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

        public override void Visit(Question node)
        {
            if (!DeclaredVariables.Keys.Contains(node.Id.Name))
            {
                DeclaredVariables.Add(node.Id.Name, new IdentifierUsageCount(node.Id, 0));
            }
            else
            {
                RedeclaredVariables.Add(node.Id);
            }
        }

        public override void Visit(Declaration node)
        {
            if (!DeclaredVariables.Keys.Contains(node.Id.Name))
            {
                DeclaredVariables.Add(node.Id.Name, new IdentifierUsageCount(node.Id, 0));
            }
            else
            {
                RedeclaredVariables.Add(node.Id);
            }

            if (node.Initialization != null)
            {
                node.Initialization.Accept(this);
            }
        }

        public override void Visit(Identifier node)
        {
            if (DeclaredVariables.Keys.Contains(node.Name))
            {
                DeclaredVariables[node.Name].Increase();
            }
            else
            {
                UndeclaredVariables.Add(node);
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
