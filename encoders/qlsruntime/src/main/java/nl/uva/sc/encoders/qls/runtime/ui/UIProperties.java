package nl.uva.sc.encoders.qls.runtime.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UIProperties {

	Properties uiProperties = new Properties();

	public UIProperties() {
		InputStream inputProperties = null;
		try {
			inputProperties = new FileInputStream("src/main/resources/UI.properties");
			uiProperties.load(inputProperties);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Properties getUIProperties() {
		return uiProperties;
	}

}
