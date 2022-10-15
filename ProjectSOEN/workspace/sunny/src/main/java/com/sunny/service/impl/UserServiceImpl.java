package com.sunny.service.impl;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sunny.dao.IUserDao;
import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.GooglePojo;
import com.sunny.model.User;
import com.sunny.service.IUserService;

//@Component
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userdao;

	@Autowired
	private JavaMailSender mailSender;

	private int verifyerCode = (int) ((Math.random() * (999999 - 100000)) + 100000);

	@Override
	public User create(User user) throws Exception {
		if (userdao.findUserByAccountName(user.getAccountName()) == null
				&& userdao.findUserByEmail(user.getEmail()) == null) {
			return userdao.create(user);
		} else
			throw new Exception("User exist !!");
	}

	@Override
	public void update(User user) {
		userdao.update(user.getAccountName(), user.getPassword());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userdao = new UserDaoImpl();
		userdao.delete(id);
	}

	@Override
	public List<User> getAllUser() {
		return userdao.getAllUser();
	}

	@Override
	public User verifyerLogin(String accountName, String password) {
		User user = userdao.findUserByAccountName(accountName);
		if (user != null) {
			if (BCrypt.checkpw(password, user.getPassword()) == true)
				return user;
		}
		return null;
	}

	@Override
	public void sendEmailVerify(User user) throws Exception {
		String subject = "Please verify your account";
		String senderName = "Thousand Sunny";
		String mailContent = "<p>Dear :" + user.getAccountName() + ",</p>";
		mailContent += "<p>Plase enter the verifyer code below to verify your account.</p>";

		mailContent += "<h1>" + String.valueOf(verifyerCode) + "</h1>";

		mailContent += "<p>Thank You <br> Thousand Sunny Team</p>";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("20110675@student.hcmute.edu.vn", senderName);
		helper.setTo(user.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);

		mailSender.send(message);

	}

	@Override
	public boolean verifyerRegister(User user, int code) throws Exception {
		User check1 = userdao.findUserByAccountName(user.getAccountName());
		User check2 = userdao.findUserByEmail(user.getEmail());

		if (check1 != null && check2 != null && code == verifyerCode) {
			userdao.verifyer(user.getAccountName());
			return true;

		} else
			throw new Exception("User/Email exist !!");
	}

	@Override
	public void resetPassword(User user, int code) throws Exception {
		User check1 = userdao.findUserByAccountName(user.getAccountName());
		User check2 = userdao.findUserByEmail(user.getEmail());
		if (check1.getUserId() == check2.getUserId()) {
			if (code == verifyerCode) {
				userdao.update(user.getAccountName(), user.getPassword());
			}
		} else
			throw new Exception("Email và tài khoản không trùng khớp");
	}

	@Override
	public void createOrLogin(GooglePojo googlePojo) {
		if (userdao.findUserByAccountName(googlePojo.getEmail().toString()) == null) {
			User user = new User();
			user.setAccountName(googlePojo.getEmail().toString());
			user.setPassword(googlePojo.getId().toString());
			user.setEnable(true);
			userdao.save(user);
		} else {
			verifyerLogin(googlePojo.getEmail().toString(), googlePojo.getId().toString());
		}
	}

}
