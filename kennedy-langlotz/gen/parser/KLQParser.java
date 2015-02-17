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
		T__0=1, T__1=2, T__2=3, T__3=4, QUESTION=5, END=6, ID=7, TEXT=8, TYPE=9, 
		VALUE=10, SET=11, BOOLEAN=12, DATE=13, STRING=14, NUMERAL=15, ANSWER=16, 
		IF=17, THEN=18, ADD=19, SUB=20, MUL=21, DIV=22, G=23, L=24, GT=25, LT=26, 
		AND=27, OR=28, End=29, QuestionId=30, String=31, Number=32, Date=33, Time=34, 
		Int=35, Decimal=36, NEWLINE=37, WS=38, COMMENT=39, LINE_COMMENT=40;
	public static final int
		RULE_questionnaire = 0, RULE_question = 1, RULE_condQuestion = 2, RULE_uncondQuestion = 3, 
		RULE_questionType = 4, RULE_expr = 5, RULE_answerSet = 6;
	public static final String[] ruleNames = {
		"questionnaire", "question", "condQuestion", "uncondQuestion", "questionType", 
		"expr", "answerSet"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "', '", "'question'", "'end'", "'id'", "'text'", 
		"'type'", "'value'", "'set'", "'boolean'", "'date'", "'string'", "'numeral'", 
		"'answer'", "'if'", "'then'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
		"'>='", "'<='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "QUESTION", "END", "ID", "TEXT", "TYPE", 
		"VALUE", "SET", "BOOLEAN", "DATE", "STRING", "NUMERAL", "ANSWER", "IF", 
		"THEN", "ADD", "SUB", "MUL", "DIV", "G", "L", "GT", "LT", "AND", "OR", 
		"End", "QuestionId", "String", "Number", "Date", "Time", "Int", "Decimal", 
		"NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitQuestionnaire(this);
		}
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); 
				question();
				}
				}
				setState(17); 
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
		try {
			setState(21);
			switch (_input.LA(1)) {
			case QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(19); 
				uncondQuestion();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(20); 
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
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode End() { return getToken(KLQParser.End, 0); }
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
		enterRule(_localctx, 4, RULE_condQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			match(IF);
			setState(24); 
			expr(0);
			setState(25); 
			match(THEN);
			setState(26); 
			match(NEWLINE);
			setState(27); 
			question();
			setState(28); 
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
		public AnswerSetContext answerSet() {
			return getRuleContext(AnswerSetContext.class,0);
		}
		public UncondQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncondQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterUncondQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitUncondQuestion(this);
		}
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
			setState(30); 
			match(QUESTION);
			setState(31); 
			match(NEWLINE);
			setState(32); 
			match(ID);
			setState(33); 
			match(T__0);
			setState(34); 
			((UncondQuestionContext)_localctx).id = match(QuestionId);
			setState(35); 
			match(NEWLINE);
			setState(36); 
			match(TEXT);
			setState(37); 
			match(T__0);
			setState(38); 
			((UncondQuestionContext)_localctx).text = match(String);
			setState(39); 
			match(NEWLINE);
			setState(40); 
			match(TYPE);
			setState(41); 
			match(T__0);
			setState(42); 
			((UncondQuestionContext)_localctx).type = questionType();
			setState(43); 
			match(NEWLINE);
			setState(49);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(44); 
				match(VALUE);
				setState(45); 
				match(T__0);
				setState(46); 
				answerSet();
				setState(47); 
				match(NEWLINE);
				}
			}

			setState(51); 
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
		enterRule(_localctx, 8, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SET) | (1L << BOOLEAN) | (1L << DATE) | (1L << STRING) | (1L << NUMERAL))) != 0)) ) {
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitOr(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitAddSub(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparatorsContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparatorsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterComparators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitComparators(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitAnd(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitString(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitId(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitDate(this);
		}
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
			setState(64);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56); 
				match(T__1);
				setState(57); 
				expr(0);
				setState(58); 
				match(T__2);
				}
				break;
			case Number:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); 
				match(Number);
				}
				break;
			case Date:
				{
				_localctx = new DateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); 
				match(Date);
				}
				break;
			case String:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62); 
				match(String);
				}
				break;
			case QuestionId:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63); 
				match(QuestionId);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(67);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(68); 
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(70);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(71); 
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ComparatorsContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(73);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << G) | (1L << L) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(74); 
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(76); 
						match(AND);
						setState(77); 
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(79); 
						match(OR);
						setState(80); 
						expr(7);
						}
						break;
					}
					} 
				}
				setState(85);
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
		enterRule(_localctx, 12, RULE_answerSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); 
			expr(0);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(87); 
				match(T__3);
				setState(88); 
				expr(0);
				}
				}
				setState(93);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*a\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23\3"+
		"\3\3\3\5\3\30\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7C\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7T\n\7\f\7\16\7W\13\7"+
		"\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\b\2\3\f\t\2\4\6\b\n\f\16\2\6\3"+
		"\2\r\21\3\2\27\30\3\2\25\26\3\2\31\34f\2\21\3\2\2\2\4\27\3\2\2\2\6\31"+
		"\3\2\2\2\b \3\2\2\2\n\67\3\2\2\2\fB\3\2\2\2\16X\3\2\2\2\20\22\5\4\3\2"+
		"\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2"+
		"\25\30\5\b\5\2\26\30\5\6\4\2\27\25\3\2\2\2\27\26\3\2\2\2\30\5\3\2\2\2"+
		"\31\32\7\23\2\2\32\33\5\f\7\2\33\34\7\24\2\2\34\35\7\'\2\2\35\36\5\4\3"+
		"\2\36\37\7\37\2\2\37\7\3\2\2\2 !\7\7\2\2!\"\7\'\2\2\"#\7\t\2\2#$\7\3\2"+
		"\2$%\7 \2\2%&\7\'\2\2&\'\7\n\2\2\'(\7\3\2\2()\7!\2\2)*\7\'\2\2*+\7\13"+
		"\2\2+,\7\3\2\2,-\5\n\6\2-\63\7\'\2\2./\7\f\2\2/\60\7\3\2\2\60\61\5\16"+
		"\b\2\61\62\7\'\2\2\62\64\3\2\2\2\63.\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2"+
		"\2\65\66\7\37\2\2\66\t\3\2\2\2\678\t\2\2\28\13\3\2\2\29:\b\7\1\2:;\7\4"+
		"\2\2;<\5\f\7\2<=\7\5\2\2=C\3\2\2\2>C\7\"\2\2?C\7#\2\2@C\7!\2\2AC\7 \2"+
		"\2B9\3\2\2\2B>\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2CU\3\2\2\2DE\f\f\2"+
		"\2EF\t\3\2\2FT\5\f\7\rGH\f\13\2\2HI\t\4\2\2IT\5\f\7\fJK\f\n\2\2KL\t\5"+
		"\2\2LT\5\f\7\13MN\f\t\2\2NO\7\35\2\2OT\5\f\7\nPQ\f\b\2\2QR\7\36\2\2RT"+
		"\5\f\7\tSD\3\2\2\2SG\3\2\2\2SJ\3\2\2\2SM\3\2\2\2SP\3\2\2\2TW\3\2\2\2U"+
		"S\3\2\2\2UV\3\2\2\2V\r\3\2\2\2WU\3\2\2\2X]\5\f\7\2YZ\7\6\2\2Z\\\5\f\7"+
		"\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\17\3\2\2\2_]\3\2\2\2\t\23"+
		"\27\63BSU]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}