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
		return this.getLOCTuple().getX() == obj.getLOCTuple().getX() && this.getLOCTuple().getY() == obj.getLOCTuple().getY();
	}
	
	@Override
	public String toString(){
		return "CodeLines(" + this.getLOCTuple().getX() + "," + this.getLOCTuple().getY() + ")";
	}
}
