package ayds.dictionary.alpha.fulllogic.View;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ayds.dictionary.alpha.R;
import ayds.dictionary.alpha.fulllogic.Controller.SearchItemController;
import ayds.dictionary.alpha.fulllogic.Model.Term;
import ayds.dictionary.alpha.fulllogic.Model.TermModel;

public class SearchItemViewImpl extends AppCompatActivity implements SearchItemView {

    private SearchItemController searchItemController;
    private TermModel termModel;

    private EditText textField1;
    private Button goButton;
    private TextView textPane1;

    public SearchItemViewImpl(SearchItemController searchItemController, TermModel termModel){

        this.termModel = termModel;
        this.searchItemController = searchItemController;

        setContentView(R.layout.activity_main);

        textField1 = findViewById(R.id.textField1);
        goButton = findViewById(R.id.goButton);
        textPane1 = findViewById(R.id.textPane1);

        iniciarListiners();

    }

    private void iniciarListiners(){
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Paso datos al controlador
            }
        });
        //Implementacion de listener del modelo
    }

    private void actualizarTextField(){

        Term term = termModel.getTerm();
        textPane1.setText(term.getDefinicion());
    }

}
