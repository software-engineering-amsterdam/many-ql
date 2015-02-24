	/*
	 * @Zarina
	 */

package com.antlr4.zarina.tazql;

import gui.MainFrame;

import java.io.FileNotFoundException;
import java.io.IOException;


	public class MainTaZQL {
		
		public static void main(String[] args) throws FileNotFoundException, IOException  {
						
				// Build my GUI
				MainFrame mf = new MainFrame();
				mf.magic(new ASTCreator().formCreator());
					
		}
}

