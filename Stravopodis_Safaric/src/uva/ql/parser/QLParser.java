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
		T__9=10, QuestionLiteral=11, BooleanLiteral=12, Identifier=13, Integer=14, 
		Decimal=15, WS=16, ID_LETTER=17, DIGIT=18, STRING=19, LINE_COMMENT=20, 
		COMMENT=21, MUL=22, DIV=23, ADD=24, SUB=25, LP=26, RP=27, LC=28, RC=29, 
		LESS=30, LESS_EQUAL=31, GREATER=32, GREATER_EQUAL=33, EQUAL=34, LOG_AND=35, 
		LOG_OR=36, NOT_EQUAL=37, NL=38, EXP=39;
	public static final int
		RULE_prog = 0, RULE_form = 1, RULE_quest = 2, RULE_stat = 3, RULE_assign = 4, 
		RULE_expr = 5, RULE_ifStatement = 6, RULE_literal = 7, RULE_primitiveType = 8;
	public static final String[] ruleNames = {
		"prog", "form", "quest", "stat", "assign", "expr", "ifStatement", "literal", 
		"primitiveType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "'typeof'", "'='", "';'", "'if'", "'boolean'", 
		"'decimal'", "'string'", "'int'", null, null, null, null, null, null, 
		null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", 
		"'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", 
		null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "QuestionLiteral", 
		"BooleanLiteral", "Identifier", "Integer", "Decimal", "WS", "ID_LETTER", 
		"DIGIT", "STRING", "LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", "SUB", 
		"LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", 
		"EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", "NL", "EXP"
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
			match(Identifier);
			setState(23);
			match(LC);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Decimal) | (1L << LP))) != 0)) {
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
		public StatContext stat;
		public List<StatContext> stms = new ArrayList<StatContext>();
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public QuestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__1);
			setState(33);
			match(Identifier);
			setState(34);
			match(T__2);
			setState(35);
			primitiveType();
			setState(36);
			match(LC);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Decimal) | (1L << LP))) != 0)) {
				{
				{
				setState(37);
				((QuestContext)_localctx).stat = stat();
				((QuestContext)_localctx).stms.add(((QuestContext)_localctx).stat);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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

	public static class StatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stat);
		try {
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				quest();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
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
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignStrContext extends AssignContext {
		public Token str;
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public AssignStrContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAssignStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends AssignContext {
		public ExprContext exp;
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignExprContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(Identifier);
				setState(52);
				match(T__3);
				setState(53);
				((AssignExprContext)_localctx).exp = expr(0);
				setState(54);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new AssignStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(Identifier);
				setState(57);
				match(T__3);
				setState(58);
				((AssignStrContext)_localctx).str = match(STRING);
				setState(59);
				match(T__4);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext x;
		public LiteralContext lit;
		public Token op;
		public ExprContext y;
		public TerminalNode LP() { return getToken(QLParser.LP, 0); }
		public TerminalNode RP() { return getToken(QLParser.RP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode EXP() { return getToken(QLParser.EXP, 0); }
		public TerminalNode MUL() { return getToken(QLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(QLParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(QLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(QLParser.SUB, 0); }
		public TerminalNode LESS() { return getToken(QLParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(QLParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(QLParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(QLParser.GREATER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(QLParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(QLParser.NOT_EQUAL, 0); }
		public TerminalNode LOG_AND() { return getToken(QLParser.LOG_AND, 0); }
		public TerminalNode LOG_OR() { return getToken(QLParser.LOG_OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(68);
			switch (_input.LA(1)) {
			case LP:
				{
				setState(63);
				match(LP);
				setState(64);
				((ExprContext)_localctx).x = expr(0);
				setState(65);
				match(RP);
				}
				break;
			case BooleanLiteral:
			case Identifier:
			case Integer:
			case Decimal:
				{
				setState(67);
				((ExprContext)_localctx).lit = literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(91);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(71);
						((ExprContext)_localctx).op = match(EXP);
						setState(72);
						((ExprContext)_localctx).y = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(74);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(75);
						((ExprContext)_localctx).y = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(77);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(78);
						((ExprContext)_localctx).y = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(80);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESS_EQUAL) | (1L << GREATER) | (1L << GREATER_EQUAL))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(81);
						((ExprContext)_localctx).y = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(83);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(84);
						((ExprContext)_localctx).y = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(86);
						((ExprContext)_localctx).op = match(LOG_AND);
						setState(87);
						((ExprContext)_localctx).y = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(89);
						((ExprContext)_localctx).op = match(LOG_OR);
						setState(90);
						((ExprContext)_localctx).y = expr(3);
						}
						break;
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(96);
			match(T__5);
			setState(97);
			match(LP);
			setState(98);
			expr(0);
			setState(99);
			match(RP);
			setState(100);
			match(LC);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Decimal) | (1L << LP))) != 0)) {
				{
				{
				setState(101);
				((IfStatementContext)_localctx).stat = stat();
				((IfStatementContext)_localctx).stms.add(((IfStatementContext)_localctx).stat);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
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
		public TerminalNode BooleanLiteral() { return getToken(QLParser.BooleanLiteral, 0); }
		public TerminalNode Integer() { return getToken(QLParser.Integer, 0); }
		public TerminalNode Decimal() { return getToken(QLParser.Decimal, 0); }
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Identifier) | (1L << Integer) | (1L << Decimal))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)t\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\64\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7G\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bi"+
		"\n\b\f\b\16\bl\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\3\f\13\2\4\6\b\n\f\16"+
		"\20\22\2\b\3\2\30\31\3\2\32\33\3\2 #\4\2$$\'\'\3\2\16\21\3\2\t\fy\2\24"+
		"\3\2\2\2\4\27\3\2\2\2\6\"\3\2\2\2\b\63\3\2\2\2\n>\3\2\2\2\fF\3\2\2\2\16"+
		"b\3\2\2\2\20o\3\2\2\2\22q\3\2\2\2\24\25\5\4\3\2\25\26\7\2\2\3\26\3\3\2"+
		"\2\2\27\30\7\3\2\2\30\31\7\17\2\2\31\35\7\36\2\2\32\34\5\b\5\2\33\32\3"+
		"\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2"+
		"\2\2 !\7\37\2\2!\5\3\2\2\2\"#\7\4\2\2#$\7\17\2\2$%\7\5\2\2%&\5\22\n\2"+
		"&*\7\36\2\2\')\5\b\5\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2"+
		"\2\2,*\3\2\2\2-.\7\37\2\2.\7\3\2\2\2/\64\5\f\7\2\60\64\5\6\4\2\61\64\5"+
		"\16\b\2\62\64\5\n\6\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3"+
		"\2\2\2\64\t\3\2\2\2\65\66\7\17\2\2\66\67\7\6\2\2\678\5\f\7\289\7\7\2\2"+
		"9?\3\2\2\2:;\7\17\2\2;<\7\6\2\2<=\7\25\2\2=?\7\7\2\2>\65\3\2\2\2>:\3\2"+
		"\2\2?\13\3\2\2\2@A\b\7\1\2AB\7\34\2\2BC\5\f\7\2CD\7\35\2\2DG\3\2\2\2E"+
		"G\5\20\t\2F@\3\2\2\2FE\3\2\2\2G_\3\2\2\2HI\f\n\2\2IJ\7)\2\2J^\5\f\7\13"+
		"KL\f\t\2\2LM\t\2\2\2M^\5\f\7\nNO\f\b\2\2OP\t\3\2\2P^\5\f\7\tQR\f\7\2\2"+
		"RS\t\4\2\2S^\5\f\7\bTU\f\6\2\2UV\t\5\2\2V^\5\f\7\7WX\f\5\2\2XY\7%\2\2"+
		"Y^\5\f\7\6Z[\f\4\2\2[\\\7&\2\2\\^\5\f\7\5]H\3\2\2\2]K\3\2\2\2]N\3\2\2"+
		"\2]Q\3\2\2\2]T\3\2\2\2]W\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`\r\3\2\2\2a_\3\2\2\2bc\7\b\2\2cd\7\34\2\2de\5\f\7\2ef\7\35\2\2fj\7"+
		"\36\2\2gi\5\b\5\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj"+
		"\3\2\2\2mn\7\37\2\2n\17\3\2\2\2op\t\6\2\2p\21\3\2\2\2qr\t\7\2\2r\23\3"+
		"\2\2\2\n\35*\63>F]_j";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}