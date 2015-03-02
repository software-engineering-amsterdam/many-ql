package org.uva.sea.ql.encoders.ui;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import org.uva.sea.ql.encoders.ast.TypeValidation;

public class ValidationsUI {

	public Control generateUI(List<TypeValidation> typeValidations) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(new Label("Type Checker errors:"), 0, 0);

		TextArea typeCheckerMessages = new TextArea();
		grid.add(typeCheckerMessages, 0, 1);
		typeCheckerMessages.setEditable(false);
		typeCheckerMessages.setStyle("-fx-text-fill: red;");

		for (TypeValidation typeValidation : typeValidations) {
			typeCheckerMessages.appendText(typeValidation.getName() + ": " + typeValidation.getTypeErrorText());
			typeCheckerMessages.appendText("\n");
		}
		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(550, 275);
		return scrollPane;
	}
}
