package JAVA_2021_01_12_Tenth;

public class PrintSImpleNumberTest {
    public static void main(String[] args) {
        MySeries ms = new MySeries(1, 10);

        ms.printValue();

        ms.changeRange(3, 33);
        ms.printValue();

        ms.changeRange(5, 55);
        ms.printValue(7);
    }
}
