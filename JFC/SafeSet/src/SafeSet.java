import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SafeSet<T> {
    private Set<T> set = new HashSet<>();
    private List<T> trash = new ArrayList<>();

    public boolean add(T object) {
        return set.add(object);
    }


    public boolean contains(T object) {
        return set.contains(object);
    }

    public boolean remove(T object) {
        if (trash.contains(object)) {
            trash.remove(object);
        } else {
            trash.add(object);
        }
        set.remove(object);

        return true;
    }


}