package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage{

    private Map<String, String> dictionary;

    public InMemoryKV(Map dictionary) {
        this.dictionary = new HashMap<>(dictionary);
    }

    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
    }

    @Override
    public void unset(String key) {
        dictionary.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {

        String result = dictionary.getOrDefault(key,defaultValue);
        return result;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dictionary);
    }
}
// END
