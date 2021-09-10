package multiplication.multiplicationspring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/table")
	public String create(int startRowNumber, int endRowNumber, int endColumnNumber) {
		return "multiplicationTable";
	}
}
