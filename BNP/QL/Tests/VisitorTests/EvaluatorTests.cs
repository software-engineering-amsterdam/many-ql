using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.AST;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.Exceptions.Errors;

namespace Tests.VisitorTests
{
    [TestClass]
    public class EvaluatorTests
    {
        protected QLBuilder Builder;

        public void Initialize(string input){
        
            Builder = new QLBuilder(input);
            Builder.RegisterGenericDataHandlers();
            Assert.IsTrue(Builder.RunInit());
            Assert.IsTrue(Builder.RunASTBuilders());
            Assert.IsTrue(Builder.RunTypeCheckers());

        }

        

        [TestMethod]
        public void EvaluationBase()
        {
            Initialize(@"form ExampleBlock {
                }
            "); 
            
            Assert.IsTrue(Builder.RunEvaluators());

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
            Assert.IsTrue(Builder.RunEvaluators());
            TextWrapper tw = new TextWrapper("abc");
            TextWrapper tw_from_code = Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1") as TextWrapper;
            Assert.IsTrue((tw_from_code == tw).Value.Value);

            Assert.IsTrue(new YesnoWrapper(true).Value==((YesnoWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S2")).Value);

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
            Assert.IsTrue(Builder.RunEvaluators());           

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
            Assert.IsTrue(Builder.RunEvaluators());
            Identifier i = new Identifier("Q1");

            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValue(i);
            nw.Value = 2;
            Assert.IsTrue(Builder.RunEvaluators());
            
            Identifier S1 = new Identifier("S1");
            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValue(S1);
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
            Assert.IsTrue(Builder.RunEvaluators());
            Identifier i = new Identifier("Q1");

            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValue(i);

            nw.Value = 2; // answer to the question
            Assert.IsTrue(Builder.RunEvaluators(),"reevaluation");

            Identifier S1 = new Identifier("S1");
            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValue(S1);

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
            Assert.IsTrue(Builder.RunEvaluators(),"First evaluation");
            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNull(S1_value, "S1 should not exist");
            NumberWrapper S2_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S2");
            Assert.IsNull(S2_value, "S2 should not exist");

            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("Q1");
            nw.Value = 2; // answer to the question so the if condition is true

            Assert.IsTrue(Builder.RunEvaluators(), "Second evaluation");
            S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNotNull(S1_value,"S1 variable was not evaluated correctly");
            S2_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S2");
            Assert.IsNull(S2_value, "S2 variable is evaluated, shouldnt be");
            Assert.AreEqual(2 * 2 + 123, S1_value.Value,"Bad maths");

            nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("Q1");
            nw.Value = 31; // answer to the question so the if condition is false

            Assert.IsTrue(Builder.RunEvaluators(), "Third evaluation");
            S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNull(S1_value,"S1 shouldnt exist anymore");
            S2_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S2");
            Assert.IsNotNull(S2_value, "S2 should appear");
        }
        [TestMethod]
        public void Maths()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";
                statement S1 (number, (1+(2-(3-(4*Q1))))) ""bla"";
                
                }
            ");
            Assert.IsTrue(Builder.RunEvaluators(), "evaluation");
            
            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("Q1");
            Assert.IsNotNull(nw);
            nw.Value = 42; // answer to the question
            Assert.IsTrue(Builder.RunEvaluators(), "reevaluation");
            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNotNull(S1_value);
            Assert.AreEqual((1 + (2 - (3 - (4 * 42)))), S1_value.Value);
            nw.Value = -6; // answer to the question
            Assert.IsTrue(Builder.RunEvaluators(), "reevaluation");
            S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNotNull(S1_value);
            Assert.AreEqual((1 + (2 - (3 - (4 * (-6))))), S1_value.Value);
        }
        [TestMethod]
        public void EvaluationDivisionByZeroReassignment()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";
                statement S1 (number, (123+(123/Q1))) ""you wrote 2"";
                
                }
            ");
            Assert.IsTrue(Builder.RunEvaluators());
            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("Q1");

            nw.Value = 0; // new answer to the question, division by zero
            Assert.IsFalse(Builder.RunEvaluators(), "division by zero");

            Assert.IsInstanceOfType(Builder.DataContext.ASTHandlerExceptions[0], typeof(DivisionByZeroError), "incorrect exception");
            nw.Value = 1; // new answer to the question
            Assert.IsTrue(Builder.RunEvaluators(), "reevaluation failed");

            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNotNull(S1_value);
            Assert.AreEqual(123 + (123 / 1), S1_value.Value);
        }
        public void EvaluationOfUnavailableBlock()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""Give me a number"";

                if (Q1==2){
                   statement S1 (number, (123+(123/Q1))) ""you wrote 2"";
                    };
                }
            ");
            Assert.IsTrue(Builder.RunEvaluators());
            NumberWrapper nw = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("Q1");
            nw.Value = 1; // new answer to the question
            Assert.IsTrue(Builder.RunEvaluators(), "reevaluation failed");

            NumberWrapper S1_value = (NumberWrapper)Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            Assert.IsNotNull(S1_value);
            nw.Value = 0; // new answer to the question, statement should not be evaluated
            Assert.IsTrue(Builder.RunEvaluators(), "division by zero exception should not be thrown");
            bool correctException=false;            
            try
            {
                Builder.DataContext.ValueReferenceTable.GetValueOrNull("S1");
            }
            catch (EvaluationError)
            {
                correctException=true;
            }
            Assert.IsTrue(correctException, "exception not caught, identifier should be removed");
        }     
        [TestMethod]
        public void EvaluationSelfReference()
        {
            Initialize(@"form ExampleBlock {
                   statement S1 (number, S1) ""blah"";
                  
                }
            ");
            Assert.IsFalse(Builder.RunEvaluators());
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
        public void ReferenceFromAnotherBranch2()
        {
            Initialize(@"form ExampleBlock {
                question Q1 (number) ""blah"";

                if (4==2){
                   statement S1 (number, Q1) ""bbbb"";
                    }
	            else {
                        statement S2 (number, S1) ""bbbb"";                    
                     };
                
                }
            ");
            Assert.IsFalse(Builder.RunEvaluators(),"Undeclared variable error should be thrown");
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

            Assert.IsFalse(Builder.RunEvaluators());
        }
        
       
    }
}
