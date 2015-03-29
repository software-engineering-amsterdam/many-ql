// Generated from F:/UvA/SE/Software Construction/many-ql/kennedy-langlotz/KLQ/src\KLQ.g4 by ANTLR 4.5
package com.klq.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KLQLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, QUESTION=4, END=5, ID=6, TEXT=7, TYPE=8, VALUE=9, 
		BOOLEAN=10, DATE=11, STRING=12, NUMERAL=13, IF=14, THEN=15, ADD=16, SUB=17, 
		MUL=18, DIV=19, GT=20, LT=21, GE=22, LE=23, EQ=24, NEQ=25, AND=26, OR=27, 
		End=28, QuestionId=29, String=30, Number=31, Date=32, Int=33, Decimal=34, 
		NEWLINE=35, WS=36, COMMENT=37, LINE_COMMENT=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "QUESTION", "END", "ID", "TEXT", "TYPE", "VALUE", 
		"BOOLEAN", "DATE", "STRING", "NUMERAL", "IF", "THEN", "ADD", "SUB", "MUL", 
		"DIV", "GT", "LT", "GE", "LE", "EQ", "NEQ", "AND", "OR", "End", "QuestionId", 
		"String", "Number", "Date", "Int", "Decimal", "StringCharacter", "Letter", 
		"LetterOrDigit", "Digit", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'('", "')'", "'question'", "'end'", "'id'", "'text'", "'type'", 
		"'value'", "'boolean'", "'date'", "'string'", "'numeral'", "'if'", "'then'", 
		"'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
		"'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "QUESTION", "END", "ID", "TEXT", "TYPE", "VALUE", 
		"BOOLEAN", "DATE", "STRING", "NUMERAL", "IF", "THEN", "ADD", "SUB", "MUL", 
		"DIV", "GT", "LT", "GE", "LE", "EQ", "NEQ", "AND", "OR", "End", "QuestionId", 
		"String", "Number", "Date", "Int", "Decimal", "NEWLINE", "WS", "COMMENT", 
		"LINE_COMMENT"
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


	public KLQLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KLQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u0125\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\6\35\u00c5\n\35\r\35\16\35\u00c6\3\35\5\35\u00ca\n\35\3\36\3\36\7"+
		"\36\u00ce\n\36\f\36\16\36\u00d1\13\36\3\37\3\37\7\37\u00d5\n\37\f\37\16"+
		"\37\u00d8\13\37\3\37\3\37\3 \3 \5 \u00de\n \3!\3!\3!\3!\3!\3!\3\"\6\""+
		"\u00e7\n\"\r\"\16\"\u00e8\3#\6#\u00ec\n#\r#\16#\u00ed\3#\3#\7#\u00f2\n"+
		"#\f#\16#\u00f5\13#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\5(\u0100\n(\3(\3(\5(\u0104"+
		"\n(\3)\6)\u0107\n)\r)\16)\u0108\3)\3)\3*\3*\3*\3*\7*\u0111\n*\f*\16*\u0114"+
		"\13*\3*\3*\3*\3*\3*\3+\3+\3+\3+\7+\u011f\n+\f+\16+\u0122\13+\3+\3+\3\u0112"+
		"\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G\2I\2K\2M\2O%Q&S\'U(\3\2\b\4\2$$^^\4\2C\\c|\5\2\62;C\\"+
		"c|\3\2\62;\4\2\13\13\"\"\4\2\f\f\17\17\u012d\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13f\3\2\2\2\rj\3"+
		"\2\2\2\17m\3\2\2\2\21r\3\2\2\2\23w\3\2\2\2\25}\3\2\2\2\27\u0085\3\2\2"+
		"\2\31\u008a\3\2\2\2\33\u0091\3\2\2\2\35\u0099\3\2\2\2\37\u009c\3\2\2\2"+
		"!\u00a1\3\2\2\2#\u00a3\3\2\2\2%\u00a5\3\2\2\2\'\u00a7\3\2\2\2)\u00a9\3"+
		"\2\2\2+\u00ab\3\2\2\2-\u00ad\3\2\2\2/\u00b0\3\2\2\2\61\u00b3\3\2\2\2\63"+
		"\u00b6\3\2\2\2\65\u00b9\3\2\2\2\67\u00bc\3\2\2\29\u00bf\3\2\2\2;\u00cb"+
		"\3\2\2\2=\u00d2\3\2\2\2?\u00dd\3\2\2\2A\u00df\3\2\2\2C\u00e6\3\2\2\2E"+
		"\u00eb\3\2\2\2G\u00f6\3\2\2\2I\u00f8\3\2\2\2K\u00fa\3\2\2\2M\u00fc\3\2"+
		"\2\2O\u0103\3\2\2\2Q\u0106\3\2\2\2S\u010c\3\2\2\2U\u011a\3\2\2\2WX\7<"+
		"\2\2X\4\3\2\2\2YZ\7*\2\2Z\6\3\2\2\2[\\\7+\2\2\\\b\3\2\2\2]^\7s\2\2^_\7"+
		"w\2\2_`\7g\2\2`a\7u\2\2ab\7v\2\2bc\7k\2\2cd\7q\2\2de\7p\2\2e\n\3\2\2\2"+
		"fg\7g\2\2gh\7p\2\2hi\7f\2\2i\f\3\2\2\2jk\7k\2\2kl\7f\2\2l\16\3\2\2\2m"+
		"n\7v\2\2no\7g\2\2op\7z\2\2pq\7v\2\2q\20\3\2\2\2rs\7v\2\2st\7{\2\2tu\7"+
		"r\2\2uv\7g\2\2v\22\3\2\2\2wx\7x\2\2xy\7c\2\2yz\7n\2\2z{\7w\2\2{|\7g\2"+
		"\2|\24\3\2\2\2}~\7d\2\2~\177\7q\2\2\177\u0080\7q\2\2\u0080\u0081\7n\2"+
		"\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083\u0084\7p\2\2\u0084\26\3"+
		"\2\2\2\u0085\u0086\7f\2\2\u0086\u0087\7c\2\2\u0087\u0088\7v\2\2\u0088"+
		"\u0089\7g\2\2\u0089\30\3\2\2\2\u008a\u008b\7u\2\2\u008b\u008c\7v\2\2\u008c"+
		"\u008d\7t\2\2\u008d\u008e\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090\7i\2\2"+
		"\u0090\32\3\2\2\2\u0091\u0092\7p\2\2\u0092\u0093\7w\2\2\u0093\u0094\7"+
		"o\2\2\u0094\u0095\7g\2\2\u0095\u0096\7t\2\2\u0096\u0097\7c\2\2\u0097\u0098"+
		"\7n\2\2\u0098\34\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\36"+
		"\3\2\2\2\u009c\u009d\7v\2\2\u009d\u009e\7j\2\2\u009e\u009f\7g\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0 \3\2\2\2\u00a1\u00a2\7-\2\2\u00a2\"\3\2\2\2\u00a3"+
		"\u00a4\7/\2\2\u00a4$\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6&\3\2\2\2\u00a7\u00a8"+
		"\7\61\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7@\2\2\u00aa*\3\2\2\2\u00ab\u00ac"+
		"\7>\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\7?\2\2\u00af.\3"+
		"\2\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b2\7?\2\2\u00b2\60\3\2\2\2\u00b3\u00b4"+
		"\7?\2\2\u00b4\u00b5\7?\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\7#\2\2\u00b7\u00b8"+
		"\7?\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\7(\2\2\u00bb\66"+
		"\3\2\2\2\u00bc\u00bd\7~\2\2\u00bd\u00be\7~\2\2\u00be8\3\2\2\2\u00bf\u00c0"+
		"\7g\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c9\3\2\2\2\u00c3"+
		"\u00c5\5O(\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00ca\7\2\2\3\u00c9\u00c4"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca:\3\2\2\2\u00cb\u00cf\5I%\2\u00cc\u00ce"+
		"\5K&\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0<\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d6\7$\2\2\u00d3"+
		"\u00d5\5G$\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da"+
		"\7$\2\2\u00da>\3\2\2\2\u00db\u00de\5C\"\2\u00dc\u00de\5E#\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de@\3\2\2\2\u00df\u00e0\5C\"\2\u00e0\u00e1"+
		"\4/\61\2\u00e1\u00e2\5C\"\2\u00e2\u00e3\4/\61\2\u00e3\u00e4\5C\"\2\u00e4"+
		"B\3\2\2\2\u00e5\u00e7\5M\'\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9D\3\2\2\2\u00ea\u00ec\5M\'\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f3\7\60\2\2\u00f0\u00f2\5M\'\2\u00f1"+
		"\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2"+
		"\2\2\u00f4F\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\n\2\2\2\u00f7H\3\2"+
		"\2\2\u00f8\u00f9\t\3\2\2\u00f9J\3\2\2\2\u00fa\u00fb\t\4\2\2\u00fbL\3\2"+
		"\2\2\u00fc\u00fd\t\5\2\2\u00fdN\3\2\2\2\u00fe\u0100\7\17\2\2\u00ff\u00fe"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\7\f\2\2\u0102"+
		"\u0104\7\16\2\2\u0103\u00ff\3\2\2\2\u0103\u0102\3\2\2\2\u0104P\3\2\2\2"+
		"\u0105\u0107\t\6\2\2\u0106\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b)\2\2\u010b"+
		"R\3\2\2\2\u010c\u010d\7\61\2\2\u010d\u010e\7,\2\2\u010e\u0112\3\2\2\2"+
		"\u010f\u0111\13\2\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0116\7,\2\2\u0116\u0117\7\61\2\2\u0117\u0118\3\2\2\2\u0118\u0119\b*"+
		"\2\2\u0119T\3\2\2\2\u011a\u011b\7\61\2\2\u011b\u011c\7\61\2\2\u011c\u0120"+
		"\3\2\2\2\u011d\u011f\n\7\2\2\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0123\u0124\b+\2\2\u0124V\3\2\2\2\20\2\u00c6\u00c9\u00cf\u00d6\u00dd"+
		"\u00e8\u00ed\u00f3\u00ff\u0103\u0108\u0112\u0120\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}