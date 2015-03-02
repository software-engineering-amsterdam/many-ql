// Generated from E:\workspace2\proji\src\anotherOne\grammar\qlGrammar.g4 by ANTLR 4.0
package project.grammar;
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
		public BoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_box; }
	 
		public BoxContext() { }
		public void copyFrom(BoxContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalBoxContext extends BoxContext {
		public QuestionContext question;
		public List<QuestionContext> ifPart = new ArrayList<QuestionContext>();
		public List<QuestionContext> elsePart = new ArrayList<QuestionContext>();
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public ConditionalBoxContext(BoxContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitConditionalBox(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NormalBoxContext extends BoxContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public NormalBoxContext(BoxContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitNormalBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoxContext box() throws RecognitionException {
		BoxContext _localctx = new BoxContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_box);
		int _la;
		try {
			int _alt;
			setState(41);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NormalBoxContext(_localctx);
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
				break;
			case 4:
				_localctx = new ConditionalBoxContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22); match(4);
				setState(23); match(3);
				setState(24); expr(0);
				setState(25); match(2);
				setState(26); match(1);
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(27); ((ConditionalBoxContext)_localctx).question = question();
					((ConditionalBoxContext)_localctx).ifPart.add(((ConditionalBoxContext)_localctx).question);
					}
					}
					setState(30); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(32); match(6);
				setState(39);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(33); match(5);
					setState(35); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(34); ((ConditionalBoxContext)_localctx).question = question();
							((ConditionalBoxContext)_localctx).elsePart.add(((ConditionalBoxContext)_localctx).question);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(37); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
					}
				}

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

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new CompleteQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43); match(ID);
				setState(44); match(STRING);
				setState(45); type();
				}
				break;

			case 2:
				_localctx = new CompleteComputedQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46); match(ID);
				setState(47); match(STRING);
				setState(48); type();
				setState(49); match(3);
				setState(50); expr(0);
				setState(51); match(2);
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
			setState(58);
			switch (_input.LA(1)) {
			case BOOL_TYPE:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55); match(BOOL_TYPE);
				}
				break;
			case INT_TYPE:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(INT_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(57); match(STRING_TYPE);
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
	public static class BiggerContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public BiggerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBigger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OR() { return getToken(qlGrammarParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitOr(this);
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
	public static class BiggerEqContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public BiggerEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitBiggerEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public EqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitEqual(this);
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
	public static class UnequalContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public UnequalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitUnequal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SmallerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitSmaller(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public TerminalNode AND() { return getToken(qlGrammarParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAnd(this);
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
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(qlGrammarParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerEqContext extends ExprContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SmallerEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitSmallerEq(this);
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
			setState(68);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(61); match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62); match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63); match(3);
				setState(64); expr(0);
				setState(65); match(2);
				}
				break;
			case TRUE:
			case FALSE:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
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
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(71); match(MUL);
						setState(72); expr(17);
						}
						break;

					case 2:
						{
						_localctx = new DivideContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(74); match(DIV);
						setState(75); expr(16);
						}
						break;

					case 3:
						{
						_localctx = new AddContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(77); match(ADD);
						setState(78); expr(15);
						}
						break;

					case 4:
						{
						_localctx = new SubContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(80); match(SUB);
						setState(81); expr(14);
						}
						break;

					case 5:
						{
						_localctx = new BiggerContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(83); match(GT);
						setState(84); expr(13);
						}
						break;

					case 6:
						{
						_localctx = new BiggerEqContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(86); match(GEQ);
						setState(87); expr(12);
						}
						break;

					case 7:
						{
						_localctx = new SmallerContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(89); match(LT);
						setState(90); expr(11);
						}
						break;

					case 8:
						{
						_localctx = new SmallerEqContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(92); match(LEQ);
						setState(93); expr(10);
						}
						break;

					case 9:
						{
						_localctx = new EqualContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(95); match(EQ);
						setState(96); expr(9);
						}
						break;

					case 10:
						{
						_localctx = new UnequalContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(98); match(NEQ);
						setState(99); expr(8);
						}
						break;

					case 11:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(101); match(AND);
						setState(102); expr(7);
						}
						break;

					case 12:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(104); match(OR);
						setState(105); expr(6);
						}
						break;
					}
					} 
				}
				setState(110);
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
	public static class Or2Context extends Bool_exprContext {
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(qlGrammarParser.OR, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Or2Context(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitOr2(this);
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
	public static class And2Context extends Bool_exprContext {
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(qlGrammarParser.AND, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public And2Context(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof qlGrammarVisitor ) return ((qlGrammarVisitor<? extends T>)visitor).visitAnd2(this);
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
			setState(117);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(112); match(NOT);
				setState(113); bool_expr(4);
				}
				break;
			case ID:
				{
				_localctx = new BoolIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(ID);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116); match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(125);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new And2Context(new Bool_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(119);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(120); match(AND);
						setState(121); bool_expr(7);
						}
						break;

					case 2:
						{
						_localctx = new Or2Context(new Bool_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(122);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(123); match(OR);
						setState(124); bool_expr(6);
						}
						break;
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		case 0: return 16 >= _localctx._p;

		case 1: return 15 >= _localctx._p;

		case 2: return 14 >= _localctx._p;

		case 3: return 13 >= _localctx._p;

		case 4: return 12 >= _localctx._p;

		case 5: return 11 >= _localctx._p;

		case 6: return 10 >= _localctx._p;

		case 7: return 9 >= _localctx._p;

		case 8: return 8 >= _localctx._p;

		case 9: return 7 >= _localctx._p;

		case 10: return 6 >= _localctx._p;

		case 11: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean bool_expr_sempred(Bool_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12: return 6 >= _localctx._p;

		case 13: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3#\u0085\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20"+
		"\n\2\r\2\16\2\21\3\3\6\3\25\n\3\r\3\16\3\26\3\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3\37\n\3\r\3\16\3 \3\3\3\3\3\3\6\3&\n\3\r\3\16\3\'\5\3*\n\3\5\3,\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\48\n\4\3\5\3\5\3\5\5\5=\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6G\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7x\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0080\n"+
		"\7\f\7\16\7\u0083\13\7\3\7\2\b\2\4\6\b\n\f\2\3\3\34\35\u009b\2\17\3\2"+
		"\2\2\4+\3\2\2\2\6\67\3\2\2\2\b<\3\2\2\2\nF\3\2\2\2\fw\3\2\2\2\16\20\5"+
		"\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3"+
		"\2\2\2\23\25\5\6\4\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3"+
		"\2\2\2\27,\3\2\2\2\30\31\7\6\2\2\31\32\7\5\2\2\32\33\5\n\6\2\33\34\7\4"+
		"\2\2\34\36\7\3\2\2\35\37\5\6\4\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2"+
		" !\3\2\2\2!\"\3\2\2\2\")\7\b\2\2#%\7\7\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2"+
		"\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)#\3\2\2\2)*\3\2\2\2*,\3\2\2\2+\24"+
		"\3\2\2\2+\30\3\2\2\2,\5\3\2\2\2-.\7\36\2\2./\7 \2\2/8\5\b\5\2\60\61\7"+
		"\36\2\2\61\62\7 \2\2\62\63\5\b\5\2\63\64\7\5\2\2\64\65\5\n\6\2\65\66\7"+
		"\4\2\2\668\3\2\2\2\67-\3\2\2\2\67\60\3\2\2\28\7\3\2\2\29=\7\t\2\2:=\7"+
		"\13\2\2;=\7\n\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\t\3\2\2\2>?\b\6\1\2?"+
		"G\7\37\2\2@G\7\36\2\2AB\7\5\2\2BC\5\n\6\2CD\7\4\2\2DG\3\2\2\2EG\t\2\2"+
		"\2F>\3\2\2\2F@\3\2\2\2FA\3\2\2\2FE\3\2\2\2Gn\3\2\2\2HI\6\6\2\3IJ\7\21"+
		"\2\2Jm\5\n\6\2KL\6\6\3\3LM\7\22\2\2Mm\5\n\6\2NO\6\6\4\3OP\7\17\2\2Pm\5"+
		"\n\6\2QR\6\6\5\3RS\7\20\2\2Sm\5\n\6\2TU\6\6\6\3UV\7\25\2\2Vm\5\n\6\2W"+
		"X\6\6\7\3XY\7\27\2\2Ym\5\n\6\2Z[\6\6\b\3[\\\7\24\2\2\\m\5\n\6\2]^\6\6"+
		"\t\3^_\7\26\2\2_m\5\n\6\2`a\6\6\n\3ab\7\30\2\2bm\5\n\6\2cd\6\6\13\3de"+
		"\7\31\2\2em\5\n\6\2fg\6\6\f\3gh\7\32\2\2hm\5\n\6\2ij\6\6\r\3jk\7\33\2"+
		"\2km\5\n\6\2lH\3\2\2\2lK\3\2\2\2lN\3\2\2\2lQ\3\2\2\2lT\3\2\2\2lW\3\2\2"+
		"\2lZ\3\2\2\2l]\3\2\2\2l`\3\2\2\2lc\3\2\2\2lf\3\2\2\2li\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2o\13\3\2\2\2pn\3\2\2\2qr\b\7\1\2rs\7\23\2\2sx\5"+
		"\f\7\2tx\7\36\2\2ux\7\34\2\2vx\7\35\2\2wq\3\2\2\2wt\3\2\2\2wu\3\2\2\2"+
		"wv\3\2\2\2x\u0081\3\2\2\2yz\6\7\16\3z{\7\32\2\2{\u0080\5\f\7\2|}\6\7\17"+
		"\3}~\7\33\2\2~\u0080\5\f\7\2\177y\3\2\2\2\177|\3\2\2\2\u0080\u0083\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\r\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\20\21\26 \')+\67<Flnw\177\u0081";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}