package AST;

import java.util.HashMap;
import java.util.Map;

import com.antlr4.zarina.tazql.Questions;
import com.antlr4.zarina.tazql.TaZQLBaseVisitor;

public class QuestionVisitor extends TaZQLBaseVisitor<Integer> {
	
	Map<String,	Integer> storage = new	HashMap <String, Integer>();
	Questions q = new Questions();
	
/*	
	@Override 
	public QuestionLabels visitQuestionLabel(@NotNull TaZQLParser.QuestionLabelContext ctx) { 
	// questionLabel : questionId NUMBER FILETEXT type;
		String questionId = ctx.questionId().getText(); //name for JLabel
		int number = new Integer(ctx.NUMBER().getText());  //not sure what I want to do with this number yet...
		String filetext = ctx.FILETEXT().getText(); // this reminds me that I should rename it... this is JLabel(text)
		
	//	q.addLabel(number, filetext);
		System.out.println("testing visitor ");
		return (new QuestionLabels(number, filetext)); 
		
	}
	*/
}