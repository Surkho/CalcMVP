package juanjo.calcmvp.interfaces;

/**
 * Created by juanj on 07/03/2017.
 */

public interface MainPresenter {
    void operation(int view_operator,String number_one,String number_two);
    void showErrorPresenter(String error);
    void setResult(String result);
}
