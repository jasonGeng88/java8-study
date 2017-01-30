package lazyEvalutionWithStreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lazyEvalutionWithStreams.LazyListWithoutCompiler.head;
import static lazyEvalutionWithStreams.LazyListWithoutCompiler.tail;

/**
 * 获取递归的方式质数（由于stream只能消费一次,如果在递归时对同一个stream进行多次terminal operation 将抛出异常, 所以需要采用延时加载的方式,配合方法传参进行处理）
 * Created by jason-geng on 1/30/17.
 */
public class Test {

    public static void main(String[] args) {
//        originalFindPrimes();

//        recursiveFindPrimesWithoutCompiler(members()).limit(5).forEach(n -> System.out.println(n));

        LazyList members = recursiveFindPrimes(2);
        LazyList node = LazyList.primes(members);
        System.out.println(node.head());
        System.out.println(node.tail().head());
        System.out.println(node.tail().tail().head());//存在重复计算


    }

    /**
     * 不用递归的方式
     */
    public static void originalFindPrimes(){
        Stream.iterate(2, n -> n + 1)
                .filter(n -> {
                    int root = (int)Math.floor(Math.sqrt((double)n));
                    return IntStream.rangeClosed(2, root).noneMatch( m -> n % m == 0);
                })
                .limit(5).forEach(n -> System.out.println(n));
    }

    /**
     * 错误的递归, stream无法多次消费
     */
    public static IntStream recursiveFindPrimesWithoutCompiler(IntStream members){
        int head = head(members);
        tail(members).filter(n-> n % head != 0);
        return IntStream.concat(IntStream.of(head), recursiveFindPrimesWithoutCompiler(tail(members).filter(n-> n % head != 0)));
    }

    /**
     * 正确的递归方式,将方法作为变量进行递归传递
     * 此方法属于延时加载, 实体变量中存储的是方法函数, 当需要时才会进行实际计算
     * 存在问题: 每次调用过程中都会生成新的实体,如果多次运行获取值,存在大量的重复计算,需要添加缓存机制,避免性能损耗
     */
    public static LazyList recursiveFindPrimes(int n){
        return new LazyList(n, () -> recursiveFindPrimes(n+1));
    }
}
