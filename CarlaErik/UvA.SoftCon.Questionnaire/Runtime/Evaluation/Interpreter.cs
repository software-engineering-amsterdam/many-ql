using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation
{
    internal class Interpreter : QLVisitor<object>
    {
        private IDictionary<string, Value> _variables = new Dictionary<string, Value>();

        public IDictionary<string, Value> AvailableQuestions
        {
            get;
            private set;
        }

        public void Interpretet(QuestionForm form, IDictionary<string, Value> answers)
        {
            _variables = answers;
            AvailableQuestions = new Dictionary<string, Value>();

            Visit(form);
        }

        public override object Visit(BooleanQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(DateQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(IntegerQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(StringQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(IfStatement ifStatement)
        {
            Value result = ifStatement.If.Accept(new ExpressionInterpreter(_variables));

            if (!result.IsUndefined)
            {
                if (((BooleanValue)result).Val)
                {
                    foreach (var statement in ifStatement.Then)
                    {
                        statement.Accept(this);
                    }
                }
                else
                {
                    foreach (var statement in ifStatement.Else)
                    {
                        statement.Accept(this);
                    }
                }
            }
            return null;
        }

        private object VisitQuestion(Question question)
        {
            Value result = new Undefined();

            if (question.IsComputed)
            {
                result = question.Expression.Accept(new ExpressionInterpreter(_variables));
            }

            AvailableQuestions.Add(question.Id.Name, result);
            return null;
        }
    }
}
