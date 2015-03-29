using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Test.Evaluation.Types
{
    [TestClass]
    public class DateValueTest
    {
        [TestMethod]
        public void TestIsEqualTo()
        {
            // Arrange
            var now = DateTime.Now;
            var todayA = new DateValue(now);
            var todayB = new DateValue(now);
            var tommorow = new DateValue(DateTime.Now.AddDays(1));

            // Act & Assert
            Assert.IsTrue(((BooleanValue)todayA.IsEqualTo(todayB)).Val);
            Assert.IsFalse(((BooleanValue)todayA.IsEqualTo(tommorow)).Val);
            Assert.IsFalse(((BooleanValue)tommorow.IsEqualTo(todayA)).Val);
        }

        [TestMethod]
        public void TestNotIsEqualTo()
        {
            // Arrange
            var now = DateTime.Now;
            var todayA = new DateValue(now);
            var todayB = new DateValue(now);
            var tommorow = new DateValue(DateTime.Now.AddDays(1));

            // Act & Assert
            Assert.IsFalse(((BooleanValue)todayA.IsNotEqualTo(todayB)).Val);
            Assert.IsTrue(((BooleanValue)todayA.IsNotEqualTo(tommorow)).Val);
            Assert.IsTrue(((BooleanValue)tommorow.IsNotEqualTo(todayA)).Val);
        }

        [TestMethod]
        public void TestLessThan()
        {
            // Arrange
            var now = DateTime.Now;
            var todayA = new DateValue(now);
            var todayB = new DateValue(now);
            var tommorow = new DateValue(DateTime.Now.AddDays(1));

            // Act & Assert
            Assert.IsTrue(((BooleanValue)todayA.IsLessThan(tommorow)).Val);
            Assert.IsFalse(((BooleanValue)todayB.IsLessThan(todayA)).Val);
            Assert.IsFalse(((BooleanValue)tommorow.IsLessThan(todayA)).Val);
        }

        [TestMethod]
        public void TestLessThanOrEqualTo()
        {
            // Arrange
            var now = DateTime.Now;
            var todayA = new DateValue(now);
            var todayB = new DateValue(now);
            var tommorow = new DateValue(DateTime.Now.AddDays(1));

            // Act & Assert
            Assert.IsTrue(((BooleanValue)todayA.IsLessThanOrEqualTo(tommorow)).Val);
            Assert.IsTrue(((BooleanValue)todayB.IsLessThanOrEqualTo(todayA)).Val);
            Assert.IsFalse(((BooleanValue)tommorow.IsLessThanOrEqualTo(todayA)).Val);
        }
    }
}
