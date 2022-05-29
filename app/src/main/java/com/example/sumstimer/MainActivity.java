package com.example.sumstimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.example.sumstimer.Types.Lane;
import com.example.sumstimer.Types.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView topSum1, topSum2, jungleSum1, jungleSum2, midSum1, midSum2, supSum1, supSum2, botSum1, botSum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topSum1 = findViewById(R.id.top_sum1);
        topSum2 = findViewById(R.id.top_sum2);
        jungleSum1 = findViewById(R.id.jungle_sum1);
        jungleSum2 = findViewById(R.id.jungle_sum2);
        midSum1 = findViewById(R.id.mid_sum1);
        midSum2 = findViewById(R.id.mid_sum2);
        supSum1 = findViewById(R.id.sup_sum1);
        supSum2 = findViewById(R.id.sup_sum2);
        botSum1 = findViewById(R.id.bot_sum1);
        botSum2 = findViewById(R.id.bot_sum2);

        MyModel model = new ViewModelProvider(this).get(MyModel.class);

        model.getTop().observe(this, new Observer<Lane>() {
            @Override
            public void onChanged(Lane lane) {
                setImageSum(topSum1, lane.getSum1());
                setImageSum(topSum2, lane.getSum2());
            }
        });
        model.getJgl().observe(this, new Observer<Lane>() {
            @Override
            public void onChanged(Lane lane) {
                setImageSum(jungleSum1, lane.getSum1());
                setImageSum(jungleSum2, lane.getSum2());
            }
        });
        model.getMid().observe(this, new Observer<Lane>() {
            @Override
            public void onChanged(Lane lane) {
                setImageSum(midSum1, lane.getSum1());
                setImageSum(midSum2, lane.getSum2());
            }
        });
        model.getSup().observe(this, new Observer<Lane>() {
            @Override
            public void onChanged(Lane lane) {
                setImageSum(supSum1, lane.getSum1());
                setImageSum(supSum2, lane.getSum2());
            }
        });
        model.getBot().observe(this, new Observer<Lane>() {
            @Override
            public void onChanged(Lane lane) {
                setImageSum(botSum1, lane.getSum1());
                setImageSum(botSum2, lane.getSum2());
            }
        });

        topSum1.setOnLongClickListener(ImageLongClickListener());
        topSum2.setOnLongClickListener(ImageLongClickListener());
        jungleSum1.setOnLongClickListener(ImageLongClickListener());
        jungleSum2.setOnLongClickListener(ImageLongClickListener());
        midSum1.setOnLongClickListener(ImageLongClickListener());
        midSum2.setOnLongClickListener(ImageLongClickListener());
        supSum1.setOnLongClickListener(ImageLongClickListener());
        supSum2.setOnLongClickListener(ImageLongClickListener());
        botSum1.setOnLongClickListener(ImageLongClickListener());
        botSum2.setOnLongClickListener(ImageLongClickListener());

    }

    @NonNull
    private View.OnLongClickListener ImageLongClickListener() {
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
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // The user clicked on l_finalArray[which]
                        setImageSum((ImageView) view, Sum.valueOf(l_finalArray[which]));
                    }
                });
                builder.show();
                return true;
            }
        };
    }

    public void setImageSum(ImageView p_image, Sum p_spell){
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