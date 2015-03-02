using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;
using QL;

namespace Tests.AstBuilderTests
{
    [TestClass]
    public class AstBuilderTests : QLTestBase
    {
        protected QLListener Listener;
        
        [TestMethod]
        public void ControlUnitConstruction()
        {
            ControlUnit c = new ControlUnit();
            Expression e = new Expression();
            Block tb = new Block();
            Block fb = new Block();

            Assert.IsNull(c.Expression);
            Assert.IsNull(c.ConditionFalseBlock);
            Assert.IsNull(c.ConditionTrueBlock);


            c.Expression = e;
            c.ConditionTrueBlock = tb;
            c.ConditionFalseBlock = fb;
            Assert.AreEqual(c.Children.Count, 3);

        }
        

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
            Assert.IsTrue(Listener.AstExists);

        }
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
            Assert.AreEqual(ast.TypeCheckerErrors.Count,0);
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
                if (3+(4+(5+6))){}
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
                if (3+(4+(5+6))){}
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
        
    }
}
