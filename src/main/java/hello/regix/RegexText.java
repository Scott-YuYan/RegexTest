package hello.regix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexText {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\d+-\\d+-\\d+\\s(?:\\d+:){2}\\d+.(\\d+)");
        List<String> list = Files.readAllLines(new File("springBootLog").toPath());
        list.stream().forEach(s -> {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()){
                System.out.println(matcher.group(1));
            }
        });


    }
}
