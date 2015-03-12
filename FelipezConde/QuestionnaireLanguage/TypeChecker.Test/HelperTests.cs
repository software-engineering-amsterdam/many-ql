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

namespace TypeChecker.Test
{
    [TestClass]
    public class HelperTester
    {
        [TestMethod]
        public void ContainsError_Returns_False_On_Warning()
        {
            List<INotification> NoError = new List<INotification> { 
                new DuplicateLabel("bogus", new List<PositionInText>())
            };

            Assert.IsFalse(Helper.ContainsError(NoError));
        }
        [TestMethod]
        public void ContainsError_Returns_True_On_Error()
        {
            List<INotification> NoError = new List<INotification> { 
                new UndefinedIdentifier(new PositionInText(), "bogus")
            };

            Assert.IsTrue(Helper.ContainsError(NoError));
        }
        [TestMethod]
        public void GetDefinedIdentifiers_Returns_Correct_Identifier_Count()
        {
            PositionInText p = new PositionInText();

            List<IFormObject> ls = new List<IFormObject> {
                CreateBogusQuestion(new Id("1", p), new Types.StringType()), 
                CreateBogusQuestion(new Id("2", p), new Types.StringType()), 
                CreateBogusQuestion(new Id("3", p), new Types.StringType()),
                new Conditional(null, 
                    new List<IFormObject>
                    {  
                       CreateBogusQuestion(new Id("4", p), new Types.StringType()),
                       CreateBogusQuestion(new Id("5", p), new Types.StringType())
                    }, new PositionInText()
                )
            };
            
            var x = Helper.GetDefinedIdentifiers(new Form(ls, new PositionInText()));

            Assert.AreEqual(x.Count, 5);

        }
        public Question CreateBogusQuestion(Id id, Types.Type type)
        {
            return new Question(id, type,
                        new Label("", new PositionInText()),
                        null,
                        new PositionInText()
                );
        }
        [TestMethod]
        public void GetIdentifierTypes_Returns_Correct_Identifier_Count()
        {
            PositionInText p = new PositionInText();

            List<IFormObject> ls = new List<IFormObject> {
                CreateBogusQuestion(new Id("1", p), new Types.StringType()), 
                CreateBogusQuestion(new Id("2", p), new Types.StringType()), 
                CreateBogusQuestion(new Id("3", p), new Types.StringType()),
                new Conditional(null, 
                    new List<IFormObject>
                    {  
                       CreateBogusQuestion(new Id("4", p), new Types.StringType()),
                       CreateBogusQuestion(new Id("5", p), new Types.StringType())
                    }, new PositionInText()
                )
            };
            
            var x = Helper.GetIdentifierTypes(new Form(ls, new PositionInText()));

            Assert.AreEqual(x.Count, 5);
        }

        [TestMethod]
        public void GetIdentifierTypes_Returns_Correct_Identifiers()
        {
            PositionInText p = new PositionInText();
            Id[] ids = new Id[]{
                    new Id("1", p),
                    new Id("2", p),
                    new Id("3", p),
                    new Id("4", p),
                    new Id("5", p)
            };

            List<IFormObject> ls = new List<IFormObject> {
                CreateBogusQuestion(ids[0], new Types.StringType()), 
                CreateBogusQuestion(ids[1], new Types.StringType()), 
                CreateBogusQuestion(ids[2], new Types.StringType()),
                new Conditional(null, 
                    new List<IFormObject>
                    {  
                       CreateBogusQuestion(ids[3], new Types.StringType()),
                       CreateBogusQuestion(ids[4], new Types.StringType())
                    }, new PositionInText()
                )
            };
            
            var x = Helper.GetIdentifierTypes(new Form(ls, new PositionInText()));

            foreach(Id id in ids)
            {
                Assert.IsTrue(x.ContainsKey(id));
            }
        }


    }
}
