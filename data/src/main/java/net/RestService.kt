package net

import com.google.gson.GsonBuilder
import entity.OwlResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//для загрузки и получения
class RestService(private val apiUrl: String) {

    private val restApi: RestApi

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)//сколько времени на чтение данных
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())

        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //ответы в виде rx
                .addConverterFactory(GsonConverterFactory.create(gson))//как делать парсинг данных
                .client(okHttpBuilder.build())
                .build()

        restApi = retrofit.create(RestApi::class.java)
    }

//    fun getStudents() : Observable<List<OwlResponse>>{
//        return restApi.getStudents()
//    }
//
//    fun getStudentsById(id:String) : Observable<OwlResponse>{
//        return restApi.getStudentsById(id)
//    }
//
//    fun updateStudent(owl : OwlRequest) : Observable<OwlResponse>{
//        return restApi.updateStudent(owl)
//    }
//
//    fun deleteStudent(id:String) : Observable<Void>{
//        return restApi.deleteStudent(id)
//    }

    fun getOwls():Observable<List<OwlResponse>>{
        return restApi.getOwls()
    }
}