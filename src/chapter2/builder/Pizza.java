package chapter2.builder;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE, CHICKEN, MARIANARA, BASIL, MOZARELLA}
    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract String getName();

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza bake();

        protected abstract T self();
    }

    @Override
    public String toString() {
        String topping = "Toppings: ";
        Iterator<Topping> it = this.toppings.iterator();
        topping += it.hasNext() ? it.next() : null;
        while (it.hasNext()) {
            topping += ", " + it.next();
        }
        return "[" + getName() + "\n" + topping + "\n";
    }
}
