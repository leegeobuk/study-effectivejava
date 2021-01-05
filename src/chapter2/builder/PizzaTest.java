package chapter2.builder;

import static chapter2.builder.Pizza.Topping.*;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).bake();
        Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().bake();
        System.out.println(nyPizza);
        System.out.println(calzone);
    }
}
