package ec.com.learning.reactor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.com.learning.reactor.model.Person;
import ec.com.learning.reactor.operator.combination.Combination;
import ec.com.learning.reactor.operator.creation.Creation;
import ec.com.learning.reactor.operator.filter.Filter;
import ec.com.learning.reactor.operator.transform.Transform;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoProjectReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1, "Steven", 28)).doOnNext(p -> {
			// Aditional logic
			log.info("[Reactor] Person (doOnNext): " + p.toString());
		}).subscribe(p -> log.info("[Reactor] Person: " + p.toString()));
	}

	public void rxjava3() {
		Observable.just(new Person(1, "Steven", 28)).doOnNext(p -> log.info("[RxJava3] Person: " + p.toString()))
				.subscribe(p -> log.info("[RxJava3] Person: " + p.toString()));
		;
	}

	public void mono() {
		Mono.just(new Person(1, "Steven", 28)).subscribe(p -> log.info(p.toString()));
	}

	public void flux() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));
		Flux.fromIterable(people).subscribe(p -> log.info(p.toString()));

	}

	public void fluxMono() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven", 28));
		people.add(new Person(2, "Andres", 29));
		people.add(new Person(3, "German", 27));
		Flux<Person> fx = Flux.fromIterable(people);
		fx.collectList().subscribe(list -> log.info(list.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * mono(); flux(); fluxMono();
		 */
		/*
		 * Creation app = new Creation(); app.range(); app.repeat();
		 */
		/*
		 * Transform app = new Transform(); app.map(); app.flatMap(); app.groupBy();
		 */
		/*
		 * Filter app = new Filter(); // app.filter(); // app.distinct(); // app.take();
		 * // app.takeLast(); //app.skip(); app.skipLast();
		 */

		Combination app = new Combination();
		// app.merge();
		// app.zip();
		app.zipWith();
	}

}
