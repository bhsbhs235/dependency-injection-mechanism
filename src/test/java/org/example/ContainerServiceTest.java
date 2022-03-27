package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ContainerServiceTest extends TestCase {

    @Test
    public void testgetObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        InjectionRepository injectionRepository = ContainerService.getObject(InjectionRepository.class);
        assertNotNull(injectionRepository);
    }

    @Test
    public void testGetInjectionService() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        InjectionService injectionService = ContainerService.getObject(InjectionService.class);
        assertNotNull(injectionService);  //injectionService가 생성된 것을 확인
        assertNotNull(injectionService.injectionRepository); // injectionService 안에 주입된 injectionRepository 도 생성된 것을 확인
    }
}