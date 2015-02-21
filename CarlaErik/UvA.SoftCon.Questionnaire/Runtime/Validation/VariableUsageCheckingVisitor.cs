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
    }
}
