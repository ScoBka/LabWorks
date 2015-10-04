package LW_1;//Вариант 9

/**
 * Created by user on 9/8/2015.
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Taylor c = new Taylor();
        try {
            c.inputData();
            c.calcStand();
            c.calcTaylor();
            c.printResult();
        }
        catch (IOException f) {
            f.printStackTrace();
        }
        catch (NumberFormatException g) {
            System.out.println("Wrong number format!");
        }
    }
}
