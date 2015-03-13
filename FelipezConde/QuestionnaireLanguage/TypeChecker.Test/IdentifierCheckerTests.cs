using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Notifications;
using System.Collections.Generic;
using TypeChecker.Notifications.Warnings;
using TypeChecker.Notifications.Errors;
using AST.Representation;
using TypeChecker;
using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Nodes.FormObject;
using AST.Nodes.Labels;
using AST.Nodes.Expression;
using Types = AST.Types;
using TypeChecker;
using AST.Nodes.Literals;

namespace TypeChecker.Test
{
    [TestClass]
    public class IdentifierCheckerTests
    {
        private PositionInText pos = new PositionInText();

        [TestMethod]
        public void Has_Duplicate_Identifiers_returns_a_notification_per_duplicate()
        {
            var checker = new PrivateObject(new IdentifierChecker(new Form(TwoDuplicates(), pos)));

            IEnumerable<INotification> notifs = (IEnumerable<INotification>)checker.Invoke("HasDuplicate_Identifiers");

            //Assert.IsTrue(notifs.GetEnumerator().)
        }

        private List<IFormObject> TwoDuplicates()
        {
            return new List<IFormObject> {
                new Question(new Id("1", pos), 
                             new Types.BoolType(),
                             new Label("", pos),
                             new Container(new Bool(true), pos), 
                             pos
                             ),
                new Question(new Id("1", pos), 
                             new Types.IntType(),
                             new Label("", pos),
                             new Container(new Int(3), pos), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.BoolType(),
                             new Label("", pos),
                             new Container(new Bool(true), pos), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.IntType(),
                             new Label("", pos),
                             new Container(new Int(3), pos), 
                             pos
                             )
            };
        }


        [TestMethod]
        public void IsTypeCorrect_Returns_True_If_Typecorrect()
        {
            var x = TypeCheckManager.IsTypeCorrect(IncorrectForm());

            Assert.IsFalse(x);
        }

        public Form CorrectForm()
        {
            var formBody = new List<IFormObject>
            {
                new Question(new Id("1", pos), 
                             new Types.BoolType(),
                             new Label("", pos),
                             new Container(new Bool(true), pos), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.IntType(),
                             new Label("", pos),
                             new Container(new Int(3), pos), 
                             pos
                             )
            };

            return new Form(formBody, new PositionInText());
        }

        public Form IncorrectForm()
        {
            var formBody = new List<IFormObject>
            {
                new Question(new Id("1", pos), 
                             new Types.IntType(),
                             new Label("", pos),
                             new Container(new Bool(true), pos), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.BoolType(),
                             new Label("", pos),
                             new Container(new Int(3), pos), 
                             pos
                             )
            };

            return new Form(formBody, new PositionInText());
        }

    }
}
