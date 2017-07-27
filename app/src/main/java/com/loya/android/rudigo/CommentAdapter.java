package com.loya.android.rudigo;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
* {@link CommentAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */
public class CommentAdapter extends ArrayAdapter<Comment> {
    private ImageButton downvote;
    private ImageButton upvote;
    private ImageButton favorite;
    private TextView textDownvote;
    private TextView textUpvote;
    private TextView textFavorite;
    private TextView textTime;

    private boolean downVoteliked = false;
    private boolean upVoteliked = false;
    private boolean favoriteliked = false;
    int dVote, uVote, fav;

    private static final String LOG_TAG = CommentAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param comments A List of Comment objects to display in a list
     */
    public CommentAdapter(Activity context, ArrayList<Comment> comments) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the CommentAdapter is populating a single TextView.
        // Because this is a custom adapter for five TextViews, and three ImageVuttons, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, comments);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list, parent, false);
        }

        // Get the {@link Comment} object located at this position in the list
        Comment currentComment = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView commentTextView = (TextView) listItemView.findViewById(R.id.custom_comment);
        // Get the text from the current Comment object and
        // set this text on the comment TextView
        commentTextView.setText(currentComment.getComment());

        textTime = (TextView) listItemView.findViewById(R.id.custom_time);
        // Get the current time from the current Comment object and
        // set this text on the time TextView
        textTime.setText(currentComment.getCurrentTime());

        downvote = (ImageButton) listItemView.findViewById(R.id.custom_downvote);
        upvote = (ImageButton) listItemView.findViewById(R.id.custom_upvote);
        favorite = (ImageButton) listItemView.findViewById(R.id.custom_favorite);

        textDownvote = (TextView) listItemView.findViewById(R.id.text_downvote);
        textUpvote = (TextView) listItemView.findViewById(R.id.text_upvote);
        textFavorite = (TextView) listItemView.findViewById(R.id.text_favorite);
        textFavorite = (TextView) listItemView.findViewById(R.id.text_favorite);





        downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downVoteliked == false) {
                    dVote += 1;
                    textDownvote.setText(String.valueOf(dVote));
                    downVoteliked = true;
                } else {
                    dVote -= 1;
                    textDownvote.setText(String.valueOf(dVote));
                    downVoteliked = false;
                }
            }
        });


        upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (upVoteliked == false) {
                    uVote += 1;
                    textUpvote.setText(String.valueOf(uVote));
                    upVoteliked = true;
                } else {
                    uVote -= 1;
                    textUpvote.setText(String.valueOf(uVote));
                    upVoteliked = false;
                }
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favoriteliked == false) {
                    fav += 1;
                    textFavorite.setText(String.valueOf(fav));
                    favoriteliked = true;
                } else {
                    fav -= 1;
                    textFavorite.setText(String.valueOf(fav));
                    favoriteliked = false;
                }
            }
        });


        return listItemView;
    }

}
