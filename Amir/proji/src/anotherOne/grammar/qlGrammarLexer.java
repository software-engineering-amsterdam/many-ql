// Generated from E:\workspace2\proji\src\anotherOne\grammar\qlGrammar.g4 by ANTLR 4.0
package anotherOne.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qlGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BOOL_TYPE=7, STRING_TYPE=8, 
		INT_TYPE=9, DATE_TYPE=10, DECIMAL_TYPE=11, MONEY_TYPE=12, ADD=13, SUB=14, 
		MUL=15, DIV=16, NOT=17, LT=18, GT=19, LEQ=20, GEQ=21, EQ=22, NEQ=23, AND=24, 
		OR=25, TRUE=26, FALSE=27, ID=28, INT=29, STRING=30, COMMENT=31, MULTYLINE_COMMENT=32, 
		WS=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "')'", "'('", "'if'", "'else'", "'}'", "'boolean'", "'string'", 
		"'integer'", "'date'", "'decimal'", "'money'", "'+'", "'-'", "'*'", "'/'", 
		"'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'true'", 
		"'false'", "ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BOOL_TYPE", "STRING_TYPE", 
		"INT_TYPE", "DATE_TYPE", "DECIMAL_TYPE", "MONEY_TYPE", "ADD", "SUB", "MUL", 
		"DIV", "NOT", "LT", "GT", "LEQ", "GEQ", "EQ", "NEQ", "AND", "OR", "TRUE", 
		"FALSE", "ID", "INT", "STRING", "ESC", "UNICODE", "HEX", "COMMENT", "MULTYLINE_COMMENT", 
		"WS"
	};


	public qlGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "qlGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 33: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 34: MULTYLINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 35: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void MULTYLINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4#\u00f8\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\7\35\u00b3\n\35\f\35\16\35\u00b6\13\35\3"+
		"\36\6\36\u00b9\n\36\r\36\16\36\u00ba\3\37\3\37\3\37\7\37\u00c0\n\37\f"+
		"\37\16\37\u00c3\13\37\3\37\3\37\3 \3 \3 \5 \u00ca\n \3!\3!\3!\3!\3!\3"+
		"!\3\"\3\"\3#\3#\3#\3#\7#\u00d8\n#\f#\16#\u00db\13#\3#\5#\u00de\n#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\7$\u00e8\n$\f$\16$\u00eb\13$\3$\3$\3$\3$\3$\3%\6%"+
		"\u00f3\n%\r%\16%\u00f4\3%\3%\4\u00d9\u00e9&\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?\2\1A\2\1C\2\1E!\2G\"\3I#\4\3\2\t\4"+
		"C\\c|\5\62;C\\c|\3\62;\4$$^^\n$$\61\61^^ddhhppttvv\5\62;CHch\5\13\f\17"+
		"\17\"\"\u00fd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2"+
		"\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13T\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2"+
		"\21c\3\2\2\2\23j\3\2\2\2\25r\3\2\2\2\27w\3\2\2\2\31\177\3\2\2\2\33\u0085"+
		"\3\2\2\2\35\u0087\3\2\2\2\37\u0089\3\2\2\2!\u008b\3\2\2\2#\u008d\3\2\2"+
		"\2%\u008f\3\2\2\2\'\u0091\3\2\2\2)\u0093\3\2\2\2+\u0096\3\2\2\2-\u0099"+
		"\3\2\2\2/\u009c\3\2\2\2\61\u009f\3\2\2\2\63\u00a2\3\2\2\2\65\u00a5\3\2"+
		"\2\2\67\u00aa\3\2\2\29\u00b0\3\2\2\2;\u00b8\3\2\2\2=\u00bc\3\2\2\2?\u00c6"+
		"\3\2\2\2A\u00cb\3\2\2\2C\u00d1\3\2\2\2E\u00d3\3\2\2\2G\u00e3\3\2\2\2I"+
		"\u00f2\3\2\2\2KL\7}\2\2L\4\3\2\2\2MN\7+\2\2N\6\3\2\2\2OP\7*\2\2P\b\3\2"+
		"\2\2QR\7k\2\2RS\7h\2\2S\n\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7u\2\2WX\7g\2\2"+
		"X\f\3\2\2\2YZ\7\177\2\2Z\16\3\2\2\2[\\\7d\2\2\\]\7q\2\2]^\7q\2\2^_\7n"+
		"\2\2_`\7g\2\2`a\7c\2\2ab\7p\2\2b\20\3\2\2\2cd\7u\2\2de\7v\2\2ef\7t\2\2"+
		"fg\7k\2\2gh\7p\2\2hi\7i\2\2i\22\3\2\2\2jk\7k\2\2kl\7p\2\2lm\7v\2\2mn\7"+
		"g\2\2no\7i\2\2op\7g\2\2pq\7t\2\2q\24\3\2\2\2rs\7f\2\2st\7c\2\2tu\7v\2"+
		"\2uv\7g\2\2v\26\3\2\2\2wx\7f\2\2xy\7g\2\2yz\7e\2\2z{\7k\2\2{|\7o\2\2|"+
		"}\7c\2\2}~\7n\2\2~\30\3\2\2\2\177\u0080\7o\2\2\u0080\u0081\7q\2\2\u0081"+
		"\u0082\7p\2\2\u0082\u0083\7g\2\2\u0083\u0084\7{\2\2\u0084\32\3\2\2\2\u0085"+
		"\u0086\7-\2\2\u0086\34\3\2\2\2\u0087\u0088\7/\2\2\u0088\36\3\2\2\2\u0089"+
		"\u008a\7,\2\2\u008a \3\2\2\2\u008b\u008c\7\61\2\2\u008c\"\3\2\2\2\u008d"+
		"\u008e\7#\2\2\u008e$\3\2\2\2\u008f\u0090\7>\2\2\u0090&\3\2\2\2\u0091\u0092"+
		"\7@\2\2\u0092(\3\2\2\2\u0093\u0094\7>\2\2\u0094\u0095\7?\2\2\u0095*\3"+
		"\2\2\2\u0096\u0097\7@\2\2\u0097\u0098\7?\2\2\u0098,\3\2\2\2\u0099\u009a"+
		"\7?\2\2\u009a\u009b\7?\2\2\u009b.\3\2\2\2\u009c\u009d\7#\2\2\u009d\u009e"+
		"\7?\2\2\u009e\60\3\2\2\2\u009f\u00a0\7(\2\2\u00a0\u00a1\7(\2\2\u00a1\62"+
		"\3\2\2\2\u00a2\u00a3\7~\2\2\u00a3\u00a4\7~\2\2\u00a4\64\3\2\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7g\2\2"+
		"\u00a9\66\3\2\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7"+
		"n\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af8\3\2\2\2\u00b0\u00b4"+
		"\t\2\2\2\u00b1\u00b3\t\3\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5:\3\2\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b7\u00b9\t\4\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb<\3\2\2\2\u00bc\u00c1\7$\2\2\u00bd\u00c0"+
		"\5? \2\u00be\u00c0\n\5\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7$\2\2\u00c5>\3\2\2\2\u00c6\u00c9"+
		"\7^\2\2\u00c7\u00ca\t\6\2\2\u00c8\u00ca\5A!\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca@\3\2\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\5C\"\2\u00cd"+
		"\u00ce\5C\"\2\u00ce\u00cf\5C\"\2\u00cf\u00d0\5C\"\2\u00d0B\3\2\2\2\u00d1"+
		"\u00d2\t\7\2\2\u00d2D\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d5\7\61\2"+
		"\2\u00d5\u00d9\3\2\2\2\u00d6\u00d8\13\2\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\u00db\3\2\2\2\u00d9\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2"+
		"\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\7\17\2\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7\f\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\b#\2\2\u00e2F\3\2\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e5"+
		"\7,\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e8\13\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7,\2\2\u00ed\u00ee\7\61\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\b$\3\2\u00f0H\3\2\2\2\u00f1\u00f3\t\b\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\b%\4\2\u00f7J\3\2\2\2\f\2\u00b4\u00ba"+
		"\u00bf\u00c1\u00c9\u00d9\u00dd\u00e9\u00f4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}