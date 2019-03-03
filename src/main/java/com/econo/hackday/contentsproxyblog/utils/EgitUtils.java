package com.econo.hackday.contentsproxyblog.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.service.ContentsService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EgitUtils {

    private IRepositoryIdProvider makeIRepositoryIdProvider(String url) throws MalformedURLException {
        URL repositoryURL = new URL(url);
        String repositoryId = repositoryURL.getPath().substring(1);
        IRepositoryIdProvider iRepositoryIdProvider = new IRepositoryIdProvider() {
            @Override
            public String generateId() {
                return repositoryId;
            }
        };
        return iRepositoryIdProvider;
    }

    private String getReadmeContentBase64(IRepositoryIdProvider iRepositoryIdProvider) throws Exception {
        ContentsService contentsService = new ContentsService();
        return contentsService.getReadme(iRepositoryIdProvider).getContent();
    }

    private String encodeContents(String base64Contents) throws IOException {
        return new String(Base64.decodeBase64(base64Contents));
    }

    public String getReadmeContents(String url) throws Exception {
        return encodeContents(getReadmeContentBase64(makeIRepositoryIdProvider(url)));
    }

}
