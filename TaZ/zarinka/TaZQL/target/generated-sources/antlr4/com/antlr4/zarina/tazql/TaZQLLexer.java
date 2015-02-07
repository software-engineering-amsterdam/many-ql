// Generated from TaZQL.g4 by ANTLR 4.4
package com.antlr4.zarina.tazql;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TaZQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, TEXT=2, FILETEXT=3, ID=4, WS=5, SPECIAL=6, NEWLINE=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'"
	};
	public static final String[] ruleNames = {
		"NUMBER", "TEXT", "FILETEXT", "ID", "WS", "SPECIAL", "NEWLINE"
	};


	public TaZQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TaZQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tQ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\2\3\2\6\2\31\n\2\r\2\16\2\32\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\3"+
		"\3\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\63"+
		"\n\4\f\4\16\4\66\13\4\3\4\3\4\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\6\6\6"+
		"B\n\6\r\6\16\6C\3\6\3\6\3\7\6\7I\n\7\r\7\16\7J\3\b\5\bN\n\b\3\b\3\b\2"+
		"\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\7\4\2C\\c|\5\2C\\aac|\6\2\62;C"+
		"\\aac|\5\2\13\f\17\17\"\"\7\2##..\60\60<=AA_\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2"+
		"\2\2\5!\3\2\2\2\7-\3\2\2\2\t9\3\2\2\2\13A\3\2\2\2\rH\3\2\2\2\17M\3\2\2"+
		"\2\21\23\4\62;\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2"+
		"\2\25\36\3\2\2\2\26\30\7\60\2\2\27\31\4\62;\2\30\27\3\2\2\2\31\32\3\2"+
		"\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\26\3\2\2\2\35 \3\2\2"+
		"\2\36\34\3\2\2\2\36\37\3\2\2\2\37\4\3\2\2\2 \36\3\2\2\2!(\7$\2\2\"\'\t"+
		"\2\2\2#\'\5\3\2\2$\'\7a\2\2%\'\5\13\6\2&\"\3\2\2\2&#\3\2\2\2&$\3\2\2\2"+
		"&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7$\2\2"+
		",\6\3\2\2\2-\64\7]\2\2.\63\5\t\5\2/\63\5\r\7\2\60\63\5\3\2\2\61\63\5\13"+
		"\6\2\62.\3\2\2\2\62/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2"+
		"\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7_\2\28\b"+
		"\3\2\2\29=\t\3\2\2:<\t\4\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>"+
		"\n\3\2\2\2?=\3\2\2\2@B\t\5\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2"+
		"DE\3\2\2\2EF\b\6\2\2F\f\3\2\2\2GI\t\6\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2"+
		"\2JK\3\2\2\2K\16\3\2\2\2LN\7\17\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7"+
		"\f\2\2P\20\3\2\2\2\16\2\24\32\36&(\62\64=CJM\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}