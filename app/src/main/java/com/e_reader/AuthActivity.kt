package com.e_reader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    private val GOOGLE_SIGN_IN=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setup()
    }

    private fun setup(){
        title="Autenticacion"
        btnSign.setOnClickListener {
            if (edtEmail.text.isNotEmpty()&& edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(edtEmail.text.toString(),edtPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intento1=Intent(this, HomeActivity::class.java)
                        startActivity(intento1)
                    }
                    else{
                        showAlert()
                    }
                }

            }
        }

        btnLogin.setOnClickListener {
            if (edtEmail.text.isNotEmpty()&& edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(edtEmail.text.toString(),edtPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intento1=Intent(this, HomeActivity::class.java)
                        startActivity(intento1)
                    }
                    else{
                        showAlert()
                    }
                }

            }
        }

    }

    private fun showAlert(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage("Se ha producido un error en la autenticacion")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog=builder.create()
        dialog.show()
    }
    
}