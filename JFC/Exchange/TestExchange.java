public class TestExchange {
    public static void main(String[] args) {
        Exchange borsa = new Exchange();
        borsa.setPrice("MaxiCom", 10.56);
        borsa.setPrice("MegaCorp", 18.2);
        borsa.setPrice("SuperMarket", 3.91);

        System.out.println("%t Inizio della borsa valori:");
        System.out.println(borsa);


        borsa.addLowAlert("MegaCorp", 17.5, ()->{System.out.println("Below the threshold!");});
        borsa.addHighAlert("MaxiCom", 12, ()->{System.out.println("More than 12!");});
        borsa.addHighAlert("MaxiCom", 20.5, ()->{System.out.println("More than 20.5!");});

        borsa.setPrice("MaxiCom", 12.3);//More than 12!
    }
}
