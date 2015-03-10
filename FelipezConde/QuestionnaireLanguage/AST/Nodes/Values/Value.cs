using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Storage;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Nodes.Values
{
    public abstract class Value
    {
        private readonly PositionInText Position;
        protected Value() { }
        protected Value(PositionInText position)
        {
            Position = position;
        }
        public virtual PositionInText GetPosition(){ return Position; }

        public abstract object GetType(ISymbolTable lookup);
        public abstract Value Equal(Value value);
        public abstract Value NotEqual(Value value);

        public virtual Bool Negate() { return null; }
        public virtual Value And(Value value) { return null; }
        public virtual Value Or(Value value) { return null; }
        public virtual Value Greater(Value value) { return null; }
        public virtual Value GreaterEqual(Value value) { return null; }
        public virtual Value Less(Value value) { return null; }
        public virtual Value LessEqual(Value value) { return null; }
        public virtual Value Add(Value value) { return null; }
        public virtual Value Substract(Value value) { return null; }
        public virtual Value Divide(Value value) { return null; }
        public virtual Value Multiply(Value value) { return null; }


        public virtual Value BoolAnd(Bool boolValue) { return null; }
        public virtual Value BoolOr(Bool boolValue) { return null; }
        public virtual Value BoolEqual(Bool boolValue) { return null; }
        public virtual Value BoolNotEqual(Bool boolValue) { return null; }

        public virtual Value StringEqual(Values.String stringValue) { return null; }
        public virtual Value StringNotEqual(Values.String stringValue) { return null; }

        public virtual Value IntegerAdd(Values.Int intValue) { return null; }
        public virtual Value IntegerSubstract(Values.Int intValue) { return null; }
        public virtual Value IntegerDivide(Values.Int intValue) { return null; }
        public virtual Value IntegerMultiply(Values.Int intValue) { return null; }
        public virtual Value IntegerEqual(Values.Int intValue) { return null; }
        public virtual Value IntegerNotEqual(Values.Int intValue) { return null; }
        public virtual Value IntegerGreater(Values.Int intValue) { return null; }
        public virtual Value IntegerGreaterEqual(Values.Int intValue) { return null; }
        public virtual Value IntegerLess(Values.Int intValue) { return null; }
        public virtual Value IntegerLessEqual(Values.Int intValue) { return null; }

        public virtual void Accept(Visitors.IVisitor visitor) {}

        public virtual T Accept<T>(Visitors.IVisitor<T> visitor) { return default(T); }

        public abstract string MakeString();

        public bool IsOfType(Types.Type type)
        {
            throw new NotImplementedException();
        }
    } 
}
