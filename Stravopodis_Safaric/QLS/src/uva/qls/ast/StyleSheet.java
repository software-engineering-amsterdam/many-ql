package uva.qls.ast;

import java.util.List;

import uva.qls.ast.literal.Identifier;
import uva.qls.ast.statements.visitor.StatementVisitor;

public class StyleSheet extends ASTNode {
	
	private Identifier identifier;
	private List<Page> page; 
	
	public StyleSheet (Identifier _identifier, List<Page> _page, CodeLines _codeLines) {
		super(_codeLines);
		this.identifier=_identifier;
		this.page=_page;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public List<Page> getPage(){
		return this.page;
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitStyleSheet(this);
	}

	@Override
	public String toString(){
		return "StyleSheet(" + this.identifier.toString() + "," + page.toString() + ")";
	}
}
