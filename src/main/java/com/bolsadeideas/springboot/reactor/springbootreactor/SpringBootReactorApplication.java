package com.bolsadeideas.springboot.reactor.springbootreactor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

/**
 * Implementamos la clase command para que sea de consola la app
 */
@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// creamos un flux (observable)(es publisher ya que hereda de esa clase)
		// cada que recibes un elemento usas doOnNext
		Flux<String> nombres = Flux.just("Andres", "Pedro", "Diego", "Juan")
				// cada que se emita un elemento lo imprimimos(doOnNext notifica que llego un
				// elemento)
				// .doOnNext(elemento -> System.out.println(elemento)); 1° forma
				.doOnNext(System.out::println); // forma simplificada haciendo referencia al metodo print(en automatico
												// pasa el argumento al print)
		// no sucede nada hasta que te subscribas al flujo
		nombres.subscribe();
	}

}
