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
		
		int startColumnNumber = 1; // ù��° �������� ��
		
		// ���� -> ���̺��� �����.
		String[][] table = multiplicationService.createTable(multiplication.getStartRowNumber(), 
				multiplication.getEndRowNumber(), startColumnNumber, 
				multiplication.getEndColumnNumber());
		
//		Assertions.assertThat(multiplicationService).isSameAs(multiplicationService2); // test����
		Gson gson = new Gson();
		String gsonString = gson.toJson(table); // ���̺� �����͸� gson�� ����Ͽ� string ���·� �ٲ۴�.
		// ���ϰ����� �Լ��� ���� ����!
		return gsonString; // string ������ �����͸� �ѱ��.
	}
}
