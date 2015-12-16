package LW_6.ReadWriteFile;


import LW_6.CheckDate;
import LW_6.Company;

import java.text.ParseException;

public class WriteJSONFile extends ReadFile {

    private CheckDate checkDate;

    public WriteJSONFile () {
        checkDate = new CheckDate();
    }

    protected StringBuilder write(Company company) throws ParseException {
        StringBuilder sb = new StringBuilder("");

        sb.append("{" + "\n");
        sb.append(format("name", company.getName()) + ",\n");
        sb.append(format("shortTitle", company.getShortTitle()) + ",\n");
        sb.append(format("address", company.getAddress()) + ",\n");
        sb.append(format("dateFoundation", checkDate.checkDate(company.getDateFoundation())) + ",\n");
        sb.append(format("countEmployees", "" + company.getCountEmployees()) + ",\n");
        sb.append(format("auditor", company.getAuditor()) + ",\n");
        sb.append(format("phone", company.getPhone()) + ",\n");
        sb.append(format("email", company.getEmail()) + ",\n");
        sb.append(format("branch", company.getBranch()) + ",\n");
        sb.append(format("activity", company.getActivity()) + ",\n");
        sb.append(format("internetAddress", company.getInternetAddress()) + "\n");
        sb.append("}");

        return sb;
    }

    protected StringBuilder format (String type, String text) {
        StringBuilder sb = new StringBuilder();

        sb.append("\t");
        sb.append("\"");
        sb.append(type);
        sb.append("\": ");
        sb.append("\"");
        sb.append(text);
        sb.append("\"");

        return sb;
    }
}
