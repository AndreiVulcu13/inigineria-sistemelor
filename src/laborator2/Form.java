package laborator2;

// Clasa de bază laborator2.Form cu contor static
public class Form {
    private String color;
    private static int counter = 0;

    public Form() {
        this.color = "white";
        counter++;
    }

    public Form(String color) {
        this.color = color;
        counter++;
    }

    public float getArea() {
        return 0;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "This form has the color " + color;
    }
}

// Clasa laborator2.Triangle derivată din laborator2.Form
class Triangle extends Form {
    private float height;
    private float base;

    public Triangle(float height, float base, String color) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", laborator2.Triangle with base " + base + " and height " + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triangle triangle = (Triangle) obj;
        return Float.compare(triangle.height, height) == 0 &&
                Float.compare(triangle.base, base) == 0;
    }
}

// Clasa laborator2.Circle derivată din laborator2.Form
class Circle extends Form {
    private float radius;

    public Circle(float radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + ", laborator2.Circle with radius " + radius;
    }
}

// Clasa laborator2.Square derivată din laborator2.Form
class Square extends Form {
    private float side;

    public Square(float side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public float getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return super.toString() + ", laborator2.Square with side " + side;
    }
}

// Clasa laborator2.Application pentru testare
class Application {
    public static void main(String[] args) {
        System.out.println("-- Forme Geometrice --");
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total forms created: " + Form.getCounter());
    }
}