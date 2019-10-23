package br.com.youthquake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import br.com.youthquake.config.WebClient
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun includeUser(view:View){
        val user = User()
        user.name = etNome.text.toString()
        user.login = etUsername.text.toString()
        user.password = etSenha.text.toString()
        user.email = etEmail.text.toString()

        val call = WebClient().includeUserService().insertUser(user)
        call.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                response?.let {
                    val responseServer = it.body()
                    if(responseServer != null){

                    }
                }
            }
            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }
    fun toastResponse(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
