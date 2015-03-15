﻿using Antlr4.Runtime;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;
using System.Linq;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
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
        public void TestParseDeclarationDefinition()
        {
            // Arrange
            var controller = new QLController();
            string ql = "string surname = \"De Vries\"";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count());
            var declaration = form.Statements.First() as Definition;

            Assert.AreEqual<DataType>(DataType.String, declaration.DataType);
            Assert.AreEqual<string>("surname", declaration.Id.Name);
            Assert.IsInstanceOfType(declaration.Expression, typeof(StringLiteral));
            var initialization = declaration.Expression as StringLiteral;
            Assert.AreEqual<string>("De Vries", initialization.GetValue());
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

        [TestMethod]
        public void TestParseDate()
        {
            // Arrange
            var controller = new QLController();
            string ql = "date dateOfBirth = [01-9-2015]";

            // Act
            var form = controller.ParseQLString(ql);

            // Assert
            Assert.IsNotNull(form, "Method ParseQLString should never return a null value.");
            Assert.AreEqual<int>(1, form.Statements.Count());
            var assignment = form.Statements.First() as Definition;
            Assert.IsInstanceOfType(assignment.Expression, typeof(DateLiteral));
            var dateLiteral = assignment.Expression as DateLiteral;
            Assert.AreEqual<DateTime>(new DateTime(2015, 9, 1), dateLiteral.GetValue());
        }
    }
}