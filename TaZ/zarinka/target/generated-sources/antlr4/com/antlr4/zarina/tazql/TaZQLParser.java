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
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, NUMBER=13, TEXT=14, FILETEXT=15, ID=16, WS=17, 
		SPECIAL=18, NEWLINE=19;
	public static final String[] tokenNames = {
		"<INVALID>", "'double'", "'int'", "'boolean'", "'true'", "'('", "')'", 
		"'String'", "'<'", "'if'", "'false'", "'>'", "'FORM'", "NUMBER", "TEXT", 
		"FILETEXT", "ID", "WS", "SPECIAL", "NEWLINE"
	};
	public static final int
		RULE_parse = 0, RULE_form = 1, RULE_formSection = 2, RULE_formId = 3, 
		RULE_type = 4, RULE_choise = 5, RULE_question = 6, RULE_questionLabel = 7, 
		RULE_questionId = 8, RULE_answerId = 9;
	public static final String[] ruleNames = {
		"parse", "form", "formSection", "formId", "type", "choise", "question", 
		"questionLabel", "questionId", "answerId"
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
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public TerminalNode EOF() { return getToken(TaZQLParser.EOF, 0); }
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); form();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(25); match(EOF);
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

	public static class FormContext extends ParserRuleContext {
		public FormSectionContext formSection() {
			return getRuleContext(FormSectionContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); formSection();
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
		public FormIdContext formId() {
			return getRuleContext(FormIdContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_formSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(T__0);
			setState(30); formId();
			setState(31); match(T__4);
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32); question();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 || _la==ID );
			setState(37); match(T__1);
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

	public static class FormIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public FormIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterFormId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitFormId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitFormId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormIdContext formId() throws RecognitionException {
		FormIdContext _localctx = new FormIdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(ID);
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
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public ChoiseContext choise() {
			return getRuleContext(ChoiseContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); match(T__9);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); match(ID);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(43); match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(44); match(T__11);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45); match(T__5);
				}
				break;
			case T__8:
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(46); choise();
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

	public static class ChoiseContext extends ParserRuleContext {
		public ChoiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterChoise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitChoise(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitChoise(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiseContext choise() throws RecognitionException {
		ChoiseContext _localctx = new ChoiseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_choise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__2) ) {
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

	public static class QuestionContext extends ParserRuleContext {
		public QuestionIdContext questionId() {
			return getRuleContext(QuestionIdContext.class,0);
		}
		public ChoiseContext choise() {
			return getRuleContext(ChoiseContext.class,0);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
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
		enterRule(_localctx, 12, RULE_question);
		int _la;
		try {
			setState(66);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); questionLabel();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52); match(T__3);
				setState(53); match(T__7);
				setState(54); questionId();
				setState(55);
				matchWildcard();
				setState(56); choise();
				setState(57); match(T__6);
				setState(58); match(T__4);
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59); question();
					}
					}
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 || _la==ID );
				setState(64); match(T__1);
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

	public static class QuestionLabelContext extends ParserRuleContext {
		public QuestionIdContext questionId() {
			return getRuleContext(QuestionIdContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(TaZQLParser.NUMBER, 0); }
		public TerminalNode FILETEXT() { return getToken(TaZQLParser.FILETEXT, 0); }
		public QuestionLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterQuestionLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitQuestionLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitQuestionLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionLabelContext questionLabel() throws RecognitionException {
		QuestionLabelContext _localctx = new QuestionLabelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_questionLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); questionId();
			setState(69); match(NUMBER);
			setState(70); match(FILETEXT);
			setState(71); type();
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

	public static class QuestionIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public QuestionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterQuestionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitQuestionId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitQuestionId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionIdContext questionId() throws RecognitionException {
		QuestionIdContext _localctx = new QuestionIdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_questionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(ID);
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

	public static class AnswerIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TaZQLParser.ID, 0); }
		public AnswerIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).enterAnswerId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaZQLListener ) ((TaZQLListener)listener).exitAnswerId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TaZQLVisitor ) return ((TaZQLVisitor<? extends T>)visitor).visitAnswerId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerIdContext answerId() throws RecognitionException {
		AnswerIdContext _localctx = new AnswerIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_answerId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25P\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\6\4$\n\4\r\4"+
		"\16\4%\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\62\n\6\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b?\n\b\r\b\16\b@\3\b\3\b\5\bE\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24"+
		"\2\3\4\2\6\6\f\fN\2\27\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b)\3\2\2\2\n"+
		"\61\3\2\2\2\f\63\3\2\2\2\16D\3\2\2\2\20F\3\2\2\2\22K\3\2\2\2\24M\3\2\2"+
		"\2\26\30\5\4\3\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2"+
		"\2\32\33\3\2\2\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\5\6\4\2\36\5\3\2\2\2"+
		"\37 \7\16\2\2 !\5\b\5\2!#\7\n\2\2\"$\5\16\b\2#\"\3\2\2\2$%\3\2\2\2%#\3"+
		"\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\r\2\2(\7\3\2\2\2)*\7\22\2\2*\t\3\2\2"+
		"\2+\62\7\5\2\2,\62\7\22\2\2-\62\7\4\2\2.\62\7\3\2\2/\62\7\t\2\2\60\62"+
		"\5\f\7\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61"+
		"\60\3\2\2\2\62\13\3\2\2\2\63\64\t\2\2\2\64\r\3\2\2\2\65E\5\20\t\2\66\67"+
		"\7\13\2\2\678\7\7\2\289\5\22\n\29:\13\2\2\2:;\5\f\7\2;<\7\b\2\2<>\7\n"+
		"\2\2=?\5\16\b\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7"+
		"\r\2\2CE\3\2\2\2D\65\3\2\2\2D\66\3\2\2\2E\17\3\2\2\2FG\5\22\n\2GH\7\17"+
		"\2\2HI\7\21\2\2IJ\5\n\6\2J\21\3\2\2\2KL\7\22\2\2L\23\3\2\2\2MN\7\22\2"+
		"\2N\25\3\2\2\2\7\31%\61@D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}