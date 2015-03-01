using System;
using QL.Model.Terminals;
using QL.Exceptions;

namespace QL.Model.Operators
{
    public class EqualsOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }
        public override Type GetReturnType()
        {
            return (new Yesno()).GetType();
        }
        protected override bool _CheckType(){
            TypeExceptions.Clear();
            if (Left.GetReturnType() == Right.GetReturnType())
                return true;
            else
            {
                TypeExceptions.Add(
                    new TypeException(String.Format("Types not comparable: {0} and {1} on position {2}", Left.GetReturnType().ToString(), Right.GetReturnType().ToString(), SourceLocation), this
                        )
                        );
                return false;

            }
                ;
        }
    }
}