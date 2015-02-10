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
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		NUMBER=25, TEXT=26, ID=27, WS=28, SPECIAL=29, NEWLINE=30, COMMENTS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'boolean'", "'integer'", "'!='", "'>='", "'||'", 
		"'{'", "'String'", "'<'", "'&&'", "'=='", "'} END'", "'}'", "'>'", "'if'", 
		"'FORM'", "'<='", "'double'", "'else'", "'('", "')'", "'*'", "'+'", "'-'", 
		"NUMBER", "TEXT", "ID", "WS", "SPECIAL", "NEWLINE", "COMMENTS"
	};
	public static final int
		RULE_parse = 0, RULE_formSection = 1, RULE_question = 2, RULE_expression = 3, 
		RULE_simpleQuestion = 4, RULE_computedQuestion = 5, RULE_type = 6;
	public static final String[] ruleNames = {
		"parse", "formSection", "question", "expression", "simpleQuestion", "computedQuestion", 
		"type"
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
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TaZQLParser.EOF, 0); }
		public FormSectionContext formSection() {
			return getRuleContext(FormSectionContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); formSection();
			setState(15); match(EOF);
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
			setState(17); match(T__8);
			setState(18); match(ID);
			setState(19); match(T__17);
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); question();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==ID );
			setState(25); match(T__12);
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
		public ComputedQuestionContext computedQuestion() {
			return getRuleContext(ComputedQuestionContext.class,0);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SimpleQuestionContext simpleQuestion() {
			return getRuleContext(SimpleQuestionContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); simpleQuestion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); computedQuestion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29); match(T__9);
				setState(30); match(T__4);
				setState(31); expression(0);
				setState(32); match(T__3);
				setState(33); match(T__17);
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(34); question();
					}
					}
					setState(37); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(39); match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41); match(T__9);
				setState(42); match(T__4);
				setState(43); expression(0);
				setState(44); match(T__3);
				setState(45); match(T__17);
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(46); question();
					}
					}
					setState(49); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(51); match(T__11);
				setState(52); match(T__5);
				setState(53); match(T__17);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54); question();
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 || _la==ID );
				setState(59); match(T__11);
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
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(TaZQLParser.NUMBER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitExpression(this);
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
			setState(72);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(64); match(ID);
				}
				break;
			case T__22:
			case T__21:
			case T__16:
			case T__6:
				{
				setState(65); type();
				}
				break;
			case TEXT:
				{
				setState(66); match(TEXT);
				}
				break;
			case NUMBER:
				{
				setState(67); match(NUMBER);
				}
				break;
			case T__4:
				{
				setState(68); match(T__4);
				setState(69); expression(0);
				setState(70); match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(74);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(75);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__2) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(76); expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(78);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__0) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(79); expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(81);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__13) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(82); expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(84); match(T__14);
						}
						setState(85); expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(87); match(T__18);
						}
						setState(88); expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(90);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__15) | (1L << T__10) | (1L << T__7))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(91); expression(3);
						}
						break;
					}
					} 
				}
				setState(96);
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

	public static class SimpleQuestionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SimpleQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleQuestion; }
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

	public final SimpleQuestionContext simpleQuestion() throws RecognitionException {
		SimpleQuestionContext _localctx = new SimpleQuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(ID);
			setState(98); match(TEXT);
			setState(99); type();
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

	public static class ComputedQuestionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(TaZQLParser.TEXT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComputedQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computedQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterComputedQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitComputedQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitComputedQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputedQuestionContext computedQuestion() throws RecognitionException {
		ComputedQuestionContext _localctx = new ComputedQuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_computedQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(ID);
			setState(102); match(TEXT);
			setState(103); type();
			setState(104); match(T__4);
			setState(105); expression(0);
			setState(106); match(T__3);
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
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__21) | (1L << T__16) | (1L << T__6))) != 0)) ) {
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
		case 3: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 5);
		case 3: return precpred(_ctx, 4);
		case 4: return precpred(_ctx, 3);
		case 5: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!q\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6"+
		"\3\30\n\3\r\3\16\3\31\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4&\n\4"+
		"\r\4\16\4\'\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\62\n\4\r\4\16\4\63\3\4"+
		"\3\4\3\4\3\4\6\4:\n\4\r\4\16\4;\3\4\3\4\5\4@\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5_\n\5\f\5\16\5b\13\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\2\3\b\t\2\4\6\b\n\f\16\2\7\4\2\3"+
		"\3\30\30\3\2\31\32\4\2\6\6\r\r\6\2\7\7\13\13\20\20\23\23\5\2\4\5\n\n\24"+
		"\24z\2\20\3\2\2\2\4\23\3\2\2\2\6?\3\2\2\2\bJ\3\2\2\2\nc\3\2\2\2\fg\3\2"+
		"\2\2\16n\3\2\2\2\20\21\5\4\3\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24\7\22\2"+
		"\2\24\25\7\35\2\2\25\27\7\t\2\2\26\30\5\6\4\2\27\26\3\2\2\2\30\31\3\2"+
		"\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\34\7\16\2\2\34\5\3\2"+
		"\2\2\35@\5\n\6\2\36@\5\f\7\2\37 \7\21\2\2 !\7\26\2\2!\"\5\b\5\2\"#\7\27"+
		"\2\2#%\7\t\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()"+
		"\3\2\2\2)*\7\17\2\2*@\3\2\2\2+,\7\21\2\2,-\7\26\2\2-.\5\b\5\2./\7\27\2"+
		"\2/\61\7\t\2\2\60\62\5\6\4\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\17\2\2\66\67\7\25\2\2\679\7\t\2\2"+
		"8:\5\6\4\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7\17\2"+
		"\2>@\3\2\2\2?\35\3\2\2\2?\36\3\2\2\2?\37\3\2\2\2?+\3\2\2\2@\7\3\2\2\2"+
		"AB\b\5\1\2BK\7\35\2\2CK\5\16\b\2DK\7\34\2\2EK\7\33\2\2FG\7\26\2\2GH\5"+
		"\b\5\2HI\7\27\2\2IK\3\2\2\2JA\3\2\2\2JC\3\2\2\2JD\3\2\2\2JE\3\2\2\2JF"+
		"\3\2\2\2K`\3\2\2\2LM\f\t\2\2MN\t\2\2\2N_\5\b\5\nOP\f\b\2\2PQ\t\3\2\2Q"+
		"_\5\b\5\tRS\f\7\2\2ST\t\4\2\2T_\5\b\5\bUV\f\6\2\2VW\7\f\2\2W_\5\b\5\7"+
		"XY\f\5\2\2YZ\7\b\2\2Z_\5\b\5\6[\\\f\4\2\2\\]\t\5\2\2]_\5\b\5\5^L\3\2\2"+
		"\2^O\3\2\2\2^R\3\2\2\2^U\3\2\2\2^X\3\2\2\2^[\3\2\2\2_b\3\2\2\2`^\3\2\2"+
		"\2`a\3\2\2\2a\t\3\2\2\2b`\3\2\2\2cd\7\35\2\2de\7\34\2\2ef\5\16\b\2f\13"+
		"\3\2\2\2gh\7\35\2\2hi\7\34\2\2ij\5\16\b\2jk\7\26\2\2kl\5\b\5\2lm\7\27"+
		"\2\2m\r\3\2\2\2no\t\6\2\2o\17\3\2\2\2\n\31\'\63;?J^`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}