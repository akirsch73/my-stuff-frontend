package de.telekom.sea.mystuff.frontend.android;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.lifecycle.ViewModelProvider;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import java.util.ArrayList;

        import de.telekom.sea.mystuff.frontend.android.ui.ItemListRecyclerViewAdapter;
        import de.telekom.sea.mystuff.frontend.android.ui.ItemListViewModel;
;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemList;
    private ItemListViewModel viewModel;
    private ItemListRecyclerViewAdapter itemListAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = findViewById(R.id.rv_items);
        //  --> check the dogsExample:  --> Mayo ==> refreshLayout = findViewById(R.id.refreshRideListLayout);
        viewModel = new ViewModelProvider(this).get(ItemListViewModel.class);
        viewModel.initWithApplication(getApplication());
        itemListAdapter = new ItemListRecyclerViewAdapter(new ArrayList<>());
        itemList.setLayoutManager(new LinearLayoutManager(this));
        itemList.setAdapter(itemListAdapter);
        observeItemsListViewModel();
    }


    private void observeItemsListViewModel() {
        viewModel.getMyItems().observe(this, listApiResponse -> {
            if (listApiResponse.isSuccessful()){
                itemListAdapter.updateList(listApiResponse.body);
            } else {
                ((MyStuffApplication) getApplication()).getMyStuffContext().sendInfoMessage(listApiResponse.errorMessage);
            }
        });
    }
}
