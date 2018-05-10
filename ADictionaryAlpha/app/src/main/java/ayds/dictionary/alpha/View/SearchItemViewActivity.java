package ayds.dictionary.alpha.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ayds.dictionary.alpha.Model.ErrorHandler;
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

        searchProgressBar = findViewById(R.id.progressBar1);
        searchProgressBar.setVisibility(View.INVISIBLE);

    }

    private void initListiners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchProgressBar.setVisibility(View.VISIBLE);
                meaningPane.setText("");
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

        termModel.setErrorHandler(new ErrorHandler() {

            @Override
            public void inputNotWellFormed() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Expresion mal formada",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void noConnection() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isFinishing()){
                            new AlertDialog.Builder(getApplicationContext())
                            .setTitle("Error")
                            .setMessage("Sin conexion")
                            .setCancelable(false)
                            .setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                        }
                    }
                });
            }

            @Override
            public void noResult(){
                AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("No hay resultado");
                builder.setTitle("Error");
                builder.setNeutralButton("Aceptar",null);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    private void updateTextField(final String definition) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchProgressBar.setVisibility(View.INVISIBLE);
                if(definition!=null)
                    meaningPane.setText(Html.fromHtml(TextHtmlImpl.textToHtml(definition, searchField.getText().toString())));
            }
        });
    }
}