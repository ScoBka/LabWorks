package LW_5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tags tag = new Tags();
        try {
            tag.readFile("D:\\Projects\\Lab1\\src\\LW_5\\input1.html", tag.text);
            tag.readFile("D:\\Projects\\Lab1\\src\\LW_5\\input2.txt", tag.txt);
            tag.distinguishTags();
            tag.sortTags();
            tag.findMatches();
            tag.textWork();
            tag.checkWords();
            tag.writeFile("D:\\Projects\\Lab1\\src\\LW_5\\output1.txt", tag.tags);
            tag.writeFile("D:\\Projects\\Lab1\\src\\LW_5\\output2.txt", tag.numStr);
            tag.writeFile("D:\\Projects\\Lab1\\src\\LW_5\\output3.txt", tag.notFoundWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
