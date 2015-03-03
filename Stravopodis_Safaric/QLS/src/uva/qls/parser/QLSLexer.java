// Generated from QLS.g4 by ANTLR 4.5

	package uva.qls.parser;

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
		T__17=18, BooleanLiteral=19, Identifier=20, Integer=21, Decimal=22, WS=23, 
		ID_LETTER=24, DIGIT=25, STRING=26, LINE_COMMENT=27, COMMENT=28, WIDGET=29, 
		WIDTH=30, HEIGHT=31, FONT=32, FONTSIZE=33, COLOR=34, NEWLINE=35, TAB=36, 
		LP=37, RP=38, LC=39, RC=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "BooleanLiteral", "Identifier", "Integer", "Decimal", "WS", "ID_LETTER", 
		"DIGIT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "WIDGET", "WIDTH", 
		"HEIGHT", "FONT", "FONTSIZE", "COLOR", "NEWLINE", "TAB", "LP", "RP", "LC", 
		"RC"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'section'", "'subsection '", "'question'", 
		"'default'", "':'", "'text'", "'spinbox'", "'slider'", "','", "'dropdown'", 
		"'radio'", "'checkbox'", "'boolean'", "'decimal'", "'string'", "'int'", 
		null, null, null, null, null, null, null, null, null, null, "'widget'", 
		"'width'", "'height'", "'font'", "'fontsize'", "'color'", "'\n'", "'\t'", 
		"'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "BooleanLiteral", "Identifier", 
		"Integer", "Decimal", "WS", "ID_LETTER", "DIGIT", "STRING", "LINE_COMMENT", 
		"COMMENT", "WIDGET", "WIDTH", "HEIGHT", "FONT", "FONTSIZE", "COLOR", "NEWLINE", 
		"TAB", "LP", "RP", "LC", "RC"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0175\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00df\n\24\3\25\3\25\3\25"+
		"\7\25\u00e4\n\25\f\25\16\25\u00e7\13\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00f0\n\26\3\27\3\27\5\27\u00f4\n\27\3\27\6\27\u00f7\n\27\r"+
		"\27\16\27\u00f8\3\27\3\27\7\27\u00fd\n\27\f\27\16\27\u0100\13\27\3\27"+
		"\5\27\u0103\n\27\3\30\3\30\3\30\5\30\u0108\n\30\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\32\7\32\u0111\n\32\f\32\16\32\u0114\13\32\5\32\u0116\n\32\3"+
		"\33\3\33\3\33\7\33\u011b\n\33\f\33\16\33\u011e\13\33\3\33\3\33\3\34\3"+
		"\34\3\34\5\34\u0125\n\34\3\35\3\35\3\35\3\35\7\35\u012b\n\35\f\35\16\35"+
		"\u012e\13\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u0138\n\36\f"+
		"\36\16\36\u013b\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\5\u011c\u012c\u0139\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\29\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*\3\2\5"+
		"\5\2C\\aac|\3\2\63;\3\2\62;\u0184\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5`\3\2\2\2\7e\3\2\2\2\tm\3\2\2\2\13y\3"+
		"\2\2\2\r\u0082\3\2\2\2\17\u008a\3\2\2\2\21\u008c\3\2\2\2\23\u0091\3\2"+
		"\2\2\25\u0099\3\2\2\2\27\u00a0\3\2\2\2\31\u00a2\3\2\2\2\33\u00ab\3\2\2"+
		"\2\35\u00b1\3\2\2\2\37\u00ba\3\2\2\2!\u00c2\3\2\2\2#\u00ca\3\2\2\2%\u00d1"+
		"\3\2\2\2\'\u00de\3\2\2\2)\u00e0\3\2\2\2+\u00ef\3\2\2\2-\u00f3\3\2\2\2"+
		"/\u0107\3\2\2\2\61\u010b\3\2\2\2\63\u0115\3\2\2\2\65\u0117\3\2\2\2\67"+
		"\u0124\3\2\2\29\u0126\3\2\2\2;\u0133\3\2\2\2=\u0141\3\2\2\2?\u0148\3\2"+
		"\2\2A\u014e\3\2\2\2C\u0155\3\2\2\2E\u015a\3\2\2\2G\u0163\3\2\2\2I\u0169"+
		"\3\2\2\2K\u016b\3\2\2\2M\u016d\3\2\2\2O\u016f\3\2\2\2Q\u0171\3\2\2\2S"+
		"\u0173\3\2\2\2UV\7u\2\2VW\7v\2\2WX\7{\2\2XY\7n\2\2YZ\7g\2\2Z[\7u\2\2["+
		"\\\7j\2\2\\]\7g\2\2]^\7g\2\2^_\7v\2\2_\4\3\2\2\2`a\7r\2\2ab\7c\2\2bc\7"+
		"i\2\2cd\7g\2\2d\6\3\2\2\2ef\7u\2\2fg\7g\2\2gh\7e\2\2hi\7v\2\2ij\7k\2\2"+
		"jk\7q\2\2kl\7p\2\2l\b\3\2\2\2mn\7u\2\2no\7w\2\2op\7d\2\2pq\7u\2\2qr\7"+
		"g\2\2rs\7e\2\2st\7v\2\2tu\7k\2\2uv\7q\2\2vw\7p\2\2wx\7\"\2\2x\n\3\2\2"+
		"\2yz\7s\2\2z{\7w\2\2{|\7g\2\2|}\7u\2\2}~\7v\2\2~\177\7k\2\2\177\u0080"+
		"\7q\2\2\u0080\u0081\7p\2\2\u0081\f\3\2\2\2\u0082\u0083\7f\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7h\2\2\u0085\u0086\7c\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u0088\7n\2\2\u0088\u0089\7v\2\2\u0089\16\3\2\2\2\u008a\u008b\7<\2\2\u008b"+
		"\20\3\2\2\2\u008c\u008d\7v\2\2\u008d\u008e\7g\2\2\u008e\u008f\7z\2\2\u008f"+
		"\u0090\7v\2\2\u0090\22\3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093\7r\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095\u0096\7d\2\2\u0096\u0097\7q\2\2"+
		"\u0097\u0098\7z\2\2\u0098\24\3\2\2\2\u0099\u009a\7u\2\2\u009a\u009b\7"+
		"n\2\2\u009b\u009c\7k\2\2\u009c\u009d\7f\2\2\u009d\u009e\7g\2\2\u009e\u009f"+
		"\7t\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7.\2\2\u00a1\30\3\2\2\2\u00a2\u00a3"+
		"\7f\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7r\2\2\u00a6"+
		"\u00a7\7f\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7y\2\2\u00a9\u00aa\7p\2\2"+
		"\u00aa\32\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7"+
		"f\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7q\2\2\u00b0\34\3\2\2\2\u00b1\u00b2"+
		"\7e\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7e\2\2\u00b5"+
		"\u00b6\7m\2\2\u00b6\u00b7\7d\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7z\2\2"+
		"\u00b9\36\3\2\2\2\u00ba\u00bb\7d\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7"+
		"q\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1 \3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5"+
		"\7e\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7o\2\2\u00c7\u00c8\7c\2\2\u00c8"+
		"\u00c9\7n\2\2\u00c9\"\3\2\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7v\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7i\2\2"+
		"\u00d0$\3\2\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7v\2"+
		"\2\u00d4&\3\2\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7"+
		"w\2\2\u00d8\u00df\7g\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7c\2\2\u00db\u00dc"+
		"\7n\2\2\u00dc\u00dd\7u\2\2\u00dd\u00df\7g\2\2\u00de\u00d5\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00df(\3\2\2\2\u00e0\u00e5\5\61\31\2\u00e1\u00e4\5\61\31"+
		"\2\u00e2\u00e4\5\63\32\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6*\3\2\2\2"+
		"\u00e7\u00e5\3\2\2\2\u00e8\u00f0\5\63\32\2\u00e9\u00ea\7*\2\2\u00ea\u00eb"+
		"\7/\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\5\63\32\2\u00ed\u00ee\7+\2\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00e9\3\2\2\2\u00f0,\3\2\2\2"+
		"\u00f1\u00f2\7*\2\2\u00f2\u00f4\7/\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f7\5\63\32\2\u00f6\u00f5\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fe\7\60\2\2\u00fb\u00fd\5\63\32\2\u00fc\u00fb\3\2\2"+
		"\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\7+\2\2\u0102\u0101\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103.\3\2\2\2\u0104\u0108\7\"\2\2\u0105\u0108\5I%\2\u0106"+
		"\u0108\5K&\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2"+
		"\2\u0108\u0109\3\2\2\2\u0109\u010a\b\30\2\2\u010a\60\3\2\2\2\u010b\u010c"+
		"\t\2\2\2\u010c\62\3\2\2\2\u010d\u0116\7\62\2\2\u010e\u0112\t\3\2\2\u010f"+
		"\u0111\t\4\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u010d\3\2\2\2\u0115\u010e\3\2\2\2\u0116\64\3\2\2\2\u0117\u011c\7$\2\2"+
		"\u0118\u011b\5\67\34\2\u0119\u011b\13\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011d\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011d\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\7$\2\2\u0120"+
		"\66\3\2\2\2\u0121\u0125\7^\2\2\u0122\u0123\7^\2\2\u0123\u0125\7^\2\2\u0124"+
		"\u0121\3\2\2\2\u0124\u0122\3\2\2\2\u01258\3\2\2\2\u0126\u0127\7\61\2\2"+
		"\u0127\u0128\7\61\2\2\u0128\u012c\3\2\2\2\u0129\u012b\13\2\2\2\u012a\u0129"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\7\f\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0132\b\35\2\2\u0132:\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135"+
		"\7,\2\2\u0135\u0139\3\2\2\2\u0136\u0138\13\2\2\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013b\3\2\2\2\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\61\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0140\b\36\2\2\u0140<\3\2\2\2\u0141\u0142\7y\2\2"+
		"\u0142\u0143\7k\2\2\u0143\u0144\7f\2\2\u0144\u0145\7i\2\2\u0145\u0146"+
		"\7g\2\2\u0146\u0147\7v\2\2\u0147>\3\2\2\2\u0148\u0149\7y\2\2\u0149\u014a"+
		"\7k\2\2\u014a\u014b\7f\2\2\u014b\u014c\7v\2\2\u014c\u014d\7j\2\2\u014d"+
		"@\3\2\2\2\u014e\u014f\7j\2\2\u014f\u0150\7g\2\2\u0150\u0151\7k\2\2\u0151"+
		"\u0152\7i\2\2\u0152\u0153\7j\2\2\u0153\u0154\7v\2\2\u0154B\3\2\2\2\u0155"+
		"\u0156\7h\2\2\u0156\u0157\7q\2\2\u0157\u0158\7p\2\2\u0158\u0159\7v\2\2"+
		"\u0159D\3\2\2\2\u015a\u015b\7h\2\2\u015b\u015c\7q\2\2\u015c\u015d\7p\2"+
		"\2\u015d\u015e\7v\2\2\u015e\u015f\7u\2\2\u015f\u0160\7k\2\2\u0160\u0161"+
		"\7|\2\2\u0161\u0162\7g\2\2\u0162F\3\2\2\2\u0163\u0164\7e\2\2\u0164\u0165"+
		"\7q\2\2\u0165\u0166\7n\2\2\u0166\u0167\7q\2\2\u0167\u0168\7t\2\2\u0168"+
		"H\3\2\2\2\u0169\u016a\7\f\2\2\u016aJ\3\2\2\2\u016b\u016c\7\13\2\2\u016c"+
		"L\3\2\2\2\u016d\u016e\7*\2\2\u016eN\3\2\2\2\u016f\u0170\7+\2\2\u0170P"+
		"\3\2\2\2\u0171\u0172\7}\2\2\u0172R\3\2\2\2\u0173\u0174\7\177\2\2\u0174"+
		"T\3\2\2\2\23\2\u00de\u00e3\u00e5\u00ef\u00f3\u00f8\u00fe\u0102\u0107\u0112"+
		"\u0115\u011a\u011c\u0124\u012c\u0139\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}