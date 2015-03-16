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
using AST.Nodes.BaseExpression;
using Types = AST.Types;
using AST.Nodes.Literals;

namespace TypeChecker.Test
{
    [TestClass]
    public class TypeCheckManagerTests
    {
        private PositionInText pos = new PositionInText();

        [TestMethod]
        public void IsTypeCorrect_Returns_True_If_Typecorrect()
        {
            var x =TypeCheckManager.IsTypeCorrect(CorrectForm());

            Assert.IsTrue(x);
        }

        [TestMethod]
        public void IsTypeCorrect_Returns_False_If_Typecorrect()
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
                             new Bool(true), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.IntType(),
                             new Label("", pos),
                             new Int(3), 
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
                             new Bool(true), 
                             pos
                             ),
                new Question(new Id("2", pos), 
                             new Types.BoolType(),
                             new Label("", pos),
                             new Int(3), 
                             pos
                             )
            };

            return new Form(formBody, new PositionInText());
        }

    }
}
