package LW_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Text {
    private String [] text;
    private StringBuilder hlpStr;
    private ArrayList list;
    private int amount;

    public void inputText() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write your string :");
        while(true){
            text []= br.readLine();
            amount ++;
            if(text[].length() == 0) break;
        }
    }
    public void printText () {
        for (int i = 0; i < amount; i++) {
            System.out.println("Our string is : " + text[i]);
        }
    }
    public void devideStrWords() {
        hlpStr = new StringBuilder();
        String seps;
        String token = "";
        seps = (" ,.");
        StringTokenizer tokenizer = new StringTokenizer(text, seps);
        while(tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            hlpStr.append(token);
        }
    }
    public void lettersSearch() {
        list = new ArrayList<char []>();
        char [] tempStr = hlpStr.toString().toCharArray();
        for (int i = 0; i < tempStr.length; i++) {
            if ((tempStr[i] > 'a' && tempStr[i] < 'z')||(tempStr[i] > 'A' && tempStr[i] < 'Z')) {
                list.add(tempStr[i]);
            }
        }
    }
    public void sortLetters() {
        Collections.sort(list, new Comparator<char[]>() {
            public int compare(char[] o1, char[] o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }
    public void printResult() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}
