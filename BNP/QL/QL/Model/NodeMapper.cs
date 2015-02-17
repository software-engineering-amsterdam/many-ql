using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Tree;
using QL.Grammars;
using QL.Model.Terminals;

namespace QL.Model
{
    public sealed class NodeMapper
    {
        List<ElementBase> level;
        public NodeMapper(){
        }

        public UnitBase Create(QLParser.UnitContext context)
        {
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
        

        // todo: move to own mapper
        public Form Create(QLParser.FormBlockContext context)
        {
            throw new NotImplementedException();
        }

        //public IEnumerable<ElementBase> ExtractChilds();

        internal void Create(Antlr4.Runtime.ParserRuleContext context)
        {
            throw new NotImplementedException();
        }
    }
}
