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
       
    }
}
