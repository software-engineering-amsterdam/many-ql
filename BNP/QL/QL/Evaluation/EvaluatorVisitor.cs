using QL.Errors;
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
        public IList<QLError> Errors { get; private set; }
        public IList<QLWarning> Warnings { get; private set; }
        public Dictionary<int, IVisitable> References; //change  ivisitable to ievaluatable
        public Dictionary<string, IVisitable> TypeReferenceDictionary;

        public EvaluatorVisitor()
        {
            Errors = new List<QLError>();
            Warnings = new List<QLWarning>();
            References = new Dictionary<int, IVisitable>();
            TypeReferenceDictionary = new Dictionary<string, IVisitable>();
        }

        private void DeclareNewVariable(string key, IVisitable value)
        {
            if (TypeReferenceDictionary.ContainsKey(key))
            {
                Warnings.Add(new RedeclaredVariableWarning("Redeclared variable: " + key));
            }
            TypeReferenceDictionary[key] = value;
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
            if (TypeReferenceDictionary.ContainsKey(node.Value))
            {
                References[node.Value.GetHashCode()] = TypeReferenceDictionary[node.Value];
            }
        }
        #endregion

        public void Visit(ElementBase node)
        {
            throw new QLError("Not implemented: " + node.GetType().ToString());
        }
    }
}
