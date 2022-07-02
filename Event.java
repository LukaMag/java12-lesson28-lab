package CLASSWORK28LAB;

import java.util.List;

public enum Event {
    SIPMDAY("Today was a simple day "){
        @Override
        protected void someShitHappens(Product product,Merchant merchant) {
            System.out.println(String.format("Today was a simple day"));
        }
    },
    RAINING("It's raining, speed was reduced to 30 percent"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    STRAIGHTROAD("Merchant found straight road, lucky for him "){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    BROKENWHEEL("Wheel broke, day was spent for free"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    RIVER("River has become a big problem, day was spent for free"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    METSTRANGER("Merchant have met aboriginal"){
        protected void someShitHappen(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    ROBBERS("Merchant have met highway robbers"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    },
    INN("Merchant have met roadside inn"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
        public void sellingOrBuying(Merchant merchant, List<Product> products){

        }
    },
    DEPRAVED("The good have deteriorated"){
        @Override
        protected void someShitHappens(Product product, Merchant merchant) {
            super.someShitHappens(product, merchant);
        }
    };

    private String name;

    Event(String name) {
        this.name = name;
    }

    protected void someShitHappens(Product product, Merchant merchant){
       System.out.println("pizda");
    }
}
