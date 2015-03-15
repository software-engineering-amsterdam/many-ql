using AST.Nodes.Expression;
using AST.Nodes.Expression.Binary;
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
            IExpression left = new Bool(true);
            IExpression right = new Bool(true);

            IExpression and = new And(left, right, pos);

            Assert.IsTrue(((Bool)evaluator.Evaluate(and)).GetValue());
        }

        [TestMethod]
        public void Evaluate_And_False_Test()
        {
            IExpression left = new Bool(true);
            IExpression right = new Bool(false);

            IExpression and = new And(left, right, pos);

            Assert.IsFalse(((Bool)evaluator.Evaluate(and)).GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_True_Test()
        {
            IExpression left = new Bool(true);
            IExpression right = new Bool(false);

            IExpression or = new Or(left, right, pos);

            Assert.IsTrue(((Bool)evaluator.Evaluate(or)).GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_False_Test()
        {
            IExpression left = new Bool(false);
            IExpression right = new Bool(false);

            IExpression or = new Or(left, right, pos);

            Assert.IsFalse(((Bool)evaluator.Evaluate(or)).GetValue());
        }

    }
}
