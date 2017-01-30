package lazyEvalutionWithStreams;

import java.util.stream.IntStream;

/**
 * Created by jason-geng on 1/30/17.
 */
public class LazyListWithoutCompiler {

    public static IntStream members(){
        return IntStream.iterate(2, n -> n+1);
    }

    public static int head(IntStream stream){
        return stream.findFirst().getAsInt();
    }

    public static IntStream tail(IntStream stream){
        return stream.skip(1);
    }

}
