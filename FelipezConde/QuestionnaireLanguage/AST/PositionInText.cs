using Antlr4.Runtime;
using System;

namespace AST
{
    public struct PositionInText
    {
        public int StartLine, EndLine, StartColumn, EndColumn;
        
        public PositionInText(int StartLine, int EndLine, int StartColumn, int EndColumn)
        {
            this.StartLine = StartLine;
            this.EndLine = EndLine;
            this.StartColumn = StartColumn;
            this.EndColumn = EndColumn;
        }

        public PositionInText(ParserRuleContext context)
        {
            this.StartLine = context.Start.Line;
            this.EndLine = context.Stop.Line;
            this.StartColumn = context.Start.Column;
            this.EndColumn =  context.Stop.Column;
        }

        public override string ToString()
        {
            return String.Format("lines [ {0} (character position: {1}), {2} (character position: {3})",
                            new object[] { 
                                this.StartLine,
                                this.StartColumn,
                                this.EndLine,
                                this.EndColumn
                            }
                        );
        }

    }
}
