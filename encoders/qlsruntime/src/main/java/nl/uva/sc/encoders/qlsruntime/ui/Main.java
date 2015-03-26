package nl.uva.sc.encoders.qlsruntime.ui;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.sc.encoders.qlsruntime.ui.handler.ParseButtonHandler;

import org.controlsfx.dialog.ExceptionDialog;

public class Main extends Application {

	private static final String DEFAULT_INPUT_FILE_DIRECTORY = "qls/";

	private static final String DEFAULT_INPUT_FILE_NAME = "stylesheet.qls";

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

		final TextField inputFileTextField = new TextField(DEFAULT_INPUT_FILE_DIRECTORY + DEFAULT_INPUT_FILE_NAME);
		Button chooseInputButton = new Button("Choose input file...");
		Button parseButton = new Button("Parse");
		grid.add(inputFileTextField, 0, 0);
		grid.add(chooseInputButton, 1, 0);
		grid.add(parseButton, 2, 0);

		chooseInputButton.setOnAction(new ChooseInputButtonHandler(inputFileTextField));

		StackPane stackPane = new StackPane();
		String inputFilePath = inputFileTextField.getText();
		ParseButtonHandler parseButtonHandler = new ParseButtonHandler(stackPane, inputFilePath);
		parseButton.setOnAction(parseButtonHandler);

		grid.add(stackPane, 0, 1, 3, 1);

		Scene scene = new Scene(grid, 750, 600);
		scene.getStylesheets().add(getClass().getResource("UIElements.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}

	private final class ChooseInputButtonHandler implements EventHandler<ActionEvent> {
		private final TextField textField;

		private ChooseInputButtonHandler(TextField textField) {
			this.textField = textField;
		}

		@Override
		public void handle(ActionEvent event) {
			try {
				URL resource = getURL(DEFAULT_INPUT_FILE_DIRECTORY + DEFAULT_INPUT_FILE_NAME);
				File file = new File(resource.toURI());
				file = file.getParentFile();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setInitialDirectory(file);
				File result = fileChooser.showOpenDialog(null);
				if (result != null) {
					textField.setText(result.getPath());
				}
			} catch (URISyntaxException e) {
				ExceptionDialog dialog = new ExceptionDialog(e);
				dialog.show();
				e.printStackTrace();
			}
		}
	}
}
