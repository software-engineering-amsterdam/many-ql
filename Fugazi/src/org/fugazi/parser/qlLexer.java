// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/ql.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, MUL=3, DIV=4, ADD=5, SUB=6, ASSIGN=7, OPEN=8, CLOSE=9, 
		QUOTE=10, ID=11, WORD=12, INT=13, NEWLINE=14, CLEAR=15, COMMENT=16, WS=17, 
		LINE_COMMENT=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "MUL", "DIV", "ADD", "SUB", "ASSIGN", "OPEN", "CLOSE", 
		"QUOTE", "ID", "WORD", "ESC", "UNICODE", "HEX", "INT", "NEWLINE", "CLEAR", 
		"COMMENT", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'bool'", "'*'", "'/'", "'+'", "'-'", "'='", "'('", "')'", 
		"'\"'", null, null, null, null, "'clear'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "MUL", "DIV", "ADD", "SUB", "ASSIGN", "OPEN", "CLOSE", 
		"QUOTE", "ID", "WORD", "INT", "NEWLINE", "CLEAR", "COMMENT", "WS", "LINE_COMMENT"
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


	public qlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\6\fF\n\f\r\f\16\fG\3\r\3\r\3\r\7\rM\n\r\f\r\16\rP\13\r\3\r\3\r\3"+
		"\16\3\16\3\16\5\16W\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\6\21b\n\21\r\21\16\21c\3\22\5\22g\n\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\7\24u\n\24\f\24\16\24x\13\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\6\25\u0080\n\25\r\25\16\25\u0081\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\7\26\u008a\n\26\f\26\16\26\u008d\13\26\3\26\5\26\u0090\n"+
		"\26\3\26\3\26\3\26\3\26\3v\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\2\35\2\37\2!\17#\20%\21\'\22)\23+\24\3\2\t\4\2"+
		"C\\c|\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\3\2\62;\5\2\13\f\16"+
		"\17\"\"\4\2\f\f\17\17\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\64\3\2\2"+
		"\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23@\3\2"+
		"\2\2\25B\3\2\2\2\27E\3\2\2\2\31I\3\2\2\2\33S\3\2\2\2\35X\3\2\2\2\37^\3"+
		"\2\2\2!a\3\2\2\2#f\3\2\2\2%j\3\2\2\2\'p\3\2\2\2)\177\3\2\2\2+\u0085\3"+
		"\2\2\2-.\7=\2\2.\4\3\2\2\2/\60\7d\2\2\60\61\7q\2\2\61\62\7q\2\2\62\63"+
		"\7n\2\2\63\6\3\2\2\2\64\65\7,\2\2\65\b\3\2\2\2\66\67\7\61\2\2\67\n\3\2"+
		"\2\289\7-\2\29\f\3\2\2\2:;\7/\2\2;\16\3\2\2\2<=\7?\2\2=\20\3\2\2\2>?\7"+
		"*\2\2?\22\3\2\2\2@A\7+\2\2A\24\3\2\2\2BC\7$\2\2C\26\3\2\2\2DF\t\2\2\2"+
		"ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\30\3\2\2\2IN\7$\2\2JM\5\33\16"+
		"\2KM\n\3\2\2LJ\3\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2"+
		"\2PN\3\2\2\2QR\7$\2\2R\32\3\2\2\2SV\7^\2\2TW\t\4\2\2UW\5\35\17\2VT\3\2"+
		"\2\2VU\3\2\2\2W\34\3\2\2\2XY\7w\2\2YZ\5\37\20\2Z[\5\37\20\2[\\\5\37\20"+
		"\2\\]\5\37\20\2]\36\3\2\2\2^_\t\5\2\2_ \3\2\2\2`b\t\6\2\2a`\3\2\2\2bc"+
		"\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\"\3\2\2\2eg\7\17\2\2fe\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hi\7\f\2\2i$\3\2\2\2jk\7e\2\2kl\7n\2\2lm\7g\2\2mn\7c\2\2no\7"+
		"t\2\2o&\3\2\2\2pq\7\61\2\2qr\7,\2\2rv\3\2\2\2su\13\2\2\2ts\3\2\2\2ux\3"+
		"\2\2\2vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7,\2\2z{\7\61\2\2{|\3"+
		"\2\2\2|}\b\24\2\2}(\3\2\2\2~\u0080\t\7\2\2\177~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\b\25\2\2\u0084*\3\2\2\2\u0085\u0086\7\61\2\2\u0086\u0087\7\61\2"+
		"\2\u0087\u008b\3\2\2\2\u0088\u008a\n\b\2\2\u0089\u0088\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0090\7\17\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\f\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\b\26\2\2\u0094,\3\2\2\2\r\2GLNVcfv\u0081\u008b\u008f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}