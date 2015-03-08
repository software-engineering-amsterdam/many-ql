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
		STYLE=1, PAGE=2, SECTION=3, QUESTION=4, WIDGET=5, SLIDER=6, SPINBOX=7, 
		TEXT=8, RADIO=9, DROPDOWN=10, CHECKBOX=11, WIDTH=12, HEIGHT=13, FONTSIZE=14, 
		FONT=15, COLOR=16, ARIAL=17, COLON=18, COMMA=19, LEFT_PAREN=20, RIGHT_PAREN=21, 
		LEFT_BRACE=22, RIGHT_BRACE=23, LEFT_BRACKET=24, RIGHT_BRACKET=25, NewLine=26, 
		IntegerLiteral=27, BooleanLiteral=28, StringLiteral=29, WhiteSpace=30, 
		MultiComment=31, SingleComment=32, Identifier=33, RgbValue=34;
	public static final String[] tokenNames = {
		"<INVALID>", "'style'", "'page'", "'section'", "'question'", "'widget'", 
		"'slider'", "'spinbox'", "'text'", "'radiobutton'", "'dropdown'", "'checkbox'", 
		"'width'", "'height'", "'fontSize'", "'font'", "'color'", "'arial'", "':'", 
		"','", "'('", "')'", "'{'", "'}'", "'['", "']'", "NewLine", "IntegerLiteral", 
		"BooleanLiteral", "StringLiteral", "WhiteSpace", "MultiComment", "SingleComment", 
		"Identifier", "RgbValue"
	};
	public static final int
		RULE_style = 0, RULE_page = 1, RULE_block = 2, RULE_section = 3, RULE_questionIdent = 4, 
		RULE_styling = 5, RULE_font = 6, RULE_widget = 7, RULE_trueFalseIdentifier = 8;
	public static final String[] ruleNames = {
		"style", "page", "block", "section", "questionIdent", "styling", "font", 
		"widget", "trueFalseIdentifier"
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
	public static class StyleContext extends ParserRuleContext {
		public TerminalNode STYLE() { return getToken(QLSParser.STYLE, 0); }
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
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
		enterRule(_localctx, 0, RULE_style);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); match(STYLE);
			setState(19); match(Identifier);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PAGE) {
				{
				{
				setState(20); page();
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
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode PAGE() { return getToken(QLSParser.PAGE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(26); match(PAGE);
			setState(27); match(Identifier);
			setState(28); block();
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

	public static class BlockContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(LEFT_PAREN);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SECTION) {
				{
				{
				setState(31); section();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37); match(RIGHT_PAREN);
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
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode SECTION() { return getToken(QLSParser.SECTION, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public QuestionIdentContext questionIdent() {
			return getRuleContext(QuestionIdentContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(SECTION);
			setState(40); match(Identifier);
			setState(41); match(LEFT_PAREN);
			setState(42); questionIdent();
			setState(43); match(RIGHT_PAREN);
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

	public static class QuestionIdentContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QLSParser.QUESTION, 0); }
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<StylingContext> styling() {
			return getRuleContexts(StylingContext.class);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public StylingContext styling(int i) {
			return getRuleContext(StylingContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(QLSParser.LEFT_PAREN, 0); }
		public QuestionIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestionIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestionIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestionIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionIdentContext questionIdent() throws RecognitionException {
		QuestionIdentContext _localctx = new QuestionIdentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionIdent);
		int _la;
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(QUESTION);
				setState(46); match(Identifier);
				setState(47); match(LEFT_PAREN);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDGET) | (1L << WIDTH) | (1L << HEIGHT) | (1L << FONTSIZE) | (1L << FONT) | (1L << COLOR))) != 0)) {
					{
					{
					setState(48); styling();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); match(QUESTION);
				setState(56); match(Identifier);
				setState(57); styling();
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
		enterRule(_localctx, 10, RULE_styling);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case WIDGET:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(WIDGET);
				setState(61); match(COLON);
				setState(62); widget();
				}
				break;
			case WIDTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); match(WIDTH);
				setState(64); match(COLON);
				setState(65); match(IntegerLiteral);
				}
				break;
			case HEIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(66); match(HEIGHT);
				setState(67); match(COLON);
				setState(68); match(IntegerLiteral);
				}
				break;
			case FONTSIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(69); match(FONTSIZE);
				setState(70); match(COLON);
				setState(71); match(IntegerLiteral);
				}
				break;
			case FONT:
				enterOuterAlt(_localctx, 5);
				{
				setState(72); match(FONT);
				setState(73); match(COLON);
				setState(74); font();
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(75); match(COLOR);
				setState(76); match(COLON);
				setState(77); match(RgbValue);
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
		enterRule(_localctx, 12, RULE_font);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(ARIAL);
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
		public TrueFalseIdentifierContext trueFalseIdentifier() {
			return getRuleContext(TrueFalseIdentifierContext.class,0);
		}
		public TerminalNode RADIO() { return getToken(QLSParser.RADIO, 0); }
		public TerminalNode SLIDER() { return getToken(QLSParser.SLIDER, 0); }
		public TerminalNode TEXT() { return getToken(QLSParser.TEXT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(QLSParser.COMMA); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(QLSParser.IntegerLiteral, i);
		}
		public List<TerminalNode> IntegerLiteral() { return getTokens(QLSParser.IntegerLiteral); }
		public TerminalNode CHECKBOX() { return getToken(QLSParser.CHECKBOX, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(QLSParser.LEFT_BRACKET, 0); }
		public TerminalNode COLON() { return getToken(QLSParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(QLSParser.COMMA, i);
		}
		public TerminalNode DROPDOWN() { return getToken(QLSParser.DROPDOWN, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(QLSParser.RIGHT_BRACKET, 0); }
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
		enterRule(_localctx, 14, RULE_widget);
		int _la;
		try {
			setState(112);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); match(TEXT);
				}
				break;
			case CHECKBOX:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); match(CHECKBOX);
				}
				break;
			case SPINBOX:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); match(SPINBOX);
				setState(85); match(COLON);
				setState(86); match(LEFT_BRACKET);
				setState(87); match(IntegerLiteral);
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88); match(COMMA);
					setState(89); match(IntegerLiteral);
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(94); match(RIGHT_BRACKET);
				}
				break;
			case SLIDER:
				enterOuterAlt(_localctx, 4);
				{
				setState(95); match(SLIDER);
				setState(96); match(COLON);
				setState(97); match(LEFT_BRACKET);
				setState(98); match(IntegerLiteral);
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99); match(COMMA);
					setState(100); match(IntegerLiteral);
					}
					}
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(105); match(RIGHT_BRACKET);
				}
				break;
			case DROPDOWN:
				enterOuterAlt(_localctx, 5);
				{
				setState(106); match(DROPDOWN);
				setState(107); match(COLON);
				setState(108); trueFalseIdentifier();
				}
				break;
			case RADIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(109); match(RADIO);
				setState(110); match(COLON);
				setState(111); trueFalseIdentifier();
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

	public static class TrueFalseIdentifierContext extends ParserRuleContext {
		public Token trueLabel;
		public Token falseLabel;
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode NewLine() { return getToken(QLSParser.NewLine, 0); }
		public TrueFalseIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalseIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterTrueFalseIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitTrueFalseIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitTrueFalseIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseIdentifierContext trueFalseIdentifier() throws RecognitionException {
		TrueFalseIdentifierContext _localctx = new TrueFalseIdentifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_trueFalseIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(114); ((TrueFalseIdentifierContext)_localctx).trueLabel = match(Identifier);
				}
				break;
			case 2:
				{
				setState(115); ((TrueFalseIdentifierContext)_localctx).falseLabel = match(Identifier);
				}
				break;
			}
			setState(118); match(NewLine);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3${\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\7"+
		"\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4#\n\4\f\4\16\4&"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\64\n\6\f\6\16"+
		"\6\67\13\6\3\6\3\6\3\6\3\6\5\6=\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7Q\n\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\6\t]\n\t\r\t\16\t^\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t"+
		"h\n\t\r\t\16\ti\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\n\3\n\5\nw\n\n"+
		"\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2\u0082\2\24\3\2\2\2\4\34\3"+
		"\2\2\2\6 \3\2\2\2\b)\3\2\2\2\n<\3\2\2\2\fP\3\2\2\2\16R\3\2\2\2\20r\3\2"+
		"\2\2\22v\3\2\2\2\24\25\7\3\2\2\25\31\7#\2\2\26\30\5\4\3\2\27\26\3\2\2"+
		"\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2"+
		"\2\34\35\7\4\2\2\35\36\7#\2\2\36\37\5\6\4\2\37\5\3\2\2\2 $\7\26\2\2!#"+
		"\5\b\5\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2"+
		"\2\'(\7\27\2\2(\7\3\2\2\2)*\7\5\2\2*+\7#\2\2+,\7\26\2\2,-\5\n\6\2-.\7"+
		"\27\2\2.\t\3\2\2\2/\60\7\6\2\2\60\61\7#\2\2\61\65\7\26\2\2\62\64\5\f\7"+
		"\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2"+
		"\67\65\3\2\2\28=\7\27\2\29:\7\6\2\2:;\7#\2\2;=\5\f\7\2</\3\2\2\2<9\3\2"+
		"\2\2=\13\3\2\2\2>?\7\7\2\2?@\7\24\2\2@Q\5\20\t\2AB\7\16\2\2BC\7\24\2\2"+
		"CQ\7\35\2\2DE\7\17\2\2EF\7\24\2\2FQ\7\35\2\2GH\7\20\2\2HI\7\24\2\2IQ\7"+
		"\35\2\2JK\7\21\2\2KL\7\24\2\2LQ\5\16\b\2MN\7\22\2\2NO\7\24\2\2OQ\7$\2"+
		"\2P>\3\2\2\2PA\3\2\2\2PD\3\2\2\2PG\3\2\2\2PJ\3\2\2\2PM\3\2\2\2Q\r\3\2"+
		"\2\2RS\7\23\2\2S\17\3\2\2\2Ts\7\n\2\2Us\7\r\2\2VW\7\t\2\2WX\7\24\2\2X"+
		"Y\7\32\2\2Y\\\7\35\2\2Z[\7\25\2\2[]\7\35\2\2\\Z\3\2\2\2]^\3\2\2\2^\\\3"+
		"\2\2\2^_\3\2\2\2_`\3\2\2\2`s\7\33\2\2ab\7\b\2\2bc\7\24\2\2cd\7\32\2\2"+
		"dg\7\35\2\2ef\7\25\2\2fh\7\35\2\2ge\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2"+
		"\2\2jk\3\2\2\2ks\7\33\2\2lm\7\f\2\2mn\7\24\2\2ns\5\22\n\2op\7\13\2\2p"+
		"q\7\24\2\2qs\5\22\n\2rT\3\2\2\2rU\3\2\2\2rV\3\2\2\2ra\3\2\2\2rl\3\2\2"+
		"\2ro\3\2\2\2s\21\3\2\2\2tw\7#\2\2uw\7#\2\2vt\3\2\2\2vu\3\2\2\2wx\3\2\2"+
		"\2xy\7\34\2\2y\23\3\2\2\2\13\31$\65<P^irv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}