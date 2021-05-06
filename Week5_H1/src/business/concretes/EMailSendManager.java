package business.concretes;

import business.abstracts.EMailSendService;
import entities.concretes.User;

public class EMailSendManager implements EMailSendService{

	@Override
	public void sendEmail(User user) {
		System.out.println(user.getePosta() + " verification e-mail sended to this adress");
	}
}