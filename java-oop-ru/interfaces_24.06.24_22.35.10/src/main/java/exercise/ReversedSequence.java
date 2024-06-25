package exercise;

// BEGIN

import java.util.stream.IntStream;

class ReversedSequence implements  CharSequence{
    String str;


    public ReversedSequence(String str) {
         this.str = str;
    }

    @Override
    public String toString() {
        return new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        String revers = new StringBuilder(str).reverse().toString();
        return revers.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String revers = new StringBuilder(str).reverse().toString();
        return revers.substring(start, end);
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
}
// END
