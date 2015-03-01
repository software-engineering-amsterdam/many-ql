using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        AstHandler Ast;
        Dictionary<string, IVisitable> references;

        public EvaluatorVisitor()
        {
            references = new Dictionary<string, IVisitable>();
        }

       
        public void Enter(IVisitable node)
        {
            node.Accept(this);
        }

     
        public void visit(Form node) {
            
        }
        public void visit(Block node)
        {
            
        }
        public void visit(ControlUnit node)
        {
                       
        }

        public void visit(StatementUnit node)
        { 

        
        }
        public void visit(QuestionUnit node) { }
        public void visit(Expression node) { }
        public void visit(EqualsOperator node) { }
        public void visit(NotEqualsOperator node) { }
        public void visit(PlusOperator node) { }

        public void visit(Number node) { }

        public void visit(Yesno node) { }

        public void visit(Identifier node) { }

        public void visit(Text node) { }

        public void visit(ElementBase node){
        throw new QLException("Not implemented: "+node.GetType().ToString() );
        }


    }
}
