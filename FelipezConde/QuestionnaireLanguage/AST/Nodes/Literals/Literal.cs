using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Representation;
using System;

namespace AST.Nodes.Literals
{
    public abstract class Literal : Expression, IHasType
    {
        protected Literal(PositionInText position)
            : base(position) {}
        public abstract object GetValueType();
        public abstract Literal Equal(Literal value);
        public abstract Literal NotEqual(Literal value);
        public virtual Bool Negate() { throw new NotImplementedException(); }
        public virtual Literal And(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Or(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Greater(Literal value) { throw new NotImplementedException(); }
        public virtual Literal GreaterEqual(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Less(Literal value) { throw new NotImplementedException(); }
        public virtual Literal LessEqual(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Add(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Substract(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Divide(Literal value) { throw new NotImplementedException(); }
        public virtual Literal Multiply(Literal value) { throw new NotImplementedException(); }
        public virtual Literal BoolAnd(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Literal BoolOr(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Literal BoolEqual(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Literal BoolNotEqual(Bool boolValue) { throw new NotImplementedException(); }
        public virtual Literal StringEqual(Literals.String stringValue) { throw new NotImplementedException(); }
        public virtual Literal StringNotEqual(Literals.String stringValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerAdd(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerSubstract(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerDivide(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerMultiply(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerEqual(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerNotEqual(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerGreater(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerGreaterEqual(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerLess(Literals.Int intValue) { throw new NotImplementedException(); }
        public virtual Literal IntegerLessEqual(Literals.Int intValue) { throw new NotImplementedException(); }
        public bool IsOfType(Types.Type type){ throw new NotImplementedException();}
        public virtual Types.Type RetrieveType(){throw new NotImplementedException();}
        public abstract override T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    } 
}
