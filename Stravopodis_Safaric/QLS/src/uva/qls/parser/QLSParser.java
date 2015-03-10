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
	public static class CtxComponentContext extends StatementContext {
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public CtxComponentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxComponent(this);
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
				_localctx = new CtxComponentContext(_localctx);
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
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
	 
		public DefaultValueContext() { }
		public void copyFrom(DefaultValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtxDefaultStatementContext extends DefaultValueContext {
		public StyleContext style;
		public List<StyleContext> stms = new ArrayList<StyleContext>();
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public CtxDefaultStatementContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxDefaultStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtxDefaultComponentContext extends DefaultValueContext {
		public ComponentContext cmp;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public CtxDefaultComponentContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCtxDefaultComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defaultValue);
		int _la;
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new CtxDefaultComponentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__5);
				setState(77);
				primitiveType();
				setState(78);
				((CtxDefaultComponentContext)_localctx).cmp = component();
				}
				break;
			case 2:
				_localctx = new CtxDefaultStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__5);
				setState(81);
				primitiveType();
				setState(82);
				match(LC);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
					{
					{
					setState(83);
					((CtxDefaultStatementContext)_localctx).style = style();
					((CtxDefaultStatementContext)_localctx).stms.add(((CtxDefaultStatementContext)_localctx).style);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				match(RC);
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
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new CtxTextboxContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(Widget);
				setState(94);
				match(Textbox);
				setState(103);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(95);
					match(LC);
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(96);
						((CtxTextboxContext)_localctx).style = style();
						((CtxTextboxContext)_localctx).stls.add(((CtxTextboxContext)_localctx).style);
						}
						}
						setState(101);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(102);
					match(RC);
					}
				}

				}
				break;
			case 2:
				_localctx = new CtxSpinboxContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(Widget);
				setState(106);
				match(Spinbox);
				setState(115);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(107);
					match(LC);
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(108);
						((CtxSpinboxContext)_localctx).style = style();
						((CtxSpinboxContext)_localctx).stls.add(((CtxSpinboxContext)_localctx).style);
						}
						}
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(114);
					match(RC);
					}
				}

				}
				break;
			case 3:
				_localctx = new CtxSliderContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(Widget);
				setState(118);
				match(Slider);
				setState(119);
				match(LP);
				setState(120);
				((CtxSliderContext)_localctx).v1 = match(STRING);
				setState(121);
				match(T__6);
				setState(122);
				((CtxSliderContext)_localctx).v2 = match(STRING);
				setState(123);
				match(RP);
				setState(132);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(124);
					match(LC);
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(125);
						((CtxSliderContext)_localctx).style = style();
						((CtxSliderContext)_localctx).stls.add(((CtxSliderContext)_localctx).style);
						}
						}
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(131);
					match(RC);
					}
				}

				}
				break;
			case 4:
				_localctx = new CtxDropdownContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(Widget);
				setState(135);
				match(Dropdown);
				setState(136);
				match(LP);
				setState(137);
				((CtxDropdownContext)_localctx).v1 = match(STRING);
				setState(138);
				match(T__6);
				setState(139);
				((CtxDropdownContext)_localctx).v2 = match(STRING);
				setState(140);
				match(RP);
				setState(149);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(141);
					match(LC);
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(142);
						((CtxDropdownContext)_localctx).style = style();
						((CtxDropdownContext)_localctx).stls.add(((CtxDropdownContext)_localctx).style);
						}
						}
						setState(147);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(148);
					match(RC);
					}
				}

				}
				break;
			case 5:
				_localctx = new CtxRadioContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				match(Widget);
				setState(152);
				match(Radio);
				setState(153);
				match(LP);
				setState(154);
				((CtxRadioContext)_localctx).v1 = match(STRING);
				setState(155);
				match(T__6);
				setState(156);
				((CtxRadioContext)_localctx).v2 = match(STRING);
				setState(157);
				match(RP);
				setState(166);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(158);
					match(LC);
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(159);
						((CtxRadioContext)_localctx).style = style();
						((CtxRadioContext)_localctx).stls.add(((CtxRadioContext)_localctx).style);
						}
						}
						setState(164);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(165);
					match(RC);
					}
				}

				}
				break;
			case 6:
				_localctx = new CtxCheckboxContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(Widget);
				setState(169);
				match(Checkbox);
				setState(170);
				match(LP);
				setState(171);
				match(STRING);
				setState(172);
				match(RP);
				setState(181);
				_la = _input.LA(1);
				if (_la==LC) {
					{
					setState(173);
					match(LC);
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Width) | (1L << Height) | (1L << Font) | (1L << Fontsize) | (1L << Color))) != 0)) {
						{
						{
						setState(174);
						((CtxCheckboxContext)_localctx).style = style();
						((CtxCheckboxContext)_localctx).stls.add(((CtxCheckboxContext)_localctx).style);
						}
						}
						setState(179);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(180);
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
		public Token v;
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
		public Token v;
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
		public Token v;
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
		public Token v;
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
		public Token v;
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
			setState(201);
			switch (_input.LA(1)) {
			case Width:
				_localctx = new CtxWidthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(Width);
				setState(186);
				match(T__7);
				setState(187);
				((CtxWidthContext)_localctx).v = match(Integer);
				}
				break;
			case Height:
				_localctx = new CtxHeightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(Height);
				setState(189);
				match(T__7);
				setState(190);
				((CtxHeightContext)_localctx).v = match(Integer);
				}
				break;
			case Font:
				_localctx = new CtxFontContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(Font);
				setState(192);
				match(T__7);
				setState(193);
				((CtxFontContext)_localctx).v = match(STRING);
				}
				break;
			case Fontsize:
				_localctx = new CtxFontsizeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				match(Fontsize);
				setState(195);
				match(T__7);
				setState(196);
				((CtxFontsizeContext)_localctx).v = match(Integer);
				}
				break;
			case Color:
				_localctx = new CtxColorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				match(Color);
				setState(198);
				match(T__7);
				setState(199);
				match(HASH);
				setState(200);
				((CtxColorContext)_localctx).v = match(Integer);
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
			setState(206);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				_localctx = new CtxBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(BooleanLiteral);
				}
				break;
			case Integer:
				_localctx = new CtxIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(Integer);
				}
				break;
			case Money:
				_localctx = new CtxMoneyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
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
			setState(212);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new CtxPrimitiveBooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new CtxPrimitiveMoneyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new CtxPrimitiveStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new CtxPrimitiveIntegerContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\67\n\5\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7"+
		"\tW\n\t\f\t\16\tZ\13\t\3\t\3\t\5\t^\n\t\3\n\3\n\3\n\3\n\7\nd\n\n\f\n\16"+
		"\ng\13\n\3\n\5\nj\n\n\3\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n\3\n\5\n"+
		"v\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16\n\u0084"+
		"\13\n\3\n\5\n\u0087\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0092"+
		"\n\n\f\n\16\n\u0095\13\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u00a3\n\n\f\n\16\n\u00a6\13\n\3\n\5\n\u00a9\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00b2\n\n\f\n\16\n\u00b5\13\n\3\n\5\n\u00b8\n\n"+
		"\5\n\u00ba\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00cc\n\13\3\f\3\f\3\f\5\f\u00d1\n\f\3"+
		"\r\3\r\3\r\3\r\5\r\u00d7\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\2\2\u00f1\2\32\3\2\2\2\4\35\3\2\2\2\6%\3\2\2\2\b\66\3\2\2\2\n8\3\2\2"+
		"\2\fC\3\2\2\2\16I\3\2\2\2\20]\3\2\2\2\22\u00b9\3\2\2\2\24\u00cb\3\2\2"+
		"\2\26\u00d0\3\2\2\2\30\u00d6\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3"+
		"\3\2\2\2\35\36\7\3\2\2\36\"\7\34\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2\2"+
		"\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$\"\3\2\2\2%&\7\4\2\2&\'\7\34\2\2\'+"+
		"\7*\2\2(*\5\b\5\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+"+
		"\3\2\2\2./\7+\2\2/\7\3\2\2\2\60\67\5\n\6\2\61\67\5\f\7\2\62\67\5\16\b"+
		"\2\63\67\5\20\t\2\64\67\5\22\n\2\65\67\5\24\13\2\66\60\3\2\2\2\66\61\3"+
		"\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\t\3"+
		"\2\2\289\7\5\2\29:\7\"\2\2:>\7*\2\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2\2><\3"+
		"\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7+\2\2B\13\3\2\2\2CD\7\6\2\2DE"+
		"\7\"\2\2EF\7*\2\2FG\5\16\b\2GH\7+\2\2H\r\3\2\2\2IJ\7\7\2\2JL\7\34\2\2"+
		"KM\5\22\n\2LK\3\2\2\2LM\3\2\2\2M\17\3\2\2\2NO\7\b\2\2OP\5\30\r\2PQ\5\22"+
		"\n\2Q^\3\2\2\2RS\7\b\2\2ST\5\30\r\2TX\7*\2\2UW\5\24\13\2VU\3\2\2\2WZ\3"+
		"\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7+\2\2\\^\3\2\2\2]N"+
		"\3\2\2\2]R\3\2\2\2^\21\3\2\2\2_`\7\25\2\2`i\7\26\2\2ae\7*\2\2bd\5\24\13"+
		"\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hj\7+\2"+
		"\2ia\3\2\2\2ij\3\2\2\2j\u00ba\3\2\2\2kl\7\25\2\2lu\7\27\2\2mq\7*\2\2n"+
		"p\5\24\13\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2"+
		"\2tv\7+\2\2um\3\2\2\2uv\3\2\2\2v\u00ba\3\2\2\2wx\7\25\2\2xy\7\30\2\2y"+
		"z\7(\2\2z{\7\"\2\2{|\7\t\2\2|}\7\"\2\2}\u0086\7)\2\2~\u0082\7*\2\2\177"+
		"\u0081\5\24\13\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2"+
		"\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0087\7+\2\2\u0086~\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u00ba\3\2\2\2\u0088"+
		"\u0089\7\25\2\2\u0089\u008a\7\31\2\2\u008a\u008b\7(\2\2\u008b\u008c\7"+
		"\"\2\2\u008c\u008d\7\t\2\2\u008d\u008e\7\"\2\2\u008e\u0097\7)\2\2\u008f"+
		"\u0093\7*\2\2\u0090\u0092\5\24\13\2\u0091\u0090\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0098\7+\2\2\u0097\u008f\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u00ba\3\2\2\2\u0099\u009a\7\25\2\2\u009a\u009b\7\32\2\2\u009b"+
		"\u009c\7(\2\2\u009c\u009d\7\"\2\2\u009d\u009e\7\t\2\2\u009e\u009f\7\""+
		"\2\2\u009f\u00a8\7)\2\2\u00a0\u00a4\7*\2\2\u00a1\u00a3\5\24\13\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\7+\2\2\u00a8"+
		"\u00a0\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ba\3\2\2\2\u00aa\u00ab\7\25"+
		"\2\2\u00ab\u00ac\7\33\2\2\u00ac\u00ad\7(\2\2\u00ad\u00ae\7\"\2\2\u00ae"+
		"\u00b7\7)\2\2\u00af\u00b3\7*\2\2\u00b0\u00b2\5\24\13\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\7+\2\2\u00b7\u00af\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9_\3\2\2\2\u00b9k\3\2"+
		"\2\2\u00b9w\3\2\2\2\u00b9\u0088\3\2\2\2\u00b9\u0099\3\2\2\2\u00b9\u00aa"+
		"\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00bc\7\20\2\2\u00bc\u00bd\7\n\2\2\u00bd"+
		"\u00cc\7\35\2\2\u00be\u00bf\7\21\2\2\u00bf\u00c0\7\n\2\2\u00c0\u00cc\7"+
		"\35\2\2\u00c1\u00c2\7\22\2\2\u00c2\u00c3\7\n\2\2\u00c3\u00cc\7\"\2\2\u00c4"+
		"\u00c5\7\23\2\2\u00c5\u00c6\7\n\2\2\u00c6\u00cc\7\35\2\2\u00c7\u00c8\7"+
		"\24\2\2\u00c8\u00c9\7\n\2\2\u00c9\u00ca\7%\2\2\u00ca\u00cc\7\35\2\2\u00cb"+
		"\u00bb\3\2\2\2\u00cb\u00be\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cb\u00c4\3\2"+
		"\2\2\u00cb\u00c7\3\2\2\2\u00cc\25\3\2\2\2\u00cd\u00d1\7\17\2\2\u00ce\u00d1"+
		"\7\35\2\2\u00cf\u00d1\7\36\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2"+
		"\u00d0\u00cf\3\2\2\2\u00d1\27\3\2\2\2\u00d2\u00d7\7\13\2\2\u00d3\u00d7"+
		"\7\f\2\2\u00d4\u00d7\7\r\2\2\u00d5\u00d7\7\16\2\2\u00d6\u00d2\3\2\2\2"+
		"\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\31"+
		"\3\2\2\2\31\"+\66>LX]eiqu\u0082\u0086\u0093\u0097\u00a4\u00a8\u00b3\u00b7"+
		"\u00b9\u00cb\u00d0\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}