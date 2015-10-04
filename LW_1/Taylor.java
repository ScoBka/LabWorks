package LW_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 9/10/2015.
 */
public class Taylor {
    private double x;
    private double k;
    private double e;
    public void inputData () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter x :");
        x = Double.parseDouble(br.readLine());
        System.out.println("Enter k :");
        do {
            k = Double.parseDouble(br.readLine());
            if (k < 0) {
                System.out.println("Wrong k !!! Try one more time. ");
            }
        } while(k < 0);
    }
    public double calcStand () {
        double res;
        res = Math.sin(x) / x;
        return res;
    }
    public double factorial (double n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public double calcTaylor () {
        int i = 0;
        double sum = 0;
        final int TEN = 10;
        double res;
        e = Math.pow(TEN, -k);
        do {
            res = (Math.pow(x, 2 * i) / factorial(2 * i + 1)) * Math.pow(-1, i);
            sum += res;
            i++;
        } while (Math.abs(res) > e);
        return sum;
    }
    public void printResult() {
        double a = calcStand();
        double b = calcTaylor();
        System.out.print("Machine's result is : ");
        System.out.printf("%.3f", a);
        System.out.println("");
        System.out.print("My result is : ");
        System.out.printf("%.3f", b);
        System.out.println("");
    }
}

