package multiplication.multiplicationspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import multiplication.multiplicationspring.domain.Multiplication;
import multiplication.multiplicationspring.service.MultiplicationService;

@Controller
public class MultiplicationController {

	@Autowired
	MultiplicationService multiplicationService;
	
	@GetMapping("/")
	public String createForm() {
		return "thymeleaf/multiplicationForm";
	}
	
	@ResponseBody
	@PostMapping("/")
	public String create(Multiplication multiplication) {
		
		int startColumnNumber = 1; // 첫번째 곱해지는 수
		
		// 서비스 -> 테이블을 만든다.
		String[][] table = multiplicationService.createTable(multiplication.getStartRowNumber(), 
				multiplication.getEndRowNumber(), startColumnNumber, 
				multiplication.getEndColumnNumber());
		
//		Assertions.assertThat(multiplicationService).isSameAs(multiplicationService2); // test실행
		Gson gson = new Gson();
		String gsonString = gson.toJson(table); // 테이블 데이터를 gson을 사용하여 string 형태로 바꾼다.
		// 리턴값에는 함수값 주지 말자!
		return gsonString; // string 형태의 데이터를 넘긴다.
	}
}
