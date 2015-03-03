// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/qls/syntax/QLS.g4 by ANTLR 4.5
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, QuestionType=17, 
		Boolean=18, Integer=19, Decimal=20, WidgetType=21, Color=22, String=23, 
		Identifier=24, Comment=25, LineComment=26, WS=27;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_statement = 2, RULE_section = 3, 
		RULE_question = 4, RULE_defaultStmt = 5, RULE_stylesheetRule = 6, RULE_stringAgrs = 7, 
		RULE_intArgs = 8, RULE_decArgs = 9;
	public static final String[] ruleNames = {
		"stylesheet", "page", "statement", "section", "question", "defaultStmt", 
		"stylesheetRule", "stringAgrs", "intArgs", "decArgs"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'color'", "'widget'", 
		"'('", "')'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "QuestionType", "Boolean", "Integer", "Decimal", 
		"WidgetType", "Color", "String", "Identifier", "Comment", "LineComment", 
		"WS"
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
			setState(20); 
			match(T__0);
			setState(21); 
			match(Identifier);
			setState(22); 
			match(T__1);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23); 
				page();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(28); 
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
		enterRule(_localctx, 2, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			match(T__3);
			setState(31); 
			match(Identifier);
			setState(32); 
			match(T__1);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33); 
				statement();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(38); 
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
			setState(43);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); 
				section();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); 
				question();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(42); 
				defaultStmt();
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
			setState(45); 
			match(T__4);
			setState(46); 
			match(String);
			setState(47); 
			match(T__1);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48); 
				statement();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(53); 
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
		public List<StylesheetRuleContext> stylesheetRule() {
			return getRuleContexts(StylesheetRuleContext.class);
		}
		public StylesheetRuleContext stylesheetRule(int i) {
			return getRuleContext(StylesheetRuleContext.class,i);
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
		enterRule(_localctx, 8, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			match(T__5);
			setState(56); 
			match(Identifier);
			setState(65);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(57); 
				match(T__1);
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58); 
					stylesheetRule();
					}
					}
					setState(61); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0) );
				setState(63); 
				match(T__2);
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
		enterRule(_localctx, 10, RULE_defaultStmt);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0) );
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
		public TerminalNode WidgetType() { return getToken(QLSParser.WidgetType, 0); }
		public StringAgrsContext stringAgrs() {
			return getRuleContext(StringAgrsContext.class,0);
		}
		public IntArgsContext intArgs() {
			return getRuleContext(IntArgsContext.class,0);
		}
		public DecArgsContext decArgs() {
			return getRuleContext(DecArgsContext.class,0);
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
		enterRule(_localctx, 12, RULE_stylesheetRule);
		int _la;
		try {
			setState(101);
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
				match(WidgetType);
				setState(99);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(91); 
					match(T__13);
					setState(95);
					switch (_input.LA(1)) {
					case String:
						{
						setState(92); 
						stringAgrs();
						}
						break;
					case Integer:
						{
						setState(93); 
						intArgs();
						}
						break;
					case Decimal:
						{
						setState(94); 
						decArgs();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(97); 
					match(T__14);
					}
				}

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

	public static class StringAgrsContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(QLSParser.String); }
		public TerminalNode String(int i) {
			return getToken(QLSParser.String, i);
		}
		public StringAgrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringAgrs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStringAgrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringAgrsContext stringAgrs() throws RecognitionException {
		StringAgrsContext _localctx = new StringAgrsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringAgrs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103); 
					match(String);
					setState(104); 
					match(T__15);
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(110); 
			match(String);
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

	public static class IntArgsContext extends ParserRuleContext {
		public List<TerminalNode> Integer() { return getTokens(QLSParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(QLSParser.Integer, i);
		}
		public IntArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intArgs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitIntArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntArgsContext intArgs() throws RecognitionException {
		IntArgsContext _localctx = new IntArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_intArgs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(112); 
					match(Integer);
					setState(113); 
					match(T__15);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(119); 
			match(Integer);
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

	public static class DecArgsContext extends ParserRuleContext {
		public List<TerminalNode> Decimal() { return getTokens(QLSParser.Decimal); }
		public TerminalNode Decimal(int i) {
			return getToken(QLSParser.Decimal, i);
		}
		public DecArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decArgs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDecArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecArgsContext decArgs() throws RecognitionException {
		DecArgsContext _localctx = new DecArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decArgs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(121); 
					match(Decimal);
					setState(122); 
					match(T__15);
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(128); 
			match(Decimal);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u0085\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\3\3\3\3\3\3\3\3\6"+
		"\3%\n\3\r\3\16\3&\3\3\3\3\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\5\3\5\6\5\64"+
		"\n\5\r\5\16\5\65\3\5\3\5\3\6\3\6\3\6\3\6\6\6>\n\6\r\6\16\6?\3\6\3\6\5"+
		"\6D\n\6\3\7\3\7\3\7\3\7\6\7J\n\7\r\7\16\7K\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bb\n\b\3\b\3\b"+
		"\5\bf\n\b\5\bh\n\b\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\t\3\t\3\n\3\n\7\n"+
		"u\n\n\f\n\16\nx\13\n\3\n\3\n\3\13\3\13\7\13~\n\13\f\13\16\13\u0081\13"+
		"\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\u008c\2\26\3\2\2"+
		"\2\4 \3\2\2\2\6-\3\2\2\2\b/\3\2\2\2\n9\3\2\2\2\fE\3\2\2\2\16g\3\2\2\2"+
		"\20m\3\2\2\2\22v\3\2\2\2\24\177\3\2\2\2\26\27\7\3\2\2\27\30\7\32\2\2\30"+
		"\32\7\4\2\2\31\33\5\4\3\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34"+
		"\35\3\2\2\2\35\36\3\2\2\2\36\37\7\5\2\2\37\3\3\2\2\2 !\7\6\2\2!\"\7\32"+
		"\2\2\"$\7\4\2\2#%\5\6\4\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'("+
		"\3\2\2\2()\7\5\2\2)\5\3\2\2\2*.\5\b\5\2+.\5\n\6\2,.\5\f\7\2-*\3\2\2\2"+
		"-+\3\2\2\2-,\3\2\2\2.\7\3\2\2\2/\60\7\7\2\2\60\61\7\31\2\2\61\63\7\4\2"+
		"\2\62\64\5\6\4\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2"+
		"\2\66\67\3\2\2\2\678\7\5\2\28\t\3\2\2\29:\7\b\2\2:C\7\32\2\2;=\7\4\2\2"+
		"<>\5\16\b\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\5\2"+
		"\2BD\3\2\2\2C;\3\2\2\2CD\3\2\2\2D\13\3\2\2\2EF\7\t\2\2FG\7\23\2\2GI\7"+
		"\4\2\2HJ\5\16\b\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN"+
		"\7\5\2\2N\r\3\2\2\2OP\7\n\2\2PQ\7\13\2\2Qh\7\25\2\2RS\7\f\2\2ST\7\13\2"+
		"\2Th\7\25\2\2UV\7\r\2\2VW\7\13\2\2Wh\7\31\2\2XY\7\16\2\2YZ\7\13\2\2Zh"+
		"\7\30\2\2[\\\7\17\2\2\\e\7\27\2\2]a\7\20\2\2^b\5\20\t\2_b\5\22\n\2`b\5"+
		"\24\13\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2bc\3\2\2\2cd\7\21\2\2df\3\2\2\2"+
		"e]\3\2\2\2ef\3\2\2\2fh\3\2\2\2gO\3\2\2\2gR\3\2\2\2gU\3\2\2\2gX\3\2\2\2"+
		"g[\3\2\2\2h\17\3\2\2\2ij\7\31\2\2jl\7\22\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\31\2\2q\21\3\2\2\2rs\7\25\2\2s"+
		"u\7\22\2\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2"+
		"yz\7\25\2\2z\23\3\2\2\2{|\7\26\2\2|~\7\22\2\2}{\3\2\2\2~\u0081\3\2\2\2"+
		"\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0082\u0083\7\26\2\2\u0083\25\3\2\2\2\17\34&-\65?CKaegmv\177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}