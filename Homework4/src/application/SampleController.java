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
			begin = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
	}
	
	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		if(!value.equals("=")) {
			if(!operator.isEmpty()) {
				return;
			}
			operator = value;
			n1 = Long.parseLong(result.getText());
			result.setText("");
		}
		else {
			if(operator.isEmpty()) {
				return;
			}
			long n2 = Long.parseLong(result.getText());
			double output = calc.calculate(n1, n2, operator);
			result.setText(String.valueOf(output));
			operator = "";
			begin = true;
		}
		if(value.equals("AC")) {
			n1 = 0;
			result.setText("");
			operator = "";
			begin = true;
		}
	}
}