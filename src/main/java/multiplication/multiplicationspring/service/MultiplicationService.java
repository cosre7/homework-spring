package multiplication.multiplicationspring.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
	
	// 싱글턴 - LazyHolder기법
	/* 클래스 내부의 클래스는 외부와 클래스가 초기화될 때 초기화되지 않고, 
	 * 클래스의 static 변수는 클래스를 로딩할 때 초기화되는 것을 이용
	 */
	/* 
	 * 싱글턴 사용 이유?
	 * - Service를 호출할 때 마다 new로 새로운 객체를 만든다? -> 메모리 낭비 엄청남
	 * -> getInstance()를 호출하면 하나의 객체만 딱 만들어두고 그걸 계~속 사용하도록
	 * - 계속 새로운 객체를 만들어내게 되면 100명의 사람이 접속하면 100개의 service가 만들어져야만 한다? -> 별로..
	 * 
	 * 
	 */
	
	//private static final MultiplicationService instance = new MultiplicationService();
	
	// 초기에는 InnerInstanceClazz를 초기화하지 않다가 getInstance가 호출되면 로딩되며 초기화한다.
//	public static MultiplicationService getInstance() {
//		return instance;
//	}
	
	private MultiplicationService() {} // 생성자를 외부에서 호출할 수 없도록 private으로 선언

	// createTable(2,9,1,9)[6][5] -> 6 * 5 = 30
	public String[][] createTable(int startRowNumber, int endRowNumber, int startColumnNumber, int endColumnNumber) {
		// 큰 범위로 배열 생성 -> rowNumber, ColumnNumber 그대로 넣어도 확인할 수 있도록 하기 위함
		String[][] table = new String[endRowNumber+1][endColumnNumber+1]; 
		for(int i = startRowNumber; i <= endRowNumber; i++) {
			for(int j = startColumnNumber; j <= endColumnNumber; j++) {
				table[i][j] = createOperation(i, j).toString();
			}
		}
		return table;
	}

	// createOperation(2,9) -> 2 * 9 = 18
	private String createOperation(int rowNumber, int columnNumber) {
		int result = rowNumber * columnNumber;
		String operation = rowNumber + " * " + columnNumber + " = " + result;
		return operation;
	}
	
//	// findOne(6,5) -> 6 * 5 = 30
//	public String findOne(int rowNumber, int ColumnNumber) {
//		return table[rowNumber][ColumnNumber];
//	}
}
