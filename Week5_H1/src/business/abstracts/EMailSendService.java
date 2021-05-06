package business.abstracts;

import entities.concretes.User;

public interface EMailSendService {
	void sendEmail(User user);
}
