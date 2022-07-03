package CLASSWORK28LAB;

import java.util.List;
import java.util.Random;

public enum Event {
    SIPMDAY("Today was a simple day ",1){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    RAINING("It's raining, speed was reduced to 30 percent",2){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    STRAIGHTROAD("Merchant found straight road, lucky for him ",3){
        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }

        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }
    },
    BROKENWHEEL("Wheel broke, day was spent for free",4){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    RIVER("River has become a big problem, day was spent for free",5){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    METSTRANGER("Merchant have met aboriginal",6){
        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }

        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }
    },
    ROBBERS("Merchant have met highway robbers",7){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            return super.someShitHappens(productsList, merchant, distance);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    INN("Merchant have met roadside inn",8){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            
            return productsList;
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    DEPRAVED("The good have deteriorated",9){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant, int distance) {
            Random rnd = new Random();
            int rndProduct = rnd.nextInt(6) + 1;
            Product product = productsList.get(rndProduct);
            product = productDeprave(product);
            productsList.get(rndProduct).setState(product.getState());
            System.out.println(String.format("%s has been depraved, now it has %s grade of quality",product.name(),product.getState().name()));
            System.out.println();
            return productsList;
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            distance -= merchant.getSpeed();
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed(),distance));
            return distance;
        }
    };

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Event(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Product productDeprave(Product product){
        if(product.getState() == ProductState.A){
            product.setState(ProductState.B);
        }else if(product.getState() == ProductState.B){
            product.setState(ProductState.C);
        }else if(product.getState() == ProductState.C) {
            product.setState(ProductState.D);
        }else if(product.getState() == ProductState.D){
            product.setState(ProductState.F);
        }else if(product.getState() == ProductState.F){
            System.out.println("It already has F grade of quality");
        }
        return product;
    }
    protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant,int distance){
       System.out.println("pizda");
       return productsList;
    }
    protected int distancePast(Merchant merchant,int distance){
        return distance;
    }
}
