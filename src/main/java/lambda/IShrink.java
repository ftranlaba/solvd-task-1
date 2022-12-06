package lambda;

@FunctionalInterface
public interface IShrink<T> {
    T shrink(T a);
}
