// Generated from E:/development/Steven/src/main/antlr/grammers\QL.g4 by ANTLR 4.5
package parser.antlrGenerated;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, UPPERCASE=29, LOWERCASE=30, NUMBERS=31, 
		STRING=32, COMMENT_LINE=33, WS=34;
	public static final int
		RULE_form = 0, RULE_statement = 1, RULE_if_statement = 2, RULE_else_clause = 3, 
		RULE_expression = 4, RULE_bool = 5, RULE_operator = 6, RULE_identifier = 7, 
		RULE_question = 8, RULE_question_expression = 9, RULE_question_type = 10, 
		RULE_question_label = 11;
	public static final String[] ruleNames = {
		"form", "statement", "if_statement", "else_clause", "expression", "bool", 
		"operator", "identifier", "question", "question_expression", "question_type", 
		"question_label"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'!'", "'true'", 
		"'false'", "'*'", "'/'", "'+'", "'-'", "'>'", "'<'", "'<='", "'>='", "'=='", 
		"'!='", "'&&'", "'||'", "'STRING'", "'INTEGER'", "'BOOLEAN'", "'DATE'", 
		"'MONEY'", "'DECIMAL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "UPPERCASE", "LOWERCASE", "NUMBERS", "STRING", 
		"COMMENT_LINE", "WS"
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
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
			setState(24); 
			match(T__0);
			setState(25); 
			identifier();
			setState(26); 
			match(T__1);
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27); 
				statement();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0) );
			setState(32); 
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
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStatement(this);
		}
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
			setState(36);
			switch (_input.LA(1)) {
			case UPPERCASE:
			case LOWERCASE:
			case NUMBERS:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); 
				question();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); 
				if_statement();
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

	public static class If_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			match(T__3);
			setState(39); 
			match(T__4);
			setState(40); 
			expression(0);
			setState(41); 
			match(T__5);
			setState(42); 
			match(T__1);
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43); 
				statement();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0) );
			setState(48); 
			match(T__2);
			setState(50);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(49); 
				else_clause();
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

	public static class Else_clauseContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Else_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterElse_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitElse_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitElse_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_clauseContext else_clause() throws RecognitionException {
		Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			match(T__6);
			setState(53); 
			match(T__1);
			setState(54); 
			statement();
			setState(55); 
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token negation;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> NUMBERS() { return getTokens(QLParser.NUMBERS); }
		public TerminalNode NUMBERS(int i) {
			return getToken(QLParser.NUMBERS, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpression(this);
		}
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(58); 
				((ExpressionContext)_localctx).negation = match(T__7);
				setState(59); 
				expression(5);
				}
				break;
			case 2:
				{
				setState(60); 
				match(T__4);
				setState(61); 
				expression(0);
				setState(62); 
				match(T__5);
				}
				break;
			case 3:
				{
				setState(65); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(64); 
						match(NUMBERS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(67); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				setState(70); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(69); 
						identifier();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(72); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(75); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(74); 
						bool();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(77); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(81);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(82); 
					operator();
					setState(83); 
					expression(5);
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator);
		int _la;
		try {
			setState(98);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(96); 
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 6);
				{
				setState(97); 
				match(T__21);
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> UPPERCASE() { return getTokens(QLParser.UPPERCASE); }
		public TerminalNode UPPERCASE(int i) {
			return getToken(QLParser.UPPERCASE, i);
		}
		public List<TerminalNode> LOWERCASE() { return getTokens(QLParser.LOWERCASE); }
		public TerminalNode LOWERCASE(int i) {
			return getToken(QLParser.LOWERCASE, i);
		}
		public List<TerminalNode> NUMBERS() { return getTokens(QLParser.NUMBERS); }
		public TerminalNode NUMBERS(int i) {
			return getToken(QLParser.NUMBERS, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(100);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(103); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public Question_typeContext question_type() {
			return getRuleContext(Question_typeContext.class,0);
		}
		public Question_labelContext question_label() {
			return getRuleContext(Question_labelContext.class,0);
		}
		public Question_expressionContext question_expression() {
			return getRuleContext(Question_expressionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			identifier();
			setState(106); 
			question_type();
			setState(107); 
			question_label();
			setState(109);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(108); 
				question_expression();
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

	public static class Question_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Question_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_expressionContext question_expression() throws RecognitionException {
		Question_expressionContext _localctx = new Question_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_question_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); 
			match(T__4);
			setState(112); 
			expression(0);
			setState(113); 
			match(T__5);
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
		public Question_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_typeContext question_type() throws RecognitionException {
		Question_typeContext _localctx = new Question_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_question_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Question_labelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public Question_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion_label(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion_label(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_labelContext question_label() throws RecognitionException {
		Question_labelContext _localctx = new Question_labelContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_question_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: 
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$z\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\3\2\3\2\3\2\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\3\3\3\3\5\3"+
		"\'\n\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4/\n\4\r\4\16\4\60\3\4\3\4\5\4\65\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6D\n\6\r\6\16\6"+
		"E\3\6\6\6I\n\6\r\6\16\6J\3\6\6\6N\n\6\r\6\16\6O\5\6R\n\6\3\6\3\6\3\6\3"+
		"\6\7\6X\n\6\f\6\16\6[\13\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b\3"+
		"\t\6\th\n\t\r\t\16\ti\3\n\3\n\3\n\3\n\5\np\n\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\2\3\n\16\2\4\6\b\n\f\16\20\22\24\26\30\2\t\3\2\13\f\3"+
		"\2\r\16\3\2\17\20\3\2\21\24\3\2\25\26\3\2\37!\3\2\31\36\u0080\2\32\3\2"+
		"\2\2\4&\3\2\2\2\6(\3\2\2\2\b\66\3\2\2\2\nQ\3\2\2\2\f\\\3\2\2\2\16d\3\2"+
		"\2\2\20g\3\2\2\2\22k\3\2\2\2\24q\3\2\2\2\26u\3\2\2\2\30w\3\2\2\2\32\33"+
		"\7\3\2\2\33\34\5\20\t\2\34\36\7\4\2\2\35\37\5\4\3\2\36\35\3\2\2\2\37 "+
		"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\5\2\2#\3\3\2\2\2$\'\5\22"+
		"\n\2%\'\5\6\4\2&$\3\2\2\2&%\3\2\2\2\'\5\3\2\2\2()\7\6\2\2)*\7\7\2\2*+"+
		"\5\n\6\2+,\7\b\2\2,.\7\4\2\2-/\5\4\3\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2"+
		"\2\60\61\3\2\2\2\61\62\3\2\2\2\62\64\7\5\2\2\63\65\5\b\5\2\64\63\3\2\2"+
		"\2\64\65\3\2\2\2\65\7\3\2\2\2\66\67\7\t\2\2\678\7\4\2\289\5\4\3\29:\7"+
		"\5\2\2:\t\3\2\2\2;<\b\6\1\2<=\7\n\2\2=R\5\n\6\7>?\7\7\2\2?@\5\n\6\2@A"+
		"\7\b\2\2AR\3\2\2\2BD\7!\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FR"+
		"\3\2\2\2GI\5\20\t\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KR\3\2\2\2"+
		"LN\5\f\7\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2Q;\3\2\2\2"+
		"Q>\3\2\2\2QC\3\2\2\2QH\3\2\2\2QM\3\2\2\2RY\3\2\2\2ST\f\6\2\2TU\5\16\b"+
		"\2UV\5\n\6\7VX\3\2\2\2WS\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\13\3\2"+
		"\2\2[Y\3\2\2\2\\]\t\2\2\2]\r\3\2\2\2^e\t\3\2\2_e\t\4\2\2`e\t\5\2\2ae\t"+
		"\6\2\2be\7\27\2\2ce\7\30\2\2d^\3\2\2\2d_\3\2\2\2d`\3\2\2\2da\3\2\2\2d"+
		"b\3\2\2\2dc\3\2\2\2e\17\3\2\2\2fh\t\7\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2"+
		"\2ij\3\2\2\2j\21\3\2\2\2kl\5\20\t\2lm\5\26\f\2mo\5\30\r\2np\5\24\13\2"+
		"on\3\2\2\2op\3\2\2\2p\23\3\2\2\2qr\7\7\2\2rs\5\n\6\2st\7\b\2\2t\25\3\2"+
		"\2\2uv\t\b\2\2v\27\3\2\2\2wx\7\"\2\2x\31\3\2\2\2\16 &\60\64EJOQYdio";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}