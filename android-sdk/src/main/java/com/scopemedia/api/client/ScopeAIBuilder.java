package com.scopemedia.api.client;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Maikel Rehl on 6/7/2017.
 */

public class ScopeAIBuilder {
    private String appId;
    private String clientId;
    private String clientSecret;
    private boolean debugMode = false;
    private HttpLoggingInterceptor.Level debugLevel = HttpLoggingInterceptor.Level.BASIC;

    public static final String DEFAULT_APP_ID = "fashion";
    private static final String baseUrl = "https://api.scopemedia.com/";

    /**
     * Create a new {@link ScopeAIBuilder} object with the DEFAULT_APP_ID = 'fashion'
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     */
    public ScopeAIBuilder(String clientId, String clientSecret) {
        this(clientId, clientSecret, DEFAULT_APP_ID);
    }

    /**
     * Create a new ScopeCheckBuilder object
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     * @param appId set your AppID
     */
    public ScopeAIBuilder(String clientId, String clientSecret, String appId) {
        this.appId = appId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Enable the debug mode for all requests and responds
     * @param enable true or false
     * @return ScopeCheckBuilder
     */
    public ScopeAIBuilder setDebugMode(boolean enable) {
        this.debugMode = enable;
        return this;
    }

    /**
     * Set the debugging level
     * @param level {@link okhttp3.logging.HttpLoggingInterceptor.Level}
     * @return ScopeCheckBuilder
     */
    public ScopeAIBuilder setDebugLevel(HttpLoggingInterceptor.Level level) {
        this.debugLevel = level;
        return this;
    }

    /**
     * Build the client
     * @return {@link ScopeAIClient}
     */
    public ScopeAIClient build() {
        return new ScopeAIClientImpl(this);
    }

    /**
     * @return returns the API Base URL
     */
    protected String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @return returns the AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @return returns the ClientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @return returns the ClientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @return returns if the debug mode is enabled
     */
    public boolean getDebugMode() {
        return debugMode;
    }

    /**
     * @return returns the debug {@link okhttp3.logging.HttpLoggingInterceptor.Level}
     */
    public HttpLoggingInterceptor.Level getDebugLevel() {
        return debugLevel;
    }
}