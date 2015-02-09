// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/ql.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TYPE=8, LOGICAL_OPERAND=9, 
		AND=10, OR=11, NOT=12, LT=13, LE=14, ST=15, SE=16, EQ=17, NE=18, ARITHMETIC_OPERAND=19, 
		MUL=20, DIV=21, ADD=22, SUB=23, ASSIGN=24, ID=25, STRING=26, BOOLEAN=27, 
		INT=28, FLOAT=29, NEWLINE=30, COMMENT=31, WS=32, LINE_COMMENT=33;
	public static final int
		RULE_form = 0, RULE_stat = 1, RULE_if_statement = 2, RULE_question = 3, 
		RULE_expression = 4, RULE_logical_expression = 5, RULE_value = 6;
	public static final String[] ruleNames = {
		"form", "stat", "if_statement", "question", "expression", "logical_expression", 
		"value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "';'", null, null, 
		"'&&'", "'||'", "'!'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", null, 
		"'*'", "'/'", "'+'", "'-'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "TYPE", "LOGICAL_OPERAND", 
		"AND", "OR", "NOT", "LT", "LE", "ST", "SE", "EQ", "NE", "ARITHMETIC_OPERAND", 
		"MUL", "DIV", "ADD", "SUB", "ASSIGN", "ID", "STRING", "BOOLEAN", "INT", 
		"FLOAT", "NEWLINE", "COMMENT", "WS", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "ql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public qlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(qlParser.ID, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitForm(this);
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
			setState(14); 
			match(T__0);
			setState(15); 
			match(ID);
			setState(16); 
			match(T__1);
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17); 
				stat();
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << TYPE) | (1L << NEWLINE))) != 0) );
			setState(22); 
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

	public static class StatContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(qlParser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(27);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); 
				question();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); 
				if_statement();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(26); 
				match(NEWLINE);
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
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitIf_statement(this);
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
			setState(29); 
			match(T__3);
			setState(30); 
			match(T__4);
			setState(31); 
			logical_expression();
			setState(32); 
			match(T__5);
			setState(33); 
			match(T__1);
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34); 
				question();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TYPE );
			setState(39); 
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
		public TerminalNode TYPE() { return getToken(qlParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(qlParser.ID, 0); }
		public TerminalNode STRING() { return getToken(qlParser.STRING, 0); }
		public TerminalNode ASSIGN() { return getToken(qlParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); 
				match(TYPE);
				setState(42); 
				match(ID);
				setState(43); 
				match(T__4);
				setState(44); 
				match(STRING);
				setState(45); 
				match(T__5);
				setState(46); 
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); 
				match(TYPE);
				setState(48); 
				match(ID);
				setState(49); 
				match(T__4);
				setState(50); 
				match(STRING);
				setState(51); 
				match(T__5);
				setState(52); 
				match(ASSIGN);
				setState(53); 
				expression();
				setState(54); 
				match(T__6);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ARITHMETIC_OPERAND() { return getToken(qlParser.ARITHMETIC_OPERAND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); 
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); 
				value();
				setState(60); 
				match(ARITHMETIC_OPERAND);
				setState(61); 
				expression();
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

	public static class Logical_expressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode LOGICAL_OPERAND() { return getToken(qlParser.LOGICAL_OPERAND, 0); }
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public Logical_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterLogical_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitLogical_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitLogical_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_expressionContext logical_expression() throws RecognitionException {
		Logical_expressionContext _localctx = new Logical_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logical_expression);
		try {
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65); 
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66); 
				match(LOGICAL_OPERAND);
				setState(67); 
				logical_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68); 
				value();
				setState(69); 
				match(LOGICAL_OPERAND);
				setState(70); 
				logical_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(72); 
				match(T__4);
				setState(73); 
				logical_expression();
				setState(74); 
				match(T__5);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(qlParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(qlParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(qlParser.FLOAT, 0); }
		public TerminalNode ID() { return getToken(qlParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof qlListener ) ((qlListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlVisitor ) return ((qlVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#S\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\6\2\25\n\2\r"+
		"\2\16\2\26\3\2\3\2\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4"+
		"&\n\4\r\4\16\4\'\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5;\n\5\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2"+
		"\3\4\2\33\33\35\37T\2\20\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b:\3\2\2\2"+
		"\nA\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20\21\7\3\2\2\21\22\7\33\2\2\22\24"+
		"\7\4\2\2\23\25\5\4\3\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27"+
		"\3\2\2\2\27\30\3\2\2\2\30\31\7\5\2\2\31\3\3\2\2\2\32\36\5\b\5\2\33\36"+
		"\5\6\4\2\34\36\7 \2\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\5\3"+
		"\2\2\2\37 \7\6\2\2 !\7\7\2\2!\"\5\f\7\2\"#\7\b\2\2#%\7\4\2\2$&\5\b\5\2"+
		"%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\5\2\2*\7\3\2"+
		"\2\2+,\7\n\2\2,-\7\33\2\2-.\7\7\2\2./\7\34\2\2/\60\7\b\2\2\60;\7\t\2\2"+
		"\61\62\7\n\2\2\62\63\7\33\2\2\63\64\7\7\2\2\64\65\7\34\2\2\65\66\7\b\2"+
		"\2\66\67\7\32\2\2\678\5\n\6\289\7\t\2\29;\3\2\2\2:+\3\2\2\2:\61\3\2\2"+
		"\2;\t\3\2\2\2<B\5\16\b\2=>\5\16\b\2>?\7\25\2\2?@\5\n\6\2@B\3\2\2\2A<\3"+
		"\2\2\2A=\3\2\2\2B\13\3\2\2\2CO\5\16\b\2DE\7\13\2\2EO\5\f\7\2FG\5\16\b"+
		"\2GH\7\13\2\2HI\5\f\7\2IO\3\2\2\2JK\7\7\2\2KL\5\f\7\2LM\7\b\2\2MO\3\2"+
		"\2\2NC\3\2\2\2ND\3\2\2\2NF\3\2\2\2NJ\3\2\2\2O\r\3\2\2\2PQ\t\2\2\2Q\17"+
		"\3\2\2\2\b\26\35\':AN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}