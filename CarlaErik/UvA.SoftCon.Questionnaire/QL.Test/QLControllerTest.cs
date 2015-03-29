using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.Test
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.QL.QLController"/> class.
    /// </summary>
    [TestClass]
    public class QLControllerTest
    {
        [TestMethod]
        public void TestParseEmptyString()
        {
            // Arrange
            var controller = new QLController();
            string ql = String.Empty; // An empty string is also valid QL code.

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(0, form.Statements.Count());
        }

        [TestMethod]
        public void TestParseQuestion()
        {
            // Arrange
            var controller = new QLController();
            string ql = "FavoriteColor \"What is your favorite color?\" string";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count());
            var question = form.Statements.First() as Question;
            Assert.AreEqual<string>("What is your favorite color?", question.Label);
            Assert.AreEqual<string>("FavoriteColor", question.Id.Name);
            Assert.AreEqual<DataType>(DataType.String, question.DataType);
        }

        [TestMethod]
        public void TestParseIfStatement()
        {
            // Arrange
            var controller = new QLController();
            string ql = "if(hasSoldHouse && boughtNew) { int sellingPrice = 0 }";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count());
            Assert.IsInstanceOfType(form.Statements.First(), typeof(IfStatement));
            var ifStatement = form.Statements.First() as IfStatement;
            Assert.AreEqual<int>(1, ifStatement.Then.Count());
            Assert.AreEqual<int>(0, ifStatement.Else.Count());
        }

        [TestMethod]
        public void TestParseIfElseStatement()
        {
            // Arrange
            var controller = new QLController();
            string ql = "if(hasSoldHouse && boughtNew) { int sellingPrice = 0 } else { int askingPrice = 0 }";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count());
            Assert.IsInstanceOfType(form.Statements.First(), typeof(IfStatement));
            var ifStatement = form.Statements.First() as IfStatement;
            Assert.AreEqual<int>(1, ifStatement.Then.Count());
            Assert.AreEqual<int>(1, ifStatement.Else.Count());
        }
    }
}
