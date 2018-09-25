package com.example.loditech.bitloanmanager.Data;

import com.example.loditech.bitloanmanager.Models.Account;

import retrofit2.Call;
import retrofit2.http.*;

public interface API {
    String BASE_URL ="https://bitloan.azurewebsites.net/api/";

    @POST("Account/LoginU")
    Call<Account> LoginUser(@Query("username") String username, @Query("password") String password);

    //@GET("Account/Login")
    //Call<User> LoginUser(@Query("username") String username, @Query("password") String password);

    @GET("Account/ChangeEmail")
    Call<Boolean> ChangeEmail(@Query("ID") int ID, @Query("password") String password,@Query("emailAddress") String emailAddress);

    @GET("Account/ChangePassword")
    Call<Boolean> ChangePassword(@Query("ID") int ID, @Query("password") String password,@Query("newPassword") String newPassword);

    @POST("Account/UpdateInformation")
    Call<Boolean> UpdateInformation(@Body Account account);
}