// Generated from QL.g4 by ANTLR 4.5

	package uva.ql.parser;
	import uva.ql.ast.expressions.*;
	import uva.ql.ast.expressions.literals.*;
	import uva.ql.ast.expressions.math.*;
	import uva.ql.ast.expressions.logic.*;
	import java.util.*;

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
		T__9=10, BooleanLiteral=11, Identifier=12, Integer=13, Money=14, WS=15, 
		ID_LETTER=16, DIGIT=17, STRING=18, LINE_COMMENT=19, COMMENT=20, MUL=21, 
		DIV=22, ADD=23, SUB=24, LP=25, RP=26, LC=27, RC=28, LESS=29, LESS_EQUAL=30, 
		GREATER=31, GREATER_EQUAL=32, EQUAL=33, LOG_AND=34, LOG_OR=35, NOT_EQUAL=36, 
		NL=37, EXP=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "BooleanLiteral", "Identifier", "Integer", "Money", "WS", "ID_LETTER", 
		"DIGIT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", 
		"SUB", "LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", 
		"EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", "NL", "EXP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "'typeof'", "':'", "';'", "'if'", "'boolean'", 
		"'money'", "'string'", "'int'", null, null, null, null, null, null, null, 
		null, null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", 
		"'<'", "'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "BooleanLiteral", 
		"Identifier", "Integer", "Money", "WS", "ID_LETTER", "DIGIT", "STRING", 
		"LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", "SUB", "LP", "RP", "LC", 
		"RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", "EQUAL", "LOG_AND", 
		"LOG_OR", "NOT_EQUAL", "NL", "EXP"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u010e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0090\n\f\3\r\3\r\3\r\7\r\u0095\n\r\f\r\16"+
		"\r\u0098\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a1\n\16\3\17"+
		"\3\17\3\20\3\20\3\20\5\20\u00a8\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\7\22\u00b1\n\22\f\22\16\22\u00b4\13\22\5\22\u00b6\n\22\3\23\3\23\3\23"+
		"\7\23\u00bb\n\23\f\23\16\23\u00be\13\23\3\23\3\23\3\24\3\24\3\24\5\24"+
		"\u00c5\n\24\3\25\3\25\3\25\3\25\7\25\u00cb\n\25\f\25\16\25\u00ce\13\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00d8\n\26\f\26\16\26\u00db"+
		"\13\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\""+
		"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\5\'\u0109\n\'\3\'\3\'"+
		"\3(\3(\5\u00bc\u00cc\u00d9\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\26-\27/\30\61"+
		"\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(\3\2\5\5\2C\\aac"+
		"|\3\2\63;\3\2\62;\u011a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5V"+
		"\3\2\2\2\7_\3\2\2\2\tf\3\2\2\2\13h\3\2\2\2\rj\3\2\2\2\17m\3\2\2\2\21u"+
		"\3\2\2\2\23{\3\2\2\2\25\u0082\3\2\2\2\27\u008f\3\2\2\2\31\u0091\3\2\2"+
		"\2\33\u00a0\3\2\2\2\35\u00a2\3\2\2\2\37\u00a7\3\2\2\2!\u00ab\3\2\2\2#"+
		"\u00b5\3\2\2\2%\u00b7\3\2\2\2\'\u00c4\3\2\2\2)\u00c6\3\2\2\2+\u00d3\3"+
		"\2\2\2-\u00e1\3\2\2\2/\u00e3\3\2\2\2\61\u00e5\3\2\2\2\63\u00e7\3\2\2\2"+
		"\65\u00e9\3\2\2\2\67\u00eb\3\2\2\29\u00ed\3\2\2\2;\u00ef\3\2\2\2=\u00f1"+
		"\3\2\2\2?\u00f3\3\2\2\2A\u00f6\3\2\2\2C\u00f8\3\2\2\2E\u00fb\3\2\2\2G"+
		"\u00fe\3\2\2\2I\u0101\3\2\2\2K\u0104\3\2\2\2M\u0108\3\2\2\2O\u010c\3\2"+
		"\2\2QR\7h\2\2RS\7q\2\2ST\7t\2\2TU\7o\2\2U\4\3\2\2\2VW\7s\2\2WX\7w\2\2"+
		"XY\7g\2\2YZ\7u\2\2Z[\7v\2\2[\\\7k\2\2\\]\7q\2\2]^\7p\2\2^\6\3\2\2\2_`"+
		"\7v\2\2`a\7{\2\2ab\7r\2\2bc\7g\2\2cd\7q\2\2de\7h\2\2e\b\3\2\2\2fg\7<\2"+
		"\2g\n\3\2\2\2hi\7=\2\2i\f\3\2\2\2jk\7k\2\2kl\7h\2\2l\16\3\2\2\2mn\7d\2"+
		"\2no\7q\2\2op\7q\2\2pq\7n\2\2qr\7g\2\2rs\7c\2\2st\7p\2\2t\20\3\2\2\2u"+
		"v\7o\2\2vw\7q\2\2wx\7p\2\2xy\7g\2\2yz\7{\2\2z\22\3\2\2\2{|\7u\2\2|}\7"+
		"v\2\2}~\7t\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7i\2\2\u0081\24"+
		"\3\2\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085\7v\2\2\u0085"+
		"\26\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089"+
		"\u0090\7g\2\2\u008a\u008b\7h\2\2\u008b\u008c\7c\2\2\u008c\u008d\7n\2\2"+
		"\u008d\u008e\7u\2\2\u008e\u0090\7g\2\2\u008f\u0086\3\2\2\2\u008f\u008a"+
		"\3\2\2\2\u0090\30\3\2\2\2\u0091\u0096\5!\21\2\u0092\u0095\5!\21\2\u0093"+
		"\u0095\5#\22\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\32\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0099\u00a1\5#\22\2\u009a\u009b\7*\2\2\u009b\u009c\7/\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\5#\22\2\u009e\u009f\7+\2\2\u009f\u00a1\3\2"+
		"\2\2\u00a0\u0099\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1\34\3\2\2\2\u00a2\u00a3"+
		"\5\33\16\2\u00a3\36\3\2\2\2\u00a4\u00a8\7\"\2\2\u00a5\u00a8\5M\'\2\u00a6"+
		"\u00a8\7\13\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\b\20\2\2\u00aa \3\2\2\2\u00ab\u00ac"+
		"\t\2\2\2\u00ac\"\3\2\2\2\u00ad\u00b6\7\62\2\2\u00ae\u00b2\t\3\2\2\u00af"+
		"\u00b1\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00ad\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b6$\3\2\2\2\u00b7\u00bc\7$\2\2\u00b8"+
		"\u00bb\5\'\24\2\u00b9\u00bb\13\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3"+
		"\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7$\2\2\u00c0&\3\2\2\2\u00c1"+
		"\u00c5\7^\2\2\u00c2\u00c3\7^\2\2\u00c3\u00c5\7^\2\2\u00c4\u00c1\3\2\2"+
		"\2\u00c4\u00c2\3\2\2\2\u00c5(\3\2\2\2\u00c6\u00c7\7\61\2\2\u00c7\u00c8"+
		"\7\61\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\13\2\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\b\25\2\2\u00d2*\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d5\7,\2\2"+
		"\u00d5\u00d9\3\2\2\2\u00d6\u00d8\13\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\7,\2\2\u00dd\u00de\7\61\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e0\b\26\2\2\u00e0,\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2.\3\2"+
		"\2\2\u00e3\u00e4\7\61\2\2\u00e4\60\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6\62"+
		"\3\2\2\2\u00e7\u00e8\7/\2\2\u00e8\64\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea"+
		"\66\3\2\2\2\u00eb\u00ec\7+\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7}\2\2\u00ee"+
		":\3\2\2\2\u00ef\u00f0\7\177\2\2\u00f0<\3\2\2\2\u00f1\u00f2\7>\2\2\u00f2"+
		">\3\2\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5\7?\2\2\u00f5@\3\2\2\2\u00f6\u00f7"+
		"\7@\2\2\u00f7B\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7?\2\2\u00faD\3"+
		"\2\2\2\u00fb\u00fc\7?\2\2\u00fc\u00fd\7?\2\2\u00fdF\3\2\2\2\u00fe\u00ff"+
		"\7(\2\2\u00ff\u0100\7(\2\2\u0100H\3\2\2\2\u0101\u0102\7~\2\2\u0102\u0103"+
		"\7~\2\2\u0103J\3\2\2\2\u0104\u0105\7#\2\2\u0105\u0106\7?\2\2\u0106L\3"+
		"\2\2\2\u0107\u0109\7\17\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\7\f\2\2\u010bN\3\2\2\2\u010c\u010d\7`\2\2\u010d"+
		"P\3\2\2\2\20\2\u008f\u0094\u0096\u00a0\u00a7\u00b2\u00b5\u00ba\u00bc\u00c4"+
		"\u00cc\u00d9\u0108\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}