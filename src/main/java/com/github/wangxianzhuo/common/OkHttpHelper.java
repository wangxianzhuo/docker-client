package com.github.wangxianzhuo.common;

import com.google.gson.JsonParseException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * okhttp helper.
 *
 * @author Yang XuePing
 */
public final class OkHttpHelper {
    private static final Logger LOG = LoggerFactory.getLogger(OkHttpHelper.class);
    private static OkHttpClient client = new OkHttpClient();

    public static Object execute(Request request, Type type) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return GsonHelper.DEFAULT_GSON.fromJson(response.body().charStream(), type);
            } else {
                throw new ServiceException(GsonHelper.DEFAULT_GSON.fromJson(response.body().charStream(), ErrorMsg.class).getMessage());
            }
        } catch (IOException e) {
            LOG.error("请求接口IO异常", e);
            throw new ServiceException("接口服务器异常");
        } catch (JsonParseException e) {
            LOG.error("请求接口IO异常", e);
            throw new ServiceException("接口服务器数据异常");
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    public static <T> T execute(Request request, Class<T> clazz) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return GsonHelper.DEFAULT_GSON.fromJson(response.body().charStream(), clazz);
            } else {
                throw new ServiceException(GsonHelper.DEFAULT_GSON.fromJson(response.body().charStream(), ErrorMsg.class).getMessage());
            }
        } catch (IOException e) {
            LOG.error("请求接口IO异常", e);
            throw new ServiceException("接口服务器异常");
        } catch (JsonParseException e) {
            LOG.error("请求接口IO异常", e);
            throw new ServiceException("接口服务器数据异常");
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    public static void execute(Request request) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ServiceException(GsonHelper.DEFAULT_GSON.fromJson(response.body().charStream(), ErrorMsg.class).getMessage());
            }
        } catch (IOException e) {
            LOG.error("请求接口IO异常", e);
            throw new ServiceException("接口服务器异常");
        } catch (JsonParseException e) {
            LOG.error("请求接口IO异常请求接口IO异常", e);
            throw new ServiceException("接口服务器数据异常");
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }
}
