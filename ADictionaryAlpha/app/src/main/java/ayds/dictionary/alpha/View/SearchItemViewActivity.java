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

import java.util.ArrayList;
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
    private ArrayList<TermView> arrayListTerm;
    private AdapterTerm adapterTerm;

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
        listView = findViewById(R.id.listView);

        arrayListTerm = new ArrayList<>();
        adapterTerm = new AdapterTerm(this,arrayListTerm);

        listView.setAdapter(adapterTerm);

        searchProgressBar = findViewById(R.id.progressBar1);
        searchProgressBar.setVisibility(View.INVISIBLE);

    }

    private void initListiners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListTerm.clear();
                searchProgressBar.setVisibility(View.VISIBLE);
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

                for(Term term : listTerm){
                    arrayListTerm.add(new TermView(term.getSource().name(),term.getDefinition()));
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapterTerm.notifyDataSetChanged();
                    }
                });
            }
        });

        ErrorHandlerModule.getInstance().getErrorHandler().setErrorHandlerListener(new ErrorHandlerListener() {

            @Override
            public void catchException(final String exceptionSource,final String exceptionMessage) {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {

                        arrayListTerm.add(new TermView(exceptionSource,exceptionMessage));
                        searchProgressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }

        });
    }

}