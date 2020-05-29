package de.telekom.sea.mystuff.frontend.android.ui;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.telekom.sea.mystuff.frontend.android.api.ApiResponse;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import de.telekom.sea.mystuff.frontend.android.util.MyStuffViewModel;

public class ItemListViewModel extends MyStuffViewModel{

    public LiveData<ApiResponse<List<Item>>> getMyItems() {
        /** TODO
         * Modify to get only my rides
         * e.g. ...getById(Long id)...
         */
       // return itemRepo.getAll();
        return getMyStuffContext().getItemRepo().getAll();
    }
}

