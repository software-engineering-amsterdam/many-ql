// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, STR=2, CUR=3, BOOL=4, TRUE=5, FALSE=6, IF=7, OR=8, AND=9, EQUAL=10, 
		GREATER=11, EQUAL_GREATER=12, EQUAL_COND=13, EQUAL_SMALLER=14, SMALLER=15, 
		LEFT_BRACES=16, RIGHT_BRACES=17, LEFT_PARENTHESES=18, RIGHT_PARENTHESES=19, 
		COLON=20, SEMICOLON=21, PLUS=22, MINUS=23, DEVIDE=24, MULTIPLY=25, Int=26, 
		Str=27, Float=28, WhiteSpace=29, MultiComment=30, SingleComment=31, Ident=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '"
	};
	public static final String[] ruleNames = {
		"INT", "STR", "CUR", "BOOL", "TRUE", "FALSE", "IF", "OR", "AND", "EQUAL", 
		"GREATER", "EQUAL_GREATER", "EQUAL_COND", "EQUAL_SMALLER", "SMALLER", 
		"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESES", "RIGHT_PARENTHESES", 
		"COLON", "SEMICOLON", "PLUS", "MINUS", "DEVIDE", "MULTIPLY", "Int", "Str", 
		"Float", "WhiteSpace", "MultiComment", "SingleComment", "Ident"
	};


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00c3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\6\33\u008d\n\33\r\33"+
		"\16\33\u008e\3\34\3\34\7\34\u0093\n\34\f\34\16\34\u0096\13\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00a6"+
		"\n\37\f\37\16\37\u00a9\13\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u00b4"+
		"\n \f \16 \u00b7\13 \3 \3 \3 \3 \3!\3!\7!\u00bf\n!\f!\16!\u00c2\13!\5"+
		"\u0094\u00a7\u00b5\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"\3\2\6\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\c|"+
		"\6\2\62;C\\aac|\u00c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2"+
		"\2\5G\3\2\2\2\7K\3\2\2\2\tO\3\2\2\2\13T\3\2\2\2\rY\3\2\2\2\17_\3\2\2\2"+
		"\21b\3\2\2\2\23e\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33o\3\2\2"+
		"\2\35r\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'}\3\2\2\2)\177"+
		"\3\2\2\2+\u0081\3\2\2\2-\u0083\3\2\2\2/\u0085\3\2\2\2\61\u0087\3\2\2\2"+
		"\63\u0089\3\2\2\2\65\u008c\3\2\2\2\67\u0090\3\2\2\29\u0099\3\2\2\2;\u009d"+
		"\3\2\2\2=\u00a1\3\2\2\2?\u00af\3\2\2\2A\u00bc\3\2\2\2CD\7K\2\2DE\7p\2"+
		"\2EF\7v\2\2F\4\3\2\2\2GH\7U\2\2HI\7v\2\2IJ\7t\2\2J\6\3\2\2\2KL\7E\2\2"+
		"LM\7w\2\2MN\7t\2\2N\b\3\2\2\2OP\7D\2\2PQ\7q\2\2QR\7q\2\2RS\7n\2\2S\n\3"+
		"\2\2\2TU\7v\2\2UV\7t\2\2VW\7w\2\2WX\7g\2\2X\f\3\2\2\2YZ\7h\2\2Z[\7c\2"+
		"\2[\\\7n\2\2\\]\7u\2\2]^\7g\2\2^\16\3\2\2\2_`\7k\2\2`a\7h\2\2a\20\3\2"+
		"\2\2bc\7~\2\2cd\7~\2\2d\22\3\2\2\2ef\7(\2\2fg\7(\2\2g\24\3\2\2\2hi\7?"+
		"\2\2i\26\3\2\2\2jk\7@\2\2k\30\3\2\2\2lm\7@\2\2mn\7?\2\2n\32\3\2\2\2op"+
		"\7?\2\2pq\7?\2\2q\34\3\2\2\2rs\7>\2\2st\7?\2\2t\36\3\2\2\2uv\7>\2\2v "+
		"\3\2\2\2wx\7}\2\2x\"\3\2\2\2yz\7\177\2\2z$\3\2\2\2{|\7*\2\2|&\3\2\2\2"+
		"}~\7+\2\2~(\3\2\2\2\177\u0080\7<\2\2\u0080*\3\2\2\2\u0081\u0082\7=\2\2"+
		"\u0082,\3\2\2\2\u0083\u0084\7-\2\2\u0084.\3\2\2\2\u0085\u0086\7/\2\2\u0086"+
		"\60\3\2\2\2\u0087\u0088\7\61\2\2\u0088\62\3\2\2\2\u0089\u008a\7,\2\2\u008a"+
		"\64\3\2\2\2\u008b\u008d\t\2\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2"+
		"\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\66\3\2\2\2\u0090\u0094"+
		"\7$\2\2\u0091\u0093\13\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\7$\2\2\u00988\3\2\2\2\u0099\u009a\5\65\33\2\u009a\u009b"+
		"\7\60\2\2\u009b\u009c\5\65\33\2\u009c:\3\2\2\2\u009d\u009e\t\3\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\b\36\2\2\u00a0<\3\2\2\2\u00a1\u00a2\7\61\2"+
		"\2\u00a2\u00a3\7,\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\13\2\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7,\2\2\u00ab\u00ac\7\61"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\37\2\2\u00ae>\3\2\2\2\u00af\u00b0"+
		"\7\61\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4\13\2\2"+
		"\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\f\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\b \2\2\u00bb@\3\2\2\2\u00bc\u00c0\t\4\2\2\u00bd"+
		"\u00bf\t\5\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1B\3\2\2\2\u00c2\u00c0\3\2\2\2\b\2\u008e"+
		"\u0094\u00a7\u00b5\u00c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}