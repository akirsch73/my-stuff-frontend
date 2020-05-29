package de.telekom.sea.mystuff.frontend.android;

import android.widget.Toast;
import de.telekom.sea.mystuff.frontend.android.api.ApiFactory;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import de.telekom.sea.mystuff.frontend.android.api.ItemApi;
import de.telekom.sea.mystuff.frontend.android.repo.ItemRepo;
import lombok.Getter;

public class MyStuffContext {
    @Getter
    private MyStuffApplication app;
    @Getter
    private ApiFactory apiFactory;
    @Getter
    private ItemRepo itemRepo;

    public MyStuffContext initWithApplication(MyStuffApplication app){
        this.app = app;
        this.apiFactory = new ApiFactory(
                BuildConfig.APIFACTORY_HOSTNAME,
                BuildConfig.APIFACTORY_PROTOCOL,
                BuildConfig.APIFACTORY_PORT
        );
        this.itemRepo = new ItemRepo(this.apiFactory.createApi(ItemApi.class));
        return this;
    }

    public String getString(int resourceId) {
        return app.getString(resourceId);
    }

    public void sendInfoMessage(int resId) {
        Toast.makeText(this.app.getApplicationContext(), getString(resId), Toast.LENGTH_LONG).show();
    }

    public void sendInfoMessage(String msg) {
        Toast.makeText(this.app.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

}


