import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] morses = br.readLine().split(" ");

        Map<String, Character> translate = morseInfo();
        StringBuilder sb = new StringBuilder();
        for (String morse : morses) {
            sb.append(translate.get(morse));
        }

        System.out.println(sb);
    }

    static Map<String, Character> morseInfo() {
        Map<String, Character> morse = new HashMap<>();

        morse.put(".-", 'A');
        morse.put("-...", 'B');
        morse.put("-.-.", 'C');
        morse.put("-..", 'D');
        morse.put(".", 'E');
        morse.put("..-.", 'F');
        morse.put("--.", 'G');
        morse.put("....", 'H');
        morse.put("..", 'I');
        morse.put(".---", 'J');
        morse.put("-.-", 'K');
        morse.put(".-..", 'L');
        morse.put("--", 'M');
        morse.put("-.", 'N');
        morse.put("---", 'O');
        morse.put(".--.", 'P');
        morse.put("--.-", 'Q');
        morse.put(".-.", 'R');
        morse.put("...", 'S');
        morse.put("-", 'T');
        morse.put("..-", 'U');
        morse.put("...-", 'V');
        morse.put(".--", 'W');
        morse.put("-..-", 'X');
        morse.put("-.--", 'Y');
        morse.put("--..", 'Z');

        morse.put(".----", '1');
        morse.put("..---", '2');
        morse.put("...--", '3');
        morse.put("....-", '4');
        morse.put(".....", '5');
        morse.put("-....", '6');
        morse.put("--...", '7');
        morse.put("---..", '8');
        morse.put("----.", '9');
        morse.put("-----", '0');

        morse.put("--..--", ',');
        morse.put(".-.-.-", '.');
        morse.put("..--..", '?');
        morse.put("---...", ':');
        morse.put("-....-", '-');
        morse.put(".--.-.", '@');

        return morse;
    }
}