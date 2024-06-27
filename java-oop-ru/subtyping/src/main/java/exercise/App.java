package exercise;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        HashBiMap<String, String> biMap = HashBiMap.create(map);

        for (String key : map.keySet()) {
            storage.unset(key);
        }

        for (Map.Entry<String, String> entry : biMap.inverse().entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }

    }
}
// END
