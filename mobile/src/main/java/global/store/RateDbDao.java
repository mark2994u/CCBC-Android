package global.store;

import global.AquilaRate;

/**
 * Created by Furszy on 3/3/18.
 */

public interface RateDbDao<T> extends AbstractDbDao<T>{

    AquilaRate getRate(String coin);


    void insertOrUpdateIfExist(AquilaRate aquilaRate);

}
