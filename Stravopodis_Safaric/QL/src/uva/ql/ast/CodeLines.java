package uva.ql.ast;
import uva.ql.supporting.*;

public class CodeLines {
	
	private Tuple<Integer, Integer> codeLines;
	
	public CodeLines(int startCodeLine, int endCodeLine){
		this.codeLines = new Tuple<Integer, Integer>(startCodeLine, endCodeLine);
	}
	
	public Tuple<Integer, Integer> getLOCTuple(){
		return this.codeLines;
	}
	
	public boolean equals(CodeLines obj){
		return this.codeLines.getX() == obj.getLOCTuple().getX() && this.codeLines.getY() == obj.getLOCTuple().getY();
	}
	
	@Override
	public String toString(){
		return "CodeLines(" + this.getLOCTuple().getX() + "," + this.getLOCTuple().getY() + ")";
	}
}
