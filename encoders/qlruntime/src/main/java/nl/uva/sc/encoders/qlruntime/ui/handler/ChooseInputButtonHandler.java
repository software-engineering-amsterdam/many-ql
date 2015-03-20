package nl.uva.sc.encoders.qlruntime.ui.handler;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.ExceptionDialog;

public final class ChooseInputButtonHandler implements EventHandler<ActionEvent> {

	private final TextField textField;

	private final String defaultLocation;

	public ChooseInputButtonHandler(TextField textField, String defaultLocation) {
		this.textField = textField;
		this.defaultLocation = defaultLocation;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			URL resource = getURL(defaultLocation);
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

	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}

}