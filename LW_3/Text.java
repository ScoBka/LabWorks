package LW_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text {
    private final int NUMB_LETTERS;
    private boolean[] resBigLetters;
    private boolean[] resSmallLetters;
    StringBuilder text;

    public Text() {
        NUMB_LETTERS = 26;
        text = new StringBuilder();
        resBigLetters = new boolean[NUMB_LETTERS];
        resSmallLetters = new boolean[NUMB_LETTERS];
        for (int i = 0; i < NUMB_LETTERS; i++) {
            resBigLetters[i] = false;
            resSmallLetters[i] = false;
        }
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your text :");
        String tmp;
        do {
            tmp = br.readLine();
            text.append(tmp);
        } while (tmp.length() > 0);
    }

    private boolean isBigLetter(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }
    private boolean isSmallLetter(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        return false;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            if (isSmallLetter(text.charAt(i))) {
                resSmallLetters[text.charAt(i) - 'a'] = true;
            }
            if (isBigLetter(text.charAt(i))) {
                resBigLetters[text.charAt(i) - 'A'] = true;
            }
        }
    }

    public void printRes() {
        for (int i = 0; i < NUMB_LETTERS; i++) {
            if (resSmallLetters[i]) {
                System.out.print((char)('a' + i) + " ");
            }
            if (resBigLetters[i]) {
                System.out.print((char)('A' + i) + " ");
            }
        }
    }
}
