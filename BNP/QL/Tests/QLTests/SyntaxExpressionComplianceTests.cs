using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL;
using QL.Model;

namespace Tests.QLTests
{
    [TestClass]
    public class SyntaxExpressionComplianceTests : QLTestBase
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

        [TestMethod]
        public void LiteralInsideAnExpression()
        {
            string input = "8";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        
        [TestMethod]
        public void LiteralInsideParenthesisInsideAnExpression()
        {
            string input = "(justMyId)";
            Build(input);
            var unit = Parser.expression();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        [TestMethod]
        public void MinusSign()
        {
            
            string input = @"form ExampleBlock {
                statement Smthing1 (number, (1+(2 -3))) ""this "";
                statement Smthing2 (number, (1+(2-3))) ""should"";
                statement Smthing3 (number, (1+(2 --3))) ""be"";
                statement Smthing4 (number, (1+(2-- 3))) ""solved"";

                }

            ";
            QLBuilder Handler = new QLBuilder(input);

            Handler.RegisterGenericDataHandlers();
            Assert.AreEqual(true, Handler.RunInit());
            Assert.AreEqual(true, Handler.RunAstBuild());



        }
        #endregion

    }
}
