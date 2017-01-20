package customFunctionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by jason-geng on 1/19/17.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
