package de.telekom.sea.mystuff.frontend.android.api;
import java.util.List;
import androidx.lifecycle.LiveData;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface ItemApi {
    @GET("/api/v1/items")
    public LiveData<ApiResponse<List<Item>>>getAll();
}