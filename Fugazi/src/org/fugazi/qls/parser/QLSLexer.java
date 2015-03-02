// Generated from /home/alex/Develop/Msc/many-ql/Fugazi/src/org/fugazi/qls/grammar/QLS.g4 by ANTLR 4.5
package org.fugazi.qls.parser;
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
		T__9=10, T__10=11, T__11=12, T__12=13, STRING=14, ID=15, COMMENT=16, WS=17, 
		LINE_COMMENT=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "STRING", "ID", "COMMENT", "WS", "LINE_COMMENT", 
		"ESC", "UNICODE", "HEX", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'page'", "'{'", "'}'", "'section'", "'question'", 
		"'widget'", "'checkbox'", "'radio'", "'dropdown'", "'spinbox'", "'slider'", 
		"'text'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "STRING", "ID", "COMMENT", "WS", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00ca\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\7\17\u008b\n\17\f\17\16\17\u008e\13\17\3\17\3\17\3"+
		"\20\6\20\u0093\n\20\r\20\16\20\u0094\3\21\3\21\3\21\3\21\7\21\u009b\n"+
		"\21\f\21\16\21\u009e\13\21\3\21\3\21\3\21\3\21\3\21\3\22\6\22\u00a6\n"+
		"\22\r\22\16\22\u00a7\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00b0\n\23\f\23"+
		"\16\23\u00b3\13\23\3\23\5\23\u00b6\n\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\5\24\u00bf\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\u009c\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\2)\2+\2-\2\3\2\t\4\2$$^^\4\2C\\c|\5\2"+
		"\13\f\16\17\"\"\4\2\f\f\17\17\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\3\2"+
		"\62;\u00cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\3/\3\2\2\2\5:\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13"+
		"C\3\2\2\2\rK\3\2\2\2\17T\3\2\2\2\21[\3\2\2\2\23d\3\2\2\2\25j\3\2\2\2\27"+
		"s\3\2\2\2\31{\3\2\2\2\33\u0082\3\2\2\2\35\u0087\3\2\2\2\37\u0092\3\2\2"+
		"\2!\u0096\3\2\2\2#\u00a5\3\2\2\2%\u00ab\3\2\2\2\'\u00bb\3\2\2\2)\u00c0"+
		"\3\2\2\2+\u00c6\3\2\2\2-\u00c8\3\2\2\2/\60\7u\2\2\60\61\7v\2\2\61\62\7"+
		"{\2\2\62\63\7n\2\2\63\64\7g\2\2\64\65\7u\2\2\65\66\7j\2\2\66\67\7g\2\2"+
		"\678\7g\2\289\7v\2\29\4\3\2\2\2:;\7r\2\2;<\7c\2\2<=\7i\2\2=>\7g\2\2>\6"+
		"\3\2\2\2?@\7}\2\2@\b\3\2\2\2AB\7\177\2\2B\n\3\2\2\2CD\7u\2\2DE\7g\2\2"+
		"EF\7e\2\2FG\7v\2\2GH\7k\2\2HI\7q\2\2IJ\7p\2\2J\f\3\2\2\2KL\7s\2\2LM\7"+
		"w\2\2MN\7g\2\2NO\7u\2\2OP\7v\2\2PQ\7k\2\2QR\7q\2\2RS\7p\2\2S\16\3\2\2"+
		"\2TU\7y\2\2UV\7k\2\2VW\7f\2\2WX\7i\2\2XY\7g\2\2YZ\7v\2\2Z\20\3\2\2\2["+
		"\\\7e\2\2\\]\7j\2\2]^\7g\2\2^_\7e\2\2_`\7m\2\2`a\7d\2\2ab\7q\2\2bc\7z"+
		"\2\2c\22\3\2\2\2de\7t\2\2ef\7c\2\2fg\7f\2\2gh\7k\2\2hi\7q\2\2i\24\3\2"+
		"\2\2jk\7f\2\2kl\7t\2\2lm\7q\2\2mn\7r\2\2no\7f\2\2op\7q\2\2pq\7y\2\2qr"+
		"\7p\2\2r\26\3\2\2\2st\7u\2\2tu\7r\2\2uv\7k\2\2vw\7p\2\2wx\7d\2\2xy\7q"+
		"\2\2yz\7z\2\2z\30\3\2\2\2{|\7u\2\2|}\7n\2\2}~\7k\2\2~\177\7f\2\2\177\u0080"+
		"\7g\2\2\u0080\u0081\7t\2\2\u0081\32\3\2\2\2\u0082\u0083\7v\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7z\2\2\u0085\u0086\7v\2\2\u0086\34\3\2\2\2\u0087\u008c"+
		"\7$\2\2\u0088\u008b\5\'\24\2\u0089\u008b\n\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7$\2\2\u0090"+
		"\36\3\2\2\2\u0091\u0093\t\3\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095 \3\2\2\2\u0096\u0097"+
		"\7\61\2\2\u0097\u0098\7,\2\2\u0098\u009c\3\2\2\2\u0099\u009b\13\2\2\2"+
		"\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7,\2\2\u00a0"+
		"\u00a1\7\61\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\21\2\2\u00a3\"\3\2\2"+
		"\2\u00a4\u00a6\t\4\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\b\22\2\2"+
		"\u00aa$\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00b1"+
		"\3\2\2\2\u00ae\u00b0\n\5\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b6\7\17\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\7\f\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\23"+
		"\2\2\u00ba&\3\2\2\2\u00bb\u00be\7^\2\2\u00bc\u00bf\t\6\2\2\u00bd\u00bf"+
		"\5)\25\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf(\3\2\2\2\u00c0"+
		"\u00c1\7w\2\2\u00c1\u00c2\5+\26\2\u00c2\u00c3\5+\26\2\u00c3\u00c4\5+\26"+
		"\2\u00c4\u00c5\5+\26\2\u00c5*\3\2\2\2\u00c6\u00c7\t\7\2\2\u00c7,\3\2\2"+
		"\2\u00c8\u00c9\t\b\2\2\u00c9.\3\2\2\2\13\2\u008a\u008c\u0094\u009c\u00a7"+
		"\u00b1\u00b5\u00be\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}