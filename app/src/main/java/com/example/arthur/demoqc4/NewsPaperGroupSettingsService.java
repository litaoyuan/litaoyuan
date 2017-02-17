package com.example.arthur.demoqc4;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arthur on 2017/2/13.
 */

public interface NewsPaperGroupSettingsService {
    @GET("book/search")
    Call<String> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag, @Query("start") int start,
                                            @Query("count") int count);
}
