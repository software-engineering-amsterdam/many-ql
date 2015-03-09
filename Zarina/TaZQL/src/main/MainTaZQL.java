	/*
	 * @Zarina
	 */

package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import typechecker.TypeChecker;
import evaluator.ValueRepository;
import gui.MainFrame;


	public class MainTaZQL {
		
		public static void main(String[] args) throws FileNotFoundException, IOException  {
				
			TypeChecker typeChecker = new TypeChecker();
			boolean check = typeChecker.checkQuestionnaire(new ASTCreator().formCreator());
			if(check) {
				ValueRepository values = new ValueRepository();
				MainFrame mf = new MainFrame();
				mf.magic(new ASTCreator().formCreator(), values);
			}
			else {
				typeChecker.showErrors();
			}
		}
}

