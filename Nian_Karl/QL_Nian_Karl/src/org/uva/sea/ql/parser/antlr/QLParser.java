// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;

	import org.uva.sea.ql.model.expression.*;
	import org.uva.sea.ql.model.expression.commonexpression.*;
	import org.uva.sea.ql.model.expression.booleanexpression.*;
	import org.uva.sea.ql.model.expression.mathexpression.*;
	import org.uva.sea.ql.model.literal.*;
	import org.uva.sea.ql.model.value.*;

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, STR=2, CUR=3, BOOL=4, DEC=5, DATE=6, FORM=7, IF=8, THEN=9, ELSE=10, 
		ELIF=11, OR=12, AND=13, EQUAL=14, GREATER=15, EQUAL_GREATER=16, EQUAL_COND=17, 
		EQUAL_SMALLER=18, SMALLER=19, PLUS=20, MINUS=21, DEVIDE=22, MULTIPLY=23, 
		LEFT_BRACE=24, RIGHT_BRACE=25, LEFT_PARENTHESES=26, RIGHT_PARENTHESES=27, 
		COLON=28, SEMICOLON=29, IntegerLiteral=30, DecimalLiteral=31, DecimalNumeral=32, 
		BooleanLiteral=33, StringLiteral=34, DateLiteral=35, Day=36, Month=37, 
		Year=38, Non_Zero_Digit=39, Digit=40, WhiteSpace=41, MultiComment=42, 
		SingleComment=43, Identifier=44;
	public static final String[] tokenNames = {
		"<INVALID>", "'Int'", "'Str'", "'Cur'", "'Bool'", "'Dec'", "'Date'", "'form'", 
		"'if'", "'then'", "'else'", "'else if'", "'||'", "'&&'", "'='", "'>'", 
		"'>='", "'=='", "'<='", "'<'", "'+'", "'-'", "'/'", "'*'", "'{'", "'}'", 
		"'('", "')'", "':'", "';'", "IntegerLiteral", "DecimalLiteral", "DecimalNumeral", 
		"BooleanLiteral", "StringLiteral", "DateLiteral", "Day", "Month", "Year", 
		"Non_Zero_Digit", "Digit", "WhiteSpace", "MultiComment", "SingleComment", 
		"Identifier"
	};
	public static final int
		RULE_form = 0, RULE_block = 1, RULE_statement = 2, RULE_question = 3, 
		RULE_questionType = 4, RULE_questionName = 5, RULE_questionLabel = 6, 
		RULE_ifStatement = 7, RULE_elseIfStatement = 8, RULE_elseStatement = 9, 
		RULE_expr = 10, RULE_literal = 11;
	public static final String[] ruleNames = {
		"form", "block", "statement", "question", "questionType", "questionName", 
		"questionLabel", "ifStatement", "elseIfStatement", "elseStatement", "expr", 
		"literal"
	};

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode FORM() { return getToken(QLParser.FORM, 0); }
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
		public TerminalNode RIGHT_BRACE() { return getToken(QLParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(QLParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBlock(this);
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
			setState(28); match(LEFT_BRACE);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STR) | (1L << CUR) | (1L << BOOL) | (1L << DEC) | (1L << DATE) | (1L << IF) | (1L << LEFT_BRACE))) != 0)) {
				{
				{
				setState(29); statement();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35); match(RIGHT_BRACE);
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
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
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
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(40);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); block();
				}
				break;
			case INT:
			case STR:
			case CUR:
			case BOOL:
			case DEC:
			case DATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(38); question();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(39); ifStatement();
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
		public TerminalNode SEMICOLON() { return getToken(QLParser.SEMICOLON, 0); }
		public QuestionNameContext questionName() {
			return getRuleContext(QuestionNameContext.class,0);
		}
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
		enterRule(_localctx, 6, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); questionType();
			setState(43); questionName();
			setState(44); questionLabel();
			setState(45); match(SEMICOLON);
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
		public TerminalNode BOOL() { return getToken(QLParser.BOOL, 0); }
		public TerminalNode DATE() { return getToken(QLParser.DATE, 0); }
		public TerminalNode CUR() { return getToken(QLParser.CUR, 0); }
		public TerminalNode INT() { return getToken(QLParser.INT, 0); }
		public TerminalNode STR() { return getToken(QLParser.STR, 0); }
		public TerminalNode DEC() { return getToken(QLParser.DEC, 0); }
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STR) | (1L << CUR) | (1L << BOOL) | (1L << DEC) | (1L << DATE))) != 0)) ) {
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

	public static class QuestionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public QuestionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionNameContext questionName() throws RecognitionException {
		QuestionNameContext _localctx = new QuestionNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(Identifier);
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
		public TerminalNode StringLiteral() { return getToken(QLParser.StringLiteral, 0); }
		public QuestionLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestionLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionLabelContext questionLabel() throws RecognitionException {
		QuestionLabelContext _localctx = new QuestionLabelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(StringLiteral);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(QLParser.IF, 0); }
		public TerminalNode LEFT_PARENTHESES() { return getToken(QLParser.LEFT_PARENTHESES, 0); }
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESES() { return getToken(QLParser.RIGHT_PARENTHESES, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(IF);
			setState(54); match(LEFT_PARENTHESES);
			setState(55); expr(0);
			setState(56); match(RIGHT_PARENTHESES);
			setState(57); block();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(58); elseIfStatement();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(64); elseStatement();
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public TerminalNode ELIF() { return getToken(QLParser.ELIF, 0); }
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(ELIF);
			setState(68); block();
			setState(69); elseStatement();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(QLParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(ELSE);
			setState(72); block();
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode DEVIDE() { return getToken(QLParser.DEVIDE, 0); }
		public TerminalNode EQUAL_SMALLER() { return getToken(QLParser.EQUAL_SMALLER, 0); }
		public TerminalNode AND() { return getToken(QLParser.AND, 0); }
		public TerminalNode MINUS() { return getToken(QLParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(QLParser.OR, 0); }
		public TerminalNode MULTIPLY() { return getToken(QLParser.MULTIPLY, 0); }
		public TerminalNode EQUAL_GREATER() { return getToken(QLParser.EQUAL_GREATER, 0); }
		public TerminalNode EQUAL() { return getToken(QLParser.EQUAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EQUAL_COND() { return getToken(QLParser.EQUAL_COND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SMALLER() { return getToken(QLParser.SMALLER, 0); }
		public TerminalNode PLUS() { return getToken(QLParser.PLUS, 0); }
		public TerminalNode GREATER() { return getToken(QLParser.GREATER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(75); literal();
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(78); match(AND);
						setState(79); expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(81); match(OR);
						setState(82); expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(84); match(EQUAL_COND);
						setState(85); expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(87); match(GREATER);
						setState(88); expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(90); match(EQUAL_GREATER);
						setState(91); expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(93); match(EQUAL);
						setState(94); expr(8);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(96); match(EQUAL_SMALLER);
						setState(97); expr(7);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(99); match(SMALLER);
						setState(100); expr(6);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102); match(PLUS);
						setState(103); expr(5);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(105); match(MINUS);
						setState(106); expr(4);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(108); match(MULTIPLY);
						setState(109); expr(3);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(111); match(DEVIDE);
						setState(112); expr(2);
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public TerminalNode Identifier() { return getToken(QLParser.Identifier, 0); }
		public TerminalNode IntegerLiteral() { return getToken(QLParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(QLParser.StringLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(QLParser.DecimalLiteral, 0); }
		public TerminalNode DateLiteral() { return getToken(QLParser.DateLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(QLParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitLiteral(this);
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
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << DateLiteral) | (1L << Identifier))) != 0)) ) {
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
		case 10: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		case 5: return precpred(_ctx, 7);
		case 6: return precpred(_ctx, 6);
		case 7: return precpred(_ctx, 5);
		case 8: return precpred(_ctx, 4);
		case 9: return precpred(_ctx, 3);
		case 10: return precpred(_ctx, 2);
		case 11: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.{\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t>\n\t\f\t\16\tA\13\t\3\t\5\tD\n\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\ft\n\f\f\f\16\fw\13\f\3\r\3\r\3\r"+
		"\2\3\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4\3\2\3\b\5\2 !#%..\177\2\32"+
		"\3\2\2\2\4\36\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n\61\3\2\2\2\f\63\3\2\2\2"+
		"\16\65\3\2\2\2\20\67\3\2\2\2\22E\3\2\2\2\24I\3\2\2\2\26L\3\2\2\2\30x\3"+
		"\2\2\2\32\33\7\t\2\2\33\34\7.\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36\"\7\32"+
		"\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2"+
		"$\"\3\2\2\2%&\7\33\2\2&\5\3\2\2\2\'+\5\4\3\2(+\5\b\5\2)+\5\20\t\2*\'\3"+
		"\2\2\2*(\3\2\2\2*)\3\2\2\2+\7\3\2\2\2,-\5\n\6\2-.\5\f\7\2./\5\16\b\2/"+
		"\60\7\37\2\2\60\t\3\2\2\2\61\62\t\2\2\2\62\13\3\2\2\2\63\64\7.\2\2\64"+
		"\r\3\2\2\2\65\66\7$\2\2\66\17\3\2\2\2\678\7\n\2\289\7\34\2\29:\5\26\f"+
		"\2:;\7\35\2\2;?\5\4\3\2<>\5\22\n\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2"+
		"\2\2@C\3\2\2\2A?\3\2\2\2BD\5\24\13\2CB\3\2\2\2CD\3\2\2\2D\21\3\2\2\2E"+
		"F\7\r\2\2FG\5\4\3\2GH\5\24\13\2H\23\3\2\2\2IJ\7\f\2\2JK\5\4\3\2K\25\3"+
		"\2\2\2LM\b\f\1\2MN\5\30\r\2Nu\3\2\2\2OP\f\16\2\2PQ\7\17\2\2Qt\5\26\f\17"+
		"RS\f\r\2\2ST\7\16\2\2Tt\5\26\f\16UV\f\f\2\2VW\7\23\2\2Wt\5\26\f\rXY\f"+
		"\13\2\2YZ\7\21\2\2Zt\5\26\f\f[\\\f\n\2\2\\]\7\22\2\2]t\5\26\f\13^_\f\t"+
		"\2\2_`\7\20\2\2`t\5\26\f\nab\f\b\2\2bc\7\24\2\2ct\5\26\f\tde\f\7\2\2e"+
		"f\7\25\2\2ft\5\26\f\bgh\f\6\2\2hi\7\26\2\2it\5\26\f\7jk\f\5\2\2kl\7\27"+
		"\2\2lt\5\26\f\6mn\f\4\2\2no\7\31\2\2ot\5\26\f\5pq\f\3\2\2qr\7\30\2\2r"+
		"t\5\26\f\4sO\3\2\2\2sR\3\2\2\2sU\3\2\2\2sX\3\2\2\2s[\3\2\2\2s^\3\2\2\2"+
		"sa\3\2\2\2sd\3\2\2\2sg\3\2\2\2sj\3\2\2\2sm\3\2\2\2sp\3\2\2\2tw\3\2\2\2"+
		"us\3\2\2\2uv\3\2\2\2v\27\3\2\2\2wu\3\2\2\2xy\t\3\2\2y\31\3\2\2\2\b\"*"+
		"?Csu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}