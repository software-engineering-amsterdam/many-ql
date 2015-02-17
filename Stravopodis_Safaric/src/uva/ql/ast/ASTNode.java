package uva.ql.ast;

import java.util.List;

import uva.ql.supporting.Tuple;

public interface ASTNode {
	
	public String toString();
	public Tuple<Integer, Integer> getCodeLine();
}
