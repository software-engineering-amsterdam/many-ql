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
		T__9=10, Keywords=11, QuestionType=12, Identifier=13, Integer=14, String=15, 
		Comment=16, LineComment=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "Letter", "Digit", "Keywords", "QuestionType", "Identifier", "Integer", 
		"String", "Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'*'", 
		"'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "Keywords", 
		"QuestionType", "Identifier", "Integer", "String", "Comment", "LineComment", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16Q\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17k\n\17\3\20\3\20\3\20"+
		"\3\20\7\20q\n\20\f\20\16\20t\13\20\3\21\6\21w\n\21\r\21\16\21x\3\22\3"+
		"\22\7\22}\n\22\f\22\16\22\u0080\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7"+
		"\23\u0088\n\23\f\23\16\23\u008b\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\7\24\u0096\n\24\f\24\16\24\u0099\13\24\3\24\3\24\3\25\6"+
		"\25\u009e\n\25\r\25\16\25\u009f\3\25\3\25\4~\u0089\2\26\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\r\35\16\37\17!\20#\21%\22"+
		"\'\23)\24\3\2\6\4\2C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00ac"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\3+\3\2\2\2\5\60\3\2\2\2\7\62\3\2\2\2\t\64\3\2\2\2\13\67"+
		"\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2\2\2\27"+
		"C\3\2\2\2\31E\3\2\2\2\33P\3\2\2\2\35j\3\2\2\2\37l\3\2\2\2!v\3\2\2\2#z"+
		"\3\2\2\2%\u0083\3\2\2\2\'\u0091\3\2\2\2)\u009d\3\2\2\2+,\7h\2\2,-\7q\2"+
		"\2-.\7t\2\2./\7o\2\2/\4\3\2\2\2\60\61\7}\2\2\61\6\3\2\2\2\62\63\7\177"+
		"\2\2\63\b\3\2\2\2\64\65\7k\2\2\65\66\7h\2\2\66\n\3\2\2\2\678\7*\2\28\f"+
		"\3\2\2\29:\7+\2\2:\16\3\2\2\2;<\7/\2\2<\20\3\2\2\2=>\7-\2\2>\22\3\2\2"+
		"\2?@\7,\2\2@\24\3\2\2\2AB\7\61\2\2B\26\3\2\2\2CD\t\2\2\2D\30\3\2\2\2E"+
		"F\t\3\2\2F\32\3\2\2\2GH\7v\2\2HI\7t\2\2IJ\7w\2\2JQ\7g\2\2KL\7h\2\2LM\7"+
		"c\2\2MN\7n\2\2NO\7u\2\2OQ\7g\2\2PG\3\2\2\2PK\3\2\2\2Q\34\3\2\2\2RS\7d"+
		"\2\2ST\7q\2\2TU\7q\2\2UV\7n\2\2VW\7g\2\2WX\7c\2\2Xk\7p\2\2YZ\7k\2\2Z["+
		"\7p\2\2[\\\7v\2\2\\]\7g\2\2]^\7i\2\2^_\7g\2\2_k\7t\2\2`a\7u\2\2ab\7v\2"+
		"\2bc\7t\2\2cd\7k\2\2de\7p\2\2ek\7i\2\2fg\7f\2\2gh\7c\2\2hi\7v\2\2ik\7"+
		"g\2\2jR\3\2\2\2jY\3\2\2\2j`\3\2\2\2jf\3\2\2\2k\36\3\2\2\2lr\5\27\f\2m"+
		"q\5\27\f\2nq\5\31\r\2oq\7a\2\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2qt\3\2\2\2"+
		"rp\3\2\2\2rs\3\2\2\2s \3\2\2\2tr\3\2\2\2uw\5\31\r\2vu\3\2\2\2wx\3\2\2"+
		"\2xv\3\2\2\2xy\3\2\2\2y\"\3\2\2\2z~\7$\2\2{}\13\2\2\2|{\3\2\2\2}\u0080"+
		"\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\u0082\7$\2\2\u0082$\3\2\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7,\2\2\u0085"+
		"\u0089\3\2\2\2\u0086\u0088\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\7,\2\2\u008d\u008e\7\61\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\b\23\2\2\u0090&\3\2\2\2\u0091\u0092\7\61\2\2\u0092\u0093"+
		"\7\61\2\2\u0093\u0097\3\2\2\2\u0094\u0096\n\4\2\2\u0095\u0094\3\2\2\2"+
		"\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\b\24\2\2\u009b(\3\2\2\2\u009c"+
		"\u009e\t\5\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\25\2\2\u00a2"+
		"*\3\2\2\2\f\2Pjprx~\u0089\u0097\u009f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}