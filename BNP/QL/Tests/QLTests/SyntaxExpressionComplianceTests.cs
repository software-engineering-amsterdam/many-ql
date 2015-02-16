using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Tests.QLTests
{
    [TestClass]
    public class SyntaxExpressionComplianceTests : SyntaxComplianceTestBase
    {
        #region Basic equality comparisons
        [TestMethod]
        public void YesNoComparison()
        {
            string input = "(yes == yes)";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void NumberComparison()
        {
            string input = "(7 == 7)";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void TextComparison()
        {
            string input = "(\"abc\" == \"abc\")";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void IDComparison()
        {
            string input = "(MySuperDuperD3luxeID123 == YourLousyMou5yID987)";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        #endregion

        #region Nested expression comparisons
        [TestMethod]
        public void NestedExpressionEqualsExpression()
        {
            string input = "((134758643 + ValueOfID1) >= no)";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        [TestMethod]
        public void ExpressionEqualsNestedExpression()
        {
            string input = "(\"duh\" != (-2343243 * yes))";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        
        [TestMethod]
        public void NestedExpressionEqualsNestedExpression()
        {
            string input = "((\"oh no!\" && no) <= (no + yes))";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }


        [TestMethod]
        public void DoubleNestedExpressionEqualsNestedExpression()
        {
            string input = "((\"oh no!\" && (no * -127)) != (12345 / \"Divide me\"))";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        #endregion

    }
}
