package lang.ql.semantics;

import java.util.Stack;

/**
 * Created by bore on 16/02/15.
 */
public class ErrorLogger
{
    private Stack<RuntimeException> exceptions;
    private Stack<RuntimeException> warnings;

    public ErrorLogger()
    {
        this.exceptions = new Stack<RuntimeException>();
        this.warnings = new Stack<RuntimeException>();
    }

    public Stack<RuntimeException> getExceptions()
    {
        return this.exceptions;
    }

    public Stack<RuntimeException> getWarnings()
    {
        return this.warnings;
    }

    public void logException(RuntimeException ex)
    {
        this.exceptions.push(ex);
    }

    public void logWarning(RuntimeException ex)
    {
        this.warnings.push(ex);
    }
}
