using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Nodes;
using AST.ParseTreeVisitors;
using Grammar;
using System;
using System.IO;

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

            parser.RemoveErrorListeners();
            parser.AddErrorListener(new ParserErrorListener());

            IParseTree tree = parser.form();

            Console.WriteLine(tree.ToStringTree(parser));
            FormVisitor visitor = new FormVisitor();
            Form ast = visitor.Visit(tree);

            return new ASTResult(ast);
        }

        public void Evaluate() 
        {
            //THIS SHOULD BE USED IN EVALUATE.TEST 
            /*

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
             */

	    }
    }
}
