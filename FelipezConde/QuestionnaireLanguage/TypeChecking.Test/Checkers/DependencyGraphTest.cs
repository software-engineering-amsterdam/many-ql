using AST.Nodes.Expressions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TypeChecking.Checkers;

namespace TypeChecking.Test.Checkers
{
    [TestClass]
    public class DependencyGraphTesta
    {
        [TestMethod]
        public void GetCycles_returns_Direct_Cycle()
        {
            var graph = new DependencyGraph();

            var id1 = new Id("1", new AST.PositionInText());
            var id2 = new Id("2", new AST.PositionInText());

            graph.AddNewDirectDepencencies(id1, new List<Id> {id2});
            graph.AddNewDirectDepencencies(id2, new List<Id> { id1 });


            var x = graph.GetCycles();

            Assert.IsTrue(graph.GetCycles().ToList().Count == 2);

        }

        [TestMethod]
        public void GetCycles_returns_Indirect_Cycle()
        {
            var graph = new DependencyGraph();

            var id1 = new Id("1", new AST.PositionInText());
            var id2 = new Id("2", new AST.PositionInText());
            var id3 = new Id("3", new AST.PositionInText());

            graph.AddNewDirectDepencencies(id1, new List<Id> { id2 });
            graph.AddNewDirectDepencencies(id2, new List<Id> { id3 });
            graph.AddNewDirectDepencencies(id3, new List<Id> { id1 });

            Assert.IsTrue(graph.GetCycles().ToList().Count == 3);

        }

    }
}
