package juanjo.calcmvp.presenters;

import juanjo.calcmvp.interactors.MainInteractorImpl;
import juanjo.calcmvp.interfaces.MainInteractor;
import juanjo.calcmvp.interfaces.MainPresenter;
import juanjo.calcmvp.interfaces.MainView;

/**
 * Created by juanj on 07/03/2017.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        interactor = new MainInteractorImpl(this);
    }

    @Override

    public void operation(int operator,String number_one, String number_two) {
        //Llamara al interactor que hara la operacion
        if(view != null){
            interactor.operation(operator,number_one,number_two);
        }
    }

    @Override
    public void showErrorPresenter(String error) {
        if(view != null){
            view.showError(error);
        }
    }

    @Override
    public void setResult(String result) {
        if(view != null){
            view.showResult(result);
        }
    }
}
