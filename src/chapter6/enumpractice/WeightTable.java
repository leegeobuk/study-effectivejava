package chapter6.enumpractice;

public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("185");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p: Planet.values()) {
            System.out.printf("%.2fkg is %fkg in %s.%n", earthWeight, p.surfaceWeight(mass), p);
        }

    }
}
