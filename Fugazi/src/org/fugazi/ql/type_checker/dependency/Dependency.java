package org.fugazi.ql.type_checker.dependency;

import org.fugazi.ql.ast.expression.literal.ID;

import java.util.ArrayList;
import java.util.List;

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
    }
}
