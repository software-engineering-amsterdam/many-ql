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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, QuestionLiteral=16, 
		BooleanLiteral=17, WS=18, ID=19, ID_LETTER=20, INT=21, FLOAT=22, CURRENCY=23, 
		STRING=24, LINE_COMMENT=25, COMMENT=26, MUL=27, DIV=28, ADD=29, SUB=30, 
		LP=31, RP=32, LC=33, RC=34, LESS=35, LESS_EQUAL=36, GREATER=37, GREATER_EQUAL=38, 
		EQUAL=39, LOG_AND=40, LOG_OR=41, NOT_EQUAL=42, NL=43, EXP=44;
	public static final int
		RULE_prog = 0, RULE_form = 1, RULE_quest = 2, RULE_stat = 3, RULE_quest_decl = 4, 
		RULE_decl = 5, RULE_assign = 6, RULE_expr = 7, RULE_ifStatement = 8, RULE_literal = 9, 
		RULE_primitiveType = 10, RULE_typeof = 11, RULE_questionType = 12;
	public static final String[] ruleNames = {
		"prog", "form", "quest", "stat", "quest_decl", "decl", "assign", "expr", 
		"ifStatement", "literal", "primitiveType", "typeof", "questionType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "'='", "';'", "'.'", "'value'", "'if'", 
		"'(-'", "'boolean'", "'float'", "'currency'", "'string'", "'int'", "'typeof'", 
		"'questionType'", null, null, null, null, null, null, null, null, null, 
		null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "QuestionLiteral", "BooleanLiteral", "WS", "ID", 
		"ID_LETTER", "INT", "FLOAT", "CURRENCY", "STRING", "LINE_COMMENT", "COMMENT", 
		"MUL", "DIV", "ADD", "SUB", "LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", 
		"GREATER", "GREATER_EQUAL", "EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", 
		"NL", "EXP"
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
			setState(26);
			form();
			setState(27);
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
		public Token title;
		public StatContext stat;
		public List<StatContext> sts = new ArrayList<StatContext>();
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
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
			setState(29);
			match(T__0);
			setState(30);
			((FormContext)_localctx).title = match(ID);
			setState(31);
			match(LC);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << BooleanLiteral) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CURRENCY) | (1L << LP))) != 0)) {
				{
				{
				setState(32);
				((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).sts.add(((FormContext)_localctx).stat);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public TypeofContext typeof() {
			return getRuleContext(TypeofContext.class,0);
		}
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
			setState(40);
			match(T__1);
			setState(41);
			match(ID);
			setState(42);
			typeof();
			setState(43);
			primitiveType();
			setState(44);
			match(LC);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << BooleanLiteral) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CURRENCY) | (1L << LP))) != 0)) {
				{
				{
				setState(45);
				stat();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public Quest_declContext quest_decl() {
			return getRuleContext(Quest_declContext.class,0);
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
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				quest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				quest_decl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
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

	public static class Quest_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public TerminalNode QuestionLiteral() { return getToken(QLParser.QuestionLiteral, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Quest_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuest_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quest_declContext quest_decl() throws RecognitionException {
		Quest_declContext _localctx = new Quest_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quest_decl);
		try {
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(ID);
				setState(62);
				match(T__2);
				setState(63);
				match(STRING);
				setState(64);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(ID);
				setState(66);
				match(T__4);
				setState(67);
				questionType();
				setState(68);
				match(T__2);
				setState(69);
				match(QuestionLiteral);
				setState(70);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(ID);
				setState(73);
				match(T__4);
				setState(74);
				match(T__5);
				setState(75);
				match(T__2);
				setState(76);
				expr(0);
				setState(77);
				match(T__3);
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

	public static class DeclContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			primitiveType();
			setState(82);
			match(ID);
			setState(84);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(83);
				match(T__2);
				}
			}

			setState(87);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << BooleanLiteral) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CURRENCY) | (1L << LP))) != 0)) {
				{
				setState(86);
				expr(0);
				}
			}

			setState(89);
			match(T__3);
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
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
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
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ID);
			setState(92);
			match(T__2);
			setState(93);
			expr(0);
			setState(94);
			match(T__3);
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
		public Expression result;
		public ExprContext x;
		public Token op;
		public ExprContext y;
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			switch (_input.LA(1)) {
			case LP:
				{
				setState(97);
				match(LP);
				setState(98);
				((ExprContext)_localctx).x = expr(0);
				setState(99);
				match(RP);
				}
				break;
			case T__7:
			case BooleanLiteral:
			case ID:
			case INT:
			case FLOAT:
			case CURRENCY:
				{
				setState(101);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(139);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						((ExprContext)_localctx).op = match(EXP);
						setState(106);
						((ExprContext)_localctx).y = expr(10);

						          									((ExprContext)_localctx).result =  (new Exponentiation(((ExprContext)_localctx).x.result,((ExprContext)_localctx).y.result));
						          								
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(110);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(111);
						((ExprContext)_localctx).y = expr(9);

						          									if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == MUL)
						          									((ExprContext)_localctx).result =  (new Multiplication(((ExprContext)_localctx).x.result,((ExprContext)_localctx).y.result));
						          									else
						          									((ExprContext)_localctx).result =  (new Division(((ExprContext)_localctx).x.result,((ExprContext)_localctx).y.result));
						          								
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(115);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(116);
						((ExprContext)_localctx).y = expr(8);

						          									if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == ADD)
						          									((ExprContext)_localctx).result =  (new Addition(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result));
						          									else
						          									((ExprContext)_localctx).result =  (new Substraction(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result));
						          								
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(120);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESS_EQUAL) | (1L << GREATER) | (1L << GREATER_EQUAL))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(121);
						((ExprContext)_localctx).y = expr(7);

						          									switch((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0)){
						          										case LESS: 			((ExprContext)_localctx).result =  (new Less(((ExprContext)_localctx).x.result,((ExprContext)_localctx).y.result,((ExprContext)_localctx).op.getText()));
						          										case LESS_EQUAL:	((ExprContext)_localctx).result =  (new Less_Eq(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          										case GREATER:		((ExprContext)_localctx).result =  (new Greater(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          										case GREATER_EQUAL: ((ExprContext)_localctx).result =  (new Greater_Eq(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          									}
						          								
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(126);
						((ExprContext)_localctx).y = expr(6);

						          									if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == EQUAL)
						          									((ExprContext)_localctx).result =  (new Equal(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          									else
						          									((ExprContext)_localctx).result =  (new NotEqual(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          								
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(130);
						((ExprContext)_localctx).op = match(LOG_AND);
						setState(131);
						((ExprContext)_localctx).y = expr(5);

						          									((ExprContext)_localctx).result =  (new And(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          								
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((ExprContext)_localctx).op = match(LOG_OR);
						setState(136);
						((ExprContext)_localctx).y = expr(4);

						          									((ExprContext)_localctx).result =  (new Or(((ExprContext)_localctx).x.result, ((ExprContext)_localctx).y.result, ((ExprContext)_localctx).op.getText()));
						          								
						}
						break;
					}
					} 
				}
				setState(143);
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

	public static class IfStatementContext extends ParserRuleContext {
		public Token ifThen;
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
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			((IfStatementContext)_localctx).ifThen = match(T__6);
			setState(145);
			match(LP);
			setState(146);
			expr(0);
			setState(147);
			match(RP);
			setState(148);
			match(LC);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << BooleanLiteral) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CURRENCY) | (1L << LP))) != 0)) {
				{
				{
				setState(149);
				stat();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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
		public TerminalNode INT() { return getToken(QLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QLParser.FLOAT, 0); }
		public TerminalNode CURRENCY() { return getToken(QLParser.CURRENCY, 0); }
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
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
		enterRule(_localctx, 18, RULE_literal);
		try {
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(BooleanLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				switch (_input.LA(1)) {
				case INT:
					{
					setState(158);
					match(INT);
					}
					break;
				case T__7:
					{
					{
					setState(159);
					match(T__7);
					setState(160);
					match(INT);
					setState(161);
					match(RP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				switch (_input.LA(1)) {
				case FLOAT:
					{
					setState(164);
					match(FLOAT);
					}
					break;
				case T__7:
					{
					{
					setState(165);
					match(T__7);
					setState(166);
					match(FLOAT);
					setState(167);
					match(RP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				switch (_input.LA(1)) {
				case CURRENCY:
					{
					setState(170);
					match(CURRENCY);
					}
					break;
				case T__7:
					{
					{
					setState(171);
					match(T__7);
					setState(172);
					match(CURRENCY);
					setState(173);
					match(RP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match(ID);
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
		enterRule(_localctx, 20, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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

	public static class TypeofContext extends ParserRuleContext {
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitTypeof(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__13);
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

	public static class QuestionTypeContext extends ParserRuleContext {
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_questionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__14);
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
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3$\n\3\f\3"+
		"\16\3\'\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4\64\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\7\3\7\3\7\5"+
		"\7W\n\7\3\7\5\7Z\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\ti\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\7\t\u008e\n\t\f\t\16\t\u0091\13\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u0099\n\n\f\n\16\n\u009c\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u00a5\n\13\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00b1\n\13\3\13\5\13\u00b4\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2"+
		"\3\20\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\7\3\2\35\36\3\2\37 \3\2%("+
		"\4\2)),,\3\2\13\17\u00c9\2\34\3\2\2\2\4\37\3\2\2\2\6*\3\2\2\2\b=\3\2\2"+
		"\2\nQ\3\2\2\2\fS\3\2\2\2\16]\3\2\2\2\20h\3\2\2\2\22\u0092\3\2\2\2\24\u00b3"+
		"\3\2\2\2\26\u00b5\3\2\2\2\30\u00b7\3\2\2\2\32\u00b9\3\2\2\2\34\35\5\4"+
		"\3\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \7\3\2\2 !\7\25\2\2!%\7#\2\2\"$\5\b"+
		"\5\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()"+
		"\7$\2\2)\5\3\2\2\2*+\7\4\2\2+,\7\25\2\2,-\5\30\r\2-.\5\26\f\2.\62\7#\2"+
		"\2/\61\5\b\5\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\65\3\2\2\2\64\62\3\2\2\2\65\66\7$\2\2\66\7\3\2\2\2\67>\5\6\4\28>\5\f"+
		"\7\29>\5\20\t\2:>\5\22\n\2;>\5\n\6\2<>\5\16\b\2=\67\3\2\2\2=8\3\2\2\2"+
		"=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\t\3\2\2\2?@\7\25\2\2@A\7\5\2"+
		"\2AB\7\32\2\2BR\7\6\2\2CD\7\25\2\2DE\7\7\2\2EF\5\32\16\2FG\7\5\2\2GH\7"+
		"\22\2\2HI\7\6\2\2IR\3\2\2\2JK\7\25\2\2KL\7\7\2\2LM\7\b\2\2MN\7\5\2\2N"+
		"O\5\20\t\2OP\7\6\2\2PR\3\2\2\2Q?\3\2\2\2QC\3\2\2\2QJ\3\2\2\2R\13\3\2\2"+
		"\2ST\5\26\f\2TV\7\25\2\2UW\7\5\2\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2XZ\5\20"+
		"\t\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\6\2\2\\\r\3\2\2\2]^\7\25\2\2^"+
		"_\7\5\2\2_`\5\20\t\2`a\7\6\2\2a\17\3\2\2\2bc\b\t\1\2cd\7!\2\2de\5\20\t"+
		"\2ef\7\"\2\2fi\3\2\2\2gi\5\24\13\2hb\3\2\2\2hg\3\2\2\2i\u008f\3\2\2\2"+
		"jk\f\13\2\2kl\7.\2\2lm\5\20\t\fmn\b\t\1\2n\u008e\3\2\2\2op\f\n\2\2pq\t"+
		"\2\2\2qr\5\20\t\13rs\b\t\1\2s\u008e\3\2\2\2tu\f\t\2\2uv\t\3\2\2vw\5\20"+
		"\t\nwx\b\t\1\2x\u008e\3\2\2\2yz\f\b\2\2z{\t\4\2\2{|\5\20\t\t|}\b\t\1\2"+
		"}\u008e\3\2\2\2~\177\f\7\2\2\177\u0080\t\5\2\2\u0080\u0081\5\20\t\b\u0081"+
		"\u0082\b\t\1\2\u0082\u008e\3\2\2\2\u0083\u0084\f\6\2\2\u0084\u0085\7*"+
		"\2\2\u0085\u0086\5\20\t\7\u0086\u0087\b\t\1\2\u0087\u008e\3\2\2\2\u0088"+
		"\u0089\f\5\2\2\u0089\u008a\7+\2\2\u008a\u008b\5\20\t\6\u008b\u008c\b\t"+
		"\1\2\u008c\u008e\3\2\2\2\u008dj\3\2\2\2\u008do\3\2\2\2\u008dt\3\2\2\2"+
		"\u008dy\3\2\2\2\u008d~\3\2\2\2\u008d\u0083\3\2\2\2\u008d\u0088\3\2\2\2"+
		"\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\21"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\t\2\2\u0093\u0094\7!\2\2\u0094"+
		"\u0095\5\20\t\2\u0095\u0096\7\"\2\2\u0096\u009a\7#\2\2\u0097\u0099\5\b"+
		"\5\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7$"+
		"\2\2\u009e\23\3\2\2\2\u009f\u00b4\7\23\2\2\u00a0\u00a5\7\27\2\2\u00a1"+
		"\u00a2\7\n\2\2\u00a2\u00a3\7\27\2\2\u00a3\u00a5\7\"\2\2\u00a4\u00a0\3"+
		"\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\u00b4\3\2\2\2\u00a6\u00ab\7\30\2\2\u00a7"+
		"\u00a8\7\n\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00ab\7\"\2\2\u00aa\u00a6\3"+
		"\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00b4\3\2\2\2\u00ac\u00b1\7\31\2\2\u00ad"+
		"\u00ae\7\n\2\2\u00ae\u00af\7\31\2\2\u00af\u00b1\7\"\2\2\u00b0\u00ac\3"+
		"\2\2\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b4\7\25\2\2\u00b3"+
		"\u009f\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b3\u00aa\3\2\2\2\u00b3\u00b0\3\2"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b4\25\3\2\2\2\u00b5\u00b6\t\6\2\2\u00b6\27"+
		"\3\2\2\2\u00b7\u00b8\7\20\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\7\21\2\2\u00ba"+
		"\33\3\2\2\2\20%\62=QVYh\u008d\u008f\u009a\u00a4\u00aa\u00b0\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}