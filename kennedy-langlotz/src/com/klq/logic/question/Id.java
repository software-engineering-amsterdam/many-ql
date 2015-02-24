package com.klq.logic.question;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 16.02.2015.
 */
public class Id implements IKLQItem {
    private String id;

    public Id(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Id){
            return id.equals(((Id)obj).id);
        } else if (obj instanceof  String){
            return id.equals(obj);
            //TODO Does this actually work?
        }
        return false;
    }
}
