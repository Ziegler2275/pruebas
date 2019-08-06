package com.cristian.myapplication.Mensajes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cristian.myapplication.R;

import java.util.List;

public class MensajeriaAdapter extends RecyclerView.Adapter<MensajeriaAdapter.MensajesViewHolder> {

    private List<MensajeDeTexto> mensajeDeTextos;

    public MensajeriaAdapter(List<MensajeDeTexto> mensajeDeTextos) {
        this.mensajeDeTextos = mensajeDeTextos;
    }


    @Override//retornar una vista,estamos inflando la tarjeta para que aparesca en nuestra vista
    public MensajeriaAdapter.MensajesViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mensajes,parent,false);
        return new MensajeriaAdapter.MensajesViewHolder(v);
    }

    @Override//donde se modifica cada tarjeta,que vamos a tener
    public void onBindViewHolder(MensajeriaAdapter.MensajesViewHolder holder, int position) {
//modificar mensaje y hora
        RelativeLayout.LayoutParams r1=(RelativeLayout.LayoutParams) holder.cardView.getLayoutParams();
        FrameLayout.LayoutParams f1=(FrameLayout.LayoutParams)holder.mensajeBG.getLayoutParams();
        LinearLayout.LayoutParams llMensaje=(LinearLayout.LayoutParams) holder.TvMensaje.getLayoutParams();//hora

        LinearLayout.LayoutParams llHora=(LinearLayout.LayoutParams) holder.TvHora.getLayoutParams();//hora


        if(mensajeDeTextos.get(position).getTipoMensaje()==1){//emisor
            holder.mensajeBG.setBackgroundResource(R.drawable.in_message_bg);
            r1.addRule(RelativeLayout.ALIGN_PARENT_LEFT,0);//limite en la pocicion 0
            r1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            llMensaje.gravity=Gravity.RIGHT;
            llHora.gravity=Gravity.RIGHT;//para la hora si va derecha o ziquerda
            f1.gravity= Gravity.RIGHT;
            holder.TvMensaje.setGravity(Gravity.RIGHT);

            //espacio en blanco a la izquierda y no  a la derecha
        }else if(mensajeDeTextos.get(position).getTipoMensaje()==2){

            holder.mensajeBG.setBackgroundResource(R.drawable.out_message_bg);
            r1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,0);
            r1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            llMensaje.gravity=Gravity.RIGHT;
            llHora.gravity=Gravity.LEFT;//para la hora si va derecha o ziquerda
            f1.gravity= Gravity.LEFT;
            holder.TvMensaje.setGravity(Gravity.LEFT);
        }




        holder.cardView.setLayoutParams(r1);
        holder.TvMensaje.setText(mensajeDeTextos.get(position).getMensaje());
        holder.TvHora.setText(mensajeDeTextos.get(position).getHoraDelMensaje());//para la hora
        holder.TvMensaje.setLayoutParams(llMensaje);
        holder.TvHora.setText(mensajeDeTextos.get(position).getHoraDelMensaje());



    }

    @Override//elementos que va a contener nuestro recicler View
    public int getItemCount() {

        return mensajeDeTextos.size();//retorna el tamaño de las tarjetas
    }
//aqui creamos las variables que esta en nuestra tarjeta
    static class MensajesViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        LinearLayout mensajeBG;
        TextView TvMensaje;
        TextView TvHora;


        MensajesViewHolder(View itemView) {

            super(itemView);
            cardView=(CardView) itemView.findViewById(R.id.cvMensaje);
            mensajeBG=(LinearLayout)itemView.findViewById(R.id.mensajeBG);
            TvMensaje=(TextView) itemView.findViewById(R.id.msTexto);
            TvHora=(TextView) itemView.findViewById(R.id.msHora);
        }


    }



}
