// Generated from E:\workspace2\qlProject\src\qlProject\grammar\qlGrammar.g4 by ANTLR 4.0
package qlProject.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qlGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, BOOL_TYPE=5, STRING_TYPE=6, INT_TYPE=7, 
		ADD=8, SUB=9, MUL=10, DIV=11, CONCAT=12, NOT=13, LT=14, GT=15, LEQ=16, 
		GEQ=17, EQ=18, NEQ=19, AND=20, OR=21, IF=22, ELSE=23, TRUE=24, FALSE=25, 
		ID=26, INT=27, STRING=28, COMMENT=29, MULTYLINE_COMMENT=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "')'", "'('", "'}'", "'boolean'", "'string'", "'integer'", 
		"'+'", "'-'", "'*'", "'/'", "'++'", "'!'", "'<'", "'>'", "'<='", "'>='", 
		"'=='", "'!='", "'&&'", "'||'", "'if'", "'else'", "'true'", "'false'", 
		"ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_statement = 1, RULE_type = 2, RULE_expr = 3;
	public static final String[] ruleNames = {
		"form", "statement", "type", "expr"
	};

	@Override
	public String getGrammarFileName() { return "qlGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public qlGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); statement();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicQuestionContext extends StatementContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(qlGrammarParser.STRING, 0); }
		public BasicQuestionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBasicQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComputedQuestionContext extends StatementContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(qlGrammarParser.STRING, 0); }
		public ComputedQuestionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitComputedQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalQuestionsListContext extends StatementContext {
		public StatementContext statement;
		public List<StatementContext> ifPart = new ArrayList<StatementContext>();
		public List<StatementContext> elsePart = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(qlGrammarParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(qlGrammarParser.IF, 0); }
		public ConditionalQuestionsListContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitConditionalQuestionsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new BasicQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13); match(ID);
				setState(14); match(STRING);
				setState(15); type();
				}
				break;

			case 2:
				_localctx = new ComputedQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16); match(ID);
				setState(17); match(STRING);
				setState(18); type();
				setState(19); match(3);
				setState(20); expr(0);
				setState(21); match(2);
				}
				break;

			case 3:
				_localctx = new ConditionalQuestionsListContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(23); match(IF);
				setState(24); match(3);
				setState(25); expr(0);
				setState(26); match(2);
				setState(27); match(1);
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(28); ((ConditionalQuestionsListContext)_localctx).statement = statement();
					((ConditionalQuestionsListContext)_localctx).ifPart.add(((ConditionalQuestionsListContext)_localctx).statement);
					}
					}
					setState(31); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==ID );
				setState(39);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(33); match(ELSE);
					setState(35); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(34); ((ConditionalQuestionsListContext)_localctx).statement = statement();
						((ConditionalQuestionsListContext)_localctx).elsePart.add(((ConditionalQuestionsListContext)_localctx).statement);
						}
						}
						setState(37); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==IF || _la==ID );
					}
				}

				setState(41); match(4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL_TYPE() { return getToken(qlGrammarParser.BOOL_TYPE, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT_TYPE() { return getToken(qlGrammarParser.INT_TYPE, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrTypeContext extends TypeContext {
		public TerminalNode STRING_TYPE() { return getToken(qlGrammarParser.STRING_TYPE, 0); }
		public StrTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitStrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case BOOL_TYPE:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(BOOL_TYPE);
				}
				break;
			case INT_TYPE:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46); match(INT_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(47); match(STRING_TYPE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class GreaterOrEqContext extends ExprContext {
		public TerminalNode GEQ() { return getToken(qlGrammarParser.GEQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public GreaterOrEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitGreaterOrEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateContext extends ExprContext {
		public TerminalNode SUB() { return getToken(qlGrammarParser.SUB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OR() { return getToken(qlGrammarParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends ExprContext {
		public TerminalNode EQ() { return getToken(qlGrammarParser.EQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public EqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ExprContext {
		public TerminalNode STRING() { return getToken(qlGrammarParser.STRING, 0); }
		public StringLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatenationExpressionContext extends ExprContext {
		public TerminalNode CONCAT() { return getToken(qlGrammarParser.CONCAT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ConcatenationExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitConcatenationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnequalContext extends ExprContext {
		public TerminalNode NEQ() { return getToken(qlGrammarParser.NEQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public UnequalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitUnequal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubtractContext extends ExprContext {
		public Token op;
		public TerminalNode SUB() { return getToken(qlGrammarParser.SUB, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode ADD() { return getToken(qlGrammarParser.ADD, 0); }
		public AddSubtractContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAddSubtract(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public TerminalNode AND() { return getToken(qlGrammarParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(qlGrammarParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessOrEqContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LEQ() { return getToken(qlGrammarParser.LEQ, 0); }
		public LessOrEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitLessOrEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyDivideContext extends ExprContext {
		public Token op;
		public TerminalNode DIV() { return getToken(qlGrammarParser.DIV, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(qlGrammarParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public MultiplyDivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitMultiplyDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ExprContext {
		public TerminalNode LT() { return getToken(qlGrammarParser.LT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public LessThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends ExprContext {
		public Token bLiteral;
		public TerminalNode FALSE() { return getToken(qlGrammarParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(qlGrammarParser.TRUE, 0); }
		public BoolLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ExprContext {
		public TerminalNode GT() { return getToken(qlGrammarParser.GT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public GreaterThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends ExprContext {
		public TerminalNode INT() { return getToken(qlGrammarParser.INT, 0); }
		public IntLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch (_input.LA(1)) {
			case SUB:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(51); match(SUB);
				setState(52); expr(18);
				}
				break;
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); match(NOT);
				setState(54); expr(15);
				}
				break;
			case INT:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55); match(INT);
				}
				break;
			case TRUE:
			case FALSE:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				((BoolLiteralContext)_localctx).bLiteral = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((BoolLiteralContext)_localctx).bLiteral = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57); match(STRING);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58); match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(3);
				setState(60); expr(0);
				setState(61); match(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(98);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyDivideContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(66);
						((MultiplyDivideContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MultiplyDivideContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(67); expr(18);
						}
						break;

					case 2:
						{
						_localctx = new AddSubtractContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(69);
						((AddSubtractContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubtractContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(70); expr(17);
						}
						break;

					case 3:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(72); match(AND);
						setState(73); expr(15);
						}
						break;

					case 4:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(75); match(OR);
						setState(76); expr(14);
						}
						break;

					case 5:
						{
						_localctx = new GreaterThanContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(78); match(GT);
						setState(79); expr(13);
						}
						break;

					case 6:
						{
						_localctx = new GreaterOrEqContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(81); match(GEQ);
						setState(82); expr(12);
						}
						break;

					case 7:
						{
						_localctx = new LessThanContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(84); match(LT);
						setState(85); expr(11);
						}
						break;

					case 8:
						{
						_localctx = new LessOrEqContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(87); match(LEQ);
						setState(88); expr(10);
						}
						break;

					case 9:
						{
						_localctx = new EqualContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(90); match(EQ);
						setState(91); expr(9);
						}
						break;

					case 10:
						{
						_localctx = new UnequalContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(93); match(NEQ);
						setState(94); expr(8);
						}
						break;

					case 11:
						{
						_localctx = new ConcatenationExpressionContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(96); match(CONCAT);
						setState(97); expr(7);
						}
						break;
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 17 >= _localctx._p;

		case 1: return 16 >= _localctx._p;

		case 2: return 14 >= _localctx._p;

		case 3: return 13 >= _localctx._p;

		case 4: return 12 >= _localctx._p;

		case 5: return 11 >= _localctx._p;

		case 6: return 10 >= _localctx._p;

		case 7: return 9 >= _localctx._p;

		case 8: return 8 >= _localctx._p;

		case 9: return 7 >= _localctx._p;

		case 10: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3!j\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3 \n\3\r"+
		"\3\16\3!\3\3\3\3\6\3&\n\3\r\3\16\3\'\5\3*\n\3\3\3\3\3\5\3.\n\3\3\4\3\4"+
		"\3\4\5\4\63\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5B\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5e\n\5\f\5\16\5h\13\5\3\5\2\6\2\4\6\b\2\5\3\32\33\3\f\r\3\n\13~\2\13"+
		"\3\2\2\2\4-\3\2\2\2\6\62\3\2\2\2\bA\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f"+
		"\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\20\7\34\2\2\20\21"+
		"\7\36\2\2\21.\5\6\4\2\22\23\7\34\2\2\23\24\7\36\2\2\24\25\5\6\4\2\25\26"+
		"\7\5\2\2\26\27\5\b\5\2\27\30\7\4\2\2\30.\3\2\2\2\31\32\7\30\2\2\32\33"+
		"\7\5\2\2\33\34\5\b\5\2\34\35\7\4\2\2\35\37\7\3\2\2\36 \5\4\3\2\37\36\3"+
		"\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\")\3\2\2\2#%\7\31\2\2$&\5\4\3"+
		"\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)#\3\2\2\2)*\3"+
		"\2\2\2*+\3\2\2\2+,\7\6\2\2,.\3\2\2\2-\17\3\2\2\2-\22\3\2\2\2-\31\3\2\2"+
		"\2.\5\3\2\2\2/\63\7\7\2\2\60\63\7\t\2\2\61\63\7\b\2\2\62/\3\2\2\2\62\60"+
		"\3\2\2\2\62\61\3\2\2\2\63\7\3\2\2\2\64\65\b\5\1\2\65\66\7\13\2\2\66B\5"+
		"\b\5\2\678\7\17\2\28B\5\b\5\29B\7\35\2\2:B\t\2\2\2;B\7\36\2\2<B\7\34\2"+
		"\2=>\7\5\2\2>?\5\b\5\2?@\7\4\2\2@B\3\2\2\2A\64\3\2\2\2A\67\3\2\2\2A9\3"+
		"\2\2\2A:\3\2\2\2A;\3\2\2\2A<\3\2\2\2A=\3\2\2\2Bf\3\2\2\2CD\6\5\2\3DE\t"+
		"\3\2\2Ee\5\b\5\2FG\6\5\3\3GH\t\4\2\2He\5\b\5\2IJ\6\5\4\3JK\7\26\2\2Ke"+
		"\5\b\5\2LM\6\5\5\3MN\7\27\2\2Ne\5\b\5\2OP\6\5\6\3PQ\7\21\2\2Qe\5\b\5\2"+
		"RS\6\5\7\3ST\7\23\2\2Te\5\b\5\2UV\6\5\b\3VW\7\20\2\2We\5\b\5\2XY\6\5\t"+
		"\3YZ\7\22\2\2Ze\5\b\5\2[\\\6\5\n\3\\]\7\24\2\2]e\5\b\5\2^_\6\5\13\3_`"+
		"\7\25\2\2`e\5\b\5\2ab\6\5\f\3bc\7\16\2\2ce\5\b\5\2dC\3\2\2\2dF\3\2\2\2"+
		"dI\3\2\2\2dL\3\2\2\2dO\3\2\2\2dR\3\2\2\2dU\3\2\2\2dX\3\2\2\2d[\3\2\2\2"+
		"d^\3\2\2\2da\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\t\3\2\2\2hf\3\2\2"+
		"\2\13\r!\')-\62Adf";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}