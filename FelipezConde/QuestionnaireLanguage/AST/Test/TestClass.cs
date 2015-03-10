using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Evaluation;
using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using AST.ParseTreeVisitors;
using AST.Representation;
using Grammar;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Test
{
    public class TestClass
    {
        public TestClass(){}

        public ASTResult GetAST(string path)
        {
            string program = File.ReadAllText(path);

            AntlrInputStream input = new AntlrInputStream(program);
            QLMainLexer lexer = new QLMainLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLMainParser parser = new QLMainParser(tokens);

            //remove standard Error Listener
            parser.RemoveErrorListeners();

            //Detect more errors (like ambiguousness errors)
            //parser.AddErrorListener(new DiagnosticErrorListener());

            //add standard error listener
            parser.AddErrorListener(new ParserErrorListener());

            IParseTree tree = parser.form();

            Console.WriteLine(tree.ToStringTree(parser));
            FormVisitor visitor = new FormVisitor();
            Form ast = visitor.Visit(tree);

            TypeCheck.TypeChecker.GetTypeCheckDiagnosis(ast);

            //Evaluate();

            return new ASTResult(ast);
        }

        public void Evaluate() 
        {
            Evaluator evaluator = new Evaluator();

            Bool boo1 = new Bool(true);
            Bool boo2 = new Bool(true);
            Int int1 = new Int(1);
            Int int2 = new Int(2);

            evaluator.AddValue(new Id("Q1", new PositionInText()), boo1);
            evaluator.AddValue(new Id("Q2", new PositionInText()), boo2);

            evaluator.AddValue(new Id("Q3", new PositionInText()), int1);
            evaluator.AddValue(new Id("Q4", new PositionInText()), int2);


            Value v;
            v = evaluator.Evaluate(new Add(int1, int2, "1 + 2", new PositionInText(0, 1, 2, 3)));
            v = evaluator.Evaluate(new Subtract(int2, int1, "2 - 1", new PositionInText(0, 1, 2, 3)));
            v = evaluator.Evaluate(new And(boo1, boo2, new PositionInText(0, 1, 2, 3)));

	    }
    }
}
