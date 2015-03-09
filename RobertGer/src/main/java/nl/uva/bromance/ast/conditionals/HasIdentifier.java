package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Identifier;

import java.util.Optional;

/**
 * Created by Robert on 9-3-2015.
 */

//TODO: maybe move to different package
public interface HasIdentifier {

    //TODO: Remove optional, syntax error will be given if no identifier is presented.R
    Optional<Identifier> getIdentifier();
}
