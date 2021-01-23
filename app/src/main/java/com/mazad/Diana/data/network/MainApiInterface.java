package com.mazad.Diana.data.network;

import com.mazad.Diana.adapter.ImageResponse;
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.data.Countrys;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.DropDownResponse;
import com.mazad.Diana.data.FollowMazadResponse;
import com.mazad.Diana.data.HogozatyResponse;
import com.mazad.Diana.data.MazadResponse;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.UserResponse;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.mazad.Diana.utels.AppConstant.AUTHORIZATION;
import static com.mazad.Diana.utels.AppConstant.CONTENT_JSON;

public interface MainApiInterface {
    // 1
    @GET("sale_type")
    Observable<MainResponse<List<Sale_typeResponse>>> SaleTypePage ();

    // 2
    @GET("posts")
    Observable<MainResponse<List<CategoriesResponse>>> CategoriesPage ();

    // 3
    @GET("title?")
    Observable<MainResponse<List<DropDownResponse>>> dropDownList (@Query("category_id") int category_id);

    //4
    @Multipart
    @POST("directsale")
    Observable<MainResponse<StatusResponse>> PostDirectSalePaged(@Part MultipartBody.Part image1, @Part MultipartBody.Part image2 ,
                                                                @Part MultipartBody.Part image3
            , @Part("cate_id") RequestBody cate_id, @Part("band_rkm") RequestBody band_rkm, @Part("general_description") RequestBody general_description,
                                                                @Part("subdropdownlist") RequestBody values,
                                                                @Part("maindropdownlist") RequestBody keySet, @Part("price") RequestBody price,
                                                                @Part("publisher_id") RequestBody publisher_id, @Part("available_number") RequestBody available_number);


    // 5
    @POST("login")
    Observable<MainResponse<UserResponse>> LoginPage(@Query("mobile") String number ,@Query("password") String password);


    // 6
    @POST("allads")
    Observable<MainResponse<List<DirectAddResponse>>> listAddsPage(@Query("sale_type") int sale_type,@Query("cat_id") int cate_id);



    // 7
    @Multipart
    @POST("register")
    Observable<MainResponse<UserResponse>>  SignUpPage(
            @Part MultipartBody.Part profile_image, @Part("name") RequestBody name, @Part("email") RequestBody email
            , @Part("fame") RequestBody fame, @Part("mobile") RequestBody mobile,
            @Part("password") RequestBody password ,@Part("country") RequestBody country);


    //8
    @GET("add_details/{addId}")
    Observable<MainResponse<AddDetails>> CurrentAddDetails(@Path("addId") int addId);

    // 9
    @POST("book_product")
    Observable<MainResponse<StatusResponse>> BookAddDirectPage(@Query("add_id") int add_id ,@Query("cate_id") int cate_id,
                                                               @Query("number_products") int number_products,
                                                               @Query("publisher_id") int publisher_id);

    //10
    @GET("allbooked/{addId}")
    Observable<MainResponse<List<BookListResponse>>> MyBookList(@Path("addId") int addId);

    // 11
    @POST("acceptadds")
    Observable<MainResponse<StatusResponse>> AcceptBookedPage(@Query("id") int add_id ,@Query("publisher") int publisherId);


    // 12
    @POST("allgazna")
    Observable<MainResponse<List<DirectAddResponse>>> MyStoresPage(@Query("publisher_id") int publisher_id);


    // 13
    @POST("republish_add")
    Observable<MainResponse<StatusResponse>> rePublishAddPage(@Query("id") int add_id,@Query("publisher_id") int publisher_id,
                                                              @Query("price") double price );



    //14
    @Multipart
    @POST("mazadsale")
    Observable<MainResponse<StatusResponse>> PostMazadSalePaged(@Part MultipartBody.Part image1, @Part MultipartBody.Part image2 ,
                                                                @Part MultipartBody.Part image3, @Part("cate_id") RequestBody cate_id,
                                                                @Part("band_rkm") RequestBody band_rkm,@Part("general_description") RequestBody general_description,
                                                                @Part("subdropdownlist") RequestBody values, @Part("maindropdownlist") RequestBody keySet,
                                                                @Part("price") RequestBody price, @Part("publisher_id") RequestBody publisher_id,
                                                                @Part("add_time_state") RequestBody add_time_state, @Part("end_add_time") RequestBody end_add_time,
                                                                @Part("require_price_enddate") RequestBody require_price_enddate, @Part("right_back") RequestBody right_back,
                                                                @Part("raise") RequestBody raise, @Part("raise_rkm") RequestBody raise_rkm,
                                                                @Part("less_raise") RequestBody less_raise, @Part("enter_mazad") RequestBody enter_mazad);


    // 15
    @POST("allmazadat")
    Observable<MainResponse<List<MazadResponse>>> listMazadAddsPage(@Query("sale_type") int sale_type, @Query("cat_id") int cate_id);



    //16
    @GET("counties")
    Observable<MainResponse<List<Countrys>>> getCountryPage();

    //17
    @GET("my_adds/{userId}")
    Observable<MainResponse<List<AddDetails>>> my_adds(@Path("userId") int userId);

    // 18
    @POST("my_hagazat_adds")
    Observable<MainResponse<List<HogozatyResponse>>> HogozateyPage(@Query("publisher_id") int publisher_id);


    // 19
    @POST("bookmazad")
    Observable<MainResponse<StatusResponse>> bookmazad(@Query("add_id") int add_id,@Query("cate_id") int cate_id,
                                                              @Query("new_price") double new_price,@Query("publisher_id") int publisher_id );

    // 20
    @POST("allmazadbooked")
    Observable<MainResponse<List<FollowMazadResponse>>> allmazadbooked(@Query("id") int publisher_id);

}
