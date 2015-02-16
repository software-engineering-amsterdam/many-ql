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
		INT=1, STR=2, CUR=3, BOOL=4, DEC=5, DATE=6, FORM=7, IF=8, THEN=9, ELSE=10, 
		ELIF=11, OR=12, AND=13, EQUAL=14, GREATER=15, EQUAL_GREATER=16, EQUAL_COND=17, 
		EQUAL_SMALLER=18, SMALLER=19, PLUS=20, MINUS=21, DEVIDE=22, MULTIPLY=23, 
		LEFT_BRACE=24, RIGHT_BRACE=25, LEFT_PARENTHESES=26, RIGHT_PARENTHESES=27, 
		COLON=28, SEMICOLON=29, IntegerLiteral=30, DecimalLiteral=31, DecimalNumeral=32, 
		BooleanLiteral=33, StringLiteral=34, DateLiteral=35, Day=36, Month=37, 
		Year=38, Non_Zero_Digit=39, Digit=40, WhiteSpace=41, MultiComment=42, 
		SingleComment=43, Identifier=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','"
	};
	public static final String[] ruleNames = {
		"INT", "STR", "CUR", "BOOL", "DEC", "DATE", "FORM", "IF", "THEN", "ELSE", 
		"ELIF", "OR", "AND", "EQUAL", "GREATER", "EQUAL_GREATER", "EQUAL_COND", 
		"EQUAL_SMALLER", "SMALLER", "PLUS", "MINUS", "DEVIDE", "MULTIPLY", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_PARENTHESES", "RIGHT_PARENTHESES", "COLON", "SEMICOLON", 
		"IntegerLiteral", "DecimalLiteral", "DecimalNumeral", "BooleanLiteral", 
		"StringLiteral", "DateLiteral", "Day", "Month", "Year", "Non_Zero_Digit", 
		"Digit", "WhiteSpace", "MultiComment", "SingleComment", "Identifier"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u011b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\7\37\u00bb\n\37\f\37\16\37\u00be\13\37\3 \3 \3 \7 \u00c3"+
		"\n \f \16 \u00c6\13 \3!\3!\7!\u00ca\n!\f!\16!\u00cd\13!\3!\5!\u00d0\n"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00db\n\"\3#\3#\7#\u00df\n#"+
		"\f#\16#\u00e2\13#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3*\3*\3+\3+\3+\3+\7+\u00fe\n+\f+\16+\u0101\13+\3+\3+\3+\3+"+
		"\3+\3,\3,\3,\3,\7,\u010c\n,\f,\16,\u010f\13,\3,\3,\3,\3,\3-\3-\7-\u0117"+
		"\n-\f-\16-\u011a\13-\5\u00e0\u00ff\u010d\2.\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.\3\2\n\3\2\63;\3\2\62;\3\2\62\62\t\2\64\64FFiikkvv}}\177\177\t\2"+
		"\66\66FFiikkvv}}\177\177\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u0123"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5_\3\2\2\2\7c\3\2\2\2\tg\3"+
		"\2\2\2\13l\3\2\2\2\rp\3\2\2\2\17u\3\2\2\2\21z\3\2\2\2\23}\3\2\2\2\25\u0082"+
		"\3\2\2\2\27\u0087\3\2\2\2\31\u008f\3\2\2\2\33\u0092\3\2\2\2\35\u0095\3"+
		"\2\2\2\37\u0097\3\2\2\2!\u0099\3\2\2\2#\u009c\3\2\2\2%\u009f\3\2\2\2\'"+
		"\u00a2\3\2\2\2)\u00a4\3\2\2\2+\u00a6\3\2\2\2-\u00a8\3\2\2\2/\u00aa\3\2"+
		"\2\2\61\u00ac\3\2\2\2\63\u00ae\3\2\2\2\65\u00b0\3\2\2\2\67\u00b2\3\2\2"+
		"\29\u00b4\3\2\2\2;\u00b6\3\2\2\2=\u00b8\3\2\2\2?\u00bf\3\2\2\2A\u00cf"+
		"\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G\u00e5\3\2\2\2I\u00eb\3\2\2\2K"+
		"\u00ed\3\2\2\2M\u00ef\3\2\2\2O\u00f1\3\2\2\2Q\u00f3\3\2\2\2S\u00f5\3\2"+
		"\2\2U\u00f9\3\2\2\2W\u0107\3\2\2\2Y\u0114\3\2\2\2[\\\7K\2\2\\]\7p\2\2"+
		"]^\7v\2\2^\4\3\2\2\2_`\7U\2\2`a\7v\2\2ab\7t\2\2b\6\3\2\2\2cd\7E\2\2de"+
		"\7w\2\2ef\7t\2\2f\b\3\2\2\2gh\7D\2\2hi\7q\2\2ij\7q\2\2jk\7n\2\2k\n\3\2"+
		"\2\2lm\7F\2\2mn\7g\2\2no\7e\2\2o\f\3\2\2\2pq\7F\2\2qr\7c\2\2rs\7v\2\2"+
		"st\7g\2\2t\16\3\2\2\2uv\7h\2\2vw\7q\2\2wx\7t\2\2xy\7o\2\2y\20\3\2\2\2"+
		"z{\7k\2\2{|\7h\2\2|\22\3\2\2\2}~\7v\2\2~\177\7j\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7p\2\2\u0081\24\3\2\2\2\u0082\u0083\7g\2\2\u0083\u0084\7n\2\2\u0084"+
		"\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086\26\3\2\2\2\u0087\u0088\7g\2\2\u0088"+
		"\u0089\7n\2\2\u0089\u008a\7u\2\2\u008a\u008b\7g\2\2\u008b\u008c\7\"\2"+
		"\2\u008c\u008d\7k\2\2\u008d\u008e\7h\2\2\u008e\30\3\2\2\2\u008f\u0090"+
		"\7~\2\2\u0090\u0091\7~\2\2\u0091\32\3\2\2\2\u0092\u0093\7(\2\2\u0093\u0094"+
		"\7(\2\2\u0094\34\3\2\2\2\u0095\u0096\7?\2\2\u0096\36\3\2\2\2\u0097\u0098"+
		"\7@\2\2\u0098 \3\2\2\2\u0099\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b\"\3"+
		"\2\2\2\u009c\u009d\7?\2\2\u009d\u009e\7?\2\2\u009e$\3\2\2\2\u009f\u00a0"+
		"\7>\2\2\u00a0\u00a1\7?\2\2\u00a1&\3\2\2\2\u00a2\u00a3\7>\2\2\u00a3(\3"+
		"\2\2\2\u00a4\u00a5\7-\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7/\2\2\u00a7,\3\2"+
		"\2\2\u00a8\u00a9\7\61\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7,\2\2\u00ab\60\3"+
		"\2\2\2\u00ac\u00ad\7}\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7\177\2\2\u00af"+
		"\64\3\2\2\2\u00b0\u00b1\7*\2\2\u00b1\66\3\2\2\2\u00b2\u00b3\7+\2\2\u00b3"+
		"8\3\2\2\2\u00b4\u00b5\7<\2\2\u00b5:\3\2\2\2\u00b6\u00b7\7=\2\2\u00b7<"+
		"\3\2\2\2\u00b8\u00bc\t\2\2\2\u00b9\u00bb\t\3\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd>\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00bf\u00c0\5A!\2\u00c0\u00c4\7\60\2\2\u00c1\u00c3"+
		"\5Q)\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5@\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00cb\5O(\2\u00c8"+
		"\u00ca\5Q)\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2"+
		"\2\u00cb\u00cc\3\2\2\2\u00cc\u00d0\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0"+
		"\t\4\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0B\3\2\2\2\u00d1"+
		"\u00d2\7v\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7w\2\2\u00d4\u00db\7g\2\2"+
		"\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9"+
		"\7u\2\2\u00d9\u00db\7g\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2\2\u00db"+
		"D\3\2\2\2\u00dc\u00e0\7$\2\2\u00dd\u00df\13\2\2\2\u00de\u00dd\3\2\2\2"+
		"\u00df\u00e2\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3"+
		"\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7$\2\2\u00e4F\3\2\2\2\u00e5\u00e6"+
		"\5I%\2\u00e6\u00e7\7/\2\2\u00e7\u00e8\5K&\2\u00e8\u00e9\7/\2\2\u00e9\u00ea"+
		"\5M\'\2\u00eaH\3\2\2\2\u00eb\u00ec\t\5\2\2\u00ecJ\3\2\2\2\u00ed\u00ee"+
		"\t\5\2\2\u00eeL\3\2\2\2\u00ef\u00f0\t\6\2\2\u00f0N\3\2\2\2\u00f1\u00f2"+
		"\t\2\2\2\u00f2P\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4R\3\2\2\2\u00f5\u00f6"+
		"\t\7\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b*\2\2\u00f8T\3\2\2\2\u00f9\u00fa"+
		"\7\61\2\2\u00fa\u00fb\7,\2\2\u00fb\u00ff\3\2\2\2\u00fc\u00fe\13\2\2\2"+
		"\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u0100\3\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7,\2\2\u0103"+
		"\u0104\7\61\2\2\u0104\u0105\3\2\2\2\u0105\u0106\b+\2\2\u0106V\3\2\2\2"+
		"\u0107\u0108\7\61\2\2\u0108\u0109\7\61\2\2\u0109\u010d\3\2\2\2\u010a\u010c"+
		"\13\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010e\3\2\2\2"+
		"\u010d\u010b\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111"+
		"\7\f\2\2\u0111\u0112\3\2\2\2\u0112\u0113\b,\2\2\u0113X\3\2\2\2\u0114\u0118"+
		"\t\b\2\2\u0115\u0117\t\t\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119Z\3\2\2\2\u011a\u0118\3\2\2\2"+
		"\f\2\u00bc\u00c4\u00cb\u00cf\u00da\u00e0\u00ff\u010d\u0118\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}