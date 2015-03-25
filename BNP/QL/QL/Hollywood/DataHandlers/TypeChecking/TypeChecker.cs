using System.Linq;
using QL.Exceptions;
using QL.Exceptions.Errors;

namespace QL.Hollywood.DataHandlers.TypeChecking
{
    public class TypeChecker : IExecutable
    {
        public TypeChecker()
        { }

        public bool Execute(DataContext context)
        {
            try
            {
            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(context.TypeReference, context.ASTHandlerExceptions);
            
                context.RootNode.Accept(typeChecker);
            }
            catch (QLBaseException ex)
            {
                /* Exceptions preventing TypeChecker from finishing */
                context.ASTHandlerExceptions.Add(ex);
                return false;
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
