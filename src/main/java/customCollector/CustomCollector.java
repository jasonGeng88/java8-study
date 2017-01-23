package customCollector;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * 自定义Collector
 * Created by jason-geng on 1/23/17.
 */
public class CustomCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>(){
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> acc.get(isPrime(acc.get(true), candidate))
                .add(candidate);
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) ->{
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        //取被比较参数的开方数,减小获取素数集的范围
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(i -> candidate % i == 0);
    }

    /**
     * 返回符合条件的最小素数集
     */
    public static <T> List<T> takeWhile(List<T> list, Predicate<T> p) {
        int i = 0;
        for (T item: list){
            if (!p.test(item)){
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}
