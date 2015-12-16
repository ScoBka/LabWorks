package LW_5;

import java.io.*;
import java.util.*;

class Tags {
    private Map<String, Integer> wordsNumStr;
    private List<String> searchWordsList;
    private List<String> tags;
    private StringBuilder tempStrBuilder;

    public Tags() {
        tempStrBuilder = new StringBuilder();
        wordsNumStr = new HashMap<>();
        searchWordsList = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public void readHtmlFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src\\LW_5\\Files\\input1.html"));
        sc.useDelimiter("[ \t]+");
        while(sc.hasNextLine()) {
            tempStrBuilder.append(sc.nextLine());
            tempStrBuilder.append("\n");
        }
        sc.close();
    }

    public void readSearchWordsFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src\\LW_5\\Files\\input2.txt"));
        sc.useDelimiter("[;\n\r]+");
        while(sc.hasNextLine()) {
            searchWordsList.add(sc.next());
        }
        sc.close();
    }

    public void searchTags () {
        StringBuilder strTags = new StringBuilder();
        for (int i = 0; i < tempStrBuilder.length() - 1; i++) {
            i = tempStrBuilder.indexOf("<");
            if (i == -1) {
                break;
            }
            strTags.append(tempStrBuilder.substring(i, tempStrBuilder.indexOf(">") + 1));
            tempStrBuilder.delete(i, tempStrBuilder.indexOf(">") + 1);
            tags.add(strTags.toString());
            strTags.delete(0, strTags.length());
        }
    }

    public void sortTags() {
        Collections.sort(tags, new Comp());
    }

    public void check (){
        for (String item : searchWordsList) {
            int index = tempStrBuilder.toString().toLowerCase().indexOf(item.toLowerCase());
            int line = 0;
            for (int i = 0; i < index; i++) {
                if (tempStrBuilder.toString().charAt(i) == '\n') {
                    line++;
                }
            }
            if (index == -1) {
                wordsNumStr.put(item, index);
            }
            else {
                wordsNumStr.put(item, line);
                deleteFoundWord(item);
            }
        }
    }

    private void deleteFoundWord (String fragment) {
        String str = tempStrBuilder.toString().replace(fragment, "");
        tempStrBuilder.delete(0, tempStrBuilder.length());
        tempStrBuilder.append(str);
    }

    public void writeFile() throws IOException {
        PrintWriter pw = new PrintWriter(new File("src\\LW_5\\output1.txt"));
        for (String item : tags) {
            pw.println(item);
        }
        pw.close();
    }

    public void writeFoundWordsFile () throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src\\LW_5\\output2.txt"));
        for (Map.Entry entry: wordsNumStr.entrySet()) {
            pw.println("Word : " + entry.getKey() + ", String number : " + entry.getValue());
        }
        pw.close();
    }

    public void writeNotFoundWordsFile () throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src\\LW_5\\output3.txt"));
        for (Map.Entry entry: wordsNumStr.entrySet()) {
            if ((int)entry.getValue() == -1) {
                pw.println(entry.getKey());
            }
        }
        pw.close();
    }
}

