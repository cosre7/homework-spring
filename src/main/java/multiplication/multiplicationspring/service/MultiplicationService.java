package multiplication.multiplicationspring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
	
	private Map<String, Object> table = new HashMap<>();

	// {2*1=[2 * 1 = 2], 2*2=[2 * 2 = 4], 2*3=[2 * 3 = 6], ~~}
	public Map<String, Object> createTable(int startRowNumber, int endRowNumber, int startColumnNumber, int endColumnNumber) {
		for(int i = startRowNumber; i <= endRowNumber; i++) {
			for(int j = startColumnNumber; j <= endColumnNumber; j++) {
				table.put(i + "*" + j, createOperation(i, j));
			}
		}
		return table;
	}

	// [2 * 1 = 2] 
	public List<String> createOperation(int rowNumber, int columnNumber) {
		int result = rowNumber * columnNumber;
		List<String> operation = new ArrayList<>();
		operation.add(rowNumber + " * " + columnNumber + " = " + result);
		return operation;
	}
		
	// 2,2 -> [2 * 2 = 4]
	public Object findItem(int rowNumber, int columnNumber) {
		String result = rowNumber + "*" + columnNumber;
		return table.get(result);
	}
	
	
}
