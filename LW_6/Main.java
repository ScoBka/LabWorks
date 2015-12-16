package LW_6;

import LW_6.ReadWriteFile.ReadFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        Menu m = new Menu();
        try {
            ReadFile.updateFile();
            rf.log("Running application");
            m.menu();
        } catch (IOException e) {
            rf.log("thrown IOException");
            System.out.println("Error writing in file");
        } catch (ParseException f) {
            rf.log("thrown ParseException");
            System.out.println("Bad parsing");
        } catch (NumberFormatException g) {
            rf.log("thrown NumberFormatException");
            System.out.println("Wrong number format");
        } catch (IllegalArgumentException j) {
            rf.log("thrown IllegalArgumentException");
            System.out.println("Bad numbers");
        }catch (InputMismatchException k) {
            rf.log("thrown InputMismatchException");
            System.out.println("Wrong input data");
        }
        finally {
            rf.log("End application");
        }
    }
}
