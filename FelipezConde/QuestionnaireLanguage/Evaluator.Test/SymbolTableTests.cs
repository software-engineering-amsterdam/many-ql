using AST.Nodes.Expression;
using AST.Nodes.Literals;
using AST.Representation;
using Evaluator.Storage;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Evaluator.Test
{
    [TestClass]
    public class SymbolTableTests
    {
        private PositionInText pos = new PositionInText();
        private Id id = new Id("1", new PositionInText());

        [TestMethod]
        public void GetValue_KeyNotFound_Test()
        {
            Id id = new Id("1", pos);
            SymbolTable.GetValue(id);
        }

        [TestMethod]
        public void AddValue_Correct_Test()
        {
            SymbolTable.AddValue(id, new Bool(true));

            Assert.IsNotNull(SymbolTable.GetValue(id));
        }

        [TestMethod]
        public void UpdateValue_Correct_Test()
        {
            AddValue_Correct_Test();
            SymbolTable.SetUpdateValue(id, new Bool(true));

            Bool value = (Bool)SymbolTable.GetValue(id).GetValueType();

            Assert.IsTrue(value.GetValue() == true);
        }
    }
}
