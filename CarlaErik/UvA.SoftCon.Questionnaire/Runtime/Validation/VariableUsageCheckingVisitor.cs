using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Checks if variables or questions are defined, not redeclared and used.
    /// </summary>
    public class VariableUsageCheckingVisitor : ASTVisitor
    {
        public class IdentifierUsageCount
        {
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

            public IdentifierUsageCount(Identifier id, int count)
            {
                Identifier = id;
                UsageCount = count;
            }

            public void Increase() {
                UsageCount++;
            }
        }

        public IDictionary<string, IdentifierUsageCount> DeclaredVariables
        {
            get;
            set;
        }

        public IList<Identifier> UndeclaredVariables
        {
            get;
            private set;
        }

        public IList<Identifier> RedeclaredVariables
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
                DeclaredVariables.Add(question.Id.Name, new IdentifierUsageCount(question.Id, 0));
            }
            else
            {
                RedeclaredVariables.Add(question.Id);
            }
        }

        public override void Visit(Declaration declaration)
        {
            if (declaration.Initialization != null)
            {
                declaration.Initialization.Accept(this);
            }

            if (!DeclaredVariables.Keys.Contains(declaration.Id.Name))
            {
                DeclaredVariables.Add(declaration.Id.Name, new IdentifierUsageCount(declaration.Id, 0));
            }
            else
            {
                RedeclaredVariables.Add(declaration.Id);
            }
        }

        public override void Visit(Assignment assignment)
        {
            if (!DeclaredVariables.ContainsKey(assignment.Variable.Name))
            {
                UndeclaredVariables.Add(assignment.Variable);
            }

            assignment.Expression.Accept(this);
        }

        public override void Visit(Identifier identifier)
        {
            if (DeclaredVariables.Keys.Contains(identifier.Name))
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
