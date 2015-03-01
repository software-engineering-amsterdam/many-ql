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
        Dictionary<int, IVisitable> References;//change  ivisitable to ievaluatable
        Dictionary<string, IVisitable> DeclaredVariables;


        public EvaluatorVisitor()
        {
            References = new Dictionary<int, IVisitable>();
            DeclaredVariables= new Dictionary<string, IVisitable>();

        }

        void DeclareNewVariable(string key, IVisitable node){
            if (DeclaredVariables.ContainsKey(key))
            {
                //just put it somewhere into list of warnings
                throw new RedeclaredVariableWarning("Redeclared variable: " + key);
            }

            DeclaredVariables[key] = node;

        }

        public void Enter(IVisitable node)
        {
            node.Accept(this);
        }

     
        public void visit(Form node) {
            DeclareNewVariable(node.Identifier.Value, node);
        }
        public void visit(Block node)
        {

             
        }
        public void visit(ControlUnit node)
        {
        }

        public void visit(StatementUnit node)
        {
            DeclareNewVariable(node.Identifier.Value, node);

        }
        public void visit(QuestionUnit node) {
            DeclareNewVariable(node.Identifier.Value, node);
        }
        public void visit(Expression node) {
            References[node.GetHashCode()] = References[node.Children[0].GetHashCode()];
        }
        public void visit(EqualsOperator node) {
            //todo bool returnvalue= (References[node.Left.GetHashCode()].Value == References[node.Right.GetHashCode()].Value);
        }

        public void visit(NotEqualsOperator node) { }
        //todo rest of the operators
        public void visit(PlusOperator node) { }

        public void visit(Number node)
        {
            References[node.GetHashCode()] = node;

            
        }

        public void visit(Yesno node) {
            References[node.GetHashCode()] = node;
        }

        public void visit(Identifier node) {
            if (DeclaredVariables.ContainsKey(node.Value)){
                References[node.Value.GetHashCode()]=DeclaredVariables[node.Value];
            }
            
        }

        public void visit(Text node) {
            References[node.GetHashCode()] = node;
        }

        public void visit(ElementBase node){
        throw new QLException("Not implemented: "+node.GetType().ToString() );
        }


    }
}
