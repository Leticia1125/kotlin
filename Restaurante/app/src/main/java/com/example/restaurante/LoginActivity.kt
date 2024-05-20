package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    //Cria a variável binding
    private lateinit var binding:ActivityLoginBinding

    //é usado para configurar a atividade quando ela é criada.é um ponto de entrada importante
    // para definir a interface do usuário, inicializar variáveis e lidar com outras tarefas de inicialização.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui, estamos inflando o layout da atividade chamado ActivityLoginBinding.
        // O método inflate() cria uma instância da classe de vinculação (binding) associada ao layout
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // define o conteúdo da atividade para ser o layout especificado.
        //O binding.root retorna o root view, que é o contêiner de visualização mais externo no layout.
        setContentView(binding.root)

        // está associando um listener de clique ao botão “Entrar” usando o View Binding
        binding.buttonEntrar.setOnClickListener {

            //Quando o botão for clicado, o código dentro do bloco será executado.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // o trecho de código verifica se o username é igual a "abc" e se a password é igual a "123".
            // Se ambas as condições forem verdadeiras, o bloco de código dentro do if será executado.
            if (username.equals("abc") && password.equals("123")) {

                //cria uma Intent para abrir a MainActivity
                val i = Intent(this, MainActivity::class.java)

                // passa o valor da variável username como um extra e, em seguida, inicia a nova atividade.
                i.putExtra("username", username)
                startActivity(i)

                //finaliza
                finish()

                //se estiver errado vai aparecer uma mensagem de erro
            } else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}