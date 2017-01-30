package combinator;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 连接函数,进行函数的多种组合
 * Created by jason-geng on 1/30/17.
 */
public class Test {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1);
        stream.map(repeat(3, (Integer n) -> 2*n)).forEach(n -> System.out.println(n));
    }

    public static <A> Function<A,A> repeat(int n, Function<A,A> f){
        return n == 0 ?
                x -> x :
                f.compose(repeat(n-1, f));
    }
}
