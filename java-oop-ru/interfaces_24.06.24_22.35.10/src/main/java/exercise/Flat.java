package exercise;

// BEGIN
public class Flat implements Home {
    private final double area;//— жилая площадь квартиры
    private final double balconyArea; // — площадь балкона
    private final int floor; // — этаж, на котором расположена квартира

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.area, another.getArea());
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}
// END
