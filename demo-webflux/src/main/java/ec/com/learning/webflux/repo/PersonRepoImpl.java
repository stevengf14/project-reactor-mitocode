package ec.com.learning.webflux.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.com.learning.webflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepoImpl implements IPersonRepo {

	private static final Logger log = LoggerFactory.getLogger(PersonRepoImpl.class);

	@Override
	public Mono<Person> create(Person person) {
		log.info(person.toString());
		return Mono.just(person);
	}

	@Override
	public Mono<Person> modify(Person person) {
		log.info(person.toString());
		return Mono.just(person);
	}

	@Override
	public Flux<Person> getAll() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Steven"));
		people.add(new Person(2, "Andres"));
		people.add(new Person(3, "Nicole"));
		people.add(new Person(1, "Abigail"));
		return Flux.fromIterable(people);

	}

	@Override
	public Mono<Person> getById(Integer id) {
		return Mono.just(new Person(1, "Steven"));
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return Mono.empty();
	}

}
