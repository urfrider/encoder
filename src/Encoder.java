public class Encoder {
    private final String offsetReference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private final int referenceSize = offsetReference.length();
    private final int offset;

    public Encoder(char key){
        this.offset = this.offsetReference.indexOf(key);
    }


    public String encode(String plainText){
        String temp = "";

        for(char c: plainText.toCharArray()){
            if (c == ' ') {
                temp += c;
                continue;
            };

            int newIndex;
            if (offsetReference.indexOf(c) - offset < 0) {
                newIndex = referenceSize + offsetReference.indexOf(c) - offset;
            }else {
                newIndex = offsetReference.indexOf(c) - offset;
            }

            temp += offsetReference.charAt(newIndex);
        }
        return temp;
    }

    public String decode(String encodedText){
        String temp = "";

        for(char c: encodedText.toCharArray()){
            if (c == ' ') {
                temp += c;
                continue;
            };

            int newIndex;
            if (offsetReference.indexOf(c) + offset > referenceSize) {
                newIndex = offsetReference.indexOf(c) + offset - referenceSize;
            }else {
                newIndex = offsetReference.indexOf(c) + offset;
            }

            temp += offsetReference.charAt(newIndex);
        }

        return temp;
    }

}
