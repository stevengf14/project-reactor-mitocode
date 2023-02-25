package ec.com.learning.reactor.operator.conditional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Conditional {

	public static final Logger log = LoggerFactory.getLogger(Conditional.class);

	public void defaultIfEmpty() {
		// Mono.empty()
		// Flux.empty()
		Mono.just(new Person(1, "Steven", 30)).defaultIfEmpty(new Person(0, "DEFAULT", 99))
				.subscribe(x -> log.info(x.toString()));
	}

	public void takeUntil() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));

		Flux.fromIterable(people).takeUntil(p -> p.getAge() > 27).subscribe(x -> log.info(x.toString()));
	}

	public void timeOut() throws InterruptedException {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));

		Flux.fromIterable(people).delayElements(Duration.ofSeconds(1)).timeout(Duration.ofSeconds(2))
				.subscribe(x -> log.info(x.toString()));
		
		Thread.sleep(10000);
	}
}
