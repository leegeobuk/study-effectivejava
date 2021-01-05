package chapter6.enum_practice;

public enum Payroll {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;
    Payroll(PayType payType) {
        this.payType = payType;
    }

    public PayType getPayType() {
        return payType;
    }

    int pay(int hoursWorked, int payRate) {
        return payType.pay(hoursWorked, payRate);
    }
    enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int hoursWorked, int payRate) {
                return hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) *payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int hoursWorked, int payRate) {
                return hoursWorked * payRate / 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;
        abstract int overtimePay(int hoursWorked, int payRate);
        int pay(int hoursWorked, int payRate) {
            int basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
