public class Color {

    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    private int r, g, b;

    private Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public int getB() {
        return b;
    }
    public int getG() {
        return g;
    }
    public int getR() {
        return r;
    }

    public static Color make(int r, int g, int b) {
        Color newColor = new Color(r, g, b);

        if(newColor.equals(RED)){
            return RED;
        } else if(newColor.equals(GREEN)){
            return GREEN;
        }else if(newColor.equals(BLUE)){
            return BLUE;
        }

        return newColor;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Color)) return false;

        Color c = (Color) obj;

        return this.r == c.getR() && this.g == c.getG() && this.b == c.getB();
    }

    @Override
    public String toString() {
        if(this.equals(RED)){
            return "red";
        } else if(this.equals(GREEN)){
            return "green";
        }else if(this.equals(BLUE)){
            return "blue";
        }
        
        return "("+this.r+","+this.g+","+this.b+")";
    }
}
