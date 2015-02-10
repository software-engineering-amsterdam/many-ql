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
		T__0=1, T__1=2, T__2=3, T__3=4, PAGE=5, SECTION=6, QUESTION=7, END=8, 
		ID=9, TYPE=10, VALUE=11, TEXT=12, REQUIRES=13, ONLY=14, SET=15, BOOLEAN=16, 
		DATE=17, CURRENCY=18, STRING=19, NUMERAL=20, TODAY=21, NOW=22, ANSWER=23, 
		ADD=24, SUB=25, MUL=26, DIV=27, G=28, L=29, GT=30, LT=31, QuestionId=32, 
		String=33, Number=34, Date=35, Time=36, Int=37, Decimal=38, NEWLINE=39, 
		WS=40, COMMENT=41, LINE_COMMENT=42;
	public static final int
		RULE_questionaire = 0, RULE_question = 1, RULE_questionBegin = 2, RULE_questionEnd = 3, 
		RULE_specification = 4, RULE_questionType = 5, RULE_answer = 6, RULE_expr = 7, 
		RULE_answers = 8;
	public static final String[] ruleNames = {
		"questionaire", "question", "questionBegin", "questionEnd", "specification", 
		"questionType", "answer", "expr", "answers"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "', '", "'page'", "'section'", "'question'", 
		"'end'", "'id'", "'type'", "'value'", "'text'", "'requires'", "'only'", 
		"'set'", "'boolean'", "'date'", "'currency'", "'string'", "'numeral'", 
		"'today'", "'now'", "'answer'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
		"'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "PAGE", "SECTION", "QUESTION", "END", "ID", 
		"TYPE", "VALUE", "TEXT", "REQUIRES", "ONLY", "SET", "BOOLEAN", "DATE", 
		"CURRENCY", "STRING", "NUMERAL", "TODAY", "NOW", "ANSWER", "ADD", "SUB", 
		"MUL", "DIV", "G", "L", "GT", "LT", "QuestionId", "String", "Number", 
		"Date", "Time", "Int", "Decimal", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
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
	}

	public final QuestionaireContext questionaire() throws RecognitionException {
		QuestionaireContext _localctx = new QuestionaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); 
				question();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION );
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
		public QuestionBeginContext questionBegin() {
			return getRuleContext(QuestionBeginContext.class,0);
		}
		public QuestionEndContext questionEnd() {
			return getRuleContext(QuestionEndContext.class,0);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
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
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			questionBegin();
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); 
				specification();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << TYPE) | (1L << VALUE) | (1L << TEXT) | (1L << REQUIRES) | (1L << ONLY))) != 0) );
			setState(29); 
			questionEnd();
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

	public static class QuestionBeginContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(KLQParser.NEWLINE, 0); }
		public QuestionBeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionBegin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestionBegin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestionBegin(this);
		}
	}

	public final QuestionBeginContext questionBegin() throws RecognitionException {
		QuestionBeginContext _localctx = new QuestionBeginContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionBegin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			match(QUESTION);
			setState(32); 
			match(NEWLINE);
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

	public static class QuestionEndContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KLQParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(KLQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KLQParser.NEWLINE, i);
		}
		public QuestionEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestionEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestionEnd(this);
		}
	}

	public final QuestionEndContext questionEnd() throws RecognitionException {
		QuestionEndContext _localctx = new QuestionEndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_questionEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			match(END);
			setState(41);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(35); 
					match(NEWLINE);
					}
					}
					setState(38); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case EOF:
				{
				setState(40); 
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SpecificationContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(KLQParser.NEWLINE, 0); }
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public AnswersContext answers() {
			return getRuleContext(AnswersContext.class,0);
		}
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitSpecification(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(43); 
				match(ID);
				setState(44); 
				match(T__0);
				setState(45); 
				match(QuestionId);
				}
				break;
			case TYPE:
				{
				setState(46); 
				match(TYPE);
				setState(47); 
				match(T__0);
				setState(48); 
				questionType();
				}
				break;
			case VALUE:
				{
				setState(49); 
				match(VALUE);
				setState(50); 
				match(T__0);
				setState(51); 
				answers();
				}
				break;
			case TEXT:
				{
				setState(52); 
				match(TEXT);
				setState(53); 
				match(T__0);
				setState(54); 
				match(String);
				}
				break;
			case REQUIRES:
				{
				setState(55); 
				match(REQUIRES);
				setState(56); 
				match(T__0);
				setState(57); 
				match(QuestionId);
				}
				break;
			case ONLY:
				{
				setState(58); 
				match(ONLY);
				setState(59); 
				match(T__0);
				setState(60); 
				answers();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63); 
			match(NEWLINE);
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
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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

	public static class AnswerContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Number() { return getToken(KLQParser.Number, 0); }
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitAnswer(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answer);
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); 
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); 
				match(Number);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); 
				match(String);
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
		public TerminalNode Number() { return getToken(KLQParser.Number, 0); }
		public TerminalNode Date() { return getToken(KLQParser.Date, 0); }
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode L() { return getToken(KLQParser.L, 0); }
		public TerminalNode LT() { return getToken(KLQParser.LT, 0); }
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
			setState(81);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(73); 
				match(Number);
				}
				break;
			case Date:
				{
				setState(74); 
				match(Date);
				}
				break;
			case String:
				{
				setState(75); 
				match(String);
				}
				break;
			case ANSWER:
				{
				setState(76); 
				match(ANSWER);
				}
				break;
			case T__1:
				{
				setState(77); 
				match(T__1);
				setState(78); 
				expr(0);
				setState(79); 
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(84);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(85); 
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(87);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(88); 
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(90);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << G) | (1L << L) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(91); 
						expr(7);
						}
						break;
					}
					} 
				}
				setState(96);
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

	public static class AnswersContext extends ParserRuleContext {
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitAnswers(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_answers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			answer();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(98); 
				match(T__3);
				setState(99); 
				answer();
				}
				}
				setState(104);
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
		case 7: 
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,l\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2\26\n"+
		"\2\r\2\16\2\27\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\6\5\'\n\5\r\5\16\5(\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6@\n\6\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\b\5\bI\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tT\n\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t_\n\t\f\t\16\tb\13\t\3\n\3\n\3\n\7\ng"+
		"\n\n\f\n\16\nj\13\n\3\n\2\3\20\13\2\4\6\b\n\f\16\20\22\2\6\3\2\21\26\3"+
		"\2\34\35\3\2\32\33\3\2\36!u\2\25\3\2\2\2\4\31\3\2\2\2\6!\3\2\2\2\b$\3"+
		"\2\2\2\n?\3\2\2\2\fC\3\2\2\2\16H\3\2\2\2\20S\3\2\2\2\22c\3\2\2\2\24\26"+
		"\5\4\3\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3"+
		"\3\2\2\2\31\33\5\6\4\2\32\34\5\n\6\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33"+
		"\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \5\b\5\2 \5\3\2\2\2!\"\7\t\2\2"+
		"\"#\7)\2\2#\7\3\2\2\2$+\7\n\2\2%\'\7)\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2),\3\2\2\2*,\7\2\2\3+&\3\2\2\2+*\3\2\2\2,\t\3\2\2\2-.\7\13"+
		"\2\2./\7\3\2\2/@\7\"\2\2\60\61\7\f\2\2\61\62\7\3\2\2\62@\5\f\7\2\63\64"+
		"\7\r\2\2\64\65\7\3\2\2\65@\5\22\n\2\66\67\7\16\2\2\678\7\3\2\28@\7#\2"+
		"\29:\7\17\2\2:;\7\3\2\2;@\7\"\2\2<=\7\20\2\2=>\7\3\2\2>@\5\22\n\2?-\3"+
		"\2\2\2?\60\3\2\2\2?\63\3\2\2\2?\66\3\2\2\2?9\3\2\2\2?<\3\2\2\2@A\3\2\2"+
		"\2AB\7)\2\2B\13\3\2\2\2CD\t\2\2\2D\r\3\2\2\2EI\5\20\t\2FI\7$\2\2GI\7#"+
		"\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\17\3\2\2\2JK\b\t\1\2KT\7$\2\2LT\7"+
		"%\2\2MT\7#\2\2NT\7\31\2\2OP\7\4\2\2PQ\5\20\t\2QR\7\5\2\2RT\3\2\2\2SJ\3"+
		"\2\2\2SL\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2T`\3\2\2\2UV\f\n\2\2VW\t"+
		"\3\2\2W_\5\20\t\13XY\f\t\2\2YZ\t\4\2\2Z_\5\20\t\n[\\\f\b\2\2\\]\t\5\2"+
		"\2]_\5\20\t\t^U\3\2\2\2^X\3\2\2\2^[\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2"+
		"\2\2a\21\3\2\2\2b`\3\2\2\2ch\5\16\b\2de\7\6\2\2eg\5\16\b\2fd\3\2\2\2g"+
		"j\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\23\3\2\2\2jh\3\2\2\2\f\27\35(+?HS^`h";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}