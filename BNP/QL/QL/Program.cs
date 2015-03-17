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
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Grammars;
using QL.Infrastructure;
using QL.Model;
using QL.Visitors;


namespace QL
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Please enter QL syntax commit by Ctrl+Z. Quit by Ctrl+C");
                Console.WriteLine();

                Stream inputStream = Console.OpenStandardInput();

                QLBuilder ast = new QLBuilder(inputStream);

                ast.registerGenericDataHandlers();
                ast.runInit();
                ast.runAstBuild();
                ast.runTypeCheck();
                ast.runEvaluate();
                foreach (Exception e in ast.Errors){
                    Console.WriteLine(e.ToString());
                }

                Console.Write("Hit <return> to restart");
                Console.ReadLine();
                Console.Clear();
            }
        }
    }
}