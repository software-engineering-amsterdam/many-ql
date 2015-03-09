using QL.Errors;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
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
        
        public readonly IDictionary<ITypeResolvable, IResolvableTerminalType> ReferenceLookupTable; // a lookup of references to terminals
        public readonly IDictionary<Identifier, ITypeResolvable> IdentifierLookupTable; // a lookup of identifiers to resolvable types

        public IDictionary<ITypeResolvable, IResolvableTerminalType> GetValuesIfNoErrors()
        {
            return Errors.Any() ? null : ReferenceLookupTable;
        }

        public EvaluatorVisitor(IList<QLError> errors, IList<QLWarning> warnings)
        {
            Errors = errors;
            Warnings = warnings;
            ReferenceLookupTable = new Dictionary<ITypeResolvable, IResolvableTerminalType>();
            IdentifierLookupTable = new Dictionary<Identifier, ITypeResolvable>();
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
            if (!IdentifierLookupTable.ContainsKey(node))
            {
                throw new QLError("Undeclared variable");
            }
            if (!ReferenceLookupTable.ContainsKey(IdentifierLookupTable[node]))
            {
                throw new QLError("Variable not assigned");//this is bullshit, cannot happen?
            }
            return ReferenceLookupTable[IdentifierLookupTable[node]];
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
            ReferenceLookupTable[node.Expression] = GetValue(node.Expression);
        }

        public void Visit(StatementUnit node)
        {
            IdentifierLookupTable[node.Identifier] = node.Expression;//NOT node.DataType, that is used only for type checking(arbitrary decision)
            ReferenceLookupTable[node.Expression] = GetValue(node.Expression);

        }

        public void Visit(QuestionUnit node)
        {
            IdentifierLookupTable[node.Identifier] = node.DataType;
            ReferenceLookupTable[node.DataType] = GetValue(node.DataType);
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
