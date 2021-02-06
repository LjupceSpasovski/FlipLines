package mk.ljupce.spasovski;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        File file = new File("exercise1.txt");
        try {
            flipLines(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private static void flipLines(File file ) throws IOException {
        Stream<String> streamOfLines = Files.lines(Paths.get(file.toURI()));
        List<String> lines = streamOfLines.collect(Collectors.toList());
        List<String> newLines = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++) {
            //int j = 0;
            if (lines.size() % 2 != 0 && lines.size() - 1 == i) {
                newLines.add(lines.get(i));
                //break;
            } else if (i % 2 == 0) {
                //j = i + 1;
                newLines.add(lines.get(i+1));
            } else {
                //j = i - 1;
                newLines.add(lines.get(i-1));
            }
        }
         newLines.forEach(line -> System.out.println(line));
    }
}
