// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/ql/syntax/QL.g4 by ANTLR 4.5
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, Keywords=9, 
		QuestionType=10, ID=11, Integer=12, String=13, Comment=14, LineComment=15, 
		WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "Letter", 
		"Digit", "Keywords", "QuestionType", "ID", "Integer", "String", "Comment", 
		"LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "Keywords", "QuestionType", 
		"ID", "Integer", "String", "Comment", "LineComment", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u009b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\fI\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rc\n\r\3\16\3\16\3\16"+
		"\3\16\7\16i\n\16\f\16\16\16l\13\16\3\17\6\17o\n\17\r\17\16\17p\3\20\3"+
		"\20\7\20u\n\20\f\20\16\20x\13\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u0080"+
		"\n\21\f\21\16\21\u0083\13\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\7\22\u008e\n\22\f\22\16\22\u0091\13\22\3\22\3\22\3\23\6\23\u0096\n"+
		"\23\r\23\16\23\u0097\3\23\3\23\4v\u0081\2\24\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\2\25\2\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\3\2\6\4\2"+
		"C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00a4\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5,\3\2\2\2\7.\3\2"+
		"\2\2\t\60\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219\3\2\2\2"+
		"\23;\3\2\2\2\25=\3\2\2\2\27H\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35n\3\2\2"+
		"\2\37r\3\2\2\2!{\3\2\2\2#\u0089\3\2\2\2%\u0095\3\2\2\2\'(\7h\2\2()\7q"+
		"\2\2)*\7t\2\2*+\7o\2\2+\4\3\2\2\2,-\7}\2\2-\6\3\2\2\2./\7\177\2\2/\b\3"+
		"\2\2\2\60\61\7k\2\2\61\62\7h\2\2\62\n\3\2\2\2\63\64\7*\2\2\64\f\3\2\2"+
		"\2\65\66\7+\2\2\66\16\3\2\2\2\678\7/\2\28\20\3\2\2\29:\7-\2\2:\22\3\2"+
		"\2\2;<\t\2\2\2<\24\3\2\2\2=>\t\3\2\2>\26\3\2\2\2?@\7v\2\2@A\7t\2\2AB\7"+
		"w\2\2BI\7g\2\2CD\7h\2\2DE\7c\2\2EF\7n\2\2FG\7u\2\2GI\7g\2\2H?\3\2\2\2"+
		"HC\3\2\2\2I\30\3\2\2\2JK\7d\2\2KL\7q\2\2LM\7q\2\2MN\7n\2\2NO\7g\2\2OP"+
		"\7c\2\2Pc\7p\2\2QR\7k\2\2RS\7p\2\2ST\7v\2\2TU\7g\2\2UV\7i\2\2VW\7g\2\2"+
		"Wc\7t\2\2XY\7u\2\2YZ\7v\2\2Z[\7t\2\2[\\\7k\2\2\\]\7p\2\2]c\7i\2\2^_\7"+
		"f\2\2_`\7c\2\2`a\7v\2\2ac\7g\2\2bJ\3\2\2\2bQ\3\2\2\2bX\3\2\2\2b^\3\2\2"+
		"\2c\32\3\2\2\2dj\5\23\n\2ei\5\23\n\2fi\5\25\13\2gi\7a\2\2he\3\2\2\2hf"+
		"\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\34\3\2\2\2lj\3\2\2\2"+
		"mo\5\25\13\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\36\3\2\2\2rv\7$"+
		"\2\2su\13\2\2\2ts\3\2\2\2ux\3\2\2\2vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3"+
		"\2\2\2yz\7$\2\2z \3\2\2\2{|\7\61\2\2|}\7,\2\2}\u0081\3\2\2\2~\u0080\13"+
		"\2\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\u0082\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7,\2\2\u0085"+
		"\u0086\7\61\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\21\2\2\u0088\"\3\2\2"+
		"\2\u0089\u008a\7\61\2\2\u008a\u008b\7\61\2\2\u008b\u008f\3\2\2\2\u008c"+
		"\u008e\n\4\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\b\22\2\2\u0093$\3\2\2\2\u0094\u0096\t\5\2\2\u0095\u0094\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u009a\b\23\2\2\u009a&\3\2\2\2\f\2Hbhjpv\u0081\u008f\u0097"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}