package core.dataAccess;

import java.util.ArrayList;

import core.entities.Entity;

public interface CrudRepository <T extends Entity>  {
	void add(T user);
	void update(T user);
	void delete(T user);
	ArrayList<T> getAll();
}
