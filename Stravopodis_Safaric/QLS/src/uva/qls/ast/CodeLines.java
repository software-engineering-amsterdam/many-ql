package uva.qls.ast;
import uva.qls.supporting.*;

public class CodeLines {

	Tuple <Integer, Integer> codeLines;
	
	public CodeLines (int startLine, int endLine){
		this.codeLines= new Tuple<Integer,Integer>(startLine,endLine);
	}
	
	public Tuple<Integer, Integer> getCodeLocation(){
		return this.codeLines;
	}
}
