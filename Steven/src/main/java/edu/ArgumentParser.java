package edu;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Optional;

/**
 * Created by Steven Kok on 15/03/2015.
 */
public class ArgumentParser {
    public ArgumentParserResult parse(String[] args) throws InvalidArgumentException {
        if (args.length == 1) {
            return new ArgumentParserResult(args[0], Optional.empty());
        } else if (args.length == 2) {
            return new ArgumentParserResult(args[0], Optional.of(args[1]));
        } else if (args.length < 1) {
            throw new InvalidArgumentException(new String[]{"Not enough arguments."});
        } else {
            throw new InvalidArgumentException(new String[]{"To many arguments."});
        }
    }
}
