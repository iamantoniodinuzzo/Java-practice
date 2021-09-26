import java.lang.Math;

public class Triangolo {

    private double lato1, lato2, lato3;

    public Triangolo(double lato1, double lato2, double lato3) throws Exception {
        if (isTriangle(lato1, lato2, lato3)) {

            this.lato1 = lato1;
            this.lato2 = lato2;
            this.lato3 = lato3;

        } else {
            throw new Exception("Non è un triangolo!");
        }
    }

    private boolean isTriangle(double a, double b, double c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    public float getArea() {
        double alfPerimeter = (lato1 + lato2 + lato3) / 2;
        double argumentOfSqrt = alfPerimeter * ((alfPerimeter - lato1) * (alfPerimeter - lato2) * (alfPerimeter - lato3));
        return (float) Math.sqrt(argumentOfSqrt);

    }

    static class Rectangle extends Triangolo {

        public Rectangle(double cateto1, double cateto2) throws Exception {
            super(cateto1, cateto2, Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)));
        }
    }

    static class Isoscele extends Triangolo {

        public Isoscele(double base, double cateto) throws Exception {
            super(base, cateto, cateto);
        }
    }

	public static void main(String[] args) {
    	Triangolo x = null, y= null, z= null;
    	try {
			 x = new Triangolo(10,20,25);
			 y = new Triangolo.Rectangle(5,8);
			 z = new Triangolo.Isoscele(6,5);

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println(x.getArea());
		System.out.println(y.getArea());
		System.out.println(z.getArea());

	}

}