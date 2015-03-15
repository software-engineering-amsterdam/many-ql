package edu;

import java.util.Optional;

/**
 * Created by Steven Kok on 15/03/2015.
 */
public class ArgumentParserResult {

    private final String QLFileLocation;
    private final Optional<String> QLSFileLocation;

    public ArgumentParserResult(String qlFileLocation, Optional<String> qlsFileLocation) {
        QLFileLocation = qlFileLocation;
        QLSFileLocation = qlsFileLocation;
    }

    public Optional<String> getQLSFileLocation() {
        return QLSFileLocation;
    }

    public String getQLFileLocation() {
        return QLFileLocation;
    }
}
