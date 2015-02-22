package nl.uva.bromance.typechecking;

import nl.uva.bromance.AST.Node;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Robert on 2/21/2015.
 */
public interface TypeCheckable {

    void typeCheck(Map<String, Node> references) throws TypeCheckingException;
}
