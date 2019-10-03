package br.com.youthquake
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.youthquake.config.ConfigRetrofit
import br.com.youthquake.data.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        btCadastrar.setOnClickListener {
            val usr = User()
            usr.name = etNome.text.toString()
            usr.login = etUsername.text.toString()
            usr.password = etSenha.text.toString()
            usr.email = etEmail.text.toString()
            val call = ConfigRetrofit().userInclude().insertUser(usr)
            call.execute()
        }
        */
    }
}
