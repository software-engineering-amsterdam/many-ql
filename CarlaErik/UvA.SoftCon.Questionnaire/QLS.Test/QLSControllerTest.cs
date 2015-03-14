using System;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UvA.SoftCon.Questionnaire.QLS.Test
{
    [TestClass]
    public class QLSControllerTest
    {
        [TestMethod]
        public void TestEmptyStyleSheet()
        {
            var controller = new QLSController();
            string qls = "stylesheet BeverageStyles {}";

            // Act
            var stylesheet = controller.ParseQLSString(qls);

            // Assert
            Assert.IsNotNull(stylesheet);
            Assert.AreEqual<string>("BeverageStyles", stylesheet.Id.Name);
            Assert.AreEqual<int>(0, stylesheet.Pages.Count());
        }
    }
}
