package multiplication.multiplicationspring.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
	
	// �̱��� - LazyHolder���
	/* Ŭ���� ������ Ŭ������ �ܺο� Ŭ������ �ʱ�ȭ�� �� �ʱ�ȭ���� �ʰ�, 
	 * Ŭ������ static ������ Ŭ������ �ε��� �� �ʱ�ȭ�Ǵ� ���� �̿�
	 */
	/* 
	 * �̱��� ��� ����?
	 * - Service�� ȣ���� �� ���� new�� ���ο� ��ü�� �����? -> �޸� ���� ��û��
	 * -> getInstance()�� ȣ���ϸ� �ϳ��� ��ü�� �� �����ΰ� �װ� ��~�� ����ϵ���
	 * - ��� ���ο� ��ü�� ������ �Ǹ� 100���� ����� �����ϸ� 100���� service�� ��������߸� �Ѵ�? -> ����..
	 * 
	 * 
	 */
	
	//private static final MultiplicationService instance = new MultiplicationService();
	
	// �ʱ⿡�� InnerInstanceClazz�� �ʱ�ȭ���� �ʴٰ� getInstance�� ȣ��Ǹ� �ε��Ǹ� �ʱ�ȭ�Ѵ�.
//	public static MultiplicationService getInstance() {
//		return instance;
//	}
	
	private MultiplicationService() {} // �����ڸ� �ܺο��� ȣ���� �� ������ private���� ����

	// createTable(2,9,1,9)[6][5] -> 6 * 5 = 30
	public String[][] createTable(int startRowNumber, int endRowNumber, int startColumnNumber, int endColumnNumber) {
		// ū ������ �迭 ���� -> rowNumber, ColumnNumber �״�� �־ Ȯ���� �� �ֵ��� �ϱ� ����
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
