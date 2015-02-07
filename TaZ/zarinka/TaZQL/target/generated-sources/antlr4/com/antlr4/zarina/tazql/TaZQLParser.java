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
		NUMBER=1, TEXT=2, FILETEXT=3, ID=4, WS=5, SPECIAL=6, NEWLINE=7;
	public static final String[] tokenNames = {
		"<INVALID>", "NUMBER", "TEXT", "FILETEXT", "ID", "WS", "SPECIAL", "NEWLINE"
	};
	public static final int
		RULE_parse = 0, RULE_questionLabel = 1;
	public static final String[] ruleNames = {
		"parse", "questionLabel"
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
		public QuestionLabelContext questionLabel(int i) {
			return getRuleContext(QuestionLabelContext.class,i);
		}
		public List<QuestionLabelContext> questionLabel() {
			return getRuleContexts(QuestionLabelContext.class);
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
			setState(5); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4); questionLabel();
				}
				}
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
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

	public static class QuestionLabelContext extends ParserRuleContext {
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
		enterRule(_localctx, 2, RULE_questionLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); match(NUMBER);
			setState(12); match(FILETEXT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\21\4\2\t\2\4\3"+
		"\t\3\3\2\6\2\b\n\2\r\2\16\2\t\3\2\3\2\3\3\3\3\3\3\3\3\2\2\4\2\4\2\2\17"+
		"\2\7\3\2\2\2\4\r\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\t\3\2\2\2\t\7\3\2\2"+
		"\2\t\n\3\2\2\2\n\13\3\2\2\2\13\f\7\2\2\3\f\3\3\2\2\2\r\16\7\3\2\2\16\17"+
		"\7\5\2\2\17\5\3\2\2\2\3\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}