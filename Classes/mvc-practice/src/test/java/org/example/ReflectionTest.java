package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @Controller print out every class with @Controller and @Service
 **/
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerSCAN() {
        Set<Class<?>> beans = getTypesAnnoatedWith(List.of(Controller.class, Service.class));
        logger.debug("beans: {}", beans);
    }

    // test method that prints out every information about class
    @Test
    void showClass() {
        Class<User> clazz = User.class;

        logger.debug(clazz.getName());

        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    /**
     * Three ways of getting information of class type instance that is loaded in the heap
     *  -> why the fuck do we need this? -> IDK no one told me
     * **/
    @Test
    void loadTest() throws ClassNotFoundException {
        // First way
        Class<User> clazz = User.class;
        // Second way
        User user = new User("something", "something");
        Class<? extends User> clazz2 = user.getClass();
        // Third way
        Class<?> clazz3 = Class.forName("org.example.model.User");

        logger.debug("clazz1: {}", clazz);
        logger.debug("clazz2: {}", clazz2);
        logger.debug("clazz3: {}", clazz3);
    }

    private static Set<Class<?>> getTypesAnnoatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
