package ql.util;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by bore on 12/03/15.
 */
public class StringHelper
{
    public static String unescapeString(String s)
    {
        if (s.length() < 2)
        {
            return s;
        }

        String result = s.substring(1, s.length()-1);
        return result.replace("\\\"", "\"");
    }

    public static String printStrValueList(Collection<String> c, String delimiter)
    {
        return c.stream().collect(Collectors.joining(delimiter));
    }
}
