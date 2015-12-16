package LW_6.ReadWriteFile;


import LW_6.Companies;
import LW_6.Company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public void readCSVFile(String fileName, Companies companies) throws IOException, ParseException{
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            Scanner sc = new Scanner(scanner.nextLine());
            sc.useDelimiter(";");
            Company company = new Company(sc.next(), sc.next(), new Date(sc.next()), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next());
            companies.addCompany(company);
        }
        scanner.close();
    }

    public void writeFile (String fileName, List<Company> companies) throws ParseException {
        try (
            PrintStream ps = new PrintStream(new FileOutputStream(fileName));
        ) {
            if(companies.size() != 0){
                for(Company item : companies){
                    ps.println(write(item));
                }
            }
            else {
                System.out.println("Company not found");
                log("Company not found");
            }
        } catch (IOException e) {
            System.out.println("Error in writing in file");
        }
    }

    public void log(String text) {
        try (
        PrintStream ps = new PrintStream(new FileOutputStream("src\\LW_6\\Files\\Log.txt", true));
        ) {
            ps.println(text);
        } catch (IOException e) {
            System.out.println("Error in logging");
        }
    }

    public static void updateFile(){
        File file = new File("src\\LW_6\\Files\\Log.txt");
        file.delete();
    }

    protected StringBuilder write(Company company) throws ParseException {
        StringBuilder strCompany = new StringBuilder("");
        return strCompany;
    }
}
