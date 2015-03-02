// Generated from /home/alex/Develop/Msc/many-ql/Fugazi/src/org/fugazi/qls/grammar/QLS.g4 by ANTLR 4.5
package org.fugazi.qls.parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, STRING=14, ID=15, COMMENT=16, WS=17, 
		LINE_COMMENT=18;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_section = 2, RULE_question = 3, 
		RULE_widget = 4, RULE_widgets = 5;
	public static final String[] ruleNames = {
		"stylesheet", "page", "section", "question", "widget", "widgets"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'{'", "'}'", "'section'", "'question'", 
		"'widget'", "'checkbox'", "'radio'", "'dropdown'", "'spinbox'", "'slider'", 
		"'text'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "STRING", "ID", "COMMENT", "WS", "LINE_COMMENT"
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
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); 
			match(T__0);
			setState(13); 
			match(ID);
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
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			match(T__1);
			setState(16); 
			match(ID);
			setState(17); 
			match(T__2);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(18); 
				section();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24); 
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			match(T__4);
			setState(27); 
			match(STRING);
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
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			match(T__5);
			setState(30); 
			match(ID);
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

	public static class WidgetContext extends ParserRuleContext {
		public WidgetsContext widgets() {
			return getRuleContext(WidgetsContext.class,0);
		}
		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widget; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_widget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			match(T__6);
			setState(33); 
			widgets();
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

	public static class WidgetsContext extends ParserRuleContext {
		public WidgetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widgets; }
	 
		public WidgetsContext() { }
		public void copyFrom(WidgetsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SpinboxWidgetContext extends WidgetsContext {
		public SpinboxWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSpinboxWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckboxWidgetContext extends WidgetsContext {
		public CheckboxWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCheckboxWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextWidgetContext extends WidgetsContext {
		public TextWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitTextWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropdownWidgetContext extends WidgetsContext {
		public DropdownWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDropdownWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SliderWidgetContext extends WidgetsContext {
		public SliderWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSliderWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RadioWidgetContext extends WidgetsContext {
		public RadioWidgetContext(WidgetsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitRadioWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetsContext widgets() throws RecognitionException {
		WidgetsContext _localctx = new WidgetsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_widgets);
		try {
			setState(41);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new CheckboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35); 
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new RadioWidgetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36); 
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new DropdownWidgetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37); 
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new SpinboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38); 
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new SliderWidgetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(39); 
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new TextWidgetContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(40); 
				match(T__12);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24.\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\26"+
		"\n\3\f\3\16\3\31\13\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7,\n\7\3\7\2\2\b\2\4\6\b\n\f\2\2-\2\16\3\2\2\2"+
		"\4\21\3\2\2\2\6\34\3\2\2\2\b\37\3\2\2\2\n\"\3\2\2\2\f+\3\2\2\2\16\17\7"+
		"\3\2\2\17\20\7\21\2\2\20\3\3\2\2\2\21\22\7\4\2\2\22\23\7\21\2\2\23\27"+
		"\7\5\2\2\24\26\5\6\4\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\6\2\2\33\5\3\2\2\2\34\35"+
		"\7\7\2\2\35\36\7\20\2\2\36\7\3\2\2\2\37 \7\b\2\2 !\7\21\2\2!\t\3\2\2\2"+
		"\"#\7\t\2\2#$\5\f\7\2$\13\3\2\2\2%,\7\n\2\2&,\7\13\2\2\',\7\f\2\2(,\7"+
		"\r\2\2),\7\16\2\2*,\7\17\2\2+%\3\2\2\2+&\3\2\2\2+\'\3\2\2\2+(\3\2\2\2"+
		"+)\3\2\2\2+*\3\2\2\2,\r\3\2\2\2\4\27+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}