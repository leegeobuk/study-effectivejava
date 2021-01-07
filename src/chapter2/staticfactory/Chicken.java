package chapter2.staticfactory;

import static chapter2.staticfactory.ChickenType.*;

public class Chicken {
    ChickenType type;

    private static final Chicken FRIED_CHICKEN = new Chicken(FRIED);

    private Chicken(ChickenType type) {
        this.type = type;
    }

    public static Chicken getFriedChicken() {
        return FRIED_CHICKEN;
    }

    public static Chicken getChicken(ChickenType type) {
        return type == FRIED ? FRIED_CHICKEN : new Chicken(type);
    }

    @Override
    public String toString() {
        String name = type.toString();
        return name.substring(0, 1) + name.substring(1).toLowerCase() + " chicken";
    }
}
