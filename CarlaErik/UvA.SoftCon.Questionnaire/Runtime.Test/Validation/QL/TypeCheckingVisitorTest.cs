using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;
using System.Text;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.Runtime.Validation.QL;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Validation.QL
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

            var controller = new QLController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new TypeCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(0, visitor.InvalidBinaryExpressions.Count());
            Assert.AreEqual<int>(0, visitor.InvalidDefinitions.Count());
            Assert.AreEqual<int>(0, visitor.InvalidIfStatements.Count());
            Assert.AreEqual<int>(0, visitor.InvalidUnaryExpressions.Count());
        }

        [TestMethod]
        public void TestStringConcationation()
        {
            // Arrange
            var controller = new QLController();
            var form = controller.ParseQLString("string test = \"Piet\" + \"Jansen\"");

            var visitor = new TypeCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(0, visitor.InvalidBinaryExpressions.Count());
            Assert.AreEqual<int>(0, visitor.InvalidDefinitions.Count());
            Assert.AreEqual<int>(0, visitor.InvalidIfStatements.Count());
            Assert.AreEqual<int>(0, visitor.InvalidUnaryExpressions.Count());
        }
    }
}
