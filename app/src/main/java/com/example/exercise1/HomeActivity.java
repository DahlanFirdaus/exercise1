package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private Listviewadapter adapter;
    String[] listnama;
    public static ArrayList<com.example.exercise1.Nama> classNamaArrayList = new ArrayList<Nama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String Kontak;

    ArrayAdapter<String > arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul",
                "Intan", "Vina", "Gita", "Vian", "Lutfi" };
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise1.Nama classNama = new com.example.exercise1.Nama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new Listviewadapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Kontak = classNamaArrayList.get(position).getNama();
                    bundle.putString("a", Kontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(HomeActivity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();



                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),Activitylihatdata.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor_kontak = Kontak.trim();
                String Nomor = "";
                if (nomor_kontak == "Inayah"){
                    Nomor = "08122222222";
                }
                else if (nomor_kontak == "Ilham"){
                    Nomor = "08122442222";
                }
                else if (nomor_kontak == "Eris"){
                    Nomor = "08111222222";
                }
                else if (nomor_kontak == "Fikri"){
                    Nomor = "08122222444";
                }
                else if (nomor_kontak == "Maul"){
                    Nomor = "08122777222";
                }
                else if (nomor_kontak == "Intan"){
                    Nomor = "08122226666";
                }
                else if (nomor_kontak == "Vina"){
                    Nomor = "08122556666";
                }
                else if (nomor_kontak == "Gita"){
                    Nomor = "08199226666";
                }
                else if (nomor_kontak == "Lutfi"){
                    Nomor = "08128886666";
                }
                else if (nomor_kontak == "Vian"){
                    Nomor = "08144426666";
                }

                Toast.makeText(getApplicationContext(),Nomor, Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }

}