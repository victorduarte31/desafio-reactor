package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {

    /*
    Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */
    public Mono<Long> countAdmins(final List<User> users) {

        return Mono.just(users)
                .map(user -> users.stream()
                        .filter(User::isAdmin)
                        .count());

    }

    public static void main(String[] args) {
        var question2 = new Question2();

        var users = List.of(
                new User(1L, "teste", "teste", "John", true),
                new User(2L, "teste1", "teste1", "teste1", false),
                new User(3L, "teste2", "teste2", "teste2", true)
        );

        var result = question2.countAdmins(users);
        result.subscribe(System.out::println);
    }

}
