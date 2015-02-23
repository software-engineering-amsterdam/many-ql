// Generated from QLbk.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLbkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FORM=1, IF=2, ELSE=3, INT=4, STR=5, BOOL=6, DATE=7, DEC=8, CUR=9, SEMI=10, 
		LBRACE=11, RBRACE=12, LPAREN=13, RPAREN=14, AND=15, OR=16, EQUAL=17, NOTEQUAL=18, 
		ASSIGN=19, GT=20, LT=21, GE=22, LE=23, ADD=24, SUB=25, MUL=26, DIV=27, 
		BANG=28, IntegerLiteral=29, StringLiteral=30, BooleanLiteral=31, DateLiteral=32, 
		DecimalLiteral=33, CurrencyLiteral=34, Non_Zero_Digit=35, Digit=36, Cap_Start_Identifier=37, 
		Identifier=38, WHITE_SPACE=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''"
	};
	public static final String[] ruleNames = {
		"FORM", "IF", "ELSE", "INT", "STR", "BOOL", "DATE", "DEC", "CUR", "SEMI", 
		"LBRACE", "RBRACE", "LPAREN", "RPAREN", "AND", "OR", "EQUAL", "NOTEQUAL", 
		"ASSIGN", "GT", "LT", "GE", "LE", "ADD", "SUB", "MUL", "DIV", "BANG", 
		"IntegerLiteral", "StringLiteral", "BooleanLiteral", "DateLiteral", "DecimalLiteral", 
		"CurrencyLiteral", "Non_Zero_Digit", "Digit", "Cap_Start_Identifier", 
		"Identifier", "WHITE_SPACE"
	};


	public QLbkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLbk.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u00f4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\7\37\u00bc\n\37\f\37\16\37\u00bf\13\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00cc\n \3!\3!\3\"\3\"\3\"\7\""+
		"\u00d3\n\"\f\"\16\"\u00d6\13\"\5\"\u00d8\n\"\3#\3#\3$\3$\3%\3%\3&\3&\7"+
		"&\u00e2\n&\f&\16&\u00e5\13&\3\'\3\'\7\'\u00e9\n\'\f\'\16\'\u00ec\13\'"+
		"\3(\6(\u00ef\n(\r(\16(\u00f0\3(\3(\3\u00bd\2)\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2"+
		"\t\3\2\62\62\3\2\63;\3\2\62;\3\2C\\\5\2\62;C\\c|\4\2C\\c|\5\2\13\f\17"+
		"\17\"\"\u00fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5"+
		"V\3\2\2\2\7Y\3\2\2\2\t^\3\2\2\2\13f\3\2\2\2\rm\3\2\2\2\17u\3\2\2\2\21"+
		"z\3\2\2\2\23\u0082\3\2\2\2\25\u008b\3\2\2\2\27\u008d\3\2\2\2\31\u008f"+
		"\3\2\2\2\33\u0091\3\2\2\2\35\u0093\3\2\2\2\37\u0095\3\2\2\2!\u0098\3\2"+
		"\2\2#\u009b\3\2\2\2%\u009e\3\2\2\2\'\u00a1\3\2\2\2)\u00a3\3\2\2\2+\u00a5"+
		"\3\2\2\2-\u00a7\3\2\2\2/\u00aa\3\2\2\2\61\u00ad\3\2\2\2\63\u00af\3\2\2"+
		"\2\65\u00b1\3\2\2\2\67\u00b3\3\2\2\29\u00b5\3\2\2\2;\u00b7\3\2\2\2=\u00b9"+
		"\3\2\2\2?\u00cb\3\2\2\2A\u00cd\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3\2\2\2G"+
		"\u00db\3\2\2\2I\u00dd\3\2\2\2K\u00df\3\2\2\2M\u00e6\3\2\2\2O\u00ee\3\2"+
		"\2\2QR\7H\2\2RS\7q\2\2ST\7t\2\2TU\7o\2\2U\4\3\2\2\2VW\7k\2\2WX\7h\2\2"+
		"X\6\3\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\b\3\2\2\2^_\7K\2\2"+
		"_`\7p\2\2`a\7v\2\2ab\7g\2\2bc\7i\2\2cd\7g\2\2de\7t\2\2e\n\3\2\2\2fg\7"+
		"U\2\2gh\7v\2\2hi\7t\2\2ij\7k\2\2jk\7p\2\2kl\7i\2\2l\f\3\2\2\2mn\7D\2\2"+
		"no\7q\2\2op\7q\2\2pq\7n\2\2qr\7g\2\2rs\7c\2\2st\7p\2\2t\16\3\2\2\2uv\7"+
		"F\2\2vw\7c\2\2wx\7v\2\2xy\7g\2\2y\20\3\2\2\2z{\7F\2\2{|\7g\2\2|}\7e\2"+
		"\2}~\7k\2\2~\177\7o\2\2\177\u0080\7c\2\2\u0080\u0081\7n\2\2\u0081\22\3"+
		"\2\2\2\u0082\u0083\7E\2\2\u0083\u0084\7w\2\2\u0084\u0085\7t\2\2\u0085"+
		"\u0086\7t\2\2\u0086\u0087\7g\2\2\u0087\u0088\7p\2\2\u0088\u0089\7e\2\2"+
		"\u0089\u008a\7{\2\2\u008a\24\3\2\2\2\u008b\u008c\7=\2\2\u008c\26\3\2\2"+
		"\2\u008d\u008e\7}\2\2\u008e\30\3\2\2\2\u008f\u0090\7\177\2\2\u0090\32"+
		"\3\2\2\2\u0091\u0092\7*\2\2\u0092\34\3\2\2\2\u0093\u0094\7+\2\2\u0094"+
		"\36\3\2\2\2\u0095\u0096\7(\2\2\u0096\u0097\7(\2\2\u0097 \3\2\2\2\u0098"+
		"\u0099\7~\2\2\u0099\u009a\7~\2\2\u009a\"\3\2\2\2\u009b\u009c\7?\2\2\u009c"+
		"\u009d\7?\2\2\u009d$\3\2\2\2\u009e\u009f\7#\2\2\u009f\u00a0\7?\2\2\u00a0"+
		"&\3\2\2\2\u00a1\u00a2\7?\2\2\u00a2(\3\2\2\2\u00a3\u00a4\7@\2\2\u00a4*"+
		"\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00a9"+
		"\7?\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7?\2\2\u00ac\60"+
		"\3\2\2\2\u00ad\u00ae\7-\2\2\u00ae\62\3\2\2\2\u00af\u00b0\7/\2\2\u00b0"+
		"\64\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2\66\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4"+
		"8\3\2\2\2\u00b5\u00b6\7#\2\2\u00b6:\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"<\3\2\2\2\u00b9\u00bd\7$\2\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2"+
		"\u00bc\u00bf\3\2\2\2\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7$\2\2\u00c1>\3\2\2\2\u00c2\u00c3"+
		"\7v\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7w\2\2\u00c5\u00cc\7g\2\2\u00c6"+
		"\u00c7\7h\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7u\2\2"+
		"\u00ca\u00cc\7g\2\2\u00cb\u00c2\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cc@\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ceB\3\2\2\2\u00cf\u00d8\t\2\2\2\u00d0\u00d4"+
		"\t\3\2\2\u00d1\u00d3\t\4\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d8D\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00daF\3\2\2\2\u00db\u00dc\t\3\2\2\u00dcH\3\2\2\2\u00dd\u00de"+
		"\t\4\2\2\u00deJ\3\2\2\2\u00df\u00e3\t\5\2\2\u00e0\u00e2\t\6\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4L\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00ea\t\7\2\2\u00e7\u00e9"+
		"\t\6\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00ebN\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\t\b\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b(\2\2\u00f3P\3\2\2\2\n\2\u00bd"+
		"\u00cb\u00d4\u00d7\u00e3\u00ea\u00f0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}