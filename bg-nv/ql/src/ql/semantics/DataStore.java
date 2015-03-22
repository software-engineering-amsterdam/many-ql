package ql.semantics;

import ql.ast.form.Form;

/**
 * Created by Nik on 22-03-2015
 */
public abstract class DataStore
{
    protected final StoreItems storeItems;

    public DataStore(Form ast, ValueTable valueTable)
    {
         this.storeItems = new StoreItems(ast, valueTable);
    }

    public abstract void store();
}
