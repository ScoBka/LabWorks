package LW_4;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Comments {
    String text;
    String txt;

    public void readFile() throws IOException {
        FileInputStream inFile = new FileInputStream("D:\\Projects\\Lab1\\src\\LW_4\\textWithComment.java");
        byte[] tempStr = new byte[inFile.available()];
        inFile.read(tempStr);
        text = new String(tempStr);
        inFile.close();
    }

    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter("D:\\Projects\\Lab1\\src\\LW_4\\textWithoutComments.txt");
        fw.write(txt);
        fw.close();
    }

    public String deleteComments () {
        txt = "";
        boolean fl;
        for (int i = 0; i < text.toCharArray().length; i++) {
            if ((text.charAt(i) == '/') && (text.charAt(i + 1) == '/')) {
                while (!(text.charAt(i) == '\n')) {
                    i++;
                }
            }
            if (text.charAt(i) == '(' && text.charAt(i + 1) == '"') {
                while (!(text.charAt(i) == '"' && text.charAt(i + 1) == ')')) {
                    txt += text.charAt(i);
                    i++;
                }
            }
            if (text.charAt(i) == '/' && text.charAt(i + 1) == '*') {
                fl = true;
                while (fl) {
                    i++;
                    if (i == text.length()){
                        return txt;
                    }
                    if (text.charAt(i) == '*' && text.charAt(i + 1) == '/') {
                        i = i + 2;
                        fl = false;
                    }
                }
            }
            txt += text.charAt(i);
        }
        return txt;
    }
}
