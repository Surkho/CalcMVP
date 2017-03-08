package juanjo.calcmvp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import juanjo.calcmvp.R;
import juanjo.calcmvp.interfaces.MainPresenter;
import juanjo.calcmvp.interfaces.MainView;
import juanjo.calcmvp.presenters.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText number_one,number_two;
    private TextView result;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    private void setUI(){
        number_one = (EditText) findViewById(R.id.number_one);
        number_two = (EditText) findViewById(R.id.number_two);
        result = (TextView) findViewById(R.id.result);
        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void showResult(String res) {
        result.setText(res);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
    }
    public void onClick(View v){
        //Llamaremos metodo del presentador que comunica con el interactor(logica)
        presenter.operation(v.getId(),number_one.getText().toString(),number_two.getText().toString());
    }
}
