// Generated from nl\u005Cuva\bromance\parsers\QLS.g4 by ANTLR 4.5
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
public class QLSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6, NUMBER=7, TEXT=8, COMMENT=9, 
		WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "STRING", "ESC", "UNICODE", "HEX", 
		"NUMBER", "INT", "EXP", "NL", "TEXT", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Page:'", "'{'", "'}'", "'Section:'", "'Question:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "STRING", "NUMBER", "TEXT", "COMMENT", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\u009c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7D\n\7\f\7\16\7G"+
		"\13\7\3\7\3\7\3\b\3\b\3\b\5\bN\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\5\13Y\n\13\3\13\3\13\3\13\6\13^\n\13\r\13\16\13_\3\13\5\13c\n\13\3\13"+
		"\5\13f\n\13\3\13\3\13\3\13\3\13\5\13l\n\13\3\13\5\13o\n\13\3\f\3\f\3\f"+
		"\7\ft\n\f\f\f\16\fw\13\f\5\fy\n\f\3\r\3\r\5\r}\n\r\3\r\3\r\3\16\3\16\3"+
		"\16\5\16\u0084\n\16\3\17\6\17\u0087\n\17\r\17\16\17\u0088\3\20\3\20\3"+
		"\20\3\20\7\20\u008f\n\20\f\20\16\20\u0092\13\20\3\20\3\20\3\21\6\21\u0097"+
		"\n\21\r\21\16\21\u0098\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\2"+
		"\21\2\23\2\25\t\27\2\31\2\33\2\35\n\37\13!\f\3\2\f\4\2$$^^\n\2$$\61\61"+
		"^^ddhhppttvv\5\2\62;CHch\3\2\62;\3\2\63;\4\2GGgg\4\2--//\4\2\f\f\17\17"+
		"\b\2\60\60\62;C\\^^aac|\5\2\13\f\17\17\"\"\u00a6\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3"+
		"\2\2\2\13\66\3\2\2\2\r@\3\2\2\2\17J\3\2\2\2\21O\3\2\2\2\23U\3\2\2\2\25"+
		"n\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33\u0083\3\2\2\2\35\u0086\3\2\2\2\37"+
		"\u008a\3\2\2\2!\u0096\3\2\2\2#$\7R\2\2$%\7c\2\2%&\7i\2\2&\'\7g\2\2\'("+
		"\7<\2\2(\4\3\2\2\2)*\7}\2\2*\6\3\2\2\2+,\7\177\2\2,\b\3\2\2\2-.\7U\2\2"+
		"./\7g\2\2/\60\7e\2\2\60\61\7v\2\2\61\62\7k\2\2\62\63\7q\2\2\63\64\7p\2"+
		"\2\64\65\7<\2\2\65\n\3\2\2\2\66\67\7S\2\2\678\7w\2\289\7g\2\29:\7u\2\2"+
		":;\7v\2\2;<\7k\2\2<=\7q\2\2=>\7p\2\2>?\7<\2\2?\f\3\2\2\2@E\7$\2\2AD\5"+
		"\17\b\2BD\n\2\2\2CA\3\2\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH"+
		"\3\2\2\2GE\3\2\2\2HI\7$\2\2I\16\3\2\2\2JM\7^\2\2KN\t\3\2\2LN\5\21\t\2"+
		"MK\3\2\2\2ML\3\2\2\2N\20\3\2\2\2OP\7w\2\2PQ\5\23\n\2QR\5\23\n\2RS\5\23"+
		"\n\2ST\5\23\n\2T\22\3\2\2\2UV\t\4\2\2V\24\3\2\2\2WY\7/\2\2XW\3\2\2\2X"+
		"Y\3\2\2\2YZ\3\2\2\2Z[\5\27\f\2[]\7\60\2\2\\^\t\5\2\2]\\\3\2\2\2^_\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\5\31\r\2ba\3\2\2\2bc\3\2\2\2co\3"+
		"\2\2\2df\7/\2\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\5\27\f\2hi\5\31\r\2io"+
		"\3\2\2\2jl\7/\2\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mo\5\27\f\2nX\3\2\2\2n"+
		"e\3\2\2\2nk\3\2\2\2o\26\3\2\2\2py\7\62\2\2qu\t\6\2\2rt\t\5\2\2sr\3\2\2"+
		"\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xp\3\2\2\2xq\3\2\2"+
		"\2y\30\3\2\2\2z|\t\7\2\2{}\t\b\2\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177"+
		"\5\27\f\2\177\32\3\2\2\2\u0080\u0081\7\17\2\2\u0081\u0084\7\f\2\2\u0082"+
		"\u0084\t\t\2\2\u0083\u0080\3\2\2\2\u0083\u0082\3\2\2\2\u0084\34\3\2\2"+
		"\2\u0085\u0087\t\n\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\36\3\2\2\2\u008a\u008b\7\61\2\2\u008b"+
		"\u008c\7\61\2\2\u008c\u0090\3\2\2\2\u008d\u008f\n\t\2\2\u008e\u008d\3"+
		"\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\b\20\2\2\u0094 \3\2\2\2"+
		"\u0095\u0097\t\13\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\21\2\2"+
		"\u009b\"\3\2\2\2\23\2CEMX_beknux|\u0083\u0088\u0090\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}