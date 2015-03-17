using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.GenericDataHandlers
{
    class Evaluator :IExecutable
    {

        public Evaluator() { }
        public bool execute(DataContext context)
        {

            context.ASTHandlerExceptions.Clear(); //we need to have clear exception list due to possible reevaluation
            EvaluatorVisitor evaluator = new EvaluatorVisitor(context.ASTHandlerExceptions, context.ReferenceLookupTable, context.IdentifierTable);
            try
            {
                context.RootNode.AcceptBottomUp(evaluator);
            }
            catch (QLError ex)
            {
                /* Exceptions preventing Evaluator from finishing */
                context.ASTHandlerExceptions.Add(ex);

            }

            context.Evaluated = !context.ASTHandlerExceptions.Any();
            return context.Evaluated;
        }
    }
}
