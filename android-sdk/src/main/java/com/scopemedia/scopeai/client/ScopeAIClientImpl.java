package com.scopemedia.scopeai.client;

import com.scopemedia.scopeai.dto.ScopeAIMissingArgumentException;
import com.scopemedia.scopeai.dto.model.Header;
import com.scopemedia.scopeai.dto.request.AddMediaRequest;
import com.scopemedia.scopeai.dto.request.MatchingImageRequest;
import com.scopemedia.scopeai.dto.request.SimilarImageRequest;
import com.scopemedia.scopeai.dto.request.PredictionRequest;
import com.scopemedia.scopeai.dto.response.AddMediaResponse;
import com.scopemedia.scopeai.dto.response.GetMediaResponse;
import com.scopemedia.scopeai.dto.response.MatchingImageResponse;
import com.scopemedia.scopeai.dto.response.ModelResponse;
import com.scopemedia.scopeai.dto.response.ScopeAIResponse;
import com.scopemedia.scopeai.dto.response.SimilarImageResponse;
import com.scopemedia.scopeai.dto.response.PredictionResponse;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by maikel on 2017-03-27.
 */

class ScopeAIClientImpl implements ScopeAIClient {
    private ScopeAIService service;

    /**
     *  Use by {@link ScopeAIBuilder} to initialise a new {@link ScopeAIClient}
     * @param builder {@link ScopeAIBuilder}
     */
    protected ScopeAIClientImpl(ScopeAIBuilder builder) {

        final String clientId = builder.getClientId();
        final String clientSecret = builder.getClientSecret();
        final String clientNode = builder.getClientNode();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Client-Id", clientId)
                        .addHeader("Client-Secret", clientSecret)
                        .addHeader("Client-Node", clientNode);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        if (builder.getDebugMode()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(builder.getDebugLevel());
            httpClient.addInterceptor(loggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.getBaseUrl())
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.service = retrofit.create(ScopeAIService.class);
    }

    /**
     *  Use by {@link ScopeAIBuilder} to initialise a new {@link ScopeAIClient}
     * @param builder {@link ScopeAIBuilder}
     * @param timeout in second
     */
    protected ScopeAIClientImpl(ScopeAIBuilder builder, long timeout) {

        final String clientId = builder.getClientId();
        final String clientSecret = builder.getClientSecret();
        final String clientNode = builder.getClientNode();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (timeout > 0) {
            httpClient.connectTimeout(timeout, TimeUnit.SECONDS);
            httpClient.readTimeout(timeout, TimeUnit.SECONDS);
            httpClient.writeTimeout(timeout, TimeUnit.SECONDS);
        }
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader(Header.CLIENT_ID, clientId)
                        .addHeader(Header.CLIENT_SECRET, clientSecret)
                        .addHeader(Header.CLIENT_NODE, clientNode);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        if (builder.getDebugMode()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(builder.getDebugLevel());
            httpClient.addInterceptor(loggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.getBaseUrl())
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.service = retrofit.create(ScopeAIService.class);
    }

    @Override
    public RequestBuilder<GetMediaResponse> getMedias(int page, int size) {
        return new RequestBuilder<>(service.getMedias(page, size));
    }

    @Override
    public RequestBuilder<AddMediaResponse> addMedias(AddMediaRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a media array");
        return new RequestBuilder<>(service.addMedias(request));
    }

    @Override
    public RequestBuilder<SimilarImageResponse> getSimilarImages(SimilarImageRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a mediaId or mediaUrl or base64");
        return new RequestBuilder<>(service.getSimilarImages(request));
    }

    @Override
    public RequestBuilder<SimilarImageResponse> getSimilarImages(Map<String, String> headers, SimilarImageRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a mediaId or mediaUrl or base64");
        return new RequestBuilder<>(service.getSimilarImages(headers, request));
    }

    @Override
    public RequestBuilder<MatchingImageResponse> getMatchingImages(MatchingImageRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a mediaId or mediaUrl or base64");
        return new RequestBuilder<>(service.getMatchingImages(request));
    }

    @Override
    public RequestBuilder<MatchingImageResponse> getMatchingImages(Map<String, String> headers, MatchingImageRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a mediaId or mediaUrl or base64");
        return new RequestBuilder<>(service.getMatchingImages(headers, request));
    }

    @Override
    public RequestBuilder<PredictionResponse> getPrediction(PredictionRequest request) {
        if (!request.checkAllRequired()) throw new ScopeAIMissingArgumentException("Please set a (mediaUrl or base64) and a modelId");
        return new RequestBuilder<>(service.getPrediction(request));
    }

    @Override
    public RequestBuilder<ModelResponse> getModels() {
        return new RequestBuilder<>(service.getModels());
    }

    /**
     * RequestBuilder class for all response classes extends {@link ScopeAIResponse}
     * @param <T> extends {@link ScopeAIResponse}
     */
    public static class RequestBuilder<T extends ScopeAIResponse> {
        private Call<T> call;

        /**
         * Create a new Request
         * @param call set the {@link Call} for any response class which extends {@link ScopeAIResponse}
         */
        private RequestBuilder(Call<T> call) {
            this.call = call;
        }

        /**
         * Perform request synchronous
         * @return Response object extends {@link ScopeAIResponse}
         * @throws IOException
         */
        public T performSync() throws IOException {
            return performCallSync(call);
        }

        /**
         * Perform request asynchronous
         * @param callback set a {@link ScopeAICallback} with any response class which extends {@link ScopeAIResponse}
         */
        public void performAsync(ScopeAICallback<T> callback) {
            performCallAsync(call, callback);
        }

        /**
         * Perform OkHttp call synchronous
         * @param call {@link Call}
         * @return Response object extends {@link ScopeAIResponse}
         * @throws IOException
         */
        private T performCallSync(Call<T> call) throws IOException {
            Response<T> response = call.execute();
            return response.body();
        }

        /**
         * Perform OkHttp call asynchronous
         * @param call {@link Call}
         * @param callback set a {@link ScopeAICallback} with any response class which extends {@link ScopeAIResponse}
         */
        private void performCallAsync(Call<T> call, final ScopeAICallback<T> callback) {
            call.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    callback.onScopeResponse(response.body());
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    callback.onScopeFailure(t);
                }
            });
        }
    }
}