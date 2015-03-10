using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Resources;
using ValueTypes = AST.Resources;

namespace AST.Nodes.Values
{
    public class Bool : Value
    {
        private readonly bool value;
        private PositionInText positionInText;

        public Bool(bool parsedValue)
        {
            this.value = parsedValue;
        }

        public Bool(bool parsedValue, PositionInText positionInText)
        {
            this.value = parsedValue;
            this.positionInText = positionInText;
        }

        public bool GetValue()
        {
            return value;
        }

        public override string MakeString()
        {
            return "bool";
        }

        public override ValueTypes.Types GetType(Storage.ISymbolTable lookup)
        {
            return ValueTypes.Types.BOOL;
        }

        // Visitor Methods
        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        #region And
        public override Value And(Value value)
        {
            return value.BoolAnd(this);
        }

        public  override Value BoolAnd(Bool boolValue)
        {
            return new Bool(GetValue() && boolValue.value);
        }
        #endregion

        #region Or
        public override Value Or(Value value)
        {
            return value.BoolOr(this);
        }

        public override Value BoolOr(Bool boolValue)
        {
            return new Bool(value || boolValue.value);
        }
        #endregion

        #region Equal
        public override Value Equal(Value value)
        {
            return value.BoolEqual(this);
        }

        public override Value BoolEqual(Bool boolValue)
        {
            return new Bool(value == boolValue.value);
        }
        #endregion

        #region NotEqual
        public override Value NotEqual(Value value)
        {
            return value.BoolEqual(this);
        }

        public override Value BoolNotEqual(Bool boolValue)
        {
            return new Bool(value != boolValue.value);
        }
        #endregion

        #region Negate
        public override Bool Negate()
        {
            return new Bool(!GetValue());
        }

        #endregion


    }
}
