// Generated from E:\workspace2\proji\src\anotherOne\grammar\qlGrammar.g4 by ANTLR 4.0
package anotherOne.grammar;
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
		RULE_bool_expr = 5;
	public static final String[] ruleNames = {
		"form", "box", "question", "type", "expr", "bool_expr"
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
	public static class BolexpContext extends QuestionContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public BolexpContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBolexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			int _alt;
			setState(51);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
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
				_localctx = new BolexpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32); match(4);
				setState(33); match(3);
				setState(34); bool_expr(0);
				setState(35); match(2);
				setState(36); match(1);
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37); question();
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==4 || _la==ID );
				setState(42); match(6);
				setState(49);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(43); match(5);
					setState(45); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(44); question();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(47); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
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
			setState(56);
			switch (_input.LA(1)) {
			case BOOL_TYPE:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53); match(BOOL_TYPE);
				}
				break;
			case INT_TYPE:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54); match(INT_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55); match(STRING_TYPE);
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
	public static class AddContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode ADD() { return getToken(qlGrammarParser.ADD, 0); }
		public AddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAdd(this);
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
	public static class DivideContext extends ExprContext {
		public TerminalNode DIV() { return getToken(qlGrammarParser.DIV, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public DivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends ExprContext {
		public TerminalNode SUB() { return getToken(qlGrammarParser.SUB, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(qlGrammarParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public MultiplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitMultiply(this);
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
			setState(66);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(59); match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); match(3);
				setState(62); expr(0);
				setState(63); match(2);
				}
				break;
			case TRUE:
			case FALSE:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
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
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(69); match(MUL);
						setState(70); expr(9);
						}
						break;

					case 2:
						{
						_localctx = new DivideContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(72); match(DIV);
						setState(73); expr(8);
						}
						break;

					case 3:
						{
						_localctx = new AddContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(75); match(ADD);
						setState(76); expr(7);
						}
						break;

					case 4:
						{
						_localctx = new SubContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(78); match(SUB);
						setState(79); expr(6);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class Bool_exprContext extends ParserRuleContext {
		public int _p;
		public Bool_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Bool_exprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
	 
		public Bool_exprContext() { }
		public void copyFrom(Bool_exprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class NotContext extends Bool_exprContext {
		public TerminalNode NOT() { return getToken(qlGrammarParser.NOT, 0); }
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public NotContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerEqContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SmallerEqContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitSmallerEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BiggerContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public BiggerContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBigger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolIdContext extends Bool_exprContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public BoolIdContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBoolId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends Bool_exprContext {
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(qlGrammarParser.OR, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public OrContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BiggerEqContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public BiggerEqContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBiggerEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends Bool_exprContext {
		public TrueContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends Bool_exprContext {
		public FalseContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public EqualContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnequalContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public UnequalContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitUnequal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerContext extends Bool_exprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SmallerContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitSmaller(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends Bool_exprContext {
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(qlGrammarParser.AND, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public AndContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, _parentState, _p);
		Bool_exprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_bool_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86); match(NOT);
				setState(87); bool_expr(4);
				}
				break;

			case 2:
				{
				_localctx = new BiggerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); expr(0);
				setState(89); match(GT);
				setState(90); expr(0);
				}
				break;

			case 3:
				{
				_localctx = new BiggerEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); expr(0);
				setState(93); match(GEQ);
				setState(94); expr(0);
				}
				break;

			case 4:
				{
				_localctx = new SmallerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); expr(0);
				setState(97); match(LT);
				setState(98); expr(0);
				}
				break;

			case 5:
				{
				_localctx = new SmallerEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100); expr(0);
				setState(101); match(LEQ);
				setState(102); expr(0);
				}
				break;

			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); expr(0);
				setState(105); match(EQ);
				setState(106); expr(0);
				}
				break;

			case 7:
				{
				_localctx = new UnequalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108); expr(0);
				setState(109); match(NEQ);
				setState(110); expr(0);
				}
				break;

			case 8:
				{
				_localctx = new BoolIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112); match(ID);
				}
				break;

			case 9:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); match(TRUE);
				}
				break;

			case 10:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(123);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new Bool_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(117);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(118); match(AND);
						setState(119); bool_expr(7);
						}
						break;

					case 2:
						{
						_localctx = new OrContext(new Bool_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(120);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(121); match(OR);
						setState(122); bool_expr(6);
						}
						break;
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

		case 5: return bool_expr_sempred((Bool_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;

		case 2: return 6 >= _localctx._p;

		case 3: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean bool_expr_sempred(Bool_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 6 >= _localctx._p;

		case 5: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3#\u0083\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20"+
		"\n\2\r\2\16\2\21\3\3\6\3\25\n\3\r\3\16\3\26\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4)\n\4\r\4\16\4*\3\4\3\4\3\4"+
		"\6\4\60\n\4\r\4\16\4\61\5\4\64\n\4\5\4\66\n\4\3\5\3\5\3\5\5\5;\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6E\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6S\n\6\f\6\16\6V\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7v\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7~\n\7\f\7\16"+
		"\7\u0081\13\7\3\7\2\b\2\4\6\b\n\f\2\3\3\34\35\u0097\2\17\3\2\2\2\4\24"+
		"\3\2\2\2\6\65\3\2\2\2\b:\3\2\2\2\nD\3\2\2\2\fu\3\2\2\2\16\20\5\4\3\2\17"+
		"\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23"+
		"\25\5\6\4\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27"+
		"\5\3\2\2\2\30\31\7\36\2\2\31\32\7 \2\2\32\66\5\b\5\2\33\34\7\36\2\2\34"+
		"\35\7 \2\2\35\36\5\b\5\2\36\37\7\5\2\2\37 \5\n\6\2 !\7\4\2\2!\66\3\2\2"+
		"\2\"#\7\6\2\2#$\7\5\2\2$%\5\f\7\2%&\7\4\2\2&(\7\3\2\2\')\5\6\4\2(\'\3"+
		"\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,\63\7\b\2\2-/\7\7\2\2."+
		"\60\5\6\4\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3"+
		"\2\2\2\63-\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\30\3\2\2\2\65\33\3\2"+
		"\2\2\65\"\3\2\2\2\66\7\3\2\2\2\67;\7\t\2\28;\7\13\2\29;\7\n\2\2:\67\3"+
		"\2\2\2:8\3\2\2\2:9\3\2\2\2;\t\3\2\2\2<=\b\6\1\2=E\7\37\2\2>E\7\36\2\2"+
		"?@\7\5\2\2@A\5\n\6\2AB\7\4\2\2BE\3\2\2\2CE\t\2\2\2D<\3\2\2\2D>\3\2\2\2"+
		"D?\3\2\2\2DC\3\2\2\2ET\3\2\2\2FG\6\6\2\3GH\7\21\2\2HS\5\n\6\2IJ\6\6\3"+
		"\3JK\7\22\2\2KS\5\n\6\2LM\6\6\4\3MN\7\17\2\2NS\5\n\6\2OP\6\6\5\3PQ\7\20"+
		"\2\2QS\5\n\6\2RF\3\2\2\2RI\3\2\2\2RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2"+
		"\2\2TU\3\2\2\2U\13\3\2\2\2VT\3\2\2\2WX\b\7\1\2XY\7\23\2\2Yv\5\f\7\2Z["+
		"\5\n\6\2[\\\7\25\2\2\\]\5\n\6\2]v\3\2\2\2^_\5\n\6\2_`\7\27\2\2`a\5\n\6"+
		"\2av\3\2\2\2bc\5\n\6\2cd\7\24\2\2de\5\n\6\2ev\3\2\2\2fg\5\n\6\2gh\7\26"+
		"\2\2hi\5\n\6\2iv\3\2\2\2jk\5\n\6\2kl\7\30\2\2lm\5\n\6\2mv\3\2\2\2no\5"+
		"\n\6\2op\7\31\2\2pq\5\n\6\2qv\3\2\2\2rv\7\36\2\2sv\7\34\2\2tv\7\35\2\2"+
		"uW\3\2\2\2uZ\3\2\2\2u^\3\2\2\2ub\3\2\2\2uf\3\2\2\2uj\3\2\2\2un\3\2\2\2"+
		"ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\177\3\2\2\2wx\6\7\6\3xy\7\32\2\2y~\5\f"+
		"\7\2z{\6\7\7\3{|\7\33\2\2|~\5\f\7\2}w\3\2\2\2}z\3\2\2\2~\u0081\3\2\2\2"+
		"\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\r\3\2\2\2\u0081\177\3\2\2\2\17\21"+
		"\26*\61\63\65:DRTu}\177";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}