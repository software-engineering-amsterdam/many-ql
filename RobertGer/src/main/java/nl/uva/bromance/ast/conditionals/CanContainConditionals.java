package nl.uva.bromance.ast.conditionals;

import java.util.List;
import java.util.Optional;

/**
 * Created by Robert on 2/22/2015.
 */
public interface CanContainConditionals {

    Optional<IfStatement> getIfsStatement();

    void setIfStatement(IfStatement ifs);

    Optional<List<ElseIfStatement>> getElseIfStatement();

    void setElseIfStatement(ElseIfStatement eifs);

    Optional<ElseStatement> getElseStatement();

    void setElseStatement(ElseStatement es);
}
