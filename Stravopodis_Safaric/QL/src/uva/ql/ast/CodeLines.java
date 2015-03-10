package uva.ql.ast;
import uva.ql.supporting.*;

public class CodeLines {
	Tuple<Integer, Integer> codeLines;
	
	public CodeLines(int startCodeLine, int endCodeLine){
		this.codeLines = new Tuple<Integer, Integer>(startCodeLine, endCodeLine);
	}
	public Tuple<Integer, Integer> getLOCTuple(){
		return this.codeLines;
	}
}
