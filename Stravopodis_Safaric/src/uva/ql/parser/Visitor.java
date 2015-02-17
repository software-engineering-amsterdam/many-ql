package uva.ql.parser;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

import uva.ql.ast.Form;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.parser.QLParser.AssignContext;
import uva.ql.parser.QLParser.DeclContext;
import uva.ql.parser.QLParser.ExprContext;
import uva.ql.parser.QLParser.IfStatementContext;
import uva.ql.parser.QLParser.LiteralContext;
import uva.ql.parser.QLParser.PrimitiveTypeContext;
import uva.ql.parser.QLParser.ProgContext;
import uva.ql.parser.QLParser.QuestContext;
import uva.ql.parser.QLParser.Quest_declContext;
import uva.ql.parser.QLParser.QuestionTypeContext;
import uva.ql.parser.QLParser.StatContext;
import uva.ql.parser.QLParser.TypeofContext;

import java.util.*;
public class Visitor extends QLBaseVisitor <Object> {
	
	
	@Override
	public Object visitProg(QLParser.ProgContext ctx) {
		System.out.println ("Prog Name:"+ ctx.getText());
		return super.visitProg(ctx);
	}

	@Override
	public Object visitForm(QLParser.FormContext ctx){
		//System.out.println ("Form Name:"+ ctx.getText());
		Identifier Id = new Identifier(ctx.title.getText());
		List <StatContext> text = ctx.sts;
		List <Statement> states = new ArrayList<Statement>();
		for (StatContext context : text){
			states.add((Statement)visitStat(context));
			
			
		}
		Form form = new Form(Id,states);
		
		//List <Statement> states = Arrays.asList(ctx.stat());
		//Collections.addAll(states, '+', '-', '*', '^');
		//System.out.println (Id);
		//System.out.println (text);
		//Form form = new Form (id,states);
		return super.visitForm(ctx);
	
	}
	
	@Override
	public Object visitQuest(QLParser.QuestContext ctx) {
		//System.out.println ("Question:" + ctx.getText());
		//Form form = new Form (ctx);
		String id = ctx.ID().getText();
		//System.out.println (id);
		return super.visitQuest(ctx);
	}
	
	
	@Override
	public Object visitStat(QLParser.StatContext ctx) {
		System.out.println ("Statement Name:"+ ctx.getText());
		return super.visitStat(ctx); //fix to return statement
	}
	/*
	@Override
	public Object visitQuestionType(QuestionTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

	
	

	

	@Override
	public Object visitStat(StatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitQuest_decl(Quest_declContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDecl(DeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAssign(AssignContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPrimitiveType(PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTypeof(TypeofContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
	*/
	
	//@Override public T visitIfStatement(@NotNull XParser.IfStatementContext ctx) { return visitChildren(ctx); }

}
	
