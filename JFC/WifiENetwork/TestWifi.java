
public class TestWifi {
    public static void main(String[] args) {
        WiFi manager = new WiFi();
        WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
        WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio", -53.05);
        WiFi.Network neighbor = manager.addNetwork("Casa Esposito", -48.95);

        neighbor.updateStrength(-39.6);
        WiFi.Network x = manager.strongest();

        System.out.println(x);

        for (WiFi.Network network : manager) {
            System.out.println(network);
        }
    }
}
