package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */

public class ColorValue extends AValue<String> {

    public ColorValue(String hexColor){
        super(hexColor, Type.COLOR);
    }
}
