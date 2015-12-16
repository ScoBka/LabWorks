package LW_4;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Comments {
    private String text;
    private String txt;

    public void readFile() throws IOException {
        FileInputStream inFile = new FileInputStream("src\\LW_4\\textWithComment.java");
        byte[] tempStr = new byte[inFile.available()];
        inFile.read(tempStr);
        txt = new String(tempStr);
        inFile.close();
    }

    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter("src\\LW_4\\textWithoutComments.txt");
        fw.write(text);
        fw.close();
    }

    public String deleteComments () {
        text = "";
        for (int i = 0; i < txt.toCharArray().length; i++) {
            boolean test = true;
            if (txt.charAt(i) == '(' && txt.charAt(i + 1) == '"') {
                while (test) {
                    if(txt.charAt(i) == '"' && txt.charAt(i + 1) == ')') {
                        int j = 0;
                        while(txt.charAt(i - (j + 1)) == '\\') {
                            j++;
                        }
                        if(j % 2 == 0) {
                            test = false;
                        } else {
                            text += txt.charAt(i);
                            i++;
                        }
                    } else {
                        text += txt.charAt(i);
                        i++;
                    }
                }
            }
            if (txt.charAt(i) == '=') {
                while (txt.charAt(i) != ';') {
                        text += txt.charAt(i);
                        i++;
                }
            }
            if (txt.charAt(i) == '/' && txt.charAt(i + 1) == '/') {
                while (txt.charAt(i) != '\n') {
                    i++;
                }
            }
            if (txt.charAt(i) == '/' && txt.charAt(i + 1) == '*') {
                test = true;
                while (test) {
                    i++;
                    if (i == txt.length()) {
                        return text;
                    }
                    if (txt.charAt(i) == '*' && txt.charAt(i + 1) == '/') {
                        i += 2;
                        test = false;
                    }
                }
            }
            text += txt.charAt(i);
        }
        return text;
    }
}
