using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.AST.ASTCreation;

namespace Tests.ASTBuilderTests
{
    [TestClass]
    public class AstBuilderTests : QLTestBase
    {

        [TestMethod]
        public void ControlBlockChildrenAssignment()
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

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.ASTExists);

        }
       
    }
}
