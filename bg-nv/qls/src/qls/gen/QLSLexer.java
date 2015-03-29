// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/qls/src/qls/syntax/QLS.g4 by ANTLR 4.5
package qls.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, QuestionType=22, Boolean=23, WidgetType=24, 
		Color=25, Integer=26, Decimal=27, String=28, Identifier=29, Comment=30, 
		LineComment=31, WS=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "Hex", "Letter", "Digit", "NonZeroDigit", 
		"ZeroDigit", "StringCharacter", "Quote", "EscapeSequence", "QuestionType", 
		"Boolean", "WidgetType", "Color", "Integer", "Decimal", "String", "Identifier", 
		"Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'color'", "'widget'", 
		"'slider'", "'('", "','", "')'", "'radio'", "'dropdown'", "'checkbox'", 
		"'textbox'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "QuestionType", 
		"Boolean", "WidgetType", "Color", "Integer", "Decimal", "String", "Identifier", 
		"Comment", "LineComment", "WS"
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


	public QLSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u0172\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\5\31\u00d7\n\31\3\32\3\32\3\33\3\33\3\34\3\34\5\34"+
		"\u00df\n\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0101\n\37\3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \5 \u010c\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u011b\n!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\7#\u0128\n#\f#\16#\u012b\13#\5"+
		"#\u012d\n#\3$\3$\7$\u0131\n$\f$\16$\u0134\13$\3$\5$\u0137\n$\5$\u0139"+
		"\n$\3$\3$\6$\u013d\n$\r$\16$\u013e\3%\3%\7%\u0143\n%\f%\16%\u0146\13%"+
		"\3%\3%\3&\3&\3&\3&\7&\u014e\n&\f&\16&\u0151\13&\3\'\3\'\3\'\3\'\7\'\u0157"+
		"\n\'\f\'\16\'\u015a\13\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0165\n(\f"+
		"(\16(\u0168\13(\3(\3(\3)\6)\u016d\n)\r)\16)\u016e\3)\3)\4\u0144\u0158"+
		"\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\2\63\2\65\2\67\29\2;\2=\30"+
		"?\31A\32C\33E\34G\35I\36K\37M O!Q\"\3\2\n\4\2\62;CH\4\2C\\c|\3\2\63;\3"+
		"\2\62\62\3\2^^\3\2$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u017d\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5^\3\2\2\2\7`\3\2\2\2\tb\3\2\2\2\13g\3"+
		"\2\2\2\ro\3\2\2\2\17x\3\2\2\2\21\u0080\3\2\2\2\23\u0086\3\2\2\2\25\u0088"+
		"\3\2\2\2\27\u0091\3\2\2\2\31\u0096\3\2\2\2\33\u009c\3\2\2\2\35\u00a3\3"+
		"\2\2\2\37\u00aa\3\2\2\2!\u00ac\3\2\2\2#\u00ae\3\2\2\2%\u00b0\3\2\2\2\'"+
		"\u00b6\3\2\2\2)\u00bf\3\2\2\2+\u00c8\3\2\2\2-\u00d0\3\2\2\2/\u00d2\3\2"+
		"\2\2\61\u00d6\3\2\2\2\63\u00d8\3\2\2\2\65\u00da\3\2\2\2\67\u00de\3\2\2"+
		"\29\u00e0\3\2\2\2;\u00e2\3\2\2\2=\u0100\3\2\2\2?\u010b\3\2\2\2A\u011a"+
		"\3\2\2\2C\u011c\3\2\2\2E\u012c\3\2\2\2G\u0138\3\2\2\2I\u0140\3\2\2\2K"+
		"\u0149\3\2\2\2M\u0152\3\2\2\2O\u0160\3\2\2\2Q\u016c\3\2\2\2ST\7u\2\2T"+
		"U\7v\2\2UV\7{\2\2VW\7n\2\2WX\7g\2\2XY\7u\2\2YZ\7j\2\2Z[\7g\2\2[\\\7g\2"+
		"\2\\]\7v\2\2]\4\3\2\2\2^_\7}\2\2_\6\3\2\2\2`a\7\177\2\2a\b\3\2\2\2bc\7"+
		"r\2\2cd\7c\2\2de\7i\2\2ef\7g\2\2f\n\3\2\2\2gh\7u\2\2hi\7g\2\2ij\7e\2\2"+
		"jk\7v\2\2kl\7k\2\2lm\7q\2\2mn\7p\2\2n\f\3\2\2\2op\7s\2\2pq\7w\2\2qr\7"+
		"g\2\2rs\7u\2\2st\7v\2\2tu\7k\2\2uv\7q\2\2vw\7p\2\2w\16\3\2\2\2xy\7f\2"+
		"\2yz\7g\2\2z{\7h\2\2{|\7c\2\2|}\7w\2\2}~\7n\2\2~\177\7v\2\2\177\20\3\2"+
		"\2\2\u0080\u0081\7y\2\2\u0081\u0082\7k\2\2\u0082\u0083\7f\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7j\2\2\u0085\22\3\2\2\2\u0086\u0087\7<\2\2\u0087\24"+
		"\3\2\2\2\u0088\u0089\7h\2\2\u0089\u008a\7q\2\2\u008a\u008b\7p\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7u\2\2\u008d\u008e\7k\2\2\u008e\u008f\7|\2\2"+
		"\u008f\u0090\7g\2\2\u0090\26\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7"+
		"q\2\2\u0093\u0094\7p\2\2\u0094\u0095\7v\2\2\u0095\30\3\2\2\2\u0096\u0097"+
		"\7e\2\2\u0097\u0098\7q\2\2\u0098\u0099\7n\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7t\2\2\u009b\32\3\2\2\2\u009c\u009d\7y\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7f\2\2\u009f\u00a0\7i\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7v\2\2"+
		"\u00a2\34\3\2\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7"+
		"k\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7t\2\2\u00a9\36"+
		"\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab \3\2\2\2\u00ac\u00ad\7.\2\2\u00ad\""+
		"\3\2\2\2\u00ae\u00af\7+\2\2\u00af$\3\2\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2"+
		"\7c\2\2\u00b2\u00b3\7f\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7q\2\2\u00b5"+
		"&\3\2\2\2\u00b6\u00b7\7f\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"\u00ba\7r\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7y\2\2"+
		"\u00bd\u00be\7p\2\2\u00be(\3\2\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7j\2"+
		"\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7m\2\2\u00c4\u00c5"+
		"\7d\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7z\2\2\u00c7*\3\2\2\2\u00c8\u00c9"+
		"\7v\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7z\2\2\u00cb\u00cc\7v\2\2\u00cc"+
		"\u00cd\7d\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7z\2\2\u00cf,\3\2\2\2\u00d0"+
		"\u00d1\t\2\2\2\u00d1.\3\2\2\2\u00d2\u00d3\t\3\2\2\u00d3\60\3\2\2\2\u00d4"+
		"\u00d7\5\65\33\2\u00d5\u00d7\5\63\32\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\t\4\2\2\u00d9\64\3\2\2\2\u00da\u00db"+
		"\t\5\2\2\u00db\66\3\2\2\2\u00dc\u00df\5;\36\2\u00dd\u00df\n\6\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df8\3\2\2\2\u00e0\u00e1\t\7\2\2"+
		"\u00e1:\3\2\2\2\u00e2\u00e3\7^\2\2\u00e3\u00e4\59\35\2\u00e4<\3\2\2\2"+
		"\u00e5\u00e6\7d\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7n\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7c\2\2\u00eb\u0101\7p\2\2\u00ec"+
		"\u00ed\7f\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7e\2\2\u00ef\u00f0\7k\2\2"+
		"\u00f0\u00f1\7o\2\2\u00f1\u00f2\7c\2\2\u00f2\u0101\7n\2\2\u00f3\u00f4"+
		"\7k\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7g\2\2\u00f7"+
		"\u00f8\7i\2\2\u00f8\u00f9\7g\2\2\u00f9\u0101\7t\2\2\u00fa\u00fb\7u\2\2"+
		"\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff"+
		"\7p\2\2\u00ff\u0101\7i\2\2\u0100\u00e5\3\2\2\2\u0100\u00ec\3\2\2\2\u0100"+
		"\u00f3\3\2\2\2\u0100\u00fa\3\2\2\2\u0101>\3\2\2\2\u0102\u0103\7v\2\2\u0103"+
		"\u0104\7t\2\2\u0104\u0105\7w\2\2\u0105\u010c\7g\2\2\u0106\u0107\7h\2\2"+
		"\u0107\u0108\7c\2\2\u0108\u0109\7n\2\2\u0109\u010a\7u\2\2\u010a\u010c"+
		"\7g\2\2\u010b\u0102\3\2\2\2\u010b\u0106\3\2\2\2\u010c@\3\2\2\2\u010d\u010e"+
		"\7e\2\2\u010e\u010f\7j\2\2\u010f\u0110\7g\2\2\u0110\u0111\7e\2\2\u0111"+
		"\u0112\7m\2\2\u0112\u0113\7d\2\2\u0113\u0114\7q\2\2\u0114\u011b\7z\2\2"+
		"\u0115\u0116\7t\2\2\u0116\u0117\7c\2\2\u0117\u0118\7f\2\2\u0118\u0119"+
		"\7k\2\2\u0119\u011b\7q\2\2\u011a\u010d\3\2\2\2\u011a\u0115\3\2\2\2\u011b"+
		"B\3\2\2\2\u011c\u011d\7%\2\2\u011d\u011e\5-\27\2\u011e\u011f\5-\27\2\u011f"+
		"\u0120\5-\27\2\u0120\u0121\5-\27\2\u0121\u0122\5-\27\2\u0122\u0123\5-"+
		"\27\2\u0123D\3\2\2\2\u0124\u012d\5\65\33\2\u0125\u0129\5\63\32\2\u0126"+
		"\u0128\5\61\31\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3"+
		"\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u0124\3\2\2\2\u012c\u0125\3\2\2\2\u012dF\3\2\2\2\u012e\u0132\5\63\32"+
		"\2\u012f\u0131\5\61\31\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0139\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0135\u0137\5\65\33\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0139\3\2\2\2\u0138\u012e\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013c\7\60\2\2\u013b\u013d\5\61\31\2\u013c\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013fH\3\2\2\2"+
		"\u0140\u0144\59\35\2\u0141\u0143\5\67\34\2\u0142\u0141\3\2\2\2\u0143\u0146"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0148\59\35\2\u0148J\3\2\2\2\u0149\u014f\5/\30\2"+
		"\u014a\u014e\5/\30\2\u014b\u014e\5\61\31\2\u014c\u014e\7a\2\2\u014d\u014a"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150L\3\2\2\2\u0151\u014f\3\2\2\2"+
		"\u0152\u0153\7\61\2\2\u0153\u0154\7,\2\2\u0154\u0158\3\2\2\2\u0155\u0157"+
		"\13\2\2\2\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0159\3\2\2\2"+
		"\u0158\u0156\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c"+
		"\7,\2\2\u015c\u015d\7\61\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b\'\2\2\u015f"+
		"N\3\2\2\2\u0160\u0161\7\61\2\2\u0161\u0162\7\61\2\2\u0162\u0166\3\2\2"+
		"\2\u0163\u0165\n\b\2\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"\u016a\b(\2\2\u016aP\3\2\2\2\u016b\u016d\t\t\2\2\u016c\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2"+
		"\2\2\u0170\u0171\b)\2\2\u0171R\3\2\2\2\24\2\u00d6\u00de\u0100\u010b\u011a"+
		"\u0129\u012c\u0132\u0136\u0138\u013e\u0144\u014d\u014f\u0158\u0166\u016e"+
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