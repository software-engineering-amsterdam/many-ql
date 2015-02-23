using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Tree;
using QL.Grammars;
using QL.Model.Terminals;
using System.Diagnostics;

namespace QL.Model
{
    public sealed class NodeMapper
    {
        TreeElementBase astRootNode;

        Stack<Stack<TreeElementBase>> childrenStack;        

        public NodeMapper(){
            childrenStack = new Stack<Stack<TreeElementBase>>();
        }

        public void InitializeNewLevel() {
            childrenStack.Push(new Stack<TreeElementBase>());
        }

        List<TreeElementBase> GetChildren()
        {
            Debug.Assert(childrenStack.Count() > 0, "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            return childrenStack.Pop().ToList();
        }
        void PutIntoTree(TreeElementBase parent)
        {
            
            if (childrenStack.Count() > 0)
            {
                Stack<TreeElementBase> parents = childrenStack.Pop();
                parents.Push(parent);
                childrenStack.Push(parents);
            }
            else
            {
                //this is the last one
                astRootNode = parent;
            }
        }
        public void HandleNode<T>() where T:TreeElementBase, new ()
        {
            List<TreeElementBase> children = GetChildren();
            T parent= new T();
            parent.HandleChildren(children);
            PutIntoTree(parent);
        }

        public UnitBase Create(QLParser.UnitContext context)
        {
            throw new NotImplementedException();

            string id = context.GetChild(1).GetText();
            string question = context.GetChild(context.ChildCount - 2).GetText();
            string[] arguments = context.children.Skip(3).Select(child => child.GetText()).Take(context.ChildCount - 3 - 3).ToArray();
            bool required;
            if (arguments.Contains("required")){
               required=true; 
            }
            else{
                required=false;
            }
            QuestionUnit questionUnit = new QuestionUnit(new Identifier(id), new Text(question), required);

            return questionUnit;
            
        }
    }
}
