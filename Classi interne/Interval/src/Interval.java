import java.util.Arrays;

public class Interval {

    private double begin, end;

    public Interval(double begin, double end) {
        this.begin = begin;
        this.end = end;

    }


    @Override
    public String toString() {
        return  begin + "," + end ;
    }

    public boolean contains(double searchedValue) {
        if (getClass().equals(Open.class))
            return searchedValue > begin && searchedValue < end;
        else
            return searchedValue >= begin && searchedValue <= end;
    }


    static class Open extends Interval {

        public Open(double begin, double end) {
            super(begin, end);
        }

        @Override
        public String toString() {
            return "("+super.toString()+")";
        }


    }

    static class Closed extends Interval {

        public Closed(double begin, double end) {
            super(begin, end);
        }

        @Override
        public String toString() {
            return "[" + super.toString() + "]";
        }
    }

    public static void main(String[] args) {
        Interval i1 = new Interval.Open(5, 10.5);
        Interval i2 = new Interval.Closed(7, 20);

        System.out.println(i1.contains(5));
        System.out.println(i1);
        System.out.println(i2);
    }


}
