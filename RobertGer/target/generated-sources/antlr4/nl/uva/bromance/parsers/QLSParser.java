// Generated from nl\u005Cuva\bromance\parsers\QLS.g4 by ANTLR 4.5
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
public class QLSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6, NUMBER=7, TEXT=8, COMMENT=9, 
		WS=10;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_pageBody = 2, RULE_section = 3, 
		RULE_sectionBody = 4, RULE_question = 5, RULE_questionBody = 6;
	public static final String[] ruleNames = {
		"stylesheet", "page", "pageBody", "section", "sectionBody", "question", 
		"questionBody"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Page:'", "'{'", "'}'", "'Section:'", "'Question:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "STRING", "NUMBER", "TEXT", "COMMENT", 
		"WS"
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
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(14);
					page();
					}
					}
					setState(19);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(20);
					question();
					}
					}
					setState(25);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class PageContext extends ParserRuleContext {
		public Token name;
		public PageBodyContext pageBody() {
			return getRuleContext(PageBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitPage(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_page);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			((PageContext)_localctx).name = match(STRING);
			setState(30);
			pageBody();
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

	public static class PageBodyContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public PageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterPageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitPageBody(this);
		}
	}

	public final PageBodyContext pageBody() throws RecognitionException {
		PageBodyContext _localctx = new PageBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__1);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				setState(35);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(33);
					section();
					}
					break;
				case T__4:
					{
					setState(34);
					question();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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

	public static class SectionContext extends ParserRuleContext {
		public Token name;
		public SectionBodyContext sectionBody() {
			return getRuleContext(SectionBodyContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__3);
			setState(43);
			((SectionContext)_localctx).name = match(STRING);
			setState(44);
			sectionBody();
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

	public static class SectionBodyContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSectionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSectionBody(this);
		}
	}

	public final SectionBodyContext sectionBody() throws RecognitionException {
		SectionBodyContext _localctx = new SectionBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sectionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__1);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(47);
				question();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__4);
			setState(56);
			((QuestionContext)_localctx).name = match(STRING);
			setState(57);
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
		public QuestionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestionBody(this);
		}
	}

	public final QuestionBodyContext questionBody() throws RecognitionException {
		QuestionBodyContext _localctx = new QuestionBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__1);
			setState(60);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fA\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\7\4&\n\4\f\4\16\4)\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6\63"+
		"\n\6\f\6\16\6\66\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\2"+
		"\4\6\b\n\f\16\2\2?\2\34\3\2\2\2\4\36\3\2\2\2\6\"\3\2\2\2\b,\3\2\2\2\n"+
		"\60\3\2\2\2\f9\3\2\2\2\16=\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\25\3"+
		"\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\35\3\2\2\2\25\23\3\2\2\2\26\30\5"+
		"\f\7\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\35\3"+
		"\2\2\2\33\31\3\2\2\2\34\23\3\2\2\2\34\31\3\2\2\2\35\3\3\2\2\2\36\37\7"+
		"\3\2\2\37 \7\b\2\2 !\5\6\4\2!\5\3\2\2\2\"\'\7\4\2\2#&\5\b\5\2$&\5\f\7"+
		"\2%#\3\2\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3"+
		"\2\2\2*+\7\5\2\2+\7\3\2\2\2,-\7\6\2\2-.\7\b\2\2./\5\n\6\2/\t\3\2\2\2\60"+
		"\64\7\4\2\2\61\63\5\f\7\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\5\2\28\13\3\2\2\29:\7\7"+
		"\2\2:;\7\b\2\2;<\5\16\b\2<\r\3\2\2\2=>\7\4\2\2>?\7\5\2\2?\17\3\2\2\2\b"+
		"\23\31\34%\'\64";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}