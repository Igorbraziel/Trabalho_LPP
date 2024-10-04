package Utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CompilerRegex {
    public static Pattern classPatt = Pattern.compile("^\\s*class\\s+\\w+$");
    public static Pattern varsPatt = Pattern.compile("^(\\s*vars\\s+\\w+(\\s*,\\s*\\w+)*)$");
    public static Pattern methodPatt = Pattern.compile("^(\\s*method\\s+\\w+\\((\\w*(\\s*,\\s*\\w+\\s*)*)\\)\\s*)$");
    public static Pattern beginPatt = Pattern.compile("^\\s*(begin)\\s*$");
    public static Pattern ioPatt = Pattern.compile("^\\s*(io.print\\(\\s*\\w+\\s*\\))$");
    public static Pattern selfPatt = Pattern.compile("self\\.\\w+");
    public static Pattern endPatt = Pattern.compile("^\\s*end\\s*$");
    public static Pattern end_classPatt = Pattern.compile("^\\s*end-class\\s*$");
    public static Pattern end_methodPatt = Pattern.compile("^\\s*end-method\\s*$");
    public static Pattern end_ifPatt = Pattern.compile("^\\s*end-if\\s*$");
    public static Pattern ifPatt = Pattern.compile("^(\\s*if\\s+\\w+\\s+(eq|ne|gt|ge|lt|le)\\s+\\w+\\s+then\\s*)$");
    public static Pattern elsePatt = Pattern.compile("^\\s*else\\s*$");
    public static Pattern mainPatt = Pattern.compile("^\\s*main\\(\\)\\s*$");
    public static Pattern returnPatt = Pattern.compile("^\\s*return\\s+\\w+\\s*$");
    public static Pattern simpleAssignmentPatt = Pattern.compile("^\\s*\\w+\\s+=\\s+\\w+\\s*$");
    public static Pattern operatorAssignmentPatt = Pattern.compile("^(\\s*\\w+\\s+=\\s+\\w+\\s+([+\\-*/])\\s+\\w+\\s*)$");
    public static Pattern obj_creationPatt = Pattern.compile("^\\s*\\w+\\s+=\\s+new\\s+\\w+$");

}
