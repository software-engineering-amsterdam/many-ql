// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/qls/syntax/QLS.g4 by ANTLR 4.5
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, QuestionType=17, 
		Boolean=18, Integer=19, Decimal=20, WidgetType=21, Color=22, String=23, 
		Identifier=24, Comment=25, LineComment=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "Hex", "Letter", 
		"Digit", "NonZeroDigit", "ZeroDigit", "StringCharacter", "Quote", "EscapeSequence", 
		"QuestionType", "Boolean", "Integer", "Decimal", "WidgetType", "Color", 
		"String", "Identifier", "Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'color'", "'widget'", 
		"'('", "')'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "QuestionType", "Boolean", "Integer", "Decimal", 
		"WidgetType", "Color", "String", "Identifier", "Comment", "LineComment", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0148\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\5\24\u00a6\n\24\3\25\3\25\3\26\3\26\3\27\3\27\5\27\u00ae\n\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u00d0\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u00db\n\33\3\34\3\34\3\34\7\34\u00e0\n\34\f\34\16\34\u00e3"+
		"\13\34\5\34\u00e5\n\34\3\35\3\35\7\35\u00e9\n\35\f\35\16\35\u00ec\13\35"+
		"\3\35\5\35\u00ef\n\35\5\35\u00f1\n\35\3\35\3\35\6\35\u00f5\n\35\r\35\16"+
		"\35\u00f6\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u010d\n\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \7 \u0119\n \f \16 \u011c\13 \3 \3 \3!"+
		"\3!\3!\3!\7!\u0124\n!\f!\16!\u0127\13!\3\"\3\"\3\"\3\"\7\"\u012d\n\"\f"+
		"\"\16\"\u0130\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u013b\n#\f#\16#"+
		"\u013e\13#\3#\3#\3$\6$\u0143\n$\r$\16$\u0144\3$\3$\4\u011a\u012e\2%\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\2%\2\'\2)\2+\2-\2/\2\61\2\63\23\65\24\67\259\26;\27=\30?\31A"+
		"\32C\33E\34G\35\3\2\13\4\2\62;CH\4\2C\\c|\3\2\63;\3\2\62\62\3\2^^\3\2"+
		"$$\3\2%%\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0154\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5T\3\2\2\2\7V\3\2\2\2\tX\3\2"+
		"\2\2\13]\3\2\2\2\re\3\2\2\2\17n\3\2\2\2\21v\3\2\2\2\23|\3\2\2\2\25~\3"+
		"\2\2\2\27\u0087\3\2\2\2\31\u008c\3\2\2\2\33\u0092\3\2\2\2\35\u0099\3\2"+
		"\2\2\37\u009b\3\2\2\2!\u009d\3\2\2\2#\u009f\3\2\2\2%\u00a1\3\2\2\2\'\u00a5"+
		"\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3\2\2\2-\u00ad\3\2\2\2/\u00af\3\2\2\2\61"+
		"\u00b1\3\2\2\2\63\u00cf\3\2\2\2\65\u00da\3\2\2\2\67\u00e4\3\2\2\29\u00f0"+
		"\3\2\2\2;\u010c\3\2\2\2=\u010e\3\2\2\2?\u0116\3\2\2\2A\u011f\3\2\2\2C"+
		"\u0128\3\2\2\2E\u0136\3\2\2\2G\u0142\3\2\2\2IJ\7u\2\2JK\7v\2\2KL\7{\2"+
		"\2LM\7n\2\2MN\7g\2\2NO\7u\2\2OP\7j\2\2PQ\7g\2\2QR\7g\2\2RS\7v\2\2S\4\3"+
		"\2\2\2TU\7}\2\2U\6\3\2\2\2VW\7\177\2\2W\b\3\2\2\2XY\7r\2\2YZ\7c\2\2Z["+
		"\7i\2\2[\\\7g\2\2\\\n\3\2\2\2]^\7u\2\2^_\7g\2\2_`\7e\2\2`a\7v\2\2ab\7"+
		"k\2\2bc\7q\2\2cd\7p\2\2d\f\3\2\2\2ef\7s\2\2fg\7w\2\2gh\7g\2\2hi\7u\2\2"+
		"ij\7v\2\2jk\7k\2\2kl\7q\2\2lm\7p\2\2m\16\3\2\2\2no\7f\2\2op\7g\2\2pq\7"+
		"h\2\2qr\7c\2\2rs\7w\2\2st\7n\2\2tu\7v\2\2u\20\3\2\2\2vw\7y\2\2wx\7k\2"+
		"\2xy\7f\2\2yz\7v\2\2z{\7j\2\2{\22\3\2\2\2|}\7<\2\2}\24\3\2\2\2~\177\7"+
		"h\2\2\177\u0080\7q\2\2\u0080\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082\u0083"+
		"\7u\2\2\u0083\u0084\7k\2\2\u0084\u0085\7|\2\2\u0085\u0086\7g\2\2\u0086"+
		"\26\3\2\2\2\u0087\u0088\7h\2\2\u0088\u0089\7q\2\2\u0089\u008a\7p\2\2\u008a"+
		"\u008b\7v\2\2\u008b\30\3\2\2\2\u008c\u008d\7e\2\2\u008d\u008e\7q\2\2\u008e"+
		"\u008f\7n\2\2\u008f\u0090\7q\2\2\u0090\u0091\7t\2\2\u0091\32\3\2\2\2\u0092"+
		"\u0093\7y\2\2\u0093\u0094\7k\2\2\u0094\u0095\7f\2\2\u0095\u0096\7i\2\2"+
		"\u0096\u0097\7g\2\2\u0097\u0098\7v\2\2\u0098\34\3\2\2\2\u0099\u009a\7"+
		"*\2\2\u009a\36\3\2\2\2\u009b\u009c\7+\2\2\u009c \3\2\2\2\u009d\u009e\7"+
		".\2\2\u009e\"\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0$\3\2\2\2\u00a1\u00a2\t"+
		"\3\2\2\u00a2&\3\2\2\2\u00a3\u00a6\5+\26\2\u00a4\u00a6\5)\25\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6(\3\2\2\2\u00a7\u00a8\t\4\2\2\u00a8"+
		"*\3\2\2\2\u00a9\u00aa\t\5\2\2\u00aa,\3\2\2\2\u00ab\u00ae\5\61\31\2\u00ac"+
		"\u00ae\n\6\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae.\3\2\2\2"+
		"\u00af\u00b0\t\7\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7^\2\2\u00b2\u00b3\5"+
		"/\30\2\u00b3\62\3\2\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7"+
		"\7q\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7c\2\2\u00ba"+
		"\u00d0\7p\2\2\u00bb\u00bc\7f\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7e\2\2"+
		"\u00be\u00bf\7k\2\2\u00bf\u00c0\7o\2\2\u00c0\u00c1\7c\2\2\u00c1\u00d0"+
		"\7n\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7i\2\2\u00c7\u00c8\7g\2\2\u00c8\u00d0\7t\2\2"+
		"\u00c9\u00ca\7u\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd"+
		"\7k\2\2\u00cd\u00ce\7p\2\2\u00ce\u00d0\7i\2\2\u00cf\u00b4\3\2\2\2\u00cf"+
		"\u00bb\3\2\2\2\u00cf\u00c2\3\2\2\2\u00cf\u00c9\3\2\2\2\u00d0\64\3\2\2"+
		"\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7w\2\2\u00d4\u00db"+
		"\7g\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8"+
		"\u00d9\7u\2\2\u00d9\u00db\7g\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2"+
		"\2\u00db\66\3\2\2\2\u00dc\u00e5\5+\26\2\u00dd\u00e1\5)\25\2\u00de\u00e0"+
		"\5\'\24\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00dc"+
		"\3\2\2\2\u00e4\u00dd\3\2\2\2\u00e58\3\2\2\2\u00e6\u00ea\5)\25\2\u00e7"+
		"\u00e9\5\'\24\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f1\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ef\5+\26\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2"+
		"\2\2\u00f0\u00e6\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f4\7\60\2\2\u00f3\u00f5\5\'\24\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7:\3\2\2\2\u00f8\u00f9"+
		"\7u\2\2\u00f9\u00fa\7r\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7p\2\2\u00fc"+
		"\u00fd\7d\2\2\u00fd\u00fe\7q\2\2\u00fe\u010d\7z\2\2\u00ff\u0100\7e\2\2"+
		"\u0100\u0101\7j\2\2\u0101\u0102\7g\2\2\u0102\u0103\7e\2\2\u0103\u0104"+
		"\7m\2\2\u0104\u0105\7d\2\2\u0105\u0106\7q\2\2\u0106\u010d\7z\2\2\u0107"+
		"\u0108\7t\2\2\u0108\u0109\7c\2\2\u0109\u010a\7f\2\2\u010a\u010b\7k\2\2"+
		"\u010b\u010d\7q\2\2\u010c\u00f8\3\2\2\2\u010c\u00ff\3\2\2\2\u010c\u0107"+
		"\3\2\2\2\u010d<\3\2\2\2\u010e\u010f\t\b\2\2\u010f\u0110\5#\22\2\u0110"+
		"\u0111\5#\22\2\u0111\u0112\5#\22\2\u0112\u0113\5#\22\2\u0113\u0114\5#"+
		"\22\2\u0114\u0115\5#\22\2\u0115>\3\2\2\2\u0116\u011a\5/\30\2\u0117\u0119"+
		"\5-\27\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u011b\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\5/"+
		"\30\2\u011e@\3\2\2\2\u011f\u0125\5%\23\2\u0120\u0124\5%\23\2\u0121\u0124"+
		"\5\'\24\2\u0122\u0124\7a\2\2\u0123\u0120\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126B\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7\61\2\2\u0129\u012a"+
		"\7,\2\2\u012a\u012e\3\2\2\2\u012b\u012d\13\2\2\2\u012c\u012b\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\3\2"+
		"\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7,\2\2\u0132\u0133\7\61\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\b\"\2\2\u0135D\3\2\2\2\u0136\u0137\7\61\2\2"+
		"\u0137\u0138\7\61\2\2\u0138\u013c\3\2\2\2\u0139\u013b\n\t\2\2\u013a\u0139"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\b#\2\2\u0140F\3\2\2\2\u0141"+
		"\u0143\t\n\2\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\b$\2\2\u0147"+
		"H\3\2\2\2\24\2\u00a5\u00ad\u00cf\u00da\u00e1\u00e4\u00ea\u00ee\u00f0\u00f6"+
		"\u010c\u011a\u0123\u0125\u012e\u013c\u0144\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}