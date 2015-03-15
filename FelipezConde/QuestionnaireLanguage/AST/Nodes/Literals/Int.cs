using AST.Representation;
using System;

namespace AST.Nodes.Literals
{
    public class Int : Literal
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

        public override object GetValueType()
        {
            return this;
        }

        public override string ToString()
        {
            return "int";
        }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override Types.Type RetrieveType()
        {
            throw new NotImplementedException();
        }

        #region Add
        public override Literal Add(Literal value)
        {
            return value.IntegerAdd(this);
        }
        public override Literal IntegerAdd(Literals.Int intValue)
        {
            return new Int(intValue.GetValue() + GetValue());
        }
        
        #endregion

        #region Substract
        public override Literal Substract(Literal value)
        {
            return value.IntegerSubstract(this);
        }
        public override Literal IntegerSubstract(Literals.Int intValue)
        {
            return new Int(intValue.GetValue() - GetValue());
        }
        #endregion

        #region Divide
        public override Literal Divide(Literal value)
        {
            return value.IntegerDivide(this);
        }
        public override Literal IntegerDivide(Literals.Int intValue)
        {
            return new Int(intValue.GetValue() / GetValue());
        }
        #endregion

        #region Multiply
        public override Literal Multiply(Literal value)
        {
            return value.IntegerMultiply(this);
        }
        public override Literal IntegerMultiply(Literals.Int intValue)
        {
            return new Int(intValue.GetValue() * GetValue());
        }
        #endregion

        #region Equals
        public override Literal Equal(Literal value)
        {
            return value.IntegerEqual(this);
        }
        public override Literal IntegerEqual(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() == GetValue());
        }
        #endregion

        #region NotEqual
        public override Literal NotEqual(Literal value)
        {
            return value.IntegerNotEqual(this);
        }
        public override Literal IntegerNotEqual(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() != GetValue());
        }
        #endregion
        
        #region GreaterThan
        public override Literal Greater(Literal value)
        {
            return value.IntegerGreater(this);
        }
        public override Literal IntegerGreater(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() > GetValue());
        }
        #endregion

        #region GreaterEqualThan
        public override Literal GreaterEqual(Literal value)
        {
            return value.IntegerGreaterEqual(this);
        }
        public override Literal IntegerGreaterEqual(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() >= GetValue());
        }
        #endregion

        #region LessThan
        public override Literal Less(Literal value)
        {
            return value.IntegerLess(this);
        }
        public override Literal IntegerLess(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() < GetValue());
        }
        #endregion

        #region LessEqualThan
        public override Literal LessEqual(Literal value)
        {
            return value.IntegerLessEqual(this);
        }
        public override Literal IntegerLessEqual(Literals.Int intValue)
        {
            return new Bool(intValue.GetValue() <= GetValue());
        }
        #endregion
    }
}
