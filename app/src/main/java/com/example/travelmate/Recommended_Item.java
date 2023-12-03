package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class Recommended_Item extends AppCompatActivity {
    
    
    Button Start_Route , Book_Now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_item);
        
        Start_Route = findViewById(R.id.Route);
        Book_Now =findViewById(R.id.BookNow);
        
        Start_Route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//V25V%2B4JJ+Ella+Rock+Trailhead,+Unnamed+Road,+Ella/@6.8559844,81.043436,16z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3ae4659801786c9d:0x9cc8ee54b5343aaf!2m2!1d81.0440226!2d6.8578491!3e0?authuser=0&entry=ttu");
            }
        });

        Book_Now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.booking.com/hotel/lk/ella-camelot.en-gb.html?aid=314920&label=ella-rock-2d9tnA4jQDtAaJeh_fksTQS102883567228%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-114322404062%3Alp9076077%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YZnKoGAh3tLoA_MNQwn0RI8&sid=22226ddb0cc7736853e2d3c4b0725b72&dest_id=900059522;dest_type=landmark;dist=0;group_adults=2;group_children=0;hapos=2;hpos=2;no_rooms=1;req_adults=2;req_children=0;room1=A%2CA;sb_price_type=total;sr_order=popularity;srepoch=1701628098;srpvid=7d15815725d501ef;type=total;ucfs=1&#hotelTmpl");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}