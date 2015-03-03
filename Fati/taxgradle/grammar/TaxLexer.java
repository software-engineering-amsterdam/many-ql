// Generated from Tax.g4 by ANTLR 4.5

package org.tax.taxgen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TaxLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "STRING", "PRIMITIVETYPE", "FORMTAG", "IFTAG", "WS", "COMMENT", 
		"DECIMAL", "INT", "DIGIT", "LOWERCASE", "UPPERCASE", "BOOLEANLITERAL", 
		"ID", "LPAR", "RPAR", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "SINGLEQUOTE", "DOULEQUOTE", 
		"NEWLINE", "COLON", "LBRA", "RBRA", "SLASH"
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


	public TaxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0130\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4i\n\4"+
		"\f\4\16\4l\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0094\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\6\b\u009f\n\b\r\b\16\b\u00a0\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u00a9"+
		"\n\t\f\t\16\t\u00ac\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\6\n\u00b5\n\n\r\n"+
		"\16\n\u00b6\3\n\6\n\u00ba\n\n\r\n\16\n\u00bb\3\n\3\n\6\n\u00c0\n\n\r\n"+
		"\16\n\u00c1\5\n\u00c4\n\n\3\13\6\13\u00c7\n\13\r\13\16\13\u00c8\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00da\n\17\3\20\3\20\5\20\u00de\n\20\3\20\3\20\3\20\7\20\u00e3\n\20\f"+
		"\20\16\20\u00e6\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"+\6+\u0125\n+\r+\16+\u0126\3,\3,\3-\3-\3.\3.\3/\3/\3\u00aa\2\60\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\t\4\2$$^^\6\2\f\f\17\17$$^^\5\2"+
		"\13\f\17\17\"\"\3\2\62;\3\2c|\3\2C\\\4\2\f\f\17\17\u0143\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7d\3\2\2"+
		"\2\t\u0093\3\2\2\2\13\u0095\3\2\2\2\r\u009a\3\2\2\2\17\u009e\3\2\2\2\21"+
		"\u00a4\3\2\2\2\23\u00c3\3\2\2\2\25\u00c6\3\2\2\2\27\u00ca\3\2\2\2\31\u00cc"+
		"\3\2\2\2\33\u00ce\3\2\2\2\35\u00d9\3\2\2\2\37\u00dd\3\2\2\2!\u00e7\3\2"+
		"\2\2#\u00e9\3\2\2\2%\u00eb\3\2\2\2\'\u00ed\3\2\2\2)\u00ef\3\2\2\2+\u00f1"+
		"\3\2\2\2-\u00f3\3\2\2\2/\u00f5\3\2\2\2\61\u00f7\3\2\2\2\63\u00fa\3\2\2"+
		"\2\65\u00fd\3\2\2\2\67\u0100\3\2\2\29\u0103\3\2\2\2;\u0106\3\2\2\2=\u0109"+
		"\3\2\2\2?\u010c\3\2\2\2A\u010f\3\2\2\2C\u0111\3\2\2\2E\u0113\3\2\2\2G"+
		"\u0115\3\2\2\2I\u0117\3\2\2\2K\u0119\3\2\2\2M\u011b\3\2\2\2O\u011d\3\2"+
		"\2\2Q\u011f\3\2\2\2S\u0121\3\2\2\2U\u0124\3\2\2\2W\u0128\3\2\2\2Y\u012a"+
		"\3\2\2\2[\u012c\3\2\2\2]\u012e\3\2\2\2_`\7.\2\2`\4\3\2\2\2ab\7\60\2\2"+
		"bc\7\60\2\2c\6\3\2\2\2dj\7$\2\2ef\7^\2\2fi\t\2\2\2gi\n\3\2\2he\3\2\2\2"+
		"hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7$\2\2"+
		"n\b\3\2\2\2op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7n\2\2st\7g\2\2tu\7c\2\2u\u0094"+
		"\7p\2\2vw\7u\2\2wx\7v\2\2xy\7t\2\2yz\7k\2\2z{\7p\2\2{\u0094\7i\2\2|}\7"+
		"k\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7g\2\2\u0080\u0081\7i\2\2\u0081\u0082"+
		"\7g\2\2\u0082\u0094\7t\2\2\u0083\u0084\7f\2\2\u0084\u0085\7c\2\2\u0085"+
		"\u0086\7v\2\2\u0086\u0094\7g\2\2\u0087\u0088\7f\2\2\u0088\u0089\7g\2\2"+
		"\u0089\u008a\7e\2\2\u008a\u008b\7k\2\2\u008b\u008c\7o\2\2\u008c\u008d"+
		"\7c\2\2\u008d\u0094\7n\2\2\u008e\u008f\7o\2\2\u008f\u0090\7q\2\2\u0090"+
		"\u0091\7p\2\2\u0091\u0092\7g\2\2\u0092\u0094\7{\2\2\u0093o\3\2\2\2\u0093"+
		"v\3\2\2\2\u0093|\3\2\2\2\u0093\u0083\3\2\2\2\u0093\u0087\3\2\2\2\u0093"+
		"\u008e\3\2\2\2\u0094\n\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7q\2\2\u0097"+
		"\u0098\7t\2\2\u0098\u0099\7o\2\2\u0099\f\3\2\2\2\u009a\u009b\7k\2\2\u009b"+
		"\u009c\7h\2\2\u009c\16\3\2\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\b\b\2\2\u00a3\20\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5"+
		"\u00a6\7,\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9\13\2\2\2\u00a8\u00a7\3\2"+
		"\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\u00af\7\61"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\t\2\2\u00b1\22\3\2\2\2\u00b2\u00b4"+
		"\7\60\2\2\u00b3\u00b5\5\27\f\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00c4\3\2\2\2\u00b8\u00ba"+
		"\5\27\f\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\7\60\2\2\u00be\u00c0"+
		"\5\27\f\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b2\3\2\2\2\u00c3\u00b9"+
		"\3\2\2\2\u00c4\24\3\2\2\2\u00c5\u00c7\5\27\f\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\26\3\2\2"+
		"\2\u00ca\u00cb\t\5\2\2\u00cb\30\3\2\2\2\u00cc\u00cd\t\6\2\2\u00cd\32\3"+
		"\2\2\2\u00ce\u00cf\t\7\2\2\u00cf\34\3\2\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2"+
		"\7t\2\2\u00d2\u00d3\7w\2\2\u00d3\u00da\7g\2\2\u00d4\u00d5\7h\2\2\u00d5"+
		"\u00d6\7c\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7u\2\2\u00d8\u00da\7g\2\2"+
		"\u00d9\u00d0\3\2\2\2\u00d9\u00d4\3\2\2\2\u00da\36\3\2\2\2\u00db\u00de"+
		"\5\31\r\2\u00dc\u00de\5\33\16\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2"+
		"\2\u00de\u00e4\3\2\2\2\u00df\u00e3\5\31\r\2\u00e0\u00e3\5\33\16\2\u00e1"+
		"\u00e3\5\27\f\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3"+
		"\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		" \3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7*\2\2\u00e8\"\3\2\2\2\u00e9"+
		"\u00ea\7+\2\2\u00ea$\3\2\2\2\u00eb\u00ec\7?\2\2\u00ec&\3\2\2\2\u00ed\u00ee"+
		"\7@\2\2\u00ee(\3\2\2\2\u00ef\u00f0\7>\2\2\u00f0*\3\2\2\2\u00f1\u00f2\7"+
		"#\2\2\u00f2,\3\2\2\2\u00f3\u00f4\7\u0080\2\2\u00f4.\3\2\2\2\u00f5\u00f6"+
		"\7A\2\2\u00f6\60\3\2\2\2\u00f7\u00f8\7?\2\2\u00f8\u00f9\7?\2\2\u00f9\62"+
		"\3\2\2\2\u00fa\u00fb\7>\2\2\u00fb\u00fc\7?\2\2\u00fc\64\3\2\2\2\u00fd"+
		"\u00fe\7@\2\2\u00fe\u00ff\7?\2\2\u00ff\66\3\2\2\2\u0100\u0101\7#\2\2\u0101"+
		"\u0102\7?\2\2\u01028\3\2\2\2\u0103\u0104\7(\2\2\u0104\u0105\7(\2\2\u0105"+
		":\3\2\2\2\u0106\u0107\7~\2\2\u0107\u0108\7~\2\2\u0108<\3\2\2\2\u0109\u010a"+
		"\7-\2\2\u010a\u010b\7-\2\2\u010b>\3\2\2\2\u010c\u010d\7/\2\2\u010d\u010e"+
		"\7/\2\2\u010e@\3\2\2\2\u010f\u0110\7-\2\2\u0110B\3\2\2\2\u0111\u0112\7"+
		"/\2\2\u0112D\3\2\2\2\u0113\u0114\7,\2\2\u0114F\3\2\2\2\u0115\u0116\7\61"+
		"\2\2\u0116H\3\2\2\2\u0117\u0118\7(\2\2\u0118J\3\2\2\2\u0119\u011a\7~\2"+
		"\2\u011aL\3\2\2\2\u011b\u011c\7`\2\2\u011cN\3\2\2\2\u011d\u011e\7\'\2"+
		"\2\u011eP\3\2\2\2\u011f\u0120\7)\2\2\u0120R\3\2\2\2\u0121\u0122\7$\2\2"+
		"\u0122T\3\2\2\2\u0123\u0125\t\b\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127V\3\2\2\2\u0128\u0129"+
		"\7<\2\2\u0129X\3\2\2\2\u012a\u012b\7}\2\2\u012bZ\3\2\2\2\u012c\u012d\7"+
		"\177\2\2\u012d\\\3\2\2\2\u012e\u012f\7\61\2\2\u012f^\3\2\2\2\22\2hj\u0093"+
		"\u00a0\u00aa\u00b6\u00bb\u00c1\u00c3\u00c8\u00d9\u00dd\u00e2\u00e4\u0126"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}