package nl.uva.softwcons.qls.validation.questionidentifier.error;

import static nl.uva.softwcons.ql.ast.I18n.i;

import java.util.Set;
import java.util.stream.Collectors;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.validation.Error;

public class MissingQuestionIdentifier extends Error {

    public MissingQuestionIdentifier(Set<Identifier> identifiers) {
        super(i("validation.errors.qls.missingidentifier",
                String.join(",", identifiers.stream().map(id -> id.getName()).collect(Collectors.toList()))));

    }

}
