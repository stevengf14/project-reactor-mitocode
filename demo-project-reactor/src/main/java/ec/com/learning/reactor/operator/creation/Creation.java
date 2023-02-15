package ec.com.learning.reactor.operator.creation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creation {

	private static final Logger log = LoggerFactory.getLogger(Creation.class);

	public void justFrom() {
		Mono.just(new Person(1, "Steven", 20));
		// Flux.fromIterable(collection);

		// RxJava
		// Observable.just(item);
	}

	public void empty() {
		Mono.empty();
		Flux.empty();
		Observable.empty();
	}

	public void range() {
		Flux.range(0, 3).doOnNext(i -> log.info("i: " + i)).subscribe();
	}

	public void repeat() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		// Flux.fromIterable(people).repeat(3).subscribe(p -> log.info(p.toString()));
		Mono.just(new Person(1, "Steven", 28)).repeat(3).subscribe(x -> log.info(x.toString()));
	}
}
