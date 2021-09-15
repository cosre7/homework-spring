package multiplication.multiplicationspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import multiplication.multiplicationspring.domain.Multiplication;
import multiplication.multiplicationspring.service.MultiplicationService;

@Controller
public class MultiplicationController {

	@Autowired
	MultiplicationService multiplicationService;
	//= MultiplicationService.getInstance();
//	MultiplicationService multiplicationService2 = MultiplicationService.getInstance();
//	MultiplicationService multiplicationService = new MultiplicationService(); // -> �����ڰ� private�̱� ������ ���� �Ұ�
//	MultiplicationService multiplicationService2 = new MultiplicationService();
	
	
	@GetMapping("/")
	public String createForm() {
		return "thymeleaf/multiplicationForm";
	}

	@PostMapping("/table")
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
		return "multiplicationTable";
	}
}
