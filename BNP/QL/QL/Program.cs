using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using QL.Grammars;
using QL.Infrastructure;


namespace QL
{
    class Program
    {
        static void Main(string[] args){

            while (true)
            {
                Console.WriteLine("Please enter QL syntax commit by Ctrl+Z. Quit by Ctrl+C");
                Console.WriteLine();

                Stream inputStream = Console.OpenStandardInput();
                AntlrInputStream input = new AntlrInputStream(inputStream);
                QLLexer lexer = new QLLexer(input);
                lexer.AddErrorListener(new LexerErrorHandler());

                CommonTokenStream tokens = new CommonTokenStream(lexer);
                QLParser parser = new QLParser(tokens);
                parser.AddErrorListener(new ParserErrorHandler());

                // parses the input as a unit
                var result = parser.unit();

                Console.Write("Hit <return> to restart");
                Console.ReadLine();
                Console.Clear();
            }
        }
    }
}