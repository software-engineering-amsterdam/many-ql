using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Validation
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.Runtime.Validation.TypeCheckingVisitor"/> class.
    /// </summary>
    [TestClass]
    public class TypeCheckingVisitorTest
    {
        [TestMethod]
        public void TestNegatedIfStatement()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("bool isHappy = true");
            ql.AppendLine("if(!isHappy)");
            ql.AppendLine("{ }");

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new TypeCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            var errorReport = new ErrorReport();
            errorReport.AddTypeCheckingMessages(visitor);

            Assert.AreEqual<int>(0, errorReport.NrOfErrors);
            Assert.AreEqual<int>(0, errorReport.NrOfWarnings);
        }

        [TestMethod]
        public void TestStringConcationation()
        {
            // Arrange
            var controller = new ASTController();
            var form = controller.ParseQLString("string test = \"Piet\" + \"Jansen\"");

            var visitor = new TypeCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            var errorReport = new ErrorReport();
            errorReport.AddTypeCheckingMessages(visitor);

            Assert.AreEqual<int>(0, errorReport.NrOfErrors);
            Assert.AreEqual<int>(0, errorReport.NrOfWarnings);
        }
    }
}
