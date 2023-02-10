package ec.com.learning.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.com.learning.reactor.model.Person;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoProjectReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1, "Steven", 28)).subscribe(p -> log.info("[Reactor] Person: " + p.toString()));
	}

	public void rxjava3() {
		Observable.just(new Person(1, "Steven", 28)).subscribe(p -> log.info("[RxJava3] Person: " + p.toString()));
		;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactor();
		rxjava3();
	}

}
