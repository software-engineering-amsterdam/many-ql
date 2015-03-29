using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Grammar;

namespace UvA.SoftCon.Questionnaire.QL.AST.Building
{
    /// <summary>
    /// Builds a questionaire AST by visiting the <c>form</c> parser rule.
    /// </summary>
    internal class QuestionFormBuilder : QLBaseVisitor<QuestionForm>
    {
        public override QuestionForm VisitForm(QLParser.FormContext context)
        {
            var statements = new List<Statement>();

            foreach (var child in context.stat())
            {
                statements.Add(child.Accept(new StatementBuilder()));
            }

            return new QuestionForm(statements, context.GetTextPosition());
        }
    }
}
