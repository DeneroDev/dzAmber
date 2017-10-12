package com.example.denero.ambercard;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.service.dreams.DreamService;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denero.ambercard.model.JsonGet;
import com.example.denero.ambercard.model.PagePOJO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class PlaceActivity extends AppCompatActivity {
    private JsonGet jsonGet = new JsonGet();
    private final String BASE_URL = "http://138.68.68.166:9999";
    private final int[] ID_STAR = {R.id.star_one,R.id.star_two,R.id.star_three,R.id.star_four,R.id.star_five};
    private Typeface YESEVA_ONE;
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.create();
    private final PagePOJO page = gson.fromJson(jsonGet.getJsonTwo(), PagePOJO.class);
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        setTitle("");
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setContentScrim(getDrawable(R.drawable.backgroundlay));
        setSupportActionBar(toolbar);

        final ImageView toolbarImg = (ImageView) findViewById(R.id.main_backdrop_activity);

        TextView descrTitle = (TextView)findViewById(R.id.title_description);
        YESEVA_ONE = Typeface.createFromAsset(getAssets(), "YesevaOne-Regular.ttf");
        descrTitle.setTypeface(YESEVA_ONE);

        TextView descrText = (TextView)findViewById(R.id.text_description);
        TextView descrWorkDay = (TextView)findViewById(R.id.workday_description);
        TextView descrPrice = (TextView)findViewById(R.id.price_description);
        TextView descrPhone = (TextView) findViewById(R.id.descr_phone);
        TextView descrPlace = (TextView) findViewById(R.id.descr_location);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getApplicationContext()) //передаем контекст приложения
                        .load( BASE_URL+page.getCategoryId().get(0).getPicture()) //адрес изображения
                        .into(toolbarImg); //ссылка на ImageView
                for(int i = 0; i<Integer.valueOf(page.getRate());i++){
                    ImageView star = (ImageView)findViewById(ID_STAR[i]);
                    star.setImageDrawable(getDrawable(R.drawable.ic_star_plus));
                }
            }
        });

        descrTitle.setText(page.getName());
        descrText.setText(page.getDescription());

        //только не по лицу
        if(page.getDescription2()!=null && page.getDescription2().length()>=2)
            descrWorkDay.setText(Html.fromHtml("<b>" + "Режим работы:" + "</b> " + page.getDescription2()));
        else
        { descrWorkDay.setWidth(0);descrWorkDay.setHeight(0);descrWorkDay.setVisibility(View.INVISIBLE);}

        if(page.getCostText()!=null && page.getCostSum().length()>1)
            descrPrice.setText(Html.fromHtml("<b>"+page.getCostText()+"</b>"+": "+page.getCostSum()));
        else
        { descrPrice.setWidth(0);descrPrice.setHeight(0); descrPrice.setVisibility(View.INVISIBLE);}

        if(page.getPhone()!=null && page.getPhone().length()>1)
        {
            descrPhone.setText(page.getPhone());
        }
        else
        {
            CardView card = (CardView)findViewById(R.id.tel_card);
            card.setVisibility(View.INVISIBLE);}

        if(page.getLongitude()!=null && page.getPhone().length()>1)
        {
            descrPlace.setText("Долгота:"+String.format(Locale.ENGLISH, "%(.2f", page.getLongitude()) + " | " + "Широта:"+String.format(Locale.ENGLISH, "%(.2f", page.getLatitude()));
        }
        else
        {
            CardView card = (CardView)findViewById(R.id.locale_card);
            card.setVisibility(View.INVISIBLE);}
       // setTitle(" ");


    }
    public void endApplication(View v){
        finish();
    }
}
