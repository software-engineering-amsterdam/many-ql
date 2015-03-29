package nl.uva.sc.encoders.qlsruntime.ui;

import static nl.uva.sc.encoders.qlruntime.ui.Main.DEFAULT_QL_INPUT_FILE_DIRECTORY;
import static nl.uva.sc.encoders.qlruntime.ui.Main.DEFAULT_QL_INPUT_FILE_NAME;

import java.util.Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler.PathSelectedCallback;
import nl.uva.sc.encoders.qlsruntime.ui.handler.ParseButtonHandler;

public class Main extends Application {

	private static final String DEFAULT_QLS_INPUT_FILE_DIRECTORY = "qls/";

	private static final String DEFAULT_QLS_INPUT_FILE_NAME = "stylesheet.qls";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Properties uiProperties = new UIProperties().getUIProperties();

		String propertyWindowName = uiProperties.getProperty("windowName");
		String propertyInitializationImage = uiProperties.getProperty("initializationImage");

		primaryStage.setTitle(propertyWindowName);
		primaryStage.getIcons().add(new Image(propertyInitializationImage));

		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");

		String defaultQlsLocation = DEFAULT_QLS_INPUT_FILE_DIRECTORY + DEFAULT_QLS_INPUT_FILE_NAME;
		String defaultQlLocation = DEFAULT_QL_INPUT_FILE_DIRECTORY + DEFAULT_QL_INPUT_FILE_NAME;
		final TextField qlInputFileTextField = new TextField(defaultQlLocation);
		final TextField qlsInputFileTextField = new TextField(defaultQlsLocation);
		Button qlChooseInputButton = new Button("Choose ql file...");
		Button qlsChooseInputButton = new Button("Choose qls file...");
		Button parseButton = new Button("Parse");
		grid.add(qlInputFileTextField, 0, 0);
		grid.add(qlChooseInputButton, 1, 0);
		grid.add(qlsInputFileTextField, 0, 1);
		grid.add(qlsChooseInputButton, 1, 1);
		grid.add(parseButton, 2, 1);

		PathSelectedCallback qlPathSelectedCallback = path -> qlInputFileTextField.setText(path);
		PathSelectedCallback qlsPathSelectedCallback = path -> qlsInputFileTextField.setText(path);
		qlChooseInputButton.setOnAction(new ChooseInputButtonHandler(qlPathSelectedCallback, defaultQlLocation));
		qlsChooseInputButton.setOnAction(new ChooseInputButtonHandler(qlsPathSelectedCallback, defaultQlsLocation));

		StackPane stackPane = new StackPane();
		String inputFilePath = qlsInputFileTextField.getText();
		ParseButtonHandler parseButtonHandler = new ParseButtonHandler(stackPane, inputFilePath);
		parseButton.setOnAction(parseButtonHandler);

		grid.add(stackPane, 0, 2, 3, 1);

		Scene scene = new Scene(grid, 750, 600);
		scene.getStylesheets().add(getClass().getResource("UIElements.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
