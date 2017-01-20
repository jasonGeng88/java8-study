package intermediateAndTerminalOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Intermediate Operation 与 Terminal Operation 区别
 *  1. 只有当Terminal Operation执行时, 程序才真正运行
 *  2. Intermediate Operation 内部会自动优化, 例如: filter和map不是filter全部执行完再执行map,从结果看进行的优化合并
 * Created by jason-geng on 1/20/17.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list =Arrays.asList(1,2,3,4,5).stream().filter(
                d -> {
                    System.out.println("filtering " + d);
                    return d > 1;
                }
        ).map(
                d -> {
                    System.out.println("map " + d);
                    return String.valueOf(d);
                }
        ).collect(Collectors.toList());
    }
}
