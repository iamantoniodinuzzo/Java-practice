import java.util.HashSet;
import java.util.Set;

class Container {

    private final boolean offGrid;
    private float currentVolume;
    public Set<Container> net = new HashSet<Container>();

    public void setCurrentVolume(float currentVolume) {
        this.currentVolume = currentVolume;
    }

    public Container() {
        offGrid = true;
        net.add(this);
    }

    public void addWater(float lt) {
        currentVolume += lt;
    }

    public float getAmount() {
        return currentVolume;
    }


    public boolean connect(Container x) {
        net.add(x);
        x.net = net;
        spreadWater();
        return true;
    }

    private void spreadWater() {
        float count = net.size();
        float waterCount = 0;
        for (Container i:net) {
            waterCount += i.getAmount();
        }
        waterCount /= count;
        for (Container i:net) {
            i.setCurrentVolume(waterCount);
        }
    }
}