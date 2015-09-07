package com.github.davidmoten.junit;

public class PrivateConstructorThrows {

    private PrivateConstructorThrows() {
        throw new RuntimeException();
    }
}
