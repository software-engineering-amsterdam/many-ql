package qls.ast;

import qls.ast.statement.Statement;

import java.util.Collection;

/**
 * Created by Nik on 10-3-15.
 */
public interface RenderableParent
{
    public Collection<Statement> getRenderableChildren();
}
