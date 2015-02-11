package uva.TaxForm;

import java.net.URISyntaxException;
import java.net.URL;

public class App {
	
	public static void main(String[] args) {
		String filePath;

		if (args.length == 0) {
			filePath = "/resources/default.tax";
		} else {
			System.out.println( args[0] );
			try {
				String uri = App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
				System.out.println( uri );
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			filePath = args[0];
		}
		
		try {
			TaxForm taxForm = new TaxForm(URL.class.getResource(filePath));
			taxForm.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
