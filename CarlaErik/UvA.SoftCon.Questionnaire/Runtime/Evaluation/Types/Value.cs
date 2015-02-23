using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public abstract class Value<T> : IValue
    {
        public T Value
        {
            get;
            private set;
        }


        public virtual IValue Add(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IValue Substract(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IValue Or(IValue value)
        {
            throw new InvalidOperationException();
        }
    }
}
