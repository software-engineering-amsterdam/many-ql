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
		T__9=10, T__10=11, T__11=12, BooleanLiteral=13, Width=14, Height=15, Font=16, 
		Fontsize=17, Color=18, Widget=19, Textbox=20, Spinbox=21, Slider=22, Dropdown=23, 
		Radio=24, Checkbox=25, Identifier=26, Integer=27, Money=28, WS=29, ID_LETTER=30, 
		DIGIT=31, STRING=32, LINE_COMMENT=33, COMMENT=34, HASH=35, NEWLINE=36, 
		TAB=37, LP=38, RP=39, LC=40, RC=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "BooleanLiteral", "Width", "Height", "Font", 
		"Fontsize", "Color", "Widget", "Textbox", "Spinbox", "Slider", "Dropdown", 
		"Radio", "Checkbox", "Identifier", "Integer", "Money", "WS", "ID_LETTER", 
		"DIGIT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "HASH", "NEWLINE", 
		"TAB", "LP", "RP", "LC", "RC"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'section'", "'subsection '", "'question'", 
		"'default'", "','", "':'", "'boolean'", "'money'", "'string'", "'integer'", 
		null, "'width'", "'height'", "'font'", "'fontsize'", "'color'", "'widget'", 
		"'textbox'", "'spinbox'", "'slider'", "'dropdown'", "'radio'", "'checkbox'", 
		null, null, null, null, null, null, null, null, null, "'#'", "'\n'", "'\t'", 
		"'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "BooleanLiteral", "Width", "Height", "Font", "Fontsize", "Color", 
		"Widget", "Textbox", "Spinbox", "Slider", "Dropdown", "Radio", "Checkbox", 
		"Identifier", "Integer", "Money", "WS", "ID_LETTER", "DIGIT", "STRING", 
		"LINE_COMMENT", "COMMENT", "HASH", "NEWLINE", "TAB", "LP", "RP", "LC", 
		"RC"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u016d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b7\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\7\33\u0113\n\33\f\33\16\33\u0116\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u011f\n\34\3\35\3\35\3\36\3\36\3\36\5\36"+
		"\u0126\n\36\3\36\3\36\3\37\3\37\3 \3 \3 \7 \u012f\n \f \16 \u0132\13 "+
		"\5 \u0134\n \3!\3!\3!\7!\u0139\n!\f!\16!\u013c\13!\3!\3!\3\"\3\"\3\"\5"+
		"\"\u0143\n\"\3#\3#\3#\3#\7#\u0149\n#\f#\16#\u014c\13#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\7$\u0156\n$\f$\16$\u0159\13$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\5\u013a\u014a\u0157\2,\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C\2E#G$I%K&M\'"+
		"O(Q)S*U+\3\2\4\5\2C\\aac|\3\2\62;\u0178\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5b\3\2\2\2\7g\3\2\2"+
		"\2\to\3\2\2\2\13{\3\2\2\2\r\u0084\3\2\2\2\17\u008c\3\2\2\2\21\u008e\3"+
		"\2\2\2\23\u0090\3\2\2\2\25\u0098\3\2\2\2\27\u009e\3\2\2\2\31\u00a5\3\2"+
		"\2\2\33\u00b6\3\2\2\2\35\u00b8\3\2\2\2\37\u00be\3\2\2\2!\u00c5\3\2\2\2"+
		"#\u00ca\3\2\2\2%\u00d3\3\2\2\2\'\u00d9\3\2\2\2)\u00e0\3\2\2\2+\u00e8\3"+
		"\2\2\2-\u00f0\3\2\2\2/\u00f7\3\2\2\2\61\u0100\3\2\2\2\63\u0106\3\2\2\2"+
		"\65\u010f\3\2\2\2\67\u011e\3\2\2\29\u0120\3\2\2\2;\u0125\3\2\2\2=\u0129"+
		"\3\2\2\2?\u0133\3\2\2\2A\u0135\3\2\2\2C\u0142\3\2\2\2E\u0144\3\2\2\2G"+
		"\u0151\3\2\2\2I\u015f\3\2\2\2K\u0161\3\2\2\2M\u0163\3\2\2\2O\u0165\3\2"+
		"\2\2Q\u0167\3\2\2\2S\u0169\3\2\2\2U\u016b\3\2\2\2WX\7u\2\2XY\7v\2\2YZ"+
		"\7{\2\2Z[\7n\2\2[\\\7g\2\2\\]\7u\2\2]^\7j\2\2^_\7g\2\2_`\7g\2\2`a\7v\2"+
		"\2a\4\3\2\2\2bc\7r\2\2cd\7c\2\2de\7i\2\2ef\7g\2\2f\6\3\2\2\2gh\7u\2\2"+
		"hi\7g\2\2ij\7e\2\2jk\7v\2\2kl\7k\2\2lm\7q\2\2mn\7p\2\2n\b\3\2\2\2op\7"+
		"u\2\2pq\7w\2\2qr\7d\2\2rs\7u\2\2st\7g\2\2tu\7e\2\2uv\7v\2\2vw\7k\2\2w"+
		"x\7q\2\2xy\7p\2\2yz\7\"\2\2z\n\3\2\2\2{|\7s\2\2|}\7w\2\2}~\7g\2\2~\177"+
		"\7u\2\2\177\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7q\2\2\u0082\u0083"+
		"\7p\2\2\u0083\f\3\2\2\2\u0084\u0085\7f\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7h\2\2\u0087\u0088\7c\2\2\u0088\u0089\7w\2\2\u0089\u008a\7n\2\2\u008a"+
		"\u008b\7v\2\2\u008b\16\3\2\2\2\u008c\u008d\7.\2\2\u008d\20\3\2\2\2\u008e"+
		"\u008f\7<\2\2\u008f\22\3\2\2\2\u0090\u0091\7d\2\2\u0091\u0092\7q\2\2\u0092"+
		"\u0093\7q\2\2\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095\u0096\7c\2\2"+
		"\u0096\u0097\7p\2\2\u0097\24\3\2\2\2\u0098\u0099\7o\2\2\u0099\u009a\7"+
		"q\2\2\u009a\u009b\7p\2\2\u009b\u009c\7g\2\2\u009c\u009d\7{\2\2\u009d\26"+
		"\3\2\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7t\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7i\2\2\u00a4\30\3\2\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7g\2\2"+
		"\u00a9\u00aa\7i\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7t\2\2\u00ac\32\3\2"+
		"\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7w\2\2\u00b0\u00b7"+
		"\7g\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4"+
		"\u00b5\7u\2\2\u00b5\u00b7\7g\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00b1\3\2\2"+
		"\2\u00b7\34\3\2\2\2\u00b8\u00b9\7y\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb"+
		"\7f\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7j\2\2\u00bd\36\3\2\2\2\u00be\u00bf"+
		"\7j\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7i\2\2\u00c2"+
		"\u00c3\7j\2\2\u00c3\u00c4\7v\2\2\u00c4 \3\2\2\2\u00c5\u00c6\7h\2\2\u00c6"+
		"\u00c7\7q\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7v\2\2\u00c9\"\3\2\2\2\u00ca"+
		"\u00cb\7h\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7v\2\2"+
		"\u00ce\u00cf\7u\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7|\2\2\u00d1\u00d2"+
		"\7g\2\2\u00d2$\3\2\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6"+
		"\7n\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7t\2\2\u00d8&\3\2\2\2\u00d9\u00da"+
		"\7y\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7i\2\2\u00dd"+
		"\u00de\7g\2\2\u00de\u00df\7v\2\2\u00df(\3\2\2\2\u00e0\u00e1\7v\2\2\u00e1"+
		"\u00e2\7g\2\2\u00e2\u00e3\7z\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7d\2\2"+
		"\u00e5\u00e6\7q\2\2\u00e6\u00e7\7z\2\2\u00e7*\3\2\2\2\u00e8\u00e9\7u\2"+
		"\2\u00e9\u00ea\7r\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed"+
		"\7d\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7z\2\2\u00ef,\3\2\2\2\u00f0\u00f1"+
		"\7u\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7f\2\2\u00f4"+
		"\u00f5\7g\2\2\u00f5\u00f6\7t\2\2\u00f6.\3\2\2\2\u00f7\u00f8\7f\2\2\u00f8"+
		"\u00f9\7t\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7r\2\2\u00fb\u00fc\7f\2\2"+
		"\u00fc\u00fd\7q\2\2\u00fd\u00fe\7y\2\2\u00fe\u00ff\7p\2\2\u00ff\60\3\2"+
		"\2\2\u0100\u0101\7t\2\2\u0101\u0102\7c\2\2\u0102\u0103\7f\2\2\u0103\u0104"+
		"\7k\2\2\u0104\u0105\7q\2\2\u0105\62\3\2\2\2\u0106\u0107\7e\2\2\u0107\u0108"+
		"\7j\2\2\u0108\u0109\7g\2\2\u0109\u010a\7e\2\2\u010a\u010b\7m\2\2\u010b"+
		"\u010c\7d\2\2\u010c\u010d\7q\2\2\u010d\u010e\7z\2\2\u010e\64\3\2\2\2\u010f"+
		"\u0114\5=\37\2\u0110\u0113\5=\37\2\u0111\u0113\5? \2\u0112\u0110\3\2\2"+
		"\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\66\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011f\5? \2\u0118"+
		"\u0119\7*\2\2\u0119\u011a\7/\2\2\u011a\u011b\3\2\2\2\u011b\u011c\5? \2"+
		"\u011c\u011d\7+\2\2\u011d\u011f\3\2\2\2\u011e\u0117\3\2\2\2\u011e\u0118"+
		"\3\2\2\2\u011f8\3\2\2\2\u0120\u0121\5\67\34\2\u0121:\3\2\2\2\u0122\u0126"+
		"\7\"\2\2\u0123\u0126\5K&\2\u0124\u0126\5M\'\2\u0125\u0122\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\b\36"+
		"\2\2\u0128<\3\2\2\2\u0129\u012a\t\2\2\2\u012a>\3\2\2\2\u012b\u0134\7\62"+
		"\2\2\u012c\u0130\t\3\2\2\u012d\u012f\t\3\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0134\3\2"+
		"\2\2\u0132\u0130\3\2\2\2\u0133\u012b\3\2\2\2\u0133\u012c\3\2\2\2\u0134"+
		"@\3\2\2\2\u0135\u013a\7$\2\2\u0136\u0139\5C\"\2\u0137\u0139\13\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013a\u0138\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013e\7$\2\2\u013eB\3\2\2\2\u013f\u0143\7^\2\2\u0140\u0141\7^\2\2\u0141"+
		"\u0143\7^\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0143D\3\2\2\2\u0144"+
		"\u0145\7\61\2\2\u0145\u0146\7\61\2\2\u0146\u014a\3\2\2\2\u0147\u0149\13"+
		"\2\2\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u014b\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7\f"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0150\b#\2\2\u0150F\3\2\2\2\u0151\u0152"+
		"\7\61\2\2\u0152\u0153\7,\2\2\u0153\u0157\3\2\2\2\u0154\u0156\13\2\2\2"+
		"\u0155\u0154\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0158\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\7,\2\2\u015b"+
		"\u015c\7\61\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b$\2\2\u015eH\3\2\2\2"+
		"\u015f\u0160\7%\2\2\u0160J\3\2\2\2\u0161\u0162\7\f\2\2\u0162L\3\2\2\2"+
		"\u0163\u0164\7\13\2\2\u0164N\3\2\2\2\u0165\u0166\7*\2\2\u0166P\3\2\2\2"+
		"\u0167\u0168\7+\2\2\u0168R\3\2\2\2\u0169\u016a\7}\2\2\u016aT\3\2\2\2\u016b"+
		"\u016c\7\177\2\2\u016cV\3\2\2\2\17\2\u00b6\u0112\u0114\u011e\u0125\u0130"+
		"\u0133\u0138\u013a\u0142\u014a\u0157\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}