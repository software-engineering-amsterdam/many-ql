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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, QuestionType=23, Boolean=24, 
		WidgetType=25, Color=26, Integer=27, Decimal=28, String=29, Identifier=30, 
		Comment=31, LineComment=32, WS=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "Hex", "Letter", "Digit", 
		"NonZeroDigit", "ZeroDigit", "StringCharacter", "Quote", "EscapeSequence", 
		"QuestionType", "Boolean", "WidgetType", "Color", "Integer", "Decimal", 
		"String", "Identifier", "Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'forecolor'", 
		"'backcolor'", "'widget'", "'slider'", "'('", "','", "')'", "'radio'", 
		"'dropdown'", "'checkbox'", "'textbox'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "QuestionType", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u0182\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\5\32\u00e7\n\32\3\33\3\33\3\34\3\34\3\35\3\35\5\35"+
		"\u00ef\n\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0111\n \3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\5!\u011c\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u012b\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\7$\u0138\n"+
		"$\f$\16$\u013b\13$\5$\u013d\n$\3%\3%\7%\u0141\n%\f%\16%\u0144\13%\3%\5"+
		"%\u0147\n%\5%\u0149\n%\3%\3%\6%\u014d\n%\r%\16%\u014e\3&\3&\7&\u0153\n"+
		"&\f&\16&\u0156\13&\3&\3&\3\'\3\'\3\'\3\'\7\'\u015e\n\'\f\'\16\'\u0161"+
		"\13\'\3(\3(\3(\3(\7(\u0167\n(\f(\16(\u016a\13(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\7)\u0175\n)\f)\16)\u0178\13)\3)\3)\3*\6*\u017d\n*\r*\16*\u017e\3"+
		"*\3*\4\u0154\u0168\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\2\61\2\63\2\65"+
		"\2\67\29\2;\2=\2?\31A\32C\33E\34G\35I\36K\37M O!Q\"S#\3\2\n\4\2\62;CH"+
		"\4\2C\\c|\3\2\63;\3\2\62\62\3\2^^\3\2$$\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\u018d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5`\3\2"+
		"\2\2\7b\3\2\2\2\td\3\2\2\2\13i\3\2\2\2\rq\3\2\2\2\17z\3\2\2\2\21\u0082"+
		"\3\2\2\2\23\u0088\3\2\2\2\25\u008a\3\2\2\2\27\u0093\3\2\2\2\31\u0098\3"+
		"\2\2\2\33\u00a2\3\2\2\2\35\u00ac\3\2\2\2\37\u00b3\3\2\2\2!\u00ba\3\2\2"+
		"\2#\u00bc\3\2\2\2%\u00be\3\2\2\2\'\u00c0\3\2\2\2)\u00c6\3\2\2\2+\u00cf"+
		"\3\2\2\2-\u00d8\3\2\2\2/\u00e0\3\2\2\2\61\u00e2\3\2\2\2\63\u00e6\3\2\2"+
		"\2\65\u00e8\3\2\2\2\67\u00ea\3\2\2\29\u00ee\3\2\2\2;\u00f0\3\2\2\2=\u00f2"+
		"\3\2\2\2?\u0110\3\2\2\2A\u011b\3\2\2\2C\u012a\3\2\2\2E\u012c\3\2\2\2G"+
		"\u013c\3\2\2\2I\u0148\3\2\2\2K\u0150\3\2\2\2M\u0159\3\2\2\2O\u0162\3\2"+
		"\2\2Q\u0170\3\2\2\2S\u017c\3\2\2\2UV\7u\2\2VW\7v\2\2WX\7{\2\2XY\7n\2\2"+
		"YZ\7g\2\2Z[\7u\2\2[\\\7j\2\2\\]\7g\2\2]^\7g\2\2^_\7v\2\2_\4\3\2\2\2`a"+
		"\7}\2\2a\6\3\2\2\2bc\7\177\2\2c\b\3\2\2\2de\7r\2\2ef\7c\2\2fg\7i\2\2g"+
		"h\7g\2\2h\n\3\2\2\2ij\7u\2\2jk\7g\2\2kl\7e\2\2lm\7v\2\2mn\7k\2\2no\7q"+
		"\2\2op\7p\2\2p\f\3\2\2\2qr\7s\2\2rs\7w\2\2st\7g\2\2tu\7u\2\2uv\7v\2\2"+
		"vw\7k\2\2wx\7q\2\2xy\7p\2\2y\16\3\2\2\2z{\7f\2\2{|\7g\2\2|}\7h\2\2}~\7"+
		"c\2\2~\177\7w\2\2\177\u0080\7n\2\2\u0080\u0081\7v\2\2\u0081\20\3\2\2\2"+
		"\u0082\u0083\7y\2\2\u0083\u0084\7k\2\2\u0084\u0085\7f\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7j\2\2\u0087\22\3\2\2\2\u0088\u0089\7<\2\2\u0089\24"+
		"\3\2\2\2\u008a\u008b\7h\2\2\u008b\u008c\7q\2\2\u008c\u008d\7p\2\2\u008d"+
		"\u008e\7v\2\2\u008e\u008f\7u\2\2\u008f\u0090\7k\2\2\u0090\u0091\7|\2\2"+
		"\u0091\u0092\7g\2\2\u0092\26\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095\7"+
		"q\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\30\3\2\2\2\u0098\u0099"+
		"\7h\2\2\u0099\u009a\7q\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7e\2\2\u009d\u009e\7q\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7q\2\2"+
		"\u00a0\u00a1\7t\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4\7"+
		"c\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7m\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8"+
		"\7q\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2\u00ab"+
		"\34\3\2\2\2\u00ac\u00ad\7y\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7f\2\2\u00af"+
		"\u00b0\7i\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7v\2\2\u00b2\36\3\2\2\2\u00b3"+
		"\u00b4\7u\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7f\2\2"+
		"\u00b7\u00b8\7g\2\2\u00b8\u00b9\7t\2\2\u00b9 \3\2\2\2\u00ba\u00bb\7*\2"+
		"\2\u00bb\"\3\2\2\2\u00bc\u00bd\7.\2\2\u00bd$\3\2\2\2\u00be\u00bf\7+\2"+
		"\2\u00bf&\3\2\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7"+
		"f\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7q\2\2\u00c5(\3\2\2\2\u00c6\u00c7"+
		"\7f\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7r\2\2\u00ca"+
		"\u00cb\7f\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7y\2\2\u00cd\u00ce\7p\2\2"+
		"\u00ce*\3\2\2\2\u00cf\u00d0\7e\2\2\u00d0\u00d1\7j\2\2\u00d1\u00d2\7g\2"+
		"\2\u00d2\u00d3\7e\2\2\u00d3\u00d4\7m\2\2\u00d4\u00d5\7d\2\2\u00d5\u00d6"+
		"\7q\2\2\u00d6\u00d7\7z\2\2\u00d7,\3\2\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da"+
		"\7g\2\2\u00da\u00db\7z\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7d\2\2\u00dd"+
		"\u00de\7q\2\2\u00de\u00df\7z\2\2\u00df.\3\2\2\2\u00e0\u00e1\t\2\2\2\u00e1"+
		"\60\3\2\2\2\u00e2\u00e3\t\3\2\2\u00e3\62\3\2\2\2\u00e4\u00e7\5\67\34\2"+
		"\u00e5\u00e7\5\65\33\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\64"+
		"\3\2\2\2\u00e8\u00e9\t\4\2\2\u00e9\66\3\2\2\2\u00ea\u00eb\t\5\2\2\u00eb"+
		"8\3\2\2\2\u00ec\u00ef\5=\37\2\u00ed\u00ef\n\6\2\2\u00ee\u00ec\3\2\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ef:\3\2\2\2\u00f0\u00f1\t\7\2\2\u00f1<\3\2\2\2"+
		"\u00f2\u00f3\7^\2\2\u00f3\u00f4\5;\36\2\u00f4>\3\2\2\2\u00f5\u00f6\7d"+
		"\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa"+
		"\7g\2\2\u00fa\u00fb\7c\2\2\u00fb\u0111\7p\2\2\u00fc\u00fd\7f\2\2\u00fd"+
		"\u00fe\7g\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7k\2\2\u0100\u0101\7o\2\2"+
		"\u0101\u0102\7c\2\2\u0102\u0111\7n\2\2\u0103\u0104\7k\2\2\u0104\u0105"+
		"\7p\2\2\u0105\u0106\7v\2\2\u0106\u0107\7g\2\2\u0107\u0108\7i\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u0111\7t\2\2\u010a\u010b\7u\2\2\u010b\u010c\7v\2\2"+
		"\u010c\u010d\7t\2\2\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0111"+
		"\7i\2\2\u0110\u00f5\3\2\2\2\u0110\u00fc\3\2\2\2\u0110\u0103\3\2\2\2\u0110"+
		"\u010a\3\2\2\2\u0111@\3\2\2\2\u0112\u0113\7v\2\2\u0113\u0114\7t\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u011c\7g\2\2\u0116\u0117\7h\2\2\u0117\u0118\7c\2\2"+
		"\u0118\u0119\7n\2\2\u0119\u011a\7u\2\2\u011a\u011c\7g\2\2\u011b\u0112"+
		"\3\2\2\2\u011b\u0116\3\2\2\2\u011cB\3\2\2\2\u011d\u011e\7e\2\2\u011e\u011f"+
		"\7j\2\2\u011f\u0120\7g\2\2\u0120\u0121\7e\2\2\u0121\u0122\7m\2\2\u0122"+
		"\u0123\7d\2\2\u0123\u0124\7q\2\2\u0124\u012b\7z\2\2\u0125\u0126\7t\2\2"+
		"\u0126\u0127\7c\2\2\u0127\u0128\7f\2\2\u0128\u0129\7k\2\2\u0129\u012b"+
		"\7q\2\2\u012a\u011d\3\2\2\2\u012a\u0125\3\2\2\2\u012bD\3\2\2\2\u012c\u012d"+
		"\7%\2\2\u012d\u012e\5/\30\2\u012e\u012f\5/\30\2\u012f\u0130\5/\30\2\u0130"+
		"\u0131\5/\30\2\u0131\u0132\5/\30\2\u0132\u0133\5/\30\2\u0133F\3\2\2\2"+
		"\u0134\u013d\5\67\34\2\u0135\u0139\5\65\33\2\u0136\u0138\5\63\32\2\u0137"+
		"\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u0134\3\2\2\2\u013c"+
		"\u0135\3\2\2\2\u013dH\3\2\2\2\u013e\u0142\5\65\33\2\u013f\u0141\5\63\32"+
		"\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0149\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\5\67\34\2"+
		"\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u013e"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\7\60\2\2"+
		"\u014b\u014d\5\63\32\2\u014c\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014fJ\3\2\2\2\u0150\u0154\5;\36\2\u0151"+
		"\u0153\59\35\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0154\u0152\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157"+
		"\u0158\5;\36\2\u0158L\3\2\2\2\u0159\u015f\5\61\31\2\u015a\u015e\5\61\31"+
		"\2\u015b\u015e\5\63\32\2\u015c\u015e\7a\2\2\u015d\u015a\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160N\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163"+
		"\7\61\2\2\u0163\u0164\7,\2\2\u0164\u0168\3\2\2\2\u0165\u0167\13\2\2\2"+
		"\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0169\3\2\2\2\u0168\u0166"+
		"\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7,\2\2\u016c"+
		"\u016d\7\61\2\2\u016d\u016e\3\2\2\2\u016e\u016f\b(\2\2\u016fP\3\2\2\2"+
		"\u0170\u0171\7\61\2\2\u0171\u0172\7\61\2\2\u0172\u0176\3\2\2\2\u0173\u0175"+
		"\n\b\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a\b)"+
		"\2\2\u017aR\3\2\2\2\u017b\u017d\t\t\2\2\u017c\u017b\3\2\2\2\u017d\u017e"+
		"\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0181\b*\2\2\u0181T\3\2\2\2\24\2\u00e6\u00ee\u0110\u011b\u012a\u0139"+
		"\u013c\u0142\u0146\u0148\u014e\u0154\u015d\u015f\u0168\u0176\u017e\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}