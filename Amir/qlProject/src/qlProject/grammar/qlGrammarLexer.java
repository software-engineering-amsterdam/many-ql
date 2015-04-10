// Generated from E:\workspace2\qlProject\src\qlProject\grammar\qlGrammar.g4 by ANTLR 4.0
package qlProject.grammar;
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
		T__3=1, T__2=2, T__1=3, T__0=4, BOOL_TYPE=5, STRING_TYPE=6, INT_TYPE=7, 
		ADD=8, SUB=9, MUL=10, DIV=11, CONCAT=12, NOT=13, LT=14, GT=15, LEQ=16, 
		GEQ=17, EQ=18, NEQ=19, AND=20, OR=21, IF=22, ELSE=23, TRUE=24, FALSE=25, 
		ID=26, INT=27, STRING=28, COMMENT=29, MULTYLINE_COMMENT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "')'", "'('", "'}'", "'boolean'", "'string'", "'integer'", "'+'", 
		"'-'", "'*'", "'/'", "'++'", "'!'", "'<'", "'>'", "'<='", "'>='", "'=='", 
		"'!='", "'&&'", "'||'", "'if'", "'else'", "'true'", "'false'", "ID", "INT", 
		"STRING", "COMMENT", "MULTYLINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "BOOL_TYPE", "STRING_TYPE", "INT_TYPE", 
		"ADD", "SUB", "MUL", "DIV", "CONCAT", "NOT", "LT", "GT", "LEQ", "GEQ", 
		"EQ", "NEQ", "AND", "OR", "IF", "ELSE", "TRUE", "FALSE", "ID", "INT", 
		"STRING", "ESC", "UNICODE", "HEX", "COMMENT", "MULTYLINE_COMMENT", "WS"
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
		case 31: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 32: MULTYLINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 33: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4!\u00e4\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\7\33\u009f\n\33\f\33\16\33\u00a2\13\33\3\34\6\34\u00a5"+
		"\n\34\r\34\16\34\u00a6\3\35\3\35\3\35\7\35\u00ac\n\35\f\35\16\35\u00af"+
		"\13\35\3\35\3\35\3\36\3\36\3\36\5\36\u00b6\n\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3!\7!\u00c4\n!\f!\16!\u00c7\13!\3!\5!\u00ca\n"+
		"!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00d4\n\"\f\"\16\"\u00d7\13\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\6#\u00df\n#\r#\16#\u00e0\3#\3#\4\u00c5\u00d5$\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30"+
		"\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\2\1=\2\1?\2\1A\37\2C "+
		"\3E!\4\3\2\t\4C\\c|\5\62;C\\c|\3\62;\4$$^^\n$$\61\61^^ddhhppttvv\5\62"+
		";CHch\5\13\f\17\17\"\"\u00e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I"+
		"\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rW\3\2\2\2\17^\3\2\2\2\21f"+
		"\3\2\2\2\23h\3\2\2\2\25j\3\2\2\2\27l\3\2\2\2\31n\3\2\2\2\33q\3\2\2\2\35"+
		"s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#z\3\2\2\2%}\3\2\2\2\'\u0080\3\2\2\2)\u0083"+
		"\3\2\2\2+\u0086\3\2\2\2-\u0089\3\2\2\2/\u008c\3\2\2\2\61\u0091\3\2\2\2"+
		"\63\u0096\3\2\2\2\65\u009c\3\2\2\2\67\u00a4\3\2\2\29\u00a8\3\2\2\2;\u00b2"+
		"\3\2\2\2=\u00b7\3\2\2\2?\u00bd\3\2\2\2A\u00bf\3\2\2\2C\u00cf\3\2\2\2E"+
		"\u00de\3\2\2\2GH\7}\2\2H\4\3\2\2\2IJ\7+\2\2J\6\3\2\2\2KL\7*\2\2L\b\3\2"+
		"\2\2MN\7\177\2\2N\n\3\2\2\2OP\7d\2\2PQ\7q\2\2QR\7q\2\2RS\7n\2\2ST\7g\2"+
		"\2TU\7c\2\2UV\7p\2\2V\f\3\2\2\2WX\7u\2\2XY\7v\2\2YZ\7t\2\2Z[\7k\2\2[\\"+
		"\7p\2\2\\]\7i\2\2]\16\3\2\2\2^_\7k\2\2_`\7p\2\2`a\7v\2\2ab\7g\2\2bc\7"+
		"i\2\2cd\7g\2\2de\7t\2\2e\20\3\2\2\2fg\7-\2\2g\22\3\2\2\2hi\7/\2\2i\24"+
		"\3\2\2\2jk\7,\2\2k\26\3\2\2\2lm\7\61\2\2m\30\3\2\2\2no\7-\2\2op\7-\2\2"+
		"p\32\3\2\2\2qr\7#\2\2r\34\3\2\2\2st\7>\2\2t\36\3\2\2\2uv\7@\2\2v \3\2"+
		"\2\2wx\7>\2\2xy\7?\2\2y\"\3\2\2\2z{\7@\2\2{|\7?\2\2|$\3\2\2\2}~\7?\2\2"+
		"~\177\7?\2\2\177&\3\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082"+
		"(\3\2\2\2\u0083\u0084\7(\2\2\u0084\u0085\7(\2\2\u0085*\3\2\2\2\u0086\u0087"+
		"\7~\2\2\u0087\u0088\7~\2\2\u0088,\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7h\2\2\u008b.\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e\7n\2\2\u008e\u008f"+
		"\7u\2\2\u008f\u0090\7g\2\2\u0090\60\3\2\2\2\u0091\u0092\7v\2\2\u0092\u0093"+
		"\7t\2\2\u0093\u0094\7w\2\2\u0094\u0095\7g\2\2\u0095\62\3\2\2\2\u0096\u0097"+
		"\7h\2\2\u0097\u0098\7c\2\2\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a"+
		"\u009b\7g\2\2\u009b\64\3\2\2\2\u009c\u00a0\t\2\2\2\u009d\u009f\t\3\2\2"+
		"\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\66\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\t\4\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a78\3\2\2\2\u00a8\u00ad\7$\2\2\u00a9\u00ac\5;\36\2\u00aa\u00ac"+
		"\n\5\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00b1\7$\2\2\u00b1:\3\2\2\2\u00b2\u00b5\7^\2\2\u00b3\u00b6"+
		"\t\6\2\2\u00b4\u00b6\5=\37\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"<\3\2\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\5? \2\u00b9\u00ba\5? \2\u00ba"+
		"\u00bb\5? \2\u00bb\u00bc\5? \2\u00bc>\3\2\2\2\u00bd\u00be\t\7\2\2\u00be"+
		"@\3\2\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c1\7\61\2\2\u00c1\u00c5\3\2\2"+
		"\2\u00c2\u00c4\13\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c8\u00ca\7\17\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b!"+
		"\2\2\u00ceB\3\2\2\2\u00cf\u00d0\7\61\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d5"+
		"\3\2\2\2\u00d2\u00d4\13\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9\u00da\7\61\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dc\b\"\3\2\u00dcD\3\2\2\2\u00dd\u00df\t\b\2\2\u00de\u00dd\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e3\b#\4\2\u00e3F\3\2\2\2\f\2\u00a0\u00a6\u00ab\u00ad"+
		"\u00b5\u00c5\u00c9\u00d5\u00e0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}