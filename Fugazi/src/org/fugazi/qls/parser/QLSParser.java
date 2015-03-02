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
		T__17=18, T__18=19, T__19=20, T__20=21, STRING=22, ID=23, NUMBER=24, HEX=25, 
		COMMENT=26, WS=27, LINE_COMMENT=28;
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
		"'widget'", "'default'", "'checkbox'", "'radio'", "'dropdown'", "'spinbox'", 
		"'slider'", "'text'", "'width:'", "'font:'", "'fontsize:'", "'color:'", 
		"'bool'", "'int'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "STRING", 
		"ID", "NUMBER", "HEX", "COMMENT", "WS", "LINE_COMMENT"
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
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			match(T__4);
			setState(39); 
			match(STRING);
			setState(40); 
			match(T__2);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__5) {
				{
				setState(43);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(41); 
					question();
					}
					break;
				case T__4:
					{
					setState(42); 
					section();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48); 
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLSParser.ID, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
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
			setState(50); 
			match(T__5);
			setState(51); 
			match(ID);
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1+1:
				{
				setState(52); 
				widget();
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
		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widget; }
	 
		public WidgetContext() { }
		public void copyFrom(WidgetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleWidgetContext extends WidgetContext {
		public SupportedWidgetContext supportedWidget() {
			return getRuleContext(SupportedWidgetContext.class,0);
		}
		public SimpleWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSimpleWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefaultStyleWidgetContext extends WidgetContext {
		public DefaultStyleDeclrContext defaultStyleDeclr() {
			return getRuleContext(DefaultStyleDeclrContext.class,0);
		}
		public DefaultStyleWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefaultStyleWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_widget);
		try {
			setState(58);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new SimpleWidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55); 
				match(T__6);
				setState(56); 
				supportedWidget();
				}
				break;
			case T__7:
				_localctx = new DefaultStyleWidgetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57); 
				defaultStyleDeclr();
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
	public static class NoStylesDefaultContext extends DefaultStyleDeclrContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public NoStylesDefaultContext(DefaultStyleDeclrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitNoStylesDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StylesDefaultContext extends DefaultStyleDeclrContext {
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
		public StylesDefaultContext(DefaultStyleDeclrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStyleDeclrContext defaultStyleDeclr() throws RecognitionException {
		DefaultStyleDeclrContext _localctx = new DefaultStyleDeclrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultStyleDeclr);
		int _la;
		try {
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new NoStylesDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60); 
				match(T__7);
				setState(61); 
				type();
				setState(62); 
				widget();
				}
				break;
			case 2:
				_localctx = new StylesDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64); 
				match(T__7);
				setState(65); 
				type();
				setState(66); 
				match(T__2);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) {
					{
					{
					setState(67); 
					styleProperty();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73); 
				widget();
				setState(74); 
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
			setState(84);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new CheckboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78); 
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new RadioWidgetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79); 
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new DropdownWidgetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80); 
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new SpinboxWidgetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81); 
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new SliderWidgetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82); 
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new TextWidgetContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83); 
				match(T__13);
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
			setState(94);
			switch (_input.LA(1)) {
			case T__14:
				_localctx = new WidthStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86); 
				match(T__14);
				setState(87); 
				match(NUMBER);
				}
				break;
			case T__15:
				_localctx = new FontStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88); 
				match(T__15);
				setState(89); 
				match(STRING);
				}
				break;
			case T__16:
				_localctx = new FontsizeStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90); 
				match(T__16);
				setState(91); 
				match(NUMBER);
				}
				break;
			case T__17:
				_localctx = new ColorStylePropertyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92); 
				match(T__17);
				setState(93); 
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
			setState(99);
			switch (_input.LA(1)) {
			case T__18:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96); 
				match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97); 
				match(T__19);
				}
				break;
			case T__20:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98); 
				match(T__20);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\5\58\n\5\3\6\3\6\3\6\5\6=\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7G\n\7\f\7\16\7J\13\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bW\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\3\n\5\nf\n\n"+
		"\3\n\3\67\2\13\2\4\6\b\n\f\16\20\22\2\2q\2\24\3\2\2\2\4\34\3\2\2\2\6("+
		"\3\2\2\2\b\64\3\2\2\2\n<\3\2\2\2\fN\3\2\2\2\16V\3\2\2\2\20`\3\2\2\2\22"+
		"e\3\2\2\2\24\25\7\3\2\2\25\31\7\31\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30"+
		"\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34"+
		"\35\7\4\2\2\35\36\7\31\2\2\36#\7\5\2\2\37\"\5\f\7\2 \"\5\6\4\2!\37\3\2"+
		"\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7"+
		"\6\2\2\'\5\3\2\2\2()\7\7\2\2)*\7\30\2\2*/\7\5\2\2+.\5\b\5\2,.\5\6\4\2"+
		"-+\3\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61"+
		"/\3\2\2\2\62\63\7\6\2\2\63\7\3\2\2\2\64\65\7\b\2\2\65\67\7\31\2\2\668"+
		"\5\n\6\2\678\3\2\2\2\67\66\3\2\2\28\t\3\2\2\29:\7\t\2\2:=\5\16\b\2;=\5"+
		"\f\7\2<9\3\2\2\2<;\3\2\2\2=\13\3\2\2\2>?\7\n\2\2?@\5\22\n\2@A\5\n\6\2"+
		"AO\3\2\2\2BC\7\n\2\2CD\5\22\n\2DH\7\5\2\2EG\5\20\t\2FE\3\2\2\2GJ\3\2\2"+
		"\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\5\n\6\2LM\7\6\2\2MO\3\2\2"+
		"\2N>\3\2\2\2NB\3\2\2\2O\r\3\2\2\2PW\7\13\2\2QW\7\f\2\2RW\7\r\2\2SW\7\16"+
		"\2\2TW\7\17\2\2UW\7\20\2\2VP\3\2\2\2VQ\3\2\2\2VR\3\2\2\2VS\3\2\2\2VT\3"+
		"\2\2\2VU\3\2\2\2W\17\3\2\2\2XY\7\21\2\2Ya\7\32\2\2Z[\7\22\2\2[a\7\30\2"+
		"\2\\]\7\23\2\2]a\7\32\2\2^_\7\24\2\2_a\7\33\2\2`X\3\2\2\2`Z\3\2\2\2`\\"+
		"\3\2\2\2`^\3\2\2\2a\21\3\2\2\2bf\7\25\2\2cf\7\26\2\2df\7\27\2\2eb\3\2"+
		"\2\2ec\3\2\2\2ed\3\2\2\2f\23\3\2\2\2\16\31!#-/\67<HNV`e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}