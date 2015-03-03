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
			match(Identifier);
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
			match(Identifier);
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
			question();
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
			match(Identifier);
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
				component();
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
		public TerminalNode Widget() { return getToken(QLSParser.Widget, 0); }
		public TerminalNode Textbox() { return getToken(QLSParser.Textbox, 0); }
		public TerminalNode Spinbox() { return getToken(QLSParser.Spinbox, 0); }
		public TerminalNode Slider() { return getToken(QLSParser.Slider, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public TerminalNode Dropdown() { return getToken(QLSParser.Dropdown, 0); }
		public TerminalNode Radio() { return getToken(QLSParser.Radio, 0); }
		public TerminalNode Checkbox() { return getToken(QLSParser.Checkbox, 0); }
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_component);
		try {
			setState(119);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(Widget);
				setState(90);
				match(Textbox);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(Widget);
				setState(92);
				match(Spinbox);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(Widget);
				setState(94);
				match(Slider);
				setState(95);
				match(LP);
				setState(96);
				match(STRING);
				setState(97);
				match(T__6);
				setState(98);
				match(STRING);
				setState(99);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(Widget);
				setState(101);
				match(Dropdown);
				setState(102);
				match(LP);
				setState(103);
				match(STRING);
				setState(104);
				match(T__6);
				setState(105);
				match(STRING);
				setState(106);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				match(Widget);
				setState(108);
				match(Radio);
				setState(109);
				match(LP);
				setState(110);
				match(STRING);
				setState(111);
				match(T__6);
				setState(112);
				match(STRING);
				setState(113);
				match(RP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				match(Widget);
				setState(115);
				match(Checkbox);
				setState(116);
				match(LP);
				setState(117);
				match(STRING);
				setState(118);
				match(RP);
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
			setState(137);
			switch (_input.LA(1)) {
			case Width:
				_localctx = new CtxWidthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(Width);
				setState(122);
				match(T__7);
				setState(123);
				match(Integer);
				}
				break;
			case Height:
				_localctx = new CtxHeightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(Height);
				setState(125);
				match(T__7);
				setState(126);
				match(Integer);
				}
				break;
			case Font:
				_localctx = new CtxFontContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(Font);
				setState(128);
				match(T__7);
				setState(129);
				match(STRING);
				}
				break;
			case Fontsize:
				_localctx = new CtxFontsizeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(Fontsize);
				setState(131);
				match(T__7);
				setState(132);
				match(Integer);
				}
				break;
			case Color:
				_localctx = new CtxColorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(Color);
				setState(134);
				match(T__7);
				setState(135);
				match(HASH);
				setState(136);
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
			setState(142);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				_localctx = new CtxBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(BooleanLiteral);
				}
				break;
			case Integer:
				_localctx = new CtxIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(Integer);
				}
				break;
			case Money:
				_localctx = new CtxMoneyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0095\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\67\n\5\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t\7\tT\n\t\f\t\16"+
		"\tW\13\t\3\t\5\tZ\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u008c\n\13\3\f\3\f\3\f\5\f\u0091\n\f\3\r\3\r"+
		"\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\13\16\u009e\2\32\3\2"+
		"\2\2\4\35\3\2\2\2\6%\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\fC\3\2\2\2\16I\3"+
		"\2\2\2\20N\3\2\2\2\22y\3\2\2\2\24\u008b\3\2\2\2\26\u0090\3\2\2\2\30\u0092"+
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
		"YQ\3\2\2\2Z\21\3\2\2\2[\\\7\25\2\2\\z\7\26\2\2]^\7\25\2\2^z\7\27\2\2_"+
		"`\7\25\2\2`a\7\30\2\2ab\7(\2\2bc\7\"\2\2cd\7\t\2\2de\7\"\2\2ez\7)\2\2"+
		"fg\7\25\2\2gh\7\31\2\2hi\7(\2\2ij\7\"\2\2jk\7\t\2\2kl\7\"\2\2lz\7)\2\2"+
		"mn\7\25\2\2no\7\32\2\2op\7(\2\2pq\7\"\2\2qr\7\t\2\2rs\7\"\2\2sz\7)\2\2"+
		"tu\7\25\2\2uv\7\33\2\2vw\7(\2\2wx\7\"\2\2xz\7)\2\2y[\3\2\2\2y]\3\2\2\2"+
		"y_\3\2\2\2yf\3\2\2\2ym\3\2\2\2yt\3\2\2\2z\23\3\2\2\2{|\7\20\2\2|}\7\n"+
		"\2\2}\u008c\7\35\2\2~\177\7\21\2\2\177\u0080\7\n\2\2\u0080\u008c\7\35"+
		"\2\2\u0081\u0082\7\22\2\2\u0082\u0083\7\n\2\2\u0083\u008c\7\"\2\2\u0084"+
		"\u0085\7\23\2\2\u0085\u0086\7\n\2\2\u0086\u008c\7\35\2\2\u0087\u0088\7"+
		"\24\2\2\u0088\u0089\7\n\2\2\u0089\u008a\7%\2\2\u008a\u008c\7\35\2\2\u008b"+
		"{\3\2\2\2\u008b~\3\2\2\2\u008b\u0081\3\2\2\2\u008b\u0084\3\2\2\2\u008b"+
		"\u0087\3\2\2\2\u008c\25\3\2\2\2\u008d\u0091\7\17\2\2\u008e\u0091\7\35"+
		"\2\2\u008f\u0091\7\36\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\27\3\2\2\2\u0092\u0093\t\2\2\2\u0093\31\3\2\2\2\f"+
		"\"+\66>LUYy\u008b\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}