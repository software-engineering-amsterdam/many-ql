// Generated from F:/UvA/SE/Software Construction/many-ql/kennedy-langlotz/KLQ/src\KLQ.g4 by ANTLR 4.5
package com.klq.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KLQParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, QUESTION=4, END=5, ID=6, TEXT=7, TYPE=8, VALUE=9, 
		BOOLEAN=10, DATE=11, STRING=12, NUMERAL=13, IF=14, THEN=15, ADD=16, SUB=17, 
		MUL=18, DIV=19, GT=20, LT=21, GE=22, LE=23, EQ=24, NEQ=25, AND=26, OR=27, 
		End=28, QuestionId=29, String=30, Number=31, Date=32, Int=33, Decimal=34, 
		NEWLINE=35, WS=36, COMMENT=37, LINE_COMMENT=38;
	public static final int
		RULE_questionnaire = 0, RULE_question = 1, RULE_condQuestion = 2, RULE_uncondQuestion = 3, 
		RULE_questionType = 4, RULE_expr = 5;
	public static final String[] ruleNames = {
		"questionnaire", "question", "condQuestion", "uncondQuestion", "questionType", 
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "'question'", "'end'", "'id'", "'text'", "'type'", 
		"'value'", "'boolean'", "'date'", "'string'", "'numeral'", "'if'", "'then'", 
		"'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
		"'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "QUESTION", "END", "ID", "TEXT", "TYPE", "VALUE", 
		"BOOLEAN", "DATE", "STRING", "NUMERAL", "IF", "THEN", "ADD", "SUB", "MUL", 
		"DIV", "GT", "LT", "GE", "LE", "EQ", "NEQ", "AND", "OR", "End", "QuestionId", 
		"String", "Number", "Date", "Int", "Decimal", "NEWLINE", "WS", "COMMENT", 
		"LINE_COMMENT"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "KLQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KLQParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QuestionnaireContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); 
				question();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION || _la==IF );
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

	public static class QuestionContext extends ParserRuleContext {
		public UncondQuestionContext uncondQuestion() {
			return getRuleContext(UncondQuestionContext.class,0);
		}
		public CondQuestionContext condQuestion() {
			return getRuleContext(CondQuestionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		try {
			setState(19);
			switch (_input.LA(1)) {
			case QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(17); 
				uncondQuestion();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(18); 
				condQuestion();
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

	public static class CondQuestionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(KLQParser.NEWLINE, 0); }
		public TerminalNode End() { return getToken(KLQParser.End, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public CondQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condQuestion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitCondQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondQuestionContext condQuestion() throws RecognitionException {
		CondQuestionContext _localctx = new CondQuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_condQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			match(IF);
			setState(22); 
			expr(0);
			setState(23); 
			match(THEN);
			setState(24); 
			match(NEWLINE);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25); 
				question();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION || _la==IF );
			setState(30); 
			match(End);
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

	public static class UncondQuestionContext extends ParserRuleContext {
		public Token id;
		public Token text;
		public QuestionTypeContext type;
		public List<TerminalNode> NEWLINE() { return getTokens(KLQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KLQParser.NEWLINE, i);
		}
		public TerminalNode End() { return getToken(KLQParser.End, 0); }
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UncondQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncondQuestion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitUncondQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UncondQuestionContext uncondQuestion() throws RecognitionException {
		UncondQuestionContext _localctx = new UncondQuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_uncondQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			match(QUESTION);
			setState(33); 
			match(NEWLINE);
			setState(34); 
			match(ID);
			setState(35); 
			match(T__0);
			setState(36); 
			((UncondQuestionContext)_localctx).id = match(QuestionId);
			setState(37); 
			match(NEWLINE);
			setState(38); 
			match(TEXT);
			setState(39); 
			match(T__0);
			setState(40); 
			((UncondQuestionContext)_localctx).text = match(String);
			setState(41); 
			match(NEWLINE);
			setState(42); 
			match(TYPE);
			setState(43); 
			match(T__0);
			setState(44); 
			((UncondQuestionContext)_localctx).type = questionType();
			setState(45); 
			match(NEWLINE);
			setState(51);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(46); 
				match(VALUE);
				setState(47); 
				match(T__0);
				setState(48); 
				expr(0);
				setState(49); 
				match(NEWLINE);
				}
			}

			setState(53); 
			match(End);
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
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << DATE) | (1L << STRING) | (1L << NUMERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExprContext {
		public TerminalNode Number() { return getToken(KLQParser.Number, 0); }
		public NumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public Token operator;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token operator;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitAddSub(this);
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
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparatorsContext extends ExprContext {
		public Token operator;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparatorsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitComparators(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DateContext extends ExprContext {
		public TerminalNode Date() { return getToken(KLQParser.Date, 0); }
		public DateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitDate(this);
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
			setState(66);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(58); 
				match(T__1);
				setState(59); 
				expr(0);
				setState(60); 
				match(T__2);
				}
				break;
			case Number:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62); 
				match(Number);
				}
				break;
			case Date:
				{
				_localctx = new DateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63); 
				match(Date);
				}
				break;
			case String:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64); 
				match(String);
				}
				break;
			case QuestionId:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); 
				match(QuestionId);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(69);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(70); 
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(72);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(73); 
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ComparatorsContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(75);
						((ComparatorsContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GE) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
							((ComparatorsContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(76); 
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(78); 
						match(AND);
						setState(79); 
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(81); 
						match(OR);
						setState(82); 
						expr(7);
						}
						break;
					}
					} 
				}
				setState(87);
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
			return precpred(_ctx, 10);
		case 1: 
			return precpred(_ctx, 9);
		case 2: 
			return precpred(_ctx, 8);
		case 3: 
			return precpred(_ctx, 7);
		case 4: 
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3([\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3\5"+
		"\3\26\n\3\3\4\3\4\3\4\3\4\3\4\6\4\35\n\4\r\4\16\4\36\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"\66\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7V\n\7\f"+
		"\7\16\7Y\13\7\3\7\2\3\f\b\2\4\6\b\n\f\2\6\3\2\f\17\3\2\24\25\3\2\22\23"+
		"\3\2\26\33a\2\17\3\2\2\2\4\25\3\2\2\2\6\27\3\2\2\2\b\"\3\2\2\2\n9\3\2"+
		"\2\2\fD\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2"+
		"\2\21\22\3\2\2\2\22\3\3\2\2\2\23\26\5\b\5\2\24\26\5\6\4\2\25\23\3\2\2"+
		"\2\25\24\3\2\2\2\26\5\3\2\2\2\27\30\7\20\2\2\30\31\5\f\7\2\31\32\7\21"+
		"\2\2\32\34\7%\2\2\33\35\5\4\3\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2"+
		"\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\36\2\2!\7\3\2\2\2\"#\7\6\2\2#$\7%\2"+
		"\2$%\7\b\2\2%&\7\3\2\2&\'\7\37\2\2\'(\7%\2\2()\7\t\2\2)*\7\3\2\2*+\7 "+
		"\2\2+,\7%\2\2,-\7\n\2\2-.\7\3\2\2./\5\n\6\2/\65\7%\2\2\60\61\7\13\2\2"+
		"\61\62\7\3\2\2\62\63\5\f\7\2\63\64\7%\2\2\64\66\3\2\2\2\65\60\3\2\2\2"+
		"\65\66\3\2\2\2\66\67\3\2\2\2\678\7\36\2\28\t\3\2\2\29:\t\2\2\2:\13\3\2"+
		"\2\2;<\b\7\1\2<=\7\4\2\2=>\5\f\7\2>?\7\5\2\2?E\3\2\2\2@E\7!\2\2AE\7\""+
		"\2\2BE\7 \2\2CE\7\37\2\2D;\3\2\2\2D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2"+
		"\2\2EW\3\2\2\2FG\f\f\2\2GH\t\3\2\2HV\5\f\7\rIJ\f\13\2\2JK\t\4\2\2KV\5"+
		"\f\7\fLM\f\n\2\2MN\t\5\2\2NV\5\f\7\13OP\f\t\2\2PQ\7\34\2\2QV\5\f\7\nR"+
		"S\f\b\2\2ST\7\35\2\2TV\5\f\7\tUF\3\2\2\2UI\3\2\2\2UL\3\2\2\2UO\3\2\2\2"+
		"UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2YW\3\2\2\2\t\21\25"+
		"\36\65DUW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}