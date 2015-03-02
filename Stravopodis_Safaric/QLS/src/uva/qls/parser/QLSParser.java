// Generated from QLS.g4 by ANTLR 4.5

	package uva.qls.parser;

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
		T__17=18, BooleanLiteral=19, Identifier=20, Integer=21, Decimal=22, WS=23, 
		ID_LETTER=24, DIGIT=25, STRING=26, LINE_COMMENT=27, COMMENT=28, WIDGET=29, 
		WIDTH=30, HEIGHT=31, FONT=32, FONTSIZE=33, COLOR=34, NEWLINE=35, TAB=36, 
		LP=37, RP=38, LC=39, RC=40;
	public static final int
		RULE_prog = 0, RULE_stylesheet = 1, RULE_page = 2, RULE_statements = 3, 
		RULE_section = 4, RULE_subsection = 5, RULE_question = 6, RULE_defaultValue = 7, 
		RULE_style = 8, RULE_width = 9, RULE_height = 10, RULE_font = 11, RULE_fontsize = 12, 
		RULE_color = 13, RULE_component = 14, RULE_textbox = 15, RULE_spinbox = 16, 
		RULE_slider = 17, RULE_dropdown = 18, RULE_radiobutton = 19, RULE_checkbox = 20, 
		RULE_literal = 21, RULE_primitiveType = 22;
	public static final String[] ruleNames = {
		"prog", "stylesheet", "page", "statements", "section", "subsection", "question", 
		"defaultValue", "style", "width", "height", "font", "fontsize", "color", 
		"component", "textbox", "spinbox", "slider", "dropdown", "radiobutton", 
		"checkbox", "literal", "primitiveType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'section'", "'subsection '", "'question'", 
		"'default'", "':'", "'text'", "'spinbox'", "'slider'", "','", "'dropdown'", 
		"'radio'", "'checkbox'", "'boolean'", "'decimal'", "'string'", "'int'", 
		null, null, null, null, null, null, null, null, null, null, "'widget'", 
		"'width'", "'height'", "'font'", "'fontsize'", "'color'", "'\n'", "'\t'", 
		"'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "BooleanLiteral", "Identifier", 
		"Integer", "Decimal", "WS", "ID_LETTER", "DIGIT", "STRING", "LINE_COMMENT", 
		"COMMENT", "WIDGET", "WIDTH", "HEIGHT", "FONT", "FONTSIZE", "COLOR", "NEWLINE", 
		"TAB", "LP", "RP", "LC", "RC"
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
	public static class ProgContext extends ParserRuleContext {
		public StylesheetContext stylesheet() {
			return getRuleContext(StylesheetContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			stylesheet();
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

	public static class StylesheetContext extends ParserRuleContext {
		public PageContext page;
		public List<PageContext> pgs = new ArrayList<PageContext>();
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
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
		enterRule(_localctx, 2, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			match(Identifier);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(50);
				((StylesheetContext)_localctx).page = page();
				((StylesheetContext)_localctx).pgs.add(((StylesheetContext)_localctx).page);
				}
				}
				setState(55);
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
		public StatementsContext statements;
		public List<StatementsContext> stms = new ArrayList<StatementsContext>();
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode LC() { return getToken(QLSParser.LC, 0); }
		public TerminalNode RC() { return getToken(QLSParser.RC, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
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
		enterRule(_localctx, 4, RULE_page);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__1);
			setState(57);
			match(Identifier);
			setState(58);
			match(LC);
			setState(59);
			((PageContext)_localctx).statements = statements();
			((PageContext)_localctx).stms.add(((PageContext)_localctx).statements);
			setState(60);
			match(RC);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxSubsectionContext extends StatementsContext {
		public SubsectionContext subsection() {
			return getRuleContext(SubsectionContext.class,0);
		}
		public CtxSubsectionContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSubsection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSectionContext extends StatementsContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public CtxSectionContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxComponentsContext extends StatementsContext {
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public CtxComponentsContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxComponents(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxQuestionContext extends StatementsContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public CtxQuestionContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statements);
		try {
			setState(66);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new CtxSectionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				section();
				}
				break;
			case T__3:
				_localctx = new CtxSubsectionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				subsection();
				}
				break;
			case T__4:
				_localctx = new CtxQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				question();
				}
				break;
			case WIDGET:
				_localctx = new CtxComponentsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				component();
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

	public static class SectionContext extends ParserRuleContext {
		public StatementsContext statements;
		public List<StatementsContext> stms = new ArrayList<StatementsContext>();
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode LC() { return getToken(QLSParser.LC, 0); }
		public TerminalNode RC() { return getToken(QLSParser.RC, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
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
		enterRule(_localctx, 8, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__2);
			setState(69);
			match(STRING);
			setState(70);
			match(LC);
			setState(71);
			((SectionContext)_localctx).statements = statements();
			((SectionContext)_localctx).stms.add(((SectionContext)_localctx).statements);
			setState(72);
			match(RC);
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

	public static class SubsectionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode LC() { return getToken(QLSParser.LC, 0); }
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode RC() { return getToken(QLSParser.RC, 0); }
		public SubsectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSubsection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubsectionContext subsection() throws RecognitionException {
		SubsectionContext _localctx = new SubsectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subsection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__3);
			setState(75);
			match(STRING);
			setState(76);
			match(LC);
			setState(77);
			question();
			setState(78);
			match(RC);
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
		public ComponentContext component;
		public List<ComponentContext> cmps = new ArrayList<ComponentContext>();
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
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
		enterRule(_localctx, 12, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(81);
			match(Identifier);
			setState(82);
			match(NEWLINE);
			setState(84);
			_la = _input.LA(1);
			if (_la==WIDGET) {
				{
				setState(83);
				((QuestionContext)_localctx).component = component();
				((QuestionContext)_localctx).cmps.add(((QuestionContext)_localctx).component);
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

	public static class DefaultValueContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LC() { return getToken(QLSParser.LC, 0); }
		public TerminalNode RC() { return getToken(QLSParser.RC, 0); }
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__5);
			setState(87);
			primitiveType();
			setState(97);
			switch (_input.LA(1)) {
			case LC:
				{
				{
				setState(88);
				match(LC);
				setState(91);
				switch (_input.LA(1)) {
				case WIDTH:
				case HEIGHT:
				case FONT:
				case FONTSIZE:
				case COLOR:
					{
					setState(89);
					style();
					}
					break;
				case WIDGET:
					{
					setState(90);
					component();
					}
					break;
				case RC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(93);
				match(RC);
				}
				}
				break;
			case WIDGET:
				{
				{
				setState(94);
				component();
				setState(95);
				match(NEWLINE);
				}
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

	public static class StyleContext extends ParserRuleContext {
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
	 
		public StyleContext() { }
		public void copyFrom(StyleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxHeightContext extends StyleContext {
		public HeightContext height() {
			return getRuleContext(HeightContext.class,0);
		}
		public CtxHeightContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxHeight(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxFontContext extends StyleContext {
		public FontContext font() {
			return getRuleContext(FontContext.class,0);
		}
		public CtxFontContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxFont(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxColorContext extends StyleContext {
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public CtxColorContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxWidthContext extends StyleContext {
		public WidthContext width() {
			return getRuleContext(WidthContext.class,0);
		}
		public CtxWidthContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxWidth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxFontsizeContext extends StyleContext {
		public FontsizeContext fontsize() {
			return getRuleContext(FontsizeContext.class,0);
		}
		public CtxFontsizeContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxFontsize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_style);
		try {
			setState(104);
			switch (_input.LA(1)) {
			case WIDTH:
				_localctx = new CtxWidthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				width();
				}
				break;
			case HEIGHT:
				_localctx = new CtxHeightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				height();
				}
				break;
			case FONT:
				_localctx = new CtxFontContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				font();
				}
				break;
			case FONTSIZE:
				_localctx = new CtxFontsizeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				fontsize();
				}
				break;
			case COLOR:
				_localctx = new CtxColorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				color();
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

	public static class WidthContext extends ParserRuleContext {
		public TerminalNode WIDTH() { return getToken(QLSParser.WIDTH, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(WIDTH);
			setState(107);
			match(T__6);
			setState(108);
			match(Integer);
			setState(109);
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

	public static class HeightContext extends ParserRuleContext {
		public TerminalNode HEIGHT() { return getToken(QLSParser.HEIGHT, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitHeight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(HEIGHT);
			setState(112);
			match(T__6);
			setState(113);
			match(Integer);
			setState(114);
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

	public static class FontContext extends ParserRuleContext {
		public TerminalNode FONT() { return getToken(QLSParser.FONT, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public FontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_font; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFont(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FontContext font() throws RecognitionException {
		FontContext _localctx = new FontContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_font);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(FONT);
			setState(117);
			match(T__6);
			setState(118);
			match(STRING);
			setState(119);
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

	public static class FontsizeContext extends ParserRuleContext {
		public TerminalNode FONTSIZE() { return getToken(QLSParser.FONTSIZE, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public FontsizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fontsize; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFontsize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FontsizeContext fontsize() throws RecognitionException {
		FontsizeContext _localctx = new FontsizeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fontsize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(FONTSIZE);
			setState(122);
			match(T__6);
			setState(123);
			match(Integer);
			setState(124);
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

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode COLOR() { return getToken(QLSParser.COLOR, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(COLOR);
			setState(127);
			match(T__6);
			setState(128);
			match(STRING);
			setState(129);
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

	public static class ComponentContext extends ParserRuleContext {
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
	 
		public ComponentContext() { }
		public void copyFrom(ComponentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxCheckboxContext extends ComponentContext {
		public CheckboxContext checkbox() {
			return getRuleContext(CheckboxContext.class,0);
		}
		public CtxCheckboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxCheckbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSpinboxContext extends ComponentContext {
		public SpinboxContext spinbox() {
			return getRuleContext(SpinboxContext.class,0);
		}
		public CtxSpinboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSpinbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxDropdownContext extends ComponentContext {
		public DropdownContext dropdown() {
			return getRuleContext(DropdownContext.class,0);
		}
		public CtxDropdownContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxDropdown(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxRadiobuttonContext extends ComponentContext {
		public RadiobuttonContext radiobutton() {
			return getRuleContext(RadiobuttonContext.class,0);
		}
		public CtxRadiobuttonContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxRadiobutton(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxTextboxContext extends ComponentContext {
		public TextboxContext textbox() {
			return getRuleContext(TextboxContext.class,0);
		}
		public CtxTextboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxTextbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSliderContext extends ComponentContext {
		public SliderContext slider() {
			return getRuleContext(SliderContext.class,0);
		}
		public CtxSliderContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSlider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_component);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new CtxTextboxContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				textbox();
				}
				break;
			case 2:
				_localctx = new CtxSpinboxContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				spinbox();
				}
				break;
			case 3:
				_localctx = new CtxSliderContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				slider();
				}
				break;
			case 4:
				_localctx = new CtxDropdownContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				dropdown();
				}
				break;
			case 5:
				_localctx = new CtxRadiobuttonContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				radiobutton();
				}
				break;
			case 6:
				_localctx = new CtxCheckboxContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				checkbox();
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

	public static class TextboxContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public TextboxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textbox; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitTextbox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextboxContext textbox() throws RecognitionException {
		TextboxContext _localctx = new TextboxContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_textbox);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(WIDGET);
			setState(140);
			match(T__7);
			setState(141);
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

	public static class SpinboxContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public SpinboxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spinbox; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSpinbox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpinboxContext spinbox() throws RecognitionException {
		SpinboxContext _localctx = new SpinboxContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_spinbox);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(WIDGET);
			setState(144);
			match(T__8);
			setState(145);
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

	public static class SliderContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public TerminalNode LP() { return getToken(QLSParser.LP, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public TerminalNode RP() { return getToken(QLSParser.RP, 0); }
		public SliderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slider; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSlider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliderContext slider() throws RecognitionException {
		SliderContext _localctx = new SliderContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_slider);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(WIDGET);
			setState(148);
			match(T__9);
			setState(154);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(149);
				match(LP);
				setState(150);
				match(STRING);
				setState(151);
				match(T__10);
				setState(152);
				match(STRING);
				setState(153);
				match(RP);
				}
			}

			setState(156);
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

	public static class DropdownContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode LP() { return getToken(QLSParser.LP, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public TerminalNode RP() { return getToken(QLSParser.RP, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public DropdownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropdown; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDropdown(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropdownContext dropdown() throws RecognitionException {
		DropdownContext _localctx = new DropdownContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dropdown);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(WIDGET);
			setState(159);
			match(T__11);
			setState(160);
			match(LP);
			setState(161);
			match(STRING);
			setState(162);
			match(T__10);
			setState(163);
			match(STRING);
			setState(164);
			match(RP);
			setState(165);
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

	public static class RadiobuttonContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode LP() { return getToken(QLSParser.LP, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public TerminalNode RP() { return getToken(QLSParser.RP, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public RadiobuttonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_radiobutton; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitRadiobutton(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RadiobuttonContext radiobutton() throws RecognitionException {
		RadiobuttonContext _localctx = new RadiobuttonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_radiobutton);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(WIDGET);
			setState(168);
			match(T__12);
			setState(169);
			match(LP);
			setState(170);
			match(STRING);
			setState(171);
			match(T__10);
			setState(172);
			match(STRING);
			setState(173);
			match(RP);
			setState(174);
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

	public static class CheckboxContext extends ParserRuleContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode NEWLINE() { return getToken(QLSParser.NEWLINE, 0); }
		public TerminalNode LP() { return getToken(QLSParser.LP, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode RP() { return getToken(QLSParser.RP, 0); }
		public CheckboxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkbox; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCheckbox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckboxContext checkbox() throws RecognitionException {
		CheckboxContext _localctx = new CheckboxContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_checkbox);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(WIDGET);
			setState(177);
			match(T__13);
			setState(181);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(178);
				match(LP);
				setState(179);
				match(STRING);
				setState(180);
				match(RP);
				}
			}

			setState(183);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentifierContext extends LiteralContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public IdentifierContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public IntegerContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalContext extends LiteralContext {
		public TerminalNode Decimal() { return getToken(QLSParser.Decimal, 0); }
		public DecimalContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(QLSParser.BooleanLiteral, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(189);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(BooleanLiteral);
				}
				break;
			case Integer:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(Integer);
				}
				break;
			case Decimal:
				_localctx = new DecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(Decimal);
				}
				break;
			case Identifier:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				match(Identifier);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00c4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\3\3\3\3\7\3\66\n\3\f\3\16\39\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\5\5E\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\5\bW\n\b\3\t\3\t\3\t\3\t\3\t\5\t^\n\t\3\t\3\t\3\t\3\t\5\td"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\5\nk\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008c\n\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u009d"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00b8"+
		"\n\26\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u00c0\n\27\3\30\3\30\3\30\2\2"+
		"\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\3\3\2\21\24\u00c2"+
		"\2\60\3\2\2\2\4\62\3\2\2\2\6:\3\2\2\2\bD\3\2\2\2\nF\3\2\2\2\fL\3\2\2\2"+
		"\16R\3\2\2\2\20X\3\2\2\2\22j\3\2\2\2\24l\3\2\2\2\26q\3\2\2\2\30v\3\2\2"+
		"\2\32{\3\2\2\2\34\u0080\3\2\2\2\36\u008b\3\2\2\2 \u008d\3\2\2\2\"\u0091"+
		"\3\2\2\2$\u0095\3\2\2\2&\u00a0\3\2\2\2(\u00a9\3\2\2\2*\u00b2\3\2\2\2,"+
		"\u00bf\3\2\2\2.\u00c1\3\2\2\2\60\61\5\4\3\2\61\3\3\2\2\2\62\63\7\3\2\2"+
		"\63\67\7\26\2\2\64\66\5\6\4\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2"+
		"\678\3\2\2\28\5\3\2\2\29\67\3\2\2\2:;\7\4\2\2;<\7\26\2\2<=\7)\2\2=>\5"+
		"\b\5\2>?\7*\2\2?\7\3\2\2\2@E\5\n\6\2AE\5\f\7\2BE\5\16\b\2CE\5\36\20\2"+
		"D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\t\3\2\2\2FG\7\5\2\2GH\7\34\2"+
		"\2HI\7)\2\2IJ\5\b\5\2JK\7*\2\2K\13\3\2\2\2LM\7\6\2\2MN\7\34\2\2NO\7)\2"+
		"\2OP\5\16\b\2PQ\7*\2\2Q\r\3\2\2\2RS\7\7\2\2ST\7\26\2\2TV\7%\2\2UW\5\36"+
		"\20\2VU\3\2\2\2VW\3\2\2\2W\17\3\2\2\2XY\7\b\2\2Yc\5.\30\2Z]\7)\2\2[^\5"+
		"\22\n\2\\^\5\36\20\2][\3\2\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_d\7*\2\2"+
		"`a\5\36\20\2ab\7%\2\2bd\3\2\2\2cZ\3\2\2\2c`\3\2\2\2d\21\3\2\2\2ek\5\24"+
		"\13\2fk\5\26\f\2gk\5\30\r\2hk\5\32\16\2ik\5\34\17\2je\3\2\2\2jf\3\2\2"+
		"\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2k\23\3\2\2\2lm\7 \2\2mn\7\t\2\2no\7\27"+
		"\2\2op\7%\2\2p\25\3\2\2\2qr\7!\2\2rs\7\t\2\2st\7\27\2\2tu\7%\2\2u\27\3"+
		"\2\2\2vw\7\"\2\2wx\7\t\2\2xy\7\34\2\2yz\7%\2\2z\31\3\2\2\2{|\7#\2\2|}"+
		"\7\t\2\2}~\7\27\2\2~\177\7%\2\2\177\33\3\2\2\2\u0080\u0081\7$\2\2\u0081"+
		"\u0082\7\t\2\2\u0082\u0083\7\34\2\2\u0083\u0084\7%\2\2\u0084\35\3\2\2"+
		"\2\u0085\u008c\5 \21\2\u0086\u008c\5\"\22\2\u0087\u008c\5$\23\2\u0088"+
		"\u008c\5&\24\2\u0089\u008c\5(\25\2\u008a\u008c\5*\26\2\u008b\u0085\3\2"+
		"\2\2\u008b\u0086\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\37\3\2\2\2\u008d\u008e\7\37\2"+
		"\2\u008e\u008f\7\n\2\2\u008f\u0090\7%\2\2\u0090!\3\2\2\2\u0091\u0092\7"+
		"\37\2\2\u0092\u0093\7\13\2\2\u0093\u0094\7%\2\2\u0094#\3\2\2\2\u0095\u0096"+
		"\7\37\2\2\u0096\u009c\7\f\2\2\u0097\u0098\7\'\2\2\u0098\u0099\7\34\2\2"+
		"\u0099\u009a\7\r\2\2\u009a\u009b\7\34\2\2\u009b\u009d\7(\2\2\u009c\u0097"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7%\2\2\u009f"+
		"%\3\2\2\2\u00a0\u00a1\7\37\2\2\u00a1\u00a2\7\16\2\2\u00a2\u00a3\7\'\2"+
		"\2\u00a3\u00a4\7\34\2\2\u00a4\u00a5\7\r\2\2\u00a5\u00a6\7\34\2\2\u00a6"+
		"\u00a7\7(\2\2\u00a7\u00a8\7%\2\2\u00a8\'\3\2\2\2\u00a9\u00aa\7\37\2\2"+
		"\u00aa\u00ab\7\17\2\2\u00ab\u00ac\7\'\2\2\u00ac\u00ad\7\34\2\2\u00ad\u00ae"+
		"\7\r\2\2\u00ae\u00af\7\34\2\2\u00af\u00b0\7(\2\2\u00b0\u00b1\7%\2\2\u00b1"+
		")\3\2\2\2\u00b2\u00b3\7\37\2\2\u00b3\u00b7\7\20\2\2\u00b4\u00b5\7\'\2"+
		"\2\u00b5\u00b6\7\34\2\2\u00b6\u00b8\7(\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7%\2\2\u00ba+\3\2\2\2\u00bb\u00c0"+
		"\7\25\2\2\u00bc\u00c0\7\27\2\2\u00bd\u00c0\7\30\2\2\u00be\u00c0\7\26\2"+
		"\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0-\3\2\2\2\u00c1\u00c2\t\2\2\2\u00c2/\3\2\2\2\f\67DV]cj\u008b"+
		"\u009c\u00b7\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}