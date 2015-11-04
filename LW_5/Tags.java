package LW_5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

class Tags {
    String strTags;
    String strWords;
    public List<Integer> numStr;
    public List<String> text;
    private List<String> words;
    public List<String> txt;
    public List<String> tags;

    public Tags() {
        strTags = "";
        strWords = "";
        numStr = new ArrayList<>();
        text = new ArrayList<>();
        txt = new ArrayList<>();
        words = new ArrayList<>();
        tags = new ArrayList<>();
    }

//    public void match() {
//        Pattern DATA = Pattern.compile("<(\\w+)>");
//        Matcher matcher = DATA.matcher(strTags);
//        for (String item : text) {
//            matcher = DATA.matcher(item);
//        }
//        while (matcher.find()){
//            System.out.print(matcher.group() + " ");
//        }
//    }

    public void readFile(String fileName, List<String> list) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);
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
        final int MINUS_ONE = -1;
        String[] searchWords = txt.toString().split("[ ,\\[\\];\n]+");
        for (String item : words) {
            String[] wordsArr = item.split(" ");
            for (String item2 : wordsArr) {
                for (String item3 : searchWords) {
                    if (item2.compareToIgnoreCase(item3) == 0) {
                        System.out.println(item2 + " " + words.indexOf(item));
                    }
                }
            }
        }
    }

    public void writeFile(String fileName) throws FileNotFoundException {
        PrintStream
//        for (String item : words) {
//           System.out.println(item);
//        }
//        System.out.println();
//        for (Integer item : numStr) {
//          System.out.print(item + " ");
//        }
//        System.out.println();
//        System.out.println(words);
//        for (String item : txt) {
//            System.out.println(item);
//        }
    }
}

