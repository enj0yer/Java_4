package training.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ru.kulagin.geometry.Line;
import ru.kulagin.geometry.Point;

public class Utility {
    public static List<String> fieldCollector(Object obj){
        List<String> namesOfFields = new ArrayList<>();

        List<String> finalNamesOfFields = namesOfFields;
        Arrays.stream(obj.getClass().getDeclaredFields()).forEach(el -> finalNamesOfFields.add(el.getName()));

        Class opClass = obj.getClass();

        while (opClass.getSuperclass() != null){
            opClass = opClass.getSuperclass();
            namesOfFields.addAll(Arrays.stream(opClass.getDeclaredFields())
                                        .map(Field::getName)
                                        .collect(Collectors.toList()));
            namesOfFields = namesOfFields.stream()
                                           .distinct()
                                           .collect(Collectors.toList());
        }

        return namesOfFields;
    }

    public static <T extends Point> void lineConnector(Line<T> l1, Line<T> l2) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Field f2 = l2.getClass().getDeclaredField("start");
        f2.setAccessible(true);
        Field f1 = l1.getClass().getDeclaredField("finish");
        f1.setAccessible(true);
        f2.set(l2, f1.get(l1));
    }

    public static void validate(Object obj, Class clazz) throws InvocationTargetException, IllegalAccessException, IllegalStateException, InstantiationException {

        Method[] methods = clazz.getDeclaredMethods();

        for (var method : methods){
            method.invoke(null, obj);
        }
    }
}
