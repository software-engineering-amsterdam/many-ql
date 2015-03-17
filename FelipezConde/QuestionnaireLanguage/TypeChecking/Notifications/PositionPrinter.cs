using AST;
using System.Collections.Generic;
using System.Linq;

namespace Notifications
{
    public static class PositionPrinter
    {
        public static string PrettyPrint(IEnumerable<PositionInText> positions)
        {
            return positions.Aggregate(
                                "positions: ",
                                (res, next) => res + ", " + next.ToString()
                             );
        }
    }
}
