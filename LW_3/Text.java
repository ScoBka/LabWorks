package LW_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Text {
    private StringBuilder hlpStr;
    private ArrayList<String> list;

    public void inputText() throws IOException {
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your text :");
        String text;
        do {
            text = br.readLine();
            list.add(text);
        } while (text.length() != 0);
    }

    public void printText() {
        System.out.println("Our text is : ");
        for (String str : list) {
            System.out.println(str + " ");
        }
    }
    private String listToStr(List<String> al){

        StringBuilder stringBuilder = new StringBuilder();

        for(String item : al){
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    public void divideStrWords() {
        String seps;
        String token;
        seps = (" ,.");
        StringTokenizer tokenizer = new StringTokenizer(listToStr(list), seps);
        while(tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            hlpStr.append(token);
        }
    }
    public void lettersSearch() {
        for (int i = 0; i < hlpStr.length(); i++) {
            if (hlpStr.toString()[i] != "//s | //d") {
                list.add(symbol);
                list.add(" ");
            }
        }
    }
//    public void sortLetters() {
//        Collections.sort(list, new Comparator<char[]>() {
//            public int compare(char[] o1, char[] o2) {
//                return o1.toString().compareTo(o2.toString());
//            }
//        });
//    }
    public void printResult() {
        String text = listToStr(list);
        System.out.println("The result is :");
        System.out.println(text);
    }
}
