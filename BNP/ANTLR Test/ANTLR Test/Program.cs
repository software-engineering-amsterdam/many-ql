using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using ANTLR_Test.Grammars;

namespace ANTLR_Test
{
    class Program
    {
        static void Main(string[] args)
        {
            Stream inputStream = Console.OpenStandardInput();
            AntlrInputStream input = new AntlrInputStream(inputStream);
            CalculatorLexer lexer = new CalculatorLexer(input);
            lexer.AddErrorHandlers();
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokens);
            parser.addSubExpr();

            Console.ReadLine();
        }
    }
}
