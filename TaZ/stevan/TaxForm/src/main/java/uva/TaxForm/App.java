package uva.TaxForm;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class App {
	
	public static void main(String[] args) {
		String filePath;
		boolean internal = true;

		if (args.length == 0) {
			filePath = "/resources/default.tax";
		} else {
			filePath = args[0];
			internal = false;
		}
		
		if (internal) {
			try {
				TaxForm taxForm = new TaxForm(URL.class.getResource(filePath), internal);
				taxForm.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				TaxForm taxForm = new TaxForm(new File(filePath).toURI().toURL(), internal);
				taxForm.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
