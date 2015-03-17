package qls;

import qls.value.FloatValue;
import qls.value.IntegerValue;

public interface Value extends ql.Value {
	public boolean assignWidth(Value argument);
	public boolean assignWidthInteger(IntegerValue argument);
	public boolean assignWidthFloat(FloatValue argument);
	
	public boolean assignHeight(Value argument);
	public boolean assignHeightInteger(IntegerValue argument);
	public boolean assignHeightFloat(FloatValue argument);
	
	public boolean assignFont(Value argument);
	public boolean assignFontInteger(IntegerValue argument);
	
	public boolean assignFontSize(Value argument);
	public boolean assignFontSizeInteger(IntegerValue argument);
	
	public boolean assignColour(Value argument);
	public boolean assignColourInteger(IntegerValue argument);
}
