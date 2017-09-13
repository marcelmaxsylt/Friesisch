package com.example.android.miwok;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class PhrasesActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech mtts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Words> words = new ArrayList<Words>();
        //(first the defaultWord, then the frisian word)

        words.add(new Words(getString(R.string.phraseWhereAreYouGoing), "Wêr binne jo?"));
        words.add(new Words(getString(R.string.phraseWhatIsYourName), "Wat is dyn namme?"));
        words.add(new Words(getString(R.string.phraseMyNameIs), "Myn namme is..."));
        words.add(new Words(getString(R.string.phraseHowAreYouFeeling), "Hoe binne jo?"));
        words.add(new Words(getString(R.string.phraseImGood), "Ik bin goed."));
        words.add(new Words(getString(R.string.phraseAreYouComing), "Binne jo?"));
        words.add(new Words(getString(R.string.phraseYesImComing), "Ja, ik kom."));
        words.add(new Words(getString(R.string.phraseImComing), "Ik kom."));
        words.add(new Words(getString(R.string.phraseLetsGo), "Litte wy gean."));
        words.add(new Words(getString(R.string.phraseComeHere), "Kom hjir."));

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
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        //Arrayadapter has a method getView() which we have to specify to our needs


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each defaultWord in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        mtts = new TextToSpeech(PhrasesActivity.this,PhrasesActivity.this);
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
