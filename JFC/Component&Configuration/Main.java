public class Main {

    public static void main(String args[]){
        Component cpu1 = new Component(Type.CPU, "Ryzen 5 2600"),
                cpu2 = new Component(Type.CPU, "Core i5 7500"),
                board1 = new Component(Type.BOARD, "Prime X470"),
                board2 = new Component(Type.BOARD, "Prime Z370"),
                ram = new Component(Type.RAM, "DDR4 8GB");

        cpu1.setIncompatible(board2);
        board1.setIncompatible(cpu2);

        Configuration pc = new Configuration();
        System.out.println(pc.add(cpu1));
        System.out.println(pc.add(cpu2)); // due cpu!
        System.out.println(pc.add(board2)); // incompatibile !
        System.out.println(pc.add(board1));
        System.out.println(pc.add(ram));

    }
}
