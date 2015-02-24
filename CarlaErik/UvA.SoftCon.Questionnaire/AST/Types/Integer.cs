using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Types
{
    public class Integer : Value<int>
    {
        public Integer(int value)
            : base(DataType.Integer, value) { }

        public override Integer Add(IValue value)
        {
            
        }



        public override Value EqualsTo(Value value)
        {
            return value.EqualsToInteger(this);
        }

        protected Value EqualsToInteger(Integer value)
        {
            return new Boolean(value.Value == this.Value);
        }
    }
}
