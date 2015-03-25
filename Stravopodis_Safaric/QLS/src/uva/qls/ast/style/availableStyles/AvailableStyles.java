package uva.qls.ast.style.availableStyles;

import uva.qls.ast.literal.*;
import uva.qls.ast.style.*;
import uva.qls.ast.style.visitor.StyleTable;

public enum AvailableStyles {

	COLOR(		"Color", 			new Color("000000", null)),
	FONTNAME(	"FontName", 		new FontName(new StringLiteral("Arial", null), null)),
	FONTSIZE(	"FontSize", 		new FontSize(new IntLiteral(12, null), null)),
	HEIGHT(		"Height", 			new Height(new IntLiteral(30, null), null)),
	WIDTH(		"Width", 			new Width(new IntLiteral(200, null), null));
	
	private String styleName;
	private Style style;
	
	private AvailableStyles(String _styleName, Style _style){
		this.styleName = _styleName;
		this.style = _style;
	}
	
	public String getStyleName(){
		return this.styleName;
	}
	
	public static StyleTable getAvailableStyles(){
		StyleTable table = new StyleTable();
		
		for (AvailableStyles s : values()){
			table.putValue(s.getStyleName(), s.style);
		}
		
		return table;
	}
	
}
