package HighFrequence.Summary;

import java.util.stream.Stream;

public class KeyboardRow_500 {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
        //String[]::new is a syntax sugar for the lambda expression size -> new String[size].
    }
    //input -> body
}
