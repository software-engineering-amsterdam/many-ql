using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace QL.Exceptions
{
    public class EvaluationError : QLError
    {
        public override string Origin
        {
            get { return "Evaluator"; }
        }
        public EvaluationError(string message)
            : base(message)
        { }
    }
}
