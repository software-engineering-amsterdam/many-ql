// Generated from QL.g4 by ANTLR 4.4
package org.uva.sea.ql.parser.antlr;

//	import org.uva.sea.ql.model.expression.*;
//	import org.uva.sea.ql.model.expression.mathexpression.*;
//	import org.uva.sea.ql.model.expression.booleanexpression.*;
//	import org.uva.sea.ql.model.expression.commonexpression.*;

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
		T__0=1, INT=2, STR=3, CUR=4, BOOL=5, TRUE=6, FALSE=7, IF=8, OR=9, AND=10, 
		EQUAL=11, GREATER=12, EQUAL_GREATER=13, EQUAL_COND=14, EQUAL_SMALLER=15, 
		SMALLER=16, LEFT_BRACES=17, RIGHT_BRACES=18, LEFT_PARENTHESES=19, RIGHT_PARENTHESES=20, 
		COLON=21, SEMICOLON=22, PLUS=23, MINUS=24, DEVIDE=25, MULTIPLY=26, Int=27, 
		Str=28, Float=29, WhiteSpace=30, MultiComment=31, SingleComment=32, Ident=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'"
	};
	public static final String[] ruleNames = {
		"T__0", "INT", "STR", "CUR", "BOOL", "TRUE", "FALSE", "IF", "OR", "AND", 
		"EQUAL", "GREATER", "EQUAL_GREATER", "EQUAL_COND", "EQUAL_SMALLER", "SMALLER", 
		"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESES", "RIGHT_PARENTHESES", 
		"COLON", "SEMICOLON", "PLUS", "MINUS", "DEVIDE", "MULTIPLY", "Int", "Str", 
		"Float", "WhiteSpace", "MultiComment", "SingleComment", "Ident"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00cc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\7\34\u0095\n\34\f\34\16\34\u0098\13\34\3\35\3\35\7\35"+
		"\u009c\n\35\f\35\16\35\u009f\13\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \7 \u00af\n \f \16 \u00b2\13 \3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\7!\u00bd\n!\f!\16!\u00c0\13!\3!\3!\3!\3!\3\"\3\"\7\"\u00c8"+
		"\n\"\f\"\16\"\u00cb\13\"\5\u009d\u00b0\u00be\2#\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\7\3\2\63"+
		";\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u00d0\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5J\3\2\2\2\7N\3\2\2\2"+
		"\tR\3\2\2\2\13V\3\2\2\2\r[\3\2\2\2\17`\3\2\2\2\21f\3\2\2\2\23i\3\2\2\2"+
		"\25l\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33s\3\2\2\2\35v\3\2\2\2\37y\3\2\2"+
		"\2!|\3\2\2\2#~\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u0084\3\2\2\2+"+
		"\u0086\3\2\2\2-\u0088\3\2\2\2/\u008a\3\2\2\2\61\u008c\3\2\2\2\63\u008e"+
		"\3\2\2\2\65\u0090\3\2\2\2\67\u0092\3\2\2\29\u0099\3\2\2\2;\u00a2\3\2\2"+
		"\2=\u00a6\3\2\2\2?\u00aa\3\2\2\2A\u00b8\3\2\2\2C\u00c5\3\2\2\2EF\7h\2"+
		"\2FG\7q\2\2GH\7t\2\2HI\7o\2\2I\4\3\2\2\2JK\7K\2\2KL\7p\2\2LM\7v\2\2M\6"+
		"\3\2\2\2NO\7U\2\2OP\7v\2\2PQ\7t\2\2Q\b\3\2\2\2RS\7E\2\2ST\7w\2\2TU\7t"+
		"\2\2U\n\3\2\2\2VW\7D\2\2WX\7q\2\2XY\7q\2\2YZ\7n\2\2Z\f\3\2\2\2[\\\7v\2"+
		"\2\\]\7t\2\2]^\7w\2\2^_\7g\2\2_\16\3\2\2\2`a\7h\2\2ab\7c\2\2bc\7n\2\2"+
		"cd\7u\2\2de\7g\2\2e\20\3\2\2\2fg\7k\2\2gh\7h\2\2h\22\3\2\2\2ij\7~\2\2"+
		"jk\7~\2\2k\24\3\2\2\2lm\7(\2\2mn\7(\2\2n\26\3\2\2\2op\7?\2\2p\30\3\2\2"+
		"\2qr\7@\2\2r\32\3\2\2\2st\7@\2\2tu\7?\2\2u\34\3\2\2\2vw\7?\2\2wx\7?\2"+
		"\2x\36\3\2\2\2yz\7>\2\2z{\7?\2\2{ \3\2\2\2|}\7>\2\2}\"\3\2\2\2~\177\7"+
		"}\2\2\177$\3\2\2\2\u0080\u0081\7\177\2\2\u0081&\3\2\2\2\u0082\u0083\7"+
		"*\2\2\u0083(\3\2\2\2\u0084\u0085\7+\2\2\u0085*\3\2\2\2\u0086\u0087\7<"+
		"\2\2\u0087,\3\2\2\2\u0088\u0089\7=\2\2\u0089.\3\2\2\2\u008a\u008b\7-\2"+
		"\2\u008b\60\3\2\2\2\u008c\u008d\7/\2\2\u008d\62\3\2\2\2\u008e\u008f\7"+
		"\61\2\2\u008f\64\3\2\2\2\u0090\u0091\7,\2\2\u0091\66\3\2\2\2\u0092\u0096"+
		"\t\2\2\2\u0093\u0095\t\3\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u00978\3\2\2\2\u0098\u0096\3\2\2\2"+
		"\u0099\u009d\7$\2\2\u009a\u009c\13\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a1\7$\2\2\u00a1:\3\2\2\2\u00a2\u00a3\5\67\34\2"+
		"\u00a3\u00a4\7\60\2\2\u00a4\u00a5\5\67\34\2\u00a5<\3\2\2\2\u00a6\u00a7"+
		"\t\4\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\37\2\2\u00a9>\3\2\2\2\u00aa"+
		"\u00ab\7\61\2\2\u00ab\u00ac\7,\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af\13"+
		"\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7,"+
		"\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b \2\2\u00b7"+
		"@\3\2\2\2\u00b8\u00b9\7\61\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00be\3\2\2"+
		"\2\u00bb\u00bd\13\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c1\u00c2\7\f\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b!\2\2\u00c4"+
		"B\3\2\2\2\u00c5\u00c9\t\5\2\2\u00c6\u00c8\t\6\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00caD\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\b\2\u0096\u009d\u00b0\u00be\u00c9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}