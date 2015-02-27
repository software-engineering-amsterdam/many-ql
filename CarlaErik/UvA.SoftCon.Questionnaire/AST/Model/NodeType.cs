using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    public enum NodeType
    {
        Form,
        Question,
        Result,
        Declaration,
        IfStatement,
        Assignment,
        Identifier,
        BooleanLiteral,
        DoubleLiteral,
        IntegerLiteral,
        StringLiteral,
        Add,
        And,
        Divide,
        EqualTo,
        GreaterThan,
        GreaterThanOrEqualTo,
        LessThan,
        LessThanOrEqualTo,
        Multiply,
        NotEqualTo,
        Or,
        Substract,
        Increment,
        Negation
    }
}
