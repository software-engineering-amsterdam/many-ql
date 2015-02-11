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
		T__17=18, T__18=19, QuestionType=20, Identifier=21, Boolean=22, Date=23, 
		Integer=24, Decimal=25, String=26, Comment=27, LineComment=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "QuestionType", "Identifier", "Boolean", "Date", "Integer", 
		"Decimal", "String", "Epsilon", "Letter", "Lowercase", "Uppercase", "Digit", 
		"NonZeroDigit", "ZeroDigit", "Year", "Month", "Day", "Quotes", "Comment", 
		"LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'*'", 
		"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "QuestionType", "Identifier", 
		"Boolean", "Date", "Integer", "Decimal", "String", "Comment", "LineComment", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u0137\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00a3\n\25\3\26\3\26\3\26\3\26\7\26\u00a9\n\26\f\26\16"+
		"\26\u00ac\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00b7"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00d1\n\30"+
		"\3\31\3\31\3\31\7\31\u00d6\n\31\f\31\16\31\u00d9\13\31\5\31\u00db\n\31"+
		"\3\32\3\32\3\32\7\32\u00e0\n\32\f\32\16\32\u00e3\13\32\3\32\5\32\u00e6"+
		"\n\32\3\32\3\32\6\32\u00ea\n\32\r\32\16\32\u00eb\3\33\3\33\3\33\7\33\u00f1"+
		"\n\33\f\33\16\33\u00f4\13\33\3\33\5\33\u00f7\n\33\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\5\35\u00ff\n\35\3\36\3\36\3\37\3\37\3 \3 \5 \u0107\n \3!\3"+
		"!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\7\'\u011c\n"+
		"\'\f\'\16\'\u011f\13\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u012a\n(\f("+
		"\16(\u012d\13(\3(\3(\3)\6)\u0132\n)\r)\16)\u0133\3)\3)\4\u00f2\u011d\2"+
		"*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\29\2;\2="+
		"\2?\2A\2C\2E\2G\2I\2K\2M\35O\36Q\37\3\2\f\4\2))^^\3\2c|\4\2C\\c|\3\2\63"+
		";\3\2\62\62\3\2\63\64\3\2\63\65\5\2$$))\u201e\u201f\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\u0142\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2M\3\2"+
		"\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5X\3\2\2\2\7Z\3\2\2\2\t\\\3\2\2"+
		"\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23g\3\2\2\2\25i\3\2"+
		"\2\2\27k\3\2\2\2\31m\3\2\2\2\33o\3\2\2\2\35q\3\2\2\2\37t\3\2\2\2!w\3\2"+
		"\2\2#z\3\2\2\2%}\3\2\2\2\'\u0080\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3\2\2\2"+
		"-\u00b6\3\2\2\2/\u00b8\3\2\2\2\61\u00da\3\2\2\2\63\u00e5\3\2\2\2\65\u00ed"+
		"\3\2\2\2\67\u00fa\3\2\2\29\u00fe\3\2\2\2;\u0100\3\2\2\2=\u0102\3\2\2\2"+
		"?\u0106\3\2\2\2A\u0108\3\2\2\2C\u010a\3\2\2\2E\u010c\3\2\2\2G\u0111\3"+
		"\2\2\2I\u0113\3\2\2\2K\u0115\3\2\2\2M\u0117\3\2\2\2O\u0125\3\2\2\2Q\u0131"+
		"\3\2\2\2ST\7h\2\2TU\7q\2\2UV\7t\2\2VW\7o\2\2W\4\3\2\2\2XY\7}\2\2Y\6\3"+
		"\2\2\2Z[\7\177\2\2[\b\3\2\2\2\\]\7k\2\2]^\7h\2\2^\n\3\2\2\2_`\7*\2\2`"+
		"\f\3\2\2\2ab\7+\2\2b\16\3\2\2\2cd\7/\2\2d\20\3\2\2\2ef\7-\2\2f\22\3\2"+
		"\2\2gh\7,\2\2h\24\3\2\2\2ij\7\61\2\2j\26\3\2\2\2kl\7\'\2\2l\30\3\2\2\2"+
		"mn\7>\2\2n\32\3\2\2\2op\7@\2\2p\34\3\2\2\2qr\7>\2\2rs\7?\2\2s\36\3\2\2"+
		"\2tu\7@\2\2uv\7?\2\2v \3\2\2\2wx\7?\2\2xy\7?\2\2y\"\3\2\2\2z{\7#\2\2{"+
		"|\7?\2\2|$\3\2\2\2}~\7(\2\2~\177\7(\2\2\177&\3\2\2\2\u0080\u0081\7~\2"+
		"\2\u0081\u0082\7~\2\2\u0082(\3\2\2\2\u0083\u0084\7d\2\2\u0084\u0085\7"+
		"q\2\2\u0085\u0086\7q\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u00a3\7p\2\2\u008a\u008b\7f\2\2\u008b\u008c\7g\2\2\u008c"+
		"\u008d\7e\2\2\u008d\u008e\7k\2\2\u008e\u008f\7o\2\2\u008f\u0090\7c\2\2"+
		"\u0090\u00a3\7n\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094"+
		"\7v\2\2\u0094\u0095\7g\2\2\u0095\u0096\7i\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u00a3\7t\2\2\u0098\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a\u009b\7t\2\2"+
		"\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u00a3\7i\2\2\u009e\u009f"+
		"\7f\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a3\7g\2\2\u00a2"+
		"\u0083\3\2\2\2\u00a2\u008a\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0098\3\2"+
		"\2\2\u00a2\u009e\3\2\2\2\u00a3*\3\2\2\2\u00a4\u00aa\59\35\2\u00a5\u00a9"+
		"\59\35\2\u00a6\u00a9\5? \2\u00a7\u00a9\7a\2\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab,\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae"+
		"\7v\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7w\2\2\u00b0\u00b7\7g\2\2\u00b1"+
		"\u00b2\7h\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7u\2\2"+
		"\u00b5\u00b7\7g\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b7.\3\2"+
		"\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc"+
		"\7g\2\2\u00bc\u00bd\7<\2\2\u00bd\u00d0\3\2\2\2\u00be\u00bf\5I%\2\u00bf"+
		"\u00c0\7/\2\2\u00c0\u00c1\5G$\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\5E#\2\u00c3"+
		"\u00d1\3\2\2\2\u00c4\u00c5\5I%\2\u00c5\u00c6\7\60\2\2\u00c6\u00c7\5G$"+
		"\2\u00c7\u00c8\7\60\2\2\u00c8\u00c9\5E#\2\u00c9\u00d1\3\2\2\2\u00ca\u00cb"+
		"\5E#\2\u00cb\u00cc\7\61\2\2\u00cc\u00cd\5G$\2\u00cd\u00ce\7\61\2\2\u00ce"+
		"\u00cf\5I%\2\u00cf\u00d1\3\2\2\2\u00d0\u00be\3\2\2\2\u00d0\u00c4\3\2\2"+
		"\2\u00d0\u00ca\3\2\2\2\u00d1\60\3\2\2\2\u00d2\u00db\5C\"\2\u00d3\u00d7"+
		"\5A!\2\u00d4\u00d6\5? \2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00d2\3\2\2\2\u00da\u00d3\3\2\2\2\u00db\62\3\2\2\2\u00dc\u00e6"+
		"\5\67\34\2\u00dd\u00e1\5A!\2\u00de\u00e0\5? \2\u00df\u00de\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6\5C\"\2\u00e5\u00dc\3\2\2\2\u00e5"+
		"\u00dd\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\7\60"+
		"\2\2\u00e8\u00ea\5? \2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\64\3\2\2\2\u00ed\u00f6\5K&\2\u00ee"+
		"\u00f7\5\67\34\2\u00ef\u00f1\13\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f7\n\2\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00f2\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\5K&\2\u00f9\66\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb8\3\2\2\2\u00fc\u00ff\5;\36\2\u00fd\u00ff\5=\37\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff:\3\2\2\2\u0100\u0101\t\3\2\2"+
		"\u0101<\3\2\2\2\u0102\u0103\t\4\2\2\u0103>\3\2\2\2\u0104\u0107\5C\"\2"+
		"\u0105\u0107\5A!\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107@\3\2"+
		"\2\2\u0108\u0109\t\5\2\2\u0109B\3\2\2\2\u010a\u010b\t\6\2\2\u010bD\3\2"+
		"\2\2\u010c\u010d\t\7\2\2\u010d\u010e\5? \2\u010e\u010f\5? \2\u010f\u0110"+
		"\5? \2\u0110F\3\2\2\2\u0111\u0112\t\7\2\2\u0112H\3\2\2\2\u0113\u0114\t"+
		"\b\2\2\u0114J\3\2\2\2\u0115\u0116\t\t\2\2\u0116L\3\2\2\2\u0117\u0118\7"+
		"\61\2\2\u0118\u0119\7,\2\2\u0119\u011d\3\2\2\2\u011a\u011c\13\2\2\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011e\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7,\2\2\u0121"+
		"\u0122\7\61\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b\'\2\2\u0124N\3\2\2\2"+
		"\u0125\u0126\7\61\2\2\u0126\u0127\7\61\2\2\u0127\u012b\3\2\2\2\u0128\u012a"+
		"\n\n\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\b("+
		"\2\2\u012fP\3\2\2\2\u0130\u0132\t\13\2\2\u0131\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\b)\2\2\u0136R\3\2\2\2\24\2\u00a2\u00a8\u00aa\u00b6\u00d0\u00d7"+
		"\u00da\u00e1\u00e5\u00eb\u00f2\u00f6\u00fe\u0106\u011d\u012b\u0133\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}