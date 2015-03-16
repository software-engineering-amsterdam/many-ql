using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using QL.Visitors.EvaluationWrappers;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Visitors
{
    public class EvaluatorVisitor : IVisitor
    {
        public IList<QLException> Exceptions { get; private set; }
        
        public readonly IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable; // a lookup of references to terminals
        public readonly IDictionary<Identifier, ITypeResolvable> IdentifierLookupTable; // a lookup of identifiers to resolvable types

        public IDictionary<ITypeResolvable, ITerminalWrapper> GetValuesIfNoErrors()
        {
            return Exceptions.Any() ? null : ReferenceLookupTable;
        }

        public EvaluatorVisitor(ObservableCollection<QLException> exceptions)
        {
            Exceptions = exceptions;
            ReferenceLookupTable = new Dictionary<ITypeResolvable, ITerminalWrapper>();
            IdentifierLookupTable = new Dictionary<Identifier, ITypeResolvable>();
        }

        public EvaluatorVisitor(ObservableCollection<QLException> exceptions, IDictionary<ITypeResolvable, ITerminalWrapper> referenceTable, IDictionary<Identifier, ITypeResolvable> identifierTable)
        {
            Exceptions = exceptions;
            ReferenceLookupTable = referenceTable;
            IdentifierLookupTable = identifierTable;

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
            IdentifierLookupTable[node.Identifier] = node.Expression;

        }

        public void Visit(QuestionUnit node)
        {
            IdentifierLookupTable[node.Identifier] = node.DataType;
            if (!ReferenceLookupTable.ContainsKey(node.DataType)) { 
                ReferenceLookupTable[node.DataType]= EvaluationTerminalWrapperFactory.CreateWrapper(node.DataType);
            }
        }

        public void Visit(Expression node)
        {
            //if expression is literal
            Contract.Assert(node.Child != null, "Expression should have one and only one child");
            Identifier i = node.Child as Identifier;
            if (i != null) //TODO refactor
            {

                if (IdentifierLookupTable.ContainsKey(i))
                {
                    if (ReferenceLookupTable.ContainsKey(IdentifierLookupTable[i]))
                    {
                        ReferenceLookupTable[node] = ReferenceLookupTable[IdentifierLookupTable[i]];
                    }
                    else
                    {
                        throw new Exception("reference not initialized, not possible");
                    }
                }
                else
                {
                    throw new QLError("Usage of variable before declaration");
                }
            }
            else if (ReferenceLookupTable.ContainsKey((ITypeResolvable)node.Child))//this should recursively get the final result
            {
                ReferenceLookupTable[node] = ReferenceLookupTable[(ITypeResolvable)node.Child];

            }
            else
            {
                throw new Exception("how is this possible? there should be at least null valued wrapper");
                //ReferenceLookupTable[node] = null;
            }
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];

            ReferenceLookupTable[node] = ((dynamic)leftWrapper) == ((dynamic)rightWrapper);
            
        }

        public void Visit(NotEqualsOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) != ((dynamic)rightWrapper);
        }

        public void Visit(GreaterThanOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
                ReferenceLookupTable[node] = ((dynamic)leftWrapper) > ((dynamic)rightWrapper);
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
                ReferenceLookupTable[node] = ((dynamic)leftWrapper) >= ((dynamic)rightWrapper);
        }

        public void Visit(LessThanOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
                ReferenceLookupTable[node] = ((dynamic)leftWrapper) < ((dynamic)rightWrapper);
        }

        public void Visit(LessThanEqualToOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) <= ((dynamic)rightWrapper);
        }

        public void Visit(MultiplicationOperator node)
        {

            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) * ((dynamic)rightWrapper);
            
        }

        public void Visit(DivisionOperator node)
        {

            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) / ((dynamic)rightWrapper);
        }

        public void Visit(PlusOperator node)
        {

            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) + ((dynamic)rightWrapper);
            
        }

        public void Visit(MinusOperator node)
        {

            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) - ((dynamic)rightWrapper);
        }

        public void Visit(AndOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) & ((dynamic)rightWrapper);
         }

        public void Visit(OrOperator node)
        {
            ITerminalWrapper leftWrapper = ReferenceLookupTable[(ITypeResolvable)node.Left];
            ITerminalWrapper rightWrapper = ReferenceLookupTable[(ITypeResolvable)node.Right];
            ReferenceLookupTable[node] = ((dynamic)leftWrapper) | ((dynamic)rightWrapper);
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
