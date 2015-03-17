using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;
using QL;

namespace Tests.VisitorTests
{
    [TestClass]
    public class TypeCheckerTests
    {

        protected QLBuilder Builder;

        public void Initialize(string input)
        {
            Builder = new QLBuilder(input);
            Builder.registerGenericDataHandlers();
            Assert.IsTrue(Builder.runInit());
            Assert.IsTrue(Builder.runAstBuild());
        }


        [TestMethod]
        public void TCCollectNothing()
        {
            Initialize(@"form ExampleBlock {
                if (3==-11){}
	            else {
                     if (3==12)
                        {}
                     else {};
                     };
                }
            ");
            Assert.IsTrue(Builder.runTypeCheck());
            Assert.AreEqual(0,Builder.dataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void TCCollectException()
        {
            Initialize(@"form ExampleBlock {
                if (3==-11){}
	            else {
                     if (3==yes)
                        {}
                     else {};
                     };
                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());
            Assert.AreEqual(1, Builder.dataContext.ASTHandlerExceptions.Count);
        }
        [TestMethod]
        public void TCCollectException2()
        {
            Initialize(@"form ExampleBlock {
                if (3==(4==(4>2))){}
	            else {
                     if (3==(4==2))
                        {}
                     else {};
                     };
                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());
            Assert.AreEqual(3, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCCollectNoExceptionCosParentheses()
        {
            Initialize(@"form ExampleBlock {
                if ((3+(4+(5+6)))==9){}
	            else {
                     if (no==(4==2))
                        {}
                     else {};
                     };
                }
            ");

            Assert.IsTrue(Builder.runTypeCheck());
            Assert.AreEqual(0, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCReferencesTest()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing (yesno, (3==4)) ""well"";
                if ((3+(4+(5+6))) ==12){}
	            else {
                     if (Smthing==(4==2))
                        {}
                     else {};
                     };
                }
            ");
            Assert.IsTrue(Builder.runTypeCheck());

            Assert.AreEqual(0, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCMemoryBuildup()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing (yesno, (3==4)) ""well"";
                if ((3+(4+(5+6))) ==12){}
	            else {
                     if (Smthing==(4==2))
                        {}
                     else {};
                     };
                }
            ");
            Builder.runTypeCheck();
            int c = Builder.dataContext.TypeReference.Count;

            for (int i = 0; i < 1000; i++)
            {
                Builder.runTypeCheck();
            }


            Assert.AreEqual(c, Builder.dataContext.TypeReference.Count);

        }

        
        [TestMethod]
        public void TCExpressionInsideStatementPass()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (yesno, ((""niet"">="" jaa"")==((5+2)<21))) ""well"";
                statement Smthing2 (number, (3* ( (5+2) - 21) ) ) ""well"";
                statement Smthing3 (text, "" all your money"" ) ""well"";
                }
            ");
            Assert.IsTrue(Builder.runTypeCheck());


            Assert.AreEqual(0, Builder.dataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void TCStatementInsideExpressionFail()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (number, (no==((5+2)<21))) ""well"";
                statement Smthing2 (text, (3*((5+2)/21))) ""well"";
                statement Smthing (yesno, "" all your money"" ) ""well"";
                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());


            Assert.AreEqual(3, Builder.dataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void TCReferenceToIdentifierPass()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (yesno, (yes)) ""well"";
                statement Smthing2 (number, (5+24124)) ""well"";
                
                statement Smthing3 (number, (5+Smthing2)) ""well"";

                if (Smthing1){};
                if (Smthing2==5){};

                }
            ");
            Assert.IsTrue(Builder.runTypeCheck());


            Assert.AreEqual(0, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfType()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing2 (number, (5+24124)) ""well"";
                               
                if (Smthing2==yes){};

                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());


            Assert.AreEqual(1, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfNotDeclared()
        {
            Initialize(@"form ExampleBlock {
            
            if (Smthing2==2){};

            statement Smthing2 (number, (5+24124)) ""well"";
                               

                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());
            Assert.AreEqual(1, Builder.dataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void TCCyclicReference()
        {
            Initialize(@"form ExampleBlock {
                   statement S1 (number, S3) ""blah"";
                   statement S2 (number, S1) ""blah"";
                   statement S3 (number, S2) ""blah"";
                  

                }
            ");
            Assert.IsFalse(Builder.runTypeCheck());
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
            Assert.IsFalse(Builder.runTypeCheck());

        }        
    }
}
