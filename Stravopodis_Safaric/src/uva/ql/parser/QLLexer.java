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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, QuestionLiteral=16, 
		BooleanLiteral=17, WS=18, ID=19, ID_LETTER=20, INT=21, FLOAT=22, CURRENCY=23, 
		STRING=24, LINE_COMMENT=25, COMMENT=26, MUL=27, DIV=28, ADD=29, SUB=30, 
		LP=31, RP=32, LC=33, RC=34, LESS=35, LESS_EQUAL=36, GREATER=37, GREATER_EQUAL=38, 
		EQUAL=39, LOG_AND=40, LOG_OR=41, NOT_EQUAL=42, NL=43, EXP=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "QuestionLiteral", 
		"BooleanLiteral", "WS", "ID", "ID_LETTER", "INT", "FLOAT", "CURRENCY", 
		"STRING", "ESC", "LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", "SUB", 
		"LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", 
		"EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", "NL", "EXP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "'='", "';'", "'.'", "'value'", "'if'", 
		"'(-'", "'boolean'", "'float'", "'currency'", "'string'", "'int'", "'typeof'", 
		"'questionType'", null, null, null, null, null, null, null, null, null, 
		null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "QuestionLiteral", "BooleanLiteral", "WS", "ID", 
		"ID_LETTER", "INT", "FLOAT", "CURRENCY", "STRING", "LINE_COMMENT", "COMMENT", 
		"MUL", "DIV", "ADD", "SUB", "LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", 
		"GREATER", "GREATER_EQUAL", "EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", 
		"NL", "EXP"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u016a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00d6\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e1"+
		"\n\22\3\23\3\23\3\23\5\23\u00e6\n\23\3\23\3\23\3\24\3\24\3\24\7\24\u00ed"+
		"\n\24\f\24\16\24\u00f0\13\24\3\25\3\25\3\26\3\26\3\26\7\26\u00f7\n\26"+
		"\f\26\16\26\u00fa\13\26\5\26\u00fc\n\26\3\27\6\27\u00ff\n\27\r\27\16\27"+
		"\u0100\3\27\3\27\7\27\u0105\n\27\f\27\16\27\u0108\13\27\3\27\3\27\6\27"+
		"\u010c\n\27\r\27\16\27\u010d\5\27\u0110\n\27\3\30\3\30\3\31\3\31\3\31"+
		"\7\31\u0117\n\31\f\31\16\31\u011a\13\31\3\31\3\31\3\32\3\32\3\32\5\32"+
		"\u0121\n\32\3\33\3\33\3\33\3\33\7\33\u0127\n\33\f\33\16\33\u012a\13\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u0134\n\34\f\34\16\34\u0137"+
		"\13\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3"+
		"!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3"+
		"*\3*\3+\3+\3+\3,\3,\3,\3-\5-\u0165\n-\3-\3-\3.\3.\5\u0118\u0128\u0135"+
		"\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\33\67\349\35"+
		";\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.\3\2\5\5\2C\\aac|\3\2\63;\3\2"+
		"\62;\u017a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5b\3\2\2\2\7k\3\2\2"+
		"\2\tm\3\2\2\2\13o\3\2\2\2\rq\3\2\2\2\17w\3\2\2\2\21z\3\2\2\2\23}\3\2\2"+
		"\2\25\u0085\3\2\2\2\27\u008b\3\2\2\2\31\u0094\3\2\2\2\33\u009b\3\2\2\2"+
		"\35\u009f\3\2\2\2\37\u00a6\3\2\2\2!\u00d5\3\2\2\2#\u00e0\3\2\2\2%\u00e5"+
		"\3\2\2\2\'\u00e9\3\2\2\2)\u00f1\3\2\2\2+\u00fb\3\2\2\2-\u010f\3\2\2\2"+
		"/\u0111\3\2\2\2\61\u0113\3\2\2\2\63\u0120\3\2\2\2\65\u0122\3\2\2\2\67"+
		"\u012f\3\2\2\29\u013d\3\2\2\2;\u013f\3\2\2\2=\u0141\3\2\2\2?\u0143\3\2"+
		"\2\2A\u0145\3\2\2\2C\u0147\3\2\2\2E\u0149\3\2\2\2G\u014b\3\2\2\2I\u014d"+
		"\3\2\2\2K\u014f\3\2\2\2M\u0152\3\2\2\2O\u0154\3\2\2\2Q\u0157\3\2\2\2S"+
		"\u015a\3\2\2\2U\u015d\3\2\2\2W\u0160\3\2\2\2Y\u0164\3\2\2\2[\u0168\3\2"+
		"\2\2]^\7h\2\2^_\7q\2\2_`\7t\2\2`a\7o\2\2a\4\3\2\2\2bc\7s\2\2cd\7w\2\2"+
		"de\7g\2\2ef\7u\2\2fg\7v\2\2gh\7k\2\2hi\7q\2\2ij\7p\2\2j\6\3\2\2\2kl\7"+
		"?\2\2l\b\3\2\2\2mn\7=\2\2n\n\3\2\2\2op\7\60\2\2p\f\3\2\2\2qr\7x\2\2rs"+
		"\7c\2\2st\7n\2\2tu\7w\2\2uv\7g\2\2v\16\3\2\2\2wx\7k\2\2xy\7h\2\2y\20\3"+
		"\2\2\2z{\7*\2\2{|\7/\2\2|\22\3\2\2\2}~\7d\2\2~\177\7q\2\2\177\u0080\7"+
		"q\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7p\2\2\u0084\24\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7n\2\2\u0087\u0088"+
		"\7q\2\2\u0088\u0089\7c\2\2\u0089\u008a\7v\2\2\u008a\26\3\2\2\2\u008b\u008c"+
		"\7e\2\2\u008c\u008d\7w\2\2\u008d\u008e\7t\2\2\u008e\u008f\7t\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091\u0092\7e\2\2\u0092\u0093\7{\2\2"+
		"\u0093\30\3\2\2\2\u0094\u0095\7u\2\2\u0095\u0096\7v\2\2\u0096\u0097\7"+
		"t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009a\7i\2\2\u009a\32"+
		"\3\2\2\2\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2\u009e"+
		"\34\3\2\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7{\2\2\u00a1\u00a2\7r\2\2\u00a2"+
		"\u00a3\7g\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7h\2\2\u00a5\36\3\2\2\2\u00a6"+
		"\u00a7\7s\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7u\2\2"+
		"\u00aa\u00ab\7v\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae"+
		"\7p\2\2\u00ae\u00af\7V\2\2\u00af\u00b0\7{\2\2\u00b0\u00b1\7r\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7Q\2\2\u00b4\u00b5\7t\2\2\u00b5"+
		"\u00b6\7f\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7c\2\2"+
		"\u00b9\u00ba\7t\2\2\u00ba\u00bb\7{\2\2\u00bb\u00bc\7S\2\2\u00bc\u00bd"+
		"\7w\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7v\2\2\u00c0"+
		"\u00c1\7k\2\2\u00c1\u00c2\7q\2\2\u00c2\u00d6\7p\2\2\u00c3\u00c4\7E\2\2"+
		"\u00c4\u00c5\7q\2\2\u00c5\u00c6\7o\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8"+
		"\7w\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7d\2\2\u00cb"+
		"\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7S\2\2\u00ce\u00cf\7w\2\2"+
		"\u00cf\u00d0\7g\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3"+
		"\7k\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d6\7p\2\2\u00d5\u00b3\3\2\2\2\u00d5"+
		"\u00c3\3\2\2\2\u00d6\"\3\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9"+
		"\u00da\7w\2\2\u00da\u00e1\7g\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7c\2\2"+
		"\u00dd\u00de\7n\2\2\u00de\u00df\7u\2\2\u00df\u00e1\7g\2\2\u00e0\u00d7"+
		"\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1$\3\2\2\2\u00e2\u00e6\7\"\2\2\u00e3"+
		"\u00e6\5Y-\2\u00e4\u00e6\7\13\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\23\2\2\u00e8"+
		"&\3\2\2\2\u00e9\u00ee\5)\25\2\u00ea\u00ed\5)\25\2\u00eb\u00ed\5+\26\2"+
		"\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef(\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f2\t\2\2\2\u00f2*\3\2\2\2\u00f3\u00fc\7\62\2\2\u00f4\u00f8\t\3\2\2"+
		"\u00f5\u00f7\t\4\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u00f3\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fc,\3\2\2\2\u00fd\u00ff\5+\26\2"+
		"\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0106\7\60\2\2\u0103\u0105\5+\26\2"+
		"\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0110\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010b\7\60\2\2"+
		"\u010a\u010c\5+\26\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u00fe\3\2\2\2\u010f"+
		"\u0109\3\2\2\2\u0110.\3\2\2\2\u0111\u0112\5-\27\2\u0112\60\3\2\2\2\u0113"+
		"\u0118\7$\2\2\u0114\u0117\5\63\32\2\u0115\u0117\13\2\2\2\u0116\u0114\3"+
		"\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0119\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7$"+
		"\2\2\u011c\62\3\2\2\2\u011d\u0121\7^\2\2\u011e\u011f\7^\2\2\u011f\u0121"+
		"\7^\2\2\u0120\u011d\3\2\2\2\u0120\u011e\3\2\2\2\u0121\64\3\2\2\2\u0122"+
		"\u0123\7\61\2\2\u0123\u0124\7\61\2\2\u0124\u0128\3\2\2\2\u0125\u0127\13"+
		"\2\2\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0129\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7\f"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012e\b\33\2\2\u012e\66\3\2\2\2\u012f\u0130"+
		"\7\61\2\2\u0130\u0131\7,\2\2\u0131\u0135\3\2\2\2\u0132\u0134\13\2\2\2"+
		"\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0136\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7,\2\2\u0139"+
		"\u013a\7\61\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\34\2\2\u013c8\3\2\2"+
		"\2\u013d\u013e\7,\2\2\u013e:\3\2\2\2\u013f\u0140\7\61\2\2\u0140<\3\2\2"+
		"\2\u0141\u0142\7-\2\2\u0142>\3\2\2\2\u0143\u0144\7/\2\2\u0144@\3\2\2\2"+
		"\u0145\u0146\7*\2\2\u0146B\3\2\2\2\u0147\u0148\7+\2\2\u0148D\3\2\2\2\u0149"+
		"\u014a\7}\2\2\u014aF\3\2\2\2\u014b\u014c\7\177\2\2\u014cH\3\2\2\2\u014d"+
		"\u014e\7>\2\2\u014eJ\3\2\2\2\u014f\u0150\7>\2\2\u0150\u0151\7?\2\2\u0151"+
		"L\3\2\2\2\u0152\u0153\7@\2\2\u0153N\3\2\2\2\u0154\u0155\7@\2\2\u0155\u0156"+
		"\7?\2\2\u0156P\3\2\2\2\u0157\u0158\7?\2\2\u0158\u0159\7?\2\2\u0159R\3"+
		"\2\2\2\u015a\u015b\7(\2\2\u015b\u015c\7(\2\2\u015cT\3\2\2\2\u015d\u015e"+
		"\7~\2\2\u015e\u015f\7~\2\2\u015fV\3\2\2\2\u0160\u0161\7#\2\2\u0161\u0162"+
		"\7?\2\2\u0162X\3\2\2\2\u0163\u0165\7\17\2\2\u0164\u0163\3\2\2\2\u0164"+
		"\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\7\f\2\2\u0167Z\3\2\2\2"+
		"\u0168\u0169\7`\2\2\u0169\\\3\2\2\2\24\2\u00d5\u00e0\u00e5\u00ec\u00ee"+
		"\u00f8\u00fb\u0100\u0106\u010d\u010f\u0116\u0118\u0120\u0128\u0135\u0164"+
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