package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

public class Question3 {

    /*
    Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
    (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres)
     */
    public Mono<Void> userIsValid(final User user) {
        return Mono.fromCallable(() -> {
            if (user.password().length() > 8) {
                throw new Exception("Usuário inválido");
            }
            return null;
        });
    }

    public static void main(String[] args) {
        Question3 question3 = new Question3();

        question3.userIsValid(new User(1L, "teste", "teste", "123456789", true))
                .doOnError(throwable -> {
                    if (throwable instanceof IllegalArgumentException) {
                        System.out.println("Exception lançada: " + throwable.getMessage());
                    }
                })
                .subscribe();
    }

}
