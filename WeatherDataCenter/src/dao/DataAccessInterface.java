package dao;

import java.util.List;

import beans.Sensors;

public interface DataAccessInterface <T> {
	public List<Sensors> findAll();
	public T findByID(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
