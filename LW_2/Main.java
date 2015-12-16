package LW_2;

/**
 * Created by user on 9/15/2015.
 */
public class Main {
    public static void main(String[] args) {
        int res;
        try {
            Matrix matrix = new Matrix();
            matrix.inputMatrixDim();
            matrix.fillMatrixArg();
            matrix.printMatrix();
            matrix.printResult();
        } catch (IllegalArgumentException e){
            System.out.println("Wrong parameters!");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error index array!");
        }
    }
}
