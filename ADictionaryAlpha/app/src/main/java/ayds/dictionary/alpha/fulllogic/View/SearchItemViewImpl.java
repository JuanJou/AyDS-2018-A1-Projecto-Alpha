package ayds.dictionary.alpha.fulllogic.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ayds.dictionary.alpha.R;
import ayds.dictionary.alpha.fulllogic.Controller.ControllerModule;
import ayds.dictionary.alpha.fulllogic.Controller.SearchItemController;
import ayds.dictionary.alpha.fulllogic.Model.Term;
import ayds.dictionary.alpha.fulllogic.Model.TermModel;
import ayds.dictionary.alpha.fulllogic.Model.TermModelListener;
import ayds.dictionary.alpha.fulllogic.Model.TermModelModule;

public class SearchItemViewImpl extends AppCompatActivity implements SearchItemView {

    private SearchItemController searchItemController;
    private TermModel termModel;

    private EditText textField1;
    private Button goButton;
    private TextView textPane1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchItemController = ControllerModule.getInstance(this.getApplicationContext()).getSearchItemController();

        termModel = TermModelModule.getInstance(this.getApplicationContext()).getTermModel();

        setContentView(R.layout.activity_main);

        textField1 = findViewById(R.id.textField1);
        goButton = findViewById(R.id.goButton);
        textPane1 = findViewById(R.id.textPane1);

        iniciarListiners();
    }

    private void iniciarListiners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                        searchItemController.onEventSearch(textField1.getText().toString());
                    }
                }).start();
            }
        });
        termModel.setListener(new TermModelListener() {
            @Override
            public void didUpdateTerm(Term term) {
                actualizarTextField(term);
            }
        });
    }

    private void actualizarTextField(Term term) {

        final Term term2 = term;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textPane1.setText(Html.fromHtml(textToHtml(term2.getDefinicion(), term2.getNombre())));
            }
        });

    }

    private static String textToHtml(String text, String term) {

        StringBuilder builder = new StringBuilder();

        String textWithBold = text.replaceAll("(?i)" + term, "<b>" + term + "</b>");

        builder.append(textWithBold);

        return builder.toString();
    }
}
