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
    /// Represents a visitor for the <c>stat</c> parser rule.
    /// </summary>
    internal class StatementVisitor : QLBaseVisitor<Statement>
    {
        public override Statement VisitIfStatement(QLParser.IfStatementContext context)
        {
            Expression condition = context.expr().Accept(new ExpressionVisitor());

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

            // Remove the leading and trailing '"' characters from the string literal.
            label = label.Trim('"');

            if (context.expr() != null)
            {
                Expression expression = context.expr().Accept(new ExpressionVisitor());
                return new Question(type, id, label, expression, context.GetTextPosition());
            }
            else
            {
                return new Question(type, id, label, context.GetTextPosition());
            }
        }

        public override Statement VisitDefinition(QLParser.DefinitionContext context)
        {
            DataType dataType = StringEnum.GetEnumerationValue<DataType>(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            Expression expression = context.expr().Accept(new ExpressionVisitor());

            return new Definition(dataType, id, expression, context.GetTextPosition());
        }
    }
}
