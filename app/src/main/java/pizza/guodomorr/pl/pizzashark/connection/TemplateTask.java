package pizza.guodomorr.pl.pizzashark.connection;

import android.content.Context;

import retrofit.RestAdapter;

/**
 * Created by lukasz on 10.10.15.
 */
public abstract class TemplateTask<POJO> {
    public abstract void onDataReceived(POJO pojo);

    public abstract void doOnStart();

    public abstract void doOnEnd();

    public void execute(Context context, RestAdapter adapter, Class<POJO> service) {

    }
}
