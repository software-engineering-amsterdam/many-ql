using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;


namespace SimpleCalculatorProject
{
    class Program
    {

        static void Main(string[] args)
        {
            Stream inputStream = Console.OpenStandardInput();
            AntlrInputStream input = new AntlrInputStream(inputStream);
            CalculatorLexer lexer = new CalculatorLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokens);             
            IParseTree tree = parser.prog();
            Console.WriteLine(tree.ToStringTree());

            Console.WriteLine("done");//to know when it's done
            Console.ReadLine();//to see the result

        }

    }


    partial class CalculatorVisitor : CalculatorBaseVisitor<int>
    {

    }

}

