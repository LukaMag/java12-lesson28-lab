package CLASSWORK28LAB;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
public enum Event {
     SIPMDAY("Today was a simple day ",1){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            return productsList;
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            distance -= merchant.getSpeed();
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed(),distance));
            return distance;
        }
    },
    RAINING("It's raining, speed was reduced to 2 km per hour",2){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            int chanceToDeprave = rnd.nextInt(3) + 1;
            if(chanceToDeprave < 3){
                System.out.println("Products has been save.");
                return productsList;
            }else{
                int rndProduct = rnd.nextInt(productsList.size());
                Product product = productsList.get(rndProduct);
                productsList.set(rndProduct,productDeprave(product));
            }
            return super.someShitHappens(productsList, merchant);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            distance -= merchant.getSpeed() - 2;
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed() - 2,distance));
            return distance;
        }
    },
    STRAIGHTROAD("Merchant found straight road, lucky for him ",3){
        @Override
        protected int distancePast(Merchant merchant, int distance) {
            distance -= merchant.getSpeed() + 2;
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed() + 2,distance));
            return distance;
        }

        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            return super.someShitHappens(productsList, merchant);
        }
    },
    BROKENWHEEL("Wheel broke, day was spent for free",4){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            return super.someShitHappens(productsList, merchant);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    RIVER("River has become a big problem, day was spent for free",5){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            return super.someShitHappens(productsList, merchant);
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            return super.distancePast(merchant, distance);
        }
    },
    METSTRANGER("Merchant have met aboriginal",6){
        @Override
        protected int distancePast(Merchant merchant, int distance) {
            int rndDistance = rnd.nextInt(4) + 3;
            distance -= merchant.getSpeed() + rndDistance;
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed() + rndDistance,distance));
            return distance;
        }

        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            return super.someShitHappens(productsList, merchant);
        }
    },
    ROBBERS("Merchant have met highway robbers",7){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            if(merchant.getCash() > 200){
                merchant.setCash(merchant.getCash() - 200);
                System.out.println(String.format("Merchant had to pay off with left money, last money %f",merchant.getCash()));
            }else{
                productsList.sort(Comparator.comparing(Product::getState));
                Iterator<Product> itr = productsList.listIterator();
                    if(itr.hasNext()) {
                        productsList.remove(0);
                    }else{
                        System.out.println("Merchant does not have any product");
                    }
            }
            return productsList;
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            distance -= merchant.getSpeed();
            System.out.println(String.format("Merchant has arrived %d, left distance is %d",merchant.getSpeed(),distance));
            return distance;
        }
    },
    INN("Merchant have met roadside inn",8){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            List<Product> products = productsList;
            Iterator<Product> itr = productsList.listIterator();
            int payForNight = 50;
            int payForMeal = 25;
            products.sort((Comparator.comparing(Product::getPrice).reversed()));
            if(merchant.getCash() > payForMeal+payForNight){
                if(merchant.getCash() > products.get(0).getPrice()){
                    productsList.add(productsList.get(0));
                    merchant.setCash(merchant.getCash() - products.get(0).getPrice());
                }else{
                    if(itr.hasNext()){
                        productsList.remove(0);
                    }else{
                        System.out.println("Merchant does not have any product");
                    }
                }
            }
            return productsList;
        }

        @Override
        protected int distancePast(Merchant merchant, int distance) {
            int payForNight = 50;
            int payForMeal = 25;
            if (merchant.getCash() > payForMeal + payForNight) {

            } else {
                distance -= merchant.getSpeed();
                System.out.println(String.format("Merchant has arrived %d, left distance is %d", merchant.getSpeed(), distance));

            }
            return distance;
        }
    },
    DEPRAVED("The good have deteriorated",9){
        @Override
        protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant) {
            Random rnd = new Random();
            int rndProduct = rnd.nextInt(productsList.size());
            Product product = productsList.get(rndProduct);
            product = productDeprave(product);
            productsList.set(rndProduct,product);
            System.out.println(String.format("%s has been depraved, now it has %s grade of quality",product.getName(),product.getState().name()));
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
    public final Random rnd = new Random();

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
        System.out.println(String.format("%s quality is %s now",product.getName(),product.getState()));
        return product;
    }
    protected List<Product> someShitHappens(List<Product> productsList, Merchant merchant){
       return productsList;
    }
    protected int distancePast(Merchant merchant,int distance){
        return distance;
    }
}
