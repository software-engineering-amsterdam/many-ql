using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Model;
using QL;
using QL.Grammars;
namespace Tests.VisitorTests
{
    [TestClass]
    public class EvaluatorTests :QLTestBase
    {
        AstHandler GetResultAst(string input)
        {
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();        
            return ast;
        }

        [TestMethod]
        public void EvaluationBase()
        {
            string input = @"form ExampleBlock {
                }
            ";
            
            AstHandler ast = GetResultAst(input);
            Assert.IsFalse(ast.CheckType());
            Assert.IsFalse(ast.Evaluate());

        }

        [TestMethod]
        public void EvaluationBasicTest()
        {
            string input = @"form ExampleBlock {
                statement S1 (text, ""abc"") ""You've failed to answer:"";
                statement S2 (yesno, yes) ""You've failed to answer:"";

                if (yes){}
	            else {
                     if (S2)
                        {}
                     else {};
                     };
                }
            ";
            AstHandler ast = GetResultAst(input);
            Assert.IsFalse(ast.CheckType());
            
            Assert.IsFalse(ast.Evaluate());
            Assert.AreEqual(ast.Values[(ITypeResolvable)ast.RootNode.Children[0].Children[0].Children[0]].ToString(), "\"abc\"");
            Assert.AreEqual(ast.Values[(ITypeResolvable)ast.RootNode.Children[0].Children[1].Children[0]].ToString(), "yes");

            


        }
    }
}
