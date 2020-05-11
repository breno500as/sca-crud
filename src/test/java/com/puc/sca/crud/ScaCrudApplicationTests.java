package com.puc.sca.crud;

import static org.assertj.core.api.Assertions.assertThat;
 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScaCrudApplicationTests {

	@Test
	public void contextLoads() {
		String reverse = "kcom";
		assertThat(reverse).isEqualTo("kcom");
	}

}
