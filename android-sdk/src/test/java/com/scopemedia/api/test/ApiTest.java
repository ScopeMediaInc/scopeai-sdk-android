package com.scopemedia.api.test;

import com.scopemedia.api.client.ScopeAIBuilder;
import com.scopemedia.api.client.ScopeAIClient;
import com.scopemedia.api.dto.model.Area;
import com.scopemedia.api.dto.model.Media;
import com.scopemedia.api.dto.model.Model;
import com.scopemedia.api.dto.model.Tag;
import com.scopemedia.api.dto.request.PredictionRequest;
import com.scopemedia.api.dto.request.SimilarImageRequest;
import com.scopemedia.api.dto.response.GetMediaResponse;
import com.scopemedia.api.dto.response.ModelResponse;
import com.scopemedia.api.dto.response.PredictionResponse;
import com.scopemedia.api.dto.response.SimilarImageResponse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Maikel Rehl on 6/8/2017.
 */

public class ApiTest {

    private static final String CLIENT_ID = "demo";
    private static final String CLIENT_SECRET = "demotestsecret";
    private ScopeAIClient client;

    private Area area = new Area(320, 520, 340, 750);
    private String imageUrl = "https://cdn-images.farfetch-contents.com/11/84/74/89/11847489_8709666_1000.jpg";

    @Before
    public void init() {
        client = new ScopeAIBuilder(CLIENT_ID, CLIENT_SECRET)
                .setDebugMode(true)
                .setDebugLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
    }

    @Test
    public void getMedias() {
        try {
            GetMediaResponse response = client.getMedias(0,20).performSync();;
            Media[] medias = response.getMedias();
            for (Media media : medias)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void getModels() {
        try {
            ModelResponse response = client.getModels().performSync();
            Model[] models = response.getModels();
            for (Model model : models)
                System.out.println(model.getName() + "\tisPublic: " + model.isPublicModel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPrediction() {
        PredictionRequest request = new PredictionRequest();
        request.setMediaAsUrl(imageUrl);
        request.setModelId("general-v3");

        try {
            PredictionResponse response = client.getPrediction(request).performSync();
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPredictionArea() {
        PredictionRequest request = new PredictionRequest();
        request.setMediaAsUrl(imageUrl);
        request.setArea(area);
        request.setModelId("general-v3");

        try {
            PredictionResponse response = client.getPrediction(request).performSync();
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSimilar() {
        SimilarImageRequest request = new SimilarImageRequest();
        request.setMediaAsUrl(imageUrl);
        request.setAppId("fashion");

        try {
            SimilarImageResponse response = client.getSimilarImages(request).performSync();
            Media[] mediaList = response.getMedias();
            for (Media media : mediaList)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSimilarArea() {
        SimilarImageRequest request = new SimilarImageRequest();
        request.setMediaAsUrl(imageUrl);
        request.setArea(area);
        request.setAppId("fashion");

        try {
            SimilarImageResponse response = client.getSimilarImages(request).performSync();
            Media[] mediaList = response.getMedias();
            for (Media media : mediaList)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
