/*
 * @Zarina
 */

package com.antlr4.zarina.tazql;

import gui.MainFrame;
import AST.TestGeneric;


public class MyTaZQLBaseListener extends TaZQLBaseListener {
	Questions q;
	MainFrame mf = new MainFrame();
	
	public MyTaZQLBaseListener(Questions q) {
		this.q = q;
	}
	
	@Override
	public void enterSimpleQuestion(TaZQLParser.SimpleQuestionContext ctx) {
		String label = new String(ctx.TEXT().getText());
		//int number = new Integer(ctx.NUMBER().getText());
		//type = ctx.TYpe().getkakakakakak
		QuestionLabels ql = new QuestionLabels(1, label);		
		q.addLabel(ql);
		
		System.out.println("Listener: "+ ql);
		
      //  TestGeneric <String> gs = new TestGeneric<String>();

        //gs.push(label);

       // System.out.println(gs.pop());
	
		// add question as a label to panel
		//mf.getLabel("Label test: "+gs.pop(), true);
		mf.getLabel("Label test: "+label, true);
	}
	
}
