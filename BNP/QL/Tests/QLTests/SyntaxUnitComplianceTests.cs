using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Tests.QLTests
{
    [TestClass]
    public class SyntaxUnitComplianceTests : QLTestBase
    {
        #region Questions of different types
        [TestMethod]
        public void QuestionOfTypeText()
        {
            string input = "question My1stQuestion2345 (text) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void QuestionOfTypeYesNo()
        {
            string input = "question My1stQuestion2345 (yesno) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void QuestionOfTypeNumber()
        {
            string input = "question My1stQuestion2345 (number) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        #endregion

        #region Statements of a static value
        [TestMethod]
        public void StaticStatementOfTypeText()
        {
            string input = "statement My2ndStatement9876 (text, \"show this string\") \"Label of the string to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void StaticStatementOfTypeYesNo()
        //this is not syntactically correct atm
        {
            string input = "statement My2ndStatement9876 (yesno, no) \"Label of the boolean value to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void StaticStatementOfTypeNumber()
        //this is not syntactically correct atm
        {
            string input = "statement My2ndStatement9876 (number, 123456) \"Label of the number to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void StaticStatementOfTypeNegativeNumber()
        //this is not syntactically correct atm
        {
            string input = "statement My2ndStatement9876 (number, -1234567) \"Label of the negative number to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        #endregion

    }
}
