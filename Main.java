package CLASSWORK28LAB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }
    static void run(){
        Random rnd = new Random();
        Map<Integer,Product> productsMap = new HashMap<>();
        productsMap.put(1,Product.MEAT);
        productsMap.put(2,Product.DRIEDFRUIT);
        productsMap.put(3,Product.GRAIN);
        productsMap.put(4,Product.POWDER);
        productsMap.put(5,Product.FABRIC);
        productsMap.put(6,Product.PAINTING);
        int rndCity = rnd.nextInt(6) + 1;
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
        int diff = 2000;
        int cash = rnd.nextInt(3000);
        cash += diff;
        Merchant merchant = new Merchant(500,cash,3,new ArrayList<Product>(), new ArrayList<Event>());
        action(productsMap,merchant,city,eventsMap);

    }
    static void action(Map<Integer,Product> productsMap,Merchant merchant,City city,Map<Integer,Event> eventsMap){
        Random rnd = new Random();
        System.out.println("Merchant's cash " + merchant.getCash());
        System.out.println("Merchant is buying:");
        while (true){
            int rndProduct = rnd.nextInt(6) + 1;
            Product product = productsMap.get(rndProduct);
            if(merchant.getCash() > productsMap.get(rndProduct).getPrice()) {
                if(merchant.getValue() > productsMap.get(rndProduct).getValue()){
                    merchant.getProducts().add(productsMap.get(rndProduct));
                    merchant.setCash(merchant.getCash() - productsMap.get(rndProduct).getPrice());
                    merchant.setValue(merchant.getValue() - productsMap.get(rndProduct).getValue());
                    continue;
                }else {
                        System.out.println(String.format("Merchant's is full of products, last value is %f.Here he goes))",merchant.getValue()));
                        System.out.println(String.format("Last product that was chosen is %s, last money %f.Here he goes))",productsMap.get(rndProduct).name(),merchant.getCash()));
                        break;
                    }
            }else{
                System.out.println(String.format("Merchant has not any money to buy a product, last money %f",merchant.getCash()));
                System.out.println(String.format("Last product that was chosen is %s.Here he goes))",productsMap.get(rndProduct).name()));
                break;
            }
        }
        printList(merchant);

        while (true){
            int rndEvent = rnd.nextInt(9) + 1;
            Event dailyShit = eventsMap.get(rndEvent);
            merchant.getEventList().add(dailyShit);

        }
    }
    static void printList(Merchant merchant){
        System.out.println("Merchant's products are:");
        for(int i = 0; i < merchant.getProducts().size(); i++){
            System.out.println(String.format("%d - %s - price is: %f",i+1,merchant.getProducts().get(i).name(),merchant.getProducts().get(i).getPrice()));
        }
    }

    public Product productDeprave(Product product){
        if(product.getState() == ProductState.A){
            product.setState(ProductState.B);
        }

                return product;
    }
}
