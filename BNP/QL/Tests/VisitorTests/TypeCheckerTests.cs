using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;
using QL;

namespace Tests.VisitorTests
{
    [TestClass]
    public class TypeCheckerTests : QLTestBase
    {

        [TestMethod]
        public void TypeCheckerCollectNothing()
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
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            Assert.AreEqual(ast.TypeCheckerErrors.Count, 0);
            ast.CheckType();
            Assert.AreEqual(ast.TypeCheckerErrors.Count, 0);

        }

        [TestMethod]
        public void TypeCheckerCollectException()
        {
            string input = @"form ExampleBlock {
                if (3==-11){}
	            else {
                     if (3==yes)
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();
            Assert.AreEqual(1, ast.TypeCheckerErrors.Count);
        }
        [TestMethod]
        public void TypeCheckerCollectException2()
        {
            string input = @"form ExampleBlock {
                if (3==(4==(4>2))){}
	            else {
                     if (3==(4==2))
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(3, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TypeCheckerCollectNoExceptionCosParentheses()
        {
            string input = @"form ExampleBlock {
                if ((3+(4+(5+6)))==9){}
	            else {
                     if (no==(4==2))
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(0, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TypeCheckerReferencesTest()
        {
            string input = @"form ExampleBlock {
                statement Smthing (yesno, (3==4)) ""well"";
                if ((3+(4+(5+6))==12){}
	            else {
                     if (Smthing==(4==2))
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(0, ast.TypeCheckerErrors.Count);

        }

        [TestMethod]
        public void TCParsingMinusSign()
        {
            string input = @"form ExampleBlock {
                statement Smthing1 (number, (1+(2- 3)) ""this "";
                statement Smthing1 (number, (1+(2 -3)) ""should"";
                statement Smthing1 (number, (1+(2 --3)) ""be"";
                statement Smthing1 (number, (1+(2-3)) ""solved"";

                }

            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(0, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCExpressionInsideStatementPass()
        {
            string input = @"form ExampleBlock {
                statement Smthing1 (yesno, ((""niet"">="" jaa"")==((5+2)<21))) ""well"";
                statement Smthing2 (number, (3* ( (5+2) - 21) ) ) ""well"";
                statement Smthing3 (text, "" all your money"" ) ""well"";
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(0, ast.TypeCheckerErrors.Count);

        }

        [TestMethod]
        public void TCStatementInsideExpressionFail()
        {
            string input = @"form ExampleBlock {
                statement Smthing1 (number, (no==((5+2)<21))) ""well"";
                statement Smthing2 (text, (3*((5+2)/21))) ""well"";
                statement Smthing (yesno, "" all your money"" ) ""well"";
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(3, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierPass()
        {
            string input = @"form ExampleBlock {
                statement Smthing1 (yesno, (yes) ""well"";
                statement Smthing2 (number, (5+24124) ""well"";
                
                statement Smthing3 (number, (5+Smthing2) ""well"";

                if (Smthing1){};
                if (Smthing2==5){};

                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(0, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfType()
        {
            string input = @"form ExampleBlock {
                statement Smthing2 (number, (5+24124) ""well"";
                               
                if (Smthing2==yes){};

                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(1, ast.TypeCheckerErrors.Count);

        }
        [TestMethod]
        public void TCReferenceToIdentifierFailBecauseOfNotDeclared()
        {
            string input = @"form ExampleBlock {
            
            if (Smthing2==2){};

            statement Smthing2 (number, (5+24124) ""well"";
                               

                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Assert.IsTrue(Listener.AstExists);
            AstHandler ast = Listener.GetAst();
            ast.CheckType();

            Assert.AreEqual(1, ast.TypeCheckerErrors.Count);

        }
    }
}
