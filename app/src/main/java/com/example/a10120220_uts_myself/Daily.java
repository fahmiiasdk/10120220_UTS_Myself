package com.example.a10120220_uts_myself;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Daily extends AppCompatActivity {

    //(2 juni 2023, 10120220, Fahmi Anwar Sidik, IF-06)
    DrawerLayout drawerLayout;
    Context context, contextFriend;
    RecyclerView recyclerView, recyclerViewFriend;
    RecyclerView.Adapter recyclerViewAdapter, recyclerViewAdapterFriend;
    RecyclerView.LayoutManager recylerViewLayoutManager,recylerViewLayoutManageFriend;
    String[] subjects = {
            "Wake Up", "Take a Bath", "Have a Breakfast", "Studying", "Work as Food Delivery", "Watching an Anime",
            "Exercising", "Call My GF","Sleep"
    };
    int[] subjectImage ={
            R.drawable.ic_bangun,R.drawable.ic_mandi,
            R.drawable.ic_food,R.drawable.ic_kuliah,
            R.drawable.ic_driver,R.drawable.ic_film,
            R.drawable.ic_basket,R.drawable.ic_phone,
            R.drawable.ic_tidur
    };
    String[] subjectsName = {
            "Abyan", "Faris", "Adit"
    };
    int[] subjectImageFriend ={
            R.drawable.abyan,R.drawable.faris,
            R.drawable.adit
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(subjects, subjectImage,context );
        recyclerView.setAdapter(recyclerViewAdapter);

        contextFriend = getApplicationContext();
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
        recylerViewLayoutManageFriend = new LinearLayoutManager(contextFriend,LinearLayoutManager.HORIZONTAL,false);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewFriend.setLayoutManager(recylerViewLayoutManageFriend);
        recyclerViewAdapterFriend = new com.example.a10120220_uts_myself.AdapterRecyclerViewFriend(subjectsName, subjectImageFriend,contextFriend );
        recyclerViewFriend.setAdapter(recyclerViewAdapterFriend);



        drawerLayout = findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        HomeActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        HomeActivity.redirectActivity(this,HomeActivity.class);
    }
    public void ClickDaily(View view){
        //recreate
        recreate();
    }

    public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this, com.example.a10120220_uts_myself.Gallery.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        HomeActivity.redirectActivity(this,Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        HomeActivity.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}