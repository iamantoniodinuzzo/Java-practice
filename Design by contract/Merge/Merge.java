import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Merge {

    /**
     * Unisce due LinkedList di pari lunghezza e dello stesso tipo alternando gli elementi.
     *
     * @param list1 la prima lista
     * @param list2 la seconda lista
     * @throws IllegalArgumentException viene lanciata quando le liste non hanno la stessa lunghezza
     */
    public static <T> LinkedList<T> merge(LinkedList<T> list1, LinkedList<T> list2) throws IllegalArgumentException {
        if (list1.size() != list2.size())
            throw new IllegalArgumentException();

        final LinkedList<T> mergedList = new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            mergedList.add(list1.get(i));
            mergedList.add(list2.get(i));
        }

        return mergedList;
    }

    public static void main(String args[]) {

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        System.out.println(merge(list1, list2));


    }


}