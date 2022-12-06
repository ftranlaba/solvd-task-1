package lambda;

@FunctionalInterface
public interface IAssessInput<T> {
    T assess(T a);
}
