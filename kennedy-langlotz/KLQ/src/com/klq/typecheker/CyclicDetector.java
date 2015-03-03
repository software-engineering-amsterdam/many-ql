package com.klq.typecheker;

import java.util.*;

/**
 * Created by juriaan on 2-3-15.
 */
public class CyclicDetector {
    private HashMap<String, Set<String>> dependencies;

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
//TODO gogogo test this, because i doubt it works lol
    public void detect(){
        ArrayList<String> cyclicList = new ArrayList<String>();

        for(Map.Entry<String, Set<String>> entry : dependencies.entrySet()){
            System.out.println(entry.getKey() + " : " + findDependencies(entry.getValue()).toString());
        }
    }

    private Set<String> findDependencies(Set<String> set){
        Set<String> newSet = set;
        for(String item : newSet){
            newSet.addAll(findDependencies(dependencies.get(item)));
        }
        return newSet;
    }
}
