package com.cristian.myapplication.Mensajes;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.cristian.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Mensajeria extends AppCompatActivity {

    private RecyclerView rv;
    private Button bTEnviarMensaje;
    private EditText eTEscribirMensaje;
    private List<MensajeDeTexto> mensajeDeTextos=new ArrayList<>();
    private MensajeriaAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensajeria);
        mensajeDeTextos=new ArrayList<>();//inicializar nuestro arrayList

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        bTEnviarMensaje=(Button)findViewById(R.id.bTenviarMensaje);
        eTEscribirMensaje=(EditText)findViewById(R.id.eTEscribirMensaje);

        rv=(RecyclerView) findViewById(R.id.rvMensajes);
        LinearLayoutManager lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);//tener datos en forma vertical

        //llenar lista
        //crear mensajes auxiliares
        for(int  i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar=new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("emisor"+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(1);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:34");
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        for(int  i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar=new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("receptor"+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(2);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:34");
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }



        adapter=new MensajeriaAdapter(mensajeDeTextos);
        rv.setAdapter(adapter);//



        bTEnviarMensaje.setOnClickListener(new View.OnClickListener(){

            @Override
                    public void onClick(View view){

//capturar lo que tenemos en un mensaje

                CreateMensaje(eTEscribirMensaje.getText().toString());

            }


        });






        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });



    }

    public void CreateMensaje (String mensaje){//nosotros siempre el emisor
        MensajeDeTexto mensajeDeTextoAuxiliar=new MensajeDeTexto();
        mensajeDeTextoAuxiliar.setId("0");
        mensajeDeTextoAuxiliar.setMensaje(mensaje);
        mensajeDeTextoAuxiliar.setTipoMensaje(1);
        mensajeDeTextoAuxiliar.setHoraDelMensaje("10:20");
        mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        adapter.notifyDataSetChanged();//cuando ocurre un cambio,la lista se actualiza
        eTEscribirMensaje.setText("");//dejar mensaje limpio luego de escribir



    }

}
