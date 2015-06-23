using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Notifications;
using AST;

namespace TypeChecking.Test
{
    [TestClass]
    public class MainTypeCheckerTests
    {
        [TestMethod]
        public void Refuse_If_AST_Has_Errors_Reported()
        {
            NotificationManager manager = new NotificationManager();
            Assert.IsTrue(manager.GetNotifications().Count == 0);

            manager.AddNotification(new DummyError());
            var x = MainTypeChecker.GetTypeCheckDiagnosis(new ASTResult(null, manager));

            Assert.IsTrue(x.NotificationManager.GetNotifications().Count == manager.GetNotifications().Count);
        }
    }
}
