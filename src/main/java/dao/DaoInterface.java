package dao;

import java.util.List;

/**
 * CRUD method
 * @author pierre
 *
 * @param <T>
 */

public interface DaoInterface<T> {

	
	/**
	 * Read 
	 */
	
	List<T> getAll();
	T get(long id);
	
	/**
	 * Update
	 */
	
	void update(long id, T objectUpdated);
	
	/**
	 * Create
	 */
	
	void create(T newObject);
	
	/**
	 * Delete
	 */

	void delete(long id);
	
}
