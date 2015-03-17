// Generated from QLSGrammar.g4 by ANTLR 4.5
package uva.sc.qls.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class QLSGrammarParser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
	}

	protected static final DFA[]					_decisionToDFA;
	protected static final PredictionContextCache	_sharedContextCache	= new PredictionContextCache();
	public static final int							T__0				= 1,
			T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
			T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13,
			T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
			T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23,
			T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, BOOLEAN = 28,
			TRUE = 29, FALSE = 30, ID = 31, COLORENCODE = 32, NUMBER = 33,
			STRING = 34, COMMENT = 35, WS = 36;
	public static final int							RULE_stylesheet		= 0,
			RULE_page = 1, RULE_section = 2, RULE_sectionBody = 3,
			RULE_question = 4, RULE_widget = 5, RULE_defaultStyle = 6,
			RULE_styleProperty = 7, RULE_type = 8, RULE_widgetType = 9,
			RULE_font = 10;
	public static final String[]					ruleNames			= { "stylesheet", "page", "section", "sectionBody", "question", "widget", "defaultStyle", "styleProperty", "type", "widgetType", "font" };

	private static final String[]					_LITERAL_NAMES		= { null, "'stylesheet'", "'page'", "'{'", "'}'", "'section'", "'question'", "'widget'", "'('", "','", "')'", "'default'", "'width:'", "'font:'", "'fontsize:'", "'color:'", "'boolean'", "'number'", "'string'", "'checkbox'", "'spinbox'", "'radio'", "'\"Arial\"'", "'\"Times New Roman\"'", "'\"Bazooka\"'", "'\"Book Antiqua\"'", "'\"Courier\"'", "'\"Dialog\"'" };
	private static final String[]					_SYMBOLIC_NAMES		= { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BOOLEAN", "TRUE", "FALSE", "ID", "COLORENCODE", "NUMBER", "STRING", "COMMENT", "WS" };
	public static final Vocabulary					VOCABULARY			= new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[]					tokenNames;
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
	public String getGrammarFileName() {
		return "QLSGrammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public QLSGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class StylesheetContext extends ParserRuleContext {
		public PageContext			page;
		public List<PageContext>	pages	= new ArrayList<PageContext>();

		public TerminalNode ID() {
			return getToken(QLSGrammarParser.ID, 0);
		}

		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}

		public PageContext page(int i) {
			return getRuleContext(PageContext.class, i);
		}

		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_stylesheet;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterStylesheet(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitStylesheet(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitStylesheet(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(22);
				match(T__0);
				setState(23);
				match(ID);
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(24);
							((StylesheetContext) _localctx).page = page();
							((StylesheetContext) _localctx).pages.add(((StylesheetContext) _localctx).page);
						}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				while (_la == T__1);
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
		public SectionContext		section;
		public List<SectionContext>	sections	= new ArrayList<SectionContext>();

		public TerminalNode ID() {
			return getToken(QLSGrammarParser.ID, 0);
		}

		public DefaultStyleContext defaultStyle() {
			return getRuleContext(DefaultStyleContext.class, 0);
		}

		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}

		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class, i);
		}

		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_page;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterPage(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitPage(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitPage(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(29);
				match(T__1);
				setState(30);
				match(ID);
				setState(31);
				match(T__2);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(32);
							((PageContext) _localctx).section = section();
							((PageContext) _localctx).sections.add(((PageContext) _localctx).section);
						}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				while (_la == T__4);
				setState(38);
				_la = _input.LA(1);
				if (_la == T__10) {
					{
						setState(37);
						defaultStyle();
					}
				}

				setState(40);
				match(T__3);
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
		public TerminalNode STRING() {
			return getToken(QLSGrammarParser.STRING, 0);
		}

		public SectionBodyContext sectionBody() {
			return getRuleContext(SectionBodyContext.class, 0);
		}

		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_section;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterSection(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitSection(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitSection(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(42);
				match(T__4);
				setState(43);
				match(STRING);
				setState(44);
				sectionBody();
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

	public static class SectionBodyContext extends ParserRuleContext {
		public QuestionContext			question;
		public List<QuestionContext>	questions	= new ArrayList<QuestionContext>();
		public SectionContext			section;
		public List<SectionContext>		sections	= new ArrayList<SectionContext>();

		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}

		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class, i);
		}

		public DefaultStyleContext defaultStyle() {
			return getRuleContext(DefaultStyleContext.class, 0);
		}

		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}

		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class, i);
		}

		public SectionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_sectionBody;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterSectionBody(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitSectionBody(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitSectionBody(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final SectionBodyContext sectionBody() throws RecognitionException {
		SectionBodyContext _localctx = new SectionBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sectionBody);
		int _la;
		try {
			setState(64);
			switch (_input.LA(1)) {
				case T__5:
					enterOuterAlt(_localctx, 1);
					{
						setState(46);
						((SectionBodyContext) _localctx).question = question();
						((SectionBodyContext) _localctx).questions.add(((SectionBodyContext) _localctx).question);
					}
					break;
				case T__2:
					enterOuterAlt(_localctx, 2);
					{
						setState(47);
						match(T__2);
						setState(49);
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
								{
									setState(48);
									((SectionBodyContext) _localctx).question = question();
									((SectionBodyContext) _localctx).questions.add(((SectionBodyContext) _localctx).question);
								}
							}
							setState(51);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						while (_la == T__5);
						setState(56);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__4) {
							{
								{
									setState(53);
									((SectionBodyContext) _localctx).section = section();
									((SectionBodyContext) _localctx).sections.add(((SectionBodyContext) _localctx).section);
								}
							}
							setState(58);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(60);
						_la = _input.LA(1);
						if (_la == T__10) {
							{
								setState(59);
								defaultStyle();
							}
						}

						setState(62);
						match(T__3);
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
		public TerminalNode ID() {
			return getToken(QLSGrammarParser.ID, 0);
		}

		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class, 0);
		}

		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_question;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterQuestion(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitQuestion(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitQuestion(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(66);
				match(T__5);
				setState(67);
				match(ID);
				setState(69);
				_la = _input.LA(1);
				if (_la == T__6) {
					{
						setState(68);
						widget();
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

	public static class WidgetContext extends ParserRuleContext {
		public WidgetTypeContext widgetType() {
			return getRuleContext(WidgetTypeContext.class, 0);
		}

		public List<TerminalNode> STRING() {
			return getTokens(QLSGrammarParser.STRING);
		}

		public TerminalNode STRING(int i) {
			return getToken(QLSGrammarParser.STRING, i);
		}

		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_widget;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterWidget(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitWidget(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitWidget(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_widget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(71);
				match(T__6);
				setState(72);
				widgetType();
				setState(78);
				_la = _input.LA(1);
				if (_la == T__7) {
					{
						setState(73);
						match(T__7);
						setState(74);
						match(STRING);
						setState(75);
						match(T__8);
						setState(76);
						match(STRING);
						setState(77);
						match(T__9);
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

	public static class DefaultStyleContext extends ParserRuleContext {
		public StylePropertyContext			styleProperty;
		public List<StylePropertyContext>	styleProperties	= new ArrayList<StylePropertyContext>();

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public WidgetContext widget() {
			return getRuleContext(WidgetContext.class, 0);
		}

		public List<StylePropertyContext> styleProperty() {
			return getRuleContexts(StylePropertyContext.class);
		}

		public StylePropertyContext styleProperty(int i) {
			return getRuleContext(StylePropertyContext.class, i);
		}

		public DefaultStyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_defaultStyle;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterDefaultStyle(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitDefaultStyle(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitDefaultStyle(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final DefaultStyleContext defaultStyle() throws RecognitionException {
		DefaultStyleContext _localctx = new DefaultStyleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defaultStyle);
		int _la;
		try {
			setState(95);
			switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
					{
						setState(80);
						match(T__10);
						setState(81);
						type();
						setState(82);
						match(T__2);
						setState(84);
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
								{
									setState(83);
									((DefaultStyleContext) _localctx).styleProperty = styleProperty();
									((DefaultStyleContext) _localctx).styleProperties.add(((DefaultStyleContext) _localctx).styleProperty);
								}
							}
							setState(86);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0));
						setState(88);
						widget();
						setState(89);
						match(T__3);
					}
					break;
				case 2:
					enterOuterAlt(_localctx, 2);
					{
						setState(91);
						match(T__10);
						setState(92);
						type();
						setState(93);
						widget();
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

	public static class StylePropertyContext extends ParserRuleContext {
		public StylePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_styleProperty;
		}

		public StylePropertyContext() {
		}

		public void copyFrom(StylePropertyContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class FontNameContext extends StylePropertyContext {
		public FontContext font() {
			return getRuleContext(FontContext.class, 0);
		}

		public FontNameContext(StylePropertyContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterFontName(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitFontName(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitFontName(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class ColorContext extends StylePropertyContext {
		public TerminalNode COLORENCODE() {
			return getToken(QLSGrammarParser.COLORENCODE, 0);
		}

		public ColorContext(StylePropertyContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterColor(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitColor(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitColor(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class WidthContext extends StylePropertyContext {
		public TerminalNode NUMBER() {
			return getToken(QLSGrammarParser.NUMBER, 0);
		}

		public WidthContext(StylePropertyContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterWidth(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitWidth(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitWidth(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class FontsizeContext extends StylePropertyContext {
		public TerminalNode NUMBER() {
			return getToken(QLSGrammarParser.NUMBER, 0);
		}

		public FontsizeContext(StylePropertyContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterFontsize(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitFontsize(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitFontsize(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StylePropertyContext styleProperty() throws RecognitionException {
		StylePropertyContext _localctx = new StylePropertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_styleProperty);
		try {
			setState(105);
			switch (_input.LA(1)) {
				case T__11:
					_localctx = new WidthContext(_localctx);
					enterOuterAlt(_localctx, 1);
					{
						setState(97);
						match(T__11);
						setState(98);
						match(NUMBER);
					}
					break;
				case T__12:
					_localctx = new FontNameContext(_localctx);
					enterOuterAlt(_localctx, 2);
					{
						setState(99);
						match(T__12);
						setState(100);
						font();
					}
					break;
				case T__13:
					_localctx = new FontsizeContext(_localctx);
					enterOuterAlt(_localctx, 3);
					{
						setState(101);
						match(T__13);
						setState(102);
						match(NUMBER);
					}
					break;
				case T__14:
					_localctx = new ColorContext(_localctx);
					enterOuterAlt(_localctx, 4);
					{
						setState(103);
						match(T__14);
						setState(104);
						match(COLORENCODE);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_type;
		}

		public TypeContext() {
		}

		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class NumberContext extends TypeContext {
		public NumberContext(TypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterNumber(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitNumber(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitNumber(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class BooleanContext extends TypeContext {
		public BooleanContext(TypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterBoolean(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitBoolean(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitBoolean(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class StringContext extends TypeContext {
		public StringContext(TypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterString(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitString(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitString(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(110);
			switch (_input.LA(1)) {
				case T__15:
					_localctx = new BooleanContext(_localctx);
					enterOuterAlt(_localctx, 1);
					{
						setState(107);
						match(T__15);
					}
					break;
				case T__16:
					_localctx = new NumberContext(_localctx);
					enterOuterAlt(_localctx, 2);
					{
						setState(108);
						match(T__16);
					}
					break;
				case T__17:
					_localctx = new StringContext(_localctx);
					enterOuterAlt(_localctx, 3);
					{
						setState(109);
						match(T__17);
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

	public static class WidgetTypeContext extends ParserRuleContext {
		public WidgetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_widgetType;
		}

		public WidgetTypeContext() {
		}

		public void copyFrom(WidgetTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class CheckboxContext extends WidgetTypeContext {
		public CheckboxContext(WidgetTypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterCheckbox(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitCheckbox(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitCheckbox(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class SpinboxContext extends WidgetTypeContext {
		public SpinboxContext(WidgetTypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterSpinbox(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitSpinbox(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitSpinbox(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class RadioContext extends WidgetTypeContext {
		public RadioContext(WidgetTypeContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterRadio(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitRadio(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitRadio(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final WidgetTypeContext widgetType() throws RecognitionException {
		WidgetTypeContext _localctx = new WidgetTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_widgetType);
		try {
			setState(115);
			switch (_input.LA(1)) {
				case T__18:
					_localctx = new CheckboxContext(_localctx);
					enterOuterAlt(_localctx, 1);
					{
						setState(112);
						match(T__18);
					}
					break;
				case T__19:
					_localctx = new SpinboxContext(_localctx);
					enterOuterAlt(_localctx, 2);
					{
						setState(113);
						match(T__19);
					}
					break;
				case T__20:
					_localctx = new RadioContext(_localctx);
					enterOuterAlt(_localctx, 3);
					{
						setState(114);
						match(T__20);
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
		public FontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_font;
		}

		public FontContext() {
		}

		public void copyFrom(FontContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class DialogContext extends FontContext {
		public DialogContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterDialog(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitDialog(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitDialog(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class BazookaContext extends FontContext {
		public BazookaContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterBazooka(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitBazooka(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitBazooka(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class CourierContext extends FontContext {
		public CourierContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterCourier(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitCourier(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitCourier(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class BookAntiquaContext extends FontContext {
		public BookAntiquaContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterBookAntiqua(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitBookAntiqua(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitBookAntiqua(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class ArialContext extends FontContext {
		public ArialContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterArial(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitArial(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitArial(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public static class TimesNewRomanContext extends FontContext {
		public TimesNewRomanContext(FontContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).enterTimesNewRoman(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof QLSGrammarListener)
				((QLSGrammarListener) listener).exitTimesNewRoman(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof QLSGrammarVisitor)
				return ((QLSGrammarVisitor<? extends T>) visitor).visitTimesNewRoman(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FontContext font() throws RecognitionException {
		FontContext _localctx = new FontContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_font);
		try {
			setState(123);
			switch (_input.LA(1)) {
				case T__21:
					_localctx = new ArialContext(_localctx);
					enterOuterAlt(_localctx, 1);
					{
						setState(117);
						match(T__21);
					}
					break;
				case T__22:
					_localctx = new TimesNewRomanContext(_localctx);
					enterOuterAlt(_localctx, 2);
					{
						setState(118);
						match(T__22);
					}
					break;
				case T__23:
					_localctx = new BazookaContext(_localctx);
					enterOuterAlt(_localctx, 3);
					{
						setState(119);
						match(T__23);
					}
					break;
				case T__24:
					_localctx = new BookAntiquaContext(_localctx);
					enterOuterAlt(_localctx, 4);
					{
						setState(120);
						match(T__24);
					}
					break;
				case T__25:
					_localctx = new CourierContext(_localctx);
					enterOuterAlt(_localctx, 5);
					{
						setState(121);
						match(T__25);
					}
					break;
				case T__26:
					_localctx = new DialogContext(_localctx);
					enterOuterAlt(_localctx, 6);
					{
						setState(122);
						match(T__26);
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

	public static final String	_serializedATN	= "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u0080\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" + "\13\4\f\t\f\3\2\3\2\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\6\3$\n" + "\3\r\3\16\3%\3\3\5\3)\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5\64\n" + "\5\r\5\16\5\65\3\5\7\59\n\5\f\5\16\5<\13\5\3\5\5\5?\n\5\3\5\3\5\5\5C\n" + "\5\3\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7Q\n\7\3\b\3\b\3" + "\b\3\b\6\bW\n\b\r\b\16\bX\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bb\n\b\3\t\3\t" + "\3\t\3\t\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\5\nq\n\n\3\13\3\13\3\13" + "\5\13v\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f~\n\f\3\f\2\2\r\2\4\6\b\n\f\16" + "\20\22\24\26\2\2\u008b\2\30\3\2\2\2\4\37\3\2\2\2\6,\3\2\2\2\bB\3\2\2\2" + "\nD\3\2\2\2\fI\3\2\2\2\16a\3\2\2\2\20k\3\2\2\2\22p\3\2\2\2\24u\3\2\2\2" + "\26}\3\2\2\2\30\31\7\3\2\2\31\33\7!\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34" + "\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37 \7\4\2\2 !\7!" + "\2\2!#\7\5\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3" + "\2\2\2\')\5\16\b\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7\6\2\2+\5\3\2\2\2" + ",-\7\7\2\2-.\7$\2\2./\5\b\5\2/\7\3\2\2\2\60C\5\n\6\2\61\63\7\5\2\2\62" + "\64\5\n\6\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66" + ":\3\2\2\2\679\5\6\4\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2" + "\2\2<:\3\2\2\2=?\5\16\b\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\6\2\2AC\3" + "\2\2\2B\60\3\2\2\2B\61\3\2\2\2C\t\3\2\2\2DE\7\b\2\2EG\7!\2\2FH\5\f\7\2" + "GF\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IJ\7\t\2\2JP\5\24\13\2KL\7\n\2\2LM\7$" + "\2\2MN\7\13\2\2NO\7$\2\2OQ\7\f\2\2PK\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RS\7" + "\r\2\2ST\5\22\n\2TV\7\5\2\2UW\5\20\t\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2X" + "Y\3\2\2\2YZ\3\2\2\2Z[\5\f\7\2[\\\7\6\2\2\\b\3\2\2\2]^\7\r\2\2^_\5\22\n" + "\2_`\5\f\7\2`b\3\2\2\2aR\3\2\2\2a]\3\2\2\2b\17\3\2\2\2cd\7\16\2\2dl\7" + "#\2\2ef\7\17\2\2fl\5\26\f\2gh\7\20\2\2hl\7#\2\2ij\7\21\2\2jl\7\"\2\2k" + "c\3\2\2\2ke\3\2\2\2kg\3\2\2\2ki\3\2\2\2l\21\3\2\2\2mq\7\22\2\2nq\7\23" + "\2\2oq\7\24\2\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2q\23\3\2\2\2rv\7\25\2\2s" + "v\7\26\2\2tv\7\27\2\2ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\25\3\2\2\2w~\7\30" + "\2\2x~\7\31\2\2y~\7\32\2\2z~\7\33\2\2{~\7\34\2\2|~\7\35\2\2}w\3\2\2\2" + "}x\3\2\2\2}y\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\27\3\2\2\2\21\35%" + "(\65:>BGPXakpu}";
	public static final ATN		_ATN			= new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}