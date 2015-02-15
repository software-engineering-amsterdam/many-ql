package org.uva.student.calinwouter.qlqls.qls.components;

import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

public class SimpleInterop implements IComponent {
    @Override
    public AbstractPushable<?> interop(Object... args) {
//        String names[] = getClass().getName().split(".");
//        System.out.print(names[names.length - 1]);
//        for (Object arg : args) {
//            System.out.print(", " + arg);
//        }
//        System.out.println();
        return new AbstractPushable<Object>(null) {};
    }
}
