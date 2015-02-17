//package org.fugazi.evaluator;
//
//public class StringValue extends ExpressionValue {
//
//    private final String value;
//
//    public StringValue(String _value) {
//        this.value = _value;
//    }
//
//    @Override
//    public ExpressionValue add(ExpressionValue exprValue) {
//        return addString(exprValue);
//    }
//
//    @Override
//    public ExpressionValue addInt(ExpressionValue exprValue) {
//        //throw new Exception("This is an abstract implementation of add.");
//        return new UndefinedValue();
//    }
//
//    @Override
//    public ExpressionValue addString(StringValue exprValue) {
//        return new StringValue(this.getValue() + exprValue.getValue());
//    }
//
//    public String getValue() {
//        return this.value;
//    }
//}