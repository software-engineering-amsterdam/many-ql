	/*
	 * @Zarina
	 */

package main;

import evaluator.ValueRepository;
import gui.MainFrame;

import java.io.FileNotFoundException;
import java.io.IOException;


	public class MainTaZQL {
		
		public static void main(String[] args) throws FileNotFoundException, IOException  {
				
			//ErrorDialog errors = new ErrorDialog();
			//errors.errorDialog();
				// Build my GUI
				ValueRepository values = new ValueRepository();
				MainFrame mf = new MainFrame();
				mf.magic(new ASTCreator().formCreator(), values);
					
		}
}

