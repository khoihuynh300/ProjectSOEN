package com.sunny.service.impl;

import java.util.List;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

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
	private Validator validator;

	@Autowired
	private JavaMailSender mailSender;

	private Integer verifyerCode;

	@Override
	public User createUser(User user) throws Exception {
		Set<ConstraintViolation<User>> violations = validator.validate(user);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<User> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}

		if (userdao.findUserByAccountName(user.getAccountName()) == null
				&& userdao.findUserByEmail(user.getEmail()) == null || checkEnableEmail(userdao.findUserByEmail(user.getEmail())) == false) {
			return userdao.create(user);
		} else
			throw new Exception("User exist !!");
	}

	public boolean checkEnableEmail(List<User> user) {
		for(User u : user) {
			if(u.isEnable()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		System.err.println("delete");
		userdao.delete(user.getUserId());
	}

	@Override
	public User getUserById(int id) {
		return userdao.getUserById(id);
	}

	@Override
	public List<User> getAllUser(int pageNumber, int pageSize, int viewdeleted) {
		
		return userdao.getAllUser(pageNumber, pageSize, viewdeleted);
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
		verifyerCode = (int) ((Math.random() * (999999 - 100000)) + 100000);
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
		// User check2 = userdao.findUserByEmail(user.getEmail());

		if (check1 != null && code == verifyerCode) {
			userdao.verifyer(user.getAccountName());
			return true;

		} else
			return false;
			//throw new Exception("Do not correct!!");
	}

	@Override
	public void resetPassword(User user, int code) throws Exception {
		User check1 = userdao.findUserByAccountName(user.getAccountName());
		if (check1 != null) {
			if (code == verifyerCode) {
				userdao.update(user.getAccountName(), user.getPassword());
			}
		} else
			throw new Exception("Email và tài khoản không trùng khớp");
	}

	@Override
	public User createOrLogin(GooglePojo googlePojo) throws Exception {
		List<User> ex1 = userdao.findUserByEmail(googlePojo.getEmail());
		User ex2 = userdao.findUserByAccountName(googlePojo.getId());
		if (ex1.isEmpty() || checkEnableEmail(ex1) == false) {
			User user = new User();
			user.setAccountName(googlePojo.getId().toString());
			System.out.println(googlePojo.getId().toString());
			user.setPassword(googlePojo.getId().toString());
			String[] email = googlePojo.getEmail().split("@");
			user.setEmail(email[0]+ "+" + BCrypt.hashpw("", BCrypt.gensalt(4)) + "@" + email[1]);
			//user.setEmail(googlePojo.getEmail());
			user.setEnable(true);
			userdao.save(user);
			return user;
		} else {
			return verifyerLogin(googlePojo.getId().toString(), googlePojo.getId().toString());
		}

	}

	@Override
	public User getUser(User user) {
		return userdao.findUser(user.getUserId());
	}

	@Override
	public void updateUser(User user, String newPassword) {
		userdao.update(user.getAccountName(), newPassword);
	}

	@Override
	public User getUserByAccountName(User user) {
		return userdao.findUserByAccountName(user.getAccountName());
	}

	@Override
	public int checkRoles(User user) {
		return user.getRoleId().getRoleId();
	}

	@Override
	public boolean checkUserInfo(User user) {
		return userdao.checkUserInfo(user.getUserId());
	}

	@Override
	public Long count(int viewdeleted, String table) {
		return userdao.count(viewdeleted, table);
	}

}
