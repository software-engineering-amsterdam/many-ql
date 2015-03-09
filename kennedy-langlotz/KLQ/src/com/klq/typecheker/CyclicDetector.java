package com.klq.typecheker;

import java.util.*;

/**
 * Created by juriaan on 2-3-15.
 */
public class CyclicDetector {
    private Map<String, Set<String>> dependencies;

    public CyclicDetector() {
        this.dependencies = new HashMap<String, Set<String>>();
    }

    public void addKey(String key){
        if(!dependencies.containsKey(key)) {
            dependencies.put(key, new HashSet<String>());
        }
    }

    public void addDependency(String key, String dependency){
        if(dependencies.containsKey(key)){
            dependencies.get(key).add(dependency);
        }
    }

    public boolean hasCycles(){
        ArrayList<String> cyclicList = new ArrayList<String>();

        for(Map.Entry<String, Set<String>> entry : dependencies.entrySet()){
             if( findDependencies(entry.getValue(), new ArrayList<String>()).contains(entry.getKey())){
                 return true;
             }
        }
        return false;
    }

    private Set<String> findDependencies(Set<String> set, List<String> visited){
        Set<String> newSet = new HashSet<>();
        newSet.addAll(set);

        for(String item : set){
            if(!visited.contains(item)) {
                visited.add(item);
                newSet.addAll(findDependencies(dependencies.get(item), visited));
            }
        }
        return newSet;
    }
}
