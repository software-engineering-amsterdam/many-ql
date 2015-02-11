// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/ql/syntax/QL.g4 by ANTLR 4.5
package lang.ql.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, QuestionType=20, Identifier=21, Boolean=22, Date=23, 
		Integer=24, Decimal=25, String=26, Comment=27, LineComment=28, WS=29;
	public static final int
		RULE_form = 0, RULE_statement = 1, RULE_question = 2, RULE_ifCondition = 3, 
		RULE_expressionList = 4, RULE_expression = 5;
	public static final String[] ruleNames = {
		"form", "statement", "question", "ifCondition", "expressionList", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'*'", 
		"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "QuestionType", "Identifier", 
		"Boolean", "Date", "Integer", "Decimal", "String", "Comment", "LineComment", 
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
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); 
			match(T__0);
			setState(13); 
			match(Identifier);
			setState(14); 
			match(T__1);
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15); 
				statement();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 || _la==QuestionType );
			setState(20); 
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
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case QuestionType:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); 
				question();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); 
				ifCondition();
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
		public TerminalNode QuestionType() { return getToken(QLParser.QuestionType, 0); }
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode String() { return getToken(QLParser.String, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			match(QuestionType);
			setState(27); 
			match(Identifier);
			setState(28); 
			match(String);
			setState(30);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << Identifier) | (1L << Boolean) | (1L << Date) | (1L << Integer) | (1L << Decimal) | (1L << String))) != 0)) {
				{
				setState(29); 
				expression(0);
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

	public static class IfConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			match(T__3);
			setState(33); 
			match(T__4);
			setState(34); 
			expression(0);
			setState(35); 
			match(T__5);
			setState(36); 
			match(T__1);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37); 
				statement();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 || _la==QuestionType );
			setState(42); 
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44); 
				expression(0);
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << Identifier) | (1L << Boolean) | (1L << Date) | (1L << Integer) | (1L << Decimal) | (1L << String))) != 0) );
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext operand;
		public ExpressionContext x;
		public Token primary;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Boolean() { return getToken(QLParser.Boolean, 0); }
		public TerminalNode Date() { return getToken(QLParser.Date, 0); }
		public TerminalNode Decimal() { return getToken(QLParser.Decimal, 0); }
		public TerminalNode String() { return getToken(QLParser.String, 0); }
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode Integer() { return getToken(QLParser.Integer, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
				{
				setState(50);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(51); 
				((ExpressionContext)_localctx).operand = expression(13);
				}
				break;
			case T__4:
				{
				setState(52); 
				match(T__4);
				setState(53); 
				((ExpressionContext)_localctx).x = expression(0);
				setState(54); 
				match(T__5);
				}
				break;
			case Boolean:
				{
				setState(56); 
				((ExpressionContext)_localctx).primary = match(Boolean);
				}
				break;
			case Date:
				{
				setState(57); 
				((ExpressionContext)_localctx).primary = match(Date);
				}
				break;
			case Decimal:
				{
				setState(58); 
				((ExpressionContext)_localctx).primary = match(Decimal);
				}
				break;
			case String:
				{
				setState(59); 
				((ExpressionContext)_localctx).primary = match(String);
				}
				break;
			case Identifier:
				{
				setState(60); 
				((ExpressionContext)_localctx).primary = match(Identifier);
				}
				break;
			case Integer:
				{
				setState(61); 
				((ExpressionContext)_localctx).primary = match(Integer);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(65);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(66); 
						((ExpressionContext)_localctx).right = expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(67);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(68);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(69); 
						((ExpressionContext)_localctx).right = expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(70);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(71);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(72); 
						((ExpressionContext)_localctx).right = expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(73);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(74);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(75); 
						((ExpressionContext)_localctx).right = expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(77); 
						((ExpressionContext)_localctx).operator = match(T__17);
						setState(78); 
						((ExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(80); 
						((ExpressionContext)_localctx).operator = match(T__18);
						setState(81); 
						((ExpressionContext)_localctx).right = expression(8);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5: 
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 12);
		case 1: 
			return precpred(_ctx, 11);
		case 2: 
			return precpred(_ctx, 10);
		case 3: 
			return precpred(_ctx, 9);
		case 4: 
			return precpred(_ctx, 8);
		case 5: 
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37Z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\2\3\2\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\6\5)\n\5\r\5\16\5*\3\5\3\5\3\6\6\6\60\n\6\r\6\16\6\61\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7A\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7U\n\7\f"+
		"\7\16\7X\13\7\3\7\2\3\f\b\2\4\6\b\n\f\2\6\3\2\t\n\3\2\13\r\3\2\16\21\3"+
		"\2\22\23e\2\16\3\2\2\2\4\32\3\2\2\2\6\34\3\2\2\2\b\"\3\2\2\2\n/\3\2\2"+
		"\2\f@\3\2\2\2\16\17\7\3\2\2\17\20\7\27\2\2\20\22\7\4\2\2\21\23\5\4\3\2"+
		"\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2"+
		"\26\27\7\5\2\2\27\3\3\2\2\2\30\33\5\6\4\2\31\33\5\b\5\2\32\30\3\2\2\2"+
		"\32\31\3\2\2\2\33\5\3\2\2\2\34\35\7\26\2\2\35\36\7\27\2\2\36 \7\34\2\2"+
		"\37!\5\f\7\2 \37\3\2\2\2 !\3\2\2\2!\7\3\2\2\2\"#\7\6\2\2#$\7\7\2\2$%\5"+
		"\f\7\2%&\7\b\2\2&(\7\4\2\2\')\5\4\3\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*"+
		"+\3\2\2\2+,\3\2\2\2,-\7\5\2\2-\t\3\2\2\2.\60\5\f\7\2/.\3\2\2\2\60\61\3"+
		"\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\13\3\2\2\2\63\64\b\7\1\2\64\65\t\2"+
		"\2\2\65A\5\f\7\17\66\67\7\7\2\2\678\5\f\7\289\7\b\2\29A\3\2\2\2:A\7\30"+
		"\2\2;A\7\31\2\2<A\7\33\2\2=A\7\34\2\2>A\7\27\2\2?A\7\32\2\2@\63\3\2\2"+
		"\2@\66\3\2\2\2@:\3\2\2\2@;\3\2\2\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2"+
		"\2\2AV\3\2\2\2BC\f\16\2\2CD\t\3\2\2DU\5\f\7\17EF\f\r\2\2FG\t\2\2\2GU\5"+
		"\f\7\16HI\f\f\2\2IJ\t\4\2\2JU\5\f\7\rKL\f\13\2\2LM\t\5\2\2MU\5\f\7\fN"+
		"O\f\n\2\2OP\7\24\2\2PU\5\f\7\13QR\f\t\2\2RS\7\25\2\2SU\5\f\7\nTB\3\2\2"+
		"\2TE\3\2\2\2TH\3\2\2\2TK\3\2\2\2TN\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2"+
		"\2VW\3\2\2\2W\r\3\2\2\2XV\3\2\2\2\n\24\32 *\61@TV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}