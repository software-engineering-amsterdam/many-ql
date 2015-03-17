package com.kls.ast.node;

import com.common.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class AGroupNodeBase extends ANodeBase {
    private final String title;
    private final List<QuestionNode> questions;
    private final DefaultNode defaultNode;

    public AGroupNodeBase(String title, List<QuestionNode> questions, DefaultNode def, Location location) {
        super(location);
        this.title = title;
        this.questions = questions;
        this.defaultNode = def;
    }

    public String getTitle() {
        return title;
    }

    public List<QuestionNode> getQuestions() {
        return questions;
    }

    public DefaultNode getDefaultNode() {
        return defaultNode;
    }
}
