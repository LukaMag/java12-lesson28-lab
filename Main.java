package CLASSWORK28LAB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }
    static void run(){
        Random rnd = new Random();


        final List<Product> products = new ArrayList<>();
        products.add(new Product("Meat",150,ProductState.A,10));
        products.add(new Product("Dried fruit",100,ProductState.A,20));
        products.add(new Product("Grain",30,ProductState.A,35));
        products.add(new Product("Powder",20,ProductState.A,30));
        products.add(new Product("Fabric",300,ProductState.A,25));
        products.add(new Product("Painting",150,ProductState.A,10));
        Map<Integer,Product> productsMap = new HashMap<>();
        for(int i = 0; i < products.size();i++){
            productsMap.put(i,products.get(i));
        }
        int rndCity = rnd.nextInt(6) + 1;
        int rndDistance = rnd.nextInt(51) + 50;
        Map<Integer,City> cityMap = new HashMap<>();
        cityMap.put(1,City.MOSCOW);
        cityMap.put(2,City.ALMATA);
        cityMap.put(3,City.BISHKEK);
        cityMap.put(4,City.OSH);
        cityMap.put(5,City.TASHKENT);
        cityMap.put(6,City.DUSHANBE);
        Map<Integer,Event> eventsMap = new HashMap<>();
        eventsMap.put(1,Event.SIPMDAY);
        eventsMap.put(2,Event.RAINING);
        eventsMap.put(3,Event.STRAIGHTROAD);
        eventsMap.put(4,Event.BROKENWHEEL);
        eventsMap.put(5,Event.RIVER);
        eventsMap.put(6,Event.METSTRANGER);
        eventsMap.put(7,Event.ROBBERS);
        eventsMap.put(8,Event.INN);
        eventsMap.put(9,Event.DEPRAVED);

        City city = cityMap.get(rndCity);
        city.setDistance(rndDistance);
        int diff = 2000;
        int cash = rnd.nextInt(3000);
        cash += diff;
        Merchant merchant = new Merchant(400,cash,3,new ArrayList<Product>(), new ArrayList<Event>());
        action(productsMap,merchant,city,eventsMap);

    }
    static void action(Map<Integer,Product> productsMap,Merchant merchant,City city,Map<Integer,Event> eventsMap){
        Random rnd = new Random();
        double merchantCapital = 0;
        int d = 0;
        System.out.println("Merchant's cash " + merchant.getCash());
        System.out.println("Merchant is buying:");
        while (true){
            int rndProduct = rnd.nextInt(6);
            Product product = productsMap.get(rndProduct);
            if(merchant.getCash() > productsMap.get(rndProduct).getPrice()) {
                if(merchant.getValue() > productsMap.get(rndProduct).getValue()){
                    merchant.getProducts().add(new Product(product.getName(),product.getPrice(),product.getState(),product.getValue()));
                    merchant.setCash(merchant.getCash() - productsMap.get(rndProduct).getPrice());
                    merchant.setValue(merchant.getValue() - productsMap.get(rndProduct).getValue());
                    continue;
                }else {
                        System.out.println(String.format("Merchant's is full of products, last value is %f.Here he goes))",merchant.getValue()));
                        System.out.println(String.format("Last product that was chosen is %s, last money %f.Here he goes))",productsMap.get(rndProduct).getName(),merchant.getCash()));
                        break;
                    }
            }else{
                System.out.println(String.format("Merchant has not any money to buy a product, last money %f",merchant.getCash()));
                System.out.println(String.format("Last product that was chosen is %s.Here he goes))",productsMap.get(rndProduct).getName()));
                break;
            }
        }
        printList(merchant);
        Iterator<Product> itr = merchant.getProducts().listIterator();
        System.out.println(String.format("To get to %s, merchant has to arrive %d",city.name(),city.getDistance()));
        while (true){
            int rndEvent = rnd.nextInt(9) + 1;
            Event dailyShit = eventsMap.get(rndEvent);
            if(city.getDistance() <= 0){
                printList(merchant);
                for(int i = 0; i < merchant.getProducts().size(); i++){
                    merchantCapital += merchant.getProducts().get(i).getPrice()*merchant.getProducts().get(i).getState().getPriceCoeff();
                }
                System.out.println(String.format("Merchant has got %f",merchantCapital));
                break;
            }else {
                if (itr.hasNext()) {
                    merchant.getEventList().add(dailyShit);
                    System.out.println(dailyShit.getName());
                    merchant.setProducts(dailyShit.someShitHappens(merchant.getProducts(), merchant));
                    city.setDistance(dailyShit.distancePast(merchant, city.getDistance(),d));
                    continue;
                } else {
                    System.out.println("Merchant is broke((((");
                }
                break;
            }
        }
    }
    static void printList(Merchant merchant){
        System.out.println("Merchant's products are:");
        double price = 0;
        for(int i = 0; i < merchant.getProducts().size(); i++){
            System.out.println(String.format("%d - %s - price is: %f, grade is %s",i + 1,merchant.getProducts().get(i).getName(),merchant.getProducts().get(i).getPrice(),merchant.getProducts().get(i).getState().name()));
        }
    }





}
