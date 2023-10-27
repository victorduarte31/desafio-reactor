package br.com.dio.desafioreactor;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.LongStream;

public class Question1 {

    /*
    Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados
     */
    public Flux<Long> inc(final List<Long> numbers) {
        return Flux.fromIterable(numbers)
                .map(n -> n + 1);
    }

    public static void main(String[] args) {
        var question1 = new Question1();

        var numbers = LongStream.range(0, 10)
                .boxed()
                .toList();

        var result = question1.inc(numbers);
        result.subscribe(System.out::println);
    }


}
