using System;

namespace Evaluation.Values
{
    public abstract class Value
    {
        public abstract T Accept<T>(IValueVisitor<T> visitor);
        public abstract Value Equal(Value value);
        public abstract Value NotEqual(Value value);
        public virtual Bool Negate() { throw new NotImplementedException(); }
        public virtual Value And(Value value) { throw new NotImplementedException(); }
        public virtual Value Or(Value value) { throw new NotImplementedException(); }
        public virtual Value Greater(Value value) { throw new NotImplementedException(); }
        public virtual Value GreaterEqual(Value value) { throw new NotImplementedException(); }
        public virtual Value Less(Value value) { throw new NotImplementedException(); }
        public virtual Value LessEqual(Value value) { throw new NotImplementedException(); }
        public virtual Value Add(Value value) { throw new NotImplementedException(); }
        public virtual Value Substract(Value value) { throw new NotImplementedException(); }
        public virtual Value Divide(Value value) { throw new NotImplementedException(); }
        public virtual Value Multiply(Value value) { throw new NotImplementedException(); }
        public virtual Value BoolAnd(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Value BoolOr(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Value BoolEqual(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Value BoolNotEqual(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Value StringEqual(Values.String stringValue) { throw new NotImplementedException(); }
        public virtual Value StringNotEqual(Values.String stringValue) { throw new NotImplementedException(); }
        public virtual Value IntegerAdd(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerSubstract(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerDivide(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerMultiply(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerEqual(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerNotEqual(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerGreater(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerGreaterEqual(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerLess(Values.Int intValue) { throw new NotImplementedException(); }
        public virtual Value IntegerLessEqual(Values.Int intValue) { throw new NotImplementedException(); }
    }
}
