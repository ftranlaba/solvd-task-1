package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLStatements {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")){
            Statement stmt = conn.createStatement();
            List<String> insertStatements = getSqlStatements();
            for(String s : insertStatements){
                stmt.execute(s);
            }
        }
        catch(SQLException e){
            LOGGER.error(e);
        }
    }

    public static List<String> getSqlStatements(){
        List<String> list = new ArrayList<>();
        list.addAll(getInsertStatements());
        list.addAll(getUpdateStatements());
        list.addAll(getDeleteStatements());
        list.addAll(getAlterStatements());
        list.addAll(getJoinStatements());
        list.addAll(getAggregateWithoutHaving());
        list.addAll(getAggregateWithHaving());

        return list;
    }

    public static List<String> getInsertStatements(){
        List<String> list = new ArrayList<>();
        list.add("INSERT INTO cities(name) VALUES ('Pomona')");
        list.add("INSERT INTO states(name) VALUES ('California')");
        list.add("INSERT INTO ziplocations VALUES (12345, 1, 1)");
        list.add("INSERT INTO customers(first_name, last_name, street, zipcode) VALUES ('francis', 'tran', 'streetExample', 12345)");
        list.add("INSERT INTO countries(name) VALUES ('USA')");
        list.add("INSERT INTO manufacturers(name, year) VALUES ('NIKE', 1960)");
        list.add("INSERT INTO shops(zipcode) VALUES (12345)");
        list.add("INSERT INTO employees(id_shop, first_name, last_name, address, zipcode) VALUES (1, 'kevin', 'nguyen', 'example address', 12345)");
        list.add("INSERT INTO products(id_manufacturer, name, price, amount, id_country) VALUES (1, 'TECH FLEECE', 50, 200, 1)");
        list.add("INSERT INTO orders(id_shop, id_customer, id_product, start_date, end_date) VALUES (1, 1, 1, '1000-01-01 00:00:00', '1000-01-01 00:00:00')");
        return list;
    }

    public static List<String> getUpdateStatements(){
        List<String> list = new ArrayList<>();
        list.add("UPDATE cities SET name = 'Buffalo' WHERE IDCITIES = 1");
        list.add("UPDATE states SET name = 'New York' WHERE IDSTATES = 1");
        list.add("UPDATE customers SET first_name = 'brian' WHERE id_customer = 1");
        list.add("UPDATE countries SET name = 'Canada' WHERE IDCOUNTRIES = 1");
        list.add("UPDATE manufacturers SET year = 2020 WHERE IDMANUFACTURERS = 1");
        list.add("UPDATE employees SET first_name = 'francis' WHERE id_employee = 1");
        list.add("UPDATE products SET price = 30 WHERE id_product = 1");
        list.add("UPDATE orders SET end_date = '2000-01-01 00:00:00' WHERE IDORDERS = 1");
        list.add("UPDATE customers SET last_name = 'nguyen' WHERE id_customer = 1");
        list.add("UPDATE employees SET last_name = 'bui' WHERE id_employee = 1");
        return list;
    }

    public static List<String> getDeleteStatements(){
        List<String> list = new ArrayList<>();
        list.add("DELETE FROM orders");
        list.add("DELETE FROM customers");
        list.add("DELETE FROM employees");
        list.add("DELETE FROM shops");
        list.add("DELETE FROM products");
        list.add("DELETE FROM ziplocations");
        list.add("DELETE FROM cities");
        list.add("DELETE FROM states");
        list.add("DELETE FROM countries");
        list.add("DELETE FROM manufacturers");
        return list;
    }

    public static List<String> getAlterStatements(){
        List<String> list = new ArrayList<>();
        list.add("ALTER TABLE states ADD Capital varchar(25)");
        list.add("ALTER TABLE states ADD Executive varchar(25)");
        list.add("ALTER TABLE states ADD Animal varchar(25)");
        list.add("ALTER TABLE states MODIFY COLUMN Capital varchar(3)");
        list.add("ALTER TABLE states DROP COLUMN Capital");
        return list;
    }

    public static List<String> getJoinStatements(){
        List<String> list = new ArrayList<>();
        list.add("SELECT * FROM customers\n" +
                "INNER JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer\n" +
                "INNER JOIN ziplocations ON customers.zipcode = ziplocations.zipcode\n" +
                "INNER JOIN cities ON ziplocations.IDCITIES = cities.IDCITIES\n" +
                "INNER JOIN states ON ziplocations.IDSTATES = states.IDSTATES\n" +
                "INNER JOIN orders ON customers.id_customer = orders.id_customer\n" +
                "INNER JOIN shops ON orders.IDSHOPS = shops.IDSHOPS\n" +
                "INNER JOIN employees ON shops.IDSHOPS = employees.IDSHOPS\n" +
                "INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee\n" +
                "INNER JOIN products ON orders.id_product = products.id_product\n" +
                "INNER JOIN countries ON products.IDCOUNTRIES = countries.IDCOUNTRIES\n" +
                "INNER JOIN manufacturers ON products.IDMANUFACTURERS = manufacturers.IDMANUFACTURERS");
        list.add("SELECT * FROM customers LEFT JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer");
        list.add("SELECT * FROM ziplocations RIGHT JOIN cities ON ziplocations.zipcode = cities.zipcode");
        list.add("SELECT * FROM ziplocations CROSS JOIN cities");
        list.add("SELECT * FROM products CROSS JOIN manufacturers");
        list.add("SELECT * FROM customers T1, customers T2 WHERE T1.first_name = T2.first_name AND T1.last_name <> T2.last_name");
        return list;
    }

    public static List<String> getAggregateWithoutHaving(){
        List<String> list = new ArrayList<>();
        list.add("SELECT COUNT(id_customer), first_name FROM customers GROUP BY first_name");
        list.add("SELECT COUNT(id_employee), first_name FROM employees GROUP BY first_name");
        list.add("SELECT AVG(price), AMOUNT FROM products GROUP BY price");
        list.add("SELECT SUM(id_product), name FROM products GROUP BY name");
        list.add("SELECT SUM(zipcode), first_name FROM employees GROUP BY first_name");
        list.add("SELECT MIN(phone_number), phone_type FROM customer_phonenumbers GROUP BY phone_type");
        list.add("SELECT MAX(price), name FROM products GROUP BY name");
        return list;
    }

    public static List<String> getAggregateWithHaving(){
        List<String> list = new ArrayList<>();
        list.add("SELECT COUNT(id_customer), first_name FROM customers GROUP BY first_name HAVING COUNT(id_customer) > 5");
        list.add("SELECT COUNT(id_employee), first_name FROM employees GROUP BY first_name HAVING COUNT(LASTNAME) = 1");
        list.add("SELECT AVG(price), AMOUNT FROM products GROUP BY price HAVING MAX(price) > 25");
        list.add("SELECT SUM(id_product), name FROM products GROUP BY name HAVING AVG(AMOUNT) > 10");
        list.add("SELECT SUM(zipcode), first_name FROM employees GROUP BY first_name HAVING COUNT(LASTNAME) = 1");
        list.add("SELECT MIN(phone_number), phone_type FROM customer_phonenumbers GROUP BY phone_type HAVING COUNT(phone_number) > 1");
        list.add("SELECT MAX(price), name FROM products GROUP BY name HAVING AVG(price) > 25");
        return list;
    }
}
