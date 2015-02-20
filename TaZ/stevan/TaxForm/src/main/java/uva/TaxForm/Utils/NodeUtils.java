package uva.TaxForm.Utils;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeQuestion;
import uva.TaxForm.AST.NodeVar;

public class NodeUtils {

	/*public static void visitChildren(uva.TaxForm.CommonTaxFormVisitor ctx, Node node) {
		
		ctx.visit(tree)
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//System.out.println(ctx.getChild(i).getClass().getCanonicalName());
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				this.visitQuestion((QuestionContext) ctx.getChild(i), condition);
			}
			//IfConditionContext
			else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				this.visitIfCondition((IfConditionContext) ctx.getChild(i), condition);
			}
		}
	}*/
	
	public static NodeVar getVarInTree(String name, Node tree) {
		
		NodeVar returnNode = new NodeVar();
		
		for (int i=0; i<tree.getNodes().size(); i++) {
			
			if (tree.getNodes().get(i).getClass().equals(uva.TaxForm.AST.NodeQuestion.class)) {
				
				//System.out.println(tree.getNodes().get(i).getClass());
				NodeQuestion nodeQ = (NodeQuestion) tree.getNodes().get(i);
				
				if (name.equals(nodeQ.getName())) {
					System.out.println("getName: " + nodeQ.getName());
					System.out.println("getVar: " + nodeQ.getVar());
					returnNode = nodeQ.getVar();
				}
			}
			else {
				//System.out.println(tree.getNodes().get(i).getClass());
				NodeUtils.getVarInTree(name, tree.getNodes().get(i));
			}
		}
		return returnNode;
	}
}
