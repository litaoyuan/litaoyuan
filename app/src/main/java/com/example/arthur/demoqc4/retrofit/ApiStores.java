package com.example.arthur.demoqc4.retrofit;

import com.example.arthur.demoqc4.NewsPaperGroupResponse;
import com.example.arthur.demoqc4.models.ReturnDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by arthur on 2017/2/13.
 */

public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://192.168.1.32:83/";
    @GET("api/Newspaper/GetNewspaperGroup")
    Call<ReturnDataResponse<NewsPaperGroupResponse>> getnewspapergroup(@Query("Id") long id);
//http://192.168.1.32:83/api/Newspaper/GetNewspaperGroup?Id=9999
    //加载天气    Call<ReturnDataResponse> getnewspapergroup(@Query("Id") long id);

//    @GET("adat/sk/{cityId}.html")
//    Observable<MainModel> loadDataByRetrofitRxjava(@Path("cityId") String cityId);
}
