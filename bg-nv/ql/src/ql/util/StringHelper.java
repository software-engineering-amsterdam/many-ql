package ql.util;

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

    public static String printStrValueList(Iterable<String> c, String delimiter)
    {
        StringBuilder builder = new StringBuilder();

        for (String s : c)
        {
            builder.append(s);
            builder.append(delimiter);
        }

        if (builder.length() < 2)
        {
            return "";
        }

        return builder.substring(0, builder.length() - 2);
    }
}
