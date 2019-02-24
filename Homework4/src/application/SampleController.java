package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class SampleController {
	@FXML
	private Label result;
	private long n1 = 0;
	private String operator = "";
	private boolean begin = true;
	private Calculator calc = new Calculator();
	
	@FXML
	public void processNumbers(ActionEvent event) {
		if(begin) {
			result.setText("");
			begin = false; //sets begin to false
		}
		String value = ((Button)event.getSource()).getText(); //sets value
		result.setText(result.getText() + value); //sets the label's text to the value
	}
	
	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		if(value.equals("AC")) { //resets everything
			n1 = 0;
			result.setText("");
			value = "";
			operator = "";
			begin = true;
		}
		if(!value.equals("=")) {
			if(!operator.isEmpty()) {
				return;
			}
			operator = value;
			n1 = Long.parseLong(result.getText()); //sets n1 to the first value typed in the calculator
			result.setText(""); //makes the label's text blank
		}
		else {
			if(operator.isEmpty()) {
				return;
			}
			long n2 = Long.parseLong(result.getText()); //sets n2 to the second value typed in the calculator
			String output = calc.calculate(n1, n2, operator); //calculates the output
			result.setText(output); //set's the label's text to the output
			operator = "";
			begin = true; //sets begin back to true
		}
	}
}