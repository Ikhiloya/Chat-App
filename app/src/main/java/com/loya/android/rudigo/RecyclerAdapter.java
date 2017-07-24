package com.loya.android.rudigo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 7/23/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //instance of the InputData class
    InputData data = new InputData();

    //data for the Recycler Adapter
    private static ArrayList<String> userName = new ArrayList<>();
    private static ArrayList<String> idea = new ArrayList<>();
    private static ArrayList<String> effect = new ArrayList<>();



  static{
      userName.add("loya");
      userName.add("ben");
      userName.add("yanky");
      userName.add("duff");
      userName.add("dan");
  }

    static{
        idea.add("Expanding The PH city Tech Space");
        idea.add("Coders in every nook and cranny");
        idea.add("Challenges of the PH Tech space");
        idea.add("Life as a coder");
        idea.add("Becoming world class with Rudigo!");

    }
    static{
        effect.add("Making today count");
        effect.add("Uprising");
        effect.add("Spring");
        effect.add("tttt");
        effect.add("ddjjd");
    }

    /**
     * our own implementation of the
     * ViewHolder class configured to reference the view elements in the card_layout.xml file
     */

    class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;

        public TextView itemUsename;
        public TextView itemIdea;

        public ViewHolder(View itemView) {
            super(itemView);

            itemUsename = (TextView) itemView.findViewById(R.id.userName);
            itemIdea = (TextView) itemView.findViewById(R.id.user_idea);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    //passe the data on the Recycler view onto the CommentActivity
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CommentActivity.class);
                    intent.putExtra("intentName", userName.get(position));
                    intent.putExtra("intentIdea", idea.get(position));
                    intent.putExtra("intentEffect", effect.get(position));

                    context.startActivity(intent);


                }
            });
        }
    }


    /**
     * This method will be called by the RecyclerView to obtain a ViewHolder object. It inflates
     * the view hierarchy card_layout.xml file and creates an instance of our ViewHolder class
     * initialized with the view hierarchy before returning it to the RecyclerView.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    /**
     * The purpose of the onBindViewHolder() method is to populate the view hierarchy within
     * the ViewHolder object with the data to be displayed. It is passed the ViewHolder object
     * and an integer value indicating the list item that is to be displayed. This method should
     * now be added, using the item number as an index into the data arrays. This data is then
     * displayed on the layout views using the references created in the constructor method of the
     * ViewHolder class:
     */

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.itemUsename.setText(userName.get(i));
        viewHolder.itemIdea.setText(idea.get(i));
    }

    /**
     * the getItem() method
     * which, in this case, simply returns the number of items in the titles array:
     */
    @Override
    public int getItemCount() {
        return userName.size();
    }

}
