// Generated from Tax.g4 by ANTLR 4.5

package org.tax.taxgen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TaxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, STRING=3, PRIMITIVETYPE=4, FORMTAG=5, IFTAG=6, WS=7, COMMENT=8, 
		DECIMAL=9, INT=10, DIGIT=11, LOWERCASE=12, UPPERCASE=13, BOOLEANLITERAL=14, 
		ID=15, LPAR=16, RPAR=17, ASSIGN=18, GT=19, LT=20, BANG=21, TILDE=22, QUESTION=23, 
		EQUAL=24, LE=25, GE=26, NOTEQUAL=27, AND=28, OR=29, INC=30, DEC=31, ADD=32, 
		SUB=33, MUL=34, DIV=35, BITAND=36, BITOR=37, CARET=38, MOD=39, SINGLEQUOTE=40, 
		DOULEQUOTE=41, NEWLINE=42, COLON=43, LBRA=44, RBRA=45, SLASH=46;
	public static final int
		RULE_prog = 0, RULE_questionnaire = 1, RULE_questionlist = 2, RULE_bracketedquestionlist = 3, 
		RULE_ifquestionlist = 4, RULE_question = 5, RULE_questionStatement = 6, 
		RULE_type = 7, RULE_primitiveType = 8, RULE_enumeration = 9, RULE_enumItem = 10, 
		RULE_expression = 11, RULE_range = 12, RULE_date = 13, RULE_variable = 14;
	public static final String[] ruleNames = {
		"prog", "questionnaire", "questionlist", "bracketedquestionlist", "ifquestionlist", 
		"question", "questionStatement", "type", "primitiveType", "enumeration", 
		"enumItem", "expression", "range", "date", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'..'", null, null, "'form'", "'if'", null, null, null, null, 
		null, null, null, null, null, "'('", "')'", "'='", "'>'", "'<'", "'!'", 
		"'~'", "'?'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", 
		"'--'", "'+'", "'-'", "'*'", null, "'&'", "'|'", "'^'", "'%'", "'''", 
		"'\"'", null, "':'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "STRING", "PRIMITIVETYPE", "FORMTAG", "IFTAG", "WS", 
		"COMMENT", "DECIMAL", "INT", "DIGIT", "LOWERCASE", "UPPERCASE", "BOOLEANLITERAL", 
		"ID", "LPAR", "RPAR", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "SINGLEQUOTE", "DOULEQUOTE", 
		"NEWLINE", "COLON", "LBRA", "RBRA", "SLASH"
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TaxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<QuestionnaireContext> questionnaire() {
			return getRuleContexts(QuestionnaireContext.class);
		}
		public QuestionnaireContext questionnaire(int i) {
			return getRuleContext(QuestionnaireContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TaxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TaxParser.NEWLINE, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FORMTAG) {
				{
				{
				setState(30);
				questionnaire();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(31);
					match(NEWLINE);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class QuestionnaireContext extends ParserRuleContext {
		public TerminalNode FORMTAG() { return getToken(TaxParser.FORMTAG, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LBRA() { return getToken(TaxParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(TaxParser.RBRA, 0); }
		public List<QuestionlistContext> questionlist() {
			return getRuleContexts(QuestionlistContext.class);
		}
		public QuestionlistContext questionlist(int i) {
			return getRuleContext(QuestionlistContext.class,i);
		}
		public List<IfquestionlistContext> ifquestionlist() {
			return getRuleContexts(IfquestionlistContext.class);
		}
		public IfquestionlistContext ifquestionlist(int i) {
			return getRuleContext(IfquestionlistContext.class,i);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitQuestionnaire(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_questionnaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(FORMTAG);
			setState(43);
			variable();
			setState(44);
			match(LBRA);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IFTAG || _la==ID) {
				{
				setState(47);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(45);
					questionlist();
					}
					break;
				case IFTAG:
					{
					setState(46);
					ifquestionlist();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(RBRA);
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

	public static class QuestionlistContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterQuestionlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitQuestionlist(this);
		}
	}

	public final QuestionlistContext questionlist() throws RecognitionException {
		QuestionlistContext _localctx = new QuestionlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionlist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(54);
					question();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(57); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class BracketedquestionlistContext extends ParserRuleContext {
		public TerminalNode LBRA() { return getToken(TaxParser.LBRA, 0); }
		public QuestionlistContext questionlist() {
			return getRuleContext(QuestionlistContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(TaxParser.RBRA, 0); }
		public BracketedquestionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketedquestionlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterBracketedquestionlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitBracketedquestionlist(this);
		}
	}

	public final BracketedquestionlistContext bracketedquestionlist() throws RecognitionException {
		BracketedquestionlistContext _localctx = new BracketedquestionlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bracketedquestionlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LBRA);
			setState(60);
			questionlist();
			setState(61);
			match(RBRA);
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

	public static class IfquestionlistContext extends ParserRuleContext {
		public TerminalNode IFTAG() { return getToken(TaxParser.IFTAG, 0); }
		public TerminalNode LPAR() { return getToken(TaxParser.LPAR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TaxParser.RPAR, 0); }
		public BracketedquestionlistContext bracketedquestionlist() {
			return getRuleContext(BracketedquestionlistContext.class,0);
		}
		public IfquestionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifquestionlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterIfquestionlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitIfquestionlist(this);
		}
	}

	public final IfquestionlistContext ifquestionlist() throws RecognitionException {
		IfquestionlistContext _localctx = new IfquestionlistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifquestionlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(IFTAG);
			setState(64);
			match(LPAR);
			setState(65);
			variable();
			setState(66);
			match(RPAR);
			setState(67);
			bracketedquestionlist();
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QuestionStatementContext questionStatement() {
			return getRuleContext(QuestionStatementContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			variable();
			setState(70);
			match(COLON);
			setState(71);
			questionStatement();
			setState(72);
			type();
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

	public static class QuestionStatementContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TaxParser.STRING, 0); }
		public QuestionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterQuestionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitQuestionStatement(this);
		}
	}

	public final QuestionStatementContext questionStatement() throws RecognitionException {
		QuestionStatementContext _localctx = new QuestionStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
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

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(TaxParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TaxParser.RPAR, 0); }
		public EnumerationContext enumeration() {
			return getRuleContext(EnumerationContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			setState(85);
			switch (_input.LA(1)) {
			case PRIMITIVETYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				primitiveType();
				setState(81);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(77);
					match(LPAR);
					setState(78);
					expression();
					setState(79);
					match(RPAR);
					}
				}

				}
				break;
			case LBRA:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				enumeration();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				range();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode PRIMITIVETYPE() { return getToken(TaxParser.PRIMITIVETYPE, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PRIMITIVETYPE);
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

	public static class EnumerationContext extends ParserRuleContext {
		public TerminalNode LBRA() { return getToken(TaxParser.LBRA, 0); }
		public List<EnumItemContext> enumItem() {
			return getRuleContexts(EnumItemContext.class);
		}
		public EnumItemContext enumItem(int i) {
			return getRuleContext(EnumItemContext.class,i);
		}
		public TerminalNode RBRA() { return getToken(TaxParser.RBRA, 0); }
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitEnumeration(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumeration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(LBRA);
			setState(90);
			enumItem();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(91);
				match(T__0);
				setState(92);
				enumItem();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(RBRA);
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

	public static class EnumItemContext extends ParserRuleContext {
		public EnumItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterEnumItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitEnumItem(this);
		}
	}

	public final EnumItemContext enumItem() throws RecognitionException {
		EnumItemContext _localctx = new EnumItemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumItem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(100);
					matchWildcard();
					}
					} 
				}
				setState(105);
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
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(TaxParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TaxParser.RPAR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			int _alt;
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(106);
				match(LPAR);
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(107);
						matchWildcard();
						}
						} 
					}
					setState(112);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(113);
				match(RPAR);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(114);
						matchWildcard();
						}
						} 
					}
					setState(119);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class RangeContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(TaxParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(TaxParser.INT, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(INT);
			setState(123);
			match(T__1);
			setState(124);
			match(INT);
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

	public static class DateContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(TaxParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(TaxParser.DIGIT, i);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitDate(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(DIGIT);
			setState(127);
			match(DIGIT);
			setState(128);
			match(SUB);
			setState(129);
			match(DIGIT);
			setState(130);
			match(DIGIT);
			setState(131);
			match(SUB);
			setState(132);
			match(DIGIT);
			setState(133);
			match(DIGIT);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaxParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaxListener ) ((TaxListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u008c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\3\3\3\3\4\6\4:\n\4\r\4\16\4;\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tT"+
		"\n\t\3\t\3\t\5\tX\n\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13`\n\13\f\13\16\13"+
		"c\13\13\3\13\3\13\3\f\7\fh\n\f\f\f\16\fk\13\f\3\r\3\r\7\ro\n\r\f\r\16"+
		"\rr\13\r\3\r\3\r\7\rv\n\r\f\r\16\ry\13\r\5\r{\n\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5ipw\2\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u0089\2)\3\2\2\2\4,\3\2\2"+
		"\2\69\3\2\2\2\b=\3\2\2\2\nA\3\2\2\2\fG\3\2\2\2\16L\3\2\2\2\20W\3\2\2\2"+
		"\22Y\3\2\2\2\24[\3\2\2\2\26i\3\2\2\2\30z\3\2\2\2\32|\3\2\2\2\34\u0080"+
		"\3\2\2\2\36\u0089\3\2\2\2 $\5\4\3\2!#\7,\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3"+
		"\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\' \3\2\2\2(+\3\2\2\2)\'\3\2\2\2)"+
		"*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,-\7\7\2\2-.\5\36\20\2.\63\7.\2\2/\62\5"+
		"\6\4\2\60\62\5\n\6\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7/\2\2\67\5\3\2\2"+
		"\28:\5\f\7\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=>\7.\2"+
		"\2>?\5\6\4\2?@\7/\2\2@\t\3\2\2\2AB\7\b\2\2BC\7\22\2\2CD\5\36\20\2DE\7"+
		"\23\2\2EF\5\b\5\2F\13\3\2\2\2GH\5\36\20\2HI\7-\2\2IJ\5\16\b\2JK\5\20\t"+
		"\2K\r\3\2\2\2LM\7\5\2\2M\17\3\2\2\2NS\5\22\n\2OP\7\22\2\2PQ\5\30\r\2Q"+
		"R\7\23\2\2RT\3\2\2\2SO\3\2\2\2ST\3\2\2\2TX\3\2\2\2UX\5\24\13\2VX\5\32"+
		"\16\2WN\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\21\3\2\2\2YZ\7\6\2\2Z\23\3\2\2\2"+
		"[\\\7.\2\2\\a\5\26\f\2]^\7\3\2\2^`\5\26\f\2_]\3\2\2\2`c\3\2\2\2a_\3\2"+
		"\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7/\2\2e\25\3\2\2\2fh\13\2\2\2gf\3"+
		"\2\2\2hk\3\2\2\2ij\3\2\2\2ig\3\2\2\2j\27\3\2\2\2ki\3\2\2\2lp\7\22\2\2"+
		"mo\13\2\2\2nm\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2qs\3\2\2\2rp\3\2\2"+
		"\2s{\7\23\2\2tv\13\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2x{\3\2"+
		"\2\2yw\3\2\2\2zl\3\2\2\2zw\3\2\2\2{\31\3\2\2\2|}\7\f\2\2}~\7\4\2\2~\177"+
		"\7\f\2\2\177\33\3\2\2\2\u0080\u0081\7\r\2\2\u0081\u0082\7\r\2\2\u0082"+
		"\u0083\7#\2\2\u0083\u0084\7\r\2\2\u0084\u0085\7\r\2\2\u0085\u0086\7#\2"+
		"\2\u0086\u0087\7\r\2\2\u0087\u0088\7\r\2\2\u0088\35\3\2\2\2\u0089\u008a"+
		"\7\21\2\2\u008a\37\3\2\2\2\16$)\61\63;SWaipwz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}