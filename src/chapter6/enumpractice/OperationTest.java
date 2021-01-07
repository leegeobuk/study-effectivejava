package chapter6.enumpractice;

public class OperationTest {
    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        for (BasicOperation bop: BasicOperation.values()) {
            System.out.printf("%f %s %f = %f%n", x, bop, y, bop.apply(x, y));
        }
        for (AdvancedOperation aop: AdvancedOperation.values()) {
            System.out.printf("%f %s %f = %f%n", x, aop, y, aop.apply(x, y));
        }
        System.out.println(BasicOperation.valueOf("PLUS"));
        System.out.println(AdvancedOperation.valueOf("EXP"));
        System.out.println(AdvancedOperation.valueOf("REMAINDER"));
    }
}
