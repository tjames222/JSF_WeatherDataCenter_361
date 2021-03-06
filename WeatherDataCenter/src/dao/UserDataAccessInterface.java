package dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserDataAccessInterface<T> extends TimDataAccessInterface<T> {
	public T get(String id);
	List<T> getAll();
	void save(T t);
	void update(String id, T t);
	void delete(T t);
}
