package br.com.youthquake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.youthquake.config.UserInclude
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btCadastrar.setOnClickListener{
            val user = User()
            user.name = etNome.text.toString()
            user.login = etUsername.text.toString()
            user.password = etSenha.text.toString()
            user.email = etEmail.text.toString()

            val call = UserInclude()
            call.execute(user)

            Toast.makeText(this, getString(R.string.registeredSuccessfully), Toast.LENGTH_SHORT).show()
        }
    }
}
