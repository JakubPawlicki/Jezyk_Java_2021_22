public class ROT11 implements Algorithm {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public String crypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        String[] words = inputWord.split(" ");

        for (int index = 0; index < words.length; index++) {
            for (char c : words[index].toCharArray()) {
                if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                    int index2 = (ALPHABET.indexOf(c) + 11) % 62;
                    result.append(ALPHABET.charAt(index2));
                } else
                    result.append(c);
            }
            if (index + 1 < words.length) result.append(" ");
        }
        return result.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        String[] words = inputWord.split(" ");

        for (int index = 0; index < words.length; index++) {
            for (char c : words[index].toCharArray()) {
                if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                    int index2 = (ALPHABET.indexOf(c) - 11) % 62;
                    if (index2 < 0) index2 = 62 + index2;
                    result.append(ALPHABET.charAt(index2));
                } else
                    result.append(c);
            }
            if (index + 1 < words.length) result.append(" ");

        }
        return result.toString();
    }
}
