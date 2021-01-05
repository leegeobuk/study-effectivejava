package chapter4.inheritance;

import java.time.Instant;

/*
When creating a class considering inheritance in the future, the constructor of the super class
should not call a method that is overridable in subclasses. It will cause a malfunction in the future.
But in case of private, final and static methods they could be used in the constructor of the
super class since they cannot be overridden.
 */

public class Sub extends Super {
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
