package src;

import java.math.BigDecimal;

public class Calculator {
	import java.math.BigDecimal;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class Calculator {
		private final char CONSTANTS_OPERATOR_ADD = '+';
		private final char CONSTANTS_OPERATOR_MINUS = '-';
		private final char CONSTANTS_OPERATOR_MULTIPLY = '*';
		private final char CONSTANTS_OPERATOR_DIVIDE = '/';
		private final char CONSTANTS_OPERATOR_OPEN_BRACKET = '(';
		private final char CONSTANTS_OPERATOR_CLOSE_BRACKET = ')';
		private final char CONSTANTS_OPERATOR_POWER = '^';
		
		
		public int indexOf(String patternString, String s) {
			Pattern pattern = Pattern.compile(patternString);
		    Matcher matcher = pattern.matcher(s);
		    return matcher.find() ? matcher.start() : -1;
		}
		
		// +1*2-2*-3+4
		// expr: 
		// postExpr: +2-6+4
		// lastOperand: 
		private Double parseAS(String expr, String postExpr, Double lastOperand){
			// check null or empty
			if(expr == null || expr.isEmpty()){
				postExpr = "+" + postExpr;
				postExpr = postExpr.replaceAll("\\-\\+", "-").replaceAll("\\+\\-", "-").replaceAll("\\-\\-", "+").replaceAll("\\+\\+", "+");
				return executeAS(postExpr);
			}
			String pattern = "[" + CONSTANTS_OPERATOR_MULTIPLY + 
									CONSTANTS_OPERATOR_DIVIDE + 
									CONSTANTS_OPERATOR_ADD + 
									CONSTANTS_OPERATOR_MINUS +
								"]";
			int index = -1;
			char leftChar = expr.charAt(0);
			String left = null, right = null, nextExpr = null;
			Double leftSum = -1.0, rightSum = -1.0, result = -1.0, nextOperand = -1.0;
			
			// find left
			
			if(leftChar == CONSTANTS_OPERATOR_MULTIPLY || leftChar == CONSTANTS_OPERATOR_DIVIDE){
				try{
					index = this.indexOf(pattern, expr.substring(1));
					if(index == -1){
						// return '*1'
						left = expr.substring(1); // 1
						leftSum = new Double(left);
						switch(leftChar){
						case CONSTANTS_OPERATOR_MULTIPLY:
							nextOperand = lastOperand * leftSum;
							break;
						case CONSTANTS_OPERATOR_DIVIDE:
							nextOperand = lastOperand / leftSum;
							break;
						}
						return executeMD(expr, postExpr, nextOperand);
					}
					index++;			
					left = expr.substring(1, index);
					right = expr.substring(index, expr.length());
					leftSum = new Double(left);
					
				} catch(NumberFormatException nte){
					nte.printStackTrace();
					return null;
				} 
			} else if (leftChar == CONSTANTS_OPERATOR_ADD || leftChar == CONSTANTS_OPERATOR_MINUS){
				if(lastOperand == null){
					nextExpr = postExpr + String.valueOf(leftChar);
				} else {
					nextExpr = postExpr + lastOperand.toString() + String.valueOf(leftChar);
				}
				
				nextOperand = 
			}
			
			
			
			return 0.0;
		}
		
		// calculate 1*2*3, return 6
		// calculate 1*2*-3, return -6
		private Double executeMD(String expr){
			// check null or empty
			if(expr == null || expr.isEmpty()){
				return 1.0;
			}
			// find index of first operator '+' or '-' in the expression
			String pattern = "[" + CONSTANTS_OPERATOR_MULTIPLY + CONSTANTS_OPERATOR_DIVIDE + "]";
			int index = -1;
			String left = null, right = null;
			Double leftSum = -1.0, rightSum = -1.0, result = -1.0;
			try{
				index = this.indexOf(pattern, expr.substring(1));
				if(index == -1){
					// return '1'
					return new Double(expr);
				}
				index++;			
				left = expr.substring(0, index);
				right = expr.substring(index, expr.length());
				leftSum = new Double(left);
				rightSum = this.executeAS(right);
				result = leftSum + rightSum;
				return result;
			} catch(NumberFormatException nte){
				nte.printStackTrace();
				return null;
			} 
		}
		
		// calculate 1+2+3+4, return 10
		// calculate -1+2+3+4, return 8
		private Double executeAS(String expr){
			// check null or empty
			if(expr == null || expr.isEmpty()){
				return 0.0;
			}
			// find index of first operator '+' or '-' in the expression
			String pattern = "[" + CONSTANTS_OPERATOR_ADD + CONSTANTS_OPERATOR_MINUS + "]";
			int index = -1;
			String left = null, right = null;
			Double leftSum = -1.0, rightSum = -1.0, result = -1.0;
			try{
				index = this.indexOf(pattern, expr.substring(1));
				if(index == -1){
					// '+1'
					return new Double(expr);
				}
				index++;			
				left = expr.substring(0, index);
				right = expr.substring(index, expr.length());
				leftSum = new Double(left);
				rightSum = this.executeAS(right);
				result = leftSum + rightSum;
				return result;
			} catch(NumberFormatException nte){
				nte.printStackTrace();
				return null;
			} 
		}
		public Double calculate(String expr) {
			
		}
		
		public static void main(String args[]){
			Calculator cal = new Calculator();
			Double result = cal.calculate("1.1-2.2+3.3-4.4");
			System.out.println("Result=["+result+"]");
		}
		
	}

	
}
