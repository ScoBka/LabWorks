package kr_tulay;

import java.util.*;
import java.io.*;


public class TextWork {
    private List<String> text;
    private List<Character> sortedSymb;
    private List<String> sortedWords;

    public TextWork () {
        text = new ArrayList<String>();
        sortedSymb = new ArrayList<Character>();
        sortedWords = new ArrayList<String>();
    }

    public void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        sc.close();
    }

    public void sortCodeSymb () {
        for (String item : text) {
            char[] arr = item.toCharArray();
            Arrays.sort(arr);
            for (Character ch : arr) {
                sortedSymb.add(ch);
            }
            sortedSymb.add('\n');
        }
    }

    public void sortAmountSymb() {
        Collections.sort(text, new Comp() {
            class Comp implements Comparator<String> {
                @Override
                public int compare(String a, String b) {
                    return a.length() - b.length();
                }
            }
        });
    }

    public void sortWords () {
        String[] wordsArr = new String[text.size()];
        List<String> list = new ArrayList<String>();
        for (String item : text) {
            wordsArr = item.split("[ ,.;]+");
            for (int i = 0; i < wordsArr.length; i++) {
                list.add(wordsArr[i]);
            }
            Collections.sort(list);
            for (String item1 : list) {
                sortedWords.add(item1 + " ");
            }
            sortedWords.add("\n");
            list.clear();
        }
    }
    
    public void writeOutput1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("output1.txt"));
        for (String item : text) {
            pw.println(item);
        }
        pw.close();
    }
    public void writeOutput2() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("output2.txt"));
        for (char symb : sortedSymb) {
            pw.print(symb + " ");
        }
        pw.close();
    }
    public void writeOutput3() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("output3.txt"));
        for (String item : sortedWords) {
            pw.print(item);
        }
        pw.close();
    }
}
