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

	private MultiplicationService multiplicationService;
	
	@Autowired
	public MultiplicationController(MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}
	
	@GetMapping("/")
	public String createForm() {
		return "multiplicationForm";
	}
	
	@PostMapping("/")
	public String create(MultiplicationForm form, Model model) {
		Multiplication multiplication = new Multiplication();
		int startRowNumber = form.getStartRowNumber();
		int endRowNumber = form.getEndRowNumber();
		int startColumnNumber = 1;
		int endColumnNumber = form.getEndColumnNumber();
		multiplicationService.createTable(startRowNumber, endRowNumber, startColumnNumber, endColumnNumber);
		multiplication.setStartRowNumber(startRowNumber);
		multiplication.setEndRowNumber(endRowNumber);
		multiplication.setStartColumnNumber(startColumnNumber);
		multiplication.setEndColumnNumber(endColumnNumber);
		
		Object item = multiplicationService.findItem(startRowNumber, startColumnNumber);
		model.addAttribute("item", item);
		model.addAttribute("startRowNumber", startRowNumber);
		System.out.println(startRowNumber);
		return "multiplicationTable";
	}
}
