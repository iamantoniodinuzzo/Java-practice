public class B{
	public static int x;
	public static A copia(B b){

		return new A();
	}
	public static int copia(B b){

		return new B();
	}
	public int g(){
		return 0;
	}

}