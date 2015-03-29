using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Test.Evaluation.Types
{
    [TestClass]
    public class IntegerValueTest
    {
        [TestMethod]
        public void TestPlus()
        {
            // Arrange
            var seven = new IntegerValue(7);
            var five = new IntegerValue(5);
            var minFour = new IntegerValue(-4);

            // Act & Assert
            Assert.AreEqual<int>(12, ((IntegerValue)seven.Plus(five)).Val);
            Assert.AreEqual<int>(12, ((IntegerValue)five.Plus(seven)).Val);
            Assert.AreEqual<int>(3, ((IntegerValue)seven.Plus(minFour)).Val);
            Assert.AreEqual<int>(-8, ((IntegerValue)minFour.Plus(minFour)).Val);
        }

        [TestMethod]
        public void TestMinus()
        {
            // Arrange
            var seven = new IntegerValue(7);
            var five = new IntegerValue(5);
            var minFour = new IntegerValue(-4);

            // Act & Assert
            Assert.AreEqual<int>(2, ((IntegerValue)seven.Minus(five)).Val);
            Assert.AreEqual<int>(-2, ((IntegerValue)five.Minus(seven)).Val);
            Assert.AreEqual<int>(11, ((IntegerValue)seven.Minus(minFour)).Val);
            Assert.AreEqual<int>(0, ((IntegerValue)minFour.Minus(minFour)).Val);
        }

        [TestMethod]
        public void TestMultipliedBy()
        {
            // Arrange
            var seven = new IntegerValue(7);
            var five = new IntegerValue(5);
            var minFour = new IntegerValue(-4);

            // Act & Assert
            Assert.AreEqual<int>(35, ((IntegerValue)seven.MultipliedBy(five)).Val);
            Assert.AreEqual<int>(35, ((IntegerValue)five.MultipliedBy(seven)).Val);
            Assert.AreEqual<int>(16, ((IntegerValue)minFour.MultipliedBy(minFour)).Val);
            Assert.AreEqual<int>(-20, ((IntegerValue)minFour.MultipliedBy(five)).Val);
        }

        [TestMethod]
        public void TestDividedBy()
        {
            // Arrange
            var nine = new IntegerValue(9);
            var three = new IntegerValue(3);

            // Act & Assert
            Assert.AreEqual<int>(3, ((IntegerValue)nine.DividedBy(three)).Val);
            Assert.AreEqual<int>(0, ((IntegerValue)three.DividedBy(nine)).Val);
        }

        [TestMethod]
        public void TestIsEqualTo()
        {
            // Arrange
            var sevenA = new IntegerValue(7);
            var sevenB = new IntegerValue(7);
            var five = new IntegerValue(5);

            // Act & Assert
            Assert.IsTrue(((BooleanValue)sevenA.IsEqualTo(sevenB)).Val);
            Assert.IsFalse(((BooleanValue)sevenA.IsEqualTo(five)).Val);
        }

        [TestMethod]
        public void TestLessThan()
        {
            // Arrange
            var nine = new IntegerValue(9);
            var three = new IntegerValue(3);

            // Act & Assert
            Assert.IsFalse(((BooleanValue)nine.IsLessThan(three)).Val);
            Assert.IsTrue(((BooleanValue)three.IsLessThan(nine)).Val);
        }

        [TestMethod]
        public void TestLessThanOrEqualTo()
        {
            // Arrange
            var nineA = new IntegerValue(9);
            var nineB = new IntegerValue(9);
            var three = new IntegerValue(3);

            // Act & Assert
            Assert.IsTrue(((BooleanValue)nineA.IsLessThanOrEqualTo(nineB)).Val);
            Assert.IsTrue(((BooleanValue)three.IsLessThanOrEqualTo(nineA)).Val);
            Assert.IsFalse(((BooleanValue)nineA.IsLessThanOrEqualTo(three)).Val);
        }
    }
}
