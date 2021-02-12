package com.scopemedia.api.client;

import com.scopemedia.api.dto.request.AddMediaRequest;
import com.scopemedia.api.dto.request.PredictionRequest;
import com.scopemedia.api.dto.request.SimilarImageRequest;
import com.scopemedia.api.dto.response.AddMediaResponse;
import com.scopemedia.api.dto.response.GetMediaResponse;
import com.scopemedia.api.dto.response.ModelResponse;
import com.scopemedia.api.dto.response.PredictionResponse;
import com.scopemedia.api.dto.response.SimilarImageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by maikel on 2017-03-27.
 */

interface ScopeAIService {

    @GET("simile/v2/medias")
    Call<GetMediaResponse> getMedias(@Query("page") int page, @Query("size") int size);

    @POST("simile/v2/medias")
    Call<AddMediaResponse> addMedias(@Body AddMediaRequest request);

    @POST("simile/v2/search")
    Call<SimilarImageResponse> getSimilarImages(@Body SimilarImageRequest request);

    @POST("tag/v2/tagging")
    Call<PredictionResponse> getPrediction(@Body PredictionRequest request);

    @GET("tag/v2/models")
    Call<ModelResponse> getModels();
}