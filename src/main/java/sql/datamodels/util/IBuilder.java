package sql.datamodels.util;

public interface IBuilder<T> {
    T getResult();

    void reset();
}
