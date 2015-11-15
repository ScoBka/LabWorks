package LW_5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tags tag = new Tags();
        try {
            tag.readHtmlFile("D:\\Projects\\Lab1\\src\\LW_5\\input1.html");
            tag.readSearchWordsFile("D:\\Projects\\Lab1\\src\\LW_5\\input2.txt");
            tag.searchTags();
            tag.sortTags();
            tag.checkWords();
            tag.writeFile("D:\\Projects\\Lab1\\src\\LW_5\\output1.txt");
            tag.writeFoundWordsFile("D:\\Projects\\Lab1\\src\\LW_5\\output2.txt");
            tag.writeNotFoundWordsFile("D:\\Projects\\Lab1\\src\\LW_5\\output3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
