using Antlr4.Runtime;
using AST.ParseTreeVisitors;
using Notifications;

namespace AST
{
    public class ParserErrorListener : BaseErrorListener
    {
        public INotificationManager NotificationManager { get; private set; }

        public ParserErrorListener()
        {
            NotificationManager = new NotificationManager();
        }
        
        public override void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            NotificationManager.AddNotification(
                new ParseError (
                    string.Format("line {0} : {1} at {2} : {3}", line, charPositionInLine, offendingSymbol, msg)
                    ));
        }
    }
}
