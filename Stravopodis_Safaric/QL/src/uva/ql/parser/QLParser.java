// Generated from QL.g4 by ANTLR 4.5

	package uva.ql.parser;
	import uva.ql.ast.expressions.*;
	import uva.ql.ast.expressions.literals.*;
	import uva.ql.ast.expressions.math.*;
	import uva.ql.ast.expressions.logic.*;
	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		BooleanLiteral=10, Identifier=11, Integer=12, Money=13, WS=14, ID_LETTER=15, 
		DIGIT=16, STRING=17, LINE_COMMENT=18, COMMENT=19, MUL=20, DIV=21, ADD=22, 
		SUB=23, LP=24, RP=25, LC=26, RC=27, LESS=28, LESS_EQUAL=29, GREATER=30, 
		GREATER_EQUAL=31, EQUAL=32, LOG_AND=33, LOG_OR=34, NOT_EQUAL=35, NL=36, 
		EXP=37;
	public static final int
		RULE_prog = 0, RULE_form = 1, RULE_quest = 2, RULE_stat = 3, RULE_assign = 4, 
		RULE_expr = 5, RULE_ifStatement = 6, RULE_literal = 7, RULE_primitiveType = 8;
	public static final String[] ruleNames = {
		"prog", "form", "quest", "stat", "assign", "expr", "ifStatement", "literal", 
		"primitiveType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "';'", "':'", "'if'", "'boolean'", "'money'", 
		"'string'", "'integer'", null, null, null, null, null, null, null, null, 
		null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "BooleanLiteral", 
		"Identifier", "Integer", "Money", "WS", "ID_LETTER", "DIGIT", "STRING", 
		"LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", "SUB", "LP", "RP", "LC", 
		"RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", "EQUAL", "LOG_AND", 
		"LOG_OR", "NOT_EQUAL", "NL", "EXP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public FormContext form() {
			return getRuleContext(FormContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QLParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			form();
			setState(19);
			match(EOF);
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

	public static class FormContext extends ParserRuleContext {
		public Token id;
		public StatContext stat;
		public List<StatContext> stms = new ArrayList<StatContext>();
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__0);
			setState(22);
			((FormContext)_localctx).id = match(Identifier);
			setState(23);
			match(LC);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Money) | (1L << LP))) != 0)) {
				{
				{
				setState(24);
				((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).stms.add(((FormContext)_localctx).stat);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(RC);
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

	public static class QuestContext extends ParserRuleContext {
		public QuestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest; }
	 
		public QuestContext() { }
		public void copyFrom(QuestContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComputedQuestionContext extends QuestContext {
		public Token id;
		public Token str;
		public AssignContext expression;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ComputedQuestionContext(QuestContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitComputedQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleQuestionContext extends QuestContext {
		public Token id;
		public Token str;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public SimpleQuestionContext(QuestContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSimpleQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_quest);
		try {
			setState(50);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SimpleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(T__1);
				setState(33);
				primitiveType();
				setState(34);
				((SimpleQuestionContext)_localctx).id = match(Identifier);
				setState(35);
				match(LP);
				setState(36);
				((SimpleQuestionContext)_localctx).str = match(STRING);
				setState(37);
				match(RP);
				setState(38);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new ComputedQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(T__1);
				setState(41);
				primitiveType();
				setState(42);
				((ComputedQuestionContext)_localctx).id = match(Identifier);
				setState(43);
				match(LP);
				setState(44);
				((ComputedQuestionContext)_localctx).str = match(STRING);
				setState(45);
				match(RP);
				setState(46);
				match(LC);
				setState(47);
				((ComputedQuestionContext)_localctx).expression = assign();
				setState(48);
				match(RC);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxAssignContext extends StatContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public CtxAssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxExpressionContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CtxExpressionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxIfStatementContext extends StatContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CtxIfStatementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxQuestionContext extends StatContext {
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public CtxQuestionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stat);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new CtxExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CtxQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				quest();
				}
				break;
			case 3:
				_localctx = new CtxIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				ifStatement();
				}
				break;
			case 4:
				_localctx = new CtxAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				assign();
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

	public static class AssignContext extends ParserRuleContext {
		public ExprContext exp;
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(Identifier);
			setState(59);
			match(T__3);
			setState(60);
			((AssignContext)_localctx).exp = expr(0);
			setState(61);
			match(T__2);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LessEqualGreaterEqualContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(QLParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(QLParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(QLParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(QLParser.GREATER_EQUAL, 0); }
		public LessEqualGreaterEqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitLessEqualGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExprContext {
		public ExprContext x;
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(QLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(QLParser.DIV, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(QLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(QLParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogOrContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOG_OR() { return getToken(QLParser.LOG_OR, 0); }
		public LogOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitLogOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLiteralContext extends ExprContext {
		public LiteralContext lit;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentiationContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EXP() { return getToken(QLParser.EXP, 0); }
		public ExponentiationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExponentiation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualNotContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(QLParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(QLParser.NOT_EQUAL, 0); }
		public EqualNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitEqualNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogAndContext extends ExprContext {
		public ExprContext x;
		public Token op;
		public ExprContext y;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOG_AND() { return getToken(QLParser.LOG_AND, 0); }
		public LogAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitLogAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			switch (_input.LA(1)) {
			case LP:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(64);
				match(LP);
				setState(65);
				((ParenthesisContext)_localctx).x = expr(0);
				setState(66);
				match(RP);
				}
				break;
			case BooleanLiteral:
			case Identifier:
			case Integer:
			case Money:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				((ExprLiteralContext)_localctx).lit = literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExponentiationContext(new ExprContext(_parentctx, _parentState));
						((ExponentiationContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(72);
						((ExponentiationContext)_localctx).op = match(EXP);
						setState(73);
						((ExponentiationContext)_localctx).y = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						((MulDivContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(75);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(76);
						((MulDivContext)_localctx).y = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						((AddSubContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(78);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(79);
						((AddSubContext)_localctx).y = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new LessEqualGreaterEqualContext(new ExprContext(_parentctx, _parentState));
						((LessEqualGreaterEqualContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(81);
						((LessEqualGreaterEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESS_EQUAL) | (1L << GREATER) | (1L << GREATER_EQUAL))) != 0)) ) {
							((LessEqualGreaterEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(82);
						((LessEqualGreaterEqualContext)_localctx).y = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualNotContext(new ExprContext(_parentctx, _parentState));
						((EqualNotContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(84);
						((EqualNotContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((EqualNotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(85);
						((EqualNotContext)_localctx).y = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new LogAndContext(new ExprContext(_parentctx, _parentState));
						((LogAndContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(87);
						((LogAndContext)_localctx).op = match(LOG_AND);
						setState(88);
						((LogAndContext)_localctx).y = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new LogOrContext(new ExprContext(_parentctx, _parentState));
						((LogOrContext)_localctx).x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(90);
						((LogOrContext)_localctx).op = match(LOG_OR);
						setState(91);
						((LogOrContext)_localctx).y = expr(3);
						}
						break;
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class IfStatementContext extends ParserRuleContext {
		public StatContext stat;
		public List<StatContext> stms = new ArrayList<StatContext>();
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__4);
			setState(98);
			match(LP);
			setState(99);
			expr(0);
			setState(100);
			match(RP);
			setState(101);
			match(LC);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Money) | (1L << LP))) != 0)) {
				{
				{
				setState(102);
				((IfStatementContext)_localctx).stat = stat();
				((IfStatementContext)_localctx).stms.add(((IfStatementContext)_localctx).stat);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(RC);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxIntLiteralContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(QLParser.Integer, 0); }
		public CtxIntLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxMoneyLiteralContext extends LiteralContext {
		public TerminalNode Money() { return getToken(QLParser.Money, 0); }
		public CtxMoneyLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxMoneyLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxBooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(QLParser.BooleanLiteral, 0); }
		public CtxBooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxIdentifierContext extends LiteralContext {
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public CtxIdentifierContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitCtxIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_literal);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				_localctx = new CtxBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(BooleanLiteral);
				}
				break;
			case Integer:
				_localctx = new CtxIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(Integer);
				}
				break;
			case Money:
				_localctx = new CtxMoneyLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(Money);
				}
				break;
			case Identifier:
				_localctx = new CtxIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(Identifier);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	 
		public PrimitiveTypeContext() { }
		public void copyFrom(PrimitiveTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntPrimitiveContext extends PrimitiveTypeContext {
		public IntPrimitiveContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIntPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoneyPrimitiveContext extends PrimitiveTypeContext {
		public MoneyPrimitiveContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitMoneyPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringPrimitiveContext extends PrimitiveTypeContext {
		public StringPrimitiveContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStringPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanPrimitiveContext extends PrimitiveTypeContext {
		public BooleanPrimitiveContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBooleanPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		try {
			setState(120);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new BooleanPrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new MoneyPrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new StringPrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new IntPrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(T__8);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\65\n\4\3\5"+
		"\3\5\3\5\3\5\5\5;\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"H\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\bj\n\b\f\b\16\bm\13\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tu\n\t\3\n\3\n\3\n\3"+
		"\n\5\n{\n\n\3\n\2\3\f\13\2\4\6\b\n\f\16\20\22\2\6\3\2\26\27\3\2\30\31"+
		"\3\2\36!\4\2\"\"%%\u0087\2\24\3\2\2\2\4\27\3\2\2\2\6\64\3\2\2\2\b:\3\2"+
		"\2\2\n<\3\2\2\2\fG\3\2\2\2\16c\3\2\2\2\20t\3\2\2\2\22z\3\2\2\2\24\25\5"+
		"\4\3\2\25\26\7\2\2\3\26\3\3\2\2\2\27\30\7\3\2\2\30\31\7\r\2\2\31\35\7"+
		"\34\2\2\32\34\5\b\5\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36"+
		"\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\35\2\2!\5\3\2\2\2\"#\7\4\2\2#$"+
		"\5\22\n\2$%\7\r\2\2%&\7\32\2\2&\'\7\23\2\2\'(\7\33\2\2()\7\5\2\2)\65\3"+
		"\2\2\2*+\7\4\2\2+,\5\22\n\2,-\7\r\2\2-.\7\32\2\2./\7\23\2\2/\60\7\33\2"+
		"\2\60\61\7\34\2\2\61\62\5\n\6\2\62\63\7\35\2\2\63\65\3\2\2\2\64\"\3\2"+
		"\2\2\64*\3\2\2\2\65\7\3\2\2\2\66;\5\f\7\2\67;\5\6\4\28;\5\16\b\29;\5\n"+
		"\6\2:\66\3\2\2\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\t\3\2\2\2<=\7\r\2\2"+
		"=>\7\6\2\2>?\5\f\7\2?@\7\5\2\2@\13\3\2\2\2AB\b\7\1\2BC\7\32\2\2CD\5\f"+
		"\7\2DE\7\33\2\2EH\3\2\2\2FH\5\20\t\2GA\3\2\2\2GF\3\2\2\2H`\3\2\2\2IJ\f"+
		"\n\2\2JK\7\'\2\2K_\5\f\7\13LM\f\t\2\2MN\t\2\2\2N_\5\f\7\nOP\f\b\2\2PQ"+
		"\t\3\2\2Q_\5\f\7\tRS\f\7\2\2ST\t\4\2\2T_\5\f\7\bUV\f\6\2\2VW\t\5\2\2W"+
		"_\5\f\7\7XY\f\5\2\2YZ\7#\2\2Z_\5\f\7\6[\\\f\4\2\2\\]\7$\2\2]_\5\f\7\5"+
		"^I\3\2\2\2^L\3\2\2\2^O\3\2\2\2^R\3\2\2\2^U\3\2\2\2^X\3\2\2\2^[\3\2\2\2"+
		"_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\r\3\2\2\2b`\3\2\2\2cd\7\7\2\2de\7\32\2"+
		"\2ef\5\f\7\2fg\7\33\2\2gk\7\34\2\2hj\5\b\5\2ih\3\2\2\2jm\3\2\2\2ki\3\2"+
		"\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\35\2\2o\17\3\2\2\2pu\7\f\2\2qu"+
		"\7\16\2\2ru\7\17\2\2su\7\r\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2"+
		"u\21\3\2\2\2v{\7\b\2\2w{\7\t\2\2x{\7\n\2\2y{\7\13\2\2zv\3\2\2\2zw\3\2"+
		"\2\2zx\3\2\2\2zy\3\2\2\2{\23\3\2\2\2\13\35\64:G^`ktz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}