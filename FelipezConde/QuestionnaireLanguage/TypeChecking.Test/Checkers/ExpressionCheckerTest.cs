using AST;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.FormObjects;
using AST.Nodes.Literals;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TypeChecking.Checkers;
using Types = AST.Types;

namespace TypeChecking.Test.Checkers
{
    [TestClass]
    public class ExpressionCheckerTest
    {
        PositionInText position = new PositionInText();
        NotificationManager manager = new NotificationManager();

        [TestMethod]
        public void Conditional_Expression_Is_BoolType_True_Test()
        {
            List<FormObject> formObjects = new List<FormObject>();

            Expression and = new And(
                new Bool(false,position), 
                new Bool(true,position), 
                position);

            Conditional conditional = new Conditional(and, null, position);

            formObjects.Add(conditional);

            ExpressionContainerChecker expressionContainerChecker = new ExpressionContainerChecker(manager,null);
            INotificationManager notificationManager =  expressionContainerChecker.AnalyzeAndReport(formObjects);

            Assert.IsTrue(notificationManager.GetNotifications().Count == 0);

        }

        [TestMethod]
        public void Conditional_Expression_Is_BoolType_InCorrect_Test()
        {
            List<FormObject> formObjects = new List<FormObject>();

            Expression and = new Add(
                new Int(2, position),
                new Int(1, position),
                position);

            Conditional conditional = new Conditional(and, null, position);

            formObjects.Add(conditional);

            ExpressionContainerChecker expressionContainerChecker = new ExpressionContainerChecker(manager, null);
            INotificationManager notificationManager = expressionContainerChecker.AnalyzeAndReport(formObjects);

            Assert.IsTrue(notificationManager.GetNotifications().Count == 1);

        }

        [TestMethod]
        public void Conditional_Expression_Arguments_Are_Compatible_Correct_Test()
        {
            List<FormObject> formObjects = new List<FormObject>();

            Expression greaterThan = new GreaterThan(
                new Int(2, position),
                new Int(1, position),
                position);

            Conditional conditional = new Conditional(greaterThan, null, position);
            formObjects.Add(conditional);

            ExpressionContainerChecker expressionContainerChecker = new ExpressionContainerChecker(manager, null);
            INotificationManager notificationManager = expressionContainerChecker.AnalyzeAndReport(formObjects);

            Assert.IsTrue(notificationManager.GetNotifications().Count == 0);

        }

        [TestMethod]
        public void Conditional_Expression_Arguments_Are_Compatible_Incorrect_Test()
        {
            List<FormObject> formObjects = new List<FormObject>();

            Expression greaterThan = new GreaterThan(
                new Int(2, position),
                new Bool(true, position),
                position);

            Conditional conditional = new Conditional(greaterThan, null, position);
            formObjects.Add(conditional);

            ExpressionContainerChecker expressionContainerChecker = new ExpressionContainerChecker(manager, null);
            INotificationManager notificationManager = expressionContainerChecker.AnalyzeAndReport(formObjects);

            Assert.IsTrue(notificationManager.GetNotifications().Count == 1);

        }

        private Question CreateQuestion(string id, string label, Expression computation)
        {
            return new Question(
                new Id(id, position),
                new Types.BoolType(),
                new Label(label, position),
                computation,
                position
                );

        }
    }
}
