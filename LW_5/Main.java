package LW_5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tags tag = new Tags();
        try {
            tag.readHtmlFile();
            tag.readSearchWordsFile();
            tag.searchTags();
            tag.sortTags();
            tag.check();
            tag.writeFile();
            tag.writeFoundWordsFile();
            tag.writeNotFoundWordsFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
