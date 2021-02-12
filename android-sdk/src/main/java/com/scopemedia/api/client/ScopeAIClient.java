package com.scopemedia.api.client;

import com.scopemedia.api.dto.request.AddMediaRequest;
import com.scopemedia.api.dto.request.PredictionRequest;
import com.scopemedia.api.dto.request.SimilarImageRequest;

import com.scopemedia.api.dto.response.AddMediaResponse;
import com.scopemedia.api.dto.response.GetMediaResponse;
import com.scopemedia.api.dto.response.ModelResponse;
import com.scopemedia.api.dto.response.PredictionResponse;
import com.scopemedia.api.dto.response.SimilarImageResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeAIClient {
    /**
     * Returns all media files form your similar images pool
     * @param page
     * @param size
     * @return {@link GetMediaResponse}
     */
    ScopeAIClientImpl.RequestBuilder<GetMediaResponse> getMedias(int page, int size);

    /**
     * Create a request to upload new media files to your similar images pool
     * Returns all media files you added to your similar images pool
     * @param request {@link AddMediaRequest}
     * @return {@link AddMediaResponse}
     */
    ScopeAIClientImpl.RequestBuilder<AddMediaResponse> addMedias(AddMediaRequest request);

    /**
     * returns similar images based on an input image
     * @param request {@link SimilarImageRequest}
     * @return {@link SimilarImageResponse}
     */
    ScopeAIClientImpl.RequestBuilder<SimilarImageResponse> getSimilarImages(SimilarImageRequest request);

    /**
     * returns predictions based on an input image
     * @param request {@link PredictionRequest}
     * @return {@link PredictionResponse}
     */
    ScopeAIClientImpl.RequestBuilder<PredictionResponse> getPrediction(PredictionRequest request);

    /**
     * returns all prediction models including public and private models of the user
     * @return {@link ModelResponse}
     */
    ScopeAIClientImpl.RequestBuilder<ModelResponse> getModels();
}