using System;
using System.IO;
using QL.AST;

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

                ast.RegisterGenericDataHandlers();
                ast.RunInit();
                ast.RunASTBuilders();
                ast.RunTypeCheckers();
                ast.RunEvaluators();

                foreach (Exception e in ast.UnhandledExceptions){
                    Console.WriteLine(e.ToString());
                }

                Console.Write("Hit <return> to restart");
                Console.ReadLine();
                Console.Clear();
            }
        }
    }
}