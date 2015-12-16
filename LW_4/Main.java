package LW_4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Comments com = new Comments();
        try {
            com.readFile();
            com.deleteComments();
            com.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
