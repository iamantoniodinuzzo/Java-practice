import java.io.FileReader;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class WiFi implements Iterable<WiFi.Network> {
    private ArrayList<Network> networks;

    public WiFi() {
        this.networks = new ArrayList<>();
    }

    @Override
    public Iterator<Network> iterator() {
        return new Iterator<Network>() {
            int currPosition = 0;

            @Override
            public boolean hasNext() {
                return (currPosition < networks.size()) && (networks.get(currPosition + 1) != null);
            }

            @Override
            public Network next() {
                return networks.get(currPosition++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public Network addNetwork(String name, double intensity) {
        if (intensity > 0)
            throw new IllegalArgumentException();
        Network newNet = new Network(name, intensity);
        this.networks.add(newNet);

        return newNet;
    }

    public WiFi.Network strongest() {
        Collections.sort(networks);
        return networks.get(0);
    }

    public ArrayList<Network> getNetworks() {
        return networks;
    }

    public static class Network implements Comparable<Network> {
        private String name;
        private double intensity;

        private Network(String name, double intensity) {
            this.name = name;
            this.intensity = intensity;
        }

        public void updateStrength(double value) {
            if (value > 0)
                throw new IllegalArgumentException();

            this.intensity = value;
        }

        @Override
        public int compareTo(Network n) {
            if (intensity < n.intensity)
                return 1;
            else if (intensity > n.intensity)
                return -1;

            return 0;
        }

        @Override
        public String toString() {
            return name + "(" + intensity + " dBm)";
        }
    }

    public static void main(String[] args) {
        WiFi manager = new WiFi();
        WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
        WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio", -53.05);
        WiFi.Network neighbor = manager.addNetwork("Casa Esposito", -48.95);
        neighbor.updateStrength(-39.6);
        WiFi.Network x = manager.strongest();
        for (Network net : manager.getNetworks()) {
            System.out.println(net);
        }
        System.out.println("\n"+x);
    }

}