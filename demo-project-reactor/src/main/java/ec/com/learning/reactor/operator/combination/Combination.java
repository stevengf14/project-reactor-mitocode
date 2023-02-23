package ec.com.learning.reactor.operator.combination;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.learning.reactor.model.Person;
import ec.com.learning.reactor.model.Product;
import reactor.core.publisher.Flux;

public class Combination {

	private static final Logger log = LoggerFactory.getLogger(Combination.class);

	public void merge() {
		List<Person> people1 = new ArrayList<>();
		people1.add(new Person(1, "Steven", 28));
		people1.add(new Person(2, "Andres", 29));
		people1.add(new Person(3, "German", 27));

		List<Person> people2 = new ArrayList<>();
		people2.add(new Person(5, "Sebastian", 25));
		people2.add(new Person(6, "Antonio", 21));
		people2.add(new Person(7, "Gerardo", 37));

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Xiaomi Redmi Note 11", LocalDateTime.now()));
		products.add(new Product(2, "Xiaomi Redmi Note 12 Pro", LocalDateTime.now()));

		Flux<Person> fx1 = Flux.fromIterable(people1);
		Flux<Person> fx2 = Flux.fromIterable(people2);
		Flux<Product> fx3 = Flux.fromIterable(products);

		Flux.merge(fx1, fx2, fx3).subscribe(p -> log.info(p.toString()));
	}

	public void zip() {
		List<Person> people1 = new ArrayList<>();
		people1.add(new Person(1, "Steven", 28));
		people1.add(new Person(2, "Andres", 29));
		people1.add(new Person(3, "German", 27));

		List<Person> people2 = new ArrayList<>();
		people2.add(new Person(5, "Sebastian", 25));
		people2.add(new Person(6, "Antonio", 21));
		people2.add(new Person(7, "Gerardo", 37));

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Xiaomi Redmi Note 11", LocalDateTime.now()));
		products.add(new Product(2, "Xiaomi Redmi Note 12 Pro", LocalDateTime.now()));

		Flux<Person> fx1 = Flux.fromIterable(people1);
		Flux<Person> fx2 = Flux.fromIterable(people2);
		Flux<Product> fx3 = Flux.fromIterable(products);

		// Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1,
		// p2)).subscribe(x -> log.info(x));
		Flux.zip(fx1, fx2, fx3).subscribe(x -> log.info(x.toString()));
	}

	public void zipWith() {
		List<Person> people1 = new ArrayList<>();
		people1.add(new Person(1, "Steven", 28));
		people1.add(new Person(2, "Andres", 29));
		people1.add(new Person(3, "German", 27));

		List<Person> people2 = new ArrayList<>();
		people2.add(new Person(5, "Sebastian", 25));
		people2.add(new Person(6, "Antonio", 21));
		people2.add(new Person(7, "Gerardo", 37));

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Xiaomi Redmi Note 11", LocalDateTime.now()));
		products.add(new Product(2, "Xiaomi Redmi Note 12 Pro", LocalDateTime.now()));

		Flux<Person> fx1 = Flux.fromIterable(people1);
		Flux<Person> fx2 = Flux.fromIterable(people2);
		Flux<Product> fx3 = Flux.fromIterable(products);

		fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2)).subscribe(x -> log.info(x));
		fx1.zipWith(fx3, (p1, v1) -> String.format("Flux1: %s, Flux3: %s", p1, v1)).subscribe(x -> log.info(x));
	}
}
