using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;

namespace Tests.VisitorTests
{
    [TestClass]
    public class BasicVisitorTests : QLTestBase
    {
        [TestMethod]
        public void TestMethod1()
        {
            string input = @"form MyForm {
                                question Q1 (yesno) ""I am not sure what to answer!"";
                                if(Q1 == yes) {
                                    statement S2 (text, Q1) ""You've answered:"";
                                };
                             }";

            Build(input);


            var formBlock = Parser.formBlock();

            IList<UnitBase> parsedUnits = new List<UnitBase>();
            
            QLVisitor visitor = new QLVisitor(Parser, parsedUnits);

            var x = visitor.VisitFormBlock(formBlock);
            x.ToString();
        }
    }
}
