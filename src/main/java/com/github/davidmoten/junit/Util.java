package com.github.davidmoten.junit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

final class Util {

    private Util() {
        // prevent instantiation
    }

    static byte[] read(InputStream in) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int n;
        while ((n = in.read(buffer)) != -1) {
            bytes.write(buffer, 0, n);
        }
        return bytes.toByteArray();
    }

    static byte[] readBytes(Class<?> cls, String resourcePath) {
        try (InputStream in = cls.getResourceAsStream(resourcePath)) {
            return Util.read(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
