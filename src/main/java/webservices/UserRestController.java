package webservices;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dao.DaoInterface;
import dao.UserDao;
import entities.User;

@RestController
public class UserRestController{
	
	
	private DaoInterface<User> usersList = UserDao.getInstance();
	
	@GetMapping("/users")
	public List<User> getAll() {
		return usersList.getAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable long id) {
		try {
			User user = usersList.get(id);
			return new ResponseEntity(user, HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user) {
		user.setRegisterDate(LocalDate.now());
		usersList.create(user);
		return new ResponseEntity(usersList.get(user.getId()), HttpStatus.CREATED);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> update(@RequestBody User userUpdated){
		try {
			User user = usersList.get(userUpdated.getId());
			usersList.update(user.getId(), userUpdated);
			return new ResponseEntity(user, HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
