using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;
using QL;
using QL.Evaluation;

namespace Tests.VisitorTests
{
    [TestClass]
    public class BasicVisitorTests : QLTestBase
    {
        [TestMethod]
        public void TestMethod1()
        {
            string input = @"form MyForm {
                                question Q1 (yesno) ""I am not sure what to answer!"";
                                if(Q1 == yes) {
                                    statement S2 (text, Q1) ""You've answered:"";
                                } else if(Q1 == no) {
                                    statement S3 (text, Q1) ""You've not answered:"";
                                }; else {
                                    statement S4 (text, Q1) ""You've failed to answer:"";
                                };
                             }";

            Build(input);


            var formBlock = Parser.formBlock();

            IList<UnitBase> parsedUnits = new List<UnitBase>();
            
            QLVisitor visitor = new QLVisitor(Parser, parsedUnits);

            var x = visitor.VisitFormBlock(formBlock);
            x.ToString();
        }
        [TestMethod]
        public void EvaluationBasicTest()
        {
            string input = @"form ExampleBlock {
                if (3==-11){}
	            else {
                     if (3==12)
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            QLListener Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists());
            AstHandler ast = Listener.GetAst();
            EvaluatorVisitor ev = new EvaluatorVisitor();
            ev.Enter(ast.RootNode);
        }
    }
}
