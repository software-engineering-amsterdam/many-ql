using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;

namespace SimpleCalculatorProject
{
    class Program
    {

        static void Main(string[] args)
        {
            while (true)
            {
                Stream inputStream = Console.OpenStandardInput();
                AntlrInputStream input = new AntlrInputStream(inputStream);
                CalculatorLexer lexer = new CalculatorLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CalculatorParser parser = new CalculatorParser(tokens);
                parser.prog();
                Console.WriteLine("done");
                Console.ReadLine();


            }
        }

    }

}

