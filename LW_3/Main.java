package LW_3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Text a = new Text();
        try {
            a.inputText();
            a.printText();
            a.devideStrWords();
            a.sortLetters();
            a.printResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("No way man! Try again.");
        }
    }
}
