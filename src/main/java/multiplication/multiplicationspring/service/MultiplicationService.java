package multiplication.multiplicationspring.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
	
	private String[][] table;

	// createTable(2,9,1,9)[6][5] -> 6 * 5 = 30
	public String[][] createTable(int startRowNumber, int endRowNumber, int startColumnNumber, int endColumnNumber) {
		// ū ������ �迭 ���� -> rowNumber, ColumnNumber �״�� �־ Ȯ���� �� �ֵ��� �ϱ� ����
		table = new String[endRowNumber+1][endColumnNumber+1]; 
		for(int i = startRowNumber; i <= endRowNumber; i++) {
			for(int j = startColumnNumber; j <= endColumnNumber; j++) {
				table[i][j] = createOperation(i, j).toString();
			}
		}
//		System.out.println(table.toString());
		return table;
	}

	// createOperation(2,9) -> 2 * 9 = 18
	public String createOperation(int rowNumber, int columnNumber) {
		int result = rowNumber * columnNumber;
//		List<String> operation = new ArrayList<>();
//		operation.add();
		String operation = rowNumber + " * " + columnNumber + " = " + result;
		return operation;
	}
	
	// findOne(6,5) -> 6 * 5 = 30
	public String findOne(int rowNumber, int ColumnNumber) {
		return table[rowNumber][ColumnNumber];
	}
}
