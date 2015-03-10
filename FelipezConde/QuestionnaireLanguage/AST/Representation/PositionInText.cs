using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Representation
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

    }
}
