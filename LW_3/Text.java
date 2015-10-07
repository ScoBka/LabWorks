package LW_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Text {
    private StringBuilder hlpStr;
    private String[] tmpString;
    private ArrayList<String> list;

    public void inputText() throws IOException {
        hlpStr = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your text :");
        String text;
        do {
            text = br.readLine();
            hlpStr.append(text);
            hlpStr.append(" ");
        } while (text.length() != 0);
    }

    public void printText() {
        System.out.println("Our text is : ");
        System.out.println(hlpStr);
    }

    public void divideStrWords() {
        tmpString = hlpStr.toString().split("[\\s,.]+");
        System.out.println("After divide :");
        for (String tmp : tmpString) {
            System.out.print(tmp + " ");
        }
        System.out.println("");
    }

    public void lettersSearch() {
        list = new ArrayList<>();
        for (String tmp : tmpString) {
             list.add(tmp.replaceAll("[0-9,.;:{}/]", ""));
        }
        System.out.println("After string edit :");
        for (String tmp1 : list) {
            System.out.print(tmp1 + " ");
        }
        System.out.println("");
    }
    public void sortLetters() {
       Collections.sort(list);
    }
    public void printResult() {
        System.out.println("Sorted :");
        for (String tmp : list) {
            System.out.print(tmp + " ");
        }
    }
}
