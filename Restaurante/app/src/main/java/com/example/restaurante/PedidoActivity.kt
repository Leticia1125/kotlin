package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityLoginBinding
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    //Cria a variável binding
    private lateinit var binding: ActivityPedidoBinding

    //é usado para configurar a atividade quando ela é criada.é um ponto de entrada importante
    // para definir a interface do usuário, inicializar variáveis e lidar com outras tarefas de inicialização.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui, estamos inflando o layout da atividade chamado ActivityPedidoBinding.
        // O método inflate() cria uma instância da classe de vinculação (binding) associada ao layout.
        binding=ActivityPedidoBinding.inflate(layoutInflater)

        // define o conteúdo da atividade para ser o layout especificado.
        //O binding.root retorna o root view, que é o contêiner de visualização mais externo no layout.
        setContentView(binding.root)

        //pega as quantidades de pizza, salada e hambúrguer que foram passadas pela tela anterior.
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        //apresenta um resumo sobre a qauntidade e preço
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço:R$ ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço:R$ ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço:R$ ${quantidadeHamburguer*12}\n"

        binding.textResumo.text = texto
    }
}