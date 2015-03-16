using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Model;
using QL;
using QL.Grammars;
using QL.Visitors;
using QL.Model.Terminals;
using QL.Exceptions.Errors;
namespace Tests.VisitorTests
{
    [TestClass]
    public class EvaluatorTests
    {
        protected ASTHandler Handler;

        public void Initialize(string input){
            Handler= new ASTHandler(input);
            Assert.IsTrue(Handler.BuildAST(), "Parsing/lexing error");

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
            
            Identifier S1 = new Identifier("S1");
            Assert.IsTrue(Handler.IdentifierTable.ContainsKey(S1));
            Assert.IsTrue(Handler.ReferenceLookupTable.ContainsKey(Handler.IdentifierTable[S1]));
            NumberWrapper S1_value = Handler.ReferenceLookupTable[Handler.IdentifierTable[S1]] as NumberWrapper;
            Assert.IsNotNull(S1_value);
            Assert.AreEqual(nw.Value,S1_value.Value);



        }
        [TestMethod]
        public void EvaluationAssignmentOfVariable2()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, (123+(Q1*2))) ""you wrote 2"";
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
            nw.Value = 2; // answer to the question
            Assert.IsTrue(Handler.Evaluate(),"reevaluation");

            Identifier S1 = new Identifier("S1");
            Assert.IsTrue(Handler.IdentifierTable.ContainsKey(S1));
            Assert.IsTrue(Handler.ReferenceLookupTable.ContainsKey(Handler.IdentifierTable[S1]));
            NumberWrapper S1_value = Handler.ReferenceLookupTable[Handler.IdentifierTable[S1]] as NumberWrapper;
            Assert.IsNotNull(S1_value);
            Assert.AreEqual(nw.Value * 2 + 123, S1_value.Value);
        }
        [TestMethod]
        public void EvaluationReassignmentOfVariable()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, (123+(Q1*2))) ""you wrote 2"";
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
            nw.Value = 2; // answer to the question
            Assert.IsTrue(Handler.Evaluate(), "reevaluation");
            
            nw.Value = 31; // new answer to the question
            Assert.IsTrue(Handler.Evaluate(), "reevaluation");

            Identifier S1 = new Identifier("S1");
            Assert.IsTrue(Handler.IdentifierTable.ContainsKey(S1));
            Assert.IsTrue(Handler.ReferenceLookupTable.ContainsKey(Handler.IdentifierTable[S1]));
            NumberWrapper S1_value = Handler.ReferenceLookupTable[Handler.IdentifierTable[S1]] as NumberWrapper;
            Assert.IsNotNull(S1_value);
            Assert.AreEqual(31 * 2 + 123, S1_value.Value);
        }
        [TestMethod]
        public void EvaluationDivisionByZeroReassignment()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, (123+(123/Q1))) ""you wrote 2"";
                    };
                }
            ");
            Assert.IsTrue(Handler.CheckType());
            Assert.IsTrue(Handler.Evaluate());
            Identifier i = new Identifier("Q1");
            NumberWrapper nw = Handler.ReferenceLookupTable[Handler.IdentifierTable[i]] as NumberWrapper;
            
            nw.Value = 0; // new answer to the question, division by zero
            Assert.IsFalse(Handler.Evaluate(), "division by zero");

            Assert.IsInstanceOfType(Handler.ASTHandlerExceptions[0], typeof(DivisionByZeroError),"incorrect exception");
            nw.Value = 1; // new answer to the question
            Assert.IsFalse(Handler.Evaluate(), "reevaluation");

            Identifier S1 = new Identifier("S1");
            Assert.IsTrue(Handler.IdentifierTable.ContainsKey(S1));
            Assert.IsTrue(Handler.ReferenceLookupTable.ContainsKey(Handler.IdentifierTable[S1]));
            NumberWrapper S1_value = Handler.ReferenceLookupTable[Handler.IdentifierTable[S1]] as NumberWrapper;
            Assert.IsNotNull(S1_value);
            Assert.AreEqual(123+(123/1), S1_value.Value);
        }     
        [TestMethod]
        public void EvaluationSelfReference()
        {
            Initialize(@"form ExampleBlock {
                   statement S1 (number, S1) ""blah"";
                  
                }
            ");
            Assert.IsTrue(Handler.CheckType());
            Assert.IsFalse(Handler.Evaluate());
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


            Assert.AreEqual(24690, (na + nb).Value);
            Assert.AreEqual("blable", (ta + tb).Value);
            
           
        }
        public void DivisionByZeroTest()
        {
            //we expect that yesno should throw and exception but number and text should add, resp. concat.

            NumberWrapper na = new NumberWrapper(12345);
            NumberWrapper nb = new NumberWrapper(0);
            bool exceptionRaised = false;
            try{
                var c = na/nb;
            }
            catch (Exception e){
                Assert.IsInstanceOfType(e, typeof(DivisionByZeroError));
                exceptionRaised = true;  
            }
            Assert.IsTrue(exceptionRaised,"No exception has  been raised");


        }
        [TestMethod]
        public void ReferenceFromAnotherBranch1()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""blah"";

                if (4!=2){
                   statement S1 (number, S2) ""this is not ok"";
                    }
	            else {
                        statement S2 (number, Q1) """";                    
                     };
                
                }
            ");
            Assert.IsFalse(Handler.CheckType() && Handler.Evaluate());

        }
        [TestMethod]
        public void ReferenceFromAnotherBranch2()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""blah"";

                if (4!=2){
                   statement S1 (number, Q1) ""bbbb"";
                    }
	            else {
                        statement S2 (number, S1) ""bbbb"";                    
                     };
                
                }
            ");
            Handler.CheckType();
            Assert.IsFalse(Handler.Evaluate());
        }
        [TestMethod]
        public void EvaluatorReferenceFromUnavaliableBranch()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""blah"";

                if (no){
                   statement S1 (number,1) ""obviously unavailable"";
                    };
                statement S2 (number, S1) ""bbbb"";                    

                }
            ");
            Handler.CheckType();

            Assert.IsFalse(Handler.Evaluate());
        }
        [TestMethod]
        public void EvaluationMemoryBuildup()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, (123+(Q1*2))) ""you wrote 2"";
                    }
	            else {
                        statement S2 (number, Q1) ""you didnt write 2"";                    
                     };
                
                }
            ");
            Handler.CheckType();
            Assert.IsTrue(Handler.Evaluate());
            int c1 = Handler.IdentifierTable.Count;
            int c2 = Handler.ReferenceLookupTable.Count;

            for (int i = 0; i < 1000; i++)
            {
                Handler.Evaluate();
            }


            Assert.AreEqual(c1, Handler.IdentifierTable.Count);

            Assert.AreEqual(c2, Handler.ReferenceLookupTable.Count);

        }
        //todo create real unit tests like new TextWrapper("def") != new TextWrapper("abc")
       
    }
}
