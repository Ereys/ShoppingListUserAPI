package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import entities.User;


/**
 * Local test for userDao
 * @author pierre
 *
 */


public class UserDao implements DaoInterface<User> {
	
	private static UserDao instance;
	
	private ArrayList<User> userStorage;
	
	
	/**
	 * Constructor
	 */
	
	private UserDao() {
		this.userStorage = new ArrayList<User>();
		this.userStorage.add(new User("Pierre", "pierre@gmail.com", "mdp", 1, LocalDate.now())); //test value
	};
	
	
	public static UserDao getInstance() {
		if(instance == null) instance = new UserDao();
		return instance;
	}
	
	

	@Override
	public List<User> getAll() {
		return this.userStorage;
	}

	@Override
	public User get(long id) {
		for(User user: this.userStorage) {
			if(user.getId() == id) return user;
		}
		throw new IllegalArgumentException("User " + Long.toString(id) + " not found");
	}


	@Override
	public void update(long id, User objectUpdated) {
		User user = this.get(id);
		
		if(user != null) {
			user.setUsername(objectUpdated.getUsername());
			user.setEmail(objectUpdated.getEmail());
			user.setPassword(objectUpdated.getPassword());
		}else {
			throw new IllegalArgumentException("User " + Long.toString(id) + " not found");
		}
	}

	@Override
	public void create(User newObject) {
		this.userStorage.add(newObject);
	}

	@Override
	public void delete(long id) {
		User user = this.get(id);
		
		if(user != null) {
		this.userStorage.removeIf((users) -> users.getId() == id);
		}else {
			throw new IllegalArgumentException("User " + Long.toString(id) + " not found");
		}
	}
}
