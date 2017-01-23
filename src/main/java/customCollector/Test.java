package customCollector;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by jason-geng on 1/23/17.
 * .collect(Collectors.toList()),.collect(Collectors.groupingBy()),.collect(Collectors.reducing()) 本质上调用的都是 .collect( ? implement Collectors<T,A,R>)
 *  - T 输入流的类型
 *  - A 叠加（accumulate）过程中的类型
 *  - R 输出流的类型
 *  例子: 区分自然数n中的素数与非素数
 */
public class Test {

    public static void main(String[] args) {
        int n = 10;
        //调用自定义Collector
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, n).boxed()
                .collect(new CustomCollector());

        System.out.println("-----素数-----");
        for (int i: map.get(true)) {
            System.out.println(i);
        }

        System.out.println("-----非素数-----");
        for (int i: map.get(false)) {
            System.out.println(i);
        }
    }
}
