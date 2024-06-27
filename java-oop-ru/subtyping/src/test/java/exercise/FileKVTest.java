package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testSetAndGet() {
        // Создаем экземпляр FileKV и устанавливаем значение
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        // Проверяем, что значение может быть получено корректно
        assertEquals("value1", storage.get("key1", "default"));
    }

    @Test
    public void testUnset() {
        // Создаем экземпляр FileKV и устанавливаем значение
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        // Удаляем значение
        storage.unset("key1");
        // Проверяем, что значение было удалено корректно
        assertEquals("default", storage.get("key1", "default"));
    }

    @Test
    public void testToMap() {
        // Создаем начальные данные
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        // Создаем экземпляр FileKV с начальными данными
        KeyValueStorage storage = new FileKV(filepath.toString(), initialData);
        // Получаем карту данных
        Map<String, String> map = storage.toMap();
        // Проверяем, что карта данных корректна
        assertEquals(initialData, map);
    }
    // END
}
