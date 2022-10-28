package ir.znu.sad.ui.service;

import ir.znu.sad.ui.MainPageManager;
import ir.znu.sad.ui.html.HtmlGenerator;
import ir.znu.sad.ui.html.HtmlTableTools;
import ir.znu.sad.ui.html.Table;
import ir.znu.sad.ui.html.TableOfProduct;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("/")
public class MainHandler {

    @GET
    @Produces("text/html;charset=utf-8")
    @Consumes("text/plain;charset=utf-8")
    public String mainPage() throws IOException {
        return getMainPageHtml();
    }

    public String getMainPageHtml() throws IOException {
//        String[] fields=new String[]{"Name","Price"};
//        Table<String> table=new Table<>("SaleItems",fields);
//        table.addRow(new String[]{"item 1","1230"});
//        table.addRow(new String[]{"item 2","7847"});

        return HtmlGenerator.getHtml(new String[]{
                HtmlTableTools.getTableHeadStyle(),
                HtmlGenerator.getLinkHtmlTag("Log in","login"),
                HtmlGenerator.getHeaderHtml("List of available items"),
                HtmlTableTools.getTableHtml(
                        TableOfProduct.getTable("Top Product", MainPageManager.getTopViewedProducts())
                )
        });
    }
}
