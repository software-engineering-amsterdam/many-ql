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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, WS=15, COMMENT=16, Bool=17, 
		Int=18, Float=19, Str=20, TRUE=21, FALSE=22, Ident=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "WS", "COMMENT", "Bool", "Int", 
		"Float", "Str", "TRUE", "FALSE", "Ident"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21[\n\21\f\21\16\21^\13\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\5\22g\n\22\3\23\6\23j\n\23\r\23\16\23k\3"+
		"\24\3\24\5\24p\n\24\3\24\5\24s\n\24\3\25\3\25\7\25w\n\25\f\25\16\25z\13"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u008a\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u009b\n\27\3\30\3\30\7\30\u009f\n\30\f"+
		"\30\16\30\u00a2\13\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3"+
		"\2\6\5\2\13\f\17\17\"\"\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\u00ac\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3"+
		"\2\2\2\5\63\3\2\2\2\7\66\3\2\2\2\t9\3\2\2\2\13<\3\2\2\2\r?\3\2\2\2\17"+
		"B\3\2\2\2\21D\3\2\2\2\23F\3\2\2\2\25I\3\2\2\2\27K\3\2\2\2\31M\3\2\2\2"+
		"\33O\3\2\2\2\35Q\3\2\2\2\37R\3\2\2\2!V\3\2\2\2#f\3\2\2\2%i\3\2\2\2\'m"+
		"\3\2\2\2)t\3\2\2\2+\u0089\3\2\2\2-\u009a\3\2\2\2/\u009c\3\2\2\2\61\62"+
		"\7\61\2\2\62\4\3\2\2\2\63\64\7#\2\2\64\65\7?\2\2\65\6\3\2\2\2\66\67\7"+
		"~\2\2\678\7~\2\28\b\3\2\2\29:\7@\2\2:;\7?\2\2;\n\3\2\2\2<=\7(\2\2=>\7"+
		"(\2\2>\f\3\2\2\2?@\7?\2\2@A\7?\2\2A\16\3\2\2\2BC\7>\2\2C\20\3\2\2\2DE"+
		"\7@\2\2E\22\3\2\2\2FG\7>\2\2GH\7?\2\2H\24\3\2\2\2IJ\7#\2\2J\26\3\2\2\2"+
		"KL\7,\2\2L\30\3\2\2\2MN\7-\2\2N\32\3\2\2\2OP\7/\2\2P\34\3\2\2\2RS\t\2"+
		"\2\2ST\3\2\2\2TU\b\20\2\2U \3\2\2\2VW\7\61\2\2WX\7,\2\2X\\\3\2\2\2Y[\13"+
		"\2\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2"+
		"_`\7,\2\2`a\7\61\2\2ab\3\2\2\2bc\b\21\2\2c\"\3\2\2\2dg\5+\26\2eg\5-\27"+
		"\2fd\3\2\2\2fe\3\2\2\2g$\3\2\2\2hj\t\3\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2"+
		"\2kl\3\2\2\2l&\3\2\2\2mo\5%\23\2np\7\60\2\2on\3\2\2\2op\3\2\2\2pr\3\2"+
		"\2\2qs\5%\23\2rq\3\2\2\2rs\3\2\2\2s(\3\2\2\2tx\7$\2\2uw\13\2\2\2vu\3\2"+
		"\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7$\2\2|*\3\2"+
		"\2\2}~\7V\2\2~\177\7t\2\2\177\u0080\7w\2\2\u0080\u008a\7g\2\2\u0081\u0082"+
		"\7v\2\2\u0082\u0083\7t\2\2\u0083\u0084\7w\2\2\u0084\u008a\7g\2\2\u0085"+
		"\u0086\7V\2\2\u0086\u0087\7T\2\2\u0087\u0088\7W\2\2\u0088\u008a\7G\2\2"+
		"\u0089}\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0085\3\2\2\2\u008a,\3\2\2\2"+
		"\u008b\u008c\7H\2\2\u008c\u008d\7c\2\2\u008d\u008e\7n\2\2\u008e\u008f"+
		"\7u\2\2\u008f\u009b\7g\2\2\u0090\u0091\7h\2\2\u0091\u0092\7c\2\2\u0092"+
		"\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u009b\7g\2\2\u0095\u0096\7H\2\2"+
		"\u0096\u0097\7C\2\2\u0097\u0098\7N\2\2\u0098\u0099\7U\2\2\u0099\u009b"+
		"\7G\2\2\u009a\u008b\3\2\2\2\u009a\u0090\3\2\2\2\u009a\u0095\3\2\2\2\u009b"+
		".\3\2\2\2\u009c\u00a0\t\4\2\2\u009d\u009f\t\5\2\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\60"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\f\2\\fkorx\u0089\u009a\u00a0\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}