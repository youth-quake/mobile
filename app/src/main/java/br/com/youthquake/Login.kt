package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.youthquake.config.WebClient
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun authenticAcessUser(view: View){
        val user = User()
        user.login = etUsername.text.toString()
        user.password = etPassword.text.toString()

        val call = WebClient().authenticLoginUser().loginUser(user)
        call.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                response?.let {
                    val responseServer = it.body()
                    if(responseServer != null){
                        goToTela()
                    }
                }
            }
            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun goToTela(){
        val telaTeste = Intent(this, Register::class.java)
        startActivity(telaTeste)
    }
}
