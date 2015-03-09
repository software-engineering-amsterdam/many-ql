using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Model;
using QL;
using QL.Grammars;
namespace Tests.VisitorTests
{
    [TestClass]
    public class EvaluatorTests
    {
        protected AstHandler Handler;

        public void Initialize(string input){
            Handler= new AstHandler(input);
            Assert.IsTrue(Handler.BuildAST());

        }

        

        [TestMethod]
        public void EvaluationBase()
        {
            Initialize(@"form ExampleBlock {
                }
            "); 
            
            Assert.IsTrue(Handler.CheckType());
            Assert.IsTrue(Handler.Evaluate());

        }

        [TestMethod]
        public void EvaluationBasicTest()
        {
            Initialize(@"form ExampleBlock {
                statement S1 (text, ""abc"") ""You've failed to answer:"";


                statement S2 (yesno, yes) ""You've failed to answer:"";

                if (yes){}
	            else {
                     if (S2)
                        {}
                     else {};
                     };
                }
            ");
            Assert.IsTrue(Handler.CheckType());
            Assert.IsTrue(Handler.Evaluate());
            Assert.AreEqual(Handler.ReferenceLookupTable[(ITypeResolvable)Handler.RootNode.Children[0].Children[0].Children[0]].ToString(), "\"abc\"");
            //evaluation should be done on the nodes(think about evaluation of only some part, not the whole tree)
            //by visitor could be done as well
            Assert.AreEqual(Handler.ReferenceLookupTable[(ITypeResolvable)Handler.RootNode.Children[0].Children[1].Children[0]].ToString(), "yes");

        }

       
    }
}
