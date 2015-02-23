// Generated from QLbk.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLbkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FORM=1, IF=2, ELSE=3, INT=4, STR=5, BOOL=6, DATE=7, DEC=8, CUR=9, SEMI=10, 
		LBRACE=11, RBRACE=12, LPAREN=13, RPAREN=14, AND=15, OR=16, EQUAL=17, NOTEQUAL=18, 
		ASSIGN=19, GT=20, LT=21, GE=22, LE=23, ADD=24, SUB=25, MUL=26, DIV=27, 
		BANG=28, IntegerLiteral=29, StringLiteral=30, BooleanLiteral=31, DateLiteral=32, 
		DecimalLiteral=33, CurrencyLiteral=34, Non_Zero_Digit=35, Digit=36, Cap_Start_Identifier=37, 
		Identifier=38, WHITE_SPACE=39;
	public static final String[] tokenNames = {
		"<INVALID>", "'Form'", "'if'", "'else'", "'Integer'", "'String'", "'Boolean'", 
		"'Date'", "'Decimal'", "'Currency'", "';'", "'{'", "'}'", "'('", "')'", 
		"'&&'", "'||'", "'=='", "'!='", "'='", "'>'", "'<'", "'>='", "'<='", "'+'", 
		"'-'", "'*'", "'/'", "'!'", "IntegerLiteral", "StringLiteral", "BooleanLiteral", 
		"DateLiteral", "DecimalLiteral", "CurrencyLiteral", "Non_Zero_Digit", 
		"Digit", "Cap_Start_Identifier", "Identifier", "WHITE_SPACE"
	};
	public static final int
		RULE_form = 0, RULE_block = 1, RULE_statement = 2, RULE_question = 3, 
		RULE_questionType = 4, RULE_builtinType = 5, RULE_userType = 6, RULE_questionName = 7, 
		RULE_questionLabel = 8, RULE_ifstatement = 9, RULE_expression = 10, RULE_literal = 11;
	public static final String[] ruleNames = {
		"form", "block", "statement", "question", "questionType", "builtinType", 
		"userType", "questionName", "questionLabel", "ifstatement", "expression", 
		"literal"
	};

	@Override
	public String getGrammarFileName() { return "QLbk.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLbkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLbkParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode FORM() { return getToken(QLbkParser.FORM, 0); }
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(FORM);
			setState(25); match(Identifier);
			setState(26); block();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode LBRACE() { return getToken(QLbkParser.LBRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(QLbkParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(LBRACE);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << INT) | (1L << STR) | (1L << BOOL) | (1L << DATE) | (1L << DEC) | (1L << CUR) | (1L << LBRACE) | (1L << Cap_Start_Identifier))) != 0)) {
				{
				{
				setState(29); statement();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35); match(RBRACE);
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
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(40);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); block();
				}
				break;
			case INT:
			case STR:
			case BOOL:
			case DATE:
			case DEC:
			case CUR:
			case Cap_Start_Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(38); question();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(39); ifstatement();
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
		public QuestionNameContext questionName() {
			return getRuleContext(QuestionNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(QLbkParser.SEMI, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public QuestionLabelContext questionLabel() {
			return getRuleContext(QuestionLabelContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); questionType();
			setState(43); questionName();
			setState(44); questionLabel();
			setState(45); match(SEMI);
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

	public static class QuestionTypeContext extends ParserRuleContext {
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitQuestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionType);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case INT:
			case STR:
			case BOOL:
			case DATE:
			case DEC:
			case CUR:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); builtinType();
				}
				break;
			case Cap_Start_Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); userType();
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

	public static class BuiltinTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(QLbkParser.BOOL, 0); }
		public TerminalNode DATE() { return getToken(QLbkParser.DATE, 0); }
		public TerminalNode CUR() { return getToken(QLbkParser.CUR, 0); }
		public TerminalNode INT() { return getToken(QLbkParser.INT, 0); }
		public TerminalNode STR() { return getToken(QLbkParser.STR, 0); }
		public TerminalNode DEC() { return getToken(QLbkParser.DEC, 0); }
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterBuiltinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitBuiltinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitBuiltinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STR) | (1L << BOOL) | (1L << DATE) | (1L << DEC) | (1L << CUR))) != 0)) ) {
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

	public static class UserTypeContext extends ParserRuleContext {
		public TerminalNode Cap_Start_Identifier() { return getToken(QLbkParser.Cap_Start_Identifier, 0); }
		public UserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterUserType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitUserType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserTypeContext userType() throws RecognitionException {
		UserTypeContext _localctx = new UserTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_userType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(Cap_Start_Identifier);
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

	public static class QuestionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLbkParser.Identifier, 0); }
		public QuestionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterQuestionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitQuestionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitQuestionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionNameContext questionName() throws RecognitionException {
		QuestionNameContext _localctx = new QuestionNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_questionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(Identifier);
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

	public static class QuestionLabelContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(QLbkParser.StringLiteral, 0); }
		public QuestionLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterQuestionLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitQuestionLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitQuestionLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionLabelContext questionLabel() throws RecognitionException {
		QuestionLabelContext _localctx = new QuestionLabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_questionLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(StringLiteral);
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

	public static class IfstatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IF() { return getToken(QLbkParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(QLbkParser.ELSE, 0); }
		public TerminalNode RPAREN() { return getToken(QLbkParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(QLbkParser.LPAREN, 0); }
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(IF);
			setState(60); match(LPAREN);
			setState(61); expression(0);
			setState(62); match(RPAREN);
			setState(63); statement();
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(64); match(ELSE);
				setState(65); statement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(QLbkParser.MUL, 0); }
		public TerminalNode AND() { return getToken(QLbkParser.AND, 0); }
		public TerminalNode BANG() { return getToken(QLbkParser.BANG, 0); }
		public TerminalNode OR() { return getToken(QLbkParser.OR, 0); }
		public TerminalNode Identifier() { return getToken(QLbkParser.Identifier, 0); }
		public TerminalNode LE() { return getToken(QLbkParser.LE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQUAL() { return getToken(QLbkParser.EQUAL, 0); }
		public TerminalNode ADD() { return getToken(QLbkParser.ADD, 0); }
		public TerminalNode GE() { return getToken(QLbkParser.GE, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(QLbkParser.DIV, 0); }
		public TerminalNode ASSIGN() { return getToken(QLbkParser.ASSIGN, 0); }
		public TerminalNode LT() { return getToken(QLbkParser.LT, 0); }
		public TerminalNode GT() { return getToken(QLbkParser.GT, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(QLbkParser.NOTEQUAL, 0); }
		public TerminalNode SUB() { return getToken(QLbkParser.SUB, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			switch (_input.LA(1)) {
			case BANG:
				{
				setState(69); match(BANG);
				setState(70); expression(1);
				}
				break;
			case Identifier:
				{
				setState(71); match(Identifier);
				}
				break;
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case DateLiteral:
			case DecimalLiteral:
			case CurrencyLiteral:
				{
				setState(72); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(75);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(76); match(AND);
						setState(77); expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(78);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(79); match(OR);
						setState(80); expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(82); match(EQUAL);
						setState(83); expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(85); match(NOTEQUAL);
						setState(86); expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(88); match(ASSIGN);
						setState(89); expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(91); match(GT);
						setState(92); expression(10);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(94); match(LT);
						setState(95); expression(9);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(97); match(GE);
						setState(98); expression(8);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(100); match(LE);
						setState(101); expression(7);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(103); match(ADD);
						setState(104); expression(6);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(106); match(SUB);
						setState(107); expression(5);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(109); match(MUL);
						setState(110); expression(4);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(112); match(DIV);
						setState(113); expression(3);
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(QLbkParser.IntegerLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(QLbkParser.DecimalLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(QLbkParser.StringLiteral, 0); }
		public TerminalNode DateLiteral() { return getToken(QLbkParser.DateLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(QLbkParser.BooleanLiteral, 0); }
		public TerminalNode CurrencyLiteral() { return getToken(QLbkParser.CurrencyLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLbkListener ) ((QLbkListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLbkVisitor ) return ((QLbkVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << DateLiteral) | (1L << DecimalLiteral) | (1L << CurrencyLiteral))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 14);
		case 1: return precpred(_ctx, 13);
		case 2: return precpred(_ctx, 12);
		case 3: return precpred(_ctx, 11);
		case 4: return precpred(_ctx, 10);
		case 5: return precpred(_ctx, 9);
		case 6: return precpred(_ctx, 8);
		case 7: return precpred(_ctx, 7);
		case 8: return precpred(_ctx, 6);
		case 9: return precpred(_ctx, 5);
		case 10: return precpred(_ctx, 4);
		case 11: return precpred(_ctx, 3);
		case 12: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)|\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6\64\n\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13E\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\5\fL\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fu\n\f\f\f\16\fx\13\f\3\r"+
		"\3\r\3\r\2\3\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4\3\2\6\13\3\2\37$"+
		"\u0083\2\32\3\2\2\2\4\36\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n\63\3\2\2\2\f"+
		"\65\3\2\2\2\16\67\3\2\2\2\209\3\2\2\2\22;\3\2\2\2\24=\3\2\2\2\26K\3\2"+
		"\2\2\30y\3\2\2\2\32\33\7\3\2\2\33\34\7(\2\2\34\35\5\4\3\2\35\3\3\2\2\2"+
		"\36\"\7\r\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2"+
		"#%\3\2\2\2$\"\3\2\2\2%&\7\16\2\2&\5\3\2\2\2\'+\5\4\3\2(+\5\b\5\2)+\5\24"+
		"\13\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\7\3\2\2\2,-\5\n\6\2-.\5\20\t\2."+
		"/\5\22\n\2/\60\7\f\2\2\60\t\3\2\2\2\61\64\5\f\7\2\62\64\5\16\b\2\63\61"+
		"\3\2\2\2\63\62\3\2\2\2\64\13\3\2\2\2\65\66\t\2\2\2\66\r\3\2\2\2\678\7"+
		"\'\2\28\17\3\2\2\29:\7(\2\2:\21\3\2\2\2;<\7 \2\2<\23\3\2\2\2=>\7\4\2\2"+
		">?\7\17\2\2?@\5\26\f\2@A\7\20\2\2AD\5\6\4\2BC\7\5\2\2CE\5\6\4\2DB\3\2"+
		"\2\2DE\3\2\2\2E\25\3\2\2\2FG\b\f\1\2GH\7\36\2\2HL\5\26\f\3IL\7(\2\2JL"+
		"\5\30\r\2KF\3\2\2\2KI\3\2\2\2KJ\3\2\2\2Lv\3\2\2\2MN\f\20\2\2NO\7\21\2"+
		"\2Ou\5\26\f\21PQ\f\17\2\2QR\7\22\2\2Ru\5\26\f\20ST\f\16\2\2TU\7\23\2\2"+
		"Uu\5\26\f\17VW\f\r\2\2WX\7\24\2\2Xu\5\26\f\16YZ\f\f\2\2Z[\7\25\2\2[u\5"+
		"\26\f\r\\]\f\13\2\2]^\7\26\2\2^u\5\26\f\f_`\f\n\2\2`a\7\27\2\2au\5\26"+
		"\f\13bc\f\t\2\2cd\7\30\2\2du\5\26\f\nef\f\b\2\2fg\7\31\2\2gu\5\26\f\t"+
		"hi\f\7\2\2ij\7\32\2\2ju\5\26\f\bkl\f\6\2\2lm\7\33\2\2mu\5\26\f\7no\f\5"+
		"\2\2op\7\34\2\2pu\5\26\f\6qr\f\4\2\2rs\7\35\2\2su\5\26\f\5tM\3\2\2\2t"+
		"P\3\2\2\2tS\3\2\2\2tV\3\2\2\2tY\3\2\2\2t\\\3\2\2\2t_\3\2\2\2tb\3\2\2\2"+
		"te\3\2\2\2th\3\2\2\2tk\3\2\2\2tn\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"vw\3\2\2\2w\27\3\2\2\2xv\3\2\2\2yz\t\3\2\2z\31\3\2\2\2\t\"*\63DKtv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}