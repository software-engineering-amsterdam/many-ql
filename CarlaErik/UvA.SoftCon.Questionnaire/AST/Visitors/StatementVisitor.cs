using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
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
            IExpression condition = context.expr().Accept(new ExpressionVisitor());

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

            return new Question(type, id, label);
        }
    }
}
