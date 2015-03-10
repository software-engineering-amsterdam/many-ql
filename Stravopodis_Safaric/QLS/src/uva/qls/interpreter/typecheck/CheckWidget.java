package uva.qls.interpreter.typecheck;

import java.util.ArrayList;
import java.util.List;

public enum CheckWidget {
	
	radio("boolean"),
	dropdown("boolean"),
	checkbox("boolean"),
	slider("integer"),
	spinbox("integer"),
	numTextBox("integer"),
	strTextBox("string");
	
	private String type;
	
	private CheckWidget(String _type){
		this.type = _type;
	}

	public String getName(){
		if (this.name().equals("numTextBox") || this.name().equals("strTextBox"))
			return this.name().substring(3).toLowerCase();
		return name();
	}
	
	public String getType(){
		return this.type;
	}
	
	public static CheckWidget detectType(String _type){
		for (CheckWidget kind : CheckWidget.values())
			if (_type.equals(kind.getType()))
				return kind;
		return null;
	}
	
	public static List<CheckWidget> detectTypes(String _type){
		List<CheckWidget> widgets = new ArrayList<CheckWidget>();
		for (CheckWidget kind : CheckWidget.values()){
			if (_type.equals(kind.getType()))
				widgets.add(kind);
		}
		return widgets;
	}
}
