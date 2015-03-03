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
        object TypeReferenceStorage;


        System.Collections.Generic.Dictionary<ITypeResolvable,IResolvableTerminalType> Values;
            

        Dictionary<Identifier, ITypeResolvable> References;

        void ResolveValue(Expression node) {
            
            Values[node] = ResolveValue((dynamic)node.Children[0]);
            
        }

        ITypeResolvable ResolveValue(Identifier node)
        {
            return References[node];//todo
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
            References[node.Identifier] = node.Expression;
            ResolveValue((dynamic)node.Expression);
        
        }

        public void Visit(QuestionUnit node)
        {
            References[node.Identifier] = node.DataType;
            ResolveValue((dynamic)node.DataType);
        }

        public void Visit(Expression node)
        {
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
        }

        public void Visit(Yesno node)
        {
        }

        public void Visit(Text node)
        {
        }

        public void Visit(Identifier node)
        {
            //Values[node] = Values[References[node]];
        }
        public void Evaluate(Identifier node)
        {
            //Values[node] = Values[References[node]];
        }
        public void Evaluate(Number node)
        {
            if (!Values.ContainsKey(node)){
                Values[node] = node;               
            }
            
        }
        public void Evaluate(Yesno node)
        {
            if (!Values.ContainsKey(node))
            {
                Values[node] = node;
            }
        }
        public void Evaluate(Text node)
        {
            if (!Values.ContainsKey(node))
            {
                Values[node] = node;
            }
        } 
        public void Evaluate(EqualsOperator node){
            //Values[node] = Values[(ITypeResolvable)node.Left] == Values[(ITypeResolvable)node.Right];
        }

        void Evaluate(Expression node)
        {
            //Values[node] = Values[node.Children[0]];
        }
        void Evaluate(PlusOperator node)
        {
            //Values[node] = Values[node.Left] + Values[node.Right];
        }

        #endregion

        public void Visit(ElementBase node)
        {
            throw new QLError("Not implemented: " + node.GetType().ToString());
        }
    }
}
