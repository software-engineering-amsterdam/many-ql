using Antlr4.Runtime;
using QL.Exceptions.Errors;

namespace QL.Hollywood.DataHandlers.InputHandling
{
    class Initializer : IExecutable
    {
        public Initializer() { }
        public bool execute(DataContext context)
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
            return true;

        }
    }
}
