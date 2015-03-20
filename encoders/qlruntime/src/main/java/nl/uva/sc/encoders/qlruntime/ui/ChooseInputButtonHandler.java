package nl.uva.sc.encoders.qlruntime.ui;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.ExceptionDialog;

final class ChooseInputButtonHandler implements EventHandler<ActionEvent> {
	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}

	private final TextField textField;

	ChooseInputButtonHandler(TextField textField) {
		this.textField = textField;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			URL resource = getURL(Main.DEFAULT_INPUT_FILE_DIRECTORY + Main.DEFAULT_INPUT_FILE_NAME);
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