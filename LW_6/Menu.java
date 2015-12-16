package LW_6;


import LW_6.ReadWriteFile.ReadFile;
import LW_6.ReadWriteFile.WriteJSONFile;
import LW_6.ReadWriteFile.WriteXMLFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Menu {
    private Companies comp;
    private Scanner sc;
    private List<Company> companyList;
    private ReadFile rf;
    private WriteJSONFile wjf;
    private WriteXMLFile wxf;
    private BufferedReader br;

    public Menu() {
        sc = new Scanner(System.in);
        comp = new Companies();
        companyList = new ArrayList<>();
        rf = new ReadFile();
        wjf = new WriteJSONFile();
        wxf = new WriteXMLFile();
        br = new BufferedReader((new InputStreamReader(System.in)));
    }

    public void menu () throws IOException, ParseException, InputMismatchException {
        rf.log("Reading from file");
        rf.readCSVFile("src\\LW_6\\Files\\input.csv", comp);
        System.out.println("Choose :");
        menuList();
        int num = sc.nextInt();
        switch (num) {
            case (1): {
                searchShortTitle();
                break;
            }
            case (2): {
                searchBranch();
                break;
            }
            case (3): {
                searchActivity();
                break;
            }
            case (4): {
                searchDataFoundation();
                break;
            }
            case (5): {
                searchAmountEmployees();
                break;
            }
            case (6): {
                rf.log("Show company list");
                companyList = comp.getCompanies();
                break;
            }
            default: {
                rf.log("Wrong menu number");
                rf.log("Exit application");
                System.out.println("Wrong number");
                return;
            }
        }
        writeFile();
    }

    private void menuList() {
        rf.log("Running menu");
        System.out.println("1.Search Short Title");
        System.out.println("2.Search Branch");
        System.out.println("3.Search Activity");
        System.out.println("4.Search Data Foundation");
        System.out.println("5.Search Amount Employees");
        System.out.println("6.Get All Companies");
    }

    private void searchShortTitle() {
        rf.log("Searching short title");
        System.out.println("Enter short title :");
        String shortTitle = sc.next();
        companyList = comp.searchShortTitle(shortTitle);
    }

    private void searchBranch() {
        rf.log("Searching branch");
        System.out.println("Enter branch :");
        String branch = sc.next();
        companyList = comp.searchBranch(branch);
    }

    private void searchActivity() {
        rf.log("Searching activity");
        System.out.println("Enter activity :");
        String activity = sc.next();
        companyList = comp.searchActivity(activity);
    }

    private void searchDataFoundation() throws IOException{
        rf.log("Searching data foundation");
        System.out.println("Enter minData (Example: 01 January 2015):");
        Date minData = new Date(br.readLine());
        System.out.println("Enter maxData :");
        Date maxData = new Date(br.readLine());
        if (minData.after(maxData)){
            System.out.println("Wrong date");
            rf.log("Wrong date");
            return;
        }
        companyList = comp.searchDateFoundation(minData, maxData);
    }

    private void searchAmountEmployees() throws NumberFormatException {
        rf.log("Searching amount employees");
        System.out.println("Enter min amount employees :");
        int minAmountEmp = sc.nextInt();
        if (minAmountEmp < 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("Enter max amount employees :");
        int maxAmountEmp = sc.nextInt();
        if (maxAmountEmp < minAmountEmp) {
            throw new IllegalArgumentException();
        }
        companyList = comp.searchAmountEmployees(minAmountEmp, maxAmountEmp);
    }

    private void writeFile() throws ParseException {
        rf.log("Writing in file");
        wjf.writeFile("src\\LW_6\\Files\\outputJSONFile.json", companyList);
        wxf.writeFile("src\\LW_6\\Files\\outputXMLFile.xml", companyList);
    }
}
