package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */
public class FontSizeValue extends AValue<Integer> {

    public FontSizeValue(int fontSize){
        super(fontSize, Type.FONT_SIZE);
    }
}
