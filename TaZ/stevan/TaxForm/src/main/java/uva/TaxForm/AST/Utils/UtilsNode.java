package uva.TaxForm.AST.Utils;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionBoolean;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionInteger;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionMoney;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionString;
import uva.TaxForm.AST.NodeVar.NodeVar;
import uva.TaxForm.AST.NodeVar.VarBoolean;
import uva.TaxForm.AST.NodeVar.VarInteger;
import uva.TaxForm.AST.NodeVar.VarMoney;
import uva.TaxForm.AST.NodeVar.VarString;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class UtilsNode {
	
	public static NodeQuestionBoolean setBooleanQuestionValues(QuestionContext ctx, Node node) {
		
		NodeQuestionBoolean question = new NodeQuestionBoolean();
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		VarBoolean var = new VarBoolean();
		var.setName(ctx.varName().getText());
		question.setVar(var);
		
		node.add(question);
		
		return question;
	}
	
	public static NodeQuestionMoney setMoneyQuestionValues(QuestionContext ctx, Node node) {
		
		NodeQuestionMoney question = new NodeQuestionMoney();
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		VarMoney var = new VarMoney();
		var.setName(ctx.varName().getText());
		question.setVar(var);
		
		node.add(question);
		
		return question;
	}
	
	public static NodeQuestionInteger setIntegerQuestionValues(QuestionContext ctx, Node node) {
		
		NodeQuestionInteger question = new NodeQuestionInteger();
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		VarInteger var = new VarInteger();
		var.setName(ctx.varName().getText());
		question.setVar(var);
		
		node.add(question);
		
		return question;
	}
	
	public static NodeQuestionString setStringQuestionValues(QuestionContext ctx, Node node) {
		
		NodeQuestionString question = new NodeQuestionString();
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		VarString var = new VarString();
		var.setName(ctx.varName().getText());
		question.setVar(var);
		
		node.add(question);
		
		return question;
	}
	
	public static NodeVar getVarInTree(String name, Node tree) {
		
		NodeVar returnNode = new NodeVar();
		
		for (int i=0; i<tree.getNodes().size(); i++) {
			
			if (tree.getNodes().get(i).getClass().equals(uva.TaxForm.AST.NodeQuestion.NodeQuestion.class)) {
				
				//System.out.println(tree.getNodes().get(i).getClass());
				//NodeQuestion nodeQ = (NodeQuestion) tree.getNodes().get(i);
				
				/*if (name.equals(nodeQ.getName())) {
					System.out.println("getName: " + nodeQ.getName());
					System.out.println("getVar: " + nodeQ.getVar());
					returnNode = nodeQ.getVar();
				}*/
			}
			else {
				//System.out.println(tree.getNodes().get(i).getClass());
				UtilsNode.getVarInTree(name, tree.getNodes().get(i));
			}
		}
		return returnNode;
	}
}
