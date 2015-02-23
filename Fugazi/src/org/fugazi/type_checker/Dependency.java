package org.fugazi.type_checker;

import org.fugazi.ast.expression.literal.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukaszharezlak on 23/02/15.
 */
public class Dependency {

    private final ID dependee;
    private final List<ID> dependants;

    public Dependency(ID _dependee) {
        this.dependee = _dependee;
        this.dependants = new ArrayList<ID>();
    }

    public ID getDependee() {
        return this.dependee;
    }

    public List<ID> getDependants() {
        return this.dependants;
    }

    public void addDependant(ID _dependant) {
        this.dependants.add(_dependant);
        return;
    }
}
