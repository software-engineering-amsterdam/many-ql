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
		public TerminalNode SECTION() { return getToken(QLSParser.SECTION, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(QLSParser.RIGHT_PAREN, 0); }
		public TerminalNode StringLiteral() { return getToken(QLSParser.StringLiteral, 0); }
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
			setState(40); match(StringLiteral);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(QUESTION);
			setState(46); match(Identifier);
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
			setState(66);
			switch (_input.LA(1)) {
			case WIDGET:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); match(WIDGET);
				setState(49); match(COLON);
				setState(50); widget();
				}
				break;
			case WIDTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); match(WIDTH);
				setState(52); match(COLON);
				setState(53); match(IntegerLiteral);
				}
				break;
			case HEIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(54); match(HEIGHT);
				setState(55); match(COLON);
				setState(56); match(IntegerLiteral);
				}
				break;
			case FONTSIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(57); match(FONTSIZE);
				setState(58); match(COLON);
				setState(59); match(IntegerLiteral);
				}
				break;
			case FONT:
				enterOuterAlt(_localctx, 5);
				{
				setState(60); match(FONT);
				setState(61); match(COLON);
				setState(62); font();
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(63); match(COLOR);
				setState(64); match(COLON);
				setState(65); match(RgbValue);
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
			setState(68); match(ARIAL);
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
			setState(100);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); match(TEXT);
				}
				break;
			case CHECKBOX:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); match(CHECKBOX);
				}
				break;
			case SPINBOX:
				enterOuterAlt(_localctx, 3);
				{
				setState(72); match(SPINBOX);
				setState(73); match(COLON);
				setState(74); match(LEFT_BRACKET);
				setState(75); match(IntegerLiteral);
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76); match(COMMA);
					setState(77); match(IntegerLiteral);
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(82); match(RIGHT_BRACKET);
				}
				break;
			case SLIDER:
				enterOuterAlt(_localctx, 4);
				{
				setState(83); match(SLIDER);
				setState(84); match(COLON);
				setState(85); match(LEFT_BRACKET);
				setState(86); match(IntegerLiteral);
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87); match(COMMA);
					setState(88); match(IntegerLiteral);
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(93); match(RIGHT_BRACKET);
				}
				break;
			case DROPDOWN:
				enterOuterAlt(_localctx, 5);
				{
				setState(94); match(DROPDOWN);
				setState(95); match(COLON);
				setState(96); trueFalseIdentifier();
				}
				break;
			case RADIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(97); match(RADIO);
				setState(98); match(COLON);
				setState(99); trueFalseIdentifier();
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
			setState(104);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(102); ((TrueFalseIdentifierContext)_localctx).trueLabel = match(Identifier);
				}
				break;
			case 2:
				{
				setState(103); ((TrueFalseIdentifierContext)_localctx).falseLabel = match(Identifier);
				}
				break;
			}
			setState(106); match(NewLine);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$o\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\7"+
		"\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4#\n\4\f\4\16\4&"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tQ\n\t\r\t\16\tR\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\6\t\\\n\t\r\t\16\t]\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tg\n\t\3"+
		"\n\3\n\5\nk\n\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2t\2\24\3\2"+
		"\2\2\4\34\3\2\2\2\6 \3\2\2\2\b)\3\2\2\2\n/\3\2\2\2\fD\3\2\2\2\16F\3\2"+
		"\2\2\20f\3\2\2\2\22j\3\2\2\2\24\25\7\3\2\2\25\31\7#\2\2\26\30\5\4\3\2"+
		"\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2"+
		"\33\31\3\2\2\2\34\35\7\4\2\2\35\36\7#\2\2\36\37\5\6\4\2\37\5\3\2\2\2 "+
		"$\7\26\2\2!#\5\b\5\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2"+
		"\2\2&$\3\2\2\2\'(\7\27\2\2(\7\3\2\2\2)*\7\5\2\2*+\7\37\2\2+,\7\26\2\2"+
		",-\5\n\6\2-.\7\27\2\2.\t\3\2\2\2/\60\7\6\2\2\60\61\7#\2\2\61\13\3\2\2"+
		"\2\62\63\7\7\2\2\63\64\7\24\2\2\64E\5\20\t\2\65\66\7\16\2\2\66\67\7\24"+
		"\2\2\67E\7\35\2\289\7\17\2\29:\7\24\2\2:E\7\35\2\2;<\7\20\2\2<=\7\24\2"+
		"\2=E\7\35\2\2>?\7\21\2\2?@\7\24\2\2@E\5\16\b\2AB\7\22\2\2BC\7\24\2\2C"+
		"E\7$\2\2D\62\3\2\2\2D\65\3\2\2\2D8\3\2\2\2D;\3\2\2\2D>\3\2\2\2DA\3\2\2"+
		"\2E\r\3\2\2\2FG\7\23\2\2G\17\3\2\2\2Hg\7\n\2\2Ig\7\r\2\2JK\7\t\2\2KL\7"+
		"\24\2\2LM\7\32\2\2MP\7\35\2\2NO\7\25\2\2OQ\7\35\2\2PN\3\2\2\2QR\3\2\2"+
		"\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2Tg\7\33\2\2UV\7\b\2\2VW\7\24\2\2WX\7\32"+
		"\2\2X[\7\35\2\2YZ\7\25\2\2Z\\\7\35\2\2[Y\3\2\2\2\\]\3\2\2\2][\3\2\2\2"+
		"]^\3\2\2\2^_\3\2\2\2_g\7\33\2\2`a\7\f\2\2ab\7\24\2\2bg\5\22\n\2cd\7\13"+
		"\2\2de\7\24\2\2eg\5\22\n\2fH\3\2\2\2fI\3\2\2\2fJ\3\2\2\2fU\3\2\2\2f`\3"+
		"\2\2\2fc\3\2\2\2g\21\3\2\2\2hk\7#\2\2ik\7#\2\2jh\3\2\2\2ji\3\2\2\2kl\3"+
		"\2\2\2lm\7\34\2\2m\23\3\2\2\2\t\31$DR]fj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}