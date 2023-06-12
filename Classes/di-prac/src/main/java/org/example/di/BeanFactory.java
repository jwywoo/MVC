package org.example.di;

import org.example.annotation.Controller;
import org.example.annotation.Inject;
import org.example.controller.UserController;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.example.di.BeanFactoryUtils.getInjectedConstructor;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClazz;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClazz) {
        this.preInstantiatedClazz = preInstantiatedClazz;
        initialize();
    }

    private void initialize() {
        for (Class<?> clazz : preInstantiatedClazz) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) {
        // Constructor
        Constructor<?> constructor = findConstructor(clazz);

        // Parameters
        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass : constructor.getParameterTypes()) {
            // getting instance of typeClass and put it inside of parameters
            parameters.add(getParameterByClass(typeClass));
        }

        // Creating instance
        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor<?> findConstructor(Class<?> clazz) {
        // Bring all constructors with withAnnotation Inject
        Constructor<?> constructor = getInjectedConstructor(clazz);

        if (Objects.nonNull(constructor)) {
            return constructor;
        }
        return clazz.getConstructors()[0];
    }

    private Object getParameterByClass(Class<?> typeClass) {
        Object instanceBean = getBean(typeClass);

        if (Objects.nonNull(instanceBean)) {
            return instanceBean;
        }

        return createInstance(typeClass);
    }

    public <T> T getBean(Class<T> requestedType) {
        return (T) beans.get(requestedType);
    }
}
