using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        public IList<QLException> Exceptions { get; private set; }
        public Dictionary<int, IVisitable> References; //change  ivisitable to ievaluatable
        public Dictionary<string, IVisitable> DeclaredVariables;

        public EvaluatorVisitor()
        {
            Exceptions = new List<QLException>();
            References = new Dictionary<int, IVisitable>();
            DeclaredVariables = new Dictionary<string, IVisitable>();
        }

        private void DeclareNewVariable(string key, IVisitable node)
        {
            if (DeclaredVariables.ContainsKey(key))
            {
                //just put it somewhere into list of warnings
                Exceptions.Add(new RedeclaredVariableWarning("Redeclared variable: " + key));
            }

            DeclaredVariables[key] = node;
        }

        #region Regular elements
        public void Visit(Form node)
        {
        }

        public void Visit(Block node)
        {
        }

        public void Visit(ControlUnit node)
        {
        }

        public void Visit(StatementUnit node)
        {
            DeclareNewVariable(node.Identifier.Value, node);
        }

        public void Visit(QuestionUnit node)
        {
            DeclareNewVariable(node.Identifier.Value, node);
        }

        public void Visit(Expression node)
        {
            References[node.GetHashCode()] = References[node.Children[0].GetHashCode()];
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            //todo bool returnvalue= (References[node.Left.GetHashCode()].Value == References[node.Right.GetHashCode()].Value);
        }

        public void Visit(NotEqualsOperator node)
        {
        }

        public void Visit(GreaterThanOperator node)
        {
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
        }

        public void Visit(LessThanOperator node)
        {
        }

        public void Visit(LessThanEqualToOperator node)
        {
        }

        public void Visit(MultiplicationOperator node)
        {
        }

        public void Visit(DivisionOperator node)
        {
        }

        public void Visit(PlusOperator node)
        {
        }

        public void Visit(MinusOperator node)
        {
        }

        public void Visit(AndOperator node)
        {
        }

        public void Visit(OrOperator node)
        {
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            References[node.GetHashCode()] = node;
        }

        public void Visit(Yesno node)
        {
            References[node.GetHashCode()] = node;
        }

        public void Visit(Text node)
        {
            References[node.GetHashCode()] = node;
        }

        public void Visit(Identifier node)
        {
            if (DeclaredVariables.ContainsKey(node.Value))
            {
                References[node.Value.GetHashCode()] = DeclaredVariables[node.Value];
            }
        }
        #endregion

        public void Visit(ElementBase node)
        {
            throw new QLException("Not implemented: " + node.GetType().ToString());
        }
    }
}
