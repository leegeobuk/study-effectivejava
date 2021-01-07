package chapter6.enumpractice;

public class PayrollDay {
    public static void main(String[] args) {
        int hoursWorked = 8;
        int payRate = 8350;
        double total = 0;
        for (Payroll p: Payroll.values()) {
            if (p.getPayType() != Payroll.PayType.WEEKEND) {
                total += p.pay(hoursWorked, payRate);
            }
        }
        System.out.printf("Daily wage: %.0f won%n", BasicOperation.DIVIDE.apply(total, 5));
        System.out.printf("Weekly wage(MON-FRI): %.0f won%n", total);
        System.out.printf("Monthly wage(4 weeks): %.0f won%n", BasicOperation.TIMES.apply(total, 4));
    }
}
