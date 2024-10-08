import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Este es el layout de login

        // Referenciar los botones del layout de login
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        // Acción al hacer clic en el botón de "Iniciar Sesión"
        buttonLogin.setOnClickListener {
            // Aquí puedes implementar la lógica para validar las credenciales
            // Por ejemplo, puedes verificar el nombre de usuario y la contraseña
        }

        // Acción al hacer clic en el botón de "Registrarse"
        buttonRegister.setOnClickListener {
            // Iniciar la nueva actividad para el registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrarse) // Este es el layout de registrarse

        // Referenciar los campos del layout de registro
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextApellido = findViewById<EditText>(R.id.editTextApellido)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextDireccion = findViewById<EditText>(R.id.editTextDireccion)
        val editTextTelefono = findViewById<EditText>(R.id.editTextTelefono)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonConfirm = findViewById<Button>(R.id.buttonConfirm)

        // Acción al hacer clic en el botón de "Confirmar Registro"
        buttonConfirm.setOnClickListener {
            // Aquí puedes implementar la lógica para registrar al usuario.
            // Puedes obtener los valores de los campos como se muestra a continuación.
            val nombre = editTextName.text.toString()
            val apellido = editTextApellido.text.toString()
            val email = editTextEmail.text.toString()
            val direccion = editTextDireccion.text.toString()
            val telefono = editTextTelefono.text.toString()
            val password = editTextPassword.text.toString()

            // Puedes mostrar un mensaje de confirmación
            Toast.makeText(this, "Registro exitoso para $nombre $apellido", Toast.LENGTH_SHORT).show()

            // Luego de registrar, puedes volver al login o hacer otra acción
            finish() // Esto cierra la actividad de registro y vuelve al login
        }
    }
}
