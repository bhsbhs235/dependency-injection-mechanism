package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    //<> 제네릭 return 타입이 Object 타입이 아니라 파라미터로 넘겨주는 classType으로 return 하고 싶을때
    public static <T> T getObject(Class<T> classType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        T instance = createInstance(classType); // Service class instance를 만듦
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            if(f.getAnnotation(Injection.class) != null){ // @Injection 어노테이션이 있는 필드에 객체를 주입한다
                Object fieldInstance = null;
                try {
                    fieldInstance = createInstance(f.getType());
                    f.setAccessible(true); // private 일수도 있다
                    f.set(instance, fieldInstance); // Service instance에 Repository instance를 set해줌
                } catch (Exception e) {
                    throw new RuntimeException();
                }

            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return classType.getConstructor(null).newInstance();
    }
}
