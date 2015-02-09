package anotherOne.grammar.saveit.trash;
// Generated from qlGrammar.g4 by ANTLR 4.0
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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, NEWLINE=7, WS=8, BOOL_TYPE=9, 
		STRING_TYPE=10, INT_TYPE=11, DATE_TYPE=12, DECIMAL_TYPE=13, MONEY_TYPE=14, 
		ADD=15, SUB=16, MUL=17, DIV=18, NOT=19, LT=20, GT=21, LEQ=22, GEQ=23, 
		EQ=24, NEQ=25, AND=26, OR=27, TRUE=28, FALSE=29, ID=30, INT=31, STRING=32, 
		COMMENT=33, MULTYLINE_COMMENT=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "')'", "'('", "'if'", "'else'", "'}'", "NEWLINE", "WS", "'boolean'", 
		"'string'", "'integer'", "'date'", "'decimal'", "'money'", "'+'", "'-'", 
		"'*'", "'/'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
		"'||'", "'true'", "'false'", "ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NEWLINE", "WS", "BOOL_TYPE", 
		"STRING_TYPE", "INT_TYPE", "DATE_TYPE", "DECIMAL_TYPE", "MONEY_TYPE", 
		"ADD", "SUB", "MUL", "DIV", "NOT", "LT", "GT", "LEQ", "GEQ", "EQ", "NEQ", 
		"AND", "OR", "TRUE", "FALSE", "ID", "INT", "STRING", "ESC", "UNICODE", 
		"HEX", "COMMENT", "MULTYLINE_COMMENT"
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
		case 7: WS_action((RuleContext)_localctx, actionIndex); break;

		case 35: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 36: MULTYLINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void MULTYLINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4$\u00ff\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\5\b_\n\b\3"+
		"\b\3\b\3\t\6\td\n\t\r\t\16\te\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u00c1\n\37\f\37\16\37\u00c4\13"+
		"\37\3 \6 \u00c7\n \r \16 \u00c8\3!\3!\3!\7!\u00ce\n!\f!\16!\u00d1\13!"+
		"\3!\3!\3\"\3\"\3\"\5\"\u00d8\n\"\3#\3#\3#\3#\3#\3#\3$\3$\3%\3%\3%\3%\7"+
		"%\u00e6\n%\f%\16%\u00e9\13%\3%\5%\u00ec\n%\3%\3%\3%\3%\3&\3&\3&\3&\7&"+
		"\u00f6\n&\f&\16&\u00f9\13&\3&\3&\3&\3&\3&\4\u00e7\u00f7\'\3\3\1\5\4\1"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\2\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31"+
		"\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C\2\1E\2\1"+
		"G\2\1I#\3K$\4\3\2\t\4\13\13\"\"\4C\\c|\5\62;C\\c|\3\62;\4$$^^\n$$\61\61"+
		"^^ddhhppttvv\5\62;CHch\u0105\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13V\3"+
		"\2\2\2\r[\3\2\2\2\17^\3\2\2\2\21c\3\2\2\2\23i\3\2\2\2\25q\3\2\2\2\27x"+
		"\3\2\2\2\31\u0080\3\2\2\2\33\u0085\3\2\2\2\35\u008d\3\2\2\2\37\u0093\3"+
		"\2\2\2!\u0095\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b\3\2\2\2)\u009d"+
		"\3\2\2\2+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00a4\3\2\2\2\61\u00a7\3\2\2\2"+
		"\63\u00aa\3\2\2\2\65\u00ad\3\2\2\2\67\u00b0\3\2\2\29\u00b3\3\2\2\2;\u00b8"+
		"\3\2\2\2=\u00be\3\2\2\2?\u00c6\3\2\2\2A\u00ca\3\2\2\2C\u00d4\3\2\2\2E"+
		"\u00d9\3\2\2\2G\u00df\3\2\2\2I\u00e1\3\2\2\2K\u00f1\3\2\2\2MN\7}\2\2N"+
		"\4\3\2\2\2OP\7+\2\2P\6\3\2\2\2QR\7*\2\2R\b\3\2\2\2ST\7k\2\2TU\7h\2\2U"+
		"\n\3\2\2\2VW\7g\2\2WX\7n\2\2XY\7u\2\2YZ\7g\2\2Z\f\3\2\2\2[\\\7\177\2\2"+
		"\\\16\3\2\2\2]_\7\17\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\f\2\2a\20\3"+
		"\2\2\2bd\t\2\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b"+
		"\t\2\2h\22\3\2\2\2ij\7d\2\2jk\7q\2\2kl\7q\2\2lm\7n\2\2mn\7g\2\2no\7c\2"+
		"\2op\7p\2\2p\24\3\2\2\2qr\7u\2\2rs\7v\2\2st\7t\2\2tu\7k\2\2uv\7p\2\2v"+
		"w\7i\2\2w\26\3\2\2\2xy\7k\2\2yz\7p\2\2z{\7v\2\2{|\7g\2\2|}\7i\2\2}~\7"+
		"g\2\2~\177\7t\2\2\177\30\3\2\2\2\u0080\u0081\7f\2\2\u0081\u0082\7c\2\2"+
		"\u0082\u0083\7v\2\2\u0083\u0084\7g\2\2\u0084\32\3\2\2\2\u0085\u0086\7"+
		"f\2\2\u0086\u0087\7g\2\2\u0087\u0088\7e\2\2\u0088\u0089\7k\2\2\u0089\u008a"+
		"\7o\2\2\u008a\u008b\7c\2\2\u008b\u008c\7n\2\2\u008c\34\3\2\2\2\u008d\u008e"+
		"\7o\2\2\u008e\u008f\7q\2\2\u008f\u0090\7p\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7{\2\2\u0092\36\3\2\2\2\u0093\u0094\7-\2\2\u0094 \3\2\2\2\u0095"+
		"\u0096\7/\2\2\u0096\"\3\2\2\2\u0097\u0098\7,\2\2\u0098$\3\2\2\2\u0099"+
		"\u009a\7\61\2\2\u009a&\3\2\2\2\u009b\u009c\7#\2\2\u009c(\3\2\2\2\u009d"+
		"\u009e\7>\2\2\u009e*\3\2\2\2\u009f\u00a0\7@\2\2\u00a0,\3\2\2\2\u00a1\u00a2"+
		"\7>\2\2\u00a2\u00a3\7?\2\2\u00a3.\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\u00a6"+
		"\7?\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9\62"+
		"\3\2\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ac\7?\2\2\u00ac\64\3\2\2\2\u00ad"+
		"\u00ae\7(\2\2\u00ae\u00af\7(\2\2\u00af\66\3\2\2\2\u00b0\u00b1\7~\2\2\u00b1"+
		"\u00b2\7~\2\2\u00b28\3\2\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7t\2\2\u00b5"+
		"\u00b6\7w\2\2\u00b6\u00b7\7g\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9"+
		"\u00ba\7c\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7g\2\2"+
		"\u00bd<\3\2\2\2\u00be\u00c2\t\3\2\2\u00bf\u00c1\t\4\2\2\u00c0\u00bf\3"+
		"\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		">\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c7\t\5\2\2\u00c6\u00c5\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9@\3"+
		"\2\2\2\u00ca\u00cf\7$\2\2\u00cb\u00ce\5C\"\2\u00cc\u00ce\n\6\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00d3\7$\2\2\u00d3B\3\2\2\2\u00d4\u00d7\7^\2\2\u00d5\u00d8\t\7\2\2\u00d6"+
		"\u00d8\5E#\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8D\3\2\2\2\u00d9"+
		"\u00da\7w\2\2\u00da\u00db\5G$\2\u00db\u00dc\5G$\2\u00dc\u00dd\5G$\2\u00dd"+
		"\u00de\5G$\2\u00deF\3\2\2\2\u00df\u00e0\t\b\2\2\u00e0H\3\2\2\2\u00e1\u00e2"+
		"\7\61\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e7\3\2\2\2\u00e4\u00e6\13\2\2"+
		"\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\7\17\2\2"+
		"\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee"+
		"\7\f\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b%\3\2\u00f0J\3\2\2\2\u00f1\u00f2"+
		"\7\61\2\2\u00f2\u00f3\7,\2\2\u00f3\u00f7\3\2\2\2\u00f4\u00f6\13\2\2\2"+
		"\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7,\2\2\u00fb"+
		"\u00fc\7\61\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b&\4\2\u00feL\3\2\2\2"+
		"\r\2^e\u00c2\u00c8\u00cd\u00cf\u00d7\u00e7\u00eb\u00f7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}