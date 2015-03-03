// Generated from /Users/Sugar/Documents/Msc/Software-Construction/many-ql/Fugazi/src/org/fugazi/qls/grammar/QLS.g4 by ANTLR 4.5
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		STRING=25, ID=26, NUMBER=27, HEX=28, COMMENT=29, WS=30, LINE_COMMENT=31;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_section = 2, RULE_question = 3, 
		RULE_widget = 4, RULE_defaultStyleDeclr = 5, RULE_supportedWidget = 6, 
		RULE_styleProperty = 7, RULE_type = 8;
	public static final String[] ruleNames = {
		"stylesheet", "page", "section", "question", "widget", "defaultStyleDeclr", 
		"supportedWidget", "styleProperty", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'{'", "'}'", "'section'", "'question'", 
		"'widget'", "'default'", "'checkbox'", "'radio'", "'('", "','", "')'", 
		"'dropdown'", "'spinbox'", "'slider'", "'text'", "'width:'", "'font:'", 
		"'fontsize:'", "'color:'", "'bool'", "'int'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "STRING", "ID", "NUMBER", "HEX", "COMMENT", "WS", "LINE_COMMENT"
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
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			match(T__0);
			setState(19); 
			match(ID);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(20); 
				page();
				}
				}
				setState(25);
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

	public static class PageContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public List<DefaultStyleDeclrContext> defaultStyleDeclr() {
			return getRuleContexts(DefaultStyleDeclrContext.class);
		}
		public DefaultStyleDeclrContext defaultStyleDeclr(int i) {
			return getRuleContext(DefaultStyleDeclrContext.class,i);
		}
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
			setState(26); 
			match(T__1);
			setState(27); 
			match(ID);
			setState(28); 
			match(T__2);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__7) {
				{
				setState(31);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(29); 
					defaultStyleDeclr();
					}
					break;
				case T__4:
					{
					setState(30); 
					section();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36); 
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
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<DefaultStyleDeclrContext> defaultStyleDeclr() {
			return getRuleContexts(DefaultStyleDeclrContext.class);
		}
		public DefaultStyleDeclrContext defaultStyleDeclr(int i) {
			return getRuleContext(DefaultStyleDeclrContext.class,i);
		}
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
		int _la;
		try {
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); 
				match(T__4);
				setState(39); 
				match(STRING);
				setState(40); 
				question();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); 
				match(T__4);
				setState(42); 
				match(STRING);
				setState(43); 
				match(T__2);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7))) != 0)) {
					{
					setState(47);
					switch (_input.LA(1)) {
					case T__5:
						{
						setState(44); 
						question();
						}
						break;
					case T__4:
						{
						setState(45); 
						section();
						}
						break;
					case T__7:
						{
						setState(46); 
						defaultStyleDeclr();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(52); 
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public DefaultStyleDeclrContext defaultStyleDeclr() {
			return getRuleContext(DefaultStyleDeclrContext.class,0);
		}
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
			setState(55); 
			match(T__5);
			setState(56); 
			match(ID);
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(57); 
				widget();
				}
				break;
			case 2:
				{
				setState(58); 
				defaultStyleDeclr();
				}
				break;
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

	public static class WidgetContext extends ParserRuleContext {
		public SupportedWidgetContext supportedWidget() {
			return getRuleContext(SupportedWidgetContext.class,0);
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
			setState(61); 
			match(T__6);
			setState(62); 
			supportedWidget();
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

	public static class DefaultStyleDeclrContext extends ParserRuleContext {
		public DefaultStyleDeclrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStyleDeclr; }
	 
		public DefaultStyleDeclrContext() { }
		public void copyFrom(DefaultStyleDeclrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StylesDefaultDeclrContext extends DefaultStyleDeclrContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public List<StylePropertyContext> styleProperty() {
			return getRuleContexts(StylePropertyContext.class);
		}
		public StylePropertyContext styleProperty(int i) {
			return getRuleContext(StylePropertyContext.class,i);
		}
		public StylesDefaultDeclrContext(DefaultStyleDeclrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesDefaultDeclr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoStylesDefaultDeclrContext extends DefaultStyleDeclrContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public NoStylesDefaultDeclrContext(DefaultStyleDeclrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitNoStylesDefaultDeclr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStyleDeclrContext defaultStyleDeclr() throws RecognitionException {
		DefaultStyleDeclrContext _localctx = new DefaultStyleDeclrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultStyleDeclr);
		int _la;
		try {
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new NoStylesDefaultDeclrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64); 
				match(T__7);
				setState(65); 
				type();
				setState(66); 
				widget();
				}
				break;
			case 2:
				_localctx = new StylesDefaultDeclrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68); 
				match(T__7);
				setState(69); 
				type();
				setState(70); 
				match(T__2);
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71); 
					styleProperty();
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0) );
				setState(76); 
				widget();
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

	public static class SupportedWidgetContext extends ParserRuleContext {
		public SupportedWidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supportedWidget; }
	 
		public SupportedWidgetContext() { }
		public void copyFrom(SupportedWidgetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SpinboxWidgetContext extends SupportedWidgetContext {
		public SpinboxWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSpinboxWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextWidgetContext extends SupportedWidgetContext {
		public TextWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitTextWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RadioWidgetContext extends SupportedWidgetContext {
		public Token yes;
		public Token no;
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public RadioWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitRadioWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropdownWidgetContext extends SupportedWidgetContext {
		public DropdownWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDropdownWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckboxWidgetContext extends SupportedWidgetContext {
		public CheckboxWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCheckboxWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SliderWidgetContext extends SupportedWidgetContext {
		public SliderWidgetContext(SupportedWidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSliderWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SupportedWidgetContext supportedWidget() throws RecognitionException {
		SupportedWidgetContext _localctx = new SupportedWidgetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_supportedWidget);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new CheckboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81); 
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new RadioWidgetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82); 
				match(T__9);
				setState(83); 
				match(T__10);
				setState(84); 
				((RadioWidgetContext)_localctx).yes = match(STRING);
				setState(85); 
				match(T__11);
				setState(86); 
				((RadioWidgetContext)_localctx).no = match(STRING);
				setState(87); 
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new DropdownWidgetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88); 
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new SpinboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(89); 
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new SliderWidgetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(90); 
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new TextWidgetContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91); 
				match(T__16);
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

	public static class StylePropertyContext extends ParserRuleContext {
		public StylePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleProperty; }
	 
		public StylePropertyContext() { }
		public void copyFrom(StylePropertyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WidthStylePropertyContext extends StylePropertyContext {
		public TerminalNode NUMBER() { return getToken(QLSParser.NUMBER, 0); }
		public WidthStylePropertyContext(StylePropertyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidthStyleProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorStylePropertyContext extends StylePropertyContext {
		public TerminalNode HEX() { return getToken(QLSParser.HEX, 0); }
		public ColorStylePropertyContext(StylePropertyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitColorStyleProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FontsizeStylePropertyContext extends StylePropertyContext {
		public TerminalNode NUMBER() { return getToken(QLSParser.NUMBER, 0); }
		public FontsizeStylePropertyContext(StylePropertyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFontsizeStyleProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FontStylePropertyContext extends StylePropertyContext {
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public FontStylePropertyContext(StylePropertyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFontStyleProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylePropertyContext styleProperty() throws RecognitionException {
		StylePropertyContext _localctx = new StylePropertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_styleProperty);
		try {
			setState(102);
			switch (_input.LA(1)) {
			case T__17:
				_localctx = new WidthStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94); 
				match(T__17);
				setState(95); 
				match(NUMBER);
				}
				break;
			case T__18:
				_localctx = new FontStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); 
				match(T__18);
				setState(97); 
				match(STRING);
				}
				break;
			case T__19:
				_localctx = new FontsizeStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98); 
				match(T__19);
				setState(99); 
				match(NUMBER);
				}
				break;
			case T__20:
				_localctx = new ColorStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(100); 
				match(T__20);
				setState(101); 
				match(HEX);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringTypeContext extends TypeContext {
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(107);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104); 
				match(T__21);
				}
				break;
			case T__22:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105); 
				match(T__22);
				}
				break;
			case T__23:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106); 
				match(T__23);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!p\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\7"+
		"\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4\16\4\65"+
		"\13\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\6\7K\n\7\r\7\16\7L\3\7\3\7\3\7\5\7R\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\ti\n\t\3\n\3\n\3\n\5\nn\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2"+
		"{\2\24\3\2\2\2\4\34\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\n?\3\2\2\2\fQ\3\2"+
		"\2\2\16^\3\2\2\2\20h\3\2\2\2\22m\3\2\2\2\24\25\7\3\2\2\25\31\7\34\2\2"+
		"\26\30\5\4\3\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2"+
		"\32\3\3\2\2\2\33\31\3\2\2\2\34\35\7\4\2\2\35\36\7\34\2\2\36#\7\5\2\2\37"+
		"\"\5\f\7\2 \"\5\6\4\2!\37\3\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2"+
		"\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\6\2\2\'\5\3\2\2\2()\7\7\2\2)*\7\33\2\2*"+
		"8\5\b\5\2+,\7\7\2\2,-\7\33\2\2-\63\7\5\2\2.\62\5\b\5\2/\62\5\6\4\2\60"+
		"\62\5\f\7\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\668\7\6\2\2\67(\3\2"+
		"\2\2\67+\3\2\2\28\7\3\2\2\29:\7\b\2\2:=\7\34\2\2;>\5\n\6\2<>\5\f\7\2="+
		";\3\2\2\2=<\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?@\7\t\2\2@A\5\16\b\2A\13\3\2"+
		"\2\2BC\7\n\2\2CD\5\22\n\2DE\5\n\6\2ER\3\2\2\2FG\7\n\2\2GH\5\22\n\2HJ\7"+
		"\5\2\2IK\5\20\t\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO"+
		"\5\n\6\2OP\7\6\2\2PR\3\2\2\2QB\3\2\2\2QF\3\2\2\2R\r\3\2\2\2S_\7\13\2\2"+
		"TU\7\f\2\2UV\7\r\2\2VW\7\33\2\2WX\7\16\2\2XY\7\33\2\2Y_\7\17\2\2Z_\7\20"+
		"\2\2[_\7\21\2\2\\_\7\22\2\2]_\7\23\2\2^S\3\2\2\2^T\3\2\2\2^Z\3\2\2\2^"+
		"[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\17\3\2\2\2`a\7\24\2\2ai\7\35\2\2bc\7\25"+
		"\2\2ci\7\33\2\2de\7\26\2\2ei\7\35\2\2fg\7\27\2\2gi\7\36\2\2h`\3\2\2\2"+
		"hb\3\2\2\2hd\3\2\2\2hf\3\2\2\2i\21\3\2\2\2jn\7\30\2\2kn\7\31\2\2ln\7\32"+
		"\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\23\3\2\2\2\16\31!#\61\63\67=LQ^hm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}