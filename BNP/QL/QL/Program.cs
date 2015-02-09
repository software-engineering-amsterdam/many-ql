using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;


namespace QL
{
    class Program
    {
        static void Main(string[] args){

            Stream inputStream = Console.OpenStandardInput();
            AntlrInputStream input = new AntlrInputStream(inputStream);
            QLLexer lexer = new QLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            


            Console.ReadLine();
        }
    }
}