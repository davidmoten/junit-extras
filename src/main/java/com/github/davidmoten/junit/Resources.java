package com.github.davidmoten.junit;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class Resources {

    private Resources() {
        // prevent instantiation
    }

    public static String readUtf8(String resourcePath) {
        return readString(Resources.class, resourcePath, StandardCharsets.UTF_8);
    }

    public static String readString(Class<?> cls, String resourcePath, Charset charset) {
        return new String(Util.readBytes(cls, resourcePath), charset);
    }

    public static byte[] readBytes(String resourcePath) {
        return Util.readBytes(Resources.class, resourcePath);
    }
    
    public static byte[] readBytes(Class<?> cls, String resourcePath) {
        return  Util.readBytes(cls, resourcePath);
    }

}
