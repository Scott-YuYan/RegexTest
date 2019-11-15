package hello.regix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexText {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\s+(\\w+)\\s+(\\w*?)\\s*(\\w+)\\s+(\\d+K)");
        List<String> list = Files.readAllLines(new File("gcLog").toPath());
        list.stream().forEach(s -> {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println(matcher.group(1) + matcher.group(2) + "_"
                        + matcher.group(3) + ":" + matcher.group(4));
            }
        });
    }
}
