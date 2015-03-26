package nl.uva.sc.encoders.qlsruntime.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class StylesheetUI {

	public Control generateUI(String stylesheetTitle) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(650, 500);
		return scrollPane;
	}

}
