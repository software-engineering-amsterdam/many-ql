using System.Linq;
using Antlr4.Runtime;
using QL.AST;
using QL.Exceptions.Errors;

namespace QL.DataHandlers.InputHandling
{
    public class Initializer : IExecutable
    {
        public Initializer()
        { }

        public bool Execute(DataContext context)
        {
            if (context.Input != null)
            {
                context.AntlrInput = new AntlrInputStream(context.Input);
            }
            else if (context.InputStream != null)
            {
                context.AntlrInput = new AntlrInputStream(context.InputStream);
            }
            else
            {
                context.ASTHandlerExceptions.Add(new QLError("No proper input provided for building an AST"));
                return false;
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
