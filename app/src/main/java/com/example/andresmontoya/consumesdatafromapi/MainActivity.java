package com.example.andresmontoya.consumesdatafromapi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private List<Reserva> items;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private RequestQueue queue;
    public SweetAlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.reciclador);
        //tomar toda la pantalla
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        items = new ArrayList<Reserva>();
        queue = Volley.newRequestQueue(this);

        //ir por los datos
        showDialog();
        getData();





    }

    private void getData(){
        String url = "http://cloudapp-manzza.rhcloud.com/Reserva/Servicio/ReservaService";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                for (int i=0; i<response.length(); i++){
                    Reserva reserva = new Reserva();
                    JSONObject jsonObject = null;


                    try {
                        jsonObject = response.getJSONObject(i);
                        reserva.setAsiento(jsonObject.getString("asiento"));
                        reserva.setCliente(jsonObject.getString("nombre"));
                        reserva.setVuelo(jsonObject.getString("codigo_vuelo"));
                        reserva.setFecha(jsonObject.getString("fecha"));
                        items.add(reserva);

                        adapter = new ReservaAdapter(items);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        queue.add(jsonArrayRequest);

    }

    private void showDialog(){

        alertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        alertDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        alertDialog.setTitleText("Loading");
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void hideDialog(){
        if(alertDialog != null){
            alertDialog.dismissWithAnimation();
        }
    }
}
