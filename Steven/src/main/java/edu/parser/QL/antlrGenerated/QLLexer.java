// Generated from E:/development/Steven/src/test/resources/antlr/grammars\QL.g4 by ANTLR 4.5
package edu.parser.QL.antlrGenerated;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, UPPERCASE=23, LOWERCASE=24, 
		NUMBERS=25, STRING=26, COMMENT_LINE=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "UPPERCASE", "LOWERCASE", 
		"NUMBERS", "STRING", "COMMENT_LINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'!'", "'true'", 
		"'false'", "'*'", "'/'", "'+'", "'-'", "'>'", "'<'", "'<='", "'>='", "'=='", 
		"'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "UPPERCASE", 
		"LOWERCASE", "NUMBERS", "STRING", "COMMENT_LINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00a7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\6\30}\n\30"+
		"\r\30\16\30~\3\31\6\31\u0082\n\31\r\31\16\31\u0083\3\32\6\32\u0087\n\32"+
		"\r\32\16\32\u0088\3\33\3\33\3\33\3\33\7\33\u008f\n\33\f\33\16\33\u0092"+
		"\13\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u009a\n\34\f\34\16\34\u009d"+
		"\13\34\3\34\3\34\3\35\6\35\u00a2\n\35\r\35\16\35\u00a3\3\35\3\35\2\2\36"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3"+
		"\2\b\3\2C\\\3\2c|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17"+
		"\"\"\u00ad\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\3;\3\2\2\2\5@\3\2\2\2\7B\3\2\2\2\tD\3\2\2\2\13G\3\2\2\2\rI\3\2\2"+
		"\2\17K\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25W\3\2\2\2\27]\3\2\2\2\31_\3\2"+
		"\2\2\33a\3\2\2\2\35c\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#i\3\2\2\2%l\3\2\2\2"+
		"\'o\3\2\2\2)r\3\2\2\2+u\3\2\2\2-x\3\2\2\2/|\3\2\2\2\61\u0081\3\2\2\2\63"+
		"\u0086\3\2\2\2\65\u008a\3\2\2\2\67\u0095\3\2\2\29\u00a1\3\2\2\2;<\7h\2"+
		"\2<=\7q\2\2=>\7t\2\2>?\7o\2\2?\4\3\2\2\2@A\7}\2\2A\6\3\2\2\2BC\7\177\2"+
		"\2C\b\3\2\2\2DE\7k\2\2EF\7h\2\2F\n\3\2\2\2GH\7*\2\2H\f\3\2\2\2IJ\7+\2"+
		"\2J\16\3\2\2\2KL\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2O\20\3\2\2\2PQ\7#\2"+
		"\2Q\22\3\2\2\2RS\7v\2\2ST\7t\2\2TU\7w\2\2UV\7g\2\2V\24\3\2\2\2WX\7h\2"+
		"\2XY\7c\2\2YZ\7n\2\2Z[\7u\2\2[\\\7g\2\2\\\26\3\2\2\2]^\7,\2\2^\30\3\2"+
		"\2\2_`\7\61\2\2`\32\3\2\2\2ab\7-\2\2b\34\3\2\2\2cd\7/\2\2d\36\3\2\2\2"+
		"ef\7@\2\2f \3\2\2\2gh\7>\2\2h\"\3\2\2\2ij\7>\2\2jk\7?\2\2k$\3\2\2\2lm"+
		"\7@\2\2mn\7?\2\2n&\3\2\2\2op\7?\2\2pq\7?\2\2q(\3\2\2\2rs\7#\2\2st\7?\2"+
		"\2t*\3\2\2\2uv\7(\2\2vw\7(\2\2w,\3\2\2\2xy\7~\2\2yz\7~\2\2z.\3\2\2\2{"+
		"}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\60\3\2\2\2\u0080"+
		"\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\62\3\2\2\2\u0085\u0087\t\4\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\64\3\2\2\2\u008a\u0090\7$\2\2\u008b\u008f\n\5\2\2\u008c\u008d\7$\2\2"+
		"\u008d\u008f\7$\2\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0092"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7$\2\2\u0094\66\3\2\2\2\u0095\u0096\7\61\2"+
		"\2\u0096\u0097\7\61\2\2\u0097\u009b\3\2\2\2\u0098\u009a\n\6\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\b\34\2\2\u009f"+
		"8\3\2\2\2\u00a0\u00a2\t\7\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2"+
		"\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6"+
		"\b\35\2\2\u00a6:\3\2\2\2\n\2~\u0083\u0088\u008e\u0090\u009b\u00a3\3\b"+
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