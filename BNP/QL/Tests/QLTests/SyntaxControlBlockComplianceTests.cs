using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Tests.QLTests
{
    [TestClass]
    public class SyntaxControlBlockComplianceTests : QLTestBase
    {
        [TestMethod]
        public void IfBlock()
        {
            string input = @"if (7 == 7) {
                                
                             };
                            ";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
        
        [TestMethod]
        public void IfElseBlock()
        {
            string input = @"if (7 == 7) {
                                
                             } else {

                             };
                            ";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }

        /*We dumped elseif
         *         [TestMethod]

         * public void IfElseIfElseBlock()
        {
            string input = @"if (7 == 7) {
                                
                             } else if (yes == no) {

                             }; else {

                             };
                            ";
            Build(input);
            var unit = Parser.unit();

            Assert.IsNull(unit.exception);
            Assert.AreEqual(0, Parser.NumberOfSyntaxErrors);
        }
         */


    }
}
