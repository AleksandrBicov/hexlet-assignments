package exercise;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// BEGIN
public class Validator {


    public static List<String> validate(Address address) {
        List<String> listAddress = new LinkedList<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        listAddress.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return listAddress;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> errors = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(address) == null) {
                        errors.computeIfAbsent(field.getName(), k -> new LinkedList<>()).add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {

                int minLength = field.getAnnotation(MinLength.class).minLength();

                try {
                    field.setAccessible(true);
                    Object value = field.get(address);
                    if (value instanceof String) {
                        String stringValue = (String) value;
                        if (stringValue.length() < minLength) {
                            errors.computeIfAbsent(field.getName(), k -> new LinkedList<>()).add("length less than " + minLength);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return errors;
    }
}

// END
