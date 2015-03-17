package com.klq.typechecker;

import com.klq.ast.impl.expr.literal.IdentifierNode;

import java.util.*;

/**
 * Created by juriaan on 2-3-15.
 */
public class CyclicDetector {
    private Map<IdentifierNode, Set<IdentifierNode>> dependencies;
    private Map<IdentifierNode, Set<IdentifierNode>> fullDependencies;

    public CyclicDetector() {
        this.dependencies = new HashMap<>();
        this.fullDependencies = new HashMap<>();
    }

    public void addKey(IdentifierNode key){
        if(!dependencies.containsKey(key)) {
            dependencies.put(key, new HashSet<>());
        }
    }

    public void addDependency(IdentifierNode key, IdentifierNode dependency){
        if(dependencies.containsKey(key)){
            dependencies.get(key).add(dependency);
        }
    }

    public boolean hasCycles(){

        for(Map.Entry<IdentifierNode, Set<IdentifierNode>> entry : fullDependencies.entrySet()){
             if( entry.getValue().contains(entry.getKey())){
                 return true;
             }
        }
        return false;
    }

    public void calculateFullDependencies(){
        fullDependencies = new HashMap<>();

        for(Map.Entry<IdentifierNode, Set<IdentifierNode>> entry : dependencies.entrySet()){
            fullDependencies.put(entry.getKey(), findDependencies(entry.getValue(), new ArrayList<>()));
        }
    }

    public List<IdentifierNode> getCyclicIds(){
        List<IdentifierNode> list = new ArrayList<>();
        for(Map.Entry<IdentifierNode, Set<IdentifierNode>> entry : fullDependencies.entrySet()){
            if( entry.getValue().contains(entry.getKey())){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private Set<IdentifierNode> findDependencies(Set<IdentifierNode> set, List<IdentifierNode> visited){
        Set<IdentifierNode> newSet = new HashSet<>();
        newSet.addAll(set);

        for(IdentifierNode item : set){
            if(!visited.contains(item)) {
                visited.add(item);
                newSet.addAll(findDependencies(dependencies.get(item), visited));
            }
        }
        return newSet;
    }
}
