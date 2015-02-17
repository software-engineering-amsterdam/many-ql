// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/ql/syntax/QL.g4 by ANTLR 4.5
package lang.ql.gen;
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, QuestionType=20, Boolean=21, Identifier=22, Date=23, 
		Integer=24, Decimal=25, String=26, Comment=27, LineComment=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "QuestionType", "Boolean", "Identifier", "Date", "Integer", 
		"Decimal", "String", "StringCharacter", "EscapeSequence", "Epsilon", "Letter", 
		"Lowercase", "Uppercase", "Digit", "NonZeroDigit", "ZeroDigit", "Year", 
		"Month", "Day", "Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'*'", 
		"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "QuestionType", "Boolean", 
		"Identifier", "Date", "Integer", "Decimal", "String", "Comment", "LineComment", 
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


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u014b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00a5\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00b0\n\26\3\27\3\27\3\27\3\27\7\27\u00b6\n\27\f\27\16\27\u00b9"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00d3\n\30"+
		"\3\31\3\31\3\31\7\31\u00d8\n\31\f\31\16\31\u00db\13\31\5\31\u00dd\n\31"+
		"\3\32\3\32\3\32\7\32\u00e2\n\32\f\32\16\32\u00e5\13\32\3\32\5\32\u00e8"+
		"\n\32\3\32\3\32\6\32\u00ec\n\32\r\32\16\32\u00ed\3\33\3\33\6\33\u00f2"+
		"\n\33\r\33\16\33\u00f3\3\33\3\33\3\33\3\33\6\33\u00fa\n\33\r\33\16\33"+
		"\u00fb\3\33\3\33\3\33\3\33\6\33\u0102\n\33\r\33\16\33\u0103\3\33\3\33"+
		"\5\33\u0108\n\33\3\34\3\34\5\34\u010c\n\34\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\5\37\u0115\n\37\3 \3 \3!\3!\3\"\3\"\5\"\u011d\n\"\3#\3#\3$\3"+
		"$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\7(\u0130\n(\f(\16(\u0133\13"+
		"(\3(\3(\3(\3(\3(\3)\3)\3)\3)\7)\u013e\n)\f)\16)\u0141\13)\3)\3)\3*\6*"+
		"\u0146\n*\r*\16*\u0147\3*\3*\6\u00f3\u00fb\u0103\u0131\2+\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\29\2;\2=\2?\2A\2C\2E\2"+
		"G\2I\2K\2M\2O\35Q\36S\37\3\2\f\3\2^^\7\2$$))^^pp\u201e\u201f\3\2c|\4\2"+
		"C\\c|\3\2\63;\3\2\62\62\3\2\63\64\3\2\63\65\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\u0159\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\3U\3\2\2\2\5Z\3\2\2\2\7\\\3\2\2\2\t^\3\2\2\2\13a\3\2\2"+
		"\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2"+
		"\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37v\3\2\2\2!y\3\2\2\2#|\3\2\2"+
		"\2%\177\3\2\2\2\'\u0082\3\2\2\2)\u00a4\3\2\2\2+\u00af\3\2\2\2-\u00b1\3"+
		"\2\2\2/\u00ba\3\2\2\2\61\u00dc\3\2\2\2\63\u00e7\3\2\2\2\65\u0107\3\2\2"+
		"\2\67\u010b\3\2\2\29\u010d\3\2\2\2;\u0110\3\2\2\2=\u0114\3\2\2\2?\u0116"+
		"\3\2\2\2A\u0118\3\2\2\2C\u011c\3\2\2\2E\u011e\3\2\2\2G\u0120\3\2\2\2I"+
		"\u0122\3\2\2\2K\u0127\3\2\2\2M\u0129\3\2\2\2O\u012b\3\2\2\2Q\u0139\3\2"+
		"\2\2S\u0145\3\2\2\2UV\7h\2\2VW\7q\2\2WX\7t\2\2XY\7o\2\2Y\4\3\2\2\2Z[\7"+
		"}\2\2[\6\3\2\2\2\\]\7\177\2\2]\b\3\2\2\2^_\7k\2\2_`\7h\2\2`\n\3\2\2\2"+
		"ab\7*\2\2b\f\3\2\2\2cd\7+\2\2d\16\3\2\2\2ef\7/\2\2f\20\3\2\2\2gh\7-\2"+
		"\2h\22\3\2\2\2ij\7,\2\2j\24\3\2\2\2kl\7\61\2\2l\26\3\2\2\2mn\7\'\2\2n"+
		"\30\3\2\2\2op\7>\2\2p\32\3\2\2\2qr\7@\2\2r\34\3\2\2\2st\7>\2\2tu\7?\2"+
		"\2u\36\3\2\2\2vw\7@\2\2wx\7?\2\2x \3\2\2\2yz\7?\2\2z{\7?\2\2{\"\3\2\2"+
		"\2|}\7#\2\2}~\7?\2\2~$\3\2\2\2\177\u0080\7(\2\2\u0080\u0081\7(\2\2\u0081"+
		"&\3\2\2\2\u0082\u0083\7~\2\2\u0083\u0084\7~\2\2\u0084(\3\2\2\2\u0085\u0086"+
		"\7d\2\2\u0086\u0087\7q\2\2\u0087\u0088\7q\2\2\u0088\u0089\7n\2\2\u0089"+
		"\u008a\7g\2\2\u008a\u008b\7c\2\2\u008b\u00a5\7p\2\2\u008c\u008d\7f\2\2"+
		"\u008d\u008e\7g\2\2\u008e\u008f\7e\2\2\u008f\u0090\7k\2\2\u0090\u0091"+
		"\7o\2\2\u0091\u0092\7c\2\2\u0092\u00a5\7n\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7v\2\2\u0096\u0097\7g\2\2\u0097\u0098\7i\2\2"+
		"\u0098\u0099\7g\2\2\u0099\u00a5\7t\2\2\u009a\u009b\7u\2\2\u009b\u009c"+
		"\7v\2\2\u009c\u009d\7t\2\2\u009d\u009e\7k\2\2\u009e\u009f\7p\2\2\u009f"+
		"\u00a5\7i\2\2\u00a0\u00a1\7f\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7v\2\2"+
		"\u00a3\u00a5\7g\2\2\u00a4\u0085\3\2\2\2\u00a4\u008c\3\2\2\2\u00a4\u0093"+
		"\3\2\2\2\u00a4\u009a\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a5*\3\2\2\2\u00a6"+
		"\u00a7\7v\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9\u00b0\7g\2\2"+
		"\u00aa\u00ab\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae"+
		"\7u\2\2\u00ae\u00b0\7g\2\2\u00af\u00a6\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0"+
		",\3\2\2\2\u00b1\u00b7\5=\37\2\u00b2\u00b6\5=\37\2\u00b3\u00b6\5C\"\2\u00b4"+
		"\u00b6\7a\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2"+
		"\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		".\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7c\2\2\u00bc"+
		"\u00bd\7v\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7<\2\2\u00bf\u00d2\3\2\2"+
		"\2\u00c0\u00c1\5M\'\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\5K&\2\u00c3\u00c4"+
		"\7/\2\2\u00c4\u00c5\5I%\2\u00c5\u00d3\3\2\2\2\u00c6\u00c7\5M\'\2\u00c7"+
		"\u00c8\7\60\2\2\u00c8\u00c9\5K&\2\u00c9\u00ca\7\60\2\2\u00ca\u00cb\5I"+
		"%\2\u00cb\u00d3\3\2\2\2\u00cc\u00cd\5I%\2\u00cd\u00ce\7\61\2\2\u00ce\u00cf"+
		"\5K&\2\u00cf\u00d0\7\61\2\2\u00d0\u00d1\5M\'\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00c0\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d3\60\3\2\2"+
		"\2\u00d4\u00dd\5G$\2\u00d5\u00d9\5E#\2\u00d6\u00d8\5C\"\2\u00d7\u00d6"+
		"\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc\u00d5\3\2"+
		"\2\2\u00dd\62\3\2\2\2\u00de\u00e8\5;\36\2\u00df\u00e3\5E#\2\u00e0\u00e2"+
		"\5C\"\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\5G"+
		"$\2\u00e7\u00de\3\2\2\2\u00e7\u00df\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00eb\7\60\2\2\u00ea\u00ec\5C\"\2\u00eb\u00ea\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\64\3\2\2\2\u00ef\u00f1\7$\2\2\u00f0\u00f2\5\67\34\2\u00f1\u00f0\3\2\2"+
		"\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\7$\2\2\u00f6\u0108\3\2\2\2\u00f7\u00f9\7)\2\2\u00f8"+
		"\u00fa\5\67\34\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7)\2\2\u00fe"+
		"\u0108\3\2\2\2\u00ff\u0101\7\u201e\2\2\u0100\u0102\5\67\34\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\7\u201f\2\2\u0106\u0108\3\2\2\2\u0107\u00ef"+
		"\3\2\2\2\u0107\u00f7\3\2\2\2\u0107\u00ff\3\2\2\2\u0108\66\3\2\2\2\u0109"+
		"\u010c\n\2\2\2\u010a\u010c\59\35\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2"+
		"\2\2\u010c8\3\2\2\2\u010d\u010e\7^\2\2\u010e\u010f\t\3\2\2\u010f:\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111<\3\2\2\2\u0112\u0115\5? \2\u0113\u0115"+
		"\5A!\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115>\3\2\2\2\u0116\u0117"+
		"\t\4\2\2\u0117@\3\2\2\2\u0118\u0119\t\5\2\2\u0119B\3\2\2\2\u011a\u011d"+
		"\5G$\2\u011b\u011d\5E#\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d"+
		"D\3\2\2\2\u011e\u011f\t\6\2\2\u011fF\3\2\2\2\u0120\u0121\t\7\2\2\u0121"+
		"H\3\2\2\2\u0122\u0123\t\b\2\2\u0123\u0124\5C\"\2\u0124\u0125\5C\"\2\u0125"+
		"\u0126\5C\"\2\u0126J\3\2\2\2\u0127\u0128\t\b\2\2\u0128L\3\2\2\2\u0129"+
		"\u012a\t\t\2\2\u012aN\3\2\2\2\u012b\u012c\7\61\2\2\u012c\u012d\7,\2\2"+
		"\u012d\u0131\3\2\2\2\u012e\u0130\13\2\2\2\u012f\u012e\3\2\2\2\u0130\u0133"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\7,\2\2\u0135\u0136\7\61\2\2\u0136\u0137\3\2"+
		"\2\2\u0137\u0138\b(\2\2\u0138P\3\2\2\2\u0139\u013a\7\61\2\2\u013a\u013b"+
		"\7\61\2\2\u013b\u013f\3\2\2\2\u013c\u013e\n\n\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142"+
		"\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\b)\2\2\u0143R\3\2\2\2\u0144\u0146"+
		"\t\13\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b*\2\2\u014aT\3\2"+
		"\2\2\27\2\u00a4\u00af\u00b5\u00b7\u00d2\u00d9\u00dc\u00e3\u00e7\u00ed"+
		"\u00f3\u00fb\u0103\u0107\u010b\u0114\u011c\u0131\u013f\u0147\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}