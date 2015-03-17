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
    class TypeChecker :IExecutable
    {

        public TypeChecker() { }
        public bool execute(DataContext context)
        {
            
            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(context.TypeReference, context.ASTHandlerExceptions);
            try
            {
                context.RootNode.Accept(typeChecker);
            }
            catch (QLError ex)
            {
                /* Exceptions preventing TypeChecker from finishing */
                context.ASTHandlerExceptions.Add(ex);
                return false;
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
