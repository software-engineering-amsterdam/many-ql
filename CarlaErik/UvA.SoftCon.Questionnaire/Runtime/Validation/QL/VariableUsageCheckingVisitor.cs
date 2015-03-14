using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks if variables or questions are defined, not redeclared and used.
    /// </summary>
    public class VariableUsageCheckingVisitor : QLVisitor
    {
        protected class IdentifierUsageCount
        {
            public bool IsQuestion
            {
                get;
                private set;
            }

            public Identifier Identifier
            {
                get;
                private set;
            }

            public int UsageCount
            {
                get;
                private set;
            }

            public IdentifierUsageCount(Identifier id, bool isQuestion, int count)
            {
                Identifier = id;
                UsageCount = count;
                IsQuestion = isQuestion;
            }

            public void Increase() {
                UsageCount++;
            }
        }

        protected IDictionary<string, IdentifierUsageCount> DeclaredVariables
        {
            get;
            private set;
        }

        public ICollection<Identifier> UnusedVariables
        {
            get
            {
                return DeclaredVariables.Where(dv => dv.Value.UsageCount == 0 && !dv.Value.IsQuestion).Select(dv => dv.Value.Identifier).ToList();
            }
        }

        public ICollection<Identifier> UndeclaredVariables
        {
            get;
            private set;
        }

        public ICollection<Identifier> RedeclaredVariables
        {
            get;
            private set;
        }

        public VariableUsageCheckingVisitor()
        {
            DeclaredVariables = new Dictionary<string, IdentifierUsageCount>();
            UndeclaredVariables = new List<Identifier>();
            RedeclaredVariables = new List<Identifier>();
        }

        public VariableUsageCheckingVisitor(VariableUsageCheckingVisitor parentVisitor)
            : this()
        {
            // Call ToList so we got a new instance
            foreach (var keyValue in parentVisitor.DeclaredVariables)
            {
                DeclaredVariables.Add(keyValue);
            }
        }

        public override void Visit(Question question)
        {
            if (question.Expression != null)
            {
                question.Expression.Accept(this);
            }

            if (!DeclaredVariables.Keys.Contains(question.Id.Name))
            {
                DeclaredVariables.Add(question.Id.Name, new IdentifierUsageCount(question.Id, true, 0));
            }
            else
            {
                RedeclaredVariables.Add(question.Id);
            }
        }

        public override void Visit(Definition definition)
        {
            definition.Expression.Accept(this);

            if (!DeclaredVariables.Keys.Contains(definition.Id.Name))
            {
                DeclaredVariables.Add(definition.Id.Name, new IdentifierUsageCount(definition.Id, false, 0));
            }
            else
            {
                RedeclaredVariables.Add(definition.Id);
            }
        }

        public override void Visit(Identifier identifier)
        {
            if (DeclaredVariables.ContainsKey(identifier.Name))
            {
                DeclaredVariables[identifier.Name].Increase();
            }
            else
            {
                UndeclaredVariables.Add(identifier);
            }
        }

        public override void Visit(IfStatement ifStatement)
        {
            ifStatement.If.Accept(this);

            var thenVisitor = new VariableUsageCheckingVisitor(this);

            foreach (var statement in ifStatement.Then)
            {
                statement.Accept(thenVisitor);
            }

            var elseVisitor = new VariableUsageCheckingVisitor(this);

            foreach (var statement in ifStatement.Else)
            {
                statement.Accept(elseVisitor);
            }

            CopyMessages(thenVisitor);
            CopyMessages(elseVisitor);
        }

        private void CopyMessages(VariableUsageCheckingVisitor visitor)
        {
            foreach (var undeclaredVariable in visitor.UndeclaredVariables)
            {
                UndeclaredVariables.Add(undeclaredVariable);
            }
            foreach (var redeclaredVariable in visitor.RedeclaredVariables)
            {
                RedeclaredVariables.Add(redeclaredVariable);
            }
        }
    }
}
