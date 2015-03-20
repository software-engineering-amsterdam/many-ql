package nl.uva.sc.encoders.qls.runtime.ui;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import nl.uva.sc.encoders.qls.validation.Validation;

public class ValidationsUI {

	public Node generateUI(List<? extends Validation> validations) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(new Label("Type Checker errors:"), 0, 0);

		TextArea typeCheckerMessages = new TextArea();
		typeCheckerMessages.setPrefSize(650, 500);
		grid.add(typeCheckerMessages, 0, 1);
		typeCheckerMessages.setEditable(false);
		typeCheckerMessages.setStyle("-fx-text-fill: red;");

		for (Validation validation : validations) {
			typeCheckerMessages.appendText(validation.toString());
		}
		return grid;
	}
}
