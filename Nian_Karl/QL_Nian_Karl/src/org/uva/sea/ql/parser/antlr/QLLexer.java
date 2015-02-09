// Generated from QL.g4 by ANTLR 4.5

package org.uva.sea.ql.parser.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QuestionType=1, WS=2, COMMENT=3, Bool=4, Ident=5, Int=6, Str=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"QuestionType", "WS", "COMMENT", "Bool", "Ident", "Int", "Str"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "QuestionType", "WS", "COMMENT", "Bool", "Ident", "Int", "Str"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tI\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\37\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\7\6\67"+
		"\n\6\f\6\16\6:\13\6\3\7\6\7=\n\7\r\7\16\7>\3\b\3\b\7\bC\n\b\f\b\16\bF"+
		"\13\b\3\b\3\b\4*D\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\7\5\2\13\f\17"+
		"\17\"\"\t\2\"\"))ccghnntw~~\4\2C\\c|\6\2\62;C\\aac|\3\2\62;O\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\3\36\3\2\2\2\5 \3\2\2\2\7$\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r"+
		"<\3\2\2\2\17@\3\2\2\2\21\22\7K\2\2\22\23\7p\2\2\23\37\7v\2\2\24\25\7U"+
		"\2\2\25\26\7v\2\2\26\37\7t\2\2\27\30\7E\2\2\30\31\7w\2\2\31\37\7t\2\2"+
		"\32\33\7D\2\2\33\34\7q\2\2\34\35\7q\2\2\35\37\7n\2\2\36\21\3\2\2\2\36"+
		"\24\3\2\2\2\36\27\3\2\2\2\36\32\3\2\2\2\37\4\3\2\2\2 !\t\2\2\2!\"\3\2"+
		"\2\2\"#\b\3\2\2#\6\3\2\2\2$%\7\61\2\2%&\7,\2\2&*\3\2\2\2\')\13\2\2\2("+
		"\'\3\2\2\2),\3\2\2\2*+\3\2\2\2*(\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7,\2\2"+
		"./\7\61\2\2/\60\3\2\2\2\60\61\b\4\2\2\61\b\3\2\2\2\62\63\t\3\2\2\63\n"+
		"\3\2\2\2\648\t\4\2\2\65\67\t\5\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2"+
		"\289\3\2\2\29\f\3\2\2\2:8\3\2\2\2;=\t\6\2\2<;\3\2\2\2=>\3\2\2\2><\3\2"+
		"\2\2>?\3\2\2\2?\16\3\2\2\2@D\7$\2\2AC\13\2\2\2BA\3\2\2\2CF\3\2\2\2DE\3"+
		"\2\2\2DB\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7$\2\2H\20\3\2\2\2\b\2\36*8>D\3"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}