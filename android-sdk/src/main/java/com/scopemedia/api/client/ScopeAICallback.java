package com.scopemedia.api.client;

import com.scopemedia.api.dto.response.ScopeResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeAICallback<T extends ScopeResponse> {
    void onScopeResponse(T response);
    void onScopeFailure(Throwable throwable);
}
