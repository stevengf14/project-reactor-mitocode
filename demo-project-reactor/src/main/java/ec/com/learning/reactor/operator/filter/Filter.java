package ec.com.learning.reactor.operator.filter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import reactor.core.publisher.Flux;

public class Filter {

	private static final Logger log = LoggerFactory.getLogger(Filter.class);

	public void filter() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).filter(p -> p.getAge() > 28).subscribe(p -> log.info(p.toString()));
	}

	public void distinct() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).distinct().subscribe(p -> log.info(p.toString()));
	}

	public void take() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).take(2).subscribe(p -> log.info(p.toString()));
	}
	
	public void takeLast() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).takeLast(2).subscribe(p -> log.info(p.toString()));
	}
	
	public void skip() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).skip(2).subscribe(p -> log.info(p.toString()));
	}
	
	public void skipLast() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));

		Flux.fromIterable(people).skipLast(2).subscribe(p -> log.info(p.toString()));
	}
}
