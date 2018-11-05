package net

import entity.Owl
import entity.OwlRequest
import entity.OwlResponse
import io.reactivex.Observable
import retrofit2.http.*

//логика запросов
interface RestApi {

//    @GET("")
//    fun getStudents(): Observable<List<OwlResponse>>
//
//    @GET("students/{id}/")
//    fun getStudentsById(@Path("id")id: String): Observable<OwlResponse>
//
//    @POST("owl/")
//    fun updateStudent(@Body owl: OwlRequest):Observable<OwlResponse>
//
//    @DELETE ("students/{id}/")
//    fun deleteStudent(@Path("id")id: String):Observable<Void>

    @GET("data/Owls")
    fun getOwls(): Observable<List<OwlResponse>>
}