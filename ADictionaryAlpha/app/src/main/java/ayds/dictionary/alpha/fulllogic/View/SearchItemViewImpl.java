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

public class SearchItemViewImpl extends AppCompatActivity implements SearchItemView {

    private SearchItemController searchItemController;
    private TermModel termModel;

    private EditText textField1;
    private Button goButton;
    private TextView textPane1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ControllerModule.getInstance().startApplication(this.getApplicationContext(),this);

        setContentView(R.layout.activity_main);

        textField1 = findViewById(R.id.textField1);
        goButton = findViewById(R.id.goButton);
        textPane1 = findViewById(R.id.textPane1);

        iniciarListiners();
    }

    public void setController(SearchItemController searchItemController){
        this.searchItemController = searchItemController;
    }

    public void setModel(TermModel termModel){
        this.termModel = termModel;
    }

    private void iniciarListiners(){
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                searchItemController.onEventSearch(textField1.getText().toString());
            }
        });
        termModel.setListener(new TermModelListener() {
            @Override
            public void didUpdateTerm() {
                actualizarTextField();
            }
        });
    }

    private void actualizarTextField(){

        Term term = termModel.getTerm();
        textPane1.setText(Html.fromHtml(textToHtml(term.getDefinicion(),term.getNombre())));
    }

    private static String textToHtml(String text, String term) {

        StringBuilder builder = new StringBuilder();

        String textWithBold = text.replaceAll("(?i)" + term, "<b>" + term + "</b>");

        builder.append(textWithBold);

        return builder.toString();
    }
}
