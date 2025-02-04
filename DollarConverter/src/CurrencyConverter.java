public class CurrencyConverter {
    public static double DOLLAR;
    public static double REAL;
    public static double IOF;

    public static double Converter(double DOLLAR, double REAL){
        double converted = DOLLAR * REAL;
        IOF = converted * 6 / 100;
        return DOLLAR * REAL + IOF;
    }
}
