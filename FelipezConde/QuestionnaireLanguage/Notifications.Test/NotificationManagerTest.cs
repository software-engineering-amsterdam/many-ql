using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Notifications.Test
{
    [TestClass]
    public class NotificationManagerTest
    {

        [TestMethod]
        public void AddNotification_Adds_Notification()
        {
            var manager = new NotificationManager();
            Assert.IsTrue(manager.GetNotifications().Count == 0);
            
            manager.AddNotification(new DummyError());
            Assert.IsTrue(manager.GetNotifications().Count == 1);

        }
        [TestMethod]
        public void AddNotifications_Adds_Notifications()
        {
            var manager = new NotificationManager();
            Assert.IsTrue(manager.GetNotifications().Count == 0);
            
            manager.AddNotifications(new List<INotification>{
                new DummyError(), new DummyError(), new DummyWarning()
            });

            Assert.IsTrue(manager.GetNotifications().Count == 3);

        }
        [TestMethod]
        public void HasError_Returns_True_On_Error()
        {
            var manager = new NotificationManager();
            Assert.IsFalse(manager.HasError());

            manager.AddNotifications(new List<INotification>{
                new DummyError()
            });

            Assert.IsTrue(manager.HasError());
        }
        [TestMethod]
        public void HasError_Returns_False_on_Warnings()
        {
            var manager = new NotificationManager();
            Assert.IsFalse(manager.HasError());

            manager.AddNotifications(new List<INotification>{
                new DummyWarning()
            });

            Assert.IsFalse(manager.HasError());
        }
        [TestMethod]
        public void Combine_combines_Notifications()
        {
            var manager1 = new NotificationManager();
            var manager2 = new NotificationManager();

            manager1.AddNotifications(new List<INotification>{
                new DummyError(), new DummyError(), new DummyError()
            });
            manager2.AddNotifications(new List<INotification>{
                new DummyError(), new DummyError()
            });

            int count1 = manager1.GetNotifications().Count;
            int count2 = manager2.GetNotifications().Count;
            
            manager1.Combine(manager2);
            int countComb = manager1.GetNotifications().Count;
                        
            Assert.IsTrue(countComb == count1 + count2);
        }

    }
}
