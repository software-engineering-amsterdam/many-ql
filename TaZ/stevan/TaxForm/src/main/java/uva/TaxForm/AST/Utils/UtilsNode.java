package uva.TaxForm.AST.Utils;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.AST.NodeVar.Var;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class UtilsNode {
	
	public static <T> Question<T> setQuestionValues(QuestionContext ctx, Node node) {
		
		Question<T> question = new Question<T>();
		node.add(question);
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		Var<T> var = new Var<T>();
		question.setVar(var);
		var.setName(ctx.varName().getText());
		
		return question;
	}
	
	public static Var<?> getVarInTree(String name, Node tree) {
		
		Var<?> var = new Var<>();
		
		if (tree.getNodes().size() > 0) {
			
			for (int i=0; i<tree.getNodes().size(); i++) {
				
				if (tree.getNodes().get(i).getClass().equals(uva.TaxForm.AST.NodeQuestion.Question.class)) {
					
					Question<?> q = (Question<?>) tree.getNodes().get(i);
					
					if (q.getVar().getName().equals(name)) {
						
						var = (Var<?>) q.getVar();
					}
				}
				else {
					UtilsNode.getVarInTree(name, tree.getNodes().get(i));
				}
			}
		}
		
		return var;
	}
}
