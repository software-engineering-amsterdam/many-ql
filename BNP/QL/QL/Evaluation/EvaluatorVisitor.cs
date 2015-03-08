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
        IDictionary<Identifier,Type> TypeReference;  //reference for types
        IDictionary<ITypeResolvable,IResolvableTerminalType> Values;   //storage of values         
        IDictionary<Identifier, ITypeResolvable> IdentifierReference;    // storage of ID references

        public IDictionary<ITypeResolvable, IResolvableTerminalType>  GetValuesIfNoErrors()
        {
            if (Errors.Any())
            {
                return null;
            }
            else{
                return Values;
            }
        }

        public EvaluatorVisitor(IDictionary<Identifier, Type> typeReference)//im not sure about this
        
        {
            TypeReference = typeReference;//im not sure about this
            Errors = new List<QLError>();
            Values = new Dictionary<ITypeResolvable, IResolvableTerminalType>();
            IdentifierReference = new Dictionary<Identifier, ITypeResolvable>();

        }

        public EvaluatorVisitor()
        {
            TypeReference = new Dictionary<Identifier,Type>();//im not sure about this
            Errors = new List<QLError>();
            Values = new Dictionary<ITypeResolvable, IResolvableTerminalType>();
            IdentifierReference = new Dictionary<Identifier, ITypeResolvable>();

        }
        IResolvableTerminalType GetValue(IResolvableTerminalType node)
        {

            return node;
            
        }
        IResolvableTerminalType GetValue(Expression node)
        {

            return GetValue((dynamic)node.Children[0]);

        }

        IResolvableTerminalType GetValue(Identifier node)
        {
            if (!IdentifierReference.ContainsKey(node))
            {
                throw new QLError("Undeclared variable");
            }
            if (!Values.ContainsKey(IdentifierReference[node])){
                throw new QLError("Variable not assigned");//this is bullshit, cannot happen?
            }
            return Values[IdentifierReference[node]];            
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
            Values[node.Expression] = GetValue(node.Expression);
        }

        public void Visit(StatementUnit node)
        {
            IdentifierReference[node.Identifier] = node.Expression;//NOT node.DataType, that is used only for type checking(arbitrary decision)
            Values[node.Expression] = GetValue(node.Expression);
        
        }

        public void Visit(QuestionUnit node)
        {
            IdentifierReference[node.Identifier] = node.DataType;
            Values[node.DataType]=GetValue(node.DataType);
        }

        public void Visit(Expression node)
        {
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {

            //Values[node] = Values[(ITypeResolvable)node.Left] == Values[(ITypeResolvable)node.Right];
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
        }

        public void Visit(ElementBase node)
        {
            throw new QLError("Not implemented: " + node.GetType().ToString());
        }
        #endregion

        
    }
}
