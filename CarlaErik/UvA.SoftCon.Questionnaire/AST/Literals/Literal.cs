using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Literals
{
    public abstract class Literal<T>
    {
        public T Value
        {
            get;
            private set;
        }

        public Literal(T value)
        {
            Value = value;
        }
    }
}
