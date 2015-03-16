using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Interfaces;
using AST.Nodes.Literals;
using AST.Representation;
using Evaluation;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Evaluator.Test
{
    [TestClass]
    public class EvaluationManagerTests
    {
        private EvaluationManager evaluator = new EvaluationManager();
        private PositionInText pos = new PositionInText();
        private Id id = new Id("1", new PositionInText());

        [TestMethod]
        public void Evaluate_And_True_Test()
        {
            Expression left = new Bool(true, pos);
            Expression right = new Bool(true, pos);

            Expression and = new And(left, right, pos);

            Assert.IsTrue(((Bool)evaluator.Evaluate(and)).GetValue());
        }

        [TestMethod]
        public void Evaluate_And_False_Test()
        {
            Expression left = new Bool(true, pos);
            Expression right = new Bool(false, pos);

            Expression and = new And(left, right, pos);

            Assert.IsFalse(((Bool)evaluator.Evaluate(and)).GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_True_Test()
        {
            Expression left = new Bool(true, pos);
            Expression right = new Bool(false, pos);

            Expression or = new Or(left, right, pos);

            Assert.IsTrue(((Bool)evaluator.Evaluate(or)).GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_False_Test()
        {
            Expression left = new Bool(false, pos);
            Expression right = new Bool(false, pos);

            Expression or = new Or(left, right, pos);

            Assert.IsFalse(((Bool)evaluator.Evaluate(or)).GetValue());
        }

    }
}
