package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN

        // Получаем класс Address
        Class<?> addressClass = address.getClass();

        // Получаем все методы класса Address
        Method[] methods = addressClass.getDeclaredMethods();

        // Проходим по всем методам
        for (Method method : methods) {
            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {
                // Получаем тип возвращаемого значения метода
                Class<?> returnType = method.getReturnType();
                // Выводим информацию о методе
                System.out.println("Method " + method.getName() + " returns a value of type " + returnType.getSimpleName());

            }
        }
        // END
    }
}
