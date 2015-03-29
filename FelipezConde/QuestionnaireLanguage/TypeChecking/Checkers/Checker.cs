using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TypeChecking.Checkers
{
    public abstract class Checker
    {
        //contains the notifications detected before going into this state, can be used for precondition checking
        protected INotificationManager preconditions;

        public Checker(INotificationManager currentState)
        {
            preconditions = currentState;
        }
    }
}
