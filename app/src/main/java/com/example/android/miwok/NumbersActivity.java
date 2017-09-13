package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class NumbersActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {


    private MediaPlayer mediaPlayer;
    private TextToSpeech mtts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Words> words = new ArrayList<Words>();
        //(first the defaultWord, then the frisian word)

        words.add(new Words(getString(R.string.numberOne), "Ien", R.drawable.number_one));
        words.add(new Words(getString(R.string.numberTwo), "Twa", R.drawable.number_two));
        words.add(new Words(getString(R.string.numberThree), "Trije", R.drawable.number_three));
        words.add(new Words(getString(R.string.numberFour), "Fjouwer", R.drawable.number_four));
        words.add(new Words(getString(R.string.numberFive), "Fiif", R.drawable.number_five));
        words.add(new Words(getString(R.string.numberSix), "Seis", R.drawable.number_six));
        words.add(new Words(getString(R.string.numberSeven), "Sân", R.drawable.number_seven));
        words.add(new Words(getString(R.string.numberEight), "Acht", R.drawable.number_eight));
        words.add(new Words(getString(R.string.numberNine), "Njoggen", R.drawable.number_nine));
        words.add(new Words(getString(R.string.numberTen), "Tsien", R.drawable.number_ten));

  /*
        words.add(new Words("one","Aas"));
        words.add(new Words("two","Twa"));
        words.add(new Words("three","Tredde"));
        words.add(new Words("four","Fjouwer"));
        words.add(new Words("five","Fiif"));
        words.add(new Words("six","Seis"));
        words.add(new Words("seven","Souje"));
        words.add(new Words("eight","Acht"));
        words.add(new Words("nine","Njuugen"));
        words.add(new Words("ten","Tsien"));
*/

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single defaultWord.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        //Arrayadapter has a method getView() which we have to specify to our needs


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each defaultWord in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        mtts = new TextToSpeech(NumbersActivity.this,NumbersActivity.this);
        mtts.setLanguage(Locale.GERMAN.getDefault());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                speaks(words.get(position).getTranslatedWord());
            }
        });

    }

    @Override
    public void onInit(int i) {

    }

    private void speaks(String eingabe){
        mtts.speak(eingabe,TextToSpeech.QUEUE_FLUSH,null);
    }
}
