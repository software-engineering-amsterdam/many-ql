package com.antlr4.zarina.tazql;


public class MyTaZQLBaseListener extends TaZQLBaseListener {
	Questions q;
	MainFrame mf = new MainFrame();
	
	public MyTaZQLBaseListener(Questions q) {
		this.q = q;
	}
	
	@Override
	public void enterQuestionLabel(TaZQLParser.QuestionLabelContext ctx) {
		String label = new String(ctx.FILETEXT().getText());
		int number = new Integer(ctx.NUMBER().getText());
		
		QuestionLabels ql = new QuestionLabels(number, label);		
		q.addLabel(ql);
		//ql.setQuestionLabel(label);
	//	String lbl = ql.getQuestionLabel();
	System.out.println("Listener: "+ ql);
	
	
		//for (QuestionLabels qls : q.getQuestionLabels()) {	
		//	System.out.println("setLabel: "+qls);
			mf.getLabel("Label test: "+ql);
		//}
	}
	

}
