public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder('F');
        String encodedText = encoder.encode("HELLO WORLD");
        System.out.println(encodedText);

        String decodedText = encoder.decode(encodedText);
        System.out.println(decodedText);

        Encoder encoder2 = new Encoder('B');
        String encodedText2 = encoder2.encode("HELLO WORLD");
        System.out.println(encodedText);

        String decodedText2 = encoder2.decode(encodedText2);
        System.out.println(decodedText2);
    }
}