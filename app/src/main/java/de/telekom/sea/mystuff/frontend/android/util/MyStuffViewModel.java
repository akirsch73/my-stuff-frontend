package de.telekom.sea.mystuff.frontend.android.util;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import de.telekom.sea.mystuff.frontend.android.MyStuffApplication;
import de.telekom.sea.mystuff.frontend.android.MyStuffContext;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import lombok.Getter;
import timber.log.Timber;

public class MyStuffViewModel extends ViewModel {

    //public List<Item> itemList = new ArrayList<Item>();

    @Getter
    private MyStuffContext myStuffContext;

    public MyStuffViewModel() {
        super();
    }

    public void initContext(MyStuffContext ctx) {
        this.myStuffContext = ctx;
    }

    public void initWithApplication(Application application) {
        initContext(((MyStuffApplication) application).getMyStuffContext());
    }

}