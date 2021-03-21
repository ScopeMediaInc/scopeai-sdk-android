package com.scopemedia.scopeai.client;

import com.scopemedia.scopeai.client.ScopeAIClientImpl.RequestBuilder;
import com.scopemedia.scopeai.dto.request.AddMediaRequest;
import com.scopemedia.scopeai.dto.request.MatchingImageRequest;
import com.scopemedia.scopeai.dto.request.PredictionRequest;
import com.scopemedia.scopeai.dto.request.SimilarImageRequest;

import com.scopemedia.scopeai.dto.response.AddMediaResponse;
import com.scopemedia.scopeai.dto.response.GetMediaResponse;
import com.scopemedia.scopeai.dto.response.MatchingImageResponse;
import com.scopemedia.scopeai.dto.response.ModelResponse;
import com.scopemedia.scopeai.dto.response.PredictionResponse;
import com.scopemedia.scopeai.dto.response.SimilarImageResponse;

import java.util.Map;

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
    RequestBuilder<GetMediaResponse> getMedias(int page, int size);

    /**
     * Create a request to upload new media files to your similar images pool
     * Returns all media files you added to your similar images pool
     * @param request {@link AddMediaRequest}
     * @return {@link AddMediaResponse}
     */
    RequestBuilder<AddMediaResponse> addMedias(AddMediaRequest request);

    /**
     * returns similar images based on an input image
     * @param request {@link SimilarImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<SimilarImageResponse> getSimilarImages(SimilarImageRequest request);

    /**
     * returns similar images based on an input image
     * @param request {@link Map<String, String>, @link SimilarImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<SimilarImageResponse> getSimilarImages(Map<String, String> headers, SimilarImageRequest request);

    /**
     * returns matching images based on an input image
     * @param request {@link MatchingImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<MatchingImageResponse> getMatchingImages(MatchingImageRequest request);

    /**
     * returns matching images based on an input image
     * @param request {@link Map<String, String>, @link MatchingImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<MatchingImageResponse> getMatchingImages(Map<String, String> headers, MatchingImageRequest request);

    /**
     * returns predictions based on an input image
     * @param request {@link PredictionRequest}
     * @return {@link PredictionResponse}
     */
    RequestBuilder<PredictionResponse> getPrediction(PredictionRequest request);

    /**
     * returns all prediction models including public and private models of the user
     * @return {@link ModelResponse}
     */
    RequestBuilder<ModelResponse> getModels();
}