package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n ) {
        List<String> result = new ArrayList<>();

        if (apartments.isEmpty()) {
            return result;
        }

        apartments.sort(Comparator.comparingDouble(Home::getArea));
        for (int i = 0; i < n; i++) {
            result.add(apartments.get(i).toString());
        }
        return result;
    }
}
// END
