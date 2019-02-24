package application;

public class Calculator {
	public double calculate(long n1, long n2, String operator) {
		switch(operator) {
		case "+":
			return n1 + n2;
		case "/":
			if(n2 == 0) {
				return 0;
			}
			else {
				return n1 / n2;
			}
		}
		return 0;
	}
}
