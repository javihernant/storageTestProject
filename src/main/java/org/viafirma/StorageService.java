package org.viafirma;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface StorageService {
    @GET("storage/api/query/ping")
    Call<ResponseBody> ping();

    @Multipart
    @POST("storage/api/object/save/stream")
    Call<ResponseBody> saveObject(@Part MultipartBody.Part file, @Part("request") SaveObjectRequest request);

    @GET("storage/api/object/read/{object_id}")
    Call<ResponseBody> fetchObject(@Path("object_id") String objectId );

    @POST("storage/api/query/query")
    Call<ResponseBody> queryMetadata(@Body QueryMetadataRequest request);
}
