using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Grammar;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Visitors
{
    /// <summary>
    /// Represents the top level visitor for constructing the Abstract Syntax Tree.
    /// </summary>
    internal class FormVisitor : QLBaseVisitor<QuestionForm>
    {
        public override QuestionForm VisitForm(QLParser.FormContext context)
        {
            var statements = new List<IStatement>();

            foreach (var child in context.stat())
            {
                statements.Add(child.Accept(new StatementVisitor()));
            }

            return new QuestionForm(statements, context.GetTextPosition());
        }
    }
}
