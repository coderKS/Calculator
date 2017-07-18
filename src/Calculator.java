package src;

import java.math.BigDecimal;

public class Calculator {
	private String CONSTANTS_OPERATOR_ADD = "+";
	private String CONSTANTS_OPERATOR_MINUS = "-";
	private String CONSTANTS_OPERATOR_MULTIPLY = "*";
	private String CONSTANTS_OPERATOR_DIVIDE = "/";
	
	public int findSplitPos(String expr, String oper1, String oper2){
		if (expr == null || expr.isEmpty()){
			return -1;
		}
		int operPos1 = expr.indexOf(oper1);
		int operPos2 = expr.indexOf(oper2);
		if(operPos1 == -1 && operPos2 == -1){
			return -1;
		} else if(operPos1 == -1){
			return operPos2;
		} else if(operPos2 == -1){
			return operPos1;
		} else {
			return operPos1 < operPos2 ? operPos1 : operPos2;
		}
		
	}
	public Double calculate(String expr) {
		if(!expr.isEmpty()){
			return new Double(1);
		}
		return new Double(0);
	}
	
	public static void main(String args[]){
		
	}
	
}
