package laborator6;

public class NewIntCalculator extends ACalculator<Integer> {

    public NewIntCalculator(int initial) {
        init(initial);
    }

    @Override
    public void init(Integer value) {
        this.state = value;
    }

    public NewIntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public NewIntCalculator subtract(int value) {
        this.state -= value;
        return this;
    }

    public NewIntCalculator multiply(int value) {
        this.state *= value;
        return this;
    }
}
