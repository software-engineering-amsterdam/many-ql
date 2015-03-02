using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Text;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Validation
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.Runtime.TypeChecking.VariableUsageCheckingVisitor"/> class.
    /// </summary>
    [TestClass]
    public class VariableUsageCheckingVisitorTest
    {
        [TestMethod]
        public void TestUnusedVariable()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("bool isHappy"); // A declared variable should always be used in an expression.

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new VariableUsageCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(1, visitor.UnusedVariables.Count);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(0, visitor.RedeclaredVariables.Count);
        }

        [TestMethod]
        public void TestUnusedQuestion()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("isHappy \"Are you happy?\" bool");  // A question doesn't need to be used in an expression.

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new VariableUsageCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(0, visitor.UnusedVariables.Count);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(0, visitor.RedeclaredVariables.Count);
        }


        [TestMethod]
        public void TestRedeclaredVariable()
        {
            // Arrange
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("int age");
            ql.AppendLine("string age");

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new VariableUsageCheckingVisitor();

            // Act
            visitor.Visit(form);

            // Assert
            Assert.AreEqual<int>(1, visitor.UnusedVariables.Count);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(1, visitor.RedeclaredVariables.Count);
        }
    }
}
