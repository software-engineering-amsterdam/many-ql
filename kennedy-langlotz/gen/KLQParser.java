// Generated from C:/Users/Timon/SkyDrive/MSc/Software Construction/many-ql/kennedy-langlotz/src\KLQ.g4 by ANTLR 4.5
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
		T__0=1, T__1=2, T__2=3, T__3=4, QUESTION=5, END=6, ID=7, TEXT=8, TYPE=9, 
		VALUE=10, SET=11, BOOLEAN=12, DATE=13, CURRENCY=14, STRING=15, NUMERAL=16, 
		ANSWER=17, IF=18, THEN=19, ADD=20, SUB=21, MUL=22, DIV=23, G=24, L=25, 
		GT=26, LT=27, AND=28, OR=29, End=30, QuestionId=31, String=32, Number=33, 
		Date=34, Time=35, Int=36, Decimal=37, NEWLINE=38, WS=39, COMMENT=40, LINE_COMMENT=41;
	public static final int
		RULE_questionaire = 0, RULE_condQuestion = 1, RULE_question = 2, RULE_questionType = 3, 
		RULE_expr = 4, RULE_answerSet = 5;
	public static final String[] ruleNames = {
		"questionaire", "condQuestion", "question", "questionType", "expr", "answerSet"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "', '", "'question'", "'end'", "'id'", "'text'", 
		"'type'", "'value'", "'set'", "'boolean'", "'date'", "'currency'", "'string'", 
		"'numeral'", "'answer'", "'if'", "'then'", "'+'", "'-'", "'*'", "'/'", 
		"'>'", "'<'", "'>='", "'<='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "QUESTION", "END", "ID", "TEXT", "TYPE", 
		"VALUE", "SET", "BOOLEAN", "DATE", "CURRENCY", "STRING", "NUMERAL", "ANSWER", 
		"IF", "THEN", "ADD", "SUB", "MUL", "DIV", "G", "L", "GT", "LT", "AND", 
		"OR", "End", "QuestionId", "String", "Number", "Date", "Time", "Int", 
		"Decimal", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
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
	public static class QuestionaireContext extends ParserRuleContext {
		public List<CondQuestionContext> condQuestion() {
			return getRuleContexts(CondQuestionContext.class);
		}
		public CondQuestionContext condQuestion(int i) {
			return getRuleContext(CondQuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestionaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestionaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionaireContext questionaire() throws RecognitionException {
		QuestionaireContext _localctx = new QuestionaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUESTION || _la==IF) {
				{
				setState(14);
				switch (_input.LA(1)) {
				case IF:
					{
					setState(12); 
					condQuestion();
					}
					break;
				case QUESTION:
					{
					setState(13); 
					question();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class CondQuestionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(KLQParser.NEWLINE, 0); }
		public TerminalNode End() { return getToken(KLQParser.End, 0); }
		public CondQuestionContext condQuestion() {
			return getRuleContext(CondQuestionContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public CondQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterCondQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitCondQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitCondQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondQuestionContext condQuestion() throws RecognitionException {
		CondQuestionContext _localctx = new CondQuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_condQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			match(IF);
			setState(20); 
			expr(0);
			setState(21); 
			match(THEN);
			setState(22); 
			match(NEWLINE);
			setState(25);
			switch (_input.LA(1)) {
			case IF:
				{
				setState(23); 
				condQuestion();
				}
				break;
			case QUESTION:
				{
				setState(24); 
				question();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(27); 
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

	public static class QuestionContext extends ParserRuleContext {
		public Token id;
		public QuestionTypeContext type;
		public List<TerminalNode> NEWLINE() { return getTokens(KLQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KLQParser.NEWLINE, i);
		}
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public TerminalNode End() { return getToken(KLQParser.End, 0); }
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public AnswerSetContext answerSet() {
			return getRuleContext(AnswerSetContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			match(QUESTION);
			setState(30); 
			match(NEWLINE);
			setState(31); 
			match(ID);
			setState(32); 
			match(T__0);
			setState(33); 
			((QuestionContext)_localctx).id = match(QuestionId);
			setState(34); 
			match(NEWLINE);
			setState(35); 
			match(TEXT);
			setState(36); 
			match(T__0);
			setState(37); 
			match(String);
			setState(38); 
			match(NEWLINE);
			setState(39); 
			match(TYPE);
			setState(40); 
			match(T__0);
			setState(41); 
			((QuestionContext)_localctx).type = questionType();
			setState(42); 
			match(NEWLINE);
			setState(48);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(43); 
				match(VALUE);
				setState(44); 
				match(T__0);
				setState(45); 
				answerSet();
				setState(46); 
				match(NEWLINE);
				}
			}

			setState(50); 
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SET) | (1L << BOOLEAN) | (1L << DATE) | (1L << CURRENCY) | (1L << STRING) | (1L << NUMERAL))) != 0)) ) {
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Number() { return getToken(KLQParser.Number, 0); }
		public TerminalNode Date() { return getToken(KLQParser.Date, 0); }
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(55); 
				match(T__1);
				setState(56); 
				expr(0);
				setState(57); 
				match(T__2);
				}
				break;
			case Number:
				{
				setState(59); 
				match(Number);
				}
				break;
			case Date:
				{
				setState(60); 
				match(Date);
				}
				break;
			case String:
				{
				setState(61); 
				match(String);
				}
				break;
			case QuestionId:
				{
				setState(62); 
				match(QuestionId);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(66);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(67); 
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(69);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(70); 
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(72);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << G) | (1L << L) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(73); 
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(75); 
						match(AND);
						setState(76); 
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(78); 
						match(OR);
						setState(79); 
						expr(7);
						}
						break;
					}
					} 
				}
				setState(84);
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

	public static class AnswerSetContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AnswerSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterAnswerSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitAnswerSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitAnswerSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerSetContext answerSet() throws RecognitionException {
		AnswerSetContext _localctx = new AnswerSetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_answerSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			expr(0);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(86); 
				match(T__3);
				setState(87); 
				expr(0);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		case 4: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+`\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\7\2\21\n\2\f\2\16\2\24\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\63\n\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6S\n\6\f\6\16\6V\13\6\3\7"+
		"\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\7\2\3\n\b\2\4\6\b\n\f\2\6\3\2\r\22"+
		"\3\2\30\31\3\2\26\27\3\2\32\35g\2\22\3\2\2\2\4\25\3\2\2\2\6\37\3\2\2\2"+
		"\b\66\3\2\2\2\nA\3\2\2\2\fW\3\2\2\2\16\21\5\4\3\2\17\21\5\6\4\2\20\16"+
		"\3\2\2\2\20\17\3\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\3"+
		"\3\2\2\2\24\22\3\2\2\2\25\26\7\24\2\2\26\27\5\n\6\2\27\30\7\25\2\2\30"+
		"\33\7(\2\2\31\34\5\4\3\2\32\34\5\6\4\2\33\31\3\2\2\2\33\32\3\2\2\2\34"+
		"\35\3\2\2\2\35\36\7 \2\2\36\5\3\2\2\2\37 \7\7\2\2 !\7(\2\2!\"\7\t\2\2"+
		"\"#\7\3\2\2#$\7!\2\2$%\7(\2\2%&\7\n\2\2&\'\7\3\2\2\'(\7\"\2\2()\7(\2\2"+
		")*\7\13\2\2*+\7\3\2\2+,\5\b\5\2,\62\7(\2\2-.\7\f\2\2./\7\3\2\2/\60\5\f"+
		"\7\2\60\61\7(\2\2\61\63\3\2\2\2\62-\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2"+
		"\2\64\65\7 \2\2\65\7\3\2\2\2\66\67\t\2\2\2\67\t\3\2\2\289\b\6\1\29:\7"+
		"\4\2\2:;\5\n\6\2;<\7\5\2\2<B\3\2\2\2=B\7#\2\2>B\7$\2\2?B\7\"\2\2@B\7!"+
		"\2\2A8\3\2\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2BT\3\2\2\2CD\f\f"+
		"\2\2DE\t\3\2\2ES\5\n\6\rFG\f\13\2\2GH\t\4\2\2HS\5\n\6\fIJ\f\n\2\2JK\t"+
		"\5\2\2KS\5\n\6\13LM\f\t\2\2MN\7\36\2\2NS\5\n\6\nOP\f\b\2\2PQ\7\37\2\2"+
		"QS\5\n\6\tRC\3\2\2\2RF\3\2\2\2RI\3\2\2\2RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2"+
		"TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VT\3\2\2\2W\\\5\n\6\2XY\7\6\2\2Y[\5\n"+
		"\6\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^\\\3\2\2\2\n"+
		"\20\22\33\62ART\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}