package customFunctionalInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jason-geng on 1/19/17.
 */
public class ProcessFile {

    public static String processFile(BufferedReaderProcessor p) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/jason-geng/Code/research/java8-study/src/main/resources/data.txt"))){
            return p.process(br);
        }
    }

    public static String originProjectFile() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/jason-geng/Code/research/java8-study/src/main/resources/data.txt"))){
            return br.readLine() + br.readLine();
        }
    }
}
