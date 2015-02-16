// Generated from /home/juriaan/Development/IdeaProjects/many-ql/kennedy-langlotz/src/KLQ.g4 by ANTLR 4.5
package parser;
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
		RULE_questionType = 4, RULE_answer = 5, RULE_expr = 6, RULE_answerSet = 7;
	public static final String[] ruleNames = {
		"questionaire", "question", "questionBegin", "questionEnd", "questionType", 
		"answer", "expr", "answerSet"
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); 
				question();
				}
				}
				setState(19); 
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
		public Token id;
		public Token text;
		public QuestionTypeContext type;
		public QuestionBeginContext questionBegin() {
			return getRuleContext(QuestionBeginContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(KLQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KLQParser.NEWLINE, i);
		}
		public QuestionEndContext questionEnd() {
			return getRuleContext(QuestionEndContext.class,0);
		}
		public TerminalNode QuestionId() { return getToken(KLQParser.QuestionId, 0); }
		public TerminalNode String() { return getToken(KLQParser.String, 0); }
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
		enterRule(_localctx, 2, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			questionBegin();
			setState(22); 
			match(ID);
			setState(23); 
			match(T__0);
			setState(24); 
			((QuestionContext)_localctx).id = match(QuestionId);
			setState(25); 
			match(NEWLINE);
			setState(26); 
			match(TEXT);
			setState(27); 
			match(T__0);
			setState(28); 
			((QuestionContext)_localctx).text = match(String);
			setState(29); 
			match(NEWLINE);
			setState(30); 
			match(TYPE);
			setState(31); 
			match(T__0);
			setState(32); 
			((QuestionContext)_localctx).type = questionType();
			setState(33); 
			match(NEWLINE);
			setState(39);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(34); 
				match(VALUE);
				setState(35); 
				match(T__0);
				setState(36); 
				answerSet();
				setState(37); 
				match(NEWLINE);
				}
			}

			setState(41); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionBegin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionBeginContext questionBegin() throws RecognitionException {
		QuestionBeginContext _localctx = new QuestionBeginContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionBegin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			match(QUESTION);
			setState(44); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionEndContext questionEnd() throws RecognitionException {
		QuestionEndContext _localctx = new QuestionEndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_questionEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			match(END);
			setState(53);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47); 
					match(NEWLINE);
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case EOF:
				{
				setState(52); 
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
		enterRule(_localctx, 8, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_answer);
		try {
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57); 
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); 
				match(Number);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59); 
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(63); 
				match(Number);
				}
				break;
			case Date:
				{
				setState(64); 
				match(Date);
				}
				break;
			case String:
				{
				setState(65); 
				match(String);
				}
				break;
			case ANSWER:
				{
				setState(66); 
				match(ANSWER);
				}
				break;
			case T__1:
				{
				setState(67); 
				match(T__1);
				setState(68); 
				expr(0);
				setState(69); 
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(74);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(75); 
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(77);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(78); 
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(80);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << G) | (1L << L) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(81); 
						expr(7);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
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
		enterRule(_localctx, 14, RULE_answerSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			answer();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(88); 
				match(T__3);
				setState(89); 
				answer();
				}
				}
				setState(94);
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
		case 6: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,b\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2\r\2\16"+
		"\2\25\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3*\n\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\6\5\63\n\5\r\5\16\5\64\3"+
		"\5\5\58\n\5\3\6\3\6\3\7\3\7\3\7\5\7?\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\bJ\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bU\n\b\f\b\16\b"+
		"X\13\b\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\t\2\3\16\n\2\4\6\b\n\f\16"+
		"\20\2\6\3\2\21\26\3\2\34\35\3\2\32\33\3\2\36!g\2\23\3\2\2\2\4\27\3\2\2"+
		"\2\6-\3\2\2\2\b\60\3\2\2\2\n9\3\2\2\2\f>\3\2\2\2\16I\3\2\2\2\20Y\3\2\2"+
		"\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2"+
		"\2\26\3\3\2\2\2\27\30\5\6\4\2\30\31\7\13\2\2\31\32\7\3\2\2\32\33\7\"\2"+
		"\2\33\34\7)\2\2\34\35\7\16\2\2\35\36\7\3\2\2\36\37\7#\2\2\37 \7)\2\2 "+
		"!\7\f\2\2!\"\7\3\2\2\"#\5\n\6\2#)\7)\2\2$%\7\r\2\2%&\7\3\2\2&\'\5\20\t"+
		"\2\'(\7)\2\2(*\3\2\2\2)$\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\5\b\5\2,\5\3\2"+
		"\2\2-.\7\t\2\2./\7)\2\2/\7\3\2\2\2\60\67\7\n\2\2\61\63\7)\2\2\62\61\3"+
		"\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2\668\7\2\2"+
		"\3\67\62\3\2\2\2\67\66\3\2\2\28\t\3\2\2\29:\t\2\2\2:\13\3\2\2\2;?\5\16"+
		"\b\2<?\7$\2\2=?\7#\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\r\3\2\2\2@A\b\b"+
		"\1\2AJ\7$\2\2BJ\7%\2\2CJ\7#\2\2DJ\7\31\2\2EF\7\4\2\2FG\5\16\b\2GH\7\5"+
		"\2\2HJ\3\2\2\2I@\3\2\2\2IB\3\2\2\2IC\3\2\2\2ID\3\2\2\2IE\3\2\2\2JV\3\2"+
		"\2\2KL\f\n\2\2LM\t\3\2\2MU\5\16\b\13NO\f\t\2\2OP\t\4\2\2PU\5\16\b\nQR"+
		"\f\b\2\2RS\t\5\2\2SU\5\16\b\tTK\3\2\2\2TN\3\2\2\2TQ\3\2\2\2UX\3\2\2\2"+
		"VT\3\2\2\2VW\3\2\2\2W\17\3\2\2\2XV\3\2\2\2Y^\5\f\7\2Z[\7\6\2\2[]\5\f\7"+
		"\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\21\3\2\2\2`^\3\2\2\2\13"+
		"\25)\64\67>ITV^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}