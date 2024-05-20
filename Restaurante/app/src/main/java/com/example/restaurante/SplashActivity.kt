package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    // //é usado para configurar a atividade quando ela é criada.é um ponto de entrada importante
    //        // para definir a interface do usuário, inicializar variáveis e lidar com outras tarefas de inicialização.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //define o layout
        setContentView(R.layout.activity_splash)

        // e ele vai ser executado depois de um intervalo especificado.
        Handler(Looper.getMainLooper()).postDelayed({

            //pega os dados recebidos atuais feito no intent splash
            val i = intent

            // cria intent para o pedido
            val j = Intent(this,PedidoActivity::class.java)

            //passa os valores atuais para o novo intent pedido
            j.putExtras(i)

            //inicia a nova tela
            startActivity(j)

        },2000)

    }
}