package multiplication.multiplicationspring.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import multiplication.multiplicationspring.domain.Multiplication;
import multiplication.multiplicationspring.service.MultiplicationService;

@Controller
public class MultiplicationControllerTest {

	@Autowired
	MultiplicationService multiplicationService = MultiplicationService.getInstance();
	MultiplicationService multiplicationService2 = MultiplicationService.getInstance();
//	MultiplicationService multiplicationService = new MultiplicationService(); // -> 생성자가 private이기 때문에 접근 불가
//	MultiplicationService multiplicationService2 = new MultiplicationService();
//	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//	MultiplicationService multiplicationService = ac.getBean(MultiplicationService.class);
//	MultiplicationService multiplicationService2 = ac.getBean(MultiplicationService.class);
	
	
	@Test
	public void create() {
		
		Assertions.assertThat(multiplicationService).isSameAs(multiplicationService2);
	}
}
