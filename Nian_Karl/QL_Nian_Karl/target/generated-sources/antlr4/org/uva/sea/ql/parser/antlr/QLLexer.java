// Generated from QL.g4 by ANTLR 4.4

package org.uva.sea.ql.parser.antlr;

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QuestionType=1, WS=2, COMMENT=3, Bool=4, Ident=5, Int=6, Str=7, Float=8, 
		INT=9, STR=10, CUR=11, BOOL=12, TRUE=13, FALSE=14, IF=15, GREATER=16, 
		EQUAL_GREATER=17, EQUAL=18, EQUAL_SMALLER=19, SMALLER=20, LEFT_BRACES=21, 
		RIGHT_BRACES=22, LEFT_PARENTHESES=23, RIGHT_PARENTHESES=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"QuestionType", "WS", "COMMENT", "Bool", "Ident", "Int", "Str", "Float", 
		"INT", "STR", "CUR", "BOOL", "TRUE", "FALSE", "IF", "GREATER", "EQUAL_GREATER", 
		"EQUAL", "EQUAL_SMALLER", "SMALLER", "LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESES", 
		"RIGHT_PARENTHESES"
	};


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\7\6\7R"+
		"\n\7\r\7\16\7S\3\b\3\b\7\bX\n\b\f\b\16\b[\13\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\4?Y\2\32\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\3\2\b\t\2\"\"DEKKNNPQTW~~\5\2\13\f\17\17\"\"\b"+
		"\2\"\"CCGHNNTW~~\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\u0099\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3"+
		"\63\3\2\2\2\5\65\3\2\2\2\79\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rQ\3\2\2\2"+
		"\17U\3\2\2\2\21^\3\2\2\2\23b\3\2\2\2\25f\3\2\2\2\27j\3\2\2\2\31n\3\2\2"+
		"\2\33s\3\2\2\2\35x\3\2\2\2\37~\3\2\2\2!\u0081\3\2\2\2#\u0083\3\2\2\2%"+
		"\u0086\3\2\2\2\'\u0089\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2-\u0090\3"+
		"\2\2\2/\u0092\3\2\2\2\61\u0094\3\2\2\2\63\64\t\2\2\2\64\4\3\2\2\2\65\66"+
		"\t\3\2\2\66\67\3\2\2\2\678\b\3\2\28\6\3\2\2\29:\7\61\2\2:;\7,\2\2;?\3"+
		"\2\2\2<>\13\2\2\2=<\3\2\2\2>A\3\2\2\2?@\3\2\2\2?=\3\2\2\2@B\3\2\2\2A?"+
		"\3\2\2\2BC\7,\2\2CD\7\61\2\2DE\3\2\2\2EF\b\4\2\2F\b\3\2\2\2GH\t\4\2\2"+
		"H\n\3\2\2\2IM\t\5\2\2JL\t\6\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2"+
		"\2N\f\3\2\2\2OM\3\2\2\2PR\t\7\2\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2"+
		"\2\2T\16\3\2\2\2UY\7$\2\2VX\13\2\2\2WV\3\2\2\2X[\3\2\2\2YZ\3\2\2\2YW\3"+
		"\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7$\2\2]\20\3\2\2\2^_\5\r\7\2_`\7\60\2\2"+
		"`a\5\r\7\2a\22\3\2\2\2bc\7K\2\2cd\7p\2\2de\7v\2\2e\24\3\2\2\2fg\7U\2\2"+
		"gh\7v\2\2hi\7t\2\2i\26\3\2\2\2jk\7E\2\2kl\7w\2\2lm\7t\2\2m\30\3\2\2\2"+
		"no\7D\2\2op\7q\2\2pq\7q\2\2qr\7n\2\2r\32\3\2\2\2st\7v\2\2tu\7t\2\2uv\7"+
		"w\2\2vw\7g\2\2w\34\3\2\2\2xy\7h\2\2yz\7c\2\2z{\7n\2\2{|\7u\2\2|}\7g\2"+
		"\2}\36\3\2\2\2~\177\7k\2\2\177\u0080\7h\2\2\u0080 \3\2\2\2\u0081\u0082"+
		"\7@\2\2\u0082\"\3\2\2\2\u0083\u0084\7@\2\2\u0084\u0085\7?\2\2\u0085$\3"+
		"\2\2\2\u0086\u0087\7?\2\2\u0087\u0088\7?\2\2\u0088&\3\2\2\2\u0089\u008a"+
		"\7>\2\2\u008a\u008b\7?\2\2\u008b(\3\2\2\2\u008c\u008d\7>\2\2\u008d*\3"+
		"\2\2\2\u008e\u008f\7}\2\2\u008f,\3\2\2\2\u0090\u0091\7\177\2\2\u0091."+
		"\3\2\2\2\u0092\u0093\7*\2\2\u0093\60\3\2\2\2\u0094\u0095\7+\2\2\u0095"+
		"\62\3\2\2\2\7\2?MSY\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}