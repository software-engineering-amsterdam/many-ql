using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Text;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.Runtime.Validation;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Test.Validation
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.Runtime.Validation.TypeCheckingVisitor"/> class.
    /// </summary>
    [TestClass]
    public class TypeCheckerTest
    {
        [TestMethod]
        public void TestNegatedIfStatement()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("isHappy \"Are you happy?\" bool");
            ql.AppendLine("if(!isHappy)");
            ql.AppendLine("{ }");

            var controller = new QLController();
            var form = controller.ParseQLString(ql.ToString());
            var typeChecker = new TypeChecker();
            var report = new ValidationReport();

            // Act
            typeChecker.Validate(form, report);

            // Assert
            Assert.AreEqual<int>(0, report.NrOfErrors);
        }

        [TestMethod]
        public void TestStringConcationation()
        {
            // Arrange
            var controller = new QLController();
            var form = controller.ParseQLString("name = \"What's your name?\" string = \"Piet\" + \"Jansen\"");
            var typeChecker = new TypeChecker();
            var report = new ValidationReport();

            // Act
            typeChecker.Validate(form, report);

            // Assert
            Assert.AreEqual<int>(0, report.NrOfErrors);
        }
    }
}
