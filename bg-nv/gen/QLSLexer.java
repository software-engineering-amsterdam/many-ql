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
		T__9=10, T__10=11, T__11=12, T__12=13, WidgetType=14, Color=15, QuestionType=16, 
		Boolean=17, Integer=18, Decimal=19, String=20, Identifier=21, Comment=22, 
		LineComment=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "Hex", "WidgetType", "Color", "Digit", 
		"NonZeroDigit", "ZeroDigit", "StringCharacter", "Quote", "EscapeSequence", 
		"QuestionType", "Boolean", "Integer", "Decimal", "String", "Letter", "Identifier", 
		"Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'color'", "'widget'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "WidgetType", "Color", "QuestionType", "Boolean", "Integer", 
		"Decimal", "String", "Identifier", "Comment", "LineComment", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u013c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00aa\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00b6\n\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\5\25\u00be\n\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00e0\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00eb\n\31\3\32\3\32\3\32\7\32\u00f0"+
		"\n\32\f\32\16\32\u00f3\13\32\5\32\u00f5\n\32\3\33\3\33\7\33\u00f9\n\33"+
		"\f\33\16\33\u00fc\13\33\3\33\5\33\u00ff\n\33\5\33\u0101\n\33\3\33\3\33"+
		"\6\33\u0105\n\33\r\33\16\33\u0106\3\34\3\34\7\34\u010b\n\34\f\34\16\34"+
		"\u010e\13\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u0118\n\36\f"+
		"\36\16\36\u011b\13\36\3\37\3\37\3\37\3\37\7\37\u0121\n\37\f\37\16\37\u0124"+
		"\13\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u012f\n \f \16 \u0132\13"+
		" \3 \3 \3!\6!\u0137\n!\r!\16!\u0138\3!\3!\4\u010c\u0122\2\"\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#"+
		"\2%\2\'\2)\2+\2-\2/\22\61\23\63\24\65\25\67\269\2;\27=\30?\31A\32\3\2"+
		"\13\4\2\62;CH\3\2%%\3\2\63;\3\2\62\62\3\2^^\3\2$$\4\2C\\c|\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\u0148\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5N\3\2\2\2\7P"+
		"\3\2\2\2\tR\3\2\2\2\13W\3\2\2\2\r_\3\2\2\2\17h\3\2\2\2\21p\3\2\2\2\23"+
		"v\3\2\2\2\25x\3\2\2\2\27\u0081\3\2\2\2\31\u0086\3\2\2\2\33\u008c\3\2\2"+
		"\2\35\u0093\3\2\2\2\37\u00a9\3\2\2\2!\u00ab\3\2\2\2#\u00b5\3\2\2\2%\u00b7"+
		"\3\2\2\2\'\u00b9\3\2\2\2)\u00bd\3\2\2\2+\u00bf\3\2\2\2-\u00c1\3\2\2\2"+
		"/\u00df\3\2\2\2\61\u00ea\3\2\2\2\63\u00f4\3\2\2\2\65\u0100\3\2\2\2\67"+
		"\u0108\3\2\2\29\u0111\3\2\2\2;\u0113\3\2\2\2=\u011c\3\2\2\2?\u012a\3\2"+
		"\2\2A\u0136\3\2\2\2CD\7u\2\2DE\7v\2\2EF\7{\2\2FG\7n\2\2GH\7g\2\2HI\7u"+
		"\2\2IJ\7j\2\2JK\7g\2\2KL\7g\2\2LM\7v\2\2M\4\3\2\2\2NO\7}\2\2O\6\3\2\2"+
		"\2PQ\7\177\2\2Q\b\3\2\2\2RS\7r\2\2ST\7c\2\2TU\7i\2\2UV\7g\2\2V\n\3\2\2"+
		"\2WX\7u\2\2XY\7g\2\2YZ\7e\2\2Z[\7v\2\2[\\\7k\2\2\\]\7q\2\2]^\7p\2\2^\f"+
		"\3\2\2\2_`\7s\2\2`a\7w\2\2ab\7g\2\2bc\7u\2\2cd\7v\2\2de\7k\2\2ef\7q\2"+
		"\2fg\7p\2\2g\16\3\2\2\2hi\7f\2\2ij\7g\2\2jk\7h\2\2kl\7c\2\2lm\7w\2\2m"+
		"n\7n\2\2no\7v\2\2o\20\3\2\2\2pq\7y\2\2qr\7k\2\2rs\7f\2\2st\7v\2\2tu\7"+
		"j\2\2u\22\3\2\2\2vw\7<\2\2w\24\3\2\2\2xy\7h\2\2yz\7q\2\2z{\7p\2\2{|\7"+
		"v\2\2|}\7u\2\2}~\7k\2\2~\177\7|\2\2\177\u0080\7g\2\2\u0080\26\3\2\2\2"+
		"\u0081\u0082\7h\2\2\u0082\u0083\7q\2\2\u0083\u0084\7p\2\2\u0084\u0085"+
		"\7v\2\2\u0085\30\3\2\2\2\u0086\u0087\7e\2\2\u0087\u0088\7q\2\2\u0088\u0089"+
		"\7n\2\2\u0089\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\32\3\2\2\2\u008c\u008d"+
		"\7y\2\2\u008d\u008e\7k\2\2\u008e\u008f\7f\2\2\u008f\u0090\7i\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7v\2\2\u0092\34\3\2\2\2\u0093\u0094\t\2\2\2"+
		"\u0094\36\3\2\2\2\u0095\u0096\7u\2\2\u0096\u0097\7r\2\2\u0097\u0098\7"+
		"k\2\2\u0098\u0099\7p\2\2\u0099\u009a\7d\2\2\u009a\u009b\7q\2\2\u009b\u00aa"+
		"\7z\2\2\u009c\u009d\7e\2\2\u009d\u009e\7j\2\2\u009e\u009f\7g\2\2\u009f"+
		"\u00a0\7e\2\2\u00a0\u00a1\7m\2\2\u00a1\u00a2\7d\2\2\u00a2\u00a3\7q\2\2"+
		"\u00a3\u00aa\7z\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7"+
		"\7f\2\2\u00a7\u00a8\7k\2\2\u00a8\u00aa\7q\2\2\u00a9\u0095\3\2\2\2\u00a9"+
		"\u009c\3\2\2\2\u00a9\u00a4\3\2\2\2\u00aa \3\2\2\2\u00ab\u00ac\t\3\2\2"+
		"\u00ac\u00ad\5\35\17\2\u00ad\u00ae\5\35\17\2\u00ae\u00af\5\35\17\2\u00af"+
		"\u00b0\5\35\17\2\u00b0\u00b1\5\35\17\2\u00b1\u00b2\5\35\17\2\u00b2\"\3"+
		"\2\2\2\u00b3\u00b6\5\'\24\2\u00b4\u00b6\5%\23\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6$\3\2\2\2\u00b7\u00b8\t\4\2\2\u00b8&\3\2\2\2\u00b9"+
		"\u00ba\t\5\2\2\u00ba(\3\2\2\2\u00bb\u00be\5-\27\2\u00bc\u00be\n\6\2\2"+
		"\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be*\3\2\2\2\u00bf\u00c0\t"+
		"\7\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7^\2\2\u00c2\u00c3\5+\26\2\u00c3.\3"+
		"\2\2\2\u00c4\u00c5\7d\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7q\2\2\u00c7"+
		"\u00c8\7n\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7c\2\2\u00ca\u00e0\7p\2\2"+
		"\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf"+
		"\7k\2\2\u00cf\u00d0\7o\2\2\u00d0\u00d1\7c\2\2\u00d1\u00e0\7n\2\2\u00d2"+
		"\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7g\2\2"+
		"\u00d6\u00d7\7i\2\2\u00d7\u00d8\7g\2\2\u00d8\u00e0\7t\2\2\u00d9\u00da"+
		"\7u\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7k\2\2\u00dd"+
		"\u00de\7p\2\2\u00de\u00e0\7i\2\2\u00df\u00c4\3\2\2\2\u00df\u00cb\3\2\2"+
		"\2\u00df\u00d2\3\2\2\2\u00df\u00d9\3\2\2\2\u00e0\60\3\2\2\2\u00e1\u00e2"+
		"\7v\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7w\2\2\u00e4\u00eb\7g\2\2\u00e5"+
		"\u00e6\7h\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9\7u\2\2"+
		"\u00e9\u00eb\7g\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e5\3\2\2\2\u00eb\62\3"+
		"\2\2\2\u00ec\u00f5\5\'\24\2\u00ed\u00f1\5%\23\2\u00ee\u00f0\5#\22\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00ec\3\2\2\2\u00f4"+
		"\u00ed\3\2\2\2\u00f5\64\3\2\2\2\u00f6\u00fa\5%\23\2\u00f7\u00f9\5#\22"+
		"\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u0101\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\5\'\24\2"+
		"\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00f6"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\7\60\2\2"+
		"\u0103\u0105\5#\22\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\66\3\2\2\2\u0108\u010c\5+\26\2\u0109"+
		"\u010b\5)\25\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\u0110\5+\26\2\u01108\3\2\2\2\u0111\u0112\t\b\2\2\u0112:\3\2\2\2\u0113"+
		"\u0119\59\35\2\u0114\u0118\59\35\2\u0115\u0118\5#\22\2\u0116\u0118\7a"+
		"\2\2\u0117\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a<\3\2\2\2"+
		"\u011b\u0119\3\2\2\2\u011c\u011d\7\61\2\2\u011d\u011e\7,\2\2\u011e\u0122"+
		"\3\2\2\2\u011f\u0121\13\2\2\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0125\u0126\7,\2\2\u0126\u0127\7\61\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\b\37\2\2\u0129>\3\2\2\2\u012a\u012b\7\61\2\2\u012b\u012c\7\61\2"+
		"\2\u012c\u0130\3\2\2\2\u012d\u012f\n\t\2\2\u012e\u012d\3\2\2\2\u012f\u0132"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0134\b \2\2\u0134@\3\2\2\2\u0135\u0137\t\n\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b!\2\2\u013bB\3\2\2\2\24\2\u00a9"+
		"\u00b5\u00bd\u00df\u00ea\u00f1\u00f4\u00fa\u00fe\u0100\u0106\u010c\u0117"+
		"\u0119\u0122\u0130\u0138\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}