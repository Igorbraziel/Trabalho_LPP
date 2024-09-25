package Utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CompilerRegex {
    public Pattern classPatt = Pattern.compile("^\\s*class\\s+\\w+$");
    public Pattern varsPatt = Pattern.compile("^(\\s*vars\\s+\\w+(\\s*,\\s*\\w+)*)$");
    public Pattern methodPatt = Pattern.compile("^(\\s*method\\s+\\w+\\((\\w*(\\s*,\\s*\\w+\\s*)*)\\)\\s*)$");
}
