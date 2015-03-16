package org.fugazi.ql.type_checker.dependency;

import org.fugazi.ql.ast.expression.literal.ID;

import java.util.*;


public class DependencyManager {

    private final Map<ID, List<ID>> dependecies;

    public DependencyManager() {
        this.dependecies = new HashMap<>();
    }

    public Set<ID> getIds() {
        return this.dependecies.keySet();
    }

    public List<ID> getIdDependencies(ID id) {
        return this.dependecies.get(id);
    }

    public List<String> getIdDependencyNames(ID id) {
        List<String> names = new ArrayList<>();
        if (this.dependecies.get(id) != null) {
            for (ID dependency : this.dependecies.get(id)) {
                names.add(dependency.getName());
            }
        }
        return names;
    }

    public void addIdDependenant(ID id, ID dependant) {
        List<ID> dependandtsList = this.dependecies.get(id);
        if (dependandtsList == null) {
            dependandtsList = new ArrayList<>();
        }
        dependandtsList.add(dependant);
        this.dependecies.put(id, dependandtsList);
    }

    public String toString() {
        String returnString = "";
        for (ID dependee : this.dependecies.keySet()) {
            returnString += "\n" + dependee.toString()
                    + this.dependecies.get(dependee).toString();
        }
        return returnString;
    }
}
