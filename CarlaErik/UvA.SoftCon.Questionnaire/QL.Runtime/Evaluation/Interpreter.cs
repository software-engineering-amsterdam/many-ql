using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation
{
    internal class Interpreter : TopDownQuestionFormVisitor<object>
    {
        private ValueTable _context;
        private ValueTable _results;

        public ValueTable Interpretet(QuestionForm form, ValueTable context)
        {
            _context = context;
            _results = new ValueTable();

            Visit(form);

            return _results;
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
            Value result = ifStatement.If.Accept(new ExpressionInterpreter(_context));

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
                result = question.Expression.Accept(new ExpressionInterpreter(_context));
            }

            _results.Add(question.Id.Name, result);
            return null;
        }
    }
}
