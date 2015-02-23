package uva.ql.interpreter.typecheck;

import org.antlr.v4.runtime.ParserRuleContext;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.declarations.Declaration;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.parser.QLBaseVisitor;
import uva.ql.parser.QLParser.AssignExprContext;
import uva.ql.parser.QLParser.AssignStrContext;
import uva.ql.parser.QLParser.DeclContext;
import uva.ql.parser.QLParser.ExprContext;
import uva.ql.parser.QLParser.FormContext;
import uva.ql.parser.QLParser.IfStatementContext;
import uva.ql.parser.QLParser.LiteralContext;
import uva.ql.parser.QLParser.PrimitiveTypeContext;
import uva.ql.parser.QLParser.ProgContext;
import uva.ql.parser.QLParser.QuestContext;
import uva.ql.parser.QLParser.StatContext;
import uva.ql.ast.expressions.literals.*;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;

import java.util.*;

public class TypeCheck extends QLBaseVisitor <ASTNode> {
	
	public Map<String, String> smb = new LinkedHashMap <String,String>();
	
	private String id, type;
	@Override 
	public ASTNode visitQuest(QuestContext ctx) { 
		
		id=(ctx.Identifier().getText());
		type=(ctx.primitiveType().getText());
		System.out.println(id+":"+type);
		smb.put(id, type);
		return super.visitQuest(ctx);
	}
	
	//System.out.println(smb.toString());
	
}
