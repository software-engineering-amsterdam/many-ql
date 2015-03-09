// Generated from QLS.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STYLE=1, PAGE=2, SECTION=3, QUESTION=4, DEFAULT=5, INT=6, STR=7, BOOL=8, 
		WIDGET=9, SLIDER=10, SPINBOX=11, TEXT=12, RADIO=13, DROPDOWN=14, CHECKBOX=15, 
		WIDTH=16, HEIGHT=17, FONTSIZE=18, FONT=19, COLOR=20, ARIAL=21, COLON=22, 
		COMMA=23, LEFT_PAREN=24, RIGHT_PAREN=25, LEFT_BRACE=26, RIGHT_BRACE=27, 
		LEFT_BRACKET=28, RIGHT_BRACKET=29, IntegerLiteral=30, BooleanLiteral=31, 
		StringLiteral=32, WhiteSpace=33, MultiComment=34, SingleComment=35, Identifier=36, 
		RgbValue=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'style'", "'page'", "'section'", "'question'", "'default'", 
		"'Int'", "'Str'", "'Bool'", "'widget'", "'slider'", "'spinbox'", "'text'", 
		"'radiobutton'", "'dropdown'", "'checkbox'", "'width'", "'height'", "'fontSize'", 
		"'font'", "'color'", "'arial'", "':'", "','", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "IntegerLiteral", "BooleanLiteral", "StringLiteral", "WhiteSpace", 
		"MultiComment", "SingleComment", "Identifier", "RgbValue"
	};
	public static final int
		RULE_sheet = 0, RULE_page = 1, RULE_pageBlock = 2, RULE_section = 3, RULE_question = 4, 
		RULE_style = 5, RULE_styling = 6, RULE_type = 7, RULE_font = 8, RULE_widget = 9, 
		RULE_intWidgetParam = 10, RULE_boolWidgetParam = 11;
	public static final String[] ruleNames = {
		"sheet", "page", "pageBlock", "section", "question", "style", "styling", 
		"type", "font", "widget", "intWidgetParam", "boolWidgetParam"
	};

	@Override
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
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
			setState(24); match(STYLE);
			setState(25); match(Identifier);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PAGE) {
				{
				{
				setState(26); page();
				}
				}
				setState(31);
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
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode PAGE() { return getToken(QLSParser.PAGE, 0); }
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
			setState(32); match(PAGE);
			setState(33); match(Identifier);
			setState(34); pageBlock();
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
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
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
			setState(36); match(LEFT_PAREN);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SECTION) {
				{
				{
				setState(37); section();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43); style();
			setState(44); match(RIGHT_PAREN);
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
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public TerminalNode SECTION() { return getToken(QLSParser.SECTION, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode StringLiteral() { return getToken(QLSParser.StringLiteral, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
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
			setState(46); match(SECTION);
			setState(47); match(StringLiteral);
			setState(48); match(LEFT_PAREN);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUESTION) {
				{
				{
				setState(49); question();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(RIGHT_PAREN);
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
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(QUESTION);
			setState(58); match(Identifier);
			setState(59); style();
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
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public List<StylingContext> styling() {
			return getRuleContexts(StylingContext.class);
		}
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public StylingContext styling(int i) {
			return getRuleContext(StylingContext.class,i);
		}
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
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); match(DEFAULT);
				setState(62); type();
				setState(63); styling();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); match(DEFAULT);
				setState(66); type();
				setState(67); match(LEFT_PAREN);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDGET) | (1L << WIDTH) | (1L << HEIGHT) | (1L << FONTSIZE) | (1L << FONT) | (1L << COLOR))) != 0)) {
					{
					{
					setState(68); styling();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74); match(RIGHT_PAREN);
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
		public FontContext font() {
			return getRuleContext(FontContext.class,0);
		}
		public TerminalNode WIDTH() { return getToken(QLSParser.WIDTH, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public TerminalNode FONT() { return getToken(QLSParser.FONT, 0); }
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode FONTSIZE() { return getToken(QLSParser.FONTSIZE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(QLSParser.IntegerLiteral, 0); }
		public TerminalNode RgbValue() { return getToken(QLSParser.RgbValue, 0); }
		public TerminalNode COLOR() { return getToken(QLSParser.COLOR, 0); }
		public TerminalNode COLON() { return getToken(QLSParser.COLON, 0); }
		public TerminalNode HEIGHT() { return getToken(QLSParser.HEIGHT, 0); }
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
			setState(96);
			switch (_input.LA(1)) {
			case WIDGET:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); match(WIDGET);
				setState(79); match(COLON);
				setState(80); widget();
				}
				break;
			case WIDTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(81); match(WIDTH);
				setState(82); match(COLON);
				setState(83); match(IntegerLiteral);
				}
				break;
			case HEIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); match(HEIGHT);
				setState(85); match(COLON);
				setState(86); match(IntegerLiteral);
				}
				break;
			case FONTSIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); match(FONTSIZE);
				setState(88); match(COLON);
				setState(89); match(IntegerLiteral);
				}
				break;
			case FONT:
				enterOuterAlt(_localctx, 5);
				{
				setState(90); match(FONT);
				setState(91); match(COLON);
				setState(92); font();
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(93); match(COLOR);
				setState(94); match(COLON);
				setState(95); match(RgbValue);
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
		public TerminalNode BOOL() { return getToken(QLSParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(QLSParser.INT, 0); }
		public TerminalNode STR() { return getToken(QLSParser.STR, 0); }
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
			setState(98);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STR) | (1L << BOOL))) != 0)) ) {
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
			setState(100); match(ARIAL);
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
		public TerminalNode SPINBOX() { return getToken(QLSParser.SPINBOX, 0); }
		public TerminalNode RADIO() { return getToken(QLSParser.RADIO, 0); }
		public TerminalNode SLIDER() { return getToken(QLSParser.SLIDER, 0); }
		public TerminalNode TEXT() { return getToken(QLSParser.TEXT, 0); }
		public IntWidgetParamContext intWidgetParam() {
			return getRuleContext(IntWidgetParamContext.class,0);
		}
		public TerminalNode CHECKBOX() { return getToken(QLSParser.CHECKBOX, 0); }
		public BoolWidgetParamContext boolWidgetParam() {
			return getRuleContext(BoolWidgetParamContext.class,0);
		}
		public TerminalNode DROPDOWN() { return getToken(QLSParser.DROPDOWN, 0); }
		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_widget);
		try {
			setState(112);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); match(TEXT);
				}
				break;
			case CHECKBOX:
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(CHECKBOX);
				}
				break;
			case SPINBOX:
				enterOuterAlt(_localctx, 3);
				{
				setState(104); match(SPINBOX);
				setState(105); intWidgetParam();
				}
				break;
			case SLIDER:
				enterOuterAlt(_localctx, 4);
				{
				setState(106); match(SLIDER);
				setState(107); intWidgetParam();
				}
				break;
			case DROPDOWN:
				enterOuterAlt(_localctx, 5);
				{
				setState(108); match(DROPDOWN);
				setState(109); boolWidgetParam();
				}
				break;
			case RADIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(110); match(RADIO);
				setState(111); boolWidgetParam();
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

	public static class IntWidgetParamContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(QLSParser.COMMA); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(QLSParser.IntegerLiteral, i);
		}
		public List<TerminalNode> IntegerLiteral() { return getTokens(QLSParser.IntegerLiteral); }
		public TerminalNode LEFT_BRACKET() { return getToken(QLSParser.LEFT_BRACKET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(QLSParser.COMMA, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(QLSParser.RIGHT_BRACKET, 0); }
		public IntWidgetParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intWidgetParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterIntWidgetParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitIntWidgetParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitIntWidgetParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntWidgetParamContext intWidgetParam() throws RecognitionException {
		IntWidgetParamContext _localctx = new IntWidgetParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_intWidgetParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(LEFT_BRACKET);
			setState(115); match(IntegerLiteral);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116); match(COMMA);
				setState(117); match(IntegerLiteral);
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(122); match(RIGHT_BRACKET);
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

	public static class BoolWidgetParamContext extends ParserRuleContext {
		public Token trueLabel;
		public Token falseLabel;
		public TerminalNode COMMA() { return getToken(QLSParser.COMMA, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(QLSParser.StringLiteral); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public TerminalNode StringLiteral(int i) {
			return getToken(QLSParser.StringLiteral, i);
		}
		public BoolWidgetParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolWidgetParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterBoolWidgetParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitBoolWidgetParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitBoolWidgetParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolWidgetParamContext boolWidgetParam() throws RecognitionException {
		BoolWidgetParamContext _localctx = new BoolWidgetParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_boolWidgetParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); match(LEFT_PAREN);
			setState(125); ((BoolWidgetParamContext)_localctx).trueLabel = match(StringLiteral);
			setState(126); match(COMMA);
			setState(127); ((BoolWidgetParamContext)_localctx).falseLabel = match(StringLiteral);
			setState(128); match(RIGHT_PAREN);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0085\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\65"+
		"\n\5\f\5\16\58\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7H\n\7\f\7\16\7K\13\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13s\n\13\3"+
		"\f\3\f\3\f\3\f\6\fy\n\f\r\f\16\fz\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\b\n\u0088\2\32\3\2\2\2\4"+
		"\"\3\2\2\2\6&\3\2\2\2\b\60\3\2\2\2\n;\3\2\2\2\fN\3\2\2\2\16b\3\2\2\2\20"+
		"d\3\2\2\2\22f\3\2\2\2\24r\3\2\2\2\26t\3\2\2\2\30~\3\2\2\2\32\33\7\3\2"+
		"\2\33\37\7&\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2"+
		"\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"#\7\4\2\2#$\7&\2\2$%\5\6\4\2%\5\3"+
		"\2\2\2&*\7\32\2\2\')\5\b\5\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2"+
		"+-\3\2\2\2,*\3\2\2\2-.\5\f\7\2./\7\33\2\2/\7\3\2\2\2\60\61\7\5\2\2\61"+
		"\62\7\"\2\2\62\66\7\32\2\2\63\65\5\n\6\2\64\63\3\2\2\2\658\3\2\2\2\66"+
		"\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\33\2\2:\t\3\2\2"+
		"\2;<\7\6\2\2<=\7&\2\2=>\5\f\7\2>\13\3\2\2\2?@\7\7\2\2@A\5\20\t\2AB\5\16"+
		"\b\2BO\3\2\2\2CD\7\7\2\2DE\5\20\t\2EI\7\32\2\2FH\5\16\b\2GF\3\2\2\2HK"+
		"\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\33\2\2MO\3\2\2\2"+
		"N?\3\2\2\2NC\3\2\2\2O\r\3\2\2\2PQ\7\13\2\2QR\7\30\2\2Rc\5\24\13\2ST\7"+
		"\22\2\2TU\7\30\2\2Uc\7 \2\2VW\7\23\2\2WX\7\30\2\2Xc\7 \2\2YZ\7\24\2\2"+
		"Z[\7\30\2\2[c\7 \2\2\\]\7\25\2\2]^\7\30\2\2^c\5\22\n\2_`\7\26\2\2`a\7"+
		"\30\2\2ac\7\'\2\2bP\3\2\2\2bS\3\2\2\2bV\3\2\2\2bY\3\2\2\2b\\\3\2\2\2b"+
		"_\3\2\2\2c\17\3\2\2\2de\t\2\2\2e\21\3\2\2\2fg\7\27\2\2g\23\3\2\2\2hs\7"+
		"\16\2\2is\7\21\2\2jk\7\r\2\2ks\5\26\f\2lm\7\f\2\2ms\5\26\f\2no\7\20\2"+
		"\2os\5\30\r\2pq\7\17\2\2qs\5\30\r\2rh\3\2\2\2ri\3\2\2\2rj\3\2\2\2rl\3"+
		"\2\2\2rn\3\2\2\2rp\3\2\2\2s\25\3\2\2\2tu\7\36\2\2ux\7 \2\2vw\7\31\2\2"+
		"wy\7 \2\2xv\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\37\2\2"+
		"}\27\3\2\2\2~\177\7\32\2\2\177\u0080\7\"\2\2\u0080\u0081\7\31\2\2\u0081"+
		"\u0082\7\"\2\2\u0082\u0083\7\33\2\2\u0083\31\3\2\2\2\n\37*\66INbrz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}