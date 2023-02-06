package sql.datamodels.util;

public interface IPersonBuilder<Person> extends IBuilder {
    void reset();

    void buildFirstName(String s);

    void buildLastName(String s);

    void buildAddress(String s);

    void buildPhoneType(String s);

    void buildPhoneNumber(String s);

    void buildZipcode(int num);

    @Override
    Person getResult();
}
