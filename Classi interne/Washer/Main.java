public class Main {
    public static void main(String[] args) {
        Washer w = new Washer();
        Program p = new Program();
        p.addAction(new Program.SetTemp(30));
        p.addAction(new Program.SetSpeed(20));
        p.addAction(new Program.Wait(10));
        p.addAction(new Program.AddSoap());
        p.addAction(new Program.SetSpeed(100));
        p.addAction(new Program.Wait(10));
        p.addAction(new Program.SetSpeed(0));
        p.execute(w);
    }
}
