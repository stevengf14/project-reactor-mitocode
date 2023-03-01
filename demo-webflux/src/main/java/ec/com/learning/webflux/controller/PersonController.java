package ec.com.learning.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.learning.webflux.model.Person;
import ec.com.learning.webflux.repo.IPersonRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
public class PersonController {

	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private IPersonRepo repo;

	@GetMapping
	public Flux<Person> getAll() {
		return repo.getAll();
	}

	@GetMapping("/{id}")
	public Mono<Person> getById(@PathVariable("id") Integer id) {
		return repo.getById(id);
	}

	@PostMapping
	public Mono<Person> create(@RequestBody Person person) {
		return repo.create(person);
	}

	@PutMapping
	public Mono<Person> modify(@RequestBody Person person) {
		return repo.modify(person);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable("id") Integer id) {
		return repo.getById(id).flatMap(p -> repo.delete(p.getId()));
		// return repo.delete(id);
	}

}
