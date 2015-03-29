using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Test.Evaluation.Types
{
    [TestClass]
    public class BooleanValueTest
    {
        [TestMethod]
        public void TestAnd()
        {
            // Arrange
            var boolTrue = new BooleanValue(true);
            var boolFalse = new BooleanValue(false);

            // Act & Assert
            Assert.IsFalse(((BooleanValue)boolFalse.And(boolFalse)).Val);
            Assert.IsFalse(((BooleanValue)boolTrue.And(boolFalse)).Val);
            Assert.IsFalse(((BooleanValue)boolFalse.And(boolTrue)).Val);
            Assert.IsTrue(((BooleanValue)boolTrue.And(boolTrue)).Val);
        }

        [TestMethod]
        public void TestOr()
        {
            // Arrange
            var boolTrue = new BooleanValue(true);
            var boolFalse = new BooleanValue(false);

            // Act & Assert
            Assert.IsFalse(((BooleanValue)boolFalse.Or(boolFalse)).Val);
            Assert.IsTrue(((BooleanValue)boolTrue.Or(boolFalse)).Val);
            Assert.IsTrue(((BooleanValue)boolFalse.Or(boolTrue)).Val);
            Assert.IsTrue(((BooleanValue)boolTrue.Or(boolTrue)).Val);
        }

        [TestMethod]
        public void TestIsEqualTo()
        {
            // Arrange
            var boolTrue = new BooleanValue(true);
            var boolFalse = new BooleanValue(false);

            // Act & Assert
            Assert.IsTrue(((BooleanValue)boolFalse.IsEqualTo(boolFalse)).Val);
            Assert.IsFalse(((BooleanValue)boolTrue.IsEqualTo(boolFalse)).Val);
            Assert.IsFalse(((BooleanValue)boolFalse.IsEqualTo(boolTrue)).Val);
            Assert.IsTrue(((BooleanValue)boolTrue.IsEqualTo(boolTrue)).Val);
        }

        [TestMethod]
        public void TestIsNotEqualTo()
        {
            // Arrange
            var boolTrue = new BooleanValue(true);
            var boolFalse = new BooleanValue(false);

            // Act & Assert
            Assert.IsFalse(((BooleanValue)boolFalse.IsNotEqualTo(boolFalse)).Val);
            Assert.IsTrue(((BooleanValue)boolTrue.IsNotEqualTo(boolFalse)).Val);
            Assert.IsTrue(((BooleanValue)boolFalse.IsNotEqualTo(boolTrue)).Val);
            Assert.IsFalse(((BooleanValue)boolTrue.IsNotEqualTo(boolTrue)).Val);
        }
    }
}
