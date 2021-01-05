package chapter2.builder;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    String getName() {
        return "Calzone";
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone bake() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Sauce: " + sauceInside + "]";
    }
}
