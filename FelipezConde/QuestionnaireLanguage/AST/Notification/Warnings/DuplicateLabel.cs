using AST.Helpers;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Notification
{
    public class DuplicateLabel : IWarning
    {
        private readonly string label;
        private readonly IEnumerable<PositionInText> positions;

        public DuplicateLabel(string label, IEnumerable<PositionInText> positions)
        {
            this.label = label;
            this.positions = positions;
        }

        public string Message()
        {
            return string.Format("Duplicated label \"{0}\" at {1}",
                    label,
                    Position.PrettyPrint(positions)
                );
        }
    }
}
