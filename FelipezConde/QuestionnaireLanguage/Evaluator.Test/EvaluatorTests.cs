using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Evaluation;
using AST.Nodes.Interfaces;
using AST;
using AST.Nodes.Expressions;
using Values = Evaluation.Values;
using Literals = AST.Nodes.Literals;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;

namespace Evaluator.Test
{
    [TestClass]
    public class EvaluatorTests
    {
        private Evaluation.Evaluator evaluator = new Evaluation.Evaluator(new SymbolTable());
        private PositionInText pos = new PositionInText();
        private Id id = new Id("1", new PositionInText());

        private Literals.Bool CreateBoolLiteral(bool value)
        {
            return new Literals.Bool(value, pos);
        }

        private Literals.String CreateStringLiteral(string value)
        {
            return new Literals.String(value, pos);
        }

        private Literals.Int CreateIntLiteral(int value)
        {
            return new Literals.Int(value, pos);
        }

        #region Bool
        [TestMethod]
        public void Evaluate_And_True_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(true);

            Expression and = new And(left, right, pos);

            Values.Bool value = ((Values.Bool)and.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_And_False_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(false);

            Expression and = new And(left, right, pos);

            Values.Bool value = ((Values.Bool)and.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_True_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(false);

            Expression or = new Or(left, right, pos);

            Values.Bool value = ((Values.Bool)or.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Or_False_Test()
        {
            Expression left = CreateBoolLiteral(false);
            Expression right = CreateBoolLiteral(false);

            Expression or = new Or(left, right, pos);

            Values.Bool value = ((Values.Bool)or.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Equal_Bool_True_Test()
        {
            Expression left = CreateBoolLiteral(false);
            Expression right = CreateBoolLiteral(false);

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Equal_Bool_False_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(false);

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_Bool_True_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(false);

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_Bool_False_Test()
        {
            Expression left = CreateBoolLiteral(true);
            Expression right = CreateBoolLiteral(true);

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Negate_Bool_True_Test()
        {
            Expression expression = CreateBoolLiteral(false);

            Expression negate = new Negate(expression, pos);

            Values.Bool value = ((Values.Bool)negate.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        #endregion

        #region Int
        [TestMethod]
        public void Evaluate_Add_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(1);

            Expression add = new Add(left, right, pos);

            Values.Int value = ((Values.Int)add.Accept(evaluator));

            Assert.IsTrue(value.GetValue() == 2);
        }

        [TestMethod]
        public void Evaluate_Substract_Positive_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(1);

            Expression substract = new Subtract(left, right, pos);

            Values.Int value = ((Values.Int)substract.Accept(evaluator));

            Assert.IsTrue(value.GetValue() == 1);
        }

        [TestMethod]
        public void Evaluate_Substract_Negative_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression substract = new Subtract(left, right, pos);

            Values.Int value = ((Values.Int)substract.Accept(evaluator));

            Assert.IsTrue(value.GetValue() == -1);
        }

        [TestMethod]
        public void Evaluate_Divide_Test()
        {
            Expression left = CreateIntLiteral(4);
            Expression right = CreateIntLiteral(2);

            Expression divide = new Divide(left, right, pos);

            Values.Int value = ((Values.Int)divide.Accept(evaluator));

            Assert.IsTrue(value.GetValue() == 2);
        }

        [TestMethod]
        public void Evaluate_Multiply_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(2);

            Expression multiply = new Multiply(left, right, pos);

            Values.Int value = ((Values.Int)multiply.Accept(evaluator));

            Assert.IsTrue(value.GetValue() == 4);
        }

        [TestMethod]
        public void Evaluate_Equal_Int_True_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(1);

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Equal_Int_False_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_Int_True_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_Int_False_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(1);

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_GreaterThan_Int_True_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(1);

            Expression greaterThan = new GreaterThan(left, right, pos);

            Values.Bool value = ((Values.Bool)greaterThan.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_GreaterThan_Int_False_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression greaterThan = new GreaterThan(left, right, pos);

            Values.Bool value = ((Values.Bool)greaterThan.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_GreaterOrEqual_Int_True_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(1);

            Expression greaterOrEqual = new GreaterThanOrEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)greaterOrEqual.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_GreaterOrEqual_Int_False_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression greaterOrEqual = new GreaterThanOrEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)greaterOrEqual.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_LessThan_Int_True_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression lessThan = new LessThan(left, right, pos);

            Values.Bool value = ((Values.Bool)lessThan.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_LessThan_Int_False_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(1);

            Expression lessThan = new LessThan(left, right, pos);

            Values.Bool value = ((Values.Bool)lessThan.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_LessOrEqual_Int_True_Test()
        {
            Expression left = CreateIntLiteral(1);
            Expression right = CreateIntLiteral(2);

            Expression lessOrEqual = new LessThanOrEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)lessOrEqual.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_LessOrEqual_Int_False_Test()
        {
            Expression left = CreateIntLiteral(2);
            Expression right = CreateIntLiteral(1);

            Expression lessOrEqual = new LessThanOrEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)lessOrEqual.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }
        #endregion

        #region String

        [TestMethod]
        public void Evaluate_Equal_String_True_Test()
        {
            Expression left = CreateStringLiteral("equal");
            Expression right = CreateStringLiteral("equal");

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_Equal_String_False_Test()
        {
            Expression left = CreateStringLiteral("equal");
            Expression right = CreateStringLiteral("notEqual");

            Expression equal = new Equal(left, right, pos);

            Values.Bool value = ((Values.Bool)equal.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_String_True_Test()
        {
            Expression left = CreateStringLiteral("equal");
            Expression right = CreateStringLiteral("notEqual");

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsTrue(value.GetValue());
        }

        [TestMethod]
        public void Evaluate_NotEqual_String_False_Test()
        {
            Expression left = CreateStringLiteral("notEqual");
            Expression right = CreateStringLiteral("notEqual");

            Expression notEqual = new NotEqual(left, right, pos);

            Values.Bool value = ((Values.Bool)notEqual.Accept(evaluator));

            Assert.IsFalse(value.GetValue());
        }

        #endregion
    }
}
