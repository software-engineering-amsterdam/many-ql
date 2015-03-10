using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Test
{
    public class ParserErrorListener : BaseErrorListener
    {
        public override void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            List<string> stack = ((Parser)recognizer).GetRuleInvocationStack().ToList();
            stack.Reverse();

            Console.WriteLine("rule stack: " + stack);
            Console.WriteLine("line " + line + 
                              ":"     + charPositionInLine + 
                              " at "  + offendingSymbol + 
                              ":"     + msg);
            
        }
    }
}
