package com.github.davidmoten.junit;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Utility methods for unit tests.
 */
public final class Asserts {

    private Asserts() {
        // prevent instantiation
    }

    /**
     * Asserts that the given class is final, has a private constructor (which
     * it calls for coverage purposes) and that the class only has static
     * declared methods.
     * 
     * @param cls
     *            the class to assert is a Utility class
     * @throws AssertionException
     *             if one of the assertions fails
     */
    public static void assertIsUtilityClass(Class<?> cls) {
        assertFinal(cls);
        assertConstructorIsPrivateAndCall(cls);
        assertOnlyStaticMethods(cls);
    }

    /**
     * Checks that a class has a no-argument private constructor and calls that
     * constructor to instantiate the class (usually for code coverage
     * purposes).
     * 
     * @param <T>
     *            type of class being checked
     * @param cls
     *            class being checked
     */
    static void assertConstructorIsPrivateAndCall(Class<?> cls) {
        Constructor<?> constructor;
        try {
            constructor = cls.getDeclaredConstructor();
        } catch (NoSuchMethodException e1) {
            throw new RuntimeException(e1);
        } catch (SecurityException e1) {
            throw new RuntimeException(e1);
        }
        assertTrue("constructor is not private", Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    static void assertFinal(Class<?> cls) {
        assertTrue("class is not final", Modifier.isFinal(cls.getModifiers()));
    }

    static void assertOnlyStaticMethods(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers()))
                throw new AssertionError("method is not static: " + method.getName());
        }
    }

}