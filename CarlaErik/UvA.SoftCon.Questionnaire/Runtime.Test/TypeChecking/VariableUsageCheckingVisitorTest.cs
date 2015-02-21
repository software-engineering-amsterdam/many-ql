using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.Runtime.TypeChecking;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.TypeChecking
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
                new Declaration(DataType.String, new Identifier("age")),
                new Assignment(new Identifier("age"), new Literal<int>(36))
            };

            var ql = new Form(statements);

            // Act
            visitor.Visit(ql);

            // Assert
            Assert.AreEqual<int>(1, visitor.DeclaredVariables.Count);
            Assert.AreEqual<int>(1, visitor.DeclaredVariables["age"].UsageCount);
            Assert.AreEqual<int>(0, visitor.UndeclaredVariables.Count);
            Assert.AreEqual<int>(0, visitor.RedeclaredVariables.Count);
        }
    }
}
