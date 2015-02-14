using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>num_expr</c> parser rule.
    /// </summary>
    internal class NumericExpressionVisitor : QLBaseVisitor<INumericExpression>
    {

    }
}
