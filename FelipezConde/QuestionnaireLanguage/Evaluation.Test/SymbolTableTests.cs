using AST;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Evaluation.Test
{
    [TestClass]
    public class SymbolTableTests
    {
        private PositionInText pos = new PositionInText();
        private Id id = new Id("1", new PositionInText());
        private SymbolTable symbolTable;

        [TestMethod]
        public void GetValue_KeyNotFound_Test()
        {
            symbolTable = new SymbolTable();

            Id id = new Id("1", pos);
            symbolTable.GetValue(id);
        }

        [TestMethod]
        public void AddValue_Correct_Test()
        {
            symbolTable = new SymbolTable();
            symbolTable.AddValue(id, new Bool(false));

            Assert.IsNotNull(symbolTable.GetValue(id));
        }

        [TestMethod]
        public void UpdateValue_Correct_Test()
        {
            symbolTable = new SymbolTable();

            AddValue_Correct_Test();

            symbolTable.SetUpdateValue(id, new Bool(true));

            Bool value = (Bool)symbolTable.GetValue(id);

            Assert.IsTrue(value.GetValue() == true);
        }

        [TestMethod]
        public void Is_In_Table_Test()
        {
            symbolTable = new SymbolTable();

            AddValue_Correct_Test();

            Assert.IsTrue(symbolTable.IsInTable(id));

        }
    }
}
