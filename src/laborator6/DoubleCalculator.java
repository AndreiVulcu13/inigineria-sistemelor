package laborator6;

public class DoubleCalculator extends ACalculator<Double> {

    public DoubleCalculator(double initial) {
        init(initial);
    }

    @Override
    public void init(Double value) {
        this.state = value;
    }

    public DoubleCalculator add(double value) {
        this.state += value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        this.state -= value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        this.state *= value;
        return this;
    }
}
