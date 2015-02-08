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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, QuestionId=20, Letter=21, LetterOrDigit=22, Digit=23, 
		Answers=24, NEWLINE=25, NONEWLINE=26, WS=27, COMMENT=28, LINE_COMMENT=29;
	public static final int
		RULE_questionaire = 0, RULE_group = 1, RULE_groupBegin = 2, RULE_groupEnd = 3, 
		RULE_specification = 4, RULE_questionType = 5;
	public static final String[] ruleNames = {
		"questionaire", "group", "groupBegin", "groupEnd", "specification", "questionType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'page'", "'section'", "'questions'", "'question'", "'end'", "'id'", 
		"':'", "'type'", "'value'", "'text'", "'requires'", "'only'", "'radio'", 
		"'boolean'", "'date'", "'currency'", "'dropdown'", "'string'", "'numeral'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "QuestionId", "Letter", 
		"LetterOrDigit", "Digit", "Answers", "NEWLINE", "NONEWLINE", "WS", "COMMENT", 
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
	public static class QuestionaireContext extends ParserRuleContext {
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); 
				group();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0) );
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

	public static class GroupContext extends ParserRuleContext {
		public GroupBeginContext groupBegin() {
			return getRuleContext(GroupBeginContext.class,0);
		}
		public GroupEndContext groupEnd() {
			return getRuleContext(GroupEndContext.class,0);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(KLQParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KLQParser.NEWLINE, i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			groupBegin();
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); 
				specification();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) );
			setState(23); 
			groupEnd();
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); 
				match(NEWLINE);
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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

	public static class GroupBeginContext extends ParserRuleContext {
		public GroupBeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupBegin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterGroupBegin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitGroupBegin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitGroupBegin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupBeginContext groupBegin() throws RecognitionException {
		GroupBeginContext _localctx = new GroupBeginContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_groupBegin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
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

	public static class GroupEndContext extends ParserRuleContext {
		public GroupEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).enterGroupEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KLQListener ) ((KLQListener)listener).exitGroupEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitGroupEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupEndContext groupEnd() throws RecognitionException {
		GroupEndContext _localctx = new GroupEndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			match(T__4);
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
		public TerminalNode Answers() { return getToken(KLQParser.Answers, 0); }
		public TerminalNode NONEWLINE() { return getToken(KLQParser.NONEWLINE, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(33); 
				match(T__5);
				setState(34); 
				match(T__6);
				setState(35); 
				match(QuestionId);
				}
				break;
			case T__7:
				{
				setState(36); 
				match(T__7);
				setState(37); 
				match(T__6);
				setState(38); 
				questionType();
				}
				break;
			case T__8:
				{
				setState(39); 
				match(T__8);
				setState(40); 
				match(T__6);
				setState(41); 
				match(Answers);
				}
				break;
			case T__9:
				{
				setState(42); 
				match(T__9);
				setState(43); 
				match(T__6);
				setState(44); 
				match(NONEWLINE);
				}
				break;
			case T__10:
				{
				setState(45); 
				match(T__10);
				setState(46); 
				match(T__6);
				setState(47); 
				match(QuestionId);
				}
				break;
			case T__11:
				{
				setState(48); 
				match(T__11);
				setState(49); 
				match(T__6);
				setState(50); 
				match(Answers);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KLQVisitor ) return ((KLQVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37<\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\6\3\26\n\3\r\3\16\3\27\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\66\n\6\3\6\3\6\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\4\3\2\3\6\3\2\17"+
		"\25=\2\17\3\2\2\2\4\23\3\2\2\2\6\37\3\2\2\2\b!\3\2\2\2\n\65\3\2\2\2\f"+
		"9\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22"+
		"\3\2\2\2\22\3\3\2\2\2\23\25\5\6\4\2\24\26\5\n\6\2\25\24\3\2\2\2\26\27"+
		"\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\33\5\b\5\2\32\34"+
		"\7\33\2\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\5"+
		"\3\2\2\2\37 \t\2\2\2 \7\3\2\2\2!\"\7\7\2\2\"\t\3\2\2\2#$\7\b\2\2$%\7\t"+
		"\2\2%\66\7\26\2\2&\'\7\n\2\2\'(\7\t\2\2(\66\5\f\7\2)*\7\13\2\2*+\7\t\2"+
		"\2+\66\7\32\2\2,-\7\f\2\2-.\7\t\2\2.\66\7\34\2\2/\60\7\r\2\2\60\61\7\t"+
		"\2\2\61\66\7\26\2\2\62\63\7\16\2\2\63\64\7\t\2\2\64\66\7\32\2\2\65#\3"+
		"\2\2\2\65&\3\2\2\2\65)\3\2\2\2\65,\3\2\2\2\65/\3\2\2\2\65\62\3\2\2\2\66"+
		"\67\3\2\2\2\678\7\33\2\28\13\3\2\2\29:\t\3\2\2:\r\3\2\2\2\6\21\27\35\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}