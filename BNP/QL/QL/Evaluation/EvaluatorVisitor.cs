using QL.Errors;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        public IList<QLError> Errors { get; private set; }
        public IList<QLWarning> Warnings { get; private set; }
        
        public readonly IDictionary<ITypeResolvable, TerminalWrapper> ReferenceLookupTable; // a lookup of references to terminals
        public readonly IDictionary<Identifier, ITypeResolvable> IdentifierLookupTable; // a lookup of identifiers to resolvable types
        private IList<QLError> EvaluationErrors;
        private IList<QLWarning> EvaluationWarnings;

        public IDictionary<ITypeResolvable, TerminalWrapper> GetValuesIfNoErrors()
        {
            return Errors.Any() ? null : ReferenceLookupTable;
        }

        public EvaluatorVisitor(IList<QLError> errors, IList<QLWarning> warnings)
        {
            Errors = errors;
            Warnings = warnings;
            ReferenceLookupTable = new Dictionary<ITypeResolvable, TerminalWrapper>();
            IdentifierLookupTable = new Dictionary<Identifier, ITypeResolvable>();
        }

        public EvaluatorVisitor(IList<QLError> EvaluationErrors, IList<QLWarning> EvaluationWarnings, IDictionary<ITypeResolvable, TerminalWrapper> referenceTable, IDictionary<Identifier, ITypeResolvable> identifierTable)
        {
            this.Errors = EvaluationErrors;
            this.Warnings = EvaluationWarnings;
            this.ReferenceLookupTable = referenceTable;
            IdentifierLookupTable = identifierTable;

        }

        /*
        TerminalWrapper GetValue(IResolvableTerminalType node)
        {
            throw new Exception("blabla");
            return new TerminalWrapper((dynamic)node);

        }
        TerminalWrapper GetValue(Expression node)
        {

            return GetValue((dynamic)node.Child);

        }

        TerminalWrapper GetValue(Identifier node)
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
        TerminalWrapper GetValue(ElementBase node)
        {
            throw new QLException("Not recognised, base case");

        }
        */

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
            IdentifierLookupTable[node.Identifier] = node.Expression;

        }

        public void Visit(QuestionUnit node)
        {
            IdentifierLookupTable[node.Identifier] = node.DataType;//this should be used for further value assignment
        }

        public void Visit(Expression node)
        {
            //if expression is literal
            Contract.Assert(node.Child != null, "Expression should have one and only one child");
            Identifier i = node.Child as Identifier;
            if (i != null)
            {

                if (IdentifierLookupTable.ContainsKey(i))
                {
                    ReferenceLookupTable[node] = ReferenceLookupTable[IdentifierLookupTable[i]];
                }
                else
                {
                    throw new QLError("Usage of variable before declaration");
                }
            }
            else
            {
                ReferenceLookupTable[node] = ReferenceLookupTable[(ITypeResolvable)node.Child];
            }
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            TerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            TerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];

            ReferenceLookupTable[node] =  ((dynamic)leftWrapper)==((dynamic) rightWrapper);
            
        }

        public void Visit(NotEqualsOperator node)
        {
            TerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            TerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];

            ReferenceLookupTable[node] = ((dynamic)leftWrapper) !=((dynamic) rightWrapper);

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
            ReferenceLookupTable[node] = new NumberWrapper(node);
            
        }

        public void Visit(Yesno node)
        {
            ReferenceLookupTable[node] = new YesnoWrapper(node);


        }

        public void Visit(Text node)
        {
            ReferenceLookupTable[node] = new TextWrapper(node);

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
