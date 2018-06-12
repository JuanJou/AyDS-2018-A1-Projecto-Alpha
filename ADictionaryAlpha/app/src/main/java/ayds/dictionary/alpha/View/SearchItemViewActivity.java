package ayds.dictionary.alpha.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ayds.dictionary.alpha.Model.Exceptions.ErrorHandlerListener;
import ayds.dictionary.alpha.Model.Exceptions.ErrorHandlerModule;
import ayds.dictionary.alpha.Model.Source;
import ayds.dictionary.alpha.Model.Term;
import ayds.dictionary.alpha.R;
import ayds.dictionary.alpha.Controller.ControllerModule;
import ayds.dictionary.alpha.Controller.SearchItemController;
import ayds.dictionary.alpha.Model.TermModel;
import ayds.dictionary.alpha.Model.TermModelListener;
import ayds.dictionary.alpha.Model.TermModelModule;

public class SearchItemViewActivity extends AppCompatActivity implements SearchItemView {

    private SearchItemController searchItemController;
    private TermModel termModel;

    private EditText searchField;
    private Button goButton;
    private TextView meaningPane;
    private ProgressBar searchProgressBar;
    private TextView sourceField;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchItemViewModule.getInstance().setContext(this.getApplicationContext());
        termModel = TermModelModule.getInstance().getTermModel();
        searchItemController = ControllerModule.getInstance().getSearchItemController();

        initGUI();

        initListiners();
    }

    private void initGUI(){
        setContentView(R.layout.activity_main);

        searchField = findViewById(R.id.textField1);
        goButton = findViewById(R.id.goButton);
        meaningPane = findViewById(R.id.textPane1);
        sourceField=findViewById(R.id.source);
        listView = findViewById(R.id.listView);

        searchProgressBar = findViewById(R.id.progressBar1);
        searchProgressBar.setVisibility(View.INVISIBLE);

    }

    private void initListiners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                searchProgressBar.setVisibility(View.VISIBLE);
                meaningPane.setText("");
                sourceField.setText("");
                new Thread(new Runnable() {
                    public void run() {
                        searchItemController.onEventSearch(searchField.getText().toString());
                    }
                }).start();
            }
        });

        termModel.setListener(new TermModelListener() {
            @Override
            public void didUpdateTerm(List<Term> listTerm) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchProgressBar.setVisibility(View.INVISIBLE);
                    }
                });
                updateTextField(listTerm.get(0).getDefinition());
                updateSource(listTerm.get(0).getSource());
            }
        });

        ErrorHandlerModule.getInstance().getErrorHandler().setErrorHandlerListener(new ErrorHandlerListener() {

            @Override
            public void catchException(final String exceptionMessage) {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),exceptionMessage,Toast.LENGTH_LONG).show();
                        searchProgressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }

        });
    }

    private void updateTextField(final String definition) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(definition!=null)
                    meaningPane.setText(Html.fromHtml(TextHtmlImpl.textToHtml(definition, searchField.getText().toString())));
            }
        });
    }

    private void updateSource(final String source){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                    sourceField.setText("Source:"+source);
            }
        });
    }
}