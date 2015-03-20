package uva.qls.interpreter.typecheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CheckWidget {
	
	radio("boolean"),
	dropdown("boolean"),
	checkbox("boolean"),
	
	slider("integer"),
	spinbox("integer"),
	intTextBox("integer"),
	
	strTextBox("string"),
	
	monSlider("money"),
	monSpinbox("money"),
	monTextbox("money");
	
	private String type;
	
	private CheckWidget(String _type){
		this.type = _type;
	}

	public String getName(){
		if (this.hasPrefix(Arrays.asList("int","str","mon"))){
			return this.name().substring(3).toLowerCase();
		}
		return name();
	}
	
	private boolean hasPrefix(List<String> prefix){
		return prefix.contains(this.name().subSequence(0, 3));
	}
	
	public String getType(){
		return this.type;
	}
	
	public static CheckWidget detectType(String _type){
		for (CheckWidget kind : CheckWidget.values())
			if (_type.equals(kind.getType())){
				return kind;
			}
		return null;
	}
	
	public static List<CheckWidget> detectTypes(String _type){
		List<CheckWidget> widgets = new ArrayList<CheckWidget>();
		for (CheckWidget kind : CheckWidget.values()){
			if (_type.equals(kind.getType())){
				widgets.add(kind);
			}
		}
		return widgets;
	}
}
