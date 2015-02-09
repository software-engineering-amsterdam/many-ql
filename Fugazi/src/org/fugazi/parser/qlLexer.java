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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ARITHMETIC_EXPRESSION=9, 
		MUL=10, DIV=11, ADD=12, SUB=13, ASSIGN=14, LOGICAL_EXPORESSION=15, AND=16, 
		OR=17, NOT=18, LT=19, LE=20, ST=21, SE=22, EQ=23, NE=24, ID=25, WORD=26, 
		BOOLEAN=27, INT=28, FLOAT=29, NEWLINE=30, COMMENT=31, WS=32, LINE_COMMENT=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "ARITHMETIC_EXPRESSION", 
		"MUL", "DIV", "ADD", "SUB", "ASSIGN", "LOGICAL_EXPORESSION", "AND", "OR", 
		"NOT", "LT", "LE", "ST", "SE", "EQ", "NE", "ID", "WORD", "BOOLEAN", "INT", 
		"FLOAT", "NEWLINE", "COMMENT", "WS", "LINE_COMMENT", "ESC", "UNICODE", 
		"HEX", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "';'", "'bool'", null, 
		"'*'", "'/'", "'+'", "'-'", "'='", null, "'&&'", "'||'", "'!'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "ARITHMETIC_EXPRESSION", 
		"MUL", "DIV", "ADD", "SUB", "ASSIGN", "LOGICAL_EXPORESSION", "AND", "OR", 
		"NOT", "LT", "LE", "ST", "SE", "EQ", "NE", "ID", "WORD", "BOOLEAN", "INT", 
		"FLOAT", "NEWLINE", "COMMENT", "WS", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00fa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\5\ni\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20~\n\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\6\32\u0099\n\32\r\32\16\32\u009a\3\33\3"+
		"\33\3\33\7\33\u00a0\n\33\f\33\16\33\u00a3\13\33\3\33\3\33\3\34\3\34\3"+
		"\35\6\35\u00aa\n\35\r\35\16\35\u00ab\3\36\6\36\u00af\n\36\r\36\16\36\u00b0"+
		"\3\36\3\36\7\36\u00b5\n\36\f\36\16\36\u00b8\13\36\3\36\3\36\6\36\u00bc"+
		"\n\36\r\36\16\36\u00bd\5\36\u00c0\n\36\3\37\5\37\u00c3\n\37\3\37\3\37"+
		"\3 \3 \3 \3 \7 \u00cb\n \f \16 \u00ce\13 \3 \3 \3 \3 \3 \3!\6!\u00d6\n"+
		"!\r!\16!\u00d7\3!\3!\3\"\3\"\3\"\3\"\7\"\u00e0\n\"\f\"\16\"\u00e3\13\""+
		"\3\"\5\"\u00e6\n\"\3\"\3\"\3\"\3\"\3#\3#\3#\5#\u00ef\n#\3$\3$\3$\3$\3"+
		"$\3$\3%\3%\3&\3&\3\u00cc\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2K\2\3\2\n\4\2C\\c|\4\2"+
		"$$^^\b\2$$ccghnntw~~\5\2\13\f\16\17\"\"\4\2\f\f\17\17\n\2$$\61\61^^dd"+
		"hhppttvv\5\2\62;CHch\3\2\62;\u010e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\3M\3\2\2\2\5R\3\2\2\2\7T\3\2\2\2\tV\3\2\2\2\13Y\3\2\2\2"+
		"\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23h\3\2\2\2\25j\3\2\2\2\27l\3\2\2"+
		"\2\31n\3\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0082"+
		"\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008c\3\2\2\2"+
		"-\u008e\3\2\2\2/\u0091\3\2\2\2\61\u0094\3\2\2\2\63\u0098\3\2\2\2\65\u009c"+
		"\3\2\2\2\67\u00a6\3\2\2\29\u00a9\3\2\2\2;\u00bf\3\2\2\2=\u00c2\3\2\2\2"+
		"?\u00c6\3\2\2\2A\u00d5\3\2\2\2C\u00db\3\2\2\2E\u00eb\3\2\2\2G\u00f0\3"+
		"\2\2\2I\u00f6\3\2\2\2K\u00f8\3\2\2\2MN\7h\2\2NO\7q\2\2OP\7t\2\2PQ\7o\2"+
		"\2Q\4\3\2\2\2RS\7}\2\2S\6\3\2\2\2TU\7\177\2\2U\b\3\2\2\2VW\7k\2\2WX\7"+
		"h\2\2X\n\3\2\2\2YZ\7*\2\2Z\f\3\2\2\2[\\\7+\2\2\\\16\3\2\2\2]^\7=\2\2^"+
		"\20\3\2\2\2_`\7d\2\2`a\7q\2\2ab\7q\2\2bc\7n\2\2c\22\3\2\2\2di\5\25\13"+
		"\2ei\5\27\f\2fi\5\31\r\2gi\5\33\16\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3"+
		"\2\2\2i\24\3\2\2\2jk\7,\2\2k\26\3\2\2\2lm\7\61\2\2m\30\3\2\2\2no\7-\2"+
		"\2o\32\3\2\2\2pq\7/\2\2q\34\3\2\2\2rs\7?\2\2s\36\3\2\2\2t~\5!\21\2u~\5"+
		"#\22\2v~\5%\23\2w~\5\'\24\2x~\5)\25\2y~\5+\26\2z~\5-\27\2{~\5/\30\2|~"+
		"\5\61\31\2}t\3\2\2\2}u\3\2\2\2}v\3\2\2\2}w\3\2\2\2}x\3\2\2\2}y\3\2\2\2"+
		"}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~ \3\2\2\2\177\u0080\7(\2\2\u0080\u0081"+
		"\7(\2\2\u0081\"\3\2\2\2\u0082\u0083\7~\2\2\u0083\u0084\7~\2\2\u0084$\3"+
		"\2\2\2\u0085\u0086\7#\2\2\u0086&\3\2\2\2\u0087\u0088\7@\2\2\u0088(\3\2"+
		"\2\2\u0089\u008a\7@\2\2\u008a\u008b\7?\2\2\u008b*\3\2\2\2\u008c\u008d"+
		"\7>\2\2\u008d,\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\7?\2\2\u0090.\3"+
		"\2\2\2\u0091\u0092\7?\2\2\u0092\u0093\7?\2\2\u0093\60\3\2\2\2\u0094\u0095"+
		"\7#\2\2\u0095\u0096\7?\2\2\u0096\62\3\2\2\2\u0097\u0099\t\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\64\3\2\2\2\u009c\u00a1\7$\2\2\u009d\u00a0\5E#\2\u009e\u00a0"+
		"\n\3\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a4\u00a5\7$\2\2\u00a5\66\3\2\2\2\u00a6\u00a7\t\4\2\2\u00a78\3"+
		"\2\2\2\u00a8\u00aa\5K&\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac:\3\2\2\2\u00ad\u00af\5K&\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\7\60\2\2\u00b3\u00b5\5K&\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00c0\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\60\2\2\u00ba"+
		"\u00bc\5K&\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2"+
		"\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00ae\3\2\2\2\u00bf\u00b9"+
		"\3\2\2\2\u00c0<\3\2\2\2\u00c1\u00c3\7\17\2\2\u00c2\u00c1\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\f\2\2\u00c5>\3\2\2\2"+
		"\u00c6\u00c7\7\61\2\2\u00c7\u00c8\7,\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb"+
		"\13\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2"+
		"\u00cc\u00ca\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0"+
		"\7,\2\2\u00d0\u00d1\7\61\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b \2\2\u00d3"+
		"@\3\2\2\2\u00d4\u00d6\t\5\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2"+
		"\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\b!\2\2\u00daB\3\2\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\7\61\2\2\u00dd"+
		"\u00e1\3\2\2\2\u00de\u00e0\n\6\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2"+
		"\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e6\7\17\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3"+
		"\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ea\b\"\2\2\u00eaD\3\2\2\2\u00eb\u00ee\7^\2\2\u00ec\u00ef\t\7\2\2\u00ed"+
		"\u00ef\5G$\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00efF\3\2\2\2\u00f0"+
		"\u00f1\7w\2\2\u00f1\u00f2\5I%\2\u00f2\u00f3\5I%\2\u00f3\u00f4\5I%\2\u00f4"+
		"\u00f5\5I%\2\u00f5H\3\2\2\2\u00f6\u00f7\t\b\2\2\u00f7J\3\2\2\2\u00f8\u00f9"+
		"\t\t\2\2\u00f9L\3\2\2\2\23\2h}\u009a\u009f\u00a1\u00ab\u00b0\u00b6\u00bd"+
		"\u00bf\u00c2\u00cc\u00d7\u00e1\u00e5\u00ee\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}