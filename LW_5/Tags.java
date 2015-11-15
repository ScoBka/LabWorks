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

    public void readHtmlFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(fileName));
        sc.useDelimiter("[ \t]+");
        while(sc.hasNextLine()) {
            tempStrBuilder.append(sc.nextLine());
            tempStrBuilder.append("\n");
        }

        sc.close();
    }

    public void readSearchWordsFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(fileName));
        while(sc.hasNextLine()) {
            searchWordsList.add(sc.nextLine());
        }
        sc.close();
    }

    public void searchTags () {
        StringBuilder strTags = new StringBuilder();
        for (int i = 0; i < tempStrBuilder.length() - 1; i++) {
            i = tempStrBuilder.indexOf("<");
            strTags.append(tempStrBuilder.substring(i, tempStrBuilder.indexOf(">") + 1));
            tempStrBuilder.delete(i, tempStrBuilder.indexOf(">") + 1);
            tags.add(strTags.toString());
            strTags.delete(0, strTags.length());
        }
    }

    public void sortTags() {
        Collections.sort(tags, new Comp());
    }

    private int searchLineNumberWord (String fragment){
        fragment = fragment.toLowerCase();
        int index = tempStrBuilder.toString().toLowerCase().indexOf(fragment);
        int line = 0;
        for(int i = 0; i < index; i++){
            if(tempStrBuilder.toString().charAt(i) == '\n'){
                line++;
            }
        }
        return line;
    }

    private void deleteFoundWord (String fragment) {
        String str = tempStrBuilder.toString().replace(fragment, "");
        tempStrBuilder.delete(0, tempStrBuilder.length());
        tempStrBuilder.append(str);
    }

    private List<String> fillWordsList () {
        List<String> wordsList = new ArrayList<>();
        String[] wordsArr = tempStrBuilder.toString().split("[ \n]+");
        for (String item : wordsArr) {
            wordsList.add(item.toLowerCase());
        }
        return wordsList;
    }

    private String[] fillSearchWordsArr () {
        StringBuilder sb = new StringBuilder();
        for (String item : searchWordsList) {
            sb.append(item);
            sb.append(" ");
        }
        String[] wordsArr = sb.toString().split("[ ;,\n]+");
        return wordsArr;
    }

    public void checkWords() {
        String[] searchWordsArr = fillSearchWordsArr();
        for (String item : searchWordsArr) {
            if (!fillWordsList().contains(item.toLowerCase())) {
                wordsNumStr.put(item, -1);
            }
            else {
                wordsNumStr.put(item, searchLineNumberWord(item));
                deleteFoundWord(item);
            }
        }
    }

    public void writeFile(String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(new File(fileName));
        for (String item : tags) {
            pw.println(item);
        }
        pw.close();
    }

    public void writeFoundWordsFile (String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        for (Map.Entry entry: wordsNumStr.entrySet()) {
            pw.println("Word : " + entry.getKey() + ", String number : " + entry.getValue());
        }
        pw.close();
    }

    public void writeNotFoundWordsFile (String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        for (Map.Entry entry: wordsNumStr.entrySet()) {
            if ((int)entry.getValue() == -1) {
                pw.println(entry.getKey());
            }
        }
        pw.close();
    }
}

