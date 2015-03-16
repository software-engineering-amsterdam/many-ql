package org.uva.ql.antlr;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class QLImplErrorListener implements ANTLRErrorListener {

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
			BitSet ambigAlts, ATNConfigSet configs) {
		System.out.println("Error, ambiguity in the input.");
		System.out.println("Line: " + startIndex + " to " + stopIndex);
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
			BitSet conflictingAlts, ATNConfigSet configs) {
		System.out.println("Error, attempting full context in the input.");
		System.out.println("Line: " + startIndex + " to " + stopIndex);
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
			ATNConfigSet configs) {
		System.out.println("Error, context sensitive in the input.");
		System.out.println("Line: " + startIndex + " to " + stopIndex);
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, java.lang.Object offendingSymbol, int line,
			int charPositionInLine, String msg, RecognitionException e) {
		System.out.println("Syntax error.");
		System.out.println("Line: " + line);
	}
}
