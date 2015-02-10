// Generated from C:/Users/Timon/SkyDrive/MSc/Software Construction/many-ql/kennedy-langlotz/src\KLQ.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KLQLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, String=5, Number=6, PAGE=7, SECTION=8, 
		QUESTION=9, END=10, ID=11, TYPE=12, VALUE=13, TEXT=14, REQUIRES=15, ONLY=16, 
		SET=17, BOOLEAN=18, DATE=19, CURRENCY=20, STRING=21, NUMERAL=22, ADD=23, 
		SUB=24, MUL=25, DIV=26, QuestionId=27, Int=28, Decimal=29, NEWLINE=30, 
		WS=31, COMMENT=32, LINE_COMMENT=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "String", "Number", "StringCharacter", 
		"PAGE", "SECTION", "QUESTION", "END", "ID", "TYPE", "VALUE", "TEXT", "REQUIRES", 
		"ONLY", "SET", "BOOLEAN", "DATE", "CURRENCY", "STRING", "NUMERAL", "ADD", 
		"SUB", "MUL", "DIV", "QuestionId", "Int", "Decimal", "Letter", "LetterOrDigit", 
		"Digit", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "', '", null, null, "'page'", "'section'", 
		"'question'", "'end'", "'id'", "'type'", "'value'", "'text'", "'requires'", 
		"'only'", "'set'", "'boolean'", "'date'", "'currency'", "'string'", "'numeral'", 
		"'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "String", "Number", "PAGE", "SECTION", "QUESTION", 
		"END", "ID", "TYPE", "VALUE", "TEXT", "REQUIRES", "ONLY", "SET", "BOOLEAN", 
		"DATE", "CURRENCY", "STRING", "NUMERAL", "ADD", "SUB", "MUL", "DIV", "QuestionId", 
		"Int", "Decimal", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public KLQLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KLQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\3\7\3\7\5\7b\n\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\7\35\u00d4\n\35\f\35\16\35\u00d7"+
		"\13\35\3\36\6\36\u00da\n\36\r\36\16\36\u00db\3\37\6\37\u00df\n\37\r\37"+
		"\16\37\u00e0\3\37\3\37\7\37\u00e5\n\37\f\37\16\37\u00e8\13\37\3 \3 \3"+
		"!\3!\3\"\3\"\3#\5#\u00f1\n#\3#\3#\5#\u00f5\n#\3$\6$\u00f8\n$\r$\16$\u00f9"+
		"\3$\3$\3%\3%\3%\3%\7%\u0102\n%\f%\16%\u0105\13%\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3&\7&\u0110\n&\f&\16&\u0113\13&\3&\3&\3\u0103\2\'\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\2\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'"+
		"\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37?\2A\2C\2E G!I"+
		"\"K#\3\2\b\4\2$$^^\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\4\2\f\f"+
		"\17\17\u011c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2"+
		"\5O\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13V\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21"+
		"e\3\2\2\2\23j\3\2\2\2\25r\3\2\2\2\27{\3\2\2\2\31\177\3\2\2\2\33\u0082"+
		"\3\2\2\2\35\u0087\3\2\2\2\37\u008d\3\2\2\2!\u0092\3\2\2\2#\u009b\3\2\2"+
		"\2%\u00a0\3\2\2\2\'\u00a4\3\2\2\2)\u00ac\3\2\2\2+\u00b1\3\2\2\2-\u00ba"+
		"\3\2\2\2/\u00c1\3\2\2\2\61\u00c9\3\2\2\2\63\u00cb\3\2\2\2\65\u00cd\3\2"+
		"\2\2\67\u00cf\3\2\2\29\u00d1\3\2\2\2;\u00d9\3\2\2\2=\u00de\3\2\2\2?\u00e9"+
		"\3\2\2\2A\u00eb\3\2\2\2C\u00ed\3\2\2\2E\u00f4\3\2\2\2G\u00f7\3\2\2\2I"+
		"\u00fd\3\2\2\2K\u010b\3\2\2\2MN\7<\2\2N\4\3\2\2\2OP\7*\2\2P\6\3\2\2\2"+
		"QR\7+\2\2R\b\3\2\2\2ST\7.\2\2TU\7\"\2\2U\n\3\2\2\2VZ\7$\2\2WY\5\17\b\2"+
		"XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7$\2"+
		"\2^\f\3\2\2\2_b\5;\36\2`b\5=\37\2a_\3\2\2\2a`\3\2\2\2b\16\3\2\2\2cd\n"+
		"\2\2\2d\20\3\2\2\2ef\7r\2\2fg\7c\2\2gh\7i\2\2hi\7g\2\2i\22\3\2\2\2jk\7"+
		"u\2\2kl\7g\2\2lm\7e\2\2mn\7v\2\2no\7k\2\2op\7q\2\2pq\7p\2\2q\24\3\2\2"+
		"\2rs\7s\2\2st\7w\2\2tu\7g\2\2uv\7u\2\2vw\7v\2\2wx\7k\2\2xy\7q\2\2yz\7"+
		"p\2\2z\26\3\2\2\2{|\7g\2\2|}\7p\2\2}~\7f\2\2~\30\3\2\2\2\177\u0080\7k"+
		"\2\2\u0080\u0081\7f\2\2\u0081\32\3\2\2\2\u0082\u0083\7v\2\2\u0083\u0084"+
		"\7{\2\2\u0084\u0085\7r\2\2\u0085\u0086\7g\2\2\u0086\34\3\2\2\2\u0087\u0088"+
		"\7x\2\2\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7w\2\2\u008b"+
		"\u008c\7g\2\2\u008c\36\3\2\2\2\u008d\u008e\7v\2\2\u008e\u008f\7g\2\2\u008f"+
		"\u0090\7z\2\2\u0090\u0091\7v\2\2\u0091 \3\2\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7g\2\2\u0094\u0095\7s\2\2\u0095\u0096\7w\2\2\u0096\u0097\7k\2\2"+
		"\u0097\u0098\7t\2\2\u0098\u0099\7g\2\2\u0099\u009a\7u\2\2\u009a\"\3\2"+
		"\2\2\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e\7n\2\2\u009e\u009f"+
		"\7{\2\2\u009f$\3\2\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7c\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab(\3\2\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7v\2\2\u00af\u00b0\7g\2\2\u00b0*\3\2\2\2\u00b1\u00b2\7e\2\2\u00b2"+
		"\u00b3\7w\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\u00b7\7p\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7{\2\2\u00b9,\3\2\2"+
		"\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be"+
		"\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7i\2\2\u00c0.\3\2\2\2\u00c1\u00c2"+
		"\7p\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4\7o\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7t\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7n\2\2\u00c8\60\3\2\2\2\u00c9"+
		"\u00ca\7-\2\2\u00ca\62\3\2\2\2\u00cb\u00cc\7/\2\2\u00cc\64\3\2\2\2\u00cd"+
		"\u00ce\7,\2\2\u00ce\66\3\2\2\2\u00cf\u00d0\7\61\2\2\u00d08\3\2\2\2\u00d1"+
		"\u00d5\5? \2\u00d2\u00d4\5A!\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6:\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d8\u00da\5C\"\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc<\3\2\2\2\u00dd\u00df\5C\"\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\7\60\2\2\u00e3\u00e5\5C\"\2\u00e4"+
		"\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7>\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\t\3\2\2\u00ea@\3\2"+
		"\2\2\u00eb\u00ec\t\4\2\2\u00ecB\3\2\2\2\u00ed\u00ee\t\5\2\2\u00eeD\3\2"+
		"\2\2\u00ef\u00f1\7\17\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f5\7\f\2\2\u00f3\u00f5\7\16\2\2\u00f4\u00f0\3"+
		"\2\2\2\u00f4\u00f3\3\2\2\2\u00f5F\3\2\2\2\u00f6\u00f8\t\6\2\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fc\b$\2\2\u00fcH\3\2\2\2\u00fd\u00fe\7\61\2\2"+
		"\u00fe\u00ff\7,\2\2\u00ff\u0103\3\2\2\2\u0100\u0102\13\2\2\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7,\2\2\u0107\u0108\7\61"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b%\2\2\u010aJ\3\2\2\2\u010b\u010c"+
		"\7\61\2\2\u010c\u010d\7\61\2\2\u010d\u0111\3\2\2\2\u010e\u0110\n\7\2\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\b&\2\2\u0115"+
		"L\3\2\2\2\16\2Za\u00d5\u00db\u00e0\u00e6\u00f0\u00f4\u00f9\u0103\u0111"+
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