using AST;
using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;
using TypeChecking.Checkers;

namespace TypeChecking.Test.Checkers
{
    [TestClass]
    public class LabelCheckerTest
    {
        PositionInText position = new PositionInText();
        NotificationManager manager = new NotificationManager();

        [TestMethod]
        public void Get_Duplicate_Label_Warnings()
        {
            LabelChecker labelChecker = new LabelChecker();

            Assert.IsTrue(manager.GetNotifications().Count == 0);

            List<FormObject> formObjects = new List<FormObject>();
            formObjects.Add(CreateQuestion("id1", "label1", null));
            formObjects.Add(CreateQuestion("id2", "label1", null));

            INotificationManager notificationManager = labelChecker.AnalyzeAndReport(formObjects);

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
