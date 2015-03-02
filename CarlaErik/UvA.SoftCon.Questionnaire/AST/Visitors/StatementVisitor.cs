using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Extensions;
using UvA.SoftCon.Questionnaire.Parsing;
using UvA.SoftCon.Questionnaire.Utilities;

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

            var thenStatements = new List<IStatement>();
            var elseStatements = new List<IStatement>();
           
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

        public override IStatement VisitQuestion(QLParser.QuestionContext context)
        {
            DataType type = StringEnum.GetEnumerationValue<DataType>(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            string label = context.STRING().GetText();

            // Remove the leading and trailing '"' characters from the string literal.
            label = label.Trim('"');

            if (context.expr() != null)
            {
                IExpression expression = context.expr().Accept(new ExpressionVisitor());
                return new Question(type, id, label, expression, context.GetTextPosition());
            }
            else
            {
                return new Question(type, id, label, context.GetTextPosition());
            }
        }

        public override IStatement VisitDeclaration(QLParser.DeclarationContext context)
        {
            DataType dataType = StringEnum.GetEnumerationValue<DataType>(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());

            if (context.expr() != null)
            {
                IExpression initialization = context.expr().Accept(new ExpressionVisitor());
                return new Declaration(dataType, id, initialization, context.GetTextPosition());
            }
            else
            {
                return new Declaration(dataType, id, context.GetTextPosition());
            }
        }

        public override IStatement VisitAssignment(QLParser.AssignmentContext context)
        {
            Identifier variable = new Identifier(context.ID().GetText(), context.GetTextPosition());
            IExpression expression = context.expr().Accept(new ExpressionVisitor());

            return new Assignment(variable, expression, context.GetTextPosition());
        }
    }
}
