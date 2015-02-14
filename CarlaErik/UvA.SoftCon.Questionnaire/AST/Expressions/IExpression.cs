using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions
{
    public interface IExpression<T>
    {
        /// <summary>
        /// Evaluates the expression and returns it result.
        /// </summary>
        /// <returns>The result of the evaluated expression.</returns>
        T Evaluate();
    }
}
