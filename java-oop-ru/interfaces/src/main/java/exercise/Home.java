package exercise;

// BEGIN
public interface Home {

    // — предназначен для получения общей площади объекта недвижимости.
    double getArea();

    //— Служит для сравнения двух объектов недвижимости по их площади.
    int compareTo(Home anotherhome);

}
// END
