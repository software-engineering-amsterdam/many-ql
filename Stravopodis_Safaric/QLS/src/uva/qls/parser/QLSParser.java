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
		T__9=10, T__10=11, T__11=12, BooleanLiteral=13, Width=14, Height=15, Font=16, 
		Fontsize=17, Color=18, Widget=19, Textbox=20, Spinbox=21, Slider=22, Dropdown=23, 
		Radio=24, Checkbox=25, Identifier=26, Integer=27, Money=28, WS=29, ID_LETTER=30, 
		DIGIT=31, STRING=32, LINE_COMMENT=33, COMMENT=34, HASH=35, NEWLINE=36, 
		TAB=37, LP=38, RP=39, LC=40, RC=41;
	public static final int
		RULE_prog = 0, RULE_stylesheet = 1, RULE_page = 2, RULE_statement = 3, 
		RULE_section = 4, RULE_subsection = 5, RULE_question = 6, RULE_defaultValue = 7, 
		RULE_component = 8, RULE_style = 9, RULE_literal = 10, RULE_primitiveType = 11;
	public static final String[] ruleNames = {
		"prog", "stylesheet", "page", "statement", "section", "subsection", "question", 
		"defaultValue", "component", "style", "literal", "primitiveType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'section'", "'subsection '", "'question'", 
		"'default'", "','", "':'", "'boolean'", "'money'", "'string'", "'integer'", 
		null, "'width'", "'height'", "'font'", "'fontsize'", "'color'", "'widget'", 
		"'textbox'", "'spinbox'", "'slider'", "'dropdown'", "'radio'", "'checkbox'", 
		null, null, null, null, null, null, null, null, null, "'#'", "'\n'", "'\t'", 
		"'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "BooleanLiteral", "Width", "Height", "Font", "Fontsize", "Color", 
		"Widget", "Textbox", "Spinbox", "Slider", "Dropdown", "Radio", "Checkbox", 
		"Identifier", "Integer", "Money", "WS", "ID_LETTER", "DIGIT", "STRING", 
		"LINE_COMMENT", "COMMENT", "HASH", "NEWLINE", "TAB", "LP", "RP", "LC", 
		"RC"
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
		public TerminalNode EOF() { return getToken(QLSParser.EOF, 0); }
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
			setState(24);
			stylesheet();
			setState(25);
			match(EOF);
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
		public Token id;
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
			setState(27);
			match(T__0);
			setState(28);
			((StylesheetContext)_localctx).id = match(Identifier);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(29);
				((StylesheetContext)_localctx).page = page();
				((StylesheetContext)_localctx).pgs.add(((StylesheetContext)_localctx).page);
				}
				}
				setState(34);
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
		public Token id;
		public StatementContext statement;
		public List<StatementContext> stms = new ArrayList<StatementContext>();
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__1);
			setState(36);
			((PageContext)_localctx).id = match(Identifier);
			setState(37);
			match(LC);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color) | (1L << Widget))) != 0)) {
				{
				{
				setState(38);
				((PageContext)_localctx).statement = statement();
				((PageContext)_localctx).stms.add(((PageContext)_localctx).statement);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxStyleContext extends StatementContext {
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public CtxStyleContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxStyle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSubsectionContext extends StatementContext {
		public SubsectionContext subsection() {
			return getRuleContext(SubsectionContext.class,0);
		}
		public CtxSubsectionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSubsection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSectionContext extends StatementContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public CtxSectionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxDefaultValueContext extends StatementContext {
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public CtxDefaultValueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxComponenetContext extends StatementContext {
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public CtxComponenetContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxComponenet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxQuestionContext extends StatementContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public CtxQuestionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(52);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new CtxSectionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				section();
				}
				break;
			case T__3:
				_localctx = new CtxSubsectionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				subsection();
				}
				break;
			case T__4:
				_localctx = new CtxQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				question();
				}
				break;
			case T__5:
				_localctx = new CtxDefaultValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				defaultValue();
				}
				break;
			case Widget:
				_localctx = new CtxComponenetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				component();
				}
				break;
			case Width:
			case Height:
			case Font:
			case Fontsize:
			case Color:
				_localctx = new CtxStyleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				style();
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
		public StatementContext statement;
		public List<StatementContext> stms = new ArrayList<StatementContext>();
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(55);
			match(STRING);
			setState(56);
			match(LC);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color) | (1L << Widget))) != 0)) {
				{
				{
				setState(57);
				((SectionContext)_localctx).statement = statement();
				((SectionContext)_localctx).stms.add(((SectionContext)_localctx).statement);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
		public QuestionContext quest;
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
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
			setState(65);
			match(T__3);
			setState(66);
			match(STRING);
			setState(67);
			match(LC);
			setState(68);
			((SubsectionContext)_localctx).quest = question();
			setState(69);
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
		public Token id;
		public ComponentContext cmp;
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__4);
			setState(72);
			((QuestionContext)_localctx).id = match(Identifier);
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(73);
				((QuestionContext)_localctx).cmp = component();
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

	public static class DefaultValueContext extends ParserRuleContext {
		public ComponentContext cmp;
		public StatementContext statement;
		public List<StatementContext> stms = new ArrayList<StatementContext>();
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__5);
			setState(77);
			primitiveType();
			setState(87);
			switch (_input.LA(1)) {
			case Widget:
				{
				setState(78);
				((DefaultValueContext)_localctx).cmp = component();
				}
				break;
			case LC:
				{
				{
				setState(79);
				match(LC);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color) | (1L << Widget))) != 0)) {
					{
					{
					setState(80);
					((DefaultValueContext)_localctx).statement = statement();
					((DefaultValueContext)_localctx).stms.add(((DefaultValueContext)_localctx).statement);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(RC);
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
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Checkbox() { return getToken(QLSParser.Checkbox, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxCheckboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxCheckbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSpinboxContext extends ComponentContext {
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Spinbox() { return getToken(QLSParser.Spinbox, 0); }
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxSpinboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSpinbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxDropdownContext extends ComponentContext {
		public Token v1;
		public Token v2;
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Dropdown() { return getToken(QLSParser.Dropdown, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxDropdownContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxDropdown(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxTextboxContext extends ComponentContext {
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Textbox() { return getToken(QLSParser.Textbox, 0); }
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxTextboxContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxTextbox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxSliderContext extends ComponentContext {
		public Token v1;
		public Token v2;
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Slider() { return getToken(QLSParser.Slider, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxSliderContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxSlider(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxRadioContext extends ComponentContext {
		public Token v1;
		public Token v2;
		public StyleContext style;
		public List<StyleContext> stls = new ArrayList<StyleContext>();
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Radio() { return getToken(QLSParser.Radio, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxRadioContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxRadio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_component);
		int _la;
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new CtxTextboxContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(Widget);
				setState(90);
				match(Textbox);
				setState(99);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(91);
					match(LC);
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(92);
						((CtxTextboxContext)_localctx).style = style();
						((CtxTextboxContext)_localctx).stls.add(((CtxTextboxContext)_localctx).style);
						}
						}
						setState(97);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(98);
					match(RC);
					}
				}

				}
				break;
			case 2:
				_localctx = new CtxSpinboxContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(Widget);
				setState(102);
				match(Spinbox);
				setState(111);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(103);
					match(LC);
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(104);
						((CtxSpinboxContext)_localctx).style = style();
						((CtxSpinboxContext)_localctx).stls.add(((CtxSpinboxContext)_localctx).style);
						}
						}
						setState(109);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(110);
					match(RC);
					}
				}

				}
				break;
			case 3:
				_localctx = new CtxSliderContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(Widget);
				setState(114);
				match(Slider);
				setState(115);
				match(LP);
				setState(116);
				((CtxSliderContext)_localctx).v1 = match(STRING);
				setState(117);
				match(T__6);
				setState(118);
				((CtxSliderContext)_localctx).v2 = match(STRING);
				setState(119);
				match(RP);
				setState(128);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(120);
					match(LC);
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(121);
						((CtxSliderContext)_localctx).style = style();
						((CtxSliderContext)_localctx).stls.add(((CtxSliderContext)_localctx).style);
						}
						}
						setState(126);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(127);
					match(RC);
					}
				}

				}
				break;
			case 4:
				_localctx = new CtxDropdownContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(Widget);
				setState(131);
				match(Dropdown);
				setState(132);
				match(LP);
				setState(133);
				((CtxDropdownContext)_localctx).v1 = match(STRING);
				setState(134);
				match(T__6);
				setState(135);
				((CtxDropdownContext)_localctx).v2 = match(STRING);
				setState(136);
				match(RP);
				setState(145);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(137);
					match(LC);
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(138);
						((CtxDropdownContext)_localctx).style = style();
						((CtxDropdownContext)_localctx).stls.add(((CtxDropdownContext)_localctx).style);
						}
						}
						setState(143);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(144);
					match(RC);
					}
				}

				}
				break;
			case 5:
				_localctx = new CtxRadioContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(Widget);
				setState(148);
				match(Radio);
				setState(149);
				match(LP);
				setState(150);
				((CtxRadioContext)_localctx).v1 = match(STRING);
				setState(151);
				match(T__6);
				setState(152);
				((CtxRadioContext)_localctx).v2 = match(STRING);
				setState(153);
				match(RP);
				setState(162);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(154);
					match(LC);
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(155);
						((CtxRadioContext)_localctx).style = style();
						((CtxRadioContext)_localctx).stls.add(((CtxRadioContext)_localctx).style);
						}
						}
						setState(160);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(161);
					match(RC);
					}
				}

				}
				break;
			case 6:
				_localctx = new CtxCheckboxContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				match(Widget);
				setState(165);
				match(Checkbox);
				setState(166);
				match(LP);
				setState(167);
				match(STRING);
				setState(168);
				match(RP);
				setState(177);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(169);
					match(LC);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(170);
						((CtxCheckboxContext)_localctx).style = style();
						((CtxCheckboxContext)_localctx).stls.add(((CtxCheckboxContext)_localctx).style);
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(176);
					match(RC);
					}
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
		public TerminalNode Height() { return getToken(QLSParser.Height, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public CtxHeightContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxHeight(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxFontContext extends StyleContext {
		public TerminalNode Font() { return getToken(QLSParser.Font, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public CtxFontContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxFont(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxColorContext extends StyleContext {
		public TerminalNode Color() { return getToken(QLSParser.Color, 0); }
		public TerminalNode HASH() { return getToken(QLSParser.HASH, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public CtxColorContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxWidthContext extends StyleContext {
		public TerminalNode Width() { return getToken(QLSParser.Width, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public CtxWidthContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxWidth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxFontsizeContext extends StyleContext {
		public TerminalNode Fontsize() { return getToken(QLSParser.Fontsize, 0); }
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public CtxFontsizeContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxFontsize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_style);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case Width:
				_localctx = new CtxWidthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(Width);
				setState(182);
				match(T__7);
				setState(183);
				match(Integer);
				}
				break;
			case Height:
				_localctx = new CtxHeightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(Height);
				setState(185);
				match(T__7);
				setState(186);
				match(Integer);
				}
				break;
			case Font:
				_localctx = new CtxFontContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(Font);
				setState(188);
				match(T__7);
				setState(189);
				match(STRING);
				}
				break;
			case Fontsize:
				_localctx = new CtxFontsizeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				match(Fontsize);
				setState(191);
				match(T__7);
				setState(192);
				match(Integer);
				}
				break;
			case Color:
				_localctx = new CtxColorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				match(Color);
				setState(194);
				match(T__7);
				setState(195);
				match(HASH);
				setState(196);
				match(Integer);
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
	public static class CtxIntegerContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public CtxIntegerContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxMoneyContext extends LiteralContext {
		public TerminalNode Money() { return getToken(QLSParser.Money, 0); }
		public CtxMoneyContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxMoney(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxBooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(QLSParser.BooleanLiteral, 0); }
		public CtxBooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				_localctx = new CtxBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(BooleanLiteral);
				}
				break;
			case Integer:
				_localctx = new CtxIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(Integer);
				}
				break;
			case Money:
				_localctx = new CtxMoneyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(Money);
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
	 
		public PrimitiveTypeContext() { }
		public void copyFrom(PrimitiveTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxPrimitiveMoneyContext extends PrimitiveTypeContext {
		public CtxPrimitiveMoneyContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxPrimitiveMoney(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxPrimitiveIntegerContext extends PrimitiveTypeContext {
		public CtxPrimitiveIntegerContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxPrimitiveInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxPrimitiveBooleanContext extends PrimitiveTypeContext {
		public CtxPrimitiveBooleanContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxPrimitiveBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxPrimitiveStringContext extends PrimitiveTypeContext {
		public CtxPrimitiveStringContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxPrimitiveString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primitiveType);
		try {
			setState(208);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new CtxPrimitiveBooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new CtxPrimitiveMoneyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new CtxPrimitiveStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new CtxPrimitiveIntegerContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				match(T__11);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00d5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\67\n\5\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t\7\tT\n\t\f\t\16"+
		"\tW\13\t\3\t\5\tZ\n\t\3\n\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13\n\3\n\5\n"+
		"f\n\n\3\n\3\n\3\n\3\n\7\nl\n\n\f\n\16\no\13\n\3\n\5\nr\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\3\n\5\n\u0083\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008e\n\n\f\n\16\n\u0091\13"+
		"\n\3\n\5\n\u0094\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009f\n\n"+
		"\f\n\16\n\u00a2\13\n\3\n\5\n\u00a5\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u00ae\n\n\f\n\16\n\u00b1\13\n\3\n\5\n\u00b4\n\n\5\n\u00b6\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00c8\n\13\3\f\3\f\3\f\5\f\u00cd\n\f\3\r\3\r\3\r\3\r\5\r\u00d3"+
		"\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00ed\2\32\3\2\2\2\4"+
		"\35\3\2\2\2\6%\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\fC\3\2\2\2\16I\3\2\2\2"+
		"\20N\3\2\2\2\22\u00b5\3\2\2\2\24\u00c7\3\2\2\2\26\u00cc\3\2\2\2\30\u00d2"+
		"\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\7\3\2\2\36\"\7"+
		"\34\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2"+
		"\2\2$\"\3\2\2\2%&\7\4\2\2&\'\7\34\2\2\'+\7*\2\2(*\5\b\5\2)(\3\2\2\2*-"+
		"\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7+\2\2/\7\3\2\2\2\60"+
		"\67\5\n\6\2\61\67\5\f\7\2\62\67\5\16\b\2\63\67\5\20\t\2\64\67\5\22\n\2"+
		"\65\67\5\24\13\2\66\60\3\2\2\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2"+
		"\2\66\64\3\2\2\2\66\65\3\2\2\2\67\t\3\2\2\289\7\5\2\29:\7\"\2\2:>\7*\2"+
		"\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2"+
		"\2AB\7+\2\2B\13\3\2\2\2CD\7\6\2\2DE\7\"\2\2EF\7*\2\2FG\5\16\b\2GH\7+\2"+
		"\2H\r\3\2\2\2IJ\7\7\2\2JL\7\34\2\2KM\5\22\n\2LK\3\2\2\2LM\3\2\2\2M\17"+
		"\3\2\2\2NO\7\b\2\2OY\5\30\r\2PZ\5\22\n\2QU\7*\2\2RT\5\b\5\2SR\3\2\2\2"+
		"TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XZ\7+\2\2YP\3\2\2\2"+
		"YQ\3\2\2\2Z\21\3\2\2\2[\\\7\25\2\2\\e\7\26\2\2]a\7*\2\2^`\5\24\13\2_^"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2df\7+\2\2e]"+
		"\3\2\2\2ef\3\2\2\2f\u00b6\3\2\2\2gh\7\25\2\2hq\7\27\2\2im\7*\2\2jl\5\24"+
		"\13\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pr\7"+
		"+\2\2qi\3\2\2\2qr\3\2\2\2r\u00b6\3\2\2\2st\7\25\2\2tu\7\30\2\2uv\7(\2"+
		"\2vw\7\"\2\2wx\7\t\2\2xy\7\"\2\2y\u0082\7)\2\2z~\7*\2\2{}\5\24\13\2|{"+
		"\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0083\7+\2\2\u0082z\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u00b6\3\2\2\2\u0084\u0085\7\25\2\2\u0085\u0086\7\31\2\2\u0086\u0087\7"+
		"(\2\2\u0087\u0088\7\"\2\2\u0088\u0089\7\t\2\2\u0089\u008a\7\"\2\2\u008a"+
		"\u0093\7)\2\2\u008b\u008f\7*\2\2\u008c\u008e\5\24\13\2\u008d\u008c\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\7+\2\2\u0093\u008b\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u00b6\3\2\2\2\u0095\u0096\7\25\2\2\u0096"+
		"\u0097\7\32\2\2\u0097\u0098\7(\2\2\u0098\u0099\7\"\2\2\u0099\u009a\7\t"+
		"\2\2\u009a\u009b\7\"\2\2\u009b\u00a4\7)\2\2\u009c\u00a0\7*\2\2\u009d\u009f"+
		"\5\24\13\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5"+
		"\7+\2\2\u00a4\u009c\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00b6\3\2\2\2\u00a6"+
		"\u00a7\7\25\2\2\u00a7\u00a8\7\33\2\2\u00a8\u00a9\7(\2\2\u00a9\u00aa\7"+
		"\"\2\2\u00aa\u00b3\7)\2\2\u00ab\u00af\7*\2\2\u00ac\u00ae\5\24\13\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\7+\2\2\u00b3"+
		"\u00ab\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5[\3\2\2\2"+
		"\u00b5g\3\2\2\2\u00b5s\3\2\2\2\u00b5\u0084\3\2\2\2\u00b5\u0095\3\2\2\2"+
		"\u00b5\u00a6\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00b8\7\20\2\2\u00b8\u00b9"+
		"\7\n\2\2\u00b9\u00c8\7\35\2\2\u00ba\u00bb\7\21\2\2\u00bb\u00bc\7\n\2\2"+
		"\u00bc\u00c8\7\35\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\7\n\2\2\u00bf\u00c8"+
		"\7\"\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7\n\2\2\u00c2\u00c8\7\35\2\2"+
		"\u00c3\u00c4\7\24\2\2\u00c4\u00c5\7\n\2\2\u00c5\u00c6\7%\2\2\u00c6\u00c8"+
		"\7\35\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00ba\3\2\2\2\u00c7\u00bd\3\2\2\2"+
		"\u00c7\u00c0\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\25\3\2\2\2\u00c9\u00cd"+
		"\7\17\2\2\u00ca\u00cd\7\35\2\2\u00cb\u00cd\7\36\2\2\u00cc\u00c9\3\2\2"+
		"\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\27\3\2\2\2\u00ce\u00d3"+
		"\7\13\2\2\u00cf\u00d3\7\f\2\2\u00d0\u00d3\7\r\2\2\u00d1\u00d3\7\16\2\2"+
		"\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\31\3\2\2\2\31\"+\66>LUYaemq~\u0082\u008f\u0093\u00a0\u00a4"+
		"\u00af\u00b3\u00b5\u00c7\u00cc\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}