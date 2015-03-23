using System.Linq;
using QL.Exceptions.Errors;

namespace QL.Hollywood.DataHandlers.Evaluation
{
    public class Evaluator : IExecutable
    {
        public Evaluator()
        { }

        public bool Execute(DataContext context)
        {
            context.ASTHandlerExceptions.Clear();
            context.ValueReference.ClearIdentifiers();

            EvaluatorVisitor evaluator = new EvaluatorVisitor(context.ASTHandlerExceptions, context.ValueReference);
            try
            {
                context.RootNode.Accept(evaluator);
            }
            catch (QLError ex)
            {   // Exceptions preventing Evaluator from finishing
                context.ASTHandlerExceptions.Add(ex);
                return false;
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
