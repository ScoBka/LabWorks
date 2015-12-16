package LW_7;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Companies {

    private List<Company> companies;

    public Companies() {
        companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public List<Company> searchShortTitle (String shortTitle) {
        List<Company> list = new ArrayList<>();
        for (Company item : companies) {
            if(item.getShortTitle().toLowerCase().equals(shortTitle.toLowerCase())) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchBranch (String branch) {
        List<Company> list = new ArrayList<>();
        for (Company item : companies) {
            if(item.getBranch().toLowerCase().equals(branch.toLowerCase())) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchActivity (String activity) {
        List<Company> list = new ArrayList<>();
        for (Company item : companies) {
            if(item.getActivity().toLowerCase().equals(activity.toLowerCase())) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchDateFoundation (Date minDate, Date maxDate) {
        List<Company> list = new ArrayList<>();
        for (Company item : companies) {
            if(minDate.before(item.getDateFoundation()) && maxDate.after(item.getDateFoundation())) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchAmountEmployees (int minAmountEmp, int maxAmountEmp) {
        List<Company> list = new ArrayList<>();
        for (Company item : companies) {
            if(item.getCountEmployees() > minAmountEmp && item.getCountEmployees() < maxAmountEmp) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
