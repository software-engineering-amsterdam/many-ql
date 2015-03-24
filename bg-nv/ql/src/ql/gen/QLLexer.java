// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/ql/src/ql/syntax/QL.g4 by ANTLR 4.5
package ql.gen;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, QuestionType=20, Boolean=21, Identifier=22, Integer=23, 
		Decimal=24, String=25, Comment=26, LineComment=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "StringCharacter", "Quote", "EscapeSequence", "Letter", 
		"Digit", "NonZeroDigit", "ZeroDigit", "QuestionType", "Boolean", "Identifier", 
		"Integer", "Decimal", "String", "Comment", "LineComment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'-'", "'+'", "'!'", 
		"'*'", "'/'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "QuestionType", "Boolean", 
		"Identifier", "Integer", "Decimal", "String", "Comment", "LineComment", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u0102\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\5\25|\n\25\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\5\31\u0087\n\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00a8"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00b3\n\35\3\36"+
		"\3\36\3\36\3\36\7\36\u00b9\n\36\f\36\16\36\u00bc\13\36\3\37\3\37\3\37"+
		"\7\37\u00c1\n\37\f\37\16\37\u00c4\13\37\5\37\u00c6\n\37\3 \3 \7 \u00ca"+
		"\n \f \16 \u00cd\13 \3 \5 \u00d0\n \5 \u00d2\n \3 \3 \6 \u00d6\n \r \16"+
		" \u00d7\3!\3!\7!\u00dc\n!\f!\16!\u00df\13!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00e7"+
		"\n\"\f\"\16\"\u00ea\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00f5\n#\f"+
		"#\16#\u00f8\13#\3#\3#\3$\6$\u00fd\n$\r$\16$\u00fe\3$\3$\4\u00dd\u00e8"+
		"\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\2+\2-\2/\2\61\2\63\2\65\2\67\269\27;\30=\31"+
		"?\32A\33C\34E\35G\36\3\2\t\3\2^^\3\2$$\4\2C\\c|\3\2\63;\3\2\62\62\4\2"+
		"\f\f\17\17\5\2\13\f\17\17\"\"\u010d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5N\3\2\2\2\7P\3\2\2\2\tR\3\2\2\2\13"+
		"U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25_\3\2\2\2\27"+
		"a\3\2\2\2\31c\3\2\2\2\33e\3\2\2\2\35g\3\2\2\2\37j\3\2\2\2!m\3\2\2\2#p"+
		"\3\2\2\2%s\3\2\2\2\'v\3\2\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0082"+
		"\3\2\2\2\61\u0086\3\2\2\2\63\u0088\3\2\2\2\65\u008a\3\2\2\2\67\u00a7\3"+
		"\2\2\29\u00b2\3\2\2\2;\u00b4\3\2\2\2=\u00c5\3\2\2\2?\u00d1\3\2\2\2A\u00d9"+
		"\3\2\2\2C\u00e2\3\2\2\2E\u00f0\3\2\2\2G\u00fc\3\2\2\2IJ\7h\2\2JK\7q\2"+
		"\2KL\7t\2\2LM\7o\2\2M\4\3\2\2\2NO\7}\2\2O\6\3\2\2\2PQ\7\177\2\2Q\b\3\2"+
		"\2\2RS\7k\2\2ST\7h\2\2T\n\3\2\2\2UV\7*\2\2V\f\3\2\2\2WX\7+\2\2X\16\3\2"+
		"\2\2YZ\7/\2\2Z\20\3\2\2\2[\\\7-\2\2\\\22\3\2\2\2]^\7#\2\2^\24\3\2\2\2"+
		"_`\7,\2\2`\26\3\2\2\2ab\7\61\2\2b\30\3\2\2\2cd\7>\2\2d\32\3\2\2\2ef\7"+
		"@\2\2f\34\3\2\2\2gh\7>\2\2hi\7?\2\2i\36\3\2\2\2jk\7@\2\2kl\7?\2\2l \3"+
		"\2\2\2mn\7?\2\2no\7?\2\2o\"\3\2\2\2pq\7#\2\2qr\7?\2\2r$\3\2\2\2st\7(\2"+
		"\2tu\7(\2\2u&\3\2\2\2vw\7~\2\2wx\7~\2\2x(\3\2\2\2y|\5-\27\2z|\n\2\2\2"+
		"{y\3\2\2\2{z\3\2\2\2|*\3\2\2\2}~\t\3\2\2~,\3\2\2\2\177\u0080\7^\2\2\u0080"+
		"\u0081\5+\26\2\u0081.\3\2\2\2\u0082\u0083\t\4\2\2\u0083\60\3\2\2\2\u0084"+
		"\u0087\5\65\33\2\u0085\u0087\5\63\32\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\62\3\2\2\2\u0088\u0089\t\5\2\2\u0089\64\3\2\2\2\u008a\u008b"+
		"\t\6\2\2\u008b\66\3\2\2\2\u008c\u008d\7d\2\2\u008d\u008e\7q\2\2\u008e"+
		"\u008f\7q\2\2\u008f\u0090\7n\2\2\u0090\u0091\7g\2\2\u0091\u0092\7c\2\2"+
		"\u0092\u00a8\7p\2\2\u0093\u0094\7f\2\2\u0094\u0095\7g\2\2\u0095\u0096"+
		"\7e\2\2\u0096\u0097\7k\2\2\u0097\u0098\7o\2\2\u0098\u0099\7c\2\2\u0099"+
		"\u00a8\7n\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d\7v\2\2"+
		"\u009d\u009e\7g\2\2\u009e\u009f\7i\2\2\u009f\u00a0\7g\2\2\u00a0\u00a8"+
		"\7t\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7t\2\2\u00a4"+
		"\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a8\7i\2\2\u00a7\u008c\3\2\2"+
		"\2\u00a7\u0093\3\2\2\2\u00a7\u009a\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a88"+
		"\3\2\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7w\2\2\u00ac"+
		"\u00b3\7g\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2"+
		"\u00b0\u00b1\7u\2\2\u00b1\u00b3\7g\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00ad"+
		"\3\2\2\2\u00b3:\3\2\2\2\u00b4\u00ba\5/\30\2\u00b5\u00b9\5/\30\2\u00b6"+
		"\u00b9\5\61\31\2\u00b7\u00b9\7a\2\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb<\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c6\5\65\33"+
		"\2\u00be\u00c2\5\63\32\2\u00bf\u00c1\5\61\31\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00be\3\2\2\2\u00c6"+
		">\3\2\2\2\u00c7\u00cb\5\63\32\2\u00c8\u00ca\5\61\31\2\u00c9\u00c8\3\2"+
		"\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00d2\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\5\65\33\2\u00cf\u00ce\3"+
		"\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00c7\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\7\60\2\2\u00d4\u00d6\5"+
		"\61\31\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8@\3\2\2\2\u00d9\u00dd\5+\26\2\u00da\u00dc\5)\25\2"+
		"\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00de\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\5+\26\2\u00e1"+
		"B\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e8\3\2\2\2"+
		"\u00e5\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\7,\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b\""+
		"\2\2\u00efD\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f6"+
		"\3\2\2\2\u00f3\u00f5\n\7\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00fa\b#\2\2\u00faF\3\2\2\2\u00fb\u00fd\t\b\2\2\u00fc\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\b$\2\2\u0101H\3\2\2\2\23\2{\u0086\u00a7\u00b2"+
		"\u00b8\u00ba\u00c2\u00c5\u00cb\u00cf\u00d1\u00d7\u00dd\u00e8\u00f6\u00fe"+
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