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
		T__24=25, T__25=26, UPPERCASE=27, LOWERCASE=28, NUMBERS=29, STRING=30, 
		BOOLEANEXPRESSION=31, COMMENT_LINE=32, WS=33;
	public static final int
		RULE_form = 0, RULE_statement = 1, RULE_if_statement = 2, RULE_else_clause = 3, 
		RULE_expression = 4, RULE_operator = 5, RULE_identifier = 6, RULE_question = 7, 
		RULE_question_expression = 8, RULE_question_type = 9, RULE_question_label = 10;
	public static final String[] ruleNames = {
		"form", "statement", "if_statement", "else_clause", "expression", "operator", 
		"identifier", "question", "question_expression", "question_type", "question_label"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'!'", "'*'", 
		"'/'", "'+'", "'-'", "'>'", "'<'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
		"'||'", "'STRING'", "'INTEGER'", "'BOOLEAN'", "'DATE'", "'MONEY'", "'DECIMAL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "UPPERCASE", "LOWERCASE", "NUMBERS", "STRING", "BOOLEANEXPRESSION", 
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
			setState(22); 
			match(T__0);
			setState(23); 
			identifier();
			setState(24); 
			match(T__1);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25); 
				statement();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0) );
			setState(30); 
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
			setState(34);
			switch (_input.LA(1)) {
			case UPPERCASE:
			case LOWERCASE:
			case NUMBERS:
				enterOuterAlt(_localctx, 1);
				{
				setState(32); 
				question();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(33); 
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
			setState(36); 
			match(T__3);
			setState(37); 
			match(T__4);
			setState(38); 
			expression(0);
			setState(39); 
			match(T__5);
			setState(40); 
			match(T__1);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41); 
				statement();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << UPPERCASE) | (1L << LOWERCASE) | (1L << NUMBERS))) != 0) );
			setState(46); 
			match(T__2);
			setState(48);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(47); 
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
			setState(50); 
			match(T__6);
			setState(51); 
			match(T__1);
			setState(52); 
			statement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token negation;
		public ExpressionContext right;
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
		public List<TerminalNode> BOOLEANEXPRESSION() { return getTokens(QLParser.BOOLEANEXPRESSION); }
		public TerminalNode BOOLEANEXPRESSION(int i) {
			return getToken(QLParser.BOOLEANEXPRESSION, i);
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
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(56); 
				((ExpressionContext)_localctx).negation = match(T__7);
				setState(57); 
				expression(5);
				}
				break;
			case 2:
				{
				setState(58); 
				match(T__4);
				setState(59); 
				expression(0);
				setState(60); 
				match(T__5);
				}
				break;
			case 3:
				{
				setState(63); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(62); 
						match(NUMBERS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(65); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				setState(68); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(67); 
						identifier();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(70); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(73); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(72); 
						match(BOOLEANEXPRESSION);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(75); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(79);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(80); 
					operator();
					setState(81); 
					((ExpressionContext)_localctx).right = expression(5);
					}
					} 
				}
				setState(87);
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

	public static class OperatorContext extends ParserRuleContext {
		public Token multiplication;
		public Token division;
		public Token add;
		public Token min;
		public Token greatherThan;
		public Token lessThan;
		public Token lessOrEqual;
		public Token greaterOrEqual;
		public Token equal;
		public Token notEqual;
		public Token and;
		public Token or;
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
		enterRule(_localctx, 10, RULE_operator);
		try {
			setState(108);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(88); 
					((OperatorContext)_localctx).multiplication = match(T__8);
					}
					break;
				case T__9:
					{
					setState(89); 
					((OperatorContext)_localctx).division = match(T__9);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(92); 
					((OperatorContext)_localctx).add = match(T__10);
					}
					break;
				case T__11:
					{
					setState(93); 
					((OperatorContext)_localctx).min = match(T__11);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(96); 
					((OperatorContext)_localctx).greatherThan = match(T__12);
					}
					break;
				case T__13:
					{
					setState(97); 
					((OperatorContext)_localctx).lessThan = match(T__13);
					}
					break;
				case T__14:
					{
					setState(98); 
					((OperatorContext)_localctx).lessOrEqual = match(T__14);
					}
					break;
				case T__15:
					{
					setState(99); 
					((OperatorContext)_localctx).greaterOrEqual = match(T__15);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				switch (_input.LA(1)) {
				case T__16:
					{
					setState(102); 
					((OperatorContext)_localctx).equal = match(T__16);
					}
					break;
				case T__17:
					{
					setState(103); 
					((OperatorContext)_localctx).notEqual = match(T__17);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(106); 
				((OperatorContext)_localctx).and = match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 6);
				{
				setState(107); 
				((OperatorContext)_localctx).or = match(T__19);
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
		enterRule(_localctx, 12, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(110);
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
				setState(113); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 14, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); 
			identifier();
			setState(116); 
			question_type();
			setState(117); 
			question_label();
			setState(119);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(118); 
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
		enterRule(_localctx, 16, RULE_question_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			match(T__4);
			setState(122); 
			expression(0);
			setState(123); 
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
		public Token string;
		public Token integer;
		public Token booleanType;
		public Token date;
		public Token money;
		public Token decimal;
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
		enterRule(_localctx, 18, RULE_question_type);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); 
				((Question_typeContext)_localctx).string = match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); 
				((Question_typeContext)_localctx).integer = match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(127); 
				((Question_typeContext)_localctx).booleanType = match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(128); 
				((Question_typeContext)_localctx).date = match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(129); 
				((Question_typeContext)_localctx).money = match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(130); 
				((Question_typeContext)_localctx).decimal = match(T__25);
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
		enterRule(_localctx, 20, RULE_question_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\2\3\2\3\3\3\3\5\3"+
		"%\n\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4-\n\4\r\4\16\4.\3\4\3\4\5\4\63\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6B\n\6\r\6\16\6C"+
		"\3\6\6\6G\n\6\r\6\16\6H\3\6\6\6L\n\6\r\6\16\6M\5\6P\n\6\3\6\3\6\3\6\3"+
		"\6\7\6V\n\6\f\6\16\6Y\13\6\3\7\3\7\5\7]\n\7\3\7\3\7\5\7a\n\7\3\7\3\7\3"+
		"\7\3\7\5\7g\n\7\3\7\3\7\5\7k\n\7\3\7\3\7\5\7o\n\7\3\b\6\br\n\b\r\b\16"+
		"\bs\3\t\3\t\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0086\n\13\3\f\3\f\3\f\2\3\n\r\2\4\6\b\n\f\16\20\22\24\26\2"+
		"\3\3\2\35\37\u009c\2\30\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b\64\3\2\2\2\nO"+
		"\3\2\2\2\fn\3\2\2\2\16q\3\2\2\2\20u\3\2\2\2\22{\3\2\2\2\24\u0085\3\2\2"+
		"\2\26\u0087\3\2\2\2\30\31\7\3\2\2\31\32\5\16\b\2\32\34\7\4\2\2\33\35\5"+
		"\4\3\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37 \3\2"+
		"\2\2 !\7\5\2\2!\3\3\2\2\2\"%\5\20\t\2#%\5\6\4\2$\"\3\2\2\2$#\3\2\2\2%"+
		"\5\3\2\2\2&\'\7\6\2\2\'(\7\7\2\2()\5\n\6\2)*\7\b\2\2*,\7\4\2\2+-\5\4\3"+
		"\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\7\5\2\2\61"+
		"\63\5\b\5\2\62\61\3\2\2\2\62\63\3\2\2\2\63\7\3\2\2\2\64\65\7\t\2\2\65"+
		"\66\7\4\2\2\66\67\5\4\3\2\678\7\5\2\28\t\3\2\2\29:\b\6\1\2:;\7\n\2\2;"+
		"P\5\n\6\7<=\7\7\2\2=>\5\n\6\2>?\7\b\2\2?P\3\2\2\2@B\7\37\2\2A@\3\2\2\2"+
		"BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DP\3\2\2\2EG\5\16\b\2FE\3\2\2\2GH\3\2\2"+
		"\2HF\3\2\2\2HI\3\2\2\2IP\3\2\2\2JL\7!\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2"+
		"\2MN\3\2\2\2NP\3\2\2\2O9\3\2\2\2O<\3\2\2\2OA\3\2\2\2OF\3\2\2\2OK\3\2\2"+
		"\2PW\3\2\2\2QR\f\6\2\2RS\5\f\7\2ST\5\n\6\7TV\3\2\2\2UQ\3\2\2\2VY\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X\13\3\2\2\2YW\3\2\2\2Z]\7\13\2\2[]\7\f\2\2\\Z\3"+
		"\2\2\2\\[\3\2\2\2]o\3\2\2\2^a\7\r\2\2_a\7\16\2\2`^\3\2\2\2`_\3\2\2\2a"+
		"o\3\2\2\2bg\7\17\2\2cg\7\20\2\2dg\7\21\2\2eg\7\22\2\2fb\3\2\2\2fc\3\2"+
		"\2\2fd\3\2\2\2fe\3\2\2\2go\3\2\2\2hk\7\23\2\2ik\7\24\2\2jh\3\2\2\2ji\3"+
		"\2\2\2ko\3\2\2\2lo\7\25\2\2mo\7\26\2\2n\\\3\2\2\2n`\3\2\2\2nf\3\2\2\2"+
		"nj\3\2\2\2nl\3\2\2\2nm\3\2\2\2o\r\3\2\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2"+
		"\2sq\3\2\2\2st\3\2\2\2t\17\3\2\2\2uv\5\16\b\2vw\5\24\13\2wy\5\26\f\2x"+
		"z\5\22\n\2yx\3\2\2\2yz\3\2\2\2z\21\3\2\2\2{|\7\7\2\2|}\5\n\6\2}~\7\b\2"+
		"\2~\23\3\2\2\2\177\u0086\7\27\2\2\u0080\u0086\7\30\2\2\u0081\u0086\7\31"+
		"\2\2\u0082\u0086\7\32\2\2\u0083\u0086\7\33\2\2\u0084\u0086\7\34\2\2\u0085"+
		"\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0082\3\2\2"+
		"\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\25\3\2\2\2\u0087\u0088"+
		"\7 \2\2\u0088\27\3\2\2\2\23\36$.\62CHMOW\\`fjnsy\u0085";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}