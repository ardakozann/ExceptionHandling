import business.concretes.BusinessException;
import business.concretes.UserManager;
import dataAccess.concretes.UserHibernateDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Comment i�aretleri eklenerek farkl� durumlar kontrol edilebilir.
		
		UserManager userManager = new UserManager(new UserHibernateDao());
		User user1 = new User(1,"Arda","Kozan","ardakozan@gmail.com","12345677");
		User user2 = new User(2,"Mert","Y�lmaz","ardakozan@gmail.com","12345677");//ayn� mail adresi y�z�nden kay�t olmayacak.
		User user3 = new User(1,"Mehmet","Y�ld�z","mehmetyildiz@gmail.com","12345677");//ayn� id y�z�nden kay�t olmayacak.
		User user4 = new User(3,"Ali","Yaz�c�","aliyazicigmail.com","12345677");//hatal� mail adresi y�z�nden kay�t olmayacak.
		User user5 = new User(4,"Aaaa","Bbbbb","aaaabbbbb@gmail.com","12345");//hatal� �ifre y�z�nden kay�t olmayacak.
		User user6 = new User(5,"C","Dddd","ardakozan97@gmail.com","12345677");//hatal� isim y�z�nden kay�t olmayacak.
		User user7 = new User(6,"Cccc","Dddd","ccccdddd@gmail.com","12345677");
		User user8 = new User(6,"Eeee","Ffff","eeeeffff@gmail.com","123456789");//g�ncellenecek.
		User user9 = new User(8,"Gggg","Hhhh","gggghhhh@gmail.com","12345677");
		
		try {
			userManager.add(user1);
			userManager.add(user2);
			userManager.add(user3);
			userManager.add(user4);
			userManager.add(user5);
			userManager.add(user6);
			userManager.add(user7);
			userManager.add(user9);
			userManager.update(user8);
			userManager.delete(user8);
		}
		catch(BusinessException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Kullan�c�lar:");
		for(User users : userManager.getAll()) {
			System.out.println(users.getFirstName() + " " + users.getLastName() + " " + users.geteMail());
		}
	}

}
