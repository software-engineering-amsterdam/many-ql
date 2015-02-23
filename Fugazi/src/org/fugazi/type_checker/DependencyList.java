package org.fugazi.type_checker;

import org.fugazi.ast.expression.literal.ID;

import java.util.ArrayList;
import java.util.List;

public class DependencyList {

    private final List<Dependency> dependecies;

    public DependencyList() {
        this.dependecies = new ArrayList<Dependency>();
    }

    public List<ID>getIds() {
        List<ID> ids = new ArrayList<ID>();
        for (Dependency dependency : this.dependecies) {
            ids.add(dependency.getDependee());
        }
        return ids;
    }

    // get the list of items ID depends on
    public List<ID> getIdDependencies(ID id) {
        int idx = this.indexOf(id);
        if (idx == -1) {
            return null;
        }
        return this.dependecies.get(idx).getDependants();
    }

    // add a new dependant for id
    public void addIdDependenant(ID id, ID dependant) {
        int idx = this.indexOf(id);
        if (idx == -1) {
            this.dependecies.add(new Dependency(id));
            idx = this.indexOf(id);
        }
        this.dependecies.get(idx).addDependant(dependant);
        return;
    }

    private int indexOf(ID id) {
        int idx = 0;
        for (Dependency dependency : this.dependecies) {
            if (id.getName().equals(dependency.getDependee().getName())){
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public String toString() {
        String returnString = "";
        for (Dependency dependency : this.dependecies) {
            returnString += "\n" + dependency.getDependee().toString()
                    + dependency.getDependants().toString();
        }
        return returnString;
    }
}
