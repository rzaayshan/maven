import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class lesson51 {
//    static class Pair<A,B>{
//        final A a;
//        final B b;
//
//        Pair(A a, B b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("Pair{a=%s, b=%s}", a, b);
//        }
//    }
//
//    static class Triple<A,B,C>{
//        final A l;
//        final B m;
//        final C r;
//
//        Triple(A l, B m, C r) {
//            this.l = l;
//            this.m = m;
//            this.r = r;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("Triple{l=%s, m=%s, r=%s}", l, m, r);
//        }
//    }
//
//    static <C,P> P fold(Iterable<C> data, P initial, BiFunction<P, C, P> f){
//        Iterator<C> it = data.iterator();
//        P acc = initial;
//        while (it.hasNext()){
//            acc=f.apply(acc,it.next());
//        }
//        return acc;
//    }
//
//    static LinkedList<Character> stoL(String s){
//        return (LinkedList<Character>) s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
//    }
//
//    static long substrCount(int n, String s) {
//        List<Character> chars = stoL(s);
//        Pair<Integer,Character> initial = new Pair<>(0,'_');
//
//
//    }
}
