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

        protected AstHandler Handler;

        public void Initialize(string input)
        {
            Handler = new AstHandler(input);
            Assert.IsTrue(Handler.BuildAST());

        }


        [TestMethod]
        public void TypeCheckerCollectNothing()
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
            Assert.IsTrue(Handler.CheckType());
            Assert.AreEqual(0,Handler.TypeCheckerErrors.Count);

        }

        [TestMethod]
        public void TypeCheckerCollectException()
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
            Assert.IsFalse(Handler.CheckType());
            Assert.AreEqual(1, Handler.TypeCheckerErrors.Count);
        }
        [TestMethod]
        public void TypeCheckerCollectException2()
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
            Assert.IsFalse(Handler.CheckType());
            Assert.AreEqual(3, Handler.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TypeCheckerCollectNoExceptionCosParentheses()
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

            Assert.IsTrue(Handler.CheckType());
            Assert.AreEqual(0, Handler.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TypeCheckerReferencesTest()
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
            Assert.IsTrue(Handler.CheckType());

            Assert.AreEqual(0, Handler.TypeCheckerErrors.Count);

        }

        [TestMethod]
        public void TCParsingMinusSign()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing1 (number, (1+(2- 3)) ""this "";
                statement Smthing1 (number, (1+(2 -3)) ""should"";
                statement Smthing1 (number, (1+(2 --3)) ""be"";
                statement Smthing1 (number, (1+(2-3)) ""solved"";

                }

            ");
            Assert.IsTrue(Handler.CheckType());


            Assert.AreEqual(0, Handler.TypeCheckerErrors.Count);

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
            Assert.IsTrue(Handler.CheckType());


            Assert.AreEqual(0, Handler.TypeCheckerErrors.Count);

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
            Assert.IsFalse(Handler.CheckType());


            Assert.AreEqual(3, Handler.TypeCheckerErrors.Count);

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
            Assert.IsTrue(Handler.CheckType());


            Assert.AreEqual(0, Handler.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfType()
        {
            Initialize(@"form ExampleBlock {
                statement Smthing2 (number, (5+24124)) ""well"";
                               
                if (Smthing2==yes){};

                }
            ");
            Assert.IsFalse(Handler.CheckType());


            Assert.AreEqual(1, Handler.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfNotDeclared()
        {
            Initialize(@"form ExampleBlock {
            
            if (Smthing2==2){};

            statement Smthing2 (number, (5+24124)) ""well"";
                               

                }
            ");
            Assert.IsFalse(Handler.CheckType());
            Assert.AreEqual(1, Handler.TypeCheckerErrors.Count);

        }
    }
}
