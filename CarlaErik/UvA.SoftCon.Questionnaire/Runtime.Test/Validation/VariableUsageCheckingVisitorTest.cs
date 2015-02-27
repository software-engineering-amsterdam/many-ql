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
        public void TestNoErrors()
        {
            // Arrange
            var visitor = new VariableUsageCheckingVisitor();
            var statements = new List<IStatement>() 
            {
                new Declaration(DataType.String, new Identifier("age", new TextPosition(1, 6)), new TextPosition(1,1)),
                new Assignment(new Identifier("age", new TextPosition(2,1)), new IntegerLiteral(36, new TextPosition(2,4)), new TextPosition(2,1))
            };

            var ql = new Form(statements, new TextPosition(1,1));

            // Act
            visitor.Visit(ql);

            // Assert
            Assert.AreEqual<int>(1, visitor.DeclaredVariables.Count);
            Assert.AreEqual<int>(1, visitor.DeclaredVariables["age"].UsageCount);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(0, visitor.RedeclaredVariables.Count);
        }

        [TestMethod]
        public void TestRedeclaredVariable()
        {
            // Arrange
            var visitor = new VariableUsageCheckingVisitor();
            var statements = new List<IStatement>() 
            {
                new Declaration(DataType.String, new Identifier("age", new TextPosition(1,7)), new TextPosition(1,1)),
                new Declaration(DataType.Integer, new Identifier("age", new TextPosition(1,5)), new TextPosition(2,1)),
            };

            var ql = new Form(statements, new TextPosition(1,1));

            // Act
            visitor.Visit(ql);

            // Assert
            Assert.AreEqual<int>(1, visitor.DeclaredVariables.Count);
            Assert.AreEqual<int>(0, visitor.DeclaredVariables["age"].UsageCount);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(1, visitor.RedeclaredVariables.Count);
        }

        [TestMethod]
        public void TestItWhole()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("int age = 36");
            ql.AppendLine("age = age + 5");
            ql.AppendLine("string name = \"erik\"");
            ql.AppendLine("hop = 4"); 

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new VariableUsageCheckingVisitor();

            visitor.Visit(form);

            var errorReportBuilder = new ErrorReport();
            errorReportBuilder.AddVariableUsageMessages(visitor);

            string report = errorReportBuilder.GetReport();

        }
    }
}
