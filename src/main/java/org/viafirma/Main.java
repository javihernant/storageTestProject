package org.viafirma;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;

public class Main {
    public static void testPing(StorageService service) throws IOException {
        Call<ResponseBody> call = service.ping();
        String response = call.execute().body().string();
        System.out.println(response);
    }

    public static String testSaveObject(StorageService service, String operationId) throws IOException {
        String filePath = "./src/main/resources/dummy.pdf";
        Path path = Paths.get(filePath);
        // Read the file into a byte array
        byte[] data = Files.readAllBytes(path);
        System.out.println("operationID:" + operationId);
        //creating request
        SaveObjectRequest saveObjectRequest = new SaveObjectRequest();
        saveObjectRequest.setOperationId(operationId);
        saveObjectRequest.setObjectName("objectname");
        saveObjectRequest.setObjectReference("test");
        saveObjectRequest.setSourceApplication("test");
        saveObjectRequest.setObjectLength(data.length);
        saveObjectRequest.setMetadata(Arrays.asList(new MetadataItem("key", "value", MetadataItemType.TYPE_STRING)));

        //creating file
        MediaType mediaType = MediaType.parse("application/pdf");  // Adjust based on file type
        RequestBody fileBody = RequestBody.create(mediaType, data);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", null, fileBody);

        //post of request + file
        Call<ResponseBody> call = service.saveObject(filePart, saveObjectRequest);
        String response = call.execute().body().string();
        Gson gson = new Gson();
        StorageResponse storageResponse=gson.fromJson(response, StorageResponse.class);

        return storageResponse.getObjectId();
    }

    private static void writeBytesToFile(byte[] data, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, data);
    }

    public static void testFetchObject(StorageService service, String objectId) throws IOException {
        System.out.println("Fetching (" + objectId + ")...");
        Call<ResponseBody> call = service.fetchObject(objectId);
        byte[] data = call.execute().body().bytes();
        writeBytesToFile(data, "downloaded.pdf");
    }

    public static void testQuery(StorageService service, String operationId) throws IOException {
        QueryMetadataRequest metadataRequest = new QueryMetadataRequest();
        metadataRequest.setFilters(Arrays.asList(new QueryMetadataFilterItem("operation_id",operationId, "LIKE")));
        System.out.println(metadataRequest);
        Call<ResponseBody> call = service.queryMetadata(metadataRequest);
        String response = call.execute().body().string();

        System.out.println(response);
    }

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StorageService service = retrofit.create(StorageService.class);

        testPing(service);
        String operationId= UUID.randomUUID().toString();
        String objectId = testSaveObject(service, operationId);
        testFetchObject(service, objectId);
        testQuery(service,operationId);
    }
}