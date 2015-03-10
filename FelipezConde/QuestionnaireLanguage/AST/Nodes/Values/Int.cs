using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Representation;
using ValueTypes = AST.Resources;

namespace AST.Nodes.Values
{
    public class Int : Value, IValue
    {
        private readonly int value;

        public Int(int value)
        {
            this.value = value;
        }

        public Int(int value, PositionInText positionInText)
            :base(positionInText)
        {
            this.value = value;
        }

        public int GetValue()
        {
            return value;
        }

        public override ValueTypes.Types GetType(Storage.ISymbolTable lookup)
        {
            return ValueTypes.Types.INT;
        }

        public override string MakeString()
        {
            return "int";
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

        #region Add
        public override Value Add(Value value)
        {
            return value.IntegerAdd(this);
        }
        public override Value IntegerAdd(Values.Int intValue)
        {
            return new Int(intValue.GetValue() + GetValue());
        }
        
        #endregion

        #region Substract
        public override Value Substract(Value value)
        {
            return value.IntegerSubstract(this);
        }
        public override Value IntegerSubstract(Values.Int intValue)
        {
            return new Int(intValue.GetValue() - GetValue());
        }
        #endregion

        #region Divide
        public override Value Divide(Value value)
        {
            return value.IntegerDivide(this);
        }
        public override Value IntegerDivide(Values.Int intValue)
        {
            return new Int(intValue.GetValue() / GetValue());
        }
        #endregion

        #region Multiply
        public override Value Multiply(Value value)
        {
            return value.IntegerMultiply(this);
        }
        public override Value IntegerMultiply(Values.Int intValue)
        {
            return new Int(intValue.GetValue() * GetValue());
        }
        #endregion

        #region Equals
        public override Value Equal(Value value)
        {
            return value.IntegerEqual(this);
        }
        public override Value IntegerEqual(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() == GetValue());
        }
        #endregion

        #region NotEqual
        public override Value NotEqual(Value value)
        {
            return value.IntegerNotEqual(this);
        }
        public override Value IntegerNotEqual(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() != GetValue());
        }
        #endregion
        
        #region GreaterThan
        public override Value Greater(Value value)
        {
            return value.IntegerGreater(this);
        }
        public override Value IntegerGreater(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() > GetValue());
        }
        #endregion

        #region GreaterEqualThan
        public override Value GreaterEqual(Value value)
        {
            return value.IntegerGreaterEqual(this);
        }
        public override Value IntegerGreaterEqual(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() >= GetValue());
        }
        #endregion

        #region LessThan
        public override Value Less(Value value)
        {
            return value.IntegerLess(this);
        }
        public override Value IntegerLess(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() < GetValue());
        }
        #endregion

        #region LessEqualThan
        public override Value LessEqual(Value value)
        {
            return value.IntegerLessEqual(this);
        }
        public override Value IntegerLessEqual(Values.Int intValue)
        {
            return new Bool(intValue.GetValue() <= GetValue());
        }
        #endregion

    }
}
