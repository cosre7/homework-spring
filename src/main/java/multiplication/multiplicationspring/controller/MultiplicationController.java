package multiplication.multiplicationspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@PostMapping("/")
	@ResponseBody
	public String create(Multiplication multiplication, Model model) {
		
		int startColumnNumber = 1; // ù��° �������� ��
		
		// ���� -> ���̺��� �����.
		String[][] table = multiplicationService.createTable(multiplication.getStartRowNumber(), 
				multiplication.getEndRowNumber(), startColumnNumber, 
				multiplication.getEndColumnNumber());
		
		model.addAttribute("multiplication", multiplication);
		model.addAttribute("startColumnNumber", startColumnNumber);
		model.addAttribute("table", table);
//		Assertions.assertThat(multiplicationService).isSameAs(multiplicationService2); // test����
		
		Gson gson = new Gson();
		String gsonString = gson.toJson(table);
		
		// ���ϰ����� �Լ��� ���� ����!
		return gsonString;
	}
}
