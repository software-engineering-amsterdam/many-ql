using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Grammars
{
    public class QLListener : QLBaseListener
    {

        public override void EnterEveryRule(Antlr4.Runtime.ParserRuleContext context)
        {//first
            Console.WriteLine("or this? Enter:" + context.GetType().Name);
            
            base.EnterEveryRule(context);
        }
        public override void ExitEveryRule(Antlr4.Runtime.ParserRuleContext context)
        {

            Console.WriteLine("Exit:"+context.GetType().Name);

            base.ExitEveryRule(context);
        }
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {//second
            Console.WriteLine("is this first Enter:" + context.GetType().Name);

            base.EnterFormBlock(context);
        }
        public override void ExitControlBlock(QLParser.ControlBlockContext context)
        {
            Console.WriteLine("Exit:" + context.GetType().Name);
            base.ExitControlBlock(context);
        }
    }
}
