using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Grammar;

namespace UvA.SoftCon.Questionnaire.QL.AST.Building
{
    /// <summary>
    /// Builds the AST statement nodes by visiting the <c>stat</c> parser rules.
    /// </summary>
    internal class StatementBuilder : QLBaseVisitor<Statement>
    {
        public override Statement VisitIfStatement(QLParser.IfStatementContext context)
        {
            Expression condition = context.expr().Accept(new ExpressionBuilder());

            var thenStatements = new List<Statement>();
            var elseStatements = new List<Statement>();
           
            foreach (var statement in context._then) 
            {
                thenStatements.Add(statement.Accept(this));
            }
            foreach (var statement in context._else)
            {
                elseStatements.Add(statement.Accept(this));
            }

            return new IfStatement(condition, thenStatements, elseStatements, context.GetTextPosition());
        }

        public override Statement VisitQuestion(QLParser.QuestionContext context)
        {
            DataType type = StringEnum.GetEnumerationValue<DataType>(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            string label = context.STRING().GetText();
            Expression expression = null;

            // Remove the leading and trailing '"' characters from the string literal.
            label = label.Trim('"');

            if (context.expr() != null)
            {
                expression = context.expr().Accept(new ExpressionBuilder());
            }

            switch (type)
            {
                case DataType.Boolean:
                    return new BooleanQuestion(id, label, expression, context.GetTextPosition());
                case DataType.Date:
                    return new DateQuestion(id, label, expression, context.GetTextPosition());
                case DataType.Integer:
                    return new IntegerQuestion(id, label, expression, context.GetTextPosition());
                case DataType.String:
                    return new StringQuestion(id, label, expression, context.GetTextPosition());
                default:
                    string message = String.Format("Data type '{0}' is not supported for questions.");
                    throw new NotSupportedException(message);
            }
        }
    }
}
