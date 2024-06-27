package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{

    String filePath;
    private Map<String, String> dictionary;

    public FileKV(String filePath, Map<String, String> dictionary) {
        this.filePath = filePath;
        this.dictionary = new HashMap<>(dictionary);
        saveToFile();
    }


    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        dictionary.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return dictionary.getOrDefault(key,defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dictionary);
    }

    private void saveToFile() {
        String json = Utils.serialize(dictionary);
        Utils.writeFile(filePath, json);
    }

    private void loadFromFile() {
        String json = Utils.readFile(filePath);
        dictionary = Utils.unserialize(json);
    }
}
// END
