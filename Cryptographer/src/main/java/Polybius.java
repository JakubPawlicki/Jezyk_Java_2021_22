import java.util.Map;
import java.util.Set;

public class Polybius implements Algorithm {

    static final Map<Character, Integer> ALPHABET = Map.ofEntries(Map.entry('a', 11), Map.entry('b', 12),
            Map.entry('c', 13), Map.entry('d', 14), Map.entry('e', 15), Map.entry('f', 21), Map.entry('g', 22),
            Map.entry('h', 23), Map.entry('i', 24), Map.entry('k', 25), Map.entry('l', 31), Map.entry('m', 32),
            Map.entry('n', 33), Map.entry('o', 34), Map.entry('p', 35), Map.entry('q', 41), Map.entry('r', 42),
            Map.entry('s', 43), Map.entry('t', 44), Map.entry('u', 45), Map.entry('v', 51), Map.entry('w', 52),
            Map.entry('x', 53), Map.entry('y', 54), Map.entry('z', 55), Map.entry('j', 00));

    @Override
    public String crypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        String[] words = inputWord.toLowerCase().split(" ");

        for (int index = 0; index < words.length; index++) {
            for (char c : words[index].toCharArray()) {
                if (c >= 97 && c <= 122)
                    result.append(ALPHABET.get(c));
                else
                    result.append(" ");
            }
            if (index + 1 < words.length) result.append(" ");
        }
        return result.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        inputWord = inputWord.trim().replaceAll("[ ]{2,}", " ");

        if (inputWord.contains(" ")) {
            String[] inputWord2 = inputWord.split(" ");
            for (int i = 0; i < inputWord2.length; i++) {
                result.append(decrypt(inputWord2[i]));
                if (i < inputWord2.length - 1) result.append(" ");
            }
            return result.toString();
        }
        int j = 0;
        Integer[] numbers = new Integer[inputWord.length() / 2];

        for (int i = 0; i < inputWord.length(); i = i + 2) {
            numbers[j] = Integer.parseInt(inputWord.substring(i, i + 2));
            j++;
        }

        Set<Map.Entry<Character, Integer>> entrySet = ALPHABET.entrySet();

        for (
                Integer number : numbers) {
            for (Map.Entry<Character, Integer> entry : entrySet) {
                if (number.equals(entry.getValue())) {
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        return result.toString();
    }
}
