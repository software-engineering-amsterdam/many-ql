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
        protected NodeMapper mapper;
        public QLListener()
        {
            mapper = new NodeMapper();
        }

        public bool AstExists()
        {
            return mapper.AstExists();
        }
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterFormBlock(context);
        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {
            base.ExitFormBlock(context);
            mapper.Create(context);
        }

        public override void EnterBlock(QLParser.BlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterBlock(context);
        }
        public override void ExitBlock(QLParser.BlockContext context)
        {
            base.ExitBlock(context);
            mapper.Create(context);

        }

        
        public override void EnterControlBlock(QLParser.ControlBlockContext context)
        {
            mapper.InitializeNewLevel();
            base.EnterControlBlock(context);
        }
        public override void ExitControlBlock(QLParser.ControlBlockContext context)
        {
            base.ExitControlBlock(context);
            mapper.Create(context);

        }

        public override void EnterQuestionUnit(QLParser.QuestionUnitContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterQuestionUnit(context);
        }
        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            base.ExitQuestionUnit(context);
            mapper.Create(context);

        }
        
        public override void EnterStatementUnit(QLParser.StatementUnitContext context)
        {

            mapper.InitializeNewLevel();

            base.EnterStatementUnit(context);
        }
        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            base.ExitStatementUnit(context);
            mapper.Create(context);

        }

        # region Terminals?
        public override void EnterOperator(QLParser.OperatorContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterOperator(context);
        }
        public override void ExitOperator(QLParser.OperatorContext context)
        {
            //mapper.Create(context);
            base.ExitOperator(context);
     
            
            //TODO
        }
        public override void EnterTypeName(QLParser.TypeNameContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterTypeName(context);
        }
        public override void ExitTypeName(QLParser.TypeNameContext context)
        {
            base.ExitTypeName(context);
            //TODO

        }
        public override void EnterTypeDefExt(QLParser.TypeDefExtContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterTypeDefExt(context);
        }
        public override void ExitTypeDefExt(QLParser.TypeDefExtContext context)
        {

            base.ExitTypeDefExt(context);
            //TODO

        }
        public override void EnterTypedef(QLParser.TypedefContext context)
        {
            mapper.InitializeNewLevel();

            base.EnterTypedef(context);
        }
        public override void ExitTypedef(QLParser.TypedefContext context)
        {
            base.ExitTypedef(context);
            //TODO

        }
        #endregion

    }

    
}
