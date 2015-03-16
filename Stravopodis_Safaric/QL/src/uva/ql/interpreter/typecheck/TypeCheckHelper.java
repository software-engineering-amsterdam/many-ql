package uva.ql.interpreter.typecheck;

import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.Type;
import uva.ql.interpreter.typecheck.table.LabelTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;

public class TypeCheckHelper {

	/*
	 * public static functions supporting the TypeCheckVisitor
	 */
	
	public static boolean isDuplicateQuestionSameType(Question question, SymbolTable symbolTable){
		
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		Type questionType = question.getQuestionType();
		
		return symbolTable.valueExists(questionIdentifier, questionType);
	}
	
	public static boolean isDuplicateQuestionDifferentType(Question question, SymbolTable symbolTable){
		
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		Type questionType = question.getQuestionType();
		
		if (symbolTable.keyExists(questionIdentifier)){
			return !symbolTable.retrieveValue(questionIdentifier).equals(questionType);
		}
		
		return false;
	}
	
	public static boolean referenceToUndefinedQuestion(Identifier identifier, SymbolTable symbolTable){
		return !symbolTable.keyExists(identifier.evaluate().getValue());
	}
	
	public static boolean operandCompatabilityCheck(Expression left, Expression right, List<Type> supportedTypes){
		return TypeHelper.expressionOfType(left, supportedTypes) && TypeHelper.expressionOfType(right, supportedTypes);
	}
	
	public static boolean duplicateLabelCheck(Question question, LabelTable labelTable){
		return labelTable.keyExists(question.getQuestionLabel().evaluate().getValue().replaceAll("\\s+",""));
	}
	
}
