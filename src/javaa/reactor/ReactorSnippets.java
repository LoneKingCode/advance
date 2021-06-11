package javaa.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 集合分割逐个调用
 *
 * @author wangzixiang
 * @date 2021/6/8
 */
public class ReactorSnippets {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    @Test
    public void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);
        fewWords.subscribe(System.out::print);
        System.out.println();
        fewWords.map(x -> x + " ").subscribe(System.out::print);
        System.out.println();
        manyWords.map(x -> x + " ").subscribe(System.out::print);
        System.out.println();
        Mono<String> singleWord = Mono.just("single word");
        singleWord.subscribe(System.out::print);
        System.out.println();
    }

    @Test
    public void findingMissingLetter() {
        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        manyLetters.subscribe(System.out::println);

        Flux.zip(Flux.just("a", "b"), Flux.just("1", "2", "3")).subscribe(System.out::println);
    }

    @Test
    public void restoringMissingLetter() {
        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        allLetters.subscribe(System.out::println);
    }

    @Test
    public void shortCircuit() {
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world")
                                .delaySubscription(Duration.ofMillis(500)));

        // 直接 subscribe 不会等待
        // 因为订阅后会立马返回主线程，然后主线程后面已经没其他代码了，所以会直接结束
        helloPauseWorld.subscribe(System.out::println);

        //通过stream去才会阻塞等待下
        helloPauseWorld.toStream().forEach(System.out::println);

//
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void blocks() {
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world")
                                .delaySubscription(Duration.ofMillis(500)));

        helloPauseWorld.toStream()
                .forEach(System.out::println);
    }

    @Test
    public void firstEmitting() {
        Mono<String> a = Mono.just("oops I'm late")
                .delaySubscription(Duration.ofMillis(1500));
        Flux<String> c = a.flatMapMany(x -> Flux.fromArray(x.split(" ")));

        Flux<String> b = Flux.just("let's get", "the party", "started")
                .delaySubscription(Duration.ofMillis(1500));

        a.subscribe(System.out::println);

        b.toIterable()
                .forEach(System.out::print);

        System.out.println();
        c.toIterable()
                .forEach(System.out::print);

        System.out.println();
    }
}
