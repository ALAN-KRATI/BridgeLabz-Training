class Meal{
    private String size;
    private String extraToppings;
    private String spiceLevel;
    private String addOns;

    public Meal(MealBuilder builder){
        this.size = builder.size;
        this.extraToppings = builder.extraToppings;
        this.spiceLevel = builder.spiceLevel;
        this.addOns = builder.addOns;
    }

    public static class MealBuilder{
            private String size;
            private String extraToppings;
            private String spiceLevel;
            private String addOns;

            public MealBuilder(String size){
                this.size = size;
            }

            public MealBuilder extraToppings(String extraToppings){
                this.extraToppings = extraToppings;
                return this;
            }

            public MealBuilder spiceLevel(String spiceLevel){
                this.spiceLevel = spiceLevel;
                return this;
            }

            public MealBuilder addOns(String addOns){
                this.addOns = addOns;
                return this;
            }

            public Meal build(){
                return new Meal(this);
            }    
    }

    public void showMeal(){
        System.out.println("Meal size: " + size);
        System.out.println("Toppings: " + extraToppings);
        System.out.println("Spice Level: " + spiceLevel);
        System.out.println("Add-ons: " + addOns);
    }
}