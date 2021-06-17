package com.sincalexandrudaniel.data.remote;

import com.sincalexandrudaniel.data.remote.Exception.ApiException;
import com.sincalexandrudaniel.data.remote.Exception.ConnectivityException;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpSuccessInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        Response response;
        try {
            response = chain.proceed(request);
        } catch (IOException exception) {
            throw new ConnectivityException(exception.getMessage());
        }
        if (!response.isSuccessful()) {
            throw new ApiException(response.code());
        }
        return response;
    }
}
