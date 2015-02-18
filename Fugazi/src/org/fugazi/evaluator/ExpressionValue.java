package org.fugazi.evaluator;

public abstract class ExpressionValue {

    ExpressionValue() {

    }

    public abstract ExpressionValue getValue();

    public ExpressionValue add(ExpressionValue exprValue) {
    	//throw new Exception("This is an abstract implementation of add.");
        return new UndefinedValue();
    }
    
    public ExpressionValue addInt(ExpressionValue exprValue) {
        return null;        
    }
    
    public ExpressionValue addString(ExpressionValue exprValue) {
       return null;     
    }
}
