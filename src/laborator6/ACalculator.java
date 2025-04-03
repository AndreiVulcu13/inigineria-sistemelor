package laborator6;

public abstract class ACalculator<T> {
    protected T state;

    public T result() {
        return state;
    }

    public void clear() {
        this.state = null;
    }

    public abstract void init(T value);
}
