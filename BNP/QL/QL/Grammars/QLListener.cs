using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL;
using QL.Model;


namespace QL.Grammars
{
    public class QLListener : QLBaseListener
    {
        NodeMapper mapper;
        public QLListener()
        {
            mapper = new NodeMapper();
        }
        public override void EnterBlock(QLParser.BlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterBlock(context);
        }
        public override void ExitBlock(QLParser.BlockContext context)
        {
            base.ExitBlock(context);
            mapper.HandleNode<QL.Model.Block>();

        }

        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterFormBlock(context);
        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {
            base.ExitFormBlock(context);
            mapper.HandleNode<QL.Model.Form>();
        }

        public override void EnterControlBlock(QLParser.ControlBlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterControlBlock(context);
        }
        public override void EnterQuestionUnit(QLParser.QuestionUnitContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterQuestionUnit(context);
        }
        public override void EnterStatementUnit(QLParser.StatementUnitContext context)
        {

            mapper.InitializeNewLevel();

            base.EnterStatementUnit(context);
        }
        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            base.ExitQuestionUnit(context);
            mapper.HandleNode<QuestionUnit>();

        }
        public override void ExitControlBlock(QLParser.ControlBlockContext context)
        {
            base.ExitControlBlock(context);
            mapper.HandleNode<QL.Model.ControlBlock>();

        }
        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            base.ExitStatementUnit(context);
            mapper.HandleNode<QL.Model.StatementUnit>();

        }

    }

    
}
