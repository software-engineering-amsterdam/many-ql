// Generated from nl\u005Cuva\bromance\parsers\QL.g4 by ANTLR 4.5
package nl.uva.bromance.parsers;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, TIMES=27, DIVISION=28, ADDITION=29, SUBTRACTION=30, 
		SMALLETHANOREQUAL=31, BIGGERTHANOREQUAL=32, BIGGERTHAN=33, SMALLERTHAN=34, 
		EQUALTO=35, NOTEQUALTO=36, AND=37, OR=38, STRING=39, NUMBER=40, TEXT=41, 
		COMMENT=42, WS=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "TIMES", "DIVISION", "ADDITION", "SUBTRACTION", "SMALLETHANOREQUAL", 
		"BIGGERTHANOREQUAL", "BIGGERTHAN", "SMALLERTHAN", "EQUALTO", "NOTEQUALTO", 
		"AND", "OR", "STRING", "ESC", "UNICODE", "HEX", "NUMBER", "INT", "EXP", 
		"NL", "TEXT", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Name:'", "'{'", "'}'", "'Form:'", "'Question:'", "'Text:'", "'Answer:'", 
		"'integer'", "'Integer'", "'boolean'", "'Boolean'", "'double'", "'Double'", 
		"'string'", "'String'", "'['", "']'", "'Range:'", "'Calculation:'", "'If:'", 
		"'Else:'", "'Else If:'", "'Label:'", "'Input:'", "'('", "')'", "'*'", 
		"'/'", "'+'", "'-'", "'<='", "'>='", "'>'", "'<'", "'=='", "'!='", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "TIMES", "DIVISION", "ADDITION", "SUBTRACTION", "SMALLETHANOREQUAL", 
		"BIGGERTHANOREQUAL", "BIGGERTHAN", "SMALLERTHAN", "EQUALTO", "NOTEQUALTO", 
		"AND", "OR", "STRING", "NUMBER", "TEXT", "COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u0180\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\7("+
		"\u0128\n(\f(\16(\u012b\13(\3(\3(\3)\3)\3)\5)\u0132\n)\3*\3*\3*\3*\3*\3"+
		"*\3+\3+\3,\5,\u013d\n,\3,\3,\3,\6,\u0142\n,\r,\16,\u0143\3,\5,\u0147\n"+
		",\3,\5,\u014a\n,\3,\3,\3,\3,\5,\u0150\n,\3,\5,\u0153\n,\3-\3-\3-\7-\u0158"+
		"\n-\f-\16-\u015b\13-\5-\u015d\n-\3.\3.\5.\u0161\n.\3.\3.\3/\3/\3/\5/\u0168"+
		"\n/\3\60\6\60\u016b\n\60\r\60\16\60\u016c\3\61\3\61\3\61\3\61\7\61\u0173"+
		"\n\61\f\61\16\61\u0176\13\61\3\61\3\61\3\62\6\62\u017b\n\62\r\62\16\62"+
		"\u017c\3\62\3\62\2\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U\2W*Y\2[\2]\2_+a,"+
		"c-\3\2\f\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\3\2\62;\3\2\63;\4"+
		"\2GGgg\4\2--//\4\2\f\f\17\17\b\2\60\60\62;C\\^^aac|\5\2\13\f\17\17\"\""+
		"\u018a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2W\3\2\2\2\2_\3"+
		"\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2"+
		"\2\13u\3\2\2\2\r\177\3\2\2\2\17\u0085\3\2\2\2\21\u008d\3\2\2\2\23\u0095"+
		"\3\2\2\2\25\u009d\3\2\2\2\27\u00a5\3\2\2\2\31\u00ad\3\2\2\2\33\u00b4\3"+
		"\2\2\2\35\u00bb\3\2\2\2\37\u00c2\3\2\2\2!\u00c9\3\2\2\2#\u00cb\3\2\2\2"+
		"%\u00cd\3\2\2\2\'\u00d4\3\2\2\2)\u00e1\3\2\2\2+\u00e5\3\2\2\2-\u00eb\3"+
		"\2\2\2/\u00f4\3\2\2\2\61\u00fb\3\2\2\2\63\u0102\3\2\2\2\65\u0104\3\2\2"+
		"\2\67\u0106\3\2\2\29\u0108\3\2\2\2;\u010a\3\2\2\2=\u010c\3\2\2\2?\u010e"+
		"\3\2\2\2A\u0111\3\2\2\2C\u0114\3\2\2\2E\u0116\3\2\2\2G\u0118\3\2\2\2I"+
		"\u011b\3\2\2\2K\u011e\3\2\2\2M\u0121\3\2\2\2O\u0124\3\2\2\2Q\u012e\3\2"+
		"\2\2S\u0133\3\2\2\2U\u0139\3\2\2\2W\u0152\3\2\2\2Y\u015c\3\2\2\2[\u015e"+
		"\3\2\2\2]\u0167\3\2\2\2_\u016a\3\2\2\2a\u016e\3\2\2\2c\u017a\3\2\2\2e"+
		"f\7P\2\2fg\7c\2\2gh\7o\2\2hi\7g\2\2ij\7<\2\2j\4\3\2\2\2kl\7}\2\2l\6\3"+
		"\2\2\2mn\7\177\2\2n\b\3\2\2\2op\7H\2\2pq\7q\2\2qr\7t\2\2rs\7o\2\2st\7"+
		"<\2\2t\n\3\2\2\2uv\7S\2\2vw\7w\2\2wx\7g\2\2xy\7u\2\2yz\7v\2\2z{\7k\2\2"+
		"{|\7q\2\2|}\7p\2\2}~\7<\2\2~\f\3\2\2\2\177\u0080\7V\2\2\u0080\u0081\7"+
		"g\2\2\u0081\u0082\7z\2\2\u0082\u0083\7v\2\2\u0083\u0084\7<\2\2\u0084\16"+
		"\3\2\2\2\u0085\u0086\7C\2\2\u0086\u0087\7p\2\2\u0087\u0088\7u\2\2\u0088"+
		"\u0089\7y\2\2\u0089\u008a\7g\2\2\u008a\u008b\7t\2\2\u008b\u008c\7<\2\2"+
		"\u008c\20\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090\7"+
		"v\2\2\u0090\u0091\7g\2\2\u0091\u0092\7i\2\2\u0092\u0093\7g\2\2\u0093\u0094"+
		"\7t\2\2\u0094\22\3\2\2\2\u0095\u0096\7K\2\2\u0096\u0097\7p\2\2\u0097\u0098"+
		"\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7i\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7t\2\2\u009c\24\3\2\2\2\u009d\u009e\7d\2\2\u009e\u009f\7q\2\2\u009f"+
		"\u00a0\7q\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7c\2\2"+
		"\u00a3\u00a4\7p\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\7D\2\2\u00a6\u00a7\7"+
		"q\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7c\2\2\u00ab\u00ac\7p\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7f\2\2\u00ae\u00af"+
		"\7q\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7d\2\2\u00b1\u00b2\7n\2\2\u00b2"+
		"\u00b3\7g\2\2\u00b3\32\3\2\2\2\u00b4\u00b5\7F\2\2\u00b5\u00b6\7q\2\2\u00b6"+
		"\u00b7\7w\2\2\u00b7\u00b8\7d\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7g\2\2"+
		"\u00ba\34\3\2\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7"+
		"t\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7i\2\2\u00c1\36"+
		"\3\2\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7t\2\2\u00c5"+
		"\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7i\2\2\u00c8 \3\2\2\2\u00c9"+
		"\u00ca\7]\2\2\u00ca\"\3\2\2\2\u00cb\u00cc\7_\2\2\u00cc$\3\2\2\2\u00cd"+
		"\u00ce\7T\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7i\2\2"+
		"\u00d1\u00d2\7g\2\2\u00d2\u00d3\7<\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7E\2"+
		"\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9"+
		"\7w\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\u00dd\7k\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7<\2\2"+
		"\u00e0(\3\2\2\2\u00e1\u00e2\7K\2\2\u00e2\u00e3\7h\2\2\u00e3\u00e4\7<\2"+
		"\2\u00e4*\3\2\2\2\u00e5\u00e6\7G\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7"+
		"u\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7<\2\2\u00ea,\3\2\2\2\u00eb\u00ec"+
		"\7G\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00ef"+
		"\u00f0\7\"\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7h\2\2\u00f2\u00f3\7<\2"+
		"\2\u00f3.\3\2\2\2\u00f4\u00f5\7N\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7"+
		"d\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7<\2\2\u00fa\60"+
		"\3\2\2\2\u00fb\u00fc\7K\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7r\2\2\u00fe"+
		"\u00ff\7w\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7<\2\2\u0101\62\3\2\2\2\u0102"+
		"\u0103\7*\2\2\u0103\64\3\2\2\2\u0104\u0105\7+\2\2\u0105\66\3\2\2\2\u0106"+
		"\u0107\7,\2\2\u01078\3\2\2\2\u0108\u0109\7\61\2\2\u0109:\3\2\2\2\u010a"+
		"\u010b\7-\2\2\u010b<\3\2\2\2\u010c\u010d\7/\2\2\u010d>\3\2\2\2\u010e\u010f"+
		"\7>\2\2\u010f\u0110\7?\2\2\u0110@\3\2\2\2\u0111\u0112\7@\2\2\u0112\u0113"+
		"\7?\2\2\u0113B\3\2\2\2\u0114\u0115\7@\2\2\u0115D\3\2\2\2\u0116\u0117\7"+
		">\2\2\u0117F\3\2\2\2\u0118\u0119\7?\2\2\u0119\u011a\7?\2\2\u011aH\3\2"+
		"\2\2\u011b\u011c\7#\2\2\u011c\u011d\7?\2\2\u011dJ\3\2\2\2\u011e\u011f"+
		"\7(\2\2\u011f\u0120\7(\2\2\u0120L\3\2\2\2\u0121\u0122\7~\2\2\u0122\u0123"+
		"\7~\2\2\u0123N\3\2\2\2\u0124\u0129\7$\2\2\u0125\u0128\5Q)\2\u0126\u0128"+
		"\n\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u012d\7$\2\2\u012dP\3\2\2\2\u012e\u0131\7^\2\2\u012f\u0132"+
		"\t\3\2\2\u0130\u0132\5S*\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2\2\2\u0132"+
		"R\3\2\2\2\u0133\u0134\7w\2\2\u0134\u0135\5U+\2\u0135\u0136\5U+\2\u0136"+
		"\u0137\5U+\2\u0137\u0138\5U+\2\u0138T\3\2\2\2\u0139\u013a\t\4\2\2\u013a"+
		"V\3\2\2\2\u013b\u013d\7/\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\5Y-\2\u013f\u0141\7\60\2\2\u0140\u0142\t\5"+
		"\2\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0147\5[.\2\u0146\u0145\3\2\2"+
		"\2\u0146\u0147\3\2\2\2\u0147\u0153\3\2\2\2\u0148\u014a\7/\2\2\u0149\u0148"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\5Y-\2\u014c"+
		"\u014d\5[.\2\u014d\u0153\3\2\2\2\u014e\u0150\7/\2\2\u014f\u014e\3\2\2"+
		"\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\5Y-\2\u0152\u013c"+
		"\3\2\2\2\u0152\u0149\3\2\2\2\u0152\u014f\3\2\2\2\u0153X\3\2\2\2\u0154"+
		"\u015d\7\62\2\2\u0155\u0159\t\6\2\2\u0156\u0158\t\5\2\2\u0157\u0156\3"+
		"\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0154\3\2\2\2\u015c\u0155\3\2"+
		"\2\2\u015dZ\3\2\2\2\u015e\u0160\t\7\2\2\u015f\u0161\t\b\2\2\u0160\u015f"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\5Y-\2\u0163"+
		"\\\3\2\2\2\u0164\u0165\7\17\2\2\u0165\u0168\7\f\2\2\u0166\u0168\t\t\2"+
		"\2\u0167\u0164\3\2\2\2\u0167\u0166\3\2\2\2\u0168^\3\2\2\2\u0169\u016b"+
		"\t\n\2\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d`\3\2\2\2\u016e\u016f\7\61\2\2\u016f\u0170\7\61\2"+
		"\2\u0170\u0174\3\2\2\2\u0171\u0173\n\t\2\2\u0172\u0171\3\2\2\2\u0173\u0176"+
		"\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0177\u0178\b\61\2\2\u0178b\3\2\2\2\u0179\u017b\t\13\2"+
		"\2\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\b\62\2\2\u017fd\3\2\2\2\23\2"+
		"\u0127\u0129\u0131\u013c\u0143\u0146\u0149\u014f\u0152\u0159\u015c\u0160"+
		"\u0167\u016c\u0174\u017c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}