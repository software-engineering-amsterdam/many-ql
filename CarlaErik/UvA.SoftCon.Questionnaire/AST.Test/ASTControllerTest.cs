using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using Antlr4.Runtime;
using UvA.SoftCon.Questionnaire.Parsing;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals;

namespace UvA.SoftCon.Questionnaire.AST.Test
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.AST.ASTController"/> class.
    /// </summary>
    [TestClass]
    public class ASTControllerTest
    {
        [TestMethod]
        public void TestParseEmptyString()
        {
            // Arrange
            var controller = new ASTController();
            string ql = String.Empty; // An empty string is also valid QL code.

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(0, form.Statements.Count);
        }

        [TestMethod]
        public void TestParseQuestion()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "string FavoriteColor \"What is your favorite color?\"";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            var question = form.Statements[0] as Question;
            Assert.AreEqual<string>("What is your favorite color?", question.Label);
            Assert.AreEqual<string>("FavoriteColor", question.Id.Name);
            Assert.AreEqual<DataType>(DataType.String, question.DataType);
        }

        [TestMethod]
        public void TestParseDeclaration()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "int counter";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            var declaration = form.Statements[0] as Declaration;

            Assert.AreEqual<DataType>(DataType.Integer, declaration.DataType);
            Assert.AreEqual<string>("counter", declaration.Id.Name);
            Assert.IsNull(declaration.Initialization);
        }

        [TestMethod]
        public void TestParseDeclarationWithInitialization()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "string surname = \"Verhoofstad\"";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            var declaration = form.Statements[0] as Declaration;

            Assert.AreEqual<DataType>(DataType.String, declaration.DataType);
            Assert.AreEqual<string>("surname", declaration.Id.Name);
            Assert.IsInstanceOfType(declaration.Initialization, typeof(StringLiteral));
            var initialization = declaration.Initialization as StringLiteral;
            Assert.AreEqual<string>("Verhoofstad", initialization.Value);
        }

        [TestMethod]
        public void TestParseAssignment()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "id = 5 * 6 + 7";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            var assignment = form.Statements[0] as Assignment;

            Assert.AreEqual<string>("5 * 6 + 7", assignment.Expression.ToString());
        }

        [TestMethod]
        public void TestParseIfStatement()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "if(hasSoldHouse && boughtNew) { int sellingPrice = 0 }";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            Assert.AreEqual<NodeType>(NodeType.IfStatement, form.Statements[0].Type);
            var ifStatement = form.Statements[0] as IfStatement;
            Assert.AreEqual<int>(1, ifStatement.Then.Count);
            Assert.AreEqual<int>(0, ifStatement.Else.Count);
        }

        [TestMethod]
        public void TestParseIfElseStatement()
        {
            // Arrange
            var controller = new ASTController();
            string ql = "if(hasSoldHouse && boughtNew) { int sellingPrice = 0 } else { int askingPrice = 0 }";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count);
            Assert.AreEqual<NodeType>(NodeType.IfStatement, form.Statements[0].Type);
            var ifStatement = form.Statements[0] as IfStatement;
            Assert.AreEqual<int>(1, ifStatement.Then.Count);
            Assert.AreEqual<int>(1, ifStatement.Else.Count);
        }
    }
}
