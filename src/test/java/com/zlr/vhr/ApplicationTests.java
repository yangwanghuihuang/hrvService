package com.zlr.vhr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.util.validate;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		BaseResponse<String> random=validate.getValidationCode();
		System.out.println(random);
	}

}
