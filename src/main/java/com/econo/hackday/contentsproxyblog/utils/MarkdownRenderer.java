package com.econo.hackday.contentsproxyblog.utils;


import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class MarkdownRenderer {

    public static String parseToHtml(String markdown) {
        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(markdown);

        return renderer.render(document);
    }
}
