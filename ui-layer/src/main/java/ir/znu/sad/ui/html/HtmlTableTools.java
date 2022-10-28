package ir.znu.sad.ui.html;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HtmlTableTools {

    public static <K> String getTableHtml(Table<K> table){
        StringBuilder html = new StringBuilder();
        html.append("<p>"+table.name+"</p>");
        html.append("<table>");
        html.append("<colgroup>\n" +
                "    <col span=\"1\" style=\"background-color: #D6EEEE\">\n" +
//                "    <col span=\"3\" style=\"background-color: pink\">\n" +
                "  </colgroup>");
        html.append("<thead>");
        html.append("<tr>");
        html.append("<td>Row</td>");
        Arrays.stream(table.getColumnNameList())
                .forEach(s -> html.append("<td>"+s+"</td>"));
        html.append("</tr>");
        html.append("</thead>");

        int[] rowNum = new int[]{0};
        html.append("<tbody>");
        table.getRows()
                .forEach(row -> {
                    html.append("<tr>");
                    html.append("<td>"+ ++rowNum[0] +"</td>");
                    Arrays.stream(row)
                            .forEach(a -> html.append("<td>"+ a +"</td>"));
                    html.append("</tr>");
                });
        html.append("</tbody>");

        html.append("</table>");

        return html.toString();
    }

    public static String getTableHeadStyle(){
        return "<head>\n" +
                "<style>\n" +
                "\n" +
                "table {\n" +
                "\tborder-collapse: collapse;\n" +
                "    font-family: Tahoma, Geneva, sans-serif;\n" +
                "}\n" +
                "table td {\n" +
                "\tpadding: 15px;\n" +
                "}\n" +
                "table thead td {\n" +
                "\tbackground-color: #54585d;\n" +
                "\tcolor: #ffffff;\n" +
                "\tfont-weight: bold;\n" +
                "\tfont-size: 13px;\n" +
                "\tborder: 1px solid #54585d;\n" +
                "}\n" +
                "table tbody td {\n" +
                "\tcolor: #636363;\n" +
                "\tborder: 1px solid #dddfe1;\n" +
                "}\n" +
                "table tbody tr {\n" +
                "\tbackground-color: #f9fafb;\n" +
                "}\n" +
                "table tbody tr:nth-child(odd) {\n" +
                "\tbackground-color: #ffffff;\n" +
                "}" +
               "\n"+
                "</style>\n" +
                "</head>";
    }

}
