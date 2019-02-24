package application;

public class Calculator {
	public String calculate(long n1, long n2, String operator) {
		switch(operator) { //for the operators
		case "+":
			return String.valueOf(n1 + n2); //returns the sum
		case "/":
			if(n2 == 0) {
				return "ERROR"; //returns an error if the denominator is 0
			}
			else {
				return String.valueOf(n1 / n2); //returns the quotient
			}
		}
		return "";
	}
}
