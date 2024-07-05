package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static exercise.Car.unserialize;

// BEGIN
public class App {

    public static void save(Path path, Car car ) {
        String json = car.serialize();
        try {
            Files.write(path, json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Car extract(Path path2) {
        try {
            String json = Files.readString(path2);
            return unserialize(String.valueOf(json));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
