package LW_3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Text a = new Text();
        try {
            a.input();
            a.check();
            a.printRes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("No way man! Try again.");
        }
    }
}
