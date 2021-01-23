package com.mazad.Diana.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.mazad.Diana.utels.AppConstant;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Part;
import retrofit2.http.Query;

import static com.mazad.Diana.utels.AppConstant.BASE_URL;

public class MainApi {


    public static <T> T getApi(Class<T> aClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //  interceptor.intercept(new FirebaseAuthInterceptor());
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build();

        OkHttpClient.Builder client = new OkHttpClient().newBuilder()
                .connectTimeout(60 * 5, TimeUnit.SECONDS)
                .readTimeout(60 * 5, TimeUnit.SECONDS)
                .writeTimeout(60 * 5, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        //' okHttpClient.interceptors().add(new AddCookiesInterceptor());

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        return retrofit.create(aClass);
    }

    private static MainApiInterface getApi() {
        return getApi(MainApiInterface.class);
    }


    public static void saleType(final ConnectionListener<MainResponse<List<Sale_typeResponse>>> connectionListener) {

        getApi().SaleTypePage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<Sale_typeResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<Sale_typeResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<Sale_typeResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void categoryApi(final ConnectionListener<MainResponse<List<CategoriesResponse>>> connectionListener) {

        getApi().CategoriesPage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<CategoriesResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<CategoriesResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<CategoriesResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void getDropDownApi(int catId, final ConnectionListener<MainResponse<List<DropDownResponse>>> connectionListener) {

        getApi().dropDownList(catId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<DropDownResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<DropDownResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<DropDownResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void directSalePost(
            MultipartBody.Part image1, MultipartBody.Part image2,
            MultipartBody.Part image3
            , RequestBody cate_id, RequestBody band_rkm, RequestBody general_description,
            RequestBody values, RequestBody keySet, RequestBody price,
            RequestBody publisher_id, RequestBody available_number, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().PostDirectSalePaged(image1, image2, image3, cate_id, band_rkm, general_description, values, keySet, price,
                publisher_id, available_number).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void Loginapi(String phone, String pass,
                                final ConnectionListener<MainResponse<UserResponse>> connectionListener) {

        getApi().LoginPage(phone, pass).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<UserResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<UserResponse> userResponse) {
                        ConnectionResponse<MainResponse<UserResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void listAddsApi(int saleTypeId,int catId,
                                   final ConnectionListener<MainResponse<List<DirectAddResponse>>> connectionListener) {

        getApi().listAddsPage(saleTypeId,catId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<DirectAddResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<DirectAddResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<DirectAddResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void Registerapi(MultipartBody.Part profile_image, RequestBody name, RequestBody email, RequestBody fame, RequestBody mobile
            , RequestBody password, RequestBody country
            , final ConnectionListener<MainResponse<UserResponse>> connectionListener) {
        getApi().SignUpPage(profile_image, name, email, fame, mobile, password,country).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<UserResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<UserResponse> userResponse) {

                        ConnectionResponse<MainResponse<UserResponse>> response = new ConnectionResponse<>();
                        //   userResponse.headers().values("Set-Cookie");
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void AddDetailsApi(int addId,
                                     final ConnectionListener<MainResponse<AddDetails>> connectionListener) {

        getApi().CurrentAddDetails(addId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<AddDetails>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<AddDetails> userResponse) {
                        ConnectionResponse<MainResponse<AddDetails>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void BookAddAPi(int add_id, int cate_id,
                                  int number_products,
                                  int publisher_id, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().BookAddDirectPage(add_id, cate_id, number_products, publisher_id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void BookPostAp(int addId,
                                  final ConnectionListener<MainResponse<List<BookListResponse>>> connectionListener) {

        getApi().MyBookList(addId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<BookListResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<BookListResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<BookListResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void AcceptBookedApi(int add_id, int publisherId, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().AcceptBookedPage(add_id, publisherId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void mySoreApi(int userId,
                                 final ConnectionListener<MainResponse<List<DirectAddResponse>>> connectionListener) {

        getApi().MyStoresPage(userId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<DirectAddResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<DirectAddResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<DirectAddResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void rePublishAdd(int add_id ,double price, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().rePublishAddPage(add_id, AppConstant.userResponse.getUser().get(0).getId(),price).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void MazadSalePost(
            MultipartBody.Part image1, MultipartBody.Part image2,
            MultipartBody.Part image3
            , RequestBody cate_id, RequestBody band_rkm, RequestBody general_description,
            RequestBody values, RequestBody keySet, RequestBody price,
            RequestBody publisher_id,
            RequestBody add_time_state, RequestBody end_add_time,
            RequestBody require_price_enddate, RequestBody right_back,
            RequestBody raise, RequestBody raise_rkm,
            RequestBody less_raise, RequestBody enter_mazad, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().PostMazadSalePaged(image1, image2, image3, cate_id, band_rkm, general_description, values, keySet, price,
                publisher_id, add_time_state, end_add_time, require_price_enddate, right_back, raise, raise_rkm, less_raise, enter_mazad).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void listMazadAddsApi(int saleTypeId,int catId,
                                   final ConnectionListener<MainResponse<List<MazadResponse>>> connectionListener) {

        getApi().listMazadAddsPage(saleTypeId,catId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<MazadResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<MazadResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<MazadResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void countriesApi(
                                 final ConnectionListener<MainResponse<List<Countrys>>> connectionListener) {

        getApi().getCountryPage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<Countrys>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<Countrys>> userResponse) {
                        ConnectionResponse<MainResponse<List<Countrys>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }
    public static void myAddApi(int userId,
                                     final ConnectionListener<MainResponse<List<AddDetails>>> connectionListener) {

        getApi().my_adds(userId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<AddDetails>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<AddDetails>> userResponse) {
                        ConnectionResponse<MainResponse<List<AddDetails>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void hgogozatyApi(int publisher_id,
                                final ConnectionListener<MainResponse<List<HogozatyResponse>>> connectionListener) {

        getApi().HogozateyPage(publisher_id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<HogozatyResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<HogozatyResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<HogozatyResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }


    public static void enterMazad( int add_id, int cate_id,
                                     double new_price, int publisher_id, final ConnectionListener<MainResponse<StatusResponse>> connectionListener) {

        getApi().bookmazad(add_id,cate_id,new_price, AppConstant.userResponse.getUser().get(0).getId()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<StatusResponse>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<StatusResponse> userResponse) {
                        ConnectionResponse<MainResponse<StatusResponse>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }

    public static void allmazadbooked(int id,
                                    final ConnectionListener<MainResponse<List<FollowMazadResponse>>> connectionListener) {

        getApi().allmazadbooked(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainResponse<List<FollowMazadResponse>>>() {
                    @Override
                    public void onError(Throwable e) {
                        connectionListener.onFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MainResponse<List<FollowMazadResponse>> userResponse) {
                        ConnectionResponse<MainResponse<List<FollowMazadResponse>>> response = new ConnectionResponse<>();
                        response.data = userResponse;
                        connectionListener.onSuccess(response);
                    }
                });
    }
}
