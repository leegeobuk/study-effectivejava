package chapter2.builder;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        //Required
        private final int servingSize;
        private final int servings;
        //Optional
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "Serving size: " + servingSize +
                "\nServings: " + servings +
                "\nCalories: " + calories +
                "\nFat: " + fat +
                "\nSodium: " + sodium +
                "\nCarbohydrate: " + carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts coke = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(coke);
    }
}
