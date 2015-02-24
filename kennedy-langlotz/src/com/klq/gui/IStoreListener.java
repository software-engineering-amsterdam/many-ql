package com.klq.gui;

import com.klq.logic.question.Id;

import java.util.List;

/**
 * Created by Timon on 24.02.2015.
 */
public interface IStoreListener {

    void storeUpdated(List<Id> changed);
}
