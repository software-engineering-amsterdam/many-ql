// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/qls/src/qls/syntax/QLS.g4 by ANTLR 4.5
package qls.gen;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, QuestionType=23, Boolean=24, 
		WidgetType=25, Color=26, Integer=27, Decimal=28, String=29, Identifier=30, 
		Comment=31, LineComment=32, WS=33;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_statement = 2, RULE_section = 3, 
		RULE_questionWithRules = 4, RULE_question = 5, RULE_defaultStmt = 6, RULE_stylesheetRule = 7, 
		RULE_widgetValue = 8;
	public static final String[] ruleNames = {
		"stylesheet", "page", "statement", "section", "questionWithRules", "question", 
		"defaultStmt", "stylesheetRule", "widgetValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'forecolor'", 
		"'backcolor'", "'widget'", "'slider'", "'('", "','", "')'", "'radio'", 
		"'dropdown'", "'checkbox'", "'textbox'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "QuestionType", 
		"Boolean", "WidgetType", "Color", "Integer", "Decimal", "String", "Identifier", 
		"Comment", "LineComment", "WS"
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
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			match(T__0);
			setState(19); 
			match(Identifier);
			setState(20); 
			match(T__1);
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21); 
				page();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(26); 
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

	public static class PageContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(QLSParser.String, 0); }
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
		enterRule(_localctx, 2, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			match(T__3);
			setState(29); 
			match(String);
			setState(30); 
			match(T__1);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31); 
				statement();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(36); 
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

	public static class StatementContext extends ParserRuleContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public QuestionWithRulesContext questionWithRules() {
			return getRuleContext(QuestionWithRulesContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public DefaultStmtContext defaultStmt() {
			return getRuleContext(DefaultStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); 
				section();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); 
				questionWithRules();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40); 
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41); 
				defaultStmt();
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(QLSParser.String, 0); }
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
		enterRule(_localctx, 6, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			match(T__4);
			setState(45); 
			match(String);
			setState(46); 
			match(T__1);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47); 
				statement();
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(52); 
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

	public static class QuestionWithRulesContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<StylesheetRuleContext> stylesheetRule() {
			return getRuleContexts(StylesheetRuleContext.class);
		}
		public StylesheetRuleContext stylesheetRule(int i) {
			return getRuleContext(StylesheetRuleContext.class,i);
		}
		public QuestionWithRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionWithRules; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestionWithRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionWithRulesContext questionWithRules() throws RecognitionException {
		QuestionWithRulesContext _localctx = new QuestionWithRulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionWithRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); 
			match(T__5);
			setState(55); 
			match(Identifier);
			setState(56); 
			match(T__1);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57); 
				stylesheetRule();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) );
			setState(62); 
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
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
		enterRule(_localctx, 10, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			match(T__5);
			setState(65); 
			match(Identifier);
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

	public static class DefaultStmtContext extends ParserRuleContext {
		public TerminalNode QuestionType() { return getToken(QLSParser.QuestionType, 0); }
		public List<StylesheetRuleContext> stylesheetRule() {
			return getRuleContexts(StylesheetRuleContext.class);
		}
		public StylesheetRuleContext stylesheetRule(int i) {
			return getRuleContext(StylesheetRuleContext.class,i);
		}
		public DefaultStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefaultStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStmtContext defaultStmt() throws RecognitionException {
		DefaultStmtContext _localctx = new DefaultStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defaultStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			match(T__6);
			setState(68); 
			match(QuestionType);
			setState(69); 
			match(T__1);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70); 
				stylesheetRule();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) );
			setState(75); 
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

	public static class StylesheetRuleContext extends ParserRuleContext {
		public Token label;
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public TerminalNode String() { return getToken(QLSParser.String, 0); }
		public TerminalNode Color() { return getToken(QLSParser.Color, 0); }
		public WidgetValueContext widgetValue() {
			return getRuleContext(WidgetValueContext.class,0);
		}
		public StylesheetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheetRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesheetRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetRuleContext stylesheetRule() throws RecognitionException {
		StylesheetRuleContext _localctx = new StylesheetRuleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stylesheetRule);
		try {
			setState(94);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); 
				((StylesheetRuleContext)_localctx).label = match(T__7);
				setState(78); 
				match(T__8);
				setState(79); 
				match(Integer);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); 
				((StylesheetRuleContext)_localctx).label = match(T__9);
				setState(81); 
				match(T__8);
				setState(82); 
				match(Integer);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(83); 
				((StylesheetRuleContext)_localctx).label = match(T__10);
				setState(84); 
				match(T__8);
				setState(85); 
				match(String);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(86); 
				((StylesheetRuleContext)_localctx).label = match(T__11);
				setState(87); 
				match(T__8);
				setState(88); 
				match(Color);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(89); 
				((StylesheetRuleContext)_localctx).label = match(T__12);
				setState(90); 
				match(T__8);
				setState(91); 
				match(Color);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(92); 
				((StylesheetRuleContext)_localctx).label = match(T__13);
				setState(93); 
				widgetValue();
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

	public static class WidgetValueContext extends ParserRuleContext {
		public Token wlabel;
		public Token decMin;
		public Token decMax;
		public Token decStep;
		public Token intMin;
		public Token intMax;
		public Token intStep;
		public Token yesText;
		public Token noText;
		public List<TerminalNode> Decimal() { return getTokens(QLSParser.Decimal); }
		public TerminalNode Decimal(int i) {
			return getToken(QLSParser.Decimal, i);
		}
		public List<TerminalNode> Integer() { return getTokens(QLSParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(QLSParser.Integer, i);
		}
		public List<TerminalNode> String() { return getTokens(QLSParser.String); }
		public TerminalNode String(int i) {
			return getToken(QLSParser.String, i);
		}
		public WidgetValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widgetValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidgetValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetValueContext widgetValue() throws RecognitionException {
		WidgetValueContext _localctx = new WidgetValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_widgetValue);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); 
				((WidgetValueContext)_localctx).wlabel = match(T__14);
				setState(97); 
				match(T__15);
				setState(98); 
				((WidgetValueContext)_localctx).decMin = match(Decimal);
				setState(99); 
				match(T__16);
				setState(100); 
				((WidgetValueContext)_localctx).decMax = match(Decimal);
				setState(101); 
				match(T__16);
				setState(102); 
				((WidgetValueContext)_localctx).decStep = match(Decimal);
				setState(103); 
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); 
				((WidgetValueContext)_localctx).wlabel = match(T__14);
				setState(105); 
				match(T__15);
				setState(106); 
				((WidgetValueContext)_localctx).intMin = match(Integer);
				setState(107); 
				match(T__16);
				setState(108); 
				((WidgetValueContext)_localctx).intMax = match(Integer);
				setState(109); 
				match(T__16);
				setState(110); 
				((WidgetValueContext)_localctx).intStep = match(Integer);
				setState(111); 
				match(T__17);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112); 
				((WidgetValueContext)_localctx).wlabel = match(T__18);
				setState(113); 
				match(T__15);
				setState(114); 
				((WidgetValueContext)_localctx).yesText = match(String);
				setState(115); 
				match(T__16);
				setState(116); 
				((WidgetValueContext)_localctx).noText = match(String);
				setState(117); 
				match(T__17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118); 
				((WidgetValueContext)_localctx).wlabel = match(T__19);
				setState(119); 
				match(T__15);
				setState(120); 
				((WidgetValueContext)_localctx).yesText = match(String);
				setState(121); 
				match(T__16);
				setState(122); 
				((WidgetValueContext)_localctx).noText = match(String);
				setState(123); 
				match(T__17);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124); 
				((WidgetValueContext)_localctx).wlabel = match(T__20);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(125); 
				((WidgetValueContext)_localctx).wlabel = match(T__21);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u0083\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\6\2\31\n\2\r\2\16\2\32\3\2\3\2\3\3\3\3\3\3\3\3\6\3#\n\3\r\3\16"+
		"\3$\3\3\3\3\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\6\5\63\n\5\r\5\16"+
		"\5\64\3\5\3\5\3\6\3\6\3\6\3\6\6\6=\n\6\r\6\16\6>\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\6\bJ\n\b\r\b\16\bK\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0081\n\n\3\n\2\2\13\2\4\6\b\n\f\16"+
		"\20\22\2\2\u008b\2\24\3\2\2\2\4\36\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n8\3"+
		"\2\2\2\fB\3\2\2\2\16E\3\2\2\2\20`\3\2\2\2\22\u0080\3\2\2\2\24\25\7\3\2"+
		"\2\25\26\7 \2\2\26\30\7\4\2\2\27\31\5\4\3\2\30\27\3\2\2\2\31\32\3\2\2"+
		"\2\32\30\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\35\7\5\2\2\35\3\3\2\2"+
		"\2\36\37\7\6\2\2\37 \7\37\2\2 \"\7\4\2\2!#\5\6\4\2\"!\3\2\2\2#$\3\2\2"+
		"\2$\"\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\7\5\2\2\'\5\3\2\2\2(-\5\b\5\2)-\5"+
		"\n\6\2*-\5\f\7\2+-\5\16\b\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\7"+
		"\3\2\2\2./\7\7\2\2/\60\7\37\2\2\60\62\7\4\2\2\61\63\5\6\4\2\62\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\5"+
		"\2\2\67\t\3\2\2\289\7\b\2\29:\7 \2\2:<\7\4\2\2;=\5\20\t\2<;\3\2\2\2=>"+
		"\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\5\2\2A\13\3\2\2\2BC\7\b\2\2"+
		"CD\7 \2\2D\r\3\2\2\2EF\7\t\2\2FG\7\31\2\2GI\7\4\2\2HJ\5\20\t\2IH\3\2\2"+
		"\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\5\2\2N\17\3\2\2\2OP\7\n"+
		"\2\2PQ\7\13\2\2Qa\7\35\2\2RS\7\f\2\2ST\7\13\2\2Ta\7\35\2\2UV\7\r\2\2V"+
		"W\7\13\2\2Wa\7\37\2\2XY\7\16\2\2YZ\7\13\2\2Za\7\34\2\2[\\\7\17\2\2\\]"+
		"\7\13\2\2]a\7\34\2\2^_\7\20\2\2_a\5\22\n\2`O\3\2\2\2`R\3\2\2\2`U\3\2\2"+
		"\2`X\3\2\2\2`[\3\2\2\2`^\3\2\2\2a\21\3\2\2\2bc\7\21\2\2cd\7\22\2\2de\7"+
		"\36\2\2ef\7\23\2\2fg\7\36\2\2gh\7\23\2\2hi\7\36\2\2i\u0081\7\24\2\2jk"+
		"\7\21\2\2kl\7\22\2\2lm\7\35\2\2mn\7\23\2\2no\7\35\2\2op\7\23\2\2pq\7\35"+
		"\2\2q\u0081\7\24\2\2rs\7\25\2\2st\7\22\2\2tu\7\37\2\2uv\7\23\2\2vw\7\37"+
		"\2\2w\u0081\7\24\2\2xy\7\26\2\2yz\7\22\2\2z{\7\37\2\2{|\7\23\2\2|}\7\37"+
		"\2\2}\u0081\7\24\2\2~\u0081\7\27\2\2\177\u0081\7\30\2\2\u0080b\3\2\2\2"+
		"\u0080j\3\2\2\2\u0080r\3\2\2\2\u0080x\3\2\2\2\u0080~\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081\23\3\2\2\2\n\32$,\64>K`\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}