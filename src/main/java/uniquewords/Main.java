package uniquewords;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        String input = "src/main/java/uniquewords/sampleinput.txt";
        String output = "src/main/java/uniquewords/output.txt";
        File file = new File(input);
        try {
            List<String> list = FileUtils.readLines(file, "UTF-8");
            int uniqueWords = uniqueWordCount(list, ' ');
            LOGGER.info("Unique word count is " + uniqueWords);
            FileUtils.write(new File(output), "Unique word count is " + uniqueWords, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("BAD FILE");
        }
    }

    public static int uniqueWordCount(List<String> list, char delimiter) {
        Map<String, Boolean> map = new HashMap<>();
        for (String line : list) {
            line = StringUtils.lowerCase(line);
            String word = "";
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != delimiter && Character.isAlphabetic(line.charAt(i))) {
                    word += line.charAt(i);
                } else {
                    if (!map.containsKey(word)) {
                        map.put(word, true);
                    }
                    word = "";
                }
            }
        }
        return map.size();
    }
}
