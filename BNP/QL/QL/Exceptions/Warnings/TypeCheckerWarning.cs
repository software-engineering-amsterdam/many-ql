using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QL.Exceptions;

namespace QL
{
    public class TypeCheckerWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Typechecker warning"; }
        }

    }
}
