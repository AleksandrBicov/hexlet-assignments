package exercise;

// BEGIN
public class Cottage implements Home {
    private final double area;    // Общая площадь коттеджа
    private final int floorCount; // количество этажей


    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.area, another.getArea());
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

}
// END
