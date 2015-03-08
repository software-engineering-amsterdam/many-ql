// Generated from nl\u005Cuva\bromance\parsers\QL.g4 by ANTLR 4.5
package nl.uva.bromance.parsers;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, TIMES=27, DIVISION=28, ADDITION=29, SUBTRACTION=30, 
		SMALLETHANOREQUAL=31, BIGGERTHANOREQUAL=32, BIGGERTHAN=33, SMALLERTHAN=34, 
		EQUALTO=35, NOTEQUALTO=36, AND=37, OR=38, STRING=39, NUMBER=40, TEXT=41, 
		COMMENT=42, WS=43;
	public static final int
		RULE_questionnaire = 0, RULE_questionnaireBody = 1, RULE_form = 2, RULE_formBody = 3, 
		RULE_question = 4, RULE_questionBody = 5, RULE_questionText = 6, RULE_questionAnswer = 7, 
		RULE_questionAnswerSimple = 8, RULE_questionAnswerCustom = 9, RULE_questionRange = 10, 
		RULE_questionRangeFromTo = 11, RULE_questionRangeBiggerThan = 12, RULE_questionRangeSmallerThan = 13, 
		RULE_calculation = 14, RULE_calculationBody = 15, RULE_ifSequence = 16, 
		RULE_ifStatement = 17, RULE_elseStatement = 18, RULE_elseIfStatement = 19, 
		RULE_statementBody = 20, RULE_label = 21, RULE_labelBody = 22, RULE_labelText = 23, 
		RULE_input = 24, RULE_expression = 25, RULE_id = 26;
	public static final String[] ruleNames = {
		"questionnaire", "questionnaireBody", "form", "formBody", "question", 
		"questionBody", "questionText", "questionAnswer", "questionAnswerSimple", 
		"questionAnswerCustom", "questionRange", "questionRangeFromTo", "questionRangeBiggerThan", 
		"questionRangeSmallerThan", "calculation", "calculationBody", "ifSequence", 
		"ifStatement", "elseStatement", "elseIfStatement", "statementBody", "label", 
		"labelBody", "labelText", "input", "expression", "id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Name:'", "'{'", "'}'", "'Form:'", "'Question:'", "'Text:'", "'Answer:'", 
		"'integer'", "'Integer'", "'boolean'", "'Boolean'", "'double'", "'Double'", 
		"'string'", "'String'", "'['", "']'", "'Range:'", "'Calculation:'", "'If:'", 
		"'Else:'", "'Else If:'", "'Label:'", "'Input:'", "'('", "')'", "'*'", 
		"'/'", "'+'", "'-'", "'<='", "'>='", "'>'", "'<'", "'=='", "'!='", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "TIMES", "DIVISION", "ADDITION", "SUBTRACTION", "SMALLETHANOREQUAL", 
		"BIGGERTHANOREQUAL", "BIGGERTHAN", "SMALLERTHAN", "EQUALTO", "NOTEQUALTO", 
		"AND", "OR", "STRING", "NUMBER", "TEXT", "COMMENT", "WS"
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
	public static class QuestionnaireContext extends ParserRuleContext {
		public Token name;
		public QuestionnaireBodyContext questionnaireBody() {
			return getRuleContext(QuestionnaireBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionnaire(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(55);
			((QuestionnaireContext)_localctx).name = match(STRING);
			setState(56);
			questionnaireBody();
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

	public static class QuestionnaireBodyContext extends ParserRuleContext {
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public QuestionnaireBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaireBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionnaireBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionnaireBody(this);
		}
	}

	public final QuestionnaireBodyContext questionnaireBody() throws RecognitionException {
		QuestionnaireBodyContext _localctx = new QuestionnaireBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_questionnaireBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__1);
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				form();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(64);
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

	public static class FormContext extends ParserRuleContext {
		public Token name;
		public FormBodyContext formBody() {
			return getRuleContext(FormBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__3);
			setState(67);
			((FormContext)_localctx).name = match(STRING);
			setState(68);
			formBody();
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

	public static class FormBodyContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public List<IfSequenceContext> ifSequence() {
			return getRuleContexts(IfSequenceContext.class);
		}
		public IfSequenceContext ifSequence(int i) {
			return getRuleContext(IfSequenceContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public FormBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterFormBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitFormBody(this);
		}
	}

	public final FormBodyContext formBody() throws RecognitionException {
		FormBodyContext _localctx = new FormBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__1);
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(75);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(71);
					question();
					}
					break;
				case T__18:
					{
					setState(72);
					calculation();
					}
					break;
				case T__19:
					{
					setState(73);
					ifSequence();
					}
					break;
				case T__22:
					{
					setState(74);
					label();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << T__22))) != 0) );
			setState(79);
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

	public static class QuestionContext extends ParserRuleContext {
		public Token name;
		public QuestionBodyContext questionBody() {
			return getRuleContext(QuestionBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__4);
			setState(82);
			((QuestionContext)_localctx).name = match(STRING);
			setState(83);
			questionBody();
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

	public static class QuestionBodyContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public QuestionAnswerContext questionAnswer() {
			return getRuleContext(QuestionAnswerContext.class,0);
		}
		public QuestionRangeContext questionRange() {
			return getRuleContext(QuestionRangeContext.class,0);
		}
		public QuestionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionBody(this);
		}
	}

	public final QuestionBodyContext questionBody() throws RecognitionException {
		QuestionBodyContext _localctx = new QuestionBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__1);
			setState(86);
			questionText();
			setState(87);
			questionAnswer();
			setState(89);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(88);
				questionRange();
				}
			}

			setState(91);
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

	public static class QuestionTextContext extends ParserRuleContext {
		public Token text;
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public QuestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionText(this);
		}
	}

	public final QuestionTextContext questionText() throws RecognitionException {
		QuestionTextContext _localctx = new QuestionTextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__5);
			setState(94);
			((QuestionTextContext)_localctx).text = match(STRING);
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

	public static class QuestionAnswerContext extends ParserRuleContext {
		public QuestionAnswerSimpleContext questionAnswerSimple() {
			return getRuleContext(QuestionAnswerSimpleContext.class,0);
		}
		public QuestionAnswerCustomContext questionAnswerCustom() {
			return getRuleContext(QuestionAnswerCustomContext.class,0);
		}
		public QuestionAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionAnswer(this);
		}
	}

	public final QuestionAnswerContext questionAnswer() throws RecognitionException {
		QuestionAnswerContext _localctx = new QuestionAnswerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_questionAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__6);
			setState(99);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				{
				setState(97);
				questionAnswerSimple();
				}
				break;
			case T__15:
				{
				setState(98);
				questionAnswerCustom();
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

	public static class QuestionAnswerSimpleContext extends ParserRuleContext {
		public Token type;
		public QuestionAnswerSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionAnswerSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionAnswerSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionAnswerSimple(this);
		}
	}

	public final QuestionAnswerSimpleContext questionAnswerSimple() throws RecognitionException {
		QuestionAnswerSimpleContext _localctx = new QuestionAnswerSimpleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_questionAnswerSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((QuestionAnswerSimpleContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				((QuestionAnswerSimpleContext)_localctx).type = (Token)_errHandler.recoverInline(this);
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

	public static class QuestionAnswerCustomContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(QLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLParser.STRING, i);
		}
		public List<TerminalNode> OR() { return getTokens(QLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(QLParser.OR, i);
		}
		public QuestionAnswerCustomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionAnswerCustom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionAnswerCustom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionAnswerCustom(this);
		}
	}

	public final QuestionAnswerCustomContext questionAnswerCustom() throws RecognitionException {
		QuestionAnswerCustomContext _localctx = new QuestionAnswerCustomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_questionAnswerCustom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__15);
			setState(104);
			match(STRING);
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				match(OR);
				setState(106);
				match(STRING);
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(111);
			match(T__16);
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

	public static class QuestionRangeContext extends ParserRuleContext {
		public QuestionRangeFromToContext questionRangeFromTo() {
			return getRuleContext(QuestionRangeFromToContext.class,0);
		}
		public QuestionRangeBiggerThanContext questionRangeBiggerThan() {
			return getRuleContext(QuestionRangeBiggerThanContext.class,0);
		}
		public QuestionRangeSmallerThanContext questionRangeSmallerThan() {
			return getRuleContext(QuestionRangeSmallerThanContext.class,0);
		}
		public QuestionRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionRange(this);
		}
	}

	public final QuestionRangeContext questionRange() throws RecognitionException {
		QuestionRangeContext _localctx = new QuestionRangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_questionRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__17);
			setState(117);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(114);
				questionRangeFromTo();
				}
				break;
			case BIGGERTHAN:
				{
				setState(115);
				questionRangeBiggerThan();
				}
				break;
			case SMALLERTHAN:
				{
				setState(116);
				questionRangeSmallerThan();
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

	public static class QuestionRangeFromToContext extends ParserRuleContext {
		public Token lower;
		public Token higher;
		public List<TerminalNode> NUMBER() { return getTokens(QLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(QLParser.NUMBER, i);
		}
		public QuestionRangeFromToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionRangeFromTo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionRangeFromTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionRangeFromTo(this);
		}
	}

	public final QuestionRangeFromToContext questionRangeFromTo() throws RecognitionException {
		QuestionRangeFromToContext _localctx = new QuestionRangeFromToContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_questionRangeFromTo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((QuestionRangeFromToContext)_localctx).lower = match(NUMBER);
			setState(120);
			match(SUBTRACTION);
			setState(121);
			((QuestionRangeFromToContext)_localctx).higher = match(NUMBER);
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

	public static class QuestionRangeBiggerThanContext extends ParserRuleContext {
		public Token num;
		public TerminalNode BIGGERTHAN() { return getToken(QLParser.BIGGERTHAN, 0); }
		public TerminalNode NUMBER() { return getToken(QLParser.NUMBER, 0); }
		public QuestionRangeBiggerThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionRangeBiggerThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionRangeBiggerThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionRangeBiggerThan(this);
		}
	}

	public final QuestionRangeBiggerThanContext questionRangeBiggerThan() throws RecognitionException {
		QuestionRangeBiggerThanContext _localctx = new QuestionRangeBiggerThanContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_questionRangeBiggerThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(BIGGERTHAN);
			setState(124);
			((QuestionRangeBiggerThanContext)_localctx).num = match(NUMBER);
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

	public static class QuestionRangeSmallerThanContext extends ParserRuleContext {
		public Token num;
		public TerminalNode SMALLERTHAN() { return getToken(QLParser.SMALLERTHAN, 0); }
		public TerminalNode NUMBER() { return getToken(QLParser.NUMBER, 0); }
		public QuestionRangeSmallerThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionRangeSmallerThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionRangeSmallerThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionRangeSmallerThan(this);
		}
	}

	public final QuestionRangeSmallerThanContext questionRangeSmallerThan() throws RecognitionException {
		QuestionRangeSmallerThanContext _localctx = new QuestionRangeSmallerThanContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_questionRangeSmallerThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(SMALLERTHAN);
			setState(127);
			((QuestionRangeSmallerThanContext)_localctx).num = match(NUMBER);
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

	public static class CalculationContext extends ParserRuleContext {
		public Token name;
		public CalculationBodyContext calculationBody() {
			return getRuleContext(CalculationBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public CalculationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterCalculation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitCalculation(this);
		}
	}

	public final CalculationContext calculation() throws RecognitionException {
		CalculationContext _localctx = new CalculationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_calculation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__18);
			setState(130);
			((CalculationContext)_localctx).name = match(STRING);
			setState(131);
			calculationBody();
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

	public static class CalculationBodyContext extends ParserRuleContext {
		public List<IfSequenceContext> ifSequence() {
			return getRuleContexts(IfSequenceContext.class);
		}
		public IfSequenceContext ifSequence(int i) {
			return getRuleContext(IfSequenceContext.class,i);
		}
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public CalculationBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculationBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterCalculationBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitCalculationBody(this);
		}
	}

	public final CalculationBodyContext calculationBody() throws RecognitionException {
		CalculationBodyContext _localctx = new CalculationBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_calculationBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__1);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(136);
				switch (_input.LA(1)) {
				case T__19:
					{
					setState(134);
					ifSequence();
					}
					break;
				case T__23:
					{
					setState(135);
					input();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 || _la==T__23 );
			setState(140);
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

	public static class IfSequenceContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfSequence(this);
		}
	}

	public final IfSequenceContext ifSequence() throws RecognitionException {
		IfSequenceContext _localctx = new IfSequenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			ifStatement();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(143);
				elseIfStatement();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(149);
				elseStatement();
				}
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBodyContext statementBody() {
			return getRuleContext(StatementBodyContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__19);
			setState(153);
			expression(0);
			setState(154);
			statementBody();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public StatementBodyContext statementBody() {
			return getRuleContext(StatementBodyContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__20);
			setState(157);
			statementBody();
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBodyContext statementBody() {
			return getRuleContext(StatementBodyContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitElseIfStatement(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__21);
			setState(160);
			expression(0);
			setState(161);
			statementBody();
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

	public static class StatementBodyContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public List<LabelTextContext> labelText() {
			return getRuleContexts(LabelTextContext.class);
		}
		public LabelTextContext labelText(int i) {
			return getRuleContext(LabelTextContext.class,i);
		}
		public StatementBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStatementBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStatementBody(this);
		}
	}

	public final StatementBodyContext statementBody() throws RecognitionException {
		StatementBodyContext _localctx = new StatementBodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statementBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__1);
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(168);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(164);
					question();
					}
					break;
				case T__18:
					{
					setState(165);
					calculation();
					}
					break;
				case T__23:
					{
					setState(166);
					input();
					}
					break;
				case T__5:
					{
					setState(167);
					labelText();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__18) | (1L << T__23))) != 0) );
			setState(172);
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

	public static class LabelContext extends ParserRuleContext {
		public Token name;
		public LabelBodyContext labelBody() {
			return getRuleContext(LabelBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__22);
			setState(175);
			((LabelContext)_localctx).name = match(STRING);
			setState(176);
			labelBody();
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

	public static class LabelBodyContext extends ParserRuleContext {
		public IfSequenceContext ifSequence() {
			return getRuleContext(IfSequenceContext.class,0);
		}
		public LabelTextContext labelText() {
			return getRuleContext(LabelTextContext.class,0);
		}
		public LabelBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLabelBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLabelBody(this);
		}
	}

	public final LabelBodyContext labelBody() throws RecognitionException {
		LabelBodyContext _localctx = new LabelBodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_labelBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__1);
			setState(181);
			switch (_input.LA(1)) {
			case T__19:
				{
				setState(179);
				ifSequence();
				}
				break;
			case T__5:
				{
				setState(180);
				labelText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
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

	public static class LabelTextContext extends ParserRuleContext {
		public Token text;
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public LabelTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLabelText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLabelText(this);
		}
	}

	public final LabelTextContext labelText() throws RecognitionException {
		LabelTextContext _localctx = new LabelTextContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_labelText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__5);
			setState(186);
			((LabelTextContext)_localctx).text = match(STRING);
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

	public static class InputContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitInput(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__23);
			setState(189);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token operator;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(QLParser.TIMES, 0); }
		public TerminalNode DIVISION() { return getToken(QLParser.DIVISION, 0); }
		public TerminalNode ADDITION() { return getToken(QLParser.ADDITION, 0); }
		public TerminalNode SUBTRACTION() { return getToken(QLParser.SUBTRACTION, 0); }
		public TerminalNode SMALLETHANOREQUAL() { return getToken(QLParser.SMALLETHANOREQUAL, 0); }
		public TerminalNode BIGGERTHANOREQUAL() { return getToken(QLParser.BIGGERTHANOREQUAL, 0); }
		public TerminalNode BIGGERTHAN() { return getToken(QLParser.BIGGERTHAN, 0); }
		public TerminalNode SMALLERTHAN() { return getToken(QLParser.SMALLERTHAN, 0); }
		public TerminalNode EQUALTO() { return getToken(QLParser.EQUALTO, 0); }
		public TerminalNode NOTEQUALTO() { return getToken(QLParser.NOTEQUALTO, 0); }
		public TerminalNode AND() { return getToken(QLParser.AND, 0); }
		public TerminalNode OR() { return getToken(QLParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			switch (_input.LA(1)) {
			case T__15:
			case STRING:
			case NUMBER:
			case TEXT:
				{
				setState(192);
				id();
				}
				break;
			case T__24:
				{
				setState(193);
				match(T__24);
				setState(194);
				expression(0);
				setState(195);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(200);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVISION) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(201);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(203);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADDITION || _la==SUBTRACTION) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(204);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(206);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SMALLETHANOREQUAL) | (1L << BIGGERTHANOREQUAL) | (1L << BIGGERTHAN) | (1L << SMALLERTHAN) | (1L << EQUALTO) | (1L << NOTEQUALTO))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(207);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(209);
						((ExpressionContext)_localctx).operator = match(AND);
						setState(210);
						expression(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(212);
						((ExpressionContext)_localctx).operator = match(OR);
						setState(213);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class IdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(QLParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(QLParser.TEXT, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_id);
		try {
			setState(226);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__15);
				setState(220);
				id();
				setState(221);
				match(T__16);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(STRING);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(NUMBER);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(TEXT);
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
		case 25:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00e7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\3\3\3\6\3?\n\3\r\3\16"+
		"\3@\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\6\5N\n\5\r\5\16\5O\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\\\n\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\5\tf\n\t\3\n\3\n\3\13\3\13\3\13\3\13\6\13n\n\13\r\13\16\13o\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\5\fx\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\6\21\u008b\n\21\r\21\16"+
		"\21\u008c\3\21\3\21\3\22\3\22\7\22\u0093\n\22\f\22\16\22\u0096\13\22\3"+
		"\22\5\22\u0099\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\6\26\u00ab\n\26\r\26\16\26\u00ac\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u00b8\n\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00c8\n\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u00d9\n\33\f\33\16\33\u00dc\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u00e5\n\34\3\34\2\3\64\35\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\66\2\6\3\2\n\21\3\2\35\36\3\2\37 \3\2!&\u00e7"+
		"\28\3\2\2\2\4<\3\2\2\2\6D\3\2\2\2\bH\3\2\2\2\nS\3\2\2\2\fW\3\2\2\2\16"+
		"_\3\2\2\2\20b\3\2\2\2\22g\3\2\2\2\24i\3\2\2\2\26s\3\2\2\2\30y\3\2\2\2"+
		"\32}\3\2\2\2\34\u0080\3\2\2\2\36\u0083\3\2\2\2 \u0087\3\2\2\2\"\u0090"+
		"\3\2\2\2$\u009a\3\2\2\2&\u009e\3\2\2\2(\u00a1\3\2\2\2*\u00a5\3\2\2\2,"+
		"\u00b0\3\2\2\2.\u00b4\3\2\2\2\60\u00bb\3\2\2\2\62\u00be\3\2\2\2\64\u00c7"+
		"\3\2\2\2\66\u00e4\3\2\2\289\7\3\2\29:\7)\2\2:;\5\4\3\2;\3\3\2\2\2<>\7"+
		"\4\2\2=?\5\6\4\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7"+
		"\5\2\2C\5\3\2\2\2DE\7\6\2\2EF\7)\2\2FG\5\b\5\2G\7\3\2\2\2HM\7\4\2\2IN"+
		"\5\n\6\2JN\5\36\20\2KN\5\"\22\2LN\5,\27\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2"+
		"\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\5\2\2R\t\3\2"+
		"\2\2ST\7\7\2\2TU\7)\2\2UV\5\f\7\2V\13\3\2\2\2WX\7\4\2\2XY\5\16\b\2Y[\5"+
		"\20\t\2Z\\\5\26\f\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\5\2\2^\r\3\2\2"+
		"\2_`\7\b\2\2`a\7)\2\2a\17\3\2\2\2be\7\t\2\2cf\5\22\n\2df\5\24\13\2ec\3"+
		"\2\2\2ed\3\2\2\2f\21\3\2\2\2gh\t\2\2\2h\23\3\2\2\2ij\7\22\2\2jm\7)\2\2"+
		"kl\7(\2\2ln\7)\2\2mk\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2q"+
		"r\7\23\2\2r\25\3\2\2\2sw\7\24\2\2tx\5\30\r\2ux\5\32\16\2vx\5\34\17\2w"+
		"t\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\27\3\2\2\2yz\7*\2\2z{\7 \2\2{|\7*\2\2|"+
		"\31\3\2\2\2}~\7#\2\2~\177\7*\2\2\177\33\3\2\2\2\u0080\u0081\7$\2\2\u0081"+
		"\u0082\7*\2\2\u0082\35\3\2\2\2\u0083\u0084\7\25\2\2\u0084\u0085\7)\2\2"+
		"\u0085\u0086\5 \21\2\u0086\37\3\2\2\2\u0087\u008a\7\4\2\2\u0088\u008b"+
		"\5\"\22\2\u0089\u008b\5\62\32\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2"+
		"\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008f\7\5\2\2\u008f!\3\2\2\2\u0090\u0094\5$\23\2\u0091"+
		"\u0093\5(\25\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0099\5&\24\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099#\3\2\2\2"+
		"\u009a\u009b\7\26\2\2\u009b\u009c\5\64\33\2\u009c\u009d\5*\26\2\u009d"+
		"%\3\2\2\2\u009e\u009f\7\27\2\2\u009f\u00a0\5*\26\2\u00a0\'\3\2\2\2\u00a1"+
		"\u00a2\7\30\2\2\u00a2\u00a3\5\64\33\2\u00a3\u00a4\5*\26\2\u00a4)\3\2\2"+
		"\2\u00a5\u00aa\7\4\2\2\u00a6\u00ab\5\n\6\2\u00a7\u00ab\5\36\20\2\u00a8"+
		"\u00ab\5\62\32\2\u00a9\u00ab\5\60\31\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\5"+
		"\2\2\u00af+\3\2\2\2\u00b0\u00b1\7\31\2\2\u00b1\u00b2\7)\2\2\u00b2\u00b3"+
		"\5.\30\2\u00b3-\3\2\2\2\u00b4\u00b7\7\4\2\2\u00b5\u00b8\5\"\22\2\u00b6"+
		"\u00b8\5\60\31\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3"+
		"\2\2\2\u00b9\u00ba\7\5\2\2\u00ba/\3\2\2\2\u00bb\u00bc\7\b\2\2\u00bc\u00bd"+
		"\7)\2\2\u00bd\61\3\2\2\2\u00be\u00bf\7\32\2\2\u00bf\u00c0\5\64\33\2\u00c0"+
		"\63\3\2\2\2\u00c1\u00c2\b\33\1\2\u00c2\u00c8\5\66\34\2\u00c3\u00c4\7\33"+
		"\2\2\u00c4\u00c5\5\64\33\2\u00c5\u00c6\7\34\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c1\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\u00da\3\2\2\2\u00c9\u00ca\f\7"+
		"\2\2\u00ca\u00cb\t\3\2\2\u00cb\u00d9\5\64\33\b\u00cc\u00cd\f\6\2\2\u00cd"+
		"\u00ce\t\4\2\2\u00ce\u00d9\5\64\33\7\u00cf\u00d0\f\5\2\2\u00d0\u00d1\t"+
		"\5\2\2\u00d1\u00d9\5\64\33\6\u00d2\u00d3\f\4\2\2\u00d3\u00d4\7\'\2\2\u00d4"+
		"\u00d9\5\64\33\5\u00d5\u00d6\f\3\2\2\u00d6\u00d7\7(\2\2\u00d7\u00d9\5"+
		"\64\33\4\u00d8\u00c9\3\2\2\2\u00d8\u00cc\3\2\2\2\u00d8\u00cf\3\2\2\2\u00d8"+
		"\u00d2\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\65\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de"+
		"\7\22\2\2\u00de\u00df\5\66\34\2\u00df\u00e0\7\23\2\2\u00e0\u00e5\3\2\2"+
		"\2\u00e1\u00e5\7)\2\2\u00e2\u00e5\7*\2\2\u00e3\u00e5\7+\2\2\u00e4\u00dd"+
		"\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\67\3\2\2\2\24@MO[eow\u008a\u008c\u0094\u0098\u00aa\u00ac\u00b7\u00c7"+
		"\u00d8\u00da\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}