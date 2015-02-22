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
        Declaration,
        IfStatement,
        Assignment,
        BinaryExpression,
        Identifier,
        BooleanLiteral,
        DoubleLiteral,
        IntegerLiteral,
        StringLiteral
    }
}
