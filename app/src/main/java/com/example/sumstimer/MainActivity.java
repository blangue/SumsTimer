package com.example.sumstimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.sumstimer.Types.Lane;
import com.example.sumstimer.Types.Sum;
import com.example.sumstimer.Types.SumImage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SumImage top1 = new SumImage(getApplicationContext());
        SumImage top2 = new SumImage(getApplicationContext());
        SumImage jungle1 = new SumImage(getApplicationContext());
        SumImage jungle2 = new SumImage(getApplicationContext());
        SumImage mid1 = new SumImage(getApplicationContext());
        SumImage mid2 = new SumImage(getApplicationContext());
        SumImage sup1 = new SumImage(getApplicationContext());
        SumImage sup2 = new SumImage(getApplicationContext());
        SumImage bot1 = new SumImage(getApplicationContext());
        SumImage bot2 = new SumImage(getApplicationContext());

        top1.image = findViewById(R.id.top_sum1);
        top2.image = findViewById(R.id.top_sum2);
        jungle1.image = findViewById(R.id.jungle_sum1);
        jungle2.image = findViewById(R.id.jungle_sum2);
        mid1.image = findViewById(R.id.mid_sum1);
        mid2.image = findViewById(R.id.mid_sum2);
        sup1.image = findViewById(R.id.sup_sum1);
        sup2.image = findViewById(R.id.sup_sum2);
        bot1.image = findViewById(R.id.bot_sum1);
        bot2.image = findViewById(R.id.bot_sum2);
        top1.text = findViewById( R.id.timer_top_sum1);
        top2.text = findViewById(R.id.timer_top_sum2);
        jungle1.text = findViewById(R.id.timer_jgl_sum1);
        jungle2.text = findViewById(R.id.timer_jgl_sum2);
        mid1.text = findViewById(R.id.timer_mid_sum1);
        mid2.text = findViewById(R.id.timer_mid_sum2);
        sup1.text = findViewById(R.id.timer_sup_sum1);
        sup2.text = findViewById(R.id.timer_sup_sum2);
        bot1.text = findViewById(R.id.timer_bot_sum1);
        bot2.text = findViewById(R.id.timer_bot_sum2);


        MyModel model = new ViewModelProvider(this).get(MyModel.class);

        model.getTop().observe(this, lane -> {
            setImageSum(top1.image, lane.getSum1());
            setImageSum(top2.image, lane.getSum2());
        });
        model.getJgl().observe(this, lane -> {
            setImageSum(jungle1.image, lane.getSum1());
            setImageSum(jungle2.image, lane.getSum2());
        });
        model.getMid().observe(this, lane -> {
            setImageSum(mid1.image, lane.getSum1());
            setImageSum(mid2.image, lane.getSum2());
        });
        model.getSup().observe(this, lane -> {
            setImageSum(sup1.image, lane.getSum1());
            setImageSum(sup2.image, lane.getSum2());
        });
        model.getBot().observe(this, lane -> {
            setImageSum(bot1.image, lane.getSum1());
            setImageSum(bot2.image, lane.getSum2());
        });

        //Long Click Listeners
        top1.image.setOnLongClickListener(ImageLongClickListener(top1));
        top2.image.setOnLongClickListener(ImageLongClickListener(top2));
        jungle1.image.setOnLongClickListener(ImageLongClickListener(jungle1));
        jungle2.image.setOnLongClickListener(ImageLongClickListener(jungle2));
        mid1.image.setOnLongClickListener(ImageLongClickListener(mid1));
        mid2.image.setOnLongClickListener(ImageLongClickListener(mid2));
        sup1.image.setOnLongClickListener(ImageLongClickListener(sup1));
        sup2.image.setOnLongClickListener(ImageLongClickListener(sup2));
        bot1.image.setOnLongClickListener(ImageLongClickListener(bot1));
        bot2.image.setOnLongClickListener(ImageLongClickListener(bot2));

//        Click Listeners
        setOnClickListener(top1);
        setOnClickListener(top2);
        setOnClickListener(jungle1);
        setOnClickListener(jungle2);
        setOnClickListener(mid1);
        setOnClickListener(mid2);
        setOnClickListener(sup1);
        setOnClickListener(sup2);
        setOnClickListener(bot1);
        setOnClickListener(bot2);

    }

    private void setOnClickListener(SumImage sumImage) {
        sumImage.image.setOnClickListener(view -> {
            ImageView image = (ImageView) view;
            image.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);
            image.setClickable(false);
            image.setLongClickable(false);
            if(sumImage.timer == null || sumImage.isFinished)
                sumImage.isFinished = false;
                sumImage.timer = new CountDownTimer(sumImage.sum.getCD() * 1000, 10) {

                    public void onTick(long millisUntilFinished) {
                        sumImage.text.setText(new SimpleDateFormat(millisUntilFinished < 60000 ? "ss:SS" : "mm:ss:SS").format(new Date(millisUntilFinished)));
                    }

                    public void onFinish() {
                        sumImage.text.setText("");
                        ((ImageView) view).clearColorFilter();
                        ((ImageView) view).setClickable(true);
                        sumImage.isFinished = true;
                    }
                }.start();
        });
    }

    @NonNull
    private View.OnLongClickListener ImageLongClickListener(SumImage sumImage) {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // Prepare the list of summoners
                ArrayList<Sum> l_sums = new ArrayList<Sum>(Arrays.asList(Sum.values()));
                List<String> l_sumsAsStrings = new ArrayList<>();
                for (Sum l_sum :
                        l_sums) {
                    l_sumsAsStrings.add((String) l_sum.toString());
                }
                String[] l_finalArray = new String[Sum.values().length];
                l_sumsAsStrings.toArray(l_finalArray);
                // PopUp to choose the new Sum

                final List<Item> itemList = new ArrayList<>();
                for (Sum l_sum :
                        Sum.values()) {
                    itemList.add(new Item(l_sum.toString(), l_sum.getIcon()));
                };
                final Item[] items = new Item[Sum.values().length];
                itemList.toArray(items);
                ListAdapter adapter = new ArrayAdapter<Item>(view.getContext(),android.R.layout.select_dialog_item,android.R.id.text1, items){
                    public View getView(int position, View convertView, ViewGroup parent) {
                        //Use super class to create the View
                        View v = super.getView(position, convertView, parent);
                        TextView tv = (TextView)v.findViewById(android.R.id.text1);

                        //Put the image on the TextView
                        tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);

                        //Add margin between image and text (support various screen densities)
                        int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
                        tv.setCompoundDrawablePadding(dp5);

                        return v;
                    }
                };


                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pick a summoner spell:");
                builder.setAdapter(adapter, (dialogInterface, which) -> {
                    // The user clicked on l_finalArray[which]
                    setImageSum((ImageView) view, Sum.valueOf(l_finalArray[which]));
                    sumImage.sum = Sum.valueOf(l_finalArray[which]);
                });
                builder.show();
                return true;
            }
        };
    }

    public void setImageSum(ImageView p_image, Sum p_spell){
        if (p_image == null){
            return;
        }
        switch (p_spell){
            case HEAL:
                p_image.setImageResource(R.drawable.heal__28summoner_spell_29);
                break;
            case GHOST:
                p_image.setImageResource(R.drawable.ghost__28summoner_spell_29);
                break;
            case SMITE:
                p_image.setImageResource(R.drawable.smite__28summoner_spell_29);
                break;
            case IGNITE:
                p_image.setImageResource(R.drawable.ignite__28summoner_spell_29);
                break;
            case BARRIER:
                p_image.setImageResource(R.drawable.barrier__summoner_spell_);
                break;
            case CLEANSE:
                p_image.setImageResource(R.drawable.cleanse__28summoner_spell_29);
                break;
            case EXHAUST:
                p_image.setImageResource(R.drawable.exhaust__28summoner_spell_29);
                break;
            case TELEPORT:
                p_image.setImageResource(R.drawable.teleport__28summoner_spell_29);
                break;
            case FLASH:
            default:
                p_image.setImageResource(R.drawable.flash__28summoner_spell_29);

        }
    }

    public static class Item{
        public final String text;
        public final int icon;
        public Item(String text, Integer icon) {
            this.text = text;
            this.icon = icon;
        }
        @Override
        public String toString() {
            return text;
        }
    }



}