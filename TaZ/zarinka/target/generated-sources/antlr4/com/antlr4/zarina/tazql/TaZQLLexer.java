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
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, NUMBER=13, TEXT=14, FILETEXT=15, ID=16, WS=17, 
		SPECIAL=18, NEWLINE=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "NUMBER", "TEXT", "FILETEXT", "ID", "WS", "SPECIAL", 
		"NEWLINE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\6\16`\n\16\r\16\16\16a\3\16\3\16"+
		"\6\16f\n\16\r\16\16\16g\7\16j\n\16\f\16\16\16m\13\16\3\17\3\17\3\17\3"+
		"\17\3\17\7\17t\n\17\f\17\16\17w\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u0080\n\20\f\20\16\20\u0083\13\20\3\20\3\20\3\21\3\21\7\21\u0089"+
		"\n\21\f\21\16\21\u008c\13\21\3\22\6\22\u008f\n\22\r\22\16\22\u0090\3\22"+
		"\3\22\3\23\6\23\u0096\n\23\r\23\16\23\u0097\3\24\5\24\u009b\n\24\3\24"+
		"\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\4\2C\\c|\5\2C\\aac|\6\2\62;"+
		"C\\aac|\5\2\13\f\17\17\"\"\7\2##..\60\60<=AA\u00ac\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\3)\3\2\2\2\5\60\3\2\2\2\7\64\3\2\2\2\t<\3\2\2\2\13A\3\2\2\2\rC"+
		"\3\2\2\2\17E\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25Q\3\2\2\2\27W\3\2\2\2\31"+
		"Y\3\2\2\2\33_\3\2\2\2\35n\3\2\2\2\37z\3\2\2\2!\u0086\3\2\2\2#\u008e\3"+
		"\2\2\2%\u0095\3\2\2\2\'\u009a\3\2\2\2)*\7f\2\2*+\7q\2\2+,\7w\2\2,-\7d"+
		"\2\2-.\7n\2\2./\7g\2\2/\4\3\2\2\2\60\61\7k\2\2\61\62\7p\2\2\62\63\7v\2"+
		"\2\63\6\3\2\2\2\64\65\7d\2\2\65\66\7q\2\2\66\67\7q\2\2\678\7n\2\289\7"+
		"g\2\29:\7c\2\2:;\7p\2\2;\b\3\2\2\2<=\7v\2\2=>\7t\2\2>?\7w\2\2?@\7g\2\2"+
		"@\n\3\2\2\2AB\7*\2\2B\f\3\2\2\2CD\7+\2\2D\16\3\2\2\2EF\7U\2\2FG\7v\2\2"+
		"GH\7t\2\2HI\7k\2\2IJ\7p\2\2JK\7i\2\2K\20\3\2\2\2LM\7>\2\2M\22\3\2\2\2"+
		"NO\7k\2\2OP\7h\2\2P\24\3\2\2\2QR\7h\2\2RS\7c\2\2ST\7n\2\2TU\7u\2\2UV\7"+
		"g\2\2V\26\3\2\2\2WX\7@\2\2X\30\3\2\2\2YZ\7H\2\2Z[\7Q\2\2[\\\7T\2\2\\]"+
		"\7O\2\2]\32\3\2\2\2^`\4\62;\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2"+
		"bk\3\2\2\2ce\7\60\2\2df\4\62;\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2"+
		"\2hj\3\2\2\2ic\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\34\3\2\2\2mk\3\2"+
		"\2\2nu\7$\2\2ot\t\2\2\2pt\5\33\16\2qt\7a\2\2rt\5#\22\2so\3\2\2\2sp\3\2"+
		"\2\2sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2"+
		"\2\2xy\7$\2\2y\36\3\2\2\2z\u0081\7]\2\2{\u0080\5!\21\2|\u0080\5%\23\2"+
		"}\u0080\5\33\16\2~\u0080\5#\22\2\177{\3\2\2\2\177|\3\2\2\2\177}\3\2\2"+
		"\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7_\2\2\u0085"+
		" \3\2\2\2\u0086\u008a\t\3\2\2\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2"+
		"\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\"\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\t\5\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\b\22\2\2\u0093$\3\2\2\2\u0094\u0096\t\6\2\2\u0095\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"&\3\2\2\2\u0099\u009b\7\17\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\u009d\7\f\2\2\u009d(\3\2\2\2\16\2agksu\177"+
		"\u0081\u008a\u0090\u0097\u009a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}