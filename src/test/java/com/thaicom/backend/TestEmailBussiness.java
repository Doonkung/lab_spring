package com.thaicom.backend;

import com.thaicom.backend.business.EmailBussiness;
import com.thaicom.backend.exception.BaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestEmailBussiness {

	@Autowired
	private EmailBussiness emailBussiness;

	@Test
	@DisplayName("ทดสอบการส่ง email")
	public void testSendEmailActivate() throws BaseException {
		emailBussiness.sendActivateUserEmail(TestDate.email, TestDate.name, TestDate.token);
	}

	interface  TestDate{
		String email = "doonkung@gmail.com";
		String name = "Test";
		String token = "Token naja";
	}
}
