using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Test.Evaluation.Types
{
    [TestClass]
    public class StringValueTest
    {
        [TestMethod]
        public void TestConcat()
        {
            // Arrange
            var erik = new StringValue("Erik");
            var verhoofstad = new StringValue("Verhoofstad");

            // Act
            var erikVerhoofstad = erik.Plus(verhoofstad) as StringValue;

            // Assert
            Assert.AreEqual<string>("ErikVerhoofstad", erikVerhoofstad.Val);
        }

        [TestMethod]
        public void TestIsEqualTo()
        {
            // Arrange
            var erikA = new StringValue("Erik");
            var erikB = new StringValue("Erik");

            // Act
            var result = erikA.IsEqualTo(erikB) as BooleanValue;

            // Assert
            Assert.IsTrue(result.Val);
        }
    }
}
