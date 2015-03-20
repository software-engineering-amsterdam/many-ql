package uva.qls.ast.value;

import java.awt.Color;


public class ColorValue extends GenericValue <Color>{

	private Color value;
	
	public ColorValue(String _value){
		this.value = this.hexToColor(_value);
	}
	
	public ColorValue(Color _value){
		this.value = _value;
	}
	
	private Color hexToColor(String _value){
		String hexString = new StringBuilder(_value).insert(0, "#").toString();
		return _value.substring(0).equals("#") ? Color.decode(_value) : Color.decode(hexString);
	}
	
	@Override
	public Color getValue() {
		return this.value;
	}
}
