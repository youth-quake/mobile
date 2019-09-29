package br.com.youthquake

import android.app.Service
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.youthquake.config.ConfigRetrofit
import br.com.youthquake.data.User
import br.com.youthquake.service.UserService
import kotlinx.android.synthetic.main.sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCadastrar.setOnClickListener {
            val usr = User()
            usr.name = etNome.text.toString()
            usr.login = etUsername.text.toString()
            usr.password = etSenha.text.toString()
            usr.email = etEmail.text.toString()
            val call = ConfigRetrofit().userInclude().insertUser(usr)
            call.execute()
        }
    }
}
