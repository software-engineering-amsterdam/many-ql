using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Model;
using QL;
using QL.Grammars;
using QL.Visitors;
using QL.Model.Terminals;
namespace Tests.VisitorTests
{
    [TestClass]
    public class EvaluatorTests
    {
        protected ASTHandler Handler;

        public void Initialize(string input){
            Handler= new ASTHandler(input);
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
            TextWrapper tw = new TextWrapper("\"abc\"");
            TextWrapper tw_from_code = Handler.ReferenceLookupTable[(ITypeResolvable)Handler.RootNode.Children[0].Children[0].Children[0]] as TextWrapper;
            Assert.IsTrue((tw_from_code == tw).Value.Value);
            //evaluation should be done on the nodes(think about evaluation of only some part, not the whole tree)
            //by visitor could be done as well

            Assert.IsTrue((Handler.ReferenceLookupTable[(ITypeResolvable)Handler.RootNode.Children[0].Children[1].Children[0]] as YesnoWrapper == new YesnoWrapper(true)).Value.Value);

        }
        [TestMethod]
        public void EvaluationEqualityExpressionEvaluationPass()
        {
            Initialize(@"form ExampleBlock {
                
                if (13==13){}
	            else {
                     if (yes==no)
                        {}
                     else {};
                     };
                if (""bla""!=""bleble""){};
                }
            ");
            Assert.IsTrue(Handler.CheckType());
            Assert.IsTrue(Handler.Evaluate());           

        }
        [TestMethod]
        public void EvaluationAssignmentOfVariable()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, Q1) ""you wrote 2"";
                    }
	            else {
                        statement S2 (number, Q1) ""you didnt write 2"";                    
                     };
                
                }
            ");
            Assert.IsTrue(Handler.CheckType());
            Assert.IsTrue(Handler.Evaluate());
            Identifier i = new Identifier("Q1");
            Assert.IsTrue(Handler.IdentifierTable.ContainsKey(i));
            Assert.IsTrue(Handler.ReferenceLookupTable.ContainsKey(Handler.IdentifierTable[i]));
            NumberWrapper nw = Handler.ReferenceLookupTable[Handler.IdentifierTable[i]] as NumberWrapper;
            Assert.IsNotNull(nw);
            nw.Value = 2;
            Assert.IsTrue(Handler.Evaluate());



        }
        [TestMethod]
        public void EvaluatedValueComparisson()
        {
            YesnoWrapper yes = new YesnoWrapper(true);
            YesnoWrapper no = new YesnoWrapper(false);
            NumberWrapper a = new NumberWrapper(12345);
            NumberWrapper b = new NumberWrapper(12345);

            Assert.IsTrue((a == b).ToBool());
            Number n = new Number();
            n.Value = 12345;
            NumberWrapper c = new NumberWrapper(n);
            Assert.IsTrue((c == a).ToBool());
            Assert.IsFalse((c != a).ToBool());

            b.Value = 23456;
            Assert.IsFalse((c == b).ToBool());
            Assert.IsTrue((c != b).ToBool());

        }

        [TestMethod]
        public void PlusOperatorTest()
        {
            //we expect that yesno should throw and exception but number and text should add, resp. concat.
           
            NumberWrapper na = new NumberWrapper(12345);
            NumberWrapper nb = new NumberWrapper(12345);
            
            TextWrapper ta = new TextWrapper("bla");
            TextWrapper tb = new TextWrapper("ble");


            Assert.AreEqual((na + nb).Value, 24690);
            Assert.AreEqual((ta + tb).Value, "blable");
            
           
        }



        //todo create real unit tests like new TextWrapper("def") != new TextWrapper("abc")
       
    }
}
