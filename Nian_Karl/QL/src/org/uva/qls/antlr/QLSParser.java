// Generated from QLS.g4 by ANTLR 4.5
package org.uva.qls.antlr;
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
		STYLE=1, PAGE=2, SECTION=3, QUESTION=4, DEFAULT=5, INT=6, STR=7, BOOL=8, 
		WIDGET=9, SLIDER=10, SPINBOX=11, TEXTBOX=12, RADIO=13, DROPDOWN=14, CHECKBOX=15, 
		WIDTH=16, HEIGHT=17, FONTSIZE=18, FONT=19, COLOR=20, ARIAL=21, COLON=22, 
		COMMA=23, LEFT_PAREN=24, RIGHT_PAREN=25, LEFT_BRACE=26, RIGHT_BRACE=27, 
		LEFT_BRACKET=28, RIGHT_BRACKET=29, IntegerLiteral=30, BooleanLiteral=31, 
		StringLiteral=32, WhiteSpace=33, MultiComment=34, SingleComment=35, Identifier=36, 
		RgbValue=37;
	public static final int
		RULE_sheet = 0, RULE_page = 1, RULE_pageBlock = 2, RULE_section = 3, RULE_question = 4, 
		RULE_style = 5, RULE_styling = 6, RULE_type = 7, RULE_font = 8, RULE_widget = 9;
	public static final String[] ruleNames = {
		"sheet", "page", "pageBlock", "section", "question", "style", "styling", 
		"type", "font", "widget"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'style'", "'page'", "'section'", "'question'", "'default'", "'Int'", 
		"'Str'", "'Bool'", "'widget'", "'slider'", "'spinbox'", "'textbox'", "'radio'", 
		"'dropdown'", "'checkbox'", "'width'", "'height'", "'fontsize'", "'font'", 
		"'color'", "'arial'", "':'", "','", "'('", "')'", "'{'", "'}'", "'['", 
		"']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STYLE", "PAGE", "SECTION", "QUESTION", "DEFAULT", "INT", "STR", 
		"BOOL", "WIDGET", "SLIDER", "SPINBOX", "TEXTBOX", "RADIO", "DROPDOWN", 
		"CHECKBOX", "WIDTH", "HEIGHT", "FONTSIZE", "FONT", "COLOR", "ARIAL", "COLON", 
		"COMMA", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "IntegerLiteral", "BooleanLiteral", "StringLiteral", 
		"WhiteSpace", "MultiComment", "SingleComment", "Identifier", "RgbValue"
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
	public static class SheetContext extends ParserRuleContext {
		public TerminalNode STYLE() { return getToken(QLSParser.STYLE, 0); }
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public SheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SheetContext sheet() throws RecognitionException {
		SheetContext _localctx = new SheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(STYLE);
			setState(21);
			match(Identifier);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PAGE) {
				{
				{
				setState(22);
				page();
				}
				}
				setState(27);
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
		public TerminalNode PAGE() { return getToken(QLSParser.PAGE, 0); }
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public PageBlockContext pageBlock() {
			return getRuleContext(PageBlockContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_page);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(PAGE);
			setState(29);
			match(Identifier);
			setState(30);
			pageBlock();
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

	public static class PageBlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(QLSParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(QLSParser.RIGHT_BRACE, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public PageBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterPageBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitPageBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPageBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageBlockContext pageBlock() throws RecognitionException {
		PageBlockContext _localctx = new PageBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pageBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(LEFT_BRACE);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SECTION) {
				{
				{
				setState(33);
				section();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT) {
				{
				{
				setState(39);
				style();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			match(RIGHT_BRACE);
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
		public TerminalNode SECTION() { return getToken(QLSParser.SECTION, 0); }
		public TerminalNode StringLiteral() { return getToken(QLSParser.StringLiteral, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(QLSParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(QLSParser.RIGHT_BRACE, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(SECTION);
			setState(48);
			match(StringLiteral);
			setState(49);
			match(LEFT_BRACE);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUESTION) {
				{
				{
				setState(50);
				question();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT) {
				{
				{
				setState(56);
				style();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(RIGHT_BRACE);
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
		public TerminalNode QUESTION() { return getToken(QLSParser.QUESTION, 0); }
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(QUESTION);
				setState(65);
				match(Identifier);
				setState(66);
				widget();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(QUESTION);
				setState(68);
				match(Identifier);
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

	public static class StyleContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(QLSParser.DEFAULT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StylingContext> styling() {
			return getRuleContexts(StylingContext.class);
		}
		public StylingContext styling(int i) {
			return getRuleContext(StylingContext.class,i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(QLSParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(QLSParser.RIGHT_BRACE, 0); }
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStyle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStyle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_style);
		int _la;
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(DEFAULT);
				setState(72);
				type();
				setState(73);
				styling();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(DEFAULT);
				setState(76);
				type();
				setState(77);
				match(LEFT_BRACE);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDGET) | (1L << WIDTH) | (1L << HEIGHT) | (1L << FONTSIZE) | (1L << FONT) | (1L << COLOR))) != 0)) {
					{
					{
					setState(78);
					styling();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(RIGHT_BRACE);
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

	public static class StylingContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode COLON() { return getToken(QLSParser.COLON, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public TerminalNode WIDTH() { return getToken(QLSParser.WIDTH, 0); }
		public TerminalNode IntegerLiteral() { return getToken(QLSParser.IntegerLiteral, 0); }
		public TerminalNode HEIGHT() { return getToken(QLSParser.HEIGHT, 0); }
		public TerminalNode FONTSIZE() { return getToken(QLSParser.FONTSIZE, 0); }
		public TerminalNode FONT() { return getToken(QLSParser.FONT, 0); }
		public FontContext font() {
			return getRuleContext(FontContext.class,0);
		}
		public TerminalNode COLOR() { return getToken(QLSParser.COLOR, 0); }
		public TerminalNode RgbValue() { return getToken(QLSParser.RgbValue, 0); }
		public StylingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styling; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStyling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStyling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStyling(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylingContext styling() throws RecognitionException {
		StylingContext _localctx = new StylingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_styling);
		try {
			setState(106);
			switch (_input.LA(1)) {
			case WIDGET:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(WIDGET);
				setState(89);
				match(COLON);
				setState(90);
				widget();
				}
				break;
			case WIDTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(WIDTH);
				setState(92);
				match(COLON);
				setState(93);
				match(IntegerLiteral);
				}
				break;
			case HEIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(HEIGHT);
				setState(95);
				match(COLON);
				setState(96);
				match(IntegerLiteral);
				}
				break;
			case FONTSIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(FONTSIZE);
				setState(98);
				match(COLON);
				setState(99);
				match(IntegerLiteral);
				}
				break;
			case FONT:
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				match(FONT);
				setState(101);
				match(COLON);
				setState(102);
				font();
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				match(COLOR);
				setState(104);
				match(COLON);
				setState(105);
				match(RgbValue);
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
		public TerminalNode INT() { return getToken(QLSParser.INT, 0); }
		public TerminalNode STR() { return getToken(QLSParser.STR, 0); }
		public TerminalNode BOOL() { return getToken(QLSParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STR) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
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

	public static class FontContext extends ParserRuleContext {
		public TerminalNode ARIAL() { return getToken(QLSParser.ARIAL, 0); }
		public FontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_font; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterFont(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitFont(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFont(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FontContext font() throws RecognitionException {
		FontContext _localctx = new FontContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_font);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ARIAL);
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
	public static class SliderContext extends WidgetContext {
		public TerminalNode SLIDER() { return getToken(QLSParser.SLIDER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public List<TerminalNode> IntegerLiteral() { return getTokens(QLSParser.IntegerLiteral); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(QLSParser.IntegerLiteral, i);
		}
		public TerminalNode COMMA() { return getToken(QLSParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public SliderContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSlider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSlider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSlider(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextboxContext extends WidgetContext {
		public TerminalNode TEXTBOX() { return getToken(QLSParser.TEXTBOX, 0); }
		public TextboxContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterTextbox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitTextbox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitTextbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckboxContext extends WidgetContext {
		public TerminalNode CHECKBOX() { return getToken(QLSParser.CHECKBOX, 0); }
		public CheckboxContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterCheckbox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitCheckbox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCheckbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropdownContext extends WidgetContext {
		public Token trueLabel;
		public Token falseLabel;
		public TerminalNode DROPDOWN() { return getToken(QLSParser.DROPDOWN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(QLSParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(QLSParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(QLSParser.StringLiteral, i);
		}
		public DropdownContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterDropdown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitDropdown(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDropdown(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpinboxContext extends WidgetContext {
		public TerminalNode SPINBOX() { return getToken(QLSParser.SPINBOX, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(QLSParser.LEFT_BRACKET, 0); }
		public List<TerminalNode> IntegerLiteral() { return getTokens(QLSParser.IntegerLiteral); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(QLSParser.IntegerLiteral, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(QLSParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(QLSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(QLSParser.COMMA, i);
		}
		public SpinboxContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSpinbox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSpinbox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSpinbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RadioContext extends WidgetContext {
		public Token trueLabel;
		public Token falseLabel;
		public TerminalNode RADIO() { return getToken(QLSParser.RADIO, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(QLSParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(QLSParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(QLSParser.StringLiteral, i);
		}
		public RadioContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterRadio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitRadio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitRadio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_widget);
		int _la;
		try {
			setState(142);
			switch (_input.LA(1)) {
			case TEXTBOX:
				_localctx = new TextboxContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(TEXTBOX);
				}
				break;
			case CHECKBOX:
				_localctx = new CheckboxContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(CHECKBOX);
				}
				break;
			case SPINBOX:
				_localctx = new SpinboxContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(SPINBOX);
				setState(115);
				match(LEFT_BRACKET);
				setState(116);
				match(IntegerLiteral);
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					match(COMMA);
					setState(118);
					match(IntegerLiteral);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(123);
				match(RIGHT_BRACKET);
				}
				break;
			case SLIDER:
				_localctx = new SliderContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(SLIDER);
				setState(125);
				match(LEFT_PAREN);
				setState(126);
				match(IntegerLiteral);
				setState(127);
				match(COMMA);
				setState(128);
				match(IntegerLiteral);
				setState(129);
				match(RIGHT_PAREN);
				}
				break;
			case DROPDOWN:
				_localctx = new DropdownContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(130);
				match(DROPDOWN);
				setState(131);
				match(LEFT_PAREN);
				setState(132);
				((DropdownContext)_localctx).trueLabel = match(StringLiteral);
				setState(133);
				match(COMMA);
				setState(134);
				((DropdownContext)_localctx).falseLabel = match(StringLiteral);
				setState(135);
				match(RIGHT_PAREN);
				}
				break;
			case RADIO:
				_localctx = new RadioContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				match(RADIO);
				setState(137);
				match(LEFT_PAREN);
				setState(138);
				((RadioContext)_localctx).trueLabel = match(StringLiteral);
				setState(139);
				match(COMMA);
				setState(140);
				((RadioContext)_localctx).falseLabel = match(StringLiteral);
				setState(141);
				match(RIGHT_PAREN);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0093\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3\3\3\3\3\4\3\4\7"+
		"\4%\n\4\f\4\16\4(\13\4\3\4\7\4+\n\4\f\4\16\4.\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\7\5\66\n\5\f\5\16\59\13\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7R\n\7\f\7"+
		"\16\7U\13\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\6\13z\n\13\r\13\16\13{\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0091\n\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\b\n\u009b\2"+
		"\26\3\2\2\2\4\36\3\2\2\2\6\"\3\2\2\2\b\61\3\2\2\2\nG\3\2\2\2\fX\3\2\2"+
		"\2\16l\3\2\2\2\20n\3\2\2\2\22p\3\2\2\2\24\u0090\3\2\2\2\26\27\7\3\2\2"+
		"\27\33\7&\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2"+
		"\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2\2\2\36\37\7\4\2\2\37 \7&\2\2 !\5"+
		"\6\4\2!\5\3\2\2\2\"&\7\34\2\2#%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2"+
		"&\'\3\2\2\2\',\3\2\2\2(&\3\2\2\2)+\5\f\7\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2"+
		"\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\35\2\2\60\7\3\2\2\2\61\62\7\5\2"+
		"\2\62\63\7\"\2\2\63\67\7\34\2\2\64\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2"+
		"\2\67\65\3\2\2\2\678\3\2\2\28=\3\2\2\29\67\3\2\2\2:<\5\f\7\2;:\3\2\2\2"+
		"<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\35\2\2A\t\3\2\2"+
		"\2BC\7\6\2\2CD\7&\2\2DH\5\24\13\2EF\7\6\2\2FH\7&\2\2GB\3\2\2\2GE\3\2\2"+
		"\2H\13\3\2\2\2IJ\7\7\2\2JK\5\20\t\2KL\5\16\b\2LY\3\2\2\2MN\7\7\2\2NO\5"+
		"\20\t\2OS\7\34\2\2PR\5\16\b\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"TV\3\2\2\2US\3\2\2\2VW\7\35\2\2WY\3\2\2\2XI\3\2\2\2XM\3\2\2\2Y\r\3\2\2"+
		"\2Z[\7\13\2\2[\\\7\30\2\2\\m\5\24\13\2]^\7\22\2\2^_\7\30\2\2_m\7 \2\2"+
		"`a\7\23\2\2ab\7\30\2\2bm\7 \2\2cd\7\24\2\2de\7\30\2\2em\7 \2\2fg\7\25"+
		"\2\2gh\7\30\2\2hm\5\22\n\2ij\7\26\2\2jk\7\30\2\2km\7\'\2\2lZ\3\2\2\2l"+
		"]\3\2\2\2l`\3\2\2\2lc\3\2\2\2lf\3\2\2\2li\3\2\2\2m\17\3\2\2\2no\t\2\2"+
		"\2o\21\3\2\2\2pq\7\27\2\2q\23\3\2\2\2r\u0091\7\16\2\2s\u0091\7\21\2\2"+
		"tu\7\r\2\2uv\7\36\2\2vy\7 \2\2wx\7\31\2\2xz\7 \2\2yw\3\2\2\2z{\3\2\2\2"+
		"{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u0091\7\37\2\2~\177\7\f\2\2\177\u0080"+
		"\7\32\2\2\u0080\u0081\7 \2\2\u0081\u0082\7\31\2\2\u0082\u0083\7 \2\2\u0083"+
		"\u0091\7\33\2\2\u0084\u0085\7\20\2\2\u0085\u0086\7\32\2\2\u0086\u0087"+
		"\7\"\2\2\u0087\u0088\7\31\2\2\u0088\u0089\7\"\2\2\u0089\u0091\7\33\2\2"+
		"\u008a\u008b\7\17\2\2\u008b\u008c\7\32\2\2\u008c\u008d\7\"\2\2\u008d\u008e"+
		"\7\31\2\2\u008e\u008f\7\"\2\2\u008f\u0091\7\33\2\2\u0090r\3\2\2\2\u0090"+
		"s\3\2\2\2\u0090t\3\2\2\2\u0090~\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u008a"+
		"\3\2\2\2\u0091\25\3\2\2\2\r\33&,\67=GSXl{\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}