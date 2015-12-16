package kr_tulay;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TextWork tw = new TextWork();
        try {
            tw.readFile();
            tw.sortAmountSymb();
            tw.sortCodeSymb();
            tw.sortWords();
            tw.writeOutput1();
            tw.writeOutput2();
            tw.writeOutput3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
