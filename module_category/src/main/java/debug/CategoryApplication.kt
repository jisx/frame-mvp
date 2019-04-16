package debug

import com.alibaba.android.arouter.launcher.ARouter
import com.frame.mvp.category.BuildConfig
import com.frame.mvp.common.base.BaseApplication

/**
 *
 * 类说明
 *
 * @author 张华洋 2017/2/15 20:09
 * @version V1.2.0
 * @name HomeApplication
 */
class CategoryApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }
}
