	/*
	 * @Zarina
	 */

package main;

import gui.MainFrame;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.manager.ASTCreator;
import typechecker.TypeChecker;
import ast.form.Form;


	public class MainTaZQL {
		
		public static void main(String[] args) throws FileNotFoundException, IOException  {
				
			TypeChecker typeChecker = new TypeChecker();
			Form form = new ASTCreator().formCreator();
			boolean check = typeChecker.checkQuestionnaire(form);
			if(check) {
				MainFrame mf = new MainFrame();
				mf.magic(form);	
			}
			else {
				typeChecker.showErrors();
			}
		}
}

