using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Nodes.Literals
{
    public abstract class Literal : ILiteral
    {
        private readonly PositionInText Position;
        protected Literal() { }
        protected Literal(PositionInText position)
        {
            Position = position;
        }
        public virtual PositionInText GetPosition(){ return Position; }

        public abstract object GetValueType();
        public abstract Literal Equal(Literal value);
        public abstract Literal NotEqual(Literal value);

        public virtual Bool Negate() { return null; }
        public virtual Literal And(Literal value) { return null; }
        public virtual Literal Or(Literal value) { return null; }
        public virtual Literal Greater(Literal value) { return null; }
        public virtual Literal GreaterEqual(Literal value) { return null; }
        public virtual Literal Less(Literal value) { return null; }
        public virtual Literal LessEqual(Literal value) { return null; }
        public virtual Literal Add(Literal value) { return null; }
        public virtual Literal Substract(Literal value) { return null; }
        public virtual Literal Divide(Literal value) { return null; }
        public virtual Literal Multiply(Literal value) { return null; }


        public virtual Literal BoolAnd(Bool boolValue) { return null; }
        public virtual Literal BoolOr(Bool boolValue) { return null; }
        public virtual Literal BoolEqual(Bool boolValue) { return null; }
        public virtual Literal BoolNotEqual(Bool boolValue) { return null; }

        public virtual Literal StringEqual(Literals.String stringValue) { return null; }
        public virtual Literal StringNotEqual(Literals.String stringValue) { return null; }

        public virtual Literal IntegerAdd(Literals.Int intValue) { return null; }
        public virtual Literal IntegerSubstract(Literals.Int intValue) { return null; }
        public virtual Literal IntegerDivide(Literals.Int intValue) { return null; }
        public virtual Literal IntegerMultiply(Literals.Int intValue) { return null; }
        public virtual Literal IntegerEqual(Literals.Int intValue) { return null; }
        public virtual Literal IntegerNotEqual(Literals.Int intValue) { return null; }
        public virtual Literal IntegerGreater(Literals.Int intValue) { return null; }
        public virtual Literal IntegerGreaterEqual(Literals.Int intValue) { return null; }
        public virtual Literal IntegerLess(Literals.Int intValue) { return null; }
        public virtual Literal IntegerLessEqual(Literals.Int intValue) { return null; }

        public virtual void Accept(Visitors.IVisitor visitor) {}

        public virtual T Accept<T>(Visitors.IVisitor<T> visitor) { return default(T); }

        public abstract string MakeString();

        public bool IsOfType(Types.Type type)
        {
            throw new NotImplementedException();
        }

        public virtual Types.Type RetrieveType()
        {
            throw new NotImplementedException();
        }
    } 
}
