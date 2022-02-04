import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Radio implements Iterable<Radio.Channel> {
    private TreeSet<Radio.Channel> channels;
    

    public Radio() {
        this.channels = new TreeSet<>(Channel.compareByFrequency);//associamo un comparatore alla struttura treeSet
    }

    public Channel addChannel(String nome, double frequenza) {
        Channel c = new Channel(nome, frequenza);
        if (!channels.add(c))
            throw new IllegalArgumentException("Canale già presente in questa stazione radio!");
        return c;
    }

    public Channel nearest(double frequenza) {
        channels.add(new Channel(null, frequenza));
        ArrayList<Channel> list = new ArrayList<>(channels);

        int index = list.indexOf(new Channel(null, frequenza));

        // controllo in che posizione è stato inserito il nuovo canale rispettando
        // l'ordineamento
        if (index == list.size() - 1) {// è stato inserito alla fine, è il più grande e devo restituire solo il suo
                                      // precedente
            return list.get(index - 1);
        }

        if (index == 0) {// è stato inserito come primo elemento, è il più piccolo, devo restituire il
                         // suo successivo
            return list.get(index + 1);
        }

        // se mi ritrovo a svolgere queste istruzioni devono valutare
        // il canale precedente e il successivo
        Channel c1_nearest = list.get(index - 1); // prendo il precedente
        Channel c2_nearest = list.get(index + 1); // prendo il successivo

        if (c1_nearest.getFrequenza() < c2_nearest.getFrequenza())
            return c1_nearest;
        else
            return c2_nearest;

    }

    public Iterator<Channel> iterator(){
        return new Iterator<Channel>(){
            int index = 0;
            ArrayList<Channel> list = new ArrayList<>(channels);
            @Override
            public boolean hasNext(){
                return index < list.size() && list.get(index) != null ;
            }

            @Override
            public Channel next(){
                Channel c =  list.get(index);
                index++;
                return c;
            }

        };
    };

     static class Channel implements Comparable<Channel> {
        private String nome;
        private double frequenza;

        private Channel(String nome, double frequenza) {
            this.nome = nome;
            this.frequenza = frequenza;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Channel))
                return false;

            Channel c = (Channel) obj;

            return this.frequenza == c.getFrequenza();
        }

        public double getFrequenza() {
            return this.frequenza;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(this.frequenza);
        }

        public int compareTo(Channel c) {
            return Double.compare(this.frequenza, c.getFrequenza());
        }

        public static final Comparator<Channel> compareByFrequency = new Comparator<>() {
            public int compare(Channel c1, Channel c2) {
                return Double.compare(c1.getFrequenza(), c2.getFrequenza());
            }
        };

        @Override
        public String toString(){
            return this.nome + " ("+this.frequenza+")";
        }

    }

    public static void main(String[] args) {
        Radio r = new Radio();
        Radio.Channel rai1 = r.addChannel("Rai Radio Uno", 89.3);
        Radio.Channel kk = r.addChannel("Radio Kiss Kiss", 101.4);
        Radio.Channel rmc = r.addChannel("Radio Monte Carlo", 96.4);
        for (Radio.Channel c : r) {
            System.out.println(c);
        }
        System.out.println(r.nearest(98.1));
    }

}