package com.econo.hackday.contentsproxyblog.utils;

import org.junit.Test;

public class EgitUtilsTest {

    EgitUtils egitUtils = new EgitUtils();

    @Test
    public void getReadmeContents() throws Exception {
        System.out.println(egitUtils.getReadmeContents("https://github.com/JNU-econovation/contents-proxy-blog-team2"));
    }
}