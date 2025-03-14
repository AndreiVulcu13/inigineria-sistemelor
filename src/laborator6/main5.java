package laborator6;

public class main5 {
    public static void main(String[] args) {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        int intResult = intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Integer result: " + intResult);

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double doubleResult = doubleCalc.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("Double result: " + doubleResult);
    }
}
