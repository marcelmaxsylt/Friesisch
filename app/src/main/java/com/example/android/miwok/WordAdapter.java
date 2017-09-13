package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Marcel Laptop on 12.09.2017.
 */

public class WordAdapter extends ArrayAdapter<Words> {

    /*
    Arrayadapter has a method getView() which we have to specify to our needs
        STRG + O or Code>Override Methods
     Create An Constructor with Activity, ArrayList<Words>
    first get a list item view we can use (use existing one or a new one(if bracket))
    second get the wordobject on a given position (the index)
    third define the views in the list item layout, setting data onto them
     */
    private int mColorResourceId;
    private int mMediaResourceID;
    private MediaPlayer mediaPlayer;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of words objects to display in a list
     */

    public WordAdapter(Activity context, ArrayList<Words> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    public WordAdapter(Activity context, ArrayList<Words> words, int colorResourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceID;
    }

    public WordAdapter(Activity context, ArrayList<Words> words, int colorResourceID, int mediaREsourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceID;
        this.mMediaResourceID = mediaREsourceID;
    }


    ////////////////////////////////////////////////////1
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
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Words} object located at this position in the list
        Words currentWords = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID tv_translatedWord
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.tv_translatedWord);
        listItemView.findViewById(R.id.tv_translatedWord);
        // Get the translated Word from the current Words object and
        // set this text on the name TextView
        nameTextView.setText(currentWords.getTranslatedWord());

        // Find the TextView in the list_item.xml layout with the ID tv_defaultWord
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.tv_defaultWord);
        // Get the default Word from the current Words object and
        // set this text on the defaultWord TextView
        numberTextView.setText(currentWords.getDefaultWord());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Words object and
        // set the image to iconView
        if (currentWords.hasImage() == true) {
            //sets image if theres an image
            iconView.setImageResource(currentWords.getImageRessourceID());

        } else {
            // hides the view when theres no image
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.lL_changeColor);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Media




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
