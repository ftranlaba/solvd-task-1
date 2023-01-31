package sql.dao;

public interface IPersonDAO<T> extends IBaseDAO<T> {

    void deletePhone(int id);

    void updatePhone(T o, int id);

    void savePhone(T o);

}
