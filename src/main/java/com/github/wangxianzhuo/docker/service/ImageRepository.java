package com.github.wangxianzhuo.docker.service;

import com.github.wangxianzhuo.common.OkHttpHelper;
import com.github.wangxianzhuo.docker.model.Image;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.catalina.ssi.SSIStopProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Image Repository
 * Created by shangjie
 * 16-8-23
 */
@Component
public class ImageRepository {
    private static final Logger LOG = LoggerFactory.getLogger(OkHttpHelper.class);
    private static OkHttpClient client = new OkHttpClient();
    @Value("${server.host}")
    String baseUrl;

    public Image all() {
        String url = baseUrl + "/images/json";
        Request request = new Request.Builder().url(url).get().build();


//        Reader reader;
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//            reader = new BufferedReader(response.body().charStream());
//            String result = "";
//            char[] buffer = new char[1024];
//            while (reader.read(buffer) != -1) {
//                result += new String(buffer);
//            }
//            System.out.println(result);
//        } catch (IOException e) {
//            LOG.error(e.getMessage(), e);
//        } finally {
//            if (response != null) {
//                response.body().close();
//            }
//        }
//
//        return "";
        return (Image) OkHttpHelper.execute(request, new TypeToken<Image>(){}.getType());
    }
}
