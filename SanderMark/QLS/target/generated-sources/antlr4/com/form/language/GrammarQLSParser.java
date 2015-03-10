// Generated from GrammarQLS.g4 by ANTLR 4.5
package com.form.language;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarQLSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, BOOLEAN=26, STRING=27, INTEGER=28, COLOR=29, ID=30, WS=31, COMMENT=32, 
		DIGIT=33;
	public static final int
		RULE_stylesheet = 0, RULE_pageList = 1, RULE_page = 2, RULE_statementList = 3, 
		RULE_statement = 4, RULE_sectionStatement = 5, RULE_questionStatement = 6, 
		RULE_defaultStatement = 7, RULE_styleList = 8, RULE_widget = 9, RULE_specificWidget = 10, 
		RULE_style = 11, RULE_type = 12;
	public static final String[] ruleNames = {
		"stylesheet", "pageList", "page", "statementList", "statement", "sectionStatement", 
		"questionStatement", "defaultStatement", "styleList", "widget", "specificWidget", 
		"style", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'widget'", "'textbox'", "'checkbox'", "'spinbox'", "'slider'", 
		"'dropdown'", "'('", "','", "')'", "'radiobutton'", "'width'", "':'", 
		"'font'", "'fontsize'", "'color'", "'Boolean'", "'String'", "'Number'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "BOOLEAN", "STRING", "INTEGER", "COLOR", "ID", "WS", "COMMENT", 
		"DIGIT"
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
	public String getGrammarFileName() { return "GrammarQLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarQLSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public StyleSheet result;
		public Token ID;
		public PageListContext pages;
		public TerminalNode ID() { return getToken(GrammarQLSParser.ID, 0); }
		public PageListContext pageList() {
			return getRuleContext(PageListContext.class,0);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			((StylesheetContext)_localctx).ID = match(ID);
			setState(28);
			match(T__1);
			setState(29);
			((StylesheetContext)_localctx).pages = pageList();
			((StylesheetContext)_localctx).result =  new StyleSheet((((StylesheetContext)_localctx).ID!=null?((StylesheetContext)_localctx).ID.getText():null),((StylesheetContext)_localctx).pages.result);
			setState(31);
			match(T__2);
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

	public static class PageListContext extends ParserRuleContext {
		public List<Page> result;
		public PageContext stmt;
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public PageListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterPageList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitPageList(this);
		}
	}

	public final PageListContext pageList() throws RecognitionException {
		PageListContext _localctx = new PageListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pageList);
		List<Page> pages = new ArrayList<Page>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				((PageListContext)_localctx).stmt = page();
				stmts.add(((PageListContext)_localctx).stmt.result);
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			((PageListContext)_localctx).result =  stmts;
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
		public Page result;
		public Token ID;
		public StatementListContext stmts;
		public TerminalNode ID() { return getToken(GrammarQLSParser.ID, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitPage(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_page);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__3);
			setState(43);
			((PageContext)_localctx).ID = match(ID);
			setState(44);
			match(T__1);
			setState(45);
			((PageContext)_localctx).stmts = statementList();
			((PageContext)_localctx).result =  new Page((((PageContext)_localctx).ID!=null?((PageContext)_localctx).ID.getText():null),((PageContext)_localctx).stmts.result);
			setState(47);
			match(T__2);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<Statement> result;
		public StatementContext stmt;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitStatementList(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statementList);
		List<Statement> sections = new ArrayList<Statement>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				((StatementListContext)_localctx).stmt = statement();
				stmts.add(((StatementListContext)_localctx).stmt.result);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			((StatementListContext)_localctx).result =  stmts;
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
		public Statement result;
		public SectionStatementContext Sectionstmt;
		public QuestionStatementContext Questionstmt;
		public DefaultStatementContext Defaultstmt;
		public SectionStatementContext sectionStatement() {
			return getRuleContext(SectionStatementContext.class,0);
		}
		public QuestionStatementContext questionStatement() {
			return getRuleContext(QuestionStatementContext.class,0);
		}
		public DefaultStatementContext defaultStatement() {
			return getRuleContext(DefaultStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(67);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((StatementContext)_localctx).Sectionstmt = sectionStatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).Sectionstmt.result;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				((StatementContext)_localctx).Questionstmt = questionStatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).Questionstmt.result;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				((StatementContext)_localctx).Defaultstmt = defaultStatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).Defaultstmt.result;
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

	public static class SectionStatementContext extends ParserRuleContext {
		public Section result;
		public Token STRING;
		public StatementListContext stmts;
		public TerminalNode STRING() { return getToken(GrammarQLSParser.STRING, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public SectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterSectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitSectionStatement(this);
		}
	}

	public final SectionStatementContext sectionStatement() throws RecognitionException {
		SectionStatementContext _localctx = new SectionStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			((SectionStatementContext)_localctx).STRING = match(STRING);
			setState(71);
			match(T__1);
			setState(72);
			((SectionStatementContext)_localctx).stmts = statementList();
			((SectionStatementContext)_localctx).result =  new Section((((SectionStatementContext)_localctx).STRING!=null?((SectionStatementContext)_localctx).STRING.getText():null),((SectionStatementContext)_localctx).stmts.result);
			setState(74);
			match(T__2);
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

	public static class QuestionStatementContext extends ParserRuleContext {
		public Question result;
		public Token ID;
		public WidgetContext widget;
		public TerminalNode ID() { return getToken(GrammarQLSParser.ID, 0); }
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public QuestionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterQuestionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitQuestionStatement(this);
		}
	}

	public final QuestionStatementContext questionStatement() throws RecognitionException {
		QuestionStatementContext _localctx = new QuestionStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionStatement);
		try {
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__5);
				setState(77);
				((QuestionStatementContext)_localctx).ID = match(ID);
				setState(78);
				((QuestionStatementContext)_localctx).widget = widget();
				((QuestionStatementContext)_localctx).result =  new Question((((QuestionStatementContext)_localctx).ID!=null?((QuestionStatementContext)_localctx).ID.getText():null), ((QuestionStatementContext)_localctx).widget.result);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__5);
				setState(82);
				((QuestionStatementContext)_localctx).ID = match(ID);
				((QuestionStatementContext)_localctx).result =  new Question((((QuestionStatementContext)_localctx).ID!=null?((QuestionStatementContext)_localctx).ID.getText():null));
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

	public static class DefaultStatementContext extends ParserRuleContext {
		public Default result;
		public TypeContext type;
		public WidgetContext widget;
		public StyleListContext styles;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class,0);
		}
		public StyleListContext styleList() {
			return getRuleContext(StyleListContext.class,0);
		}
		public DefaultStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterDefaultStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitDefaultStatement(this);
		}
	}

	public final DefaultStatementContext defaultStatement() throws RecognitionException {
		DefaultStatementContext _localctx = new DefaultStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defaultStatement);
		try {
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__6);
				setState(87);
				((DefaultStatementContext)_localctx).type = type();
				setState(88);
				((DefaultStatementContext)_localctx).widget = widget();
				 ((DefaultStatementContext)_localctx).result =  new Default(((DefaultStatementContext)_localctx).type.result,((DefaultStatementContext)_localctx).widget.result);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(T__6);
				setState(92);
				((DefaultStatementContext)_localctx).type = type();
				setState(93);
				match(T__1);
				setState(94);
				((DefaultStatementContext)_localctx).styles = styleList();
				setState(95);
				widget();
				 ((DefaultStatementContext)_localctx).result =  new Default(((DefaultStatementContext)_localctx).type.result,widget.result,styles.result);
				setState(97);
				match(T__2);
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

	public static class StyleListContext extends ParserRuleContext {
		public List<Style> result;
		public StyleContext stmt;
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public StyleListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterStyleList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitStyleList(this);
		}
	}

	public final StyleListContext styleList() throws RecognitionException {
		StyleListContext _localctx = new StyleListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_styleList);
		List<Style> sections = new ArrayList<Style>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				((StyleListContext)_localctx).stmt = style();
				stmts.add(((StyleListContext)_localctx).stmt.result);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0) );
			((StyleListContext)_localctx).result =  stmts;
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
		public Widget result;
		public SpecificWidgetContext specificWidget;
		public SpecificWidgetContext specificWidget() {
			return getRuleContext(SpecificWidgetContext.class,0);
		}
		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitWidget(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_widget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__7);
			setState(111);
			((WidgetContext)_localctx).specificWidget = specificWidget();
			_localctx.result = new Widget(((WidgetContext)_localctx).specificWidget.result)
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

	public static class SpecificWidgetContext extends ParserRuleContext {
		public Widget result;
		public List<TerminalNode> STRING() { return getTokens(GrammarQLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GrammarQLSParser.STRING, i);
		}
		public SpecificWidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificWidget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterSpecificWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitSpecificWidget(this);
		}
	}

	public final SpecificWidgetContext specificWidget() throws RecognitionException {
		SpecificWidgetContext _localctx = new SpecificWidgetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_specificWidget);
		try {
			setState(136);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(T__8);
				((SpecificWidgetContext)_localctx).result =  new TextBox();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__9);
				((SpecificWidgetContext)_localctx).result =  new CheckBox();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(T__10);
				((SpecificWidgetContext)_localctx).result =  new SpinBox();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(T__11);
				((SpecificWidgetContext)_localctx).result =  new Slider();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				match(T__12);
				setState(123);
				match(T__13);
				setState(124);
				match(STRING);
				setState(125);
				match(T__14);
				setState(126);
				match(STRING);
				setState(127);
				match(T__15);
				((SpecificWidgetContext)_localctx).result =  new DropDown();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(T__16);
				setState(130);
				match(T__13);
				setState(131);
				match(STRING);
				setState(132);
				match(T__14);
				setState(133);
				match(STRING);
				setState(134);
				match(T__15);
				((SpecificWidgetContext)_localctx).result =  new RadioButton();
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

	public static class StyleContext extends ParserRuleContext {
		public Style result;
		public Token INTEGER;
		public Token STRING;
		public Token COLOR;
		public TerminalNode INTEGER() { return getToken(GrammarQLSParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(GrammarQLSParser.STRING, 0); }
		public TerminalNode COLOR() { return getToken(GrammarQLSParser.COLOR, 0); }
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitStyle(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_style);
		try {
			setState(154);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__17);
				setState(139);
				match(T__18);
				setState(140);
				((StyleContext)_localctx).INTEGER = match(INTEGER);
				((StyleContext)_localctx).result =  new Width((((StyleContext)_localctx).INTEGER!=null?((StyleContext)_localctx).INTEGER.getText():null));
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(T__19);
				setState(143);
				match(T__18);
				setState(144);
				((StyleContext)_localctx).STRING = match(STRING);
				((StyleContext)_localctx).result =  new Width((((StyleContext)_localctx).STRING!=null?((StyleContext)_localctx).STRING.getText():null));
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(T__20);
				setState(147);
				match(T__18);
				setState(148);
				((StyleContext)_localctx).INTEGER = match(INTEGER);
				_localctx.result = new FontSize((((StyleContext)_localctx).INTEGER!=null?((StyleContext)_localctx).INTEGER.getText():null))
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(T__21);
				setState(151);
				match(T__18);
				setState(152);
				((StyleContext)_localctx).COLOR = match(COLOR);
				_localctx.result = new Color((((StyleContext)_localctx).COLOR!=null?((StyleContext)_localctx).COLOR.getText():null))
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
		public Type result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarQLSListener ) ((GrammarQLSListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			setState(162);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(T__22);
				((TypeContext)_localctx).result =  new BoolType();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__23);
				((TypeContext)_localctx).result =  new StringType();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(T__24);
				((TypeContext)_localctx).result =  new IntType();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\6\3\'\n\3\r\3\16\3(\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6"+
		"\5\67\n\5\r\5\16\58\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6F\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bW\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tf\n\t\3\n\3"+
		"\n\3\n\6\nk\n\n\r\n\16\nl\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u008b\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u009d\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a5\n\16"+
		"\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\u00aa\2\34\3\2\2\2\4"+
		"&\3\2\2\2\6,\3\2\2\2\b\66\3\2\2\2\nE\3\2\2\2\fG\3\2\2\2\16V\3\2\2\2\20"+
		"e\3\2\2\2\22j\3\2\2\2\24p\3\2\2\2\26\u008a\3\2\2\2\30\u009c\3\2\2\2\32"+
		"\u00a4\3\2\2\2\34\35\7\3\2\2\35\36\7 \2\2\36\37\7\4\2\2\37 \5\4\3\2 !"+
		"\b\2\1\2!\"\7\5\2\2\"\3\3\2\2\2#$\5\6\4\2$%\b\3\1\2%\'\3\2\2\2&#\3\2\2"+
		"\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\b\3\1\2+\5\3\2\2\2,-\7\6"+
		"\2\2-.\7 \2\2./\7\4\2\2/\60\5\b\5\2\60\61\b\4\1\2\61\62\7\5\2\2\62\7\3"+
		"\2\2\2\63\64\5\n\6\2\64\65\b\5\1\2\65\67\3\2\2\2\66\63\3\2\2\2\678\3\2"+
		"\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\5\1\2;\t\3\2\2\2<=\5\f\7\2=>"+
		"\b\6\1\2>F\3\2\2\2?@\5\16\b\2@A\b\6\1\2AF\3\2\2\2BC\5\20\t\2CD\b\6\1\2"+
		"DF\3\2\2\2E<\3\2\2\2E?\3\2\2\2EB\3\2\2\2F\13\3\2\2\2GH\7\7\2\2HI\7\35"+
		"\2\2IJ\7\4\2\2JK\5\b\5\2KL\b\7\1\2LM\7\5\2\2M\r\3\2\2\2NO\7\b\2\2OP\7"+
		" \2\2PQ\5\24\13\2QR\b\b\1\2RW\3\2\2\2ST\7\b\2\2TU\7 \2\2UW\b\b\1\2VN\3"+
		"\2\2\2VS\3\2\2\2W\17\3\2\2\2XY\7\t\2\2YZ\5\32\16\2Z[\5\24\13\2[\\\b\t"+
		"\1\2\\f\3\2\2\2]^\7\t\2\2^_\5\32\16\2_`\7\4\2\2`a\5\22\n\2ab\5\24\13\2"+
		"bc\b\t\1\2cd\7\5\2\2df\3\2\2\2eX\3\2\2\2e]\3\2\2\2f\21\3\2\2\2gh\5\30"+
		"\r\2hi\b\n\1\2ik\3\2\2\2jg\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2"+
		"\2\2no\b\n\1\2o\23\3\2\2\2pq\7\n\2\2qr\5\26\f\2rs\b\13\1\2s\25\3\2\2\2"+
		"tu\7\13\2\2u\u008b\b\f\1\2vw\7\f\2\2w\u008b\b\f\1\2xy\7\r\2\2y\u008b\b"+
		"\f\1\2z{\7\16\2\2{\u008b\b\f\1\2|}\7\17\2\2}~\7\20\2\2~\177\7\35\2\2\177"+
		"\u0080\7\21\2\2\u0080\u0081\7\35\2\2\u0081\u0082\7\22\2\2\u0082\u008b"+
		"\b\f\1\2\u0083\u0084\7\23\2\2\u0084\u0085\7\20\2\2\u0085\u0086\7\35\2"+
		"\2\u0086\u0087\7\21\2\2\u0087\u0088\7\35\2\2\u0088\u0089\7\22\2\2\u0089"+
		"\u008b\b\f\1\2\u008at\3\2\2\2\u008av\3\2\2\2\u008ax\3\2\2\2\u008az\3\2"+
		"\2\2\u008a|\3\2\2\2\u008a\u0083\3\2\2\2\u008b\27\3\2\2\2\u008c\u008d\7"+
		"\24\2\2\u008d\u008e\7\25\2\2\u008e\u008f\7\36\2\2\u008f\u009d\b\r\1\2"+
		"\u0090\u0091\7\26\2\2\u0091\u0092\7\25\2\2\u0092\u0093\7\35\2\2\u0093"+
		"\u009d\b\r\1\2\u0094\u0095\7\27\2\2\u0095\u0096\7\25\2\2\u0096\u0097\7"+
		"\36\2\2\u0097\u009d\b\r\1\2\u0098\u0099\7\30\2\2\u0099\u009a\7\25\2\2"+
		"\u009a\u009b\7\37\2\2\u009b\u009d\b\r\1\2\u009c\u008c\3\2\2\2\u009c\u0090"+
		"\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u0098\3\2\2\2\u009d\31\3\2\2\2\u009e"+
		"\u009f\7\31\2\2\u009f\u00a5\b\16\1\2\u00a0\u00a1\7\32\2\2\u00a1\u00a5"+
		"\b\16\1\2\u00a2\u00a3\7\33\2\2\u00a3\u00a5\b\16\1\2\u00a4\u009e\3\2\2"+
		"\2\u00a4\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\33\3\2\2\2\13(8EVel\u008a"+
		"\u009c\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}