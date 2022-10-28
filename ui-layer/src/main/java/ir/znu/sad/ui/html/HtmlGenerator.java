package ir.znu.sad.ui.html;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HtmlGenerator {


    public static String getHtml(String[] innerHtmlItems){
        return "<html>"+ Arrays.stream(innerHtmlItems).collect(Collectors.joining("\n"))+"</html>";
    }

    public static String getHeaderHtml(String headerText){
        return "<h2>"+headerText+"</h2>";
    }

    public static String getLinkHtmlTag(String caption, String link) {
        return "<a href=\""+link+"\">"+caption+"</a>";
    }

    public static String getNewLineHtmlTag() {
        return "<br>";
    }
}
