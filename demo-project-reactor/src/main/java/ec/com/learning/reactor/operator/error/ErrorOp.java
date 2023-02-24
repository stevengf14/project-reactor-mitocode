package ec.com.learning.reactor.operator.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOp {

	private static final Logger log = LoggerFactory.getLogger(ErrorOp.class);

	public void retry() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).concatWith(Flux.error(new RuntimeException("An Error"))).retry(5)
				.doOnNext(x -> log.info(x.toString())).subscribe();
	}

	public void errorReturn() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).concatWith(Flux.error(new RuntimeException("An Error Return")))
				.onErrorReturn(new Person(0, "ErrorXYZ ", 99)).subscribe(x -> log.info(x.toString()));
	}

	public void errorResume() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).concatWith(Flux.error(new RuntimeException("An Error Resume")))
				.onErrorResume(e -> Mono.just(new Person(0, "ErrorXYZ ", 99))).subscribe(x -> log.info(x.toString()));
	}

	public void errorMap() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).concatWith(Flux.error(new RuntimeException("An Error Map")))
				.onErrorMap(e -> new InterruptedException(e.getMessage())).subscribe(x -> log.info(x.toString()));
	}

}
