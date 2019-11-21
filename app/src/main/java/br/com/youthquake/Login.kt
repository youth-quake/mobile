package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.youthquake.config.UserAuthenticate
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
        val call = UserAuthenticate()
        val response: User? = call.execute(user).get()
        if(response != null){
            enableAccess(response.idUser,response.name,response.login,
                response.email, response.password, response.messageStatus,
                response.level)
        }else{
            rejectAccess()
        }
    }

    fun enableAccess(idUser:Long?,name:String?,login:String?,email:String?,password:String?,
                    messageStatus:String?,level:Int?){
        val goHome = Intent(this, Firststep::class.java)
        goHome.putExtra("idUser", idUser)
        goHome.putExtra("name",  name)
        goHome.putExtra("login", login)
        goHome.putExtra("email", email)
        goHome.putExtra("password", password)
        goHome.putExtra("messageStatus", messageStatus)
        goHome.putExtra("level", level)
        startActivity(goHome)
    }

    fun rejectAccess(){
        Toast.makeText(this, "Usuário/ou senha incorretos", Toast.LENGTH_LONG).show()
    }
}
