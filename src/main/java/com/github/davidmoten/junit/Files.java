package com.github.davidmoten.junit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class Files {

    private Files() {
        // prevent instantiation
    }

    public static byte[] readBytes(File file) {
        try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            return Util.read(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String readString(File file, Charset charset) {
        return new String(readBytes(file), charset);
    }

    public static String readUtf8(File file) {
        return readString(file, StandardCharsets.UTF_8);
    }

}
