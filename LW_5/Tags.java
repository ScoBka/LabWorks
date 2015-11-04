package LW_5;

import java.io.*;
import java.util.*;

class Tags {
    private String[] searchWords;
    private String strTags;
    private String strWords;
    public List<Integer> numStr;
    public List<String> text;
    private List<String> words;
    public List<String> txt;
    public List<String> tags;
    public List<String> notFoundWords;

    public Tags() {
        strTags = "";
        strWords = "";
        numStr = new ArrayList<>();
        text = new ArrayList<>();
        txt = new ArrayList<>();
        words = new ArrayList<>();
        tags = new ArrayList<>();
        notFoundWords = new ArrayList<>();
    }

    public void readFile(String fileName, List<String> list) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(fileName));
        while(sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
    }

    public void distinguishTags() {
        for (String item : text) {
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) == '<') {
                    while (item.charAt(i) != '>') {
                        strTags += item.charAt(i);
                        i++;
                    }
                    strTags += item.charAt(i) + "\n";
                }
                else {
                    strWords += item.charAt(i);
                }
            }
            strWords += "\n";
        }
    }

    public void sortTags() {
        String[] tagsArr = strTags.split("\n");
        tags.addAll(Arrays.asList(tagsArr));
        Collections.sort(tags, new Comp());
    }

    public void findMatches() {
        words.addAll(Arrays.asList(strWords.split("\n")));
        searchWords = txt.toString().split("[ ,\\[\\];\n]+");
        for (String item : words) {
            String[] wordsArr = item.split(" ");
            for (String item2 : wordsArr) {
                for (String item3 : searchWords) {
                    if (item2.compareToIgnoreCase(item3) == 0) {
                        numStr.add(words.indexOf(item));
                    }
                }
            }
        }
    }

    public void textWork(){
        words.clear();
        String[] wordsArr = strWords.split("[ \n]+");
        for(String item : wordsArr){
            if(!item.isEmpty()) {
                words.add(item);
            }
        }
    }

    public void checkWords() {
        for (String item1 : searchWords) {
            if (!words.contains(item1)) {
                notFoundWords.add(item1);
            }
        }
    }

    public void writeFile(String fileName, List list) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        list.forEach(pw::println);
        pw.close();
    }
}

