// Generated from E:/development/Steven/src/test/resources/antlr/grammars\QLS.g4 by ANTLR 4.5
package edu.parser.QLS.antlrGenerated;
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
		T__9=10, T__10=11, T__11=12, UPPERCASE=13, LOWERCASE=14, NUMBERS=15, STRING=16, 
		COMMENT_LINE=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "UPPERCASE", "LOWERCASE", "NUMBERS", "STRING", 
		"COMMENT_LINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'default'", "'page'", "'section'", 
		"'question'", "'widget'", "'width'", "'font'", "'color'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "UPPERCASE", "LOWERCASE", "NUMBERS", "STRING", "COMMENT_LINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\6\16p\n\16\r\16\16\16q\3\17\6\17u\n\17"+
		"\r\17\16\17v\3\20\6\20z\n\20\r\20\16\20{\3\21\3\21\3\21\3\21\7\21\u0082"+
		"\n\21\f\21\16\21\u0085\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u008d"+
		"\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\23\6\23\u0095\n\23\r\23\16\23"+
		"\u0096\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\b\3\2C\\\3\2c|\3\2\62;\5"+
		"\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00a0\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3"+
		"\'\3\2\2\2\5\62\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\13>\3\2\2\2\rC\3\2\2"+
		"\2\17K\3\2\2\2\21T\3\2\2\2\23[\3\2\2\2\25a\3\2\2\2\27f\3\2\2\2\31l\3\2"+
		"\2\2\33o\3\2\2\2\35t\3\2\2\2\37y\3\2\2\2!}\3\2\2\2#\u0088\3\2\2\2%\u0094"+
		"\3\2\2\2\'(\7u\2\2()\7v\2\2)*\7{\2\2*+\7n\2\2+,\7g\2\2,-\7u\2\2-.\7j\2"+
		"\2./\7g\2\2/\60\7g\2\2\60\61\7v\2\2\61\4\3\2\2\2\62\63\7}\2\2\63\6\3\2"+
		"\2\2\64\65\7\177\2\2\65\b\3\2\2\2\66\67\7f\2\2\678\7g\2\289\7h\2\29:\7"+
		"c\2\2:;\7w\2\2;<\7n\2\2<=\7v\2\2=\n\3\2\2\2>?\7r\2\2?@\7c\2\2@A\7i\2\2"+
		"AB\7g\2\2B\f\3\2\2\2CD\7u\2\2DE\7g\2\2EF\7e\2\2FG\7v\2\2GH\7k\2\2HI\7"+
		"q\2\2IJ\7p\2\2J\16\3\2\2\2KL\7s\2\2LM\7w\2\2MN\7g\2\2NO\7u\2\2OP\7v\2"+
		"\2PQ\7k\2\2QR\7q\2\2RS\7p\2\2S\20\3\2\2\2TU\7y\2\2UV\7k\2\2VW\7f\2\2W"+
		"X\7i\2\2XY\7g\2\2YZ\7v\2\2Z\22\3\2\2\2[\\\7y\2\2\\]\7k\2\2]^\7f\2\2^_"+
		"\7v\2\2_`\7j\2\2`\24\3\2\2\2ab\7h\2\2bc\7q\2\2cd\7p\2\2de\7v\2\2e\26\3"+
		"\2\2\2fg\7e\2\2gh\7q\2\2hi\7n\2\2ij\7q\2\2jk\7t\2\2k\30\3\2\2\2lm\7%\2"+
		"\2m\32\3\2\2\2np\t\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\34\3"+
		"\2\2\2su\t\3\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\36\3\2\2\2x"+
		"z\t\4\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2| \3\2\2\2}\u0083\7$"+
		"\2\2~\u0082\n\5\2\2\177\u0080\7$\2\2\u0080\u0082\7$\2\2\u0081~\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7$\2\2\u0087"+
		"\"\3\2\2\2\u0088\u0089\7\61\2\2\u0089\u008a\7\61\2\2\u008a\u008e\3\2\2"+
		"\2\u008b\u008d\n\6\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0092\b\22\2\2\u0092$\3\2\2\2\u0093\u0095\t\7\2\2\u0094\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\b\23\2\2\u0099&\3\2\2\2\n\2qv{\u0081\u0083\u008e"+
		"\u0096\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}