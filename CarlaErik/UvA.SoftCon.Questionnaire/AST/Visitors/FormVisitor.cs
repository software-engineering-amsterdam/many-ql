using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Visitors;
using UvA.SoftCon.Questionnaire.AST.Extensions;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
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
