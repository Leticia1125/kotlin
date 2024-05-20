package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Cria a variável binding
    private lateinit var binding:ActivityMainBinding


    //é usado para configurar a atividade quando ela é criada.é um ponto de entrada importante
    // para definir a interface do usuário, inicializar variáveis e lidar com outras tarefas de inicialização.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui, estamos inflando o layout da atividade chamado ActivityMainBinding.
        // O método inflate() cria uma instância da classe de vinculação (binding) associada ao layout.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // define o conteúdo da atividade para ser o layout especificado.
        //O binding.root retorna o root view, que é o contêiner de visualização mais externo no layout.
        setContentView(binding.root)

        //obtem o valor da string associada à chave "username".
        val username = intent.extras?.getString("username")

        //se as condições de if tiverem correta ira aparecer uma mensagem.
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        //botão fechar, quando for clicado irá encerrar.
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        //botão de pedir, quando clicado irá criar o intent.
        binding.buttonPedir.setOnClickListener {

            //cria intent da tela splash
            val i = Intent(this, SplashActivity::class.java)

            //esses  dados são colocado dentro do intent splash
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())

            //inicia a nova tela
            startActivity(i)

            //finaliza
            finish()
        }

        //controla o que acontece quando o checkboxes Pizza forem marcados e desmarcados
        binding.checkPizza.setOnClickListener {

            //ajusta a quantidade e visibilidade dos campos de quantidade
            // e preço conforme o usuário faz suas escolhas.
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        //controla o que acontece quando o checkboxes Salada forem marcados e desmarcados
        binding.checkSalada.setOnClickListener {

            //ajusta a quantidade e visibilidade dos campos de quantidade
            // e preço conforme o usuário faz suas escolhas.
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        //controla o que acontece quando o checkboxes Hamburguer forem marcados e desmarcados
        binding.checkHamburger.setOnClickListener {

            //ajusta a quantidade e visibilidade dos campos de quantidade
            // e preço conforme o usuário faz suas escolhas.
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}