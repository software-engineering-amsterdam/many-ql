// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TaZQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, TYPE=22, BOOLEAN=23, NUMBER=24, 
		TEXT=25, ID=26, WS=27, NEWLINE=28, COMMENTS=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'||'", "'>='", "'{'", "'&&'", "'=='", "'<'", 
		"'} END'", "'}'", "'>'", "'if'", "'FORM'", "'<='", "'!'", "'else'", "'('", 
		"')'", "'*'", "'+'", "'-'", "TYPE", "BOOLEAN", "NUMBER", "TEXT", "ID", 
		"WS", "NEWLINE", "COMMENTS"
	};
	public static final int
		RULE_questionnaire = 0, RULE_formSection = 1, RULE_question = 2, RULE_expression = 3;
	public static final String[] ruleNames = {
		"questionnaire", "formSection", "question", "expression"
	};

	@Override
	public String getGrammarFileName() { return "TaZQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TaZQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QuestionnaireContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TaZQLParser.EOF, 0); }
		public FormSectionContext formSection() {
			return getRuleContext(FormSectionContext.class,0);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); formSection();
			setState(9); match(EOF);
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

	public static class FormSectionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public FormSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterFormSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitFormSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitFormSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormSectionContext formSection() throws RecognitionException {
		FormSectionContext _localctx = new FormSectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); match(T__8);
			setState(12); match(ID);
			setState(13); match(T__16);
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); question();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==ID );
			setState(19); match(T__12);
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
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	 
		public QuestionContext() { }
		public void copyFrom(QuestionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleQuestionContext extends QuestionContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public TerminalNode TYPE() { return getToken(TaZQLParser.TYPE, 0); }
		public SimpleQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterSimpleQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitSimpleQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitSimpleQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CalcQuestionContext extends QuestionContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public TerminalNode TYPE() { return getToken(TaZQLParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CalcQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterCalcQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitCalcQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitCalcQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseStatementContext extends QuestionContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfelseStatementContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterIfelseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitIfelseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitIfelseStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends QuestionContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfStatementContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SimpleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21); match(ID);
				setState(22); match(TEXT);
				setState(23); match(TYPE);
				}
				break;
			case 2:
				_localctx = new CalcQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24); match(ID);
				setState(25); match(TEXT);
				setState(26); match(TYPE);
				setState(27); match(T__4);
				setState(28); expression(0);
				setState(29); match(T__3);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31); match(T__9);
				setState(32); match(T__4);
				setState(33); expression(0);
				setState(34); match(T__3);
				setState(35); match(T__16);
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36); question();
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(41); match(T__11);
				}
				break;
			case 4:
				_localctx = new IfelseStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(43); match(T__9);
				setState(44); match(T__4);
				setState(45); expression(0);
				setState(46); match(T__3);
				setState(47); match(T__16);
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(48); question();
					}
					}
					setState(51); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(53); match(T__11);
				setState(54); match(T__5);
				setState(55); match(T__16);
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(56); question();
					}
					}
					setState(59); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(61); match(T__11);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(TaZQLParser.NUMBER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(TaZQLParser.BOOLEAN, 0); }
		public BooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqNotContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public EqNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterEqNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitEqNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitEqNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquationContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public EquationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public IdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextContext extends ExpressionContext {
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public TextContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrioContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrioContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterPrio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitPrio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitPrio(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			switch (_input.LA(1)) {
			case T__6:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66); match(T__6);
				setState(67); expression(12);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68); match(BOOLEAN);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); match(ID);
				}
				break;
			case TEXT:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70); match(TEXT);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71); match(NUMBER);
				}
				break;
			case T__4:
				{
				_localctx = new PrioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72); match(T__4);
				setState(73); expression(0);
				setState(74); match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(78);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(79);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__2) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(80); expression(12);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(82);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__0) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(83); expression(11);
						}
						break;
					case 3:
						{
						_localctx = new EquationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(85);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__13) | (1L << T__10) | (1L << T__7))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(86); expression(10);
						}
						break;
					case 4:
						{
						_localctx = new EqNotContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(88);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__14) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(89); expression(9);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(91); match(T__15);
						}
						setState(92); expression(8);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(94); match(T__18);
						}
						setState(95); expression(7);
						}
						break;
					}
					} 
				}
				setState(100);
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
		case 3: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\22\n\3\r\3\16\3\23"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4(\n\4\r\4\16\4)\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\64\n\4\r\4\16"+
		"\4\65\3\4\3\4\3\4\3\4\6\4<\n\4\r\4\16\4=\3\4\3\4\5\4B\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5c\n\5\f\5\16\5f\13\5\3"+
		"\5\2\3\b\6\2\4\6\b\2\6\4\2\3\3\25\25\3\2\26\27\6\2\6\6\n\n\r\r\20\20\4"+
		"\2\4\4\t\tu\2\n\3\2\2\2\4\r\3\2\2\2\6A\3\2\2\2\bN\3\2\2\2\n\13\5\4\3\2"+
		"\13\f\7\2\2\3\f\3\3\2\2\2\r\16\7\17\2\2\16\17\7\34\2\2\17\21\7\7\2\2\20"+
		"\22\5\6\4\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24"+
		"\25\3\2\2\2\25\26\7\13\2\2\26\5\3\2\2\2\27\30\7\34\2\2\30\31\7\33\2\2"+
		"\31B\7\30\2\2\32\33\7\34\2\2\33\34\7\33\2\2\34\35\7\30\2\2\35\36\7\23"+
		"\2\2\36\37\5\b\5\2\37 \7\24\2\2 B\3\2\2\2!\"\7\16\2\2\"#\7\23\2\2#$\5"+
		"\b\5\2$%\7\24\2\2%\'\7\7\2\2&(\5\6\4\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2"+
		")*\3\2\2\2*+\3\2\2\2+,\7\f\2\2,B\3\2\2\2-.\7\16\2\2./\7\23\2\2/\60\5\b"+
		"\5\2\60\61\7\24\2\2\61\63\7\7\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64\65\3"+
		"\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\f\2\289\7\22\2"+
		"\29;\7\7\2\2:<\5\6\4\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2"+
		"\2?@\7\f\2\2@B\3\2\2\2A\27\3\2\2\2A\32\3\2\2\2A!\3\2\2\2A-\3\2\2\2B\7"+
		"\3\2\2\2CD\b\5\1\2DE\7\21\2\2EO\5\b\5\16FO\7\31\2\2GO\7\34\2\2HO\7\33"+
		"\2\2IO\7\32\2\2JK\7\23\2\2KL\5\b\5\2LM\7\24\2\2MO\3\2\2\2NC\3\2\2\2NF"+
		"\3\2\2\2NG\3\2\2\2NH\3\2\2\2NI\3\2\2\2NJ\3\2\2\2Od\3\2\2\2PQ\f\r\2\2Q"+
		"R\t\2\2\2Rc\5\b\5\16ST\f\f\2\2TU\t\3\2\2Uc\5\b\5\rVW\f\13\2\2WX\t\4\2"+
		"\2Xc\5\b\5\fYZ\f\n\2\2Z[\t\5\2\2[c\5\b\5\13\\]\f\t\2\2]^\7\b\2\2^c\5\b"+
		"\5\n_`\f\b\2\2`a\7\5\2\2ac\5\b\5\tbP\3\2\2\2bS\3\2\2\2bV\3\2\2\2bY\3\2"+
		"\2\2b\\\3\2\2\2b_\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\t\3\2\2\2fd\3"+
		"\2\2\2\n\23)\65=ANbd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}