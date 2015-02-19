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

            return new IfStatement(condition, thenStatements, elseStatements);
        }

        public override IStatement VisitQuestion(QLParser.QuestionContext context)
        {
            DataType type = TypeStringToEnum(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText());
            string label = context.STRING().GetText();

            // Remove the leading and trailing '"' characters from the string literal.
            label = label.Trim('"');

            return new Question(type, id, label);
        }

        public override IStatement VisitDeclaration(QLParser.DeclarationContext context)
        {
            DataType dataType = TypeStringToEnum(context.TYPE().GetText());
            Identifier id = new Identifier(context.ID().GetText());
            IExpression initialization = context.expr().Accept(new ExpressionVisitor());

            return new Declaration(dataType, id, initialization);
        }

        public override IStatement VisitAssignment(QLParser.AssignmentContext context)
        {
            Identifier variable = new Identifier(context.ID().GetText());
            IExpression expression = context.expr().Accept(new ExpressionVisitor());

            return new Assignment(variable, expression);
        }

        private static DataType TypeStringToEnum(string value)
        {
            switch (value)
            {
                case "bool":
                    return DataType.Boolean;
                case "double":
                    return DataType.Double;
                case "int":
                    return DataType.Integer;
                case "string":
                    return DataType.String;
                default:
                    throw new ArgumentException("Parameter value does not contain a valid data type. Value: " + value);
            }
        }
    }
}
