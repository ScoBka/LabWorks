package LW_5;

import java.util.Comparator;

class Comp implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}
