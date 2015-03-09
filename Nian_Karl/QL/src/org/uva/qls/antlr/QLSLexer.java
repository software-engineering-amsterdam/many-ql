// Generated from QLS.g4 by ANTLR 4.5
package org.uva.qls.antlr;
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
		STYLE=1, PAGE=2, SECTION=3, QUESTION=4, DEFAULT=5, INT=6, STR=7, BOOL=8, 
		WIDGET=9, SLIDER=10, SPINBOX=11, TEXTBOX=12, RADIO=13, DROPDOWN=14, CHECKBOX=15, 
		WIDTH=16, HEIGHT=17, FONTSIZE=18, FONT=19, COLOR=20, ARIAL=21, COLON=22, 
		COMMA=23, LEFT_PAREN=24, RIGHT_PAREN=25, LEFT_BRACE=26, RIGHT_BRACE=27, 
		LEFT_BRACKET=28, RIGHT_BRACKET=29, IntegerLiteral=30, BooleanLiteral=31, 
		StringLiteral=32, WhiteSpace=33, MultiComment=34, SingleComment=35, Identifier=36, 
		RgbValue=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STYLE", "PAGE", "SECTION", "QUESTION", "DEFAULT", "INT", "STR", "BOOL", 
		"WIDGET", "SLIDER", "SPINBOX", "TEXTBOX", "RADIO", "DROPDOWN", "CHECKBOX", 
		"WIDTH", "HEIGHT", "FONTSIZE", "FONT", "COLOR", "ARIAL", "COLON", "COMMA", 
		"LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "IntegerLiteral", "BooleanLiteral", "StringLiteral", 
		"WhiteSpace", "MultiComment", "SingleComment", "Identifier", "RgbValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'style'", "'page'", "'section'", "'question'", "'default'", "'Int'", 
		"'Str'", "'Bool'", "'widget'", "'slider'", "'spinbox'", "'textbox'", "'radio'", 
		"'dropdown'", "'checkbox'", "'width'", "'height'", "'fontsize'", "'font'", 
		"'color'", "'arial'", "':'", "','", "'('", "')'", "'{'", "'}'", "'['", 
		"']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STYLE", "PAGE", "SECTION", "QUESTION", "DEFAULT", "INT", "STR", 
		"BOOL", "WIDGET", "SLIDER", "SPINBOX", "TEXTBOX", "RADIO", "DROPDOWN", 
		"CHECKBOX", "WIDTH", "HEIGHT", "FONTSIZE", "FONT", "COLOR", "ARIAL", "COLON", 
		"COMMA", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "IntegerLiteral", "BooleanLiteral", "StringLiteral", 
		"WhiteSpace", "MultiComment", "SingleComment", "Identifier", "RgbValue"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u0135\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\7\37"+
		"\u00ee\n\37\f\37\16\37\u00f1\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00fc"+
		"\n \3!\3!\3!\3!\7!\u0102\n!\f!\16!\u0105\13!\3!\3!\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\7#\u0111\n#\f#\16#\u0114\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\7$\u011f"+
		"\n$\f$\16$\u0122\13$\3$\3$\3$\3$\3%\3%\7%\u012a\n%\f%\16%\u012d\13%\3"+
		"&\3&\7&\u0131\n&\f&\16&\u0134\13&\4\u0112\u0120\2\'\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"\3\2\b\3\2\63;\3\2\62;\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\4\2C\\c|\6\2"+
		"\62;C\\aac|\u013c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5S\3\2\2\2\7X\3\2"+
		"\2\2\t`\3\2\2\2\13i\3\2\2\2\rq\3\2\2\2\17u\3\2\2\2\21y\3\2\2\2\23~\3\2"+
		"\2\2\25\u0085\3\2\2\2\27\u008c\3\2\2\2\31\u0094\3\2\2\2\33\u009c\3\2\2"+
		"\2\35\u00a2\3\2\2\2\37\u00ab\3\2\2\2!\u00b4\3\2\2\2#\u00ba\3\2\2\2%\u00c1"+
		"\3\2\2\2\'\u00ca\3\2\2\2)\u00cf\3\2\2\2+\u00d5\3\2\2\2-\u00db\3\2\2\2"+
		"/\u00dd\3\2\2\2\61\u00df\3\2\2\2\63\u00e1\3\2\2\2\65\u00e3\3\2\2\2\67"+
		"\u00e5\3\2\2\29\u00e7\3\2\2\2;\u00e9\3\2\2\2=\u00eb\3\2\2\2?\u00fb\3\2"+
		"\2\2A\u00fd\3\2\2\2C\u0108\3\2\2\2E\u010c\3\2\2\2G\u011a\3\2\2\2I\u0127"+
		"\3\2\2\2K\u012e\3\2\2\2MN\7u\2\2NO\7v\2\2OP\7{\2\2PQ\7n\2\2QR\7g\2\2R"+
		"\4\3\2\2\2ST\7r\2\2TU\7c\2\2UV\7i\2\2VW\7g\2\2W\6\3\2\2\2XY\7u\2\2YZ\7"+
		"g\2\2Z[\7e\2\2[\\\7v\2\2\\]\7k\2\2]^\7q\2\2^_\7p\2\2_\b\3\2\2\2`a\7s\2"+
		"\2ab\7w\2\2bc\7g\2\2cd\7u\2\2de\7v\2\2ef\7k\2\2fg\7q\2\2gh\7p\2\2h\n\3"+
		"\2\2\2ij\7f\2\2jk\7g\2\2kl\7h\2\2lm\7c\2\2mn\7w\2\2no\7n\2\2op\7v\2\2"+
		"p\f\3\2\2\2qr\7K\2\2rs\7p\2\2st\7v\2\2t\16\3\2\2\2uv\7U\2\2vw\7v\2\2w"+
		"x\7t\2\2x\20\3\2\2\2yz\7D\2\2z{\7q\2\2{|\7q\2\2|}\7n\2\2}\22\3\2\2\2~"+
		"\177\7y\2\2\177\u0080\7k\2\2\u0080\u0081\7f\2\2\u0081\u0082\7i\2\2\u0082"+
		"\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084\24\3\2\2\2\u0085\u0086\7u\2\2\u0086"+
		"\u0087\7n\2\2\u0087\u0088\7k\2\2\u0088\u0089\7f\2\2\u0089\u008a\7g\2\2"+
		"\u008a\u008b\7t\2\2\u008b\26\3\2\2\2\u008c\u008d\7u\2\2\u008d\u008e\7"+
		"r\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7d\2\2\u0091\u0092"+
		"\7q\2\2\u0092\u0093\7z\2\2\u0093\30\3\2\2\2\u0094\u0095\7v\2\2\u0095\u0096"+
		"\7g\2\2\u0096\u0097\7z\2\2\u0097\u0098\7v\2\2\u0098\u0099\7d\2\2\u0099"+
		"\u009a\7q\2\2\u009a\u009b\7z\2\2\u009b\32\3\2\2\2\u009c\u009d\7t\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7q\2\2"+
		"\u00a1\34\3\2\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7"+
		"q\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9"+
		"\7y\2\2\u00a9\u00aa\7p\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7e\2\2\u00ac\u00ad"+
		"\7j\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7m\2\2\u00b0"+
		"\u00b1\7d\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7z\2\2\u00b3 \3\2\2\2\u00b4"+
		"\u00b5\7y\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7f\2\2\u00b7\u00b8\7v\2\2"+
		"\u00b8\u00b9\7j\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7g"+
		"\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7i\2\2\u00be\u00bf\7j\2\2\u00bf\u00c0"+
		"\7v\2\2\u00c0$\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4"+
		"\7p\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7|\2\2\u00c8\u00c9\7g\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7h\2\2\u00cb"+
		"\u00cc\7q\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7v\2\2\u00ce(\3\2\2\2\u00cf"+
		"\u00d0\7e\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7q\2\2"+
		"\u00d3\u00d4\7t\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7t\2"+
		"\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7n\2\2\u00da,\3\2"+
		"\2\2\u00db\u00dc\7<\2\2\u00dc.\3\2\2\2\u00dd\u00de\7.\2\2\u00de\60\3\2"+
		"\2\2\u00df\u00e0\7*\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7+\2\2\u00e2\64\3"+
		"\2\2\2\u00e3\u00e4\7}\2\2\u00e4\66\3\2\2\2\u00e5\u00e6\7\177\2\2\u00e6"+
		"8\3\2\2\2\u00e7\u00e8\7]\2\2\u00e8:\3\2\2\2\u00e9\u00ea\7_\2\2\u00ea<"+
		"\3\2\2\2\u00eb\u00ef\t\2\2\2\u00ec\u00ee\t\3\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0>\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5"+
		"\7w\2\2\u00f5\u00fc\7g\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7c\2\2\u00f8"+
		"\u00f9\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fc\7g\2\2\u00fb\u00f2\3\2\2"+
		"\2\u00fb\u00f6\3\2\2\2\u00fc@\3\2\2\2\u00fd\u0103\7$\2\2\u00fe\u0102\n"+
		"\4\2\2\u00ff\u0100\7$\2\2\u0100\u0102\7$\2\2\u0101\u00fe\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7$\2\2\u0107"+
		"B\3\2\2\2\u0108\u0109\t\5\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b\"\2\2"+
		"\u010bD\3\2\2\2\u010c\u010d\7\61\2\2\u010d\u010e\7,\2\2\u010e\u0112\3"+
		"\2\2\2\u010f\u0111\13\2\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0116\7,\2\2\u0116\u0117\7\61\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\b#\2\2\u0119F\3\2\2\2\u011a\u011b\7\61\2\2\u011b\u011c\7\61\2\2"+
		"\u011c\u0120\3\2\2\2\u011d\u011f\13\2\2\2\u011e\u011d\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0124\7\f\2\2\u0124\u0125\3\2\2\2\u0125\u0126\b$"+
		"\2\2\u0126H\3\2\2\2\u0127\u012b\t\6\2\2\u0128\u012a\t\7\2\2\u0129\u0128"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"J\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0132\7%\2\2\u012f\u0131\t\3\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133L\3\2\2\2\u0134\u0132\3\2\2\2\13\2\u00ef\u00fb\u0101\u0103\u0112"+
		"\u0120\u012b\u0132\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}