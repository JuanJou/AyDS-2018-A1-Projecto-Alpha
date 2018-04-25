package ayds.dictionary.alpha.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ayds.dictionary.alpha.R;
import ayds.dictionary.alpha.Controller.ControllerModule;
import ayds.dictionary.alpha.Controller.SearchItemController;
import ayds.dictionary.alpha.Model.TermModel;
import ayds.dictionary.alpha.Model.TermModelListener;
import ayds.dictionary.alpha.Model.TermModelModule;

public class SearchItemViewImpl extends AppCompatActivity implements SearchItemView {

    private SearchItemController searchItemController;
    private TermModel termModel;

    private EditText searchField;
    private Button goButton;
    private TextView meaningPane;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchItemViewModule.getInstance().setContext(this.getApplicationContext());
        termModel = TermModelModule.getInstance().getTermModel();
        searchItemController = ControllerModule.getInstance().getSearchItemController();

        setContentView(R.layout.activity_main);

        searchField = findViewById(R.id.textField1);
        goButton = findViewById(R.id.goButton);
        meaningPane = findViewById(R.id.textPane1);

        initListiners();
    }

    private void initListiners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                        searchItemController.onEventSearch(searchField.getText().toString());
                    }
                }).start();
            }
        });
        termModel.setListener(new TermModelListener() {
            @Override
            public void didUpdateTerm(String definition) {
                updateTextField(definition);
            }
        });
    }

    private void updateTextField(final String definition) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                meaningPane.setText(Html.fromHtml(TextHtmlImpl.textToHtml(definition, searchField.getText().toString())));
            }
        });

    }
}
