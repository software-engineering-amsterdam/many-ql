// Generated from E:\workspace2\proji\src\anotherOne\grammar\qlGrammar.g4 by ANTLR 4.0
package anotherOne.grammar.saveit.trash.new17;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qlGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BOOL_TYPE=7, STRING_TYPE=8, 
		INT_TYPE=9, DATE_TYPE=10, DECIMAL_TYPE=11, MONEY_TYPE=12, ADD=13, SUB=14, 
		MUL=15, DIV=16, NOT=17, LT=18, GT=19, LEQ=20, GEQ=21, EQ=22, NEQ=23, AND=24, 
		OR=25, TRUE=26, FALSE=27, ID=28, INT=29, STRING=30, COMMENT=31, MULTYLINE_COMMENT=32, 
		WS=33;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "')'", "'('", "'if'", "'else'", "'}'", "'boolean'", 
		"'string'", "'integer'", "'date'", "'decimal'", "'money'", "'+'", "'-'", 
		"'*'", "'/'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
		"'||'", "'true'", "'false'", "ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT", 
		"WS"
	};
	public static final int
		RULE_form = 0, RULE_box = 1, RULE_question = 2, RULE_type = 3, RULE_expr = 4, 
		RULE_condition = 5;
	public static final String[] ruleNames = {
		"form", "box", "question", "type", "expr", "condition"
	};

	@Override
	public String getGrammarFileName() { return "qlGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public qlGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public BoxContext box(int i) {
			return getRuleContext(BoxContext.class,i);
		}
		public List<BoxContext> box() {
			return getRuleContexts(BoxContext.class);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitForm(this);
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); box();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 || _la==ID );
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

	public static class BoxContext extends ParserRuleContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public BoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_box; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoxContext box() throws RecognitionException {
		BoxContext _localctx = new BoxContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_box);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(17); question();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(20); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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
	public static class ConditionalQuestionContext extends QuestionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BoxContext box(int i) {
			return getRuleContext(BoxContext.class,i);
		}
		public List<BoxContext> box() {
			return getRuleContexts(BoxContext.class);
		}
		public ConditionalQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitConditionalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompleteComputedQuestionContext extends QuestionContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(qlGrammarParser.STRING, 0); }
		public CompleteComputedQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitCompleteComputedQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompleteQuestionContext extends QuestionContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(qlGrammarParser.STRING, 0); }
		public CompleteQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitCompleteQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			setState(41);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new CompleteQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22); match(ID);
				setState(23); match(STRING);
				setState(24); type();
				}
				break;

			case 2:
				_localctx = new CompleteComputedQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(ID);
				setState(26); match(STRING);
				setState(27); type();
				setState(28); match(3);
				setState(29); expr(0);
				setState(30); match(2);
				}
				break;

			case 3:
				_localctx = new ConditionalQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32); match(4);
				setState(33); condition(0);
				setState(34); match(1);
				setState(35); box();
				setState(36); match(6);
				setState(39);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(37); match(5);
					setState(38); box();
					}
				}

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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL_TYPE() { return getToken(qlGrammarParser.BOOL_TYPE, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT_TYPE() { return getToken(qlGrammarParser.INT_TYPE, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrTypeContext extends TypeContext {
		public TerminalNode STRING_TYPE() { return getToken(qlGrammarParser.STRING_TYPE, 0); }
		public StrTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitStrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case BOOL_TYPE:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43); match(BOOL_TYPE);
				}
				break;
			case INT_TYPE:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44); match(INT_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45); match(STRING_TYPE);
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

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(qlGrammarParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public TerminalNode SUB() { return getToken(qlGrammarParser.SUB, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode ADD() { return getToken(qlGrammarParser.ADD, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(qlGrammarParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(qlGrammarParser.TRUE, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public TerminalNode DIV() { return getToken(qlGrammarParser.DIV, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(qlGrammarParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(49); match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50); match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51); match(3);
				setState(52); expr(0);
				setState(53); match(2);
				}
				break;
			case TRUE:
			case FALSE:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(64);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(59);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(60); expr(7);
						}
						break;

					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(62);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(63); expr(6);
						}
						break;
					}
					} 
				}
				setState(68);
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

	public static class ConditionContext extends ParserRuleContext {
		public int _p;
		public ConditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConditionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class NotContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(qlGrammarParser.NOT, 0); }
		public NotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ConditionContext {
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode OR() { return getToken(qlGrammarParser.OR, 0); }
		public OrContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends ConditionContext {
		public TerminalNode GT() { return getToken(qlGrammarParser.GT, 0); }
		public TerminalNode LT() { return getToken(qlGrammarParser.LT, 0); }
		public TerminalNode NEQ() { return getToken(qlGrammarParser.NEQ, 0); }
		public TerminalNode GEQ() { return getToken(qlGrammarParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(qlGrammarParser.EQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LEQ() { return getToken(qlGrammarParser.LEQ, 0); }
		public CompareContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ConditionContext {
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode AND() { return getToken(qlGrammarParser.AND, 0); }
		public AndContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState, _p);
		ConditionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_condition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70); match(NOT);
				setState(71); condition(3);
				}
				break;
			case 3:
			case TRUE:
			case FALSE:
			case ID:
			case INT:
				{
				_localctx = new CompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72); expr(0);
				setState(73);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(74); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(84);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new ConditionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(78);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						{
						setState(79); match(AND);
						}
						setState(80); condition(3);
						}
						break;

					case 2:
						{
						_localctx = new OrContext(new ConditionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(81);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						{
						setState(82); match(OR);
						}
						setState(83); condition(2);
						}
						break;
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);

		case 5: return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 2 >= _localctx._p;

		case 3: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;

		case 1: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3#\\\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2"+
		"\r\2\16\2\21\3\3\6\3\25\n\3\r\3\16\3\26\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4*\n\4\5\4,\n\4\3\5\3\5\3\5\5"+
		"\5\61\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6C\n\6\f\6\16\6F\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\2\b\2\4\6\b\n\f\2\6\3"+
		"\34\35\3\21\22\3\17\20\3\24\31d\2\17\3\2\2\2\4\24\3\2\2\2\6+\3\2\2\2\b"+
		"\60\3\2\2\2\n:\3\2\2\2\fN\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3"+
		"\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\25\5\6\4\2\24\23\3"+
		"\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3\2\2\2\30\31\7"+
		"\36\2\2\31\32\7 \2\2\32,\5\b\5\2\33\34\7\36\2\2\34\35\7 \2\2\35\36\5\b"+
		"\5\2\36\37\7\5\2\2\37 \5\n\6\2 !\7\4\2\2!,\3\2\2\2\"#\7\6\2\2#$\5\f\7"+
		"\2$%\7\3\2\2%&\5\4\3\2&)\7\b\2\2\'(\7\7\2\2(*\5\4\3\2)\'\3\2\2\2)*\3\2"+
		"\2\2*,\3\2\2\2+\30\3\2\2\2+\33\3\2\2\2+\"\3\2\2\2,\7\3\2\2\2-\61\7\t\2"+
		"\2.\61\7\13\2\2/\61\7\n\2\2\60-\3\2\2\2\60.\3\2\2\2\60/\3\2\2\2\61\t\3"+
		"\2\2\2\62\63\b\6\1\2\63;\7\37\2\2\64;\7\36\2\2\65\66\7\5\2\2\66\67\5\n"+
		"\6\2\678\7\4\2\28;\3\2\2\29;\t\2\2\2:\62\3\2\2\2:\64\3\2\2\2:\65\3\2\2"+
		"\2:9\3\2\2\2;D\3\2\2\2<=\6\6\2\3=>\t\3\2\2>C\5\n\6\2?@\6\6\3\3@A\t\4\2"+
		"\2AC\5\n\6\2B<\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\13\3\2"+
		"\2\2FD\3\2\2\2GH\b\7\1\2HI\7\23\2\2IO\5\f\7\2JK\5\n\6\2KL\t\5\2\2LM\5"+
		"\n\6\2MO\3\2\2\2NG\3\2\2\2NJ\3\2\2\2OX\3\2\2\2PQ\6\7\4\3QR\7\32\2\2RW"+
		"\5\f\7\2ST\6\7\5\3TU\7\33\2\2UW\5\f\7\2VP\3\2\2\2VS\3\2\2\2WZ\3\2\2\2"+
		"XV\3\2\2\2XY\3\2\2\2Y\r\3\2\2\2ZX\3\2\2\2\r\21\26)+\60:BDNVX";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}