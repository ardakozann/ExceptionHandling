package dataAccess.concretes;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserHibernateDao implements UserDao{
	private ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " sign in successful.");
		this.users.add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		for(User userA : this.users) {
			if(userA.getId() == user.getId()) {
				System.out.println(user.getFirstName() + " updated successful.");
				this.users.set(users.indexOf(userA), user);
				return;
			}
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " deleted successful.");
		this.users.remove(users.indexOf(user));
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
