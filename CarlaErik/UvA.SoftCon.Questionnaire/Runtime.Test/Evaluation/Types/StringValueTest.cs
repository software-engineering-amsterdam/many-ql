using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Evaluation.Types
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
    }
}
