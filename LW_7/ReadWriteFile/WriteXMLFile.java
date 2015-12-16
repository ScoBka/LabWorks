package LW_7.ReadWriteFile;


import LW_6.CheckDate;
import LW_6.Company;
import LW_6.ReadWriteFile.ReadFile;

import java.text.ParseException;

public class WriteXMLFile extends ReadFile {

    private CheckDate checkDate;

    public WriteXMLFile () {
        checkDate = new CheckDate();
    }

    protected StringBuilder write(Company company) throws ParseException{
        StringBuilder sb = new StringBuilder();

        sb.append("<company>\n");
        sb.append(format("name", company.getName()));
        sb.append(format("shortTitle", company.getShortTitle()));
        sb.append(format("address", company.getAddress()));
        sb.append(format("dateFoundation", checkDate.checkDate(company.getDateFoundation())));
        sb.append(format("countEmployees", "" + company.getCountEmployees()));
        sb.append(format("auditor", company.getAuditor()));
        sb.append(format("phone", company.getPhone()));
        sb.append(format("email", company.getEmail()));
        sb.append(format("branch", company.getBranch()));
        sb.append(format("activity", company.getActivity()));
        sb.append(format("internetAddress", company.getInternetAddress()));
        sb.append("</company>\n");

        return sb;
    }

    protected StringBuilder format(String type, String text){
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append("<");
        sb.append(type);
        sb.append(">");
        sb.append(text);
        sb.append("</");
        sb.append(type);
        sb.append(">\n");
        return sb;
    }
}
