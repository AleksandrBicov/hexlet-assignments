package exercise;

public class main {
    public static void main(String[] args) {
        CharSequence text = new ReversedSequence("abcdef");
        text.toString(); // "fedcba"
        text.charAt(1); // 'e'
        text.length(); // 6
        text.subSequence(1, 4).toString(); // "edc"
    }
}
