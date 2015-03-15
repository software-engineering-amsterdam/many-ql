using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QL.Errors;

namespace QL
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
