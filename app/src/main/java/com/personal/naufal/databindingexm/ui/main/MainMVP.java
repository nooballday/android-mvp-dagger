package com.personal.naufal.databindingexm.ui.main;

import java.util.List;

/**
 * Created by Naufal on 03/02/2018.
 */

public interface MainMVP {

    interface View {
        void displayData(List<UserModel> users);

        void showSpinner();

        void hideSpinner();
    }

    interface Presenter {
        void fetchData(String data);
        void onDestroy();
    }

}
