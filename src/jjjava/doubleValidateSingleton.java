package jjjava;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 11:08 2019/11/4
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public   class doubleValidateSingleton {
    //双重校验锁
    private volatile static doubleValidateSingleton instance;
    public static doubleValidateSingleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new doubleValidateSingleton();
                }
            }
        }
        return instance;
    }

    //懒加载  Initialization on Demand Holder（IODH）。
    static class doubleValidateSingletonHolder {
        static doubleValidateSingleton instance = new jjjava.doubleValidateSingleton();
    }

    public  static doubleValidateSingleton lazyLoadSingleton() {
        return doubleValidateSingletonHolder.instance;
    }

    public static void main(String[] args) {

    }
}
