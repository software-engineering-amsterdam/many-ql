package uva.qls.interpreter.typecheck;

public enum CheckWidget {
	
	radioButton("boolean"),
	dropDown("boolean"),
	checkBox("boolean"),
	slider("integer"),
	spinBox("integer"),
	numTextBox("integer"),
	strTextBox("string");
	
	private String type;
	
	private CheckWidget(String _type){
		this.type = _type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public CheckWidget detectType(String _type){
		for (CheckWidget kind : CheckWidget.values())
			if (_type.equals(kind.getType()))
				return kind;
		return null;
	}

}
