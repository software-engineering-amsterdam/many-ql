using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;
using UvA.SoftCon.Questionnaire.AST.Statements;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>stat</c> parser rule.
    /// </summary>
    internal class StatementVisitor : QLBaseVisitor<IStatement>
    {
        public override IStatement VisitIfStatement(QLParser.IfStatementContext context)
        {
            IBooleanExpression condition = context.bool_expr().Accept(new BooleanExpressionVisitor());

            var ifTrueStatements = new List<IStatement>();
            var ifFalseStatements = new List<IStatement>();
           
            foreach (var child in context._then) 
            {
                ifTrueStatements.Add(child.Accept(this));
            }
            foreach (var child in context._else)
            {
                ifFalseStatements.Add(child.Accept(this));
            }

            return new IfStatement(condition, ifTrueStatements, ifFalseStatements);
        }

        public override IStatement VisitQuestion(QLParser.QuestionContext context)
        {
            string type = context.TYPE().GetText();
            string id = context.ID().GetText();
            string label = context.STRING().GetText();

            // Remove the leading and trailing '"' characters from the string literal.
            label = label.Trim('"');

            switch (type)
            {
                case "bool":
                    return new BooleanQuestion(id, label);
                case "int":
                    return new NumericQuestion(id, label);
                case "string":
                    return new TextQuestion(id, label);
                default:
                    throw new NotSupportedException("Unsupported type for question statement.");
            }
        }
    }
}
