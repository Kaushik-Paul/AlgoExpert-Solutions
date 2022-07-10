package io.algoexpert.hard;

import java.util.Arrays;

public class ShortenPath {

    public static String shortenPath(String string) {
        boolean startsWithSlash = string.charAt(0) == '/';
        String[] stack = new String[string.length()];
        String[] strings = string.split("[/]");
        String[] split = Arrays.stream(strings)
                .filter(st -> st.length() > 0 && !st.equals("."))
                .toArray(st -> new String[st]);
        if (startsWithSlash) {
            stack[0] = "";
        }


        return "";
    }

    public static void main(String[] args) {
        String string = "/foo/../test/../test/../foo//bar/./baz";
        shortenPath(string);
    }
}
