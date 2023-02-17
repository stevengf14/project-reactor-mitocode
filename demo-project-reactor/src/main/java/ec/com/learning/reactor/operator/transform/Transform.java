package ec.com.learning.reactor.operator.transform;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transform {

	private static final Logger log = LoggerFactory.getLogger(Transform.class);

	public void map() {
		/*
		 * List<Person> people = new ArrayList<>(); people.add(new Person(1, "Steven",
		 * 28)); people.add(new Person(2, "Andres", 29)); people.add(new Person(3,
		 * "German", 27));
		 * 
		 * Flux.fromIterable(people).map(p -> { p.setAge(p.getAge() + 10); return p;
		 * }).subscribe(p -> log.info(p.toString()));
		 */

		Flux<Integer> fx = Flux.range(0, 10);
		Flux<Integer> fx2 = fx.map(x -> x + 10);
		fx2.subscribe(x -> log.info("X: " + x));
	}

	public void flatMap() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).flatMap(p -> {
			p.setAge(p.getAge() + 10);
			return Mono.just(p);
		}).subscribe(p -> log.info(p.toString()));
	}

	public void groupBy() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(2, "Andres 2", 29));
		people.add(new Person(2, "Andres 3", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).groupBy(Person::getId).flatMap(idFlux -> idFlux.collectList())
				.subscribe(x -> log.info(x.toString()));
	}
}
