using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Representation;
using Types = AST.Types;

namespace AST.Nodes.Literals
{
    public class Bool : Literal
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

        public override object GetValueType()
        {
            return this;
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

        public override Types.Type RetrieveType()
        {
            return new Types.BoolType();
        }

        #region And
        public override Literal And(Literal value)
        {
            return value.BoolAnd(this);
        }

        public  override Literal BoolAnd(Bool boolValue)
        {
            return new Bool(GetValue() && boolValue.value);
        }
        #endregion

        #region Or
        public override Literal Or(Literal value)
        {
            return value.BoolOr(this);
        }

        public override Literal BoolOr(Bool boolValue)
        {
            return new Bool(value || boolValue.value);
        }
        #endregion

        #region Equal
        public override Literal Equal(Literal value)
        {
            return value.BoolEqual(this);
        }

        public override Literal BoolEqual(Bool boolValue)
        {
            return new Bool(value == boolValue.value);
        }
        #endregion

        #region NotEqual
        public override Literal NotEqual(Literal value)
        {
            return value.BoolEqual(this);
        }

        public override Literal BoolNotEqual(Bool boolValue)
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
