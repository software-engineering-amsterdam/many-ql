using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.Runtime.Validation.QL;
using System.Text;
using System.Linq;
using UvA.SoftCon.Questionnaire.QL;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Validation.QL
{
    [TestClass]
    public class LiteralCheckingVisitorTest
    {
        [TestMethod]
        public void TestValidDates()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("date someDateA = [31-1-2015]");
            ql.AppendLine("date someDateB = [01-01-2015]");
            ql.AppendLine("date someDateC = [5-06-1920]");
            ql.AppendLine("date someDateD = [today]");
            ql.AppendLine("date someDateE = [yesterday]");
            ql.AppendLine("date someDateF = [tomorrow]");

            var controller = new QLController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new LiteralCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(0, visitor.InvalidLiterals.Count());
        }

        [TestMethod]
        public void TestInvalidDates()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("date someDateA = [1-31-2015]");
            ql.AppendLine("date someDateB = [30-02-2015]");

            var controller = new QLController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new LiteralCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(2, visitor.InvalidLiterals.Count());
        }

        [TestMethod]
        public void TestInvalidInteger()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("int someInt = 8374398748349837489274"); // An integer value that well surpasses the 32-bit range.

            var controller = new QLController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new LiteralCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(1, visitor.InvalidLiterals.Count());
        }
    
    }
}
