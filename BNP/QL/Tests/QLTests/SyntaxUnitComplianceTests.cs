using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Tests.QLTests
{
    [TestClass]
    public class SyntaxUnitComplianceTests : SyntaxComplianceTestBase
    {
        #region Questions of different types
        [TestMethod]
        public void QuestionOfTypeText()
        {
            string input = "question My1stQuestion2345 (text) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void QuestionOfTypeYesNo()
        {
            string input = "question My1stQuestion2345 (yesno) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void QuestionOfTypeNumber()
        {
            string input = "question My1stQuestion2345 (number) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        #endregion

        #region Optional questions of different types
        [TestMethod]
        public void OptionalQuestionOfTypeText()
        {
            string input = "question My1stQuestion2345 (text, optional) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void OptionalQuestionOfTypeYesNo()
        {
            string input = "question My1stQuestion2345 (yesno, optional) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void OptionalQuestionOfTypeNumber()
        {
            string input = "question My1stQuestion2345 (number, optional) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        #endregion

        #region Required questions of different types
        [TestMethod]
        public void RequiredQuestionOfTypeText()
        {
            string input = "question My1stQuestion2345 (text, required) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void RequiredQuestionOfTypeYesNo()
        {
            string input = "question My1stQuestion2345 (yesno, required) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void RequiredQuestionOfTypeNumber()
        {
            string input = "question My1stQuestion2345 (number, required) \"Hello world\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
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
        }

        [TestMethod]
        public void StaticStatementOfTypeYesNo()
        {
            string input = "statement My2ndStatement9876 (yesno, no) \"Label of the boolean value to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void StaticStatementOfTypeNumber()
        {
            string input = "statement My2ndStatement9876 (number, 1234567.89) \"Label of the number to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        [TestMethod]
        public void StaticStatementOfTypeNegativeNumber()
        {
            string input = "statement My2ndStatement9876 (number, -1234567.89) \"Label of the negative number to show:\";";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
        }

        #endregion

    }
}
