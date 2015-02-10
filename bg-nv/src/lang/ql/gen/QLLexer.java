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
		T__9=10, Boolean=11, QuestionType=12, Identifier=13, Decimal=14, Integer=15, 
		String=16, Comment=17, Date=18, LineComment=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "Letter", "Digit", "Boolean", "QuestionType", "Identifier", "Decimal", 
		"Integer", "String", "Test", "Comment", "Year", "Month", "Day", "Date", 
		"Quotes", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'*'", 
		"'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "Boolean", 
		"QuestionType", "Identifier", "Decimal", "Integer", "String", "Comment", 
		"Date", "LineComment", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00da\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16_\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0080\n\17\3\20\3\20\3\20\3\20\7\20\u0086\n\20\f\20\16"+
		"\20\u0089\13\20\3\21\6\21\u008c\n\21\r\21\16\21\u008d\3\21\3\21\6\21\u0092"+
		"\n\21\r\21\16\21\u0093\3\22\6\22\u0097\n\22\r\22\16\22\u0098\3\23\3\23"+
		"\7\23\u009d\n\23\f\23\16\23\u00a0\13\23\3\23\3\23\3\24\3\24\3\24\5\24"+
		"\u00a7\n\24\3\25\3\25\3\25\3\25\7\25\u00ad\n\25\f\25\16\25\u00b0\13\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\7\33"+
		"\u00cd\n\33\f\33\16\33\u00d0\13\33\3\33\3\33\3\34\6\34\u00d5\n\34\r\34"+
		"\16\34\u00d6\3\34\3\34\4\u009e\u00ae\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\2\31\2\33\r\35\16\37\17!\20#\21%\22\'\2)\23+\2-"+
		"\2/\2\61\24\63\2\65\25\67\26\3\2\n\4\2C\\c|\3\2\62;\6\2SSggqquw\3\2\63"+
		"\64\3\2\63\65\5\2$$))\u201e\u201f\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00e2"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2"+
		"\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5>\3\2\2\2\7@\3\2\2"+
		"\2\tB\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2"+
		"\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33^\3\2\2\2\35\177\3\2\2\2\37\u0081"+
		"\3\2\2\2!\u008b\3\2\2\2#\u0096\3\2\2\2%\u009a\3\2\2\2\'\u00a6\3\2\2\2"+
		")\u00a8\3\2\2\2+\u00b6\3\2\2\2-\u00bb\3\2\2\2/\u00be\3\2\2\2\61\u00c0"+
		"\3\2\2\2\63\u00c6\3\2\2\2\65\u00c8\3\2\2\2\67\u00d4\3\2\2\29:\7h\2\2:"+
		";\7q\2\2;<\7t\2\2<=\7o\2\2=\4\3\2\2\2>?\7}\2\2?\6\3\2\2\2@A\7\177\2\2"+
		"A\b\3\2\2\2BC\7k\2\2CD\7h\2\2D\n\3\2\2\2EF\7*\2\2F\f\3\2\2\2GH\7+\2\2"+
		"H\16\3\2\2\2IJ\7/\2\2J\20\3\2\2\2KL\7-\2\2L\22\3\2\2\2MN\7,\2\2N\24\3"+
		"\2\2\2OP\7\61\2\2P\26\3\2\2\2QR\t\2\2\2R\30\3\2\2\2ST\t\3\2\2T\32\3\2"+
		"\2\2UV\7v\2\2VW\7t\2\2WX\7w\2\2X_\7g\2\2YZ\7h\2\2Z[\7c\2\2[\\\7n\2\2\\"+
		"]\7u\2\2]_\7g\2\2^U\3\2\2\2^Y\3\2\2\2_\34\3\2\2\2`a\7d\2\2ab\7q\2\2bc"+
		"\7q\2\2cd\7n\2\2de\7g\2\2ef\7c\2\2f\u0080\7p\2\2gh\7f\2\2hi\7g\2\2ij\7"+
		"e\2\2jk\7k\2\2kl\7o\2\2lm\7c\2\2m\u0080\7n\2\2no\7k\2\2op\7p\2\2pq\7v"+
		"\2\2qr\7g\2\2rs\7i\2\2st\7g\2\2t\u0080\7t\2\2uv\7u\2\2vw\7v\2\2wx\7t\2"+
		"\2xy\7k\2\2yz\7p\2\2z\u0080\7i\2\2{|\7f\2\2|}\7c\2\2}~\7v\2\2~\u0080\7"+
		"g\2\2\177`\3\2\2\2\177g\3\2\2\2\177n\3\2\2\2\177u\3\2\2\2\177{\3\2\2\2"+
		"\u0080\36\3\2\2\2\u0081\u0087\5\27\f\2\u0082\u0086\5\27\f\2\u0083\u0086"+
		"\5\31\r\2\u0084\u0086\7a\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088 \3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\31\r\2\u008b\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\7\60\2\2\u0090\u0092\5\31\r\2\u0091\u0090\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\"\3\2\2\2\u0095\u0097\5\31\r\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2"+
		"\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099$\3\2\2\2\u009a\u009e"+
		"\5\63\32\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a2\5\63\32\2\u00a2&\3\2\2\2\u00a3\u00a4\7^\2\2\u00a4"+
		"\u00a7\5\63\32\2\u00a5\u00a7\n\4\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ae"+
		"\3\2\2\2\u00ab\u00ad\13\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2"+
		"\u00ae\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\b\25\2\2\u00b5*\3\2\2\2\u00b6\u00b7\t\5\2\2\u00b7\u00b8\5\31\r"+
		"\2\u00b8\u00b9\5\31\r\2\u00b9\u00ba\5\31\r\2\u00ba,\3\2\2\2\u00bb\u00bc"+
		"\t\5\2\2\u00bc\u00bd\5\31\r\2\u00bd.\3\2\2\2\u00be\u00bf\t\6\2\2\u00bf"+
		"\60\3\2\2\2\u00c0\u00c1\5/\30\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\5-\27"+
		"\2\u00c3\u00c4\7\61\2\2\u00c4\u00c5\5+\26\2\u00c5\62\3\2\2\2\u00c6\u00c7"+
		"\t\7\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9\u00ca\7\61\2\2\u00ca"+
		"\u00ce\3\2\2\2\u00cb\u00cd\n\b\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\b\33\2\2\u00d2\66\3\2\2\2\u00d3\u00d5\t\t\2"+
		"\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b\34\2\2\u00d98\3\2\2\2\17\2"+
		"^\177\u0085\u0087\u008d\u0093\u0098\u009e\u00a6\u00ae\u00ce\u00d6\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}