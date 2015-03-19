using Antlr4.Runtime;
using QL.Exceptions.Errors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.GenericDataHandlers
{
    class Initializer :IExecutable
    {
        public Initializer() { }
        public bool execute(DataContext context)
        {


            if  (context.Input != null)
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
