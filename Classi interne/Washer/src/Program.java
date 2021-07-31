import java.util.ArrayList;
import java.util.List;

public class Program {

    private final List<GenericAction> actions = new ArrayList<>();

    public void addAction(GenericAction p) {
        actions.add(p);
    }

    public void execute(Washer w) {
        for (GenericAction g : actions) {
            g.execute(w);
        }
    }

    public static class SetTemp implements GenericAction {
        private final int temp;

        public SetTemp(int i) {
            temp = i;
        }

        @Override
        public void execute(Washer w) {
            w.setTemp(temp);
        }
    }

    public static class Wait implements GenericAction {
        private final int time;

        public Wait(int i) {
            time = i;
        }

        @Override
        public void execute(Washer w) {
            System.out.println("(Attendo " + time + " minuti)");
        }
    }

    public static class AddSoap implements GenericAction {

        @Override
        public void execute(Washer w) {
            w.addSoap();
        }
    }

    public static class SetSpeed implements GenericAction {
        private final int rpm;

        public SetSpeed(int i) {
            rpm = i;
        }

        @Override
        public void execute(Washer w) {
            w.setSpeed(rpm);
        }
    }


}
