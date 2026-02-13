//Jacob Rief
//Role D

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cipher {

    public String decipher(String cipherText, Path keyFile) throws IOException {
        //Load key file
        List<String> lines = Files.readAllLines(keyFile);

        if (lines.size() != 2) {
            throw new IllegalArgumentException("Key file must have exactly 2 lines.");
        }

        String actual = lines.get(0).trim();
        String cipher = lines.get(1).trim();

        //Validate key
        validateKey(actual, cipher);

        //Build mapping
        Map<Character, Character> mapping = buildMapping(actual, cipher);

        //Decipher text
        return decodeText(cipherText, mapping);
    }

    private void validateKey(String actual, String cipher) {
        if (actual.length() != cipher.length()) {
            throw new IllegalArgumentException("Key lines must be same length.");
        }

        Set<Character> actualSet = new HashSet<>();
        Set<Character> cipherSet = new HashSet<>();

        for (char c : actual.toCharArray()) {
            if (!actualSet.add(c)) {
                throw new IllegalArgumentException("Duplicate character in actual line: " + c);
            }
        }

        for (char c : cipher.toCharArray()) {
            if (!cipherSet.add(c)) {
                throw new IllegalArgumentException("Duplicate character in cipher line: " + c);
            }
        }
    }

    private Map<Character, Character> buildMapping(String actual, String cipher) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < actual.length(); i++) {
            map.put(cipher.charAt(i), actual.charAt(i));
        }
        return map;
    }

    private String decodeText(String text, Map<Character, Character> mapping) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (mapping.containsKey(c)) {
                result.append(mapping.get(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
