package lambda;

@FunctionalInterface
public interface IGrow<T> {
    T grow(T a);
}
