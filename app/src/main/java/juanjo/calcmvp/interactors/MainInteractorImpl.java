package juanjo.calcmvp.interactors;

import juanjo.calcmvp.R;
import juanjo.calcmvp.interfaces.MainInteractor;
import juanjo.calcmvp.interfaces.MainPresenter;

/**
 * Created by juanj on 07/03/2017.
 */

public class MainInteractorImpl implements MainInteractor {
    private MainPresenter presenter;
    private double result;
    public MainInteractorImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void operation(int operator,String number_one,String number_two) {
        if(number_one.equals("") && number_two.equals("")){
            presenter.showErrorPresenter("Los campos estan vacios.");
        }else{
            try{
                switch (operator){
                    case R.id.suma:
                        result = Double.valueOf(number_one) + Double.valueOf(number_two);
                        break;
                    case R.id.resta:
                        result = Double.valueOf(number_one) - Double.valueOf(number_two);
                        break;
                    case R.id.multiplicacion:
                        result = Double.valueOf(number_one) * Double.valueOf(number_two);
                        break;
                    case R.id.divicion:
                        result = Double.valueOf(number_one) / Double.valueOf(number_two);
                        break;
                }


                presenter.setResult(String.valueOf(result));
            }catch (Exception e){
                presenter.showErrorPresenter(e.getMessage());
            }


        }
    }
}
