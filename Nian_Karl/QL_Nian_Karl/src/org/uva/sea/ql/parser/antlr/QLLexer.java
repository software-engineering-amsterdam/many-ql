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
		T__2=1, T__1=2, T__0=3, INT=4, STR=5, CUR=6, BOOL=7, TRUE=8, FALSE=9, 
		IF=10, OR=11, AND=12, EQUAL=13, GREATER=14, EQUAL_GREATER=15, EQUAL_COND=16, 
		EQUAL_SMALLER=17, SMALLER=18, LEFT_BRACES=19, RIGHT_BRACES=20, LEFT_PARENTHESES=21, 
		RIGHT_PARENTHESES=22, COLON=23, SEMICOLON=24, PLUS=25, MINUS=26, DEVIDE=27, 
		MULTIPLY=28, Int=29, Str=30, Float=31, WhiteSpace=32, MultiComment=33, 
		SingleComment=34, Ident=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "INT", "STR", "CUR", "BOOL", "TRUE", "FALSE", 
		"IF", "OR", "AND", "EQUAL", "GREATER", "EQUAL_GREATER", "EQUAL_COND", 
		"EQUAL_SMALLER", "SMALLER", "LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESES", 
		"RIGHT_PARENTHESES", "COLON", "SEMICOLON", "PLUS", "MINUS", "DEVIDE", 
		"MULTIPLY", "Int", "Str", "Float", "WhiteSpace", "MultiComment", "SingleComment", 
		"Ident"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\7\36\u009e\n\36\f\36"+
		"\16\36\u00a1\13\36\3\37\3\37\7\37\u00a5\n\37\f\37\16\37\u00a8\13\37\3"+
		"\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00b8\n\"\f\"\16"+
		"\"\u00bb\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00c6\n#\f#\16#\u00c9"+
		"\13#\3#\3#\3#\3#\3$\3$\7$\u00d1\n$\f$\16$\u00d4\13$\5\u00a6\u00b9\u00c7"+
		"\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%\3\2\7\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\c|\6"+
		"\2\62;C\\aac|\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5N\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13"+
		"W\3\2\2\2\r[\3\2\2\2\17_\3\2\2\2\21d\3\2\2\2\23i\3\2\2\2\25o\3\2\2\2\27"+
		"r\3\2\2\2\31u\3\2\2\2\33x\3\2\2\2\35z\3\2\2\2\37|\3\2\2\2!\177\3\2\2\2"+
		"#\u0082\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b\3"+
		"\2\2\2-\u008d\3\2\2\2/\u008f\3\2\2\2\61\u0091\3\2\2\2\63\u0093\3\2\2\2"+
		"\65\u0095\3\2\2\2\67\u0097\3\2\2\29\u0099\3\2\2\2;\u009b\3\2\2\2=\u00a2"+
		"\3\2\2\2?\u00ab\3\2\2\2A\u00af\3\2\2\2C\u00b3\3\2\2\2E\u00c1\3\2\2\2G"+
		"\u00ce\3\2\2\2IJ\7h\2\2JK\7q\2\2KL\7t\2\2LM\7o\2\2M\4\3\2\2\2NO\7#\2\2"+
		"OP\7?\2\2P\6\3\2\2\2QR\7#\2\2R\b\3\2\2\2ST\7K\2\2TU\7p\2\2UV\7v\2\2V\n"+
		"\3\2\2\2WX\7U\2\2XY\7v\2\2YZ\7t\2\2Z\f\3\2\2\2[\\\7E\2\2\\]\7w\2\2]^\7"+
		"t\2\2^\16\3\2\2\2_`\7D\2\2`a\7q\2\2ab\7q\2\2bc\7n\2\2c\20\3\2\2\2de\7"+
		"v\2\2ef\7t\2\2fg\7w\2\2gh\7g\2\2h\22\3\2\2\2ij\7h\2\2jk\7c\2\2kl\7n\2"+
		"\2lm\7u\2\2mn\7g\2\2n\24\3\2\2\2op\7k\2\2pq\7h\2\2q\26\3\2\2\2rs\7~\2"+
		"\2st\7~\2\2t\30\3\2\2\2uv\7(\2\2vw\7(\2\2w\32\3\2\2\2xy\7?\2\2y\34\3\2"+
		"\2\2z{\7@\2\2{\36\3\2\2\2|}\7@\2\2}~\7?\2\2~ \3\2\2\2\177\u0080\7?\2\2"+
		"\u0080\u0081\7?\2\2\u0081\"\3\2\2\2\u0082\u0083\7>\2\2\u0083\u0084\7?"+
		"\2\2\u0084$\3\2\2\2\u0085\u0086\7>\2\2\u0086&\3\2\2\2\u0087\u0088\7}\2"+
		"\2\u0088(\3\2\2\2\u0089\u008a\7\177\2\2\u008a*\3\2\2\2\u008b\u008c\7*"+
		"\2\2\u008c,\3\2\2\2\u008d\u008e\7+\2\2\u008e.\3\2\2\2\u008f\u0090\7<\2"+
		"\2\u0090\60\3\2\2\2\u0091\u0092\7=\2\2\u0092\62\3\2\2\2\u0093\u0094\7"+
		"-\2\2\u0094\64\3\2\2\2\u0095\u0096\7/\2\2\u0096\66\3\2\2\2\u0097\u0098"+
		"\7\61\2\2\u00988\3\2\2\2\u0099\u009a\7,\2\2\u009a:\3\2\2\2\u009b\u009f"+
		"\t\2\2\2\u009c\u009e\t\3\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0<\3\2\2\2\u00a1\u009f\3\2\2\2"+
		"\u00a2\u00a6\7$\2\2\u00a3\u00a5\13\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\7$\2\2\u00aa>\3\2\2\2\u00ab\u00ac\5;\36\2\u00ac"+
		"\u00ad\7\60\2\2\u00ad\u00ae\5;\36\2\u00ae@\3\2\2\2\u00af\u00b0\t\4\2\2"+
		"\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b!\2\2\u00b2B\3\2\2\2\u00b3\u00b4\7\61"+
		"\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\13\2\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00ba\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7,\2\2\u00bd"+
		"\u00be\7\61\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\"\2\2\u00c0D\3\2\2\2"+
		"\u00c1\u00c2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6"+
		"\13\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb"+
		"\7\f\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b#\2\2\u00cdF\3\2\2\2\u00ce\u00d2"+
		"\t\5\2\2\u00cf\u00d1\t\6\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3H\3\2\2\2\u00d4\u00d2\3\2\2\2"+
		"\b\2\u009f\u00a6\u00b9\u00c7\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}