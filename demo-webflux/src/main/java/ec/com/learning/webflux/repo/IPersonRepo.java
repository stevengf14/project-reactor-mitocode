package ec.com.learning.webflux.repo;

import ec.com.learning.webflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonRepo {

	Mono<Person> create(Person person);

	Mono<Person> modify(Person person);

	Flux<Person> getAll();

	Mono<Person> getById(Integer id);

	Mono<Void> delete(Integer id);

}
