package cn.edu.zafu.http;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by lizhangqu on 2015/5/11.
 */
public interface PersonService {
    @Headers({
            "Cache-Control: max-age=640000",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko"
    })
    //通过注解设置请求头
    @GET("/{test}/rest.php")
    //设置请求方法为get，相对路径为注解内内容，其中{test}会被@Path注解指定内容替换
    Person getPerson(@Path("test") String dir,@Query("name") String name);
    //@Query用于指定参数

    @FormUrlEncoded
    //urlencode
    @POST("/test/rest1.php")
    //post提交
    Person updatePerson(@Field("name") String name,@Field("age") int age);
    //@Field提交的域


    @POST("/test/rest1.php")
    void updatePerson(@Field("name") String name,@Field("age") int age, Callback<Person> callback);
    //异步回调，不能指定返回值
}
