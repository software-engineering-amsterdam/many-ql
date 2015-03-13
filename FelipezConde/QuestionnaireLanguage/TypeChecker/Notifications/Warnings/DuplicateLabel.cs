using AST.Helpers;
using AST.Representation;
using Notifications;
using System.Collections.Generic;

namespace TypeChecker.Notifications.Warnings
{
    public class DuplicateLabel : Warning
    {
        private readonly string label;
        private readonly IEnumerable<PositionInText> positions;

        public DuplicateLabel(string label, IEnumerable<PositionInText> positions)
        {
            this.label = label;
            this.positions = positions;
        }

        public override string Message()
        {
            return string.Format("Duplicated label \"{0}\" at {1}",
                    label,
                    Position.PrettyPrint(positions)
                );
        }
    }
}
