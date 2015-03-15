using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QL.Errors;

namespace QL
{
    public class EvaluationWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Evaluation warning"; }
        }
    }
}
