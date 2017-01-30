package lazyEvalutionWithStreams;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by jason-geng on 1/30/17.
 */
public class LazyList {

    private Integer head;
    private Supplier<LazyList> tail;

    public LazyList(Integer head, Supplier<LazyList> tail) {
        this.head = head;
        this.tail = tail;
    }

    public LazyList tail(){
        return tail.get();
    }

    public Integer head(){
        return head;
    }

    public LazyList filter(Predicate<Integer> p){
        return p.test(head) ?
                        new LazyList(head, () -> tail().filter(p)) :
                        tail().filter(p);

    }

    public static LazyList primes(LazyList node) {
        return new LazyList(
                node.head(),
                () -> primes(
                        node.tail().filter(n -> n % node.head() != 0)
                ));
    }
}
