package com.myapp.weeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.myapp.weeme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(1500)//Establecemos un retardo para la carga de la activity
        setTheme(R.style.Theme_WeeMe)//Establecemos el tema para que deje de usar el de la Splash Screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //CAMPO DE TEXTO USUARIO: Verificamos que se trata de un correo electrónico válido
        //Pendiente futuro desarrollo

        //CAMPO DE TEXTO CONTRASEÑA:
        //Si el campo de texto tiene el foco no debe mostrar el error
        binding.mainTilPassword.setOnFocusChangeListener { _, hasFocus ->
            run {
                if (hasFocus) {
                    binding.mainTilPassword.error = ""
                }
            }
        }
        binding.mainTiePassword.addTextChangedListener {
            val size = it!!.length
            if (size < 5) {
                binding.mainTilPassword.error = "Caracteres $size/5"
            } else {
                binding.mainTilPassword.error = ""
            }
        }
        //Verificamos que la contraseña tiene al menos 5 caracteres mostrando el error en caso contrario
        var passwordSizeCorrect = false
        binding.mainTiePassword.setOnClickListener {
            val textInputEditText = it as TextInputEditText //Casteo
            val size = textInputEditText.text.toString().length
            if (size < 5) {
                binding.mainTilPassword.error = "Caracteres $size/5"
                passwordSizeCorrect = false
            } else {
                binding.mainTilPassword.error = ""
                passwordSizeCorrect = true
            }
        }
        //Hacemos que al dar a done en el cuadro de texto se ejecute la acción del botón Login
        binding.mainTiePassword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.mainBtLogin.performClick()
            }
            false
        }

        //BOTÓN INICIAR SESIÓN: Verificamos antes de inicar sesión que la contraseña es correcta
        binding.mainBtLogin.setOnClickListener setOnCliCkListener@{
            if (!passwordSizeCorrect) {
                binding.mainTiePassword.error = "Por favor, introduzca una contraseña válida."
                return@setOnCliCkListener
            }
            //Al pulsar el botón accedemos a la Activity main2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        //BOTÓN REGISTRARSE: Accedemos a la activity de registro
        binding.mainTvRegister.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }
}