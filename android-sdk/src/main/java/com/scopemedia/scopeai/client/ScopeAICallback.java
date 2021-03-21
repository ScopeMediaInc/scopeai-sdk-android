package com.scopemedia.scopeai.client;

import com.scopemedia.scopeai.dto.response.ScopeAIResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeAICallback<T extends ScopeAIResponse> {
    void onScopeResponse(T response);
    void onScopeFailure(Throwable throwable);
}
