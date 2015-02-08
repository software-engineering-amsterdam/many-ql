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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, NUMBER=12, TEXT=13, FILETEXT=14, ID=15, WS=16, SPECIAL=17, 
		NEWLINE=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "NUMBER", "TEXT", "FILETEXT", "ID", "WS", "SPECIAL", "NEWLINE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\6\r"+
		"W\n\r\r\r\16\rX\3\r\3\r\6\r]\n\r\r\r\16\r^\7\ra\n\r\f\r\16\rd\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\7\16k\n\16\f\16\16\16n\13\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\7\17w\n\17\f\17\16\17z\13\17\3\17\3\17\3\20\3\20\7\20"+
		"\u0080\n\20\f\20\16\20\u0083\13\20\3\21\6\21\u0086\n\21\r\21\16\21\u0087"+
		"\3\21\3\21\3\22\6\22\u008d\n\22\r\22\16\22\u008e\3\23\5\23\u0092\n\23"+
		"\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\4\2C\\c|\5\2C\\aac|\6\2\62;C\\"+
		"aac|\5\2\13\f\17\17\"\"\7\2##..\60\60<=AA\u00a3\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3"+
		"\2\2\2\5.\3\2\2\2\7\62\3\2\2\2\t:\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3"+
		"\2\2\2\21E\3\2\2\2\23H\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31V\3\2\2\2\33"+
		"e\3\2\2\2\35q\3\2\2\2\37}\3\2\2\2!\u0085\3\2\2\2#\u008c\3\2\2\2%\u0091"+
		"\3\2\2\2\'(\7f\2\2()\7q\2\2)*\7w\2\2*+\7d\2\2+,\7n\2\2,-\7g\2\2-\4\3\2"+
		"\2\2./\7k\2\2/\60\7p\2\2\60\61\7v\2\2\61\6\3\2\2\2\62\63\7d\2\2\63\64"+
		"\7q\2\2\64\65\7q\2\2\65\66\7n\2\2\66\67\7g\2\2\678\7c\2\289\7p\2\29\b"+
		"\3\2\2\2:;\7v\2\2;<\7t\2\2<=\7w\2\2=>\7g\2\2>\n\3\2\2\2?@\7*\2\2@\f\3"+
		"\2\2\2AB\7+\2\2B\16\3\2\2\2CD\7>\2\2D\20\3\2\2\2EF\7k\2\2FG\7h\2\2G\22"+
		"\3\2\2\2HI\7h\2\2IJ\7c\2\2JK\7n\2\2KL\7u\2\2LM\7g\2\2M\24\3\2\2\2NO\7"+
		"@\2\2O\26\3\2\2\2PQ\7H\2\2QR\7Q\2\2RS\7T\2\2ST\7O\2\2T\30\3\2\2\2UW\4"+
		"\62;\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Yb\3\2\2\2Z\\\7\60\2\2["+
		"]\4\62;\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`Z\3\2\2"+
		"\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\32\3\2\2\2db\3\2\2\2el\7$\2\2fk\t\2"+
		"\2\2gk\5\31\r\2hk\7a\2\2ik\5!\21\2jf\3\2\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2"+
		"\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7$\2\2p\34\3"+
		"\2\2\2qx\7]\2\2rw\5\37\20\2sw\5#\22\2tw\5\31\r\2uw\5!\21\2vr\3\2\2\2v"+
		"s\3\2\2\2vt\3\2\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2"+
		"zx\3\2\2\2{|\7_\2\2|\36\3\2\2\2}\u0081\t\3\2\2~\u0080\t\4\2\2\177~\3\2"+
		"\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082 "+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\t\5\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008a\b\21\2\2\u008a\"\3\2\2\2\u008b\u008d\t\6\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"$\3\2\2\2\u0090\u0092\7\17\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\u0094\7\f\2\2\u0094&\3\2\2\2\16\2X^bjlvx\u0081"+
		"\u0087\u008e\u0091\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}