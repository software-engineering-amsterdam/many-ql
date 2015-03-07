// Generated from E:/development/Steven/src/test/resources/antlr/grammars\QLS.g4 by ANTLR 4.5
package edu.parser.QLS.antlrGenerated;
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
		T__9=10, T__10=11, T__11=12, UPPERCASE=13, LOWERCASE=14, NUMBERS=15, STRING=16, 
		COMMENT_LINE=17, WS=18;
	public static final int
		RULE_stylesheet = 0, RULE_identifier = 1, RULE_stylesheet_element = 2, 
		RULE_page = 3, RULE_section = 4, RULE_statement = 5, RULE_question = 6, 
		RULE_default_statement = 7, RULE_question_type = 8, RULE_style = 9;
	public static final String[] ruleNames = {
		"stylesheet", "identifier", "stylesheet_element", "page", "section", "statement", 
		"question", "default_statement", "question_type", "style"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'widget'", "'width'", "'font'", "'color'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "UPPERCASE", "LOWERCASE", "NUMBERS", "STRING", "COMMENT_LINE", "WS"
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<Stylesheet_elementContext> stylesheet_element() {
			return getRuleContexts(Stylesheet_elementContext.class);
		}
		public Stylesheet_elementContext stylesheet_element(int i) {
			return getRuleContext(Stylesheet_elementContext.class,i);
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
			identifier();
			setState(22); 
			match(T__1);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23); 
				stylesheet_element();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6))) != 0) );
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> UPPERCASE() { return getTokens(QLSParser.UPPERCASE); }
		public TerminalNode UPPERCASE(int i) {
			return getToken(QLSParser.UPPERCASE, i);
		}
		public List<TerminalNode> LOWERCASE() { return getTokens(QLSParser.LOWERCASE); }
		public TerminalNode LOWERCASE(int i) {
			return getToken(QLSParser.LOWERCASE, i);
		}
		public List<TerminalNode> NUMBERS() { return getTokens(QLSParser.NUMBERS); }
		public TerminalNode NUMBERS(int i) {
			return getToken(QLSParser.NUMBERS, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0) );
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

	public static class Stylesheet_elementContext extends ParserRuleContext {
		public PageContext page() {
			return getRuleContext(PageContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Stylesheet_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet_element; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesheet_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stylesheet_elementContext stylesheet_element() throws RecognitionException {
		Stylesheet_elementContext _localctx = new Stylesheet_elementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stylesheet_element);
		try {
			setState(37);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); 
				page();
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(36); 
				statement();
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

	public static class PageContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
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
		enterRule(_localctx, 6, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			match(T__3);
			setState(40); 
			match(T__1);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(41); 
				section();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SectionContext extends ParserRuleContext {
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
			setState(49); 
			match(T__4);
			setState(50); 
			match(STRING);
			setState(51); 
			match(T__1);
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52); 
				statement();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 || _la==T__6 );
			setState(57); 
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
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Default_statementContext default_statement() {
			return getRuleContext(Default_statementContext.class,0);
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
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(61);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(59); 
				question();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); 
				default_statement();
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

	public static class QuestionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
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
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63); 
				match(T__5);
				setState(64); 
				identifier();
				setState(65); 
				match(T__1);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
					{
					{
					setState(66); 
					style();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72); 
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74); 
				match(T__5);
				setState(75); 
				identifier();
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

	public static class Default_statementContext extends ParserRuleContext {
		public Question_typeContext question_type() {
			return getRuleContext(Question_typeContext.class,0);
		}
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public Default_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefault_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_statementContext default_statement() throws RecognitionException {
		Default_statementContext _localctx = new Default_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_default_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			match(T__6);
			setState(79); 
			question_type();
			setState(80); 
			match(T__1);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				{
				setState(81); 
				style();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87); 
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

	public static class Question_typeContext extends ParserRuleContext {
		public TerminalNode UPPERCASE() { return getToken(QLSParser.UPPERCASE, 0); }
		public Question_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestion_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_typeContext question_type() throws RecognitionException {
		Question_typeContext _localctx = new Question_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			match(UPPERCASE);
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
	public static class WidgetContext extends StyleContext {
		public TerminalNode UPPERCASE() { return getToken(QLSParser.UPPERCASE, 0); }
		public WidgetContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorContext extends StyleContext {
		public TerminalNode NUMBERS() { return getToken(QLSParser.NUMBERS, 0); }
		public ColorContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WidthContext extends StyleContext {
		public TerminalNode NUMBERS() { return getToken(QLSParser.NUMBERS, 0); }
		public WidthContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FontContext extends StyleContext {
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public FontContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFont(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_style);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new WidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91); 
				match(T__7);
				setState(92); 
				match(UPPERCASE);
				}
				break;
			case T__8:
				_localctx = new WidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93); 
				match(T__8);
				setState(94); 
				match(NUMBERS);
				}
				break;
			case T__9:
				_localctx = new FontContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(95); 
				match(T__9);
				setState(96); 
				match(STRING);
				}
				break;
			case T__10:
				_localctx = new ColorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(97); 
				match(T__10);
				setState(98); 
				match(T__11);
				setState(99); 
				match(NUMBERS);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24i\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\4\3\4\5\4(\n\4\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\6\68\n\6\r\6\16\69\3\6\3\6\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b"+
		"\7\bF\n\b\f\b\16\bI\13\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\7\t"+
		"U\n\t\f\t\16\tX\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13g\n\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\17\21"+
		"j\2\26\3\2\2\2\4!\3\2\2\2\6\'\3\2\2\2\b)\3\2\2\2\n\63\3\2\2\2\f?\3\2\2"+
		"\2\16N\3\2\2\2\20P\3\2\2\2\22[\3\2\2\2\24f\3\2\2\2\26\27\7\3\2\2\27\30"+
		"\5\4\3\2\30\32\7\4\2\2\31\33\5\6\4\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32"+
		"\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7\5\2\2\37\3\3\2\2\2 \"\t\2"+
		"\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%(\5\b\5\2&(\5"+
		"\f\7\2\'%\3\2\2\2\'&\3\2\2\2(\7\3\2\2\2)*\7\6\2\2*.\7\4\2\2+-\5\n\6\2"+
		",+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61"+
		"\62\7\5\2\2\62\t\3\2\2\2\63\64\7\7\2\2\64\65\7\22\2\2\65\67\7\4\2\2\66"+
		"8\5\f\7\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7"+
		"\5\2\2<\13\3\2\2\2=@\5\16\b\2>@\5\20\t\2?=\3\2\2\2?>\3\2\2\2@\r\3\2\2"+
		"\2AB\7\b\2\2BC\5\4\3\2CG\7\4\2\2DF\5\24\13\2ED\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\5\2\2KO\3\2\2\2LM\7\b\2\2MO\5\4"+
		"\3\2NA\3\2\2\2NL\3\2\2\2O\17\3\2\2\2PQ\7\t\2\2QR\5\22\n\2RV\7\4\2\2SU"+
		"\5\24\13\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2"+
		"YZ\7\5\2\2Z\21\3\2\2\2[\\\7\17\2\2\\\23\3\2\2\2]^\7\n\2\2^g\7\17\2\2_"+
		"`\7\13\2\2`g\7\21\2\2ab\7\f\2\2bg\7\22\2\2cd\7\r\2\2de\7\16\2\2eg\7\21"+
		"\2\2f]\3\2\2\2f_\3\2\2\2fa\3\2\2\2fc\3\2\2\2g\25\3\2\2\2\f\34#\'.9?GN"+
		"Vf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}