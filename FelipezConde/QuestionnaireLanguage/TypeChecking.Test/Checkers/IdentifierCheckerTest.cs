using AST;
using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.FormObjects;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TypeChecking.Checkers;
using Types = AST.Types;
using AST.Nodes.Literals;

namespace TypeChecking.Test.Checkers
{
    [TestClass]
    public class IdentifierCheckerTest
    {
        PositionInText position = new PositionInText();
        NotificationManager manager = new NotificationManager();

        [TestMethod]
        public void Has_Duplicate_Identifiers_Test()
        {
            IdentifierChecker identifier = new IdentifierChecker(manager);

            Assert.IsTrue(manager.GetNotifications().Count == 0);

            List<FormObject> formObjects = new List<FormObject>();
            formObjects.Add(CreateQuestion("id1", "label1", null));
            formObjects.Add(CreateQuestion("id1", "label2", null));

            INotificationManager notificationManager = identifier.AnalyzeAndReport(new Form(formObjects, position));

            Assert.IsTrue(notificationManager.GetNotifications().Count == 1);
        }

        [TestMethod]
        public void Has_Undefined_Identifiers_Test()
        {
            IdentifierChecker identifier = new IdentifierChecker(manager);
            Assert.IsTrue(manager.GetNotifications().Count == 0);

            Id id = new Id("id3", position);
            id.SetType(new Types.BoolType());

            Expression computed = new And(
                new Bool(true, position),
                id,
                position);

            List<FormObject> formObjects = new List<FormObject>();
            formObjects.Add(CreateQuestion("id1", "label1", computed));

            INotificationManager notificationManager = identifier.AnalyzeAndReport(new Form(formObjects, position));

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
