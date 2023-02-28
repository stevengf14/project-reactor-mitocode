package ec.com.learning.reactor.operator.mathematical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import reactor.core.publisher.Flux;

public class Mathematical {

	private static final Logger log = LoggerFactory.getLogger(Mathematical.class);

	public void average() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));
		Flux.fromIterable(people).collect(Collectors.averagingLong(Person::getAge))
				.subscribe(p -> log.info(p.toString()));
	}

	public void count() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));
		Flux.fromIterable(people).count().subscribe(x -> log.info("Quantity=" + x));
	}

	public void min() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));
		Flux.fromIterable(people).collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
				.subscribe(p -> log.info(p.get().toString()));
	}

	public void sum() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));
		Flux.fromIterable(people).collect(Collectors.summingInt(Person::getAge)).subscribe(x -> log.info("Sum=" + x));
	}

	public void summarizing() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 27));
		people.add(new Person(2, "Andres", 28));
		people.add(new Person(3, "German", 29));
		Flux.fromIterable(people).collect(Collectors.summarizingInt(Person::getAge))
				.subscribe(x -> log.info("Summarizing=" + x));
	}

}
