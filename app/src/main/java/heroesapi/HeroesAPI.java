package heroesapi;

import java.util.ArrayList;
import java.util.Map;

import model.Heroes;
import model.LoginSignupResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HeroesAPI {


    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHero(@FieldMap Map<String, String> map);


    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("heroes")
    Call<ArrayList<Heroes>> getAllHeroes();

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginSignupResponse> checkUser(@Field("username") String username, @Field("password") String password);

}