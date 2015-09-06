package com.github.davidmoten.junit;

import org.junit.Test;

public class AssertsTest {

    @Test
    public void testFinal() {
        Asserts.assertFinal(FinalClass.class);
    }

    @Test(expected = AssertionError.class)
    public void testNonFinal() {
        Asserts.assertFinal(NonFinalClass.class);
    }

    @Test
    public void testPrivateConstructor() {
        Asserts.assertConstructorIsPrivateAndCall(PrivateConstructor.class);
    }

    @Test(expected = AssertionError.class)
    public void testNonPrivateConstructor() {
        Asserts.assertConstructorIsPrivateAndCall(NonPrivateConstructor.class);
    }

    @Test
    public void testIsUtilityClass() {
        Asserts.assertIsUtilityClass(UtilityClassExample.class);
    }

}
