using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.AST;

namespace Tests.VisitorTests
{
    [TestClass]
    public class TypeCheckerTests
    {

        protected QLBuilder Builder;

        public void Initialize(string input)
        {
            Builder = new QLBuilder(input);
            Builder.RegisterGenericDataHandlers();
            Assert.IsTrue(Builder.RunInit());
            Assert.IsTrue(Builder.RunASTBuilders());
        }


        [TestMethod]
        public void CollectNothing()
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
            Assert.IsTrue(Builder.RunTypeCheckers());
            Assert.AreEqual(0,Builder.DataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void CollectException()
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
            Assert.IsFalse(Builder.RunTypeCheckers());
            Assert.AreEqual(1, Builder.DataContext.ASTHandlerExceptions.Count);
        }
        [TestMethod]
        public void CollectException2()
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
            Assert.IsFalse(Builder.RunTypeCheckers());
            Assert.AreEqual(3, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void CollectNoExceptionCosParentheses()
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

            Assert.IsTrue(Builder.RunTypeCheckers());
            Assert.AreEqual(0, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void ReferencesTest()
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
            Assert.IsTrue(Builder.RunTypeCheckers());

            Assert.AreEqual(0, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void MemoryBuildup()
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
            Builder.RunTypeCheckers();
            int c = Builder.DataContext.TypeReference.Count;

            for (int i = 0; i < 1000; i++)
            {
                Builder.RunTypeCheckers();
            }


            Assert.AreEqual(c, Builder.DataContext.TypeReference.Count);

        }

        
        [TestMethod]
        public void ExpressionInsideStatementPass()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (yesno, ((""niet"">="" jaa"")==((5+2)<21))) ""well"";
                statement Smthing2 (number, (3* ( (5+2) - 21) ) ) ""well"";
                statement Smthing3 (text, "" all your money"" ) ""well"";
                }
            ");
            Assert.IsTrue(Builder.RunTypeCheckers());


            Assert.AreEqual(0, Builder.DataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void StatementInsideExpressionFail()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (number, (no==((5+2)<21))) ""well"";
                statement Smthing2 (text, (3*((5+2)/21))) ""well"";
                statement Smthing (yesno, "" all your money"" ) ""well"";
                }
            ");
            Assert.IsFalse(Builder.RunTypeCheckers());


            Assert.AreEqual(3, Builder.DataContext.ASTHandlerExceptions.Count);

        }

        [TestMethod]
        public void ReferenceToIdentifierPass()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (yesno, (yes)) ""well"";
                statement Smthing2 (number, (5+24124)) ""well"";
                
                statement Smthing3 (number, (5+Smthing2)) ""well"";

                if (Smthing1){};
                if (Smthing2==5){};

                }
            ");
            Assert.IsTrue(Builder.RunTypeCheckers());


            Assert.AreEqual(0, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void ReferenceToIdentifierFailBecauseOfType()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing2 (number, (5+24124)) ""well"";
                               
                if (Smthing2==yes){};

                }
            ");
            Assert.IsFalse(Builder.RunTypeCheckers());


            Assert.AreEqual(1, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void ReferenceToIdentifierFailBecauseOfNotDeclared()
        {
            Initialize(@"form ExampleBlock {
            
            if (Smthing2==2){};

            statement Smthing2 (number, (5+24124)) ""well"";
                               

                }
            ");
            Assert.IsFalse(Builder.RunTypeCheckers());
            Assert.AreEqual(1, Builder.DataContext.ASTHandlerExceptions.Count);

        }
        [TestMethod]
        public void CyclicReference()
        {
            Initialize(@"form ExampleBlock {
                   statement S1 (number, S3) ""blah"";
                   statement S2 (number, S1) ""blah"";
                   statement S3 (number, S2) ""blah"";
                  

                }
            ");
            Assert.IsFalse(Builder.RunTypeCheckers());
        }
        [TestMethod]
        public void ReferenceFromAnotherBranch()
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
            Assert.IsFalse(Builder.RunTypeCheckers());

        }        
    }
}
