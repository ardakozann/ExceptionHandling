package business.concretes;

import java.util.ArrayList;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	
	public UserManager() {
		super();
	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) throws BusinessException {
		// TODO Auto-generated method stub
		if(checkUserExistId(user) && checkUserExistEMail(user) && checkEMail(user) && checkNames(user) && checkPassword(user)) {
			System.out.println("Registration Successful.");
			this.userDao.add(user);
		}
		
	}

	@Override
	public void update(User user) throws BusinessException {
		// TODO Auto-generated method stub
		if(checkUserExistEMail(user) && checkEMail(user) && checkNames(user) && checkPassword(user) && checkUpdateId(user)) {
			System.out.println("Update Successful.");
			this.userDao.update(user);
			return;
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		System.out.println("Delete Successful.");
		this.userDao.delete(user);
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.getAll();
	}

	
	private boolean checkUserExistId(User user) throws BusinessException {
		for(int i=0; i<getAll().size(); i++) {
			if(user.getId() == getAll().get(i).getId()) {
				throw new BusinessException("This id has been already used.");
			}
		}
		return true;
	}
	
	private boolean checkUserExistEMail(User user) throws BusinessException {
		for(int i=0; i<getAll().size(); i++) {
			if(user.geteMail() == getAll().get(i).geteMail()) {
				throw new BusinessException("This e-mail address has been already used.");
			}
		}
		return true;
	}
	
	private boolean checkEMail(User user) throws BusinessException {
		if(!user.geteMail().contains("@")) {
			throw new BusinessException("E-mail must be contain '@'");
		}
		return true;
	}
	
	private boolean checkNames(User user) throws BusinessException {
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			throw new BusinessException("First name and last name must be more than 2 digits.");
		}
		return true;
	}
	
	private boolean checkPassword(User user) throws BusinessException {
		if(user.getPassword().length()<6) {
			throw new BusinessException("Password must be more than 6 digits.");
		}
		return true;
	}
	
	private boolean checkUpdateId(User user) throws BusinessException {
		for(User users : this.userDao.getAll()) {
			if(users.getId() == user.getId()) {
				return true;
			}
		}
		throw new BusinessException("User that be updated couldn't find.");
	}
}
