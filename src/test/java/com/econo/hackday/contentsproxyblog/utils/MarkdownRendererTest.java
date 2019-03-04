package com.econo.hackday.contentsproxyblog.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarkdownRendererTest {
    @Test
    public void md에서html파싱테스트() {
        String markdown = "This is *Bellroute*";

        assertThat("<p>This is <em>Bellroute</em></p>\n", CoreMatchers.is(MarkdownRenderer.parseToHtml(markdown)));
    }
}